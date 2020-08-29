package ebe.API;

import ebe.DBClasses.Vacancy;
import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.VacancyQueries;
import ebe.StorageAdapter.AzureBlobAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class AzureStorageAPI {

    @Autowired
    private EmployerQueries EmployerQrys;

    @Autowired
    private VacancyQueries VacancyQrys;

    @Autowired
    private EventQueries EventQrys;

    @Autowired
    private AzureBlobAdapter azureBlobAdapter;

    @GetMapping("/container")
    public ResponseEntity createContainer(@RequestParam String containerName){
        boolean created = azureBlobAdapter.createContainer(containerName);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity upload(@RequestParam("name") String containerName,
                                 @RequestParam("file") MultipartFile file,
                                 @RequestParam("ID") String ID){

        URI url = azureBlobAdapter.upload(containerName, file);
        if (containerName.equals("employer")){
            EmployerQrys.insertDocument(Integer.valueOf(ID), url.toString());
        }
        if (containerName.equals("employerlogo")){
            EmployerQrys.insertLogoLink(Integer.valueOf(ID), url.toString());
        }
        if (containerName.equals("vacancy")){
            VacancyQrys.insertDocument(Integer.valueOf(ID), url.toString());
        }
        if (containerName.equals("event")){
            EventQrys.insertDocument(Integer.valueOf(ID), url.toString());
        }

        return ResponseEntity.ok(url);
    }

    @GetMapping("/blobs")
    public ResponseEntity getAllBlobs(@RequestParam String containerName){
        List<URI> uris = azureBlobAdapter.listBlobs(containerName);
        return ResponseEntity.ok(uris);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String containerName, @RequestParam String blobName){
        azureBlobAdapter.deleteBlob(containerName, blobName);
        return ResponseEntity.ok().build();
    }

}

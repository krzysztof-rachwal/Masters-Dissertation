package ebe.DBMethods;

import ebe.DBClasses.Event;
import ebe.DBClasses.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventQueries extends DBQueries {

    private Connection connection;
    private Statement statement;

    @Autowired
    public EventQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Events
    public List<Event> getAllEvents() throws DataAccessException {
        String getQuery = "SELECT * FROM Event";
        List<Event> list = new ArrayList<Event>();
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                event = new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallangesGenderStereotypes"));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    // 2. Get Event by Id
    public Event getEventDetailsById(int eventId) throws DataAccessException {
    String getQuery = String.format("SELECT * FROM Event WHERE EventID = \"%s\" LIMIT 1", eventId);
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                event = new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallangesGenderStereotypes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return event;
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Event
    public int createNewEvent(String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                              String NumberOfAttendees, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                              Boolean ChallangesGenderStereoTypes) throws DataAccessException {

        String insertSql = "INSERT TO Event Event(Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser," +
                "                                 NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage," +
                "                                 ChallangesGenderStereoTypes)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,
                ChallangesGenderStereoTypes);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Events by Id

    public Integer updateEvent(int EventID, String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                               String NumberOfAttendees, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                               Boolean ChallangesGenderStereoTypes) throws DataAccessException {

        String updateSql = "UPDATE Event SET Name =?, TypeOfEvent =?, Date= ?, isPublic=?, isCancelled=?," +
                "PostCode=?, NameOfAdviser=?, NumberOfAttendees=?, PromotesApprenticeships=?, PromotesWelshLanguage=?" +
                "ChallangesGenderStereoTypes=? WHERE EventlID =?";

        return jdbcTemplate().update(updateSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,
                ChallangesGenderStereoTypes, EventID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Event by ID

    public Integer deleteEvent(int eventId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Event WHERE EventID = '%s'",eventId);
        return jdbcTemplate().update(deleteSql);
    }

    ///////////////////////////////////// SORT BY METHODS ///////////////////////////////////////////////

    //12. Get Events order by name
    public List<Integer> sortByEventByName(String type) throws DataAccessException {
        String getQuery = String.format("SELECT * FROM Event ORDER BY EventName %s;", type);
        List<Integer> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                list.add(rs.getInt("EventID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    //13. Get Events order by date
    public List<Integer> sortByEventByDate(String type) throws DataAccessException {
        String getQuery = String.format("SELECT * FROM Event ORDER BY EventDateAndTime %s;", type);
        List<Integer> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                list.add(rs.getInt("EventID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    ///////////////////////////////////// FILTER METHODS ///////////////////////////////////////////////

    //14. Filter Events
    public List<Integer> filterEvents(List<Integer> typeOfEventList, List<String> nameOfAdviserList, int promotesApprenticeships, int promotesWelshLanguage, int challengesGenderStereotypes) {
        List<Integer> ids = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        ResultSet rs = null;

        String SQL = "SELECT distinct EventID FROM Event WHERE EventID IN ";
        String SQL2 = "(SELECT EventID FROM Event ";
        if (!typeOfEventList.isEmpty()){
            SQL2 = SQL2.concat(" WHERE ");
            for (int i = 0; i < typeOfEventList.size(); ++i){
                SQL2 = SQL2.concat(" Event.TypeOfEventID = " + typeOfEventList.get(i));
                if (i != typeOfEventList.size() - 1){
                    SQL2 = SQL2.concat(" OR ");
                }
            }
        }

        SQL2 = SQL2.concat(") AND EventID IN ");

        String SQL3 = "(SELECT EventID FROM Event ";
        if (!nameOfAdviserList.isEmpty()){
            SQL3 = SQL3.concat(" WHERE ");
            for (int i = 0; i < nameOfAdviserList.size(); ++i){
                SQL3 = SQL3.concat(" Event.NameOfAdviser = " + "\"" + nameOfAdviserList.get(i) + "\"" );
                if (i != nameOfAdviserList.size() - 1){
                    SQL3 = SQL3.concat(" OR ");
                }
            }
        }

        SQL3 = SQL3.concat(")");

        String SQL4 = "";

        List<Integer> booleanFilters = Arrays.asList(promotesApprenticeships, promotesWelshLanguage, challengesGenderStereotypes);

        List<String> SQLStatements = Arrays.asList(" PromotesApprenticeships = "," PromotesWelshLanguage = "," ChallengesGenderStereotypes = ");

        if (booleanFilters.contains(1)){
            SQL4 = SQL4.concat(" AND (");
            for (int i = 0; i < booleanFilters.size(); ++i){
                if (booleanFilters.get(i) == 1){
                    SQL4 = SQL4.concat(SQLStatements.get(i) + booleanFilters.get(i));
                    if (i+1 < booleanFilters.size() || i+2 < booleanFilters.size()){
                        if (booleanFilters.get(i+1) == 1 ){
                            SQL4 = SQL4.concat(" OR ");
                        } else if (i+2 < booleanFilters.size()){
                            if (booleanFilters.get(i+2) == 1 ) {
                                SQL4 = SQL4.concat(" OR ");
                            }
                        }
                    }
                }
            }
            SQL4 = SQL4.concat(");");
        }
        String finalSQL = SQL+SQL2+SQL3+SQL4;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(finalSQL);
            while (rs.next()) {
                ids.add(rs.getInt("EventID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
        }
        return ids;
    }
}

package domain.RegisterLogin;

import java.util.HashMap;

public class DBUtil {
    private static final DBUtil instance = new DBUtil();
    private final HashMap<String, UserBean> users = new HashMap<>();
    private DBUtil() {
    }

    public static DBUtil getInstance(){
        return instance;
    }

    public UserBean getUser(String username){
        return users.get(username);
    }

    public boolean insertUser(UserBean user){
        if(user == null)return false;
        if(users.containsKey(user.getUsername()))return false;
        users.put(user.getUsername(), user);
        return true;
    }
    public boolean verifyUser(String username, String password) {
        if(users.isEmpty())return false;
        UserBean user = users.get(username);
        if(!users.containsKey(user.getUsername()))return false;
        return password.equals(user.getPassword());
    }
}


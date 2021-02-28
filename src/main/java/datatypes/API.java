package datatypes;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class API {
        Activity activity;
        OnlineStatus status;
        String token;

        public API(String _token, Activity _activity, OnlineStatus _status) {
            token = _token;
            activity = _activity;
            status = _status;
        }

        public String getToken() {
            return token;
        }

        public Activity getActivity() {
            return activity;
        }

        public OnlineStatus getOnlineStatus() {
            return status;
        }
}

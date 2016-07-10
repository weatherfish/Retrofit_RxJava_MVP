package com.example.y.mvp.mvp.Bean;

import com.example.y.mvp.JokeTextInfo;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
@SuppressWarnings("ALL")
public class JokeTextBean {

    private String showapi_res_code;
    private String showapi_res_error;
    private JokeText showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public JokeText getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(JokeText showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public String getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(String showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }


    public class JokeText {

        private String allNum;
        private String allPages;
        private List<JokeTextInfo> contentlist;

        public List<JokeTextInfo> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<JokeTextInfo> contentlist) {
            this.contentlist = contentlist;
        }

        public String getAllPages() {
            return allPages;
        }

        public void setAllPages(String allPages) {
            this.allPages = allPages;
        }

        public String getAllNum() {
            return allNum;
        }

        public void setAllNum(String allNum) {
            this.allNum = allNum;
        }


    }


}

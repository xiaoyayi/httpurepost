package com.example.seek;

import java.util.List;

/**
 * Created by 小亚 on 2017/7/19.
 */

public class BweiBean {

    /**
     * ret_code : 200
     * ret_msg : ok
     * list : [{"date":"111","id":1,"pic":"http://p1.pstatp.com/large/22c90001cf8b5388ce33","title":" \n他\u201c秘书圈\u201d的人数规模，赶上了周永康","type":1},{"date":"333","id":3,"pic":"http://p1.pstatp.com/list/190x124/e580016ab3624f1ed33","title":"家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱","type":1},{"date":"444","id":4,"pic":"http://p1.pstatp.com/origin/26ec0004cc0249b49e7c","title":"世界上\u201c最恐怖\u201d的景点大盘点，中国竟然排在第一！","type":1},{"date":"6666","id":6,"pic":"http://p3.pstatp.com/list/190x124/216d001357929b02f476","title":" \n张爱朋首回应白百何绯闻事件，短短二句话，白百何后悔看错了吧！","type":1},{"date":"8888","id":8,"pic":"http://p1.pstatp.com/list/190x124/191a00048757f6714455","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"99","id":9,"pic":"http://p3.pstatp.com/list/190x124/22c700036549c9b5ff07","title":"中国第一黑老大东北王乔四爷 最终也逃不过法网恢恢","type":1},{"date":"111","id":10,"pic":"http://p3.pstatp.com/list/190x124/22c6000628d79850e6d7","title":"号称中国关系最硬的人，奶奶是慈禧，大伯是光绪，哥哥是宣统！","type":1},{"date":"222","id":11,"pic":"http://p3.pstatp.com/list/190x124/22ca00011911b0a8061c","title":" \n\u201c二婚女和剩女，我该娶哪个啊？求救！\u201d","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    public List<ListBean> list;
    public static class ListBean {
        /**
         * date : 111
         * id : 1
         * pic : http://p1.pstatp.com/large/22c90001cf8b5388ce33
         * title :
         他“秘书圈”的人数规模，赶上了周永康
         * type : 1
         */

        public String date;
        private int id;
        public String pic;
        public  String title;
        private int type;


    }
}

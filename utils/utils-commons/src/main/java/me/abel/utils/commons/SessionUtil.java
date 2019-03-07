package me.abel.utils.commons;

import javax.servlet.http.HttpSession;

/**
 * @program: automobile_dev
 * @description:
 * @author: able.li
 * @create: 2018-07-06 10:35
 */
public class SessionUtil {

    private static volatile HttpSession session;

    public static final HttpSession getSession() {
        return session;
    }

    public static final void setSession(HttpSession session) {
        SessionUtil.session = session;
    }

}

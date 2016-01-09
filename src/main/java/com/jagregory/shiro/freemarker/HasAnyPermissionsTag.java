package com.jagregory.shiro.freemarker;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 有任何之一的权限即可
 * Created by zsc on 2016/1/9.
 */
public class HasAnyPermissionsTag extends PermissionTag {

    private static final String PERM_NAMES_DELIMETER = ",";

    @Override
    protected boolean showTagBody(String perms) {

        boolean showTagBody = false;
        Subject subject = SecurityUtils.getSubject();
        if(subject !=null){
            for (String s : perms.split(PERM_NAMES_DELIMETER)) {
                if(subject.isPermitted(s)){
                    showTagBody = true;
                    break;
                }
            }
        }
        return showTagBody;
    }
}

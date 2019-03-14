/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.security.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * Shiro HasAnyPermissions Tag.
 * shiro的权限标签，是否包含指定标签之一
 * @author calvin
 */
public class HasAnyPermissionsTag extends PermissionTag {

	private static final long serialVersionUID = 1L;
	private static final String PERMISSION_NAMES_DELIMETER = ",";

	/* 是否显示标签体 */
	@Override
	protected boolean showTagBody(String permissionNames) {
		boolean hasAnyPermission = false;

		/* 获取当前主体 */
		Subject subject = getSubject();

		if (subject != null) {
			/* 遍历标签 */
			// Iterate through permissions and check to see if the user has one of the permissions
			for (String permission : permissionNames.split(PERMISSION_NAMES_DELIMETER)) {
				/* 如果含有标签之一，则为true */
				if (subject.isPermitted(permission.trim())) {
					hasAnyPermission = true;
					break;
				}

			}
		}

		return hasAnyPermission;
	}

}

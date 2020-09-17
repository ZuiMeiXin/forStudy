package cn.smbms.service.role;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleService {
	
	public List<Role> getRoleList();

	public List<Role> getRoleListByCodeAndName(String code,String name);

	public boolean deleteRole(Integer id);
	public boolean addRole(Role role);
	public boolean modifyRole(Role role);
	public Role getRoleById(Integer id);
}

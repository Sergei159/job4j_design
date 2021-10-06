package ru.job4j.generics;

public class RoleStore implements Store <Role> {

    private final Store<Role> roleStore = new MemStore<>();

    @Override
    public void add(Role model) {
        roleStore.add(model);
    }

    @Override
    public Role replace(String id, Role model) {
        return roleStore.replace(id, model);
    }

    @Override
    public Role delete(String id) {
        return roleStore.delete(id);
    }

    @Override
    public Role findById(String id) {
        return roleStore.findById(id);
    }
}

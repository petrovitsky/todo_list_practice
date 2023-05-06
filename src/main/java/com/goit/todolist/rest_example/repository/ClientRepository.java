    package com.goit.todolist.rest_example.repository;

    import com.goit.todolist.rest_example.model.Client;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface ClientRepository extends JpaRepository<Client, Long> {
}

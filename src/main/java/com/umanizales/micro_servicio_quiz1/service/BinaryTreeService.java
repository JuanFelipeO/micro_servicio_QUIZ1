package com.umanizales.micro_servicio_quiz1.service;

import com.umanizales.micro_servicio_quiz1.exception.BinaryTreeException;
import com.umanizales.micro_servicio_quiz1.exception.DataNotFoundException;
import com.umanizales.micro_servicio_quiz1.model.BinaryTree;
import com.umanizales.micro_servicio_quiz1.model.Student;
import com.umanizales.micro_servicio_quiz1.model.aplication.dto.ResponseBinaryTreeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BinaryTreeService
{
    private BinaryTree binaryTree= new BinaryTree();

    public ResponseEntity<ResponseBinaryTreeDto> addStudent(Student student) throws BinaryTreeException
    {
        binaryTree.addNode(student);
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(student, "Se ha guardado exitosamente",
                        null), HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listStudents(int which) throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.listStudent(which),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> prune() throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.prune(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> getStudentsGrade() throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.getStudentsGrade(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> getStudentsByLevel(int searchLevel) throws DataNotFoundException,BinaryTreeException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.getStudentsByLevel(searchLevel),"Success", null)
                ,HttpStatus.OK
        );
    }
}

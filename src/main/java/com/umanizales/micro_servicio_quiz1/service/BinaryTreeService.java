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

    public ResponseEntity<ResponseBinaryTreeDto> listStudentsByGrade(float grade, int condition) throws BinaryTreeException
    {
        if (binaryTree.listStudentsByGrade(grade, condition).isEmpty())
        {
            return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listStudentsByGrade(grade, condition),
                    "Esta vacia", null), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listStudentsByGrade(grade, condition),
                "Success!", null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listEndEqualNum(char number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listEndEqualNum(number),"Successful List",
                        null),HttpStatus.OK);}

    public ResponseEntity<ResponseBinaryTreeDto> countEndEqualNum(char number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.countEndEqualNum(number),"Successful Counter",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> getLeaves() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeaves(),"List Success",
                        null),HttpStatus.OK);

    }
}

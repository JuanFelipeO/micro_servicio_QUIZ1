package com.umanizales.micro_servicio_quiz1.controller;

import com.umanizales.micro_servicio_quiz1.exception.BinaryTreeException;
import com.umanizales.micro_servicio_quiz1.exception.DataNotFoundException;
import com.umanizales.micro_servicio_quiz1.model.Student;
import com.umanizales.micro_servicio_quiz1.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/binarytree")
@Validated
public class BinaryTreeController
{
    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Student student) throws BinaryTreeException
    {
        return binaryTreeService.addStudent(student);
    }

    @GetMapping("/preorden")
    public @ResponseBody
    ResponseEntity<?> listStudentPreOrden() throws DataNotFoundException {
        return binaryTreeService.listStudents(1);
    }

    @GetMapping("/inorden")
    public @ResponseBody
    ResponseEntity<?> listStudentInOrden() throws DataNotFoundException {
        return binaryTreeService.listStudents(2);
    }

    @GetMapping("/postorden")
    public @ResponseBody
    ResponseEntity<?> listStudentPostOrden() throws DataNotFoundException {
        return binaryTreeService.listStudents(3);
    }

    @GetMapping("/prune")
    public @ResponseBody
    ResponseEntity<?> prune() throws DataNotFoundException {
        return binaryTreeService.prune();
    }

    @GetMapping("/studentsgrade")
    public @ResponseBody
    ResponseEntity<?> getStudentsGrade() throws DataNotFoundException {
        return binaryTreeService.getStudentsGrade();
    }

    @GetMapping("/level/{level}")
    public @ResponseBody
    ResponseEntity<?> getStudentsByLevel(@PathVariable int level) throws DataNotFoundException,BinaryTreeException {
        return binaryTreeService.getStudentsByLevel(level);
    }

    @GetMapping("listStudentsByGradeLessEqual/{grade}")
    public @ResponseBody
    ResponseEntity<?> listStudentsByGradeLessEqual(@PathVariable float grade) throws  BinaryTreeException
    {
        return binaryTreeService.listStudentsByGrade(grade, 1);
    }
    @GetMapping("listStudentsByGradeLess/{grade}")
    public @ResponseBody
    ResponseEntity<?> listStudentsByGradeLess(@PathVariable float grade) throws  BinaryTreeException
    {
        return binaryTreeService.listStudentsByGrade(grade, 2);
    }
    @GetMapping("listStudentsByGradeGreater/{grade}")
    public @ResponseBody
    ResponseEntity<?> listStudentsByGradeGreater(@PathVariable float grade) throws  BinaryTreeException
    {
        return binaryTreeService.listStudentsByGrade(grade, 3);
    }
    @GetMapping("listStudentsByGradeGreaterEqual/{grade}")
    public @ResponseBody
    ResponseEntity<?> listStudentsByGradeGreaterEqual(@PathVariable float grade) throws  BinaryTreeException
    {
        return binaryTreeService.listStudentsByGrade(grade, 4);
    }

    @GetMapping("/listEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> listEndEqualNum(@PathVariable char number) throws DataNotFoundException {
        return binaryTreeService.listEndEqualNum(number);
    }

    @GetMapping("/countEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> countEndEqualNum(@PathVariable char number) throws DataNotFoundException {
        return binaryTreeService.countEndEqualNum(number);
    }

    @GetMapping("/getLeaves")
    public @ResponseBody
    ResponseEntity<?> getLeaves() throws DataNotFoundException {
        return binaryTreeService.getLeaves();
    }
}

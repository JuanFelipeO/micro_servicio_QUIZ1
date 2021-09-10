package com.umanizales.micro_servicio_quiz1.model;

import com.umanizales.micro_servicio_quiz1.controller.DTO.StudentGradeDTO;
import com.umanizales.micro_servicio_quiz1.exception.BinaryTreeException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@ToString
public class Node {
    private Student data;
    private Node left;
    private Node right;
    private int grade;

    public Node(Student data) {
        this.data = data;
    }

    public boolean isLeaf()
    {
        return left == null && right == null;
    }

    public void addNode(Student data) throws BinaryTreeException
    {
        if (data.getCode() < this.getData().getCode())
        {
            if (this.getLeft() == null) {
                this.setLeft(new Node(data));
            } else {
                this.left.addNode(data);
            }
            this.calculateGrade();
        }
        else if (data.getCode() > this.getData().getCode())
        {
            if (this.getRight() == null)
            {
                this.setRight(new Node(data));
            }
            else
            {
                this.right.addNode(data);
            }
            this.calculateGrade();
        }
        else
        {
            throw new BinaryTreeException("Ya existe un estudiante con esa identificacion");
        }
    }

    public List<Student> preOrden() {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(this.getData());
        if (this.getLeft() != null) {
            listStudent.addAll(this.getLeft().preOrden());
        }
        if (this.getRight() != null) {
            listStudent.addAll(this.getRight().preOrden());
        }
        return listStudent;
    }

    public List<Student> inOrden() {
        List<Student> listStudent = new ArrayList<>();
        if (this.getLeft() != null) {
            listStudent.addAll(this.getLeft().inOrden());
        }
        listStudent.add(this.getData());
        if (this.getRight() != null) {
            listStudent.addAll(this.getRight().inOrden());
        }
        return listStudent;
    }

    public List<Student> postOrden()
    {
        List<Student> listStudent = new ArrayList<>();
        if (this.getLeft() != null) {
            listStudent.addAll(this.getLeft().postOrden());
        }
        if (this.getRight() != null) {
            listStudent.addAll(this.getRight().postOrden());
        }
        listStudent.add(this.getData());
        return listStudent;
    }

    public void prune()
    {
        if(this.getRight()!=null)
        {
            if(this.getRight().isLeaf())
            {
                this.setRight(null);
            }
            else
            {
                this.getRight().prune();
            }
        }
        if(this.getLeft()!=null)
        {
            if(this.getLeft().isLeaf())
            {
                this.setLeft(null);
            }
            else
            {
                this.getLeft().prune();
            }
        }
    }

    public int calculateGrade()
    {
        int gradeLeft = this.getLeft() != null ? this.getLeft().getGrade():0;
        int gradeRight = this.getRight() != null ? this.getRight().getGrade():0;
        this.grade = gradeLeft >= gradeRight ? 1 + gradeLeft: 1 + gradeRight;
        return this.grade;
    }

    public List<StudentGradeDTO> getStudentsGrade() {
        List<StudentGradeDTO> listStudents = new ArrayList<>();
        listStudents.add(new StudentGradeDTO(this.getData(), this.grade));
        if (this.getLeft() != null) {
            listStudents.addAll(this.getLeft().getStudentsGrade());
        }
        if (this.getRight() != null) {
            listStudents.addAll(this.getRight().getStudentsGrade());
        }
        return listStudents;
    }

    public List<Student> getStudentsByLevel (int searchLevel, int yourLevel)
    {
        List<Student> listStudentsLevel = new ArrayList<>();
        if (this.isLeaf())
        {
            return listStudentsLevel;
        }

        if (searchLevel == yourLevel+1)
        {
            if (this.getLeft() != null)
            {
                listStudentsLevel.add(this.getLeft().getData());
            }
            if (this.getRight() != null)
            {
                listStudentsLevel.add(this.getRight().getData());
            }
        }
        else
        {
            if (this.getLeft() != null)
            {
                listStudentsLevel.addAll(this.getLeft().getStudentsByLevel(searchLevel, yourLevel+1));
            }
            if (this.getRight() != null)
            {
                listStudentsLevel.addAll(this.getRight().getStudentsByLevel(searchLevel, yourLevel+1));
            }
        }
        return listStudentsLevel;
    }
}

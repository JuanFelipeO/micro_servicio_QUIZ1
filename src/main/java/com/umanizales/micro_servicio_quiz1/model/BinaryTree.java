package com.umanizales.micro_servicio_quiz1.model;

import com.umanizales.micro_servicio_quiz1.controller.DTO.StudentGradeDTO;
import com.umanizales.micro_servicio_quiz1.exception.BinaryTreeException;
import com.umanizales.micro_servicio_quiz1.exception.DataNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BinaryTree
{
    private Node root;
    private int count;

    public void addNode(Student data) throws BinaryTreeException
    {
        if(root==null)
        {
            root = new Node(data);
        }
        else
        {
            root.addNode(data);
        }
        count++;
    }

    public List<Student> listStudent(int which) throws DataNotFoundException
    {
        if(root!=null)
        {
            List<Student> listStudent= new ArrayList<>();
            switch(which)
            {
                case 1:
                    return root.preOrden();
                case 2:
                    return root.inOrden();
                case 3:
                    return root.postOrden();
            }
        }
        throw new DataNotFoundException("No hay datos que mostrar");
    }

    public boolean prune() throws DataNotFoundException
    {
        if(root!=null)
        {
            if(root.isLeaf())
            {
                root=null;
            }
            else
            {
                root.prune();
            }
            return true;
        }
        throw new DataNotFoundException("No hay datos para podar");

    }

    public List<StudentGradeDTO> getStudentsGrade() throws DataNotFoundException
    {
        if (root != null)
        {
            return root.getStudentsGrade();
        }
        throw new DataNotFoundException("No hay datos que mostrar");
    }

    public List<Student> getStudentsByLevel(int searchLevel) throws DataNotFoundException,BinaryTreeException
    {
        if(root!=null)
        {
            if(searchLevel <= root.getGrade())
            {
                if(searchLevel==1)
                {
                    List<Student> listStudentsLevel = new ArrayList<>();
                    listStudentsLevel.add(root.getData());
                    return listStudentsLevel;
                }
                else
                {
                    return root.getStudentsByLevel(searchLevel,1);
                }
            }
            throw new BinaryTreeException("El level ingresado no existe");
        }
        throw new DataNotFoundException("No hay datos que mostrar");
    }
}

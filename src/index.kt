import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
val currentDateTime = LocalDateTime.now()

open class DigitalHouseManager(){
    var alunos = mutableListOf<Aluno>();
    var professores = mutableListOf<Professor>()
    var cursos = mutableListOf<Curso>()
    var matriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, titular: Titular, adjunto: Adjunto, quantidadeMaximaDeAlunos: Int){
        cursos?.add(Curso(nome, codigoCurso, titular, adjunto, quantidadeMaximaDeAlunos))
        println("Curso registrado com sucesso!")
        println(cursos[0].nome)
    }
    fun excluirCurso(curso: Curso){
        if(cursos?.contains(curso)) {
            cursos?.remove(curso)
            println("O Curso " + curso.nome + " Foi removido")
        } else {
            println("Curso não existe")
        }
    }
    fun registrarProfessorAdjunto( adjunto: Adjunto){
        professores?.add(adjunto.professor)
        println("Professor registrado com sucesso!")
        println(professores[0].nome)
    }
    fun registrarProfessorTitular(titular: Titular){
        professores?.add(titular.professor)
        println("Professor registrado com sucesso!")
        println(professores[0].nome)
    }
    fun excluirProfessor(professor: Professor){
        if(professores?.contains(professor)) {
            professores?.remove(professor)
            println("O Professor " + professor.nome + " Foi removido")
        } else {
            println("Professor não existe")
        }
    }
    open fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int){
        alunos?.add(Aluno(nome,sobrenome, codigoAluno))
        println(alunos[0].nome)
        println(alunos[0].sobrenome)
        println(alunos[0].codigo)
    }
    fun excluirAluno(aluno: Aluno){
        if(alunos?.contains(aluno)) {
            alunos?.remove(aluno)
            println("O aluno " + aluno.nome + " Foi removido do curso ")
        } else {
            println("Aluno não existe")
        }
    }
    fun alocarProfessores(curso: Curso, titular: Titular, adjunto: Adjunto){

    }
}
class Aluno(var nome: String, var sobrenome: String, var codigo: Int)

class Curso(
    var nome: String, var codigoCurso: Int, var titular: Titular,
    var adjunto: Adjunto, var quantidadeMaximaDeAlunos: Int
): DigitalHouseManager(){
    var alunosMatriculados = listOf<Aluno>()
    fun adicionarUmAluno(umAluno: Aluno){
        if(alunosMatriculados.size < quantidadeMaximaDeAlunos){
            println("Aluno Adicionado com sucesso!")
            matricularAluno(umAluno.nome, umAluno.sobrenome, umAluno.codigo)
            quantidadeMaximaDeAlunos + 1
        } else if(alunosMatriculados.size < quantidadeMaximaDeAlunos) {
            println("Este Curso está lotado!")
        }
    }
    fun removerUmAluno(umAluno: Aluno){
        excluirAluno(umAluno)
    }
}
class Professor(var nome: String, var sobrenome: String, var quantidadeDeHoras: Int, var codigoProfessor: Int)

class Titular( var especialiade: String, var  professor: Professor)
class Adjunto( var horasDeMonitoria: Int, var professor: Professor)

class Matricula(var aluno: Aluno, var curso: Curso, var data: String, var codigoMatricula: Int)
fun main(){
    var digitalHouse = DigitalHouseManager()
    var alunos = DigitalHouseManager().alunos
    var cursos = DigitalHouseManager().cursos
    var aluno = Aluno("Guilherme", "Deus", (alunos.size + 1))
    var professor = Professor("Adriano", "Rocha",40, 1234)
    var titular = Titular("Android", professor)
    var adjunto = Adjunto(40, professor)
    var curso = Curso("Android e Kotlin", (cursos.size + 1),
        Titular("Android", professor), Adjunto(40, professor),
        30)
    var matricula = Matricula(Aluno("Guilherme", "Deus", 1234), Curso("Android e Kotlin", 1234,
        Titular("Android", professor), Adjunto(40, professor),
        30), currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 1234
    )

    println(
        "Nome: " + aluno.nome + ",   "
                + " Sobrenome " + aluno.sobrenome + ",   "
                + " Código: " + aluno.codigo + ",   "
    )
    println(
        "Curso: " + curso.nome + ",   "
                + " Código do Curso: " + curso.codigoCurso + ",   "
                + " Titular:  " + curso.titular.especialiade + ",   "
                + " Adjunto: " + curso.adjunto.horasDeMonitoria + ",   "
                + " Quantidade maxima de alunos" + curso.quantidadeMaximaDeAlunos + ",   "
                + " Alunos Matriculados" + curso.alunosMatriculados + ",   "
    )
    println(
        "Titular: " + titular.especialiade + ",   "
                + " Nome: " + titular.professor.nome + ",   "
                + " Sobrenome: " + titular.professor.sobrenome + ",   "
                + " Quantidade De Horas: " + titular.professor.quantidadeDeHoras + ",   "
                + " codigo do Professor: " + titular.professor.codigoProfessor + ",   "
    )
    println(
        "Adjunto: " + adjunto.horasDeMonitoria + ",   "
                + " Nome: " + adjunto.professor.nome + ",   "
                + " Sobrenome: " + adjunto.professor.sobrenome + ",   "
                + " Quantidade De Horas: " + adjunto.professor.quantidadeDeHoras + ",   "
                + " codigo do Professor: " + adjunto.professor.codigoProfessor + ",   "
    )
    println(
        "Matricula: " + " "
                + " Aluno: " + matricula.aluno.nome + " "  + matricula.aluno.sobrenome + ",   " + " Código:  " +  matricula.aluno.codigo + ",   "
                + " Curso: " + matricula.curso.nome + ",   "  + matricula.curso.titular.especialiade + ",   " + matricula.curso.adjunto.horasDeMonitoria + ",   " + " Código:  " +  matricula.curso.codigoCurso + ",   "
                + " Data: " + matricula.data + ",   "
                + " Código da matricula: " + matricula.codigoMatricula
    )
    println(".")
    println(".")
    println(".")
    println(".")
    println(".")
    println(".")
    println(".")
    println(".")
    println(".")

    //curso.adicionarUmAluno(aluno)
    //curso.removerUmAluno(aluno)
    //digitalHouse.registrarCurso(curso.nome, curso.codigoCurso, curso.titular, curso.adjunto, curso.quantidadeMaximaDeAlunos + 1)
    //digitalHouse.excluirCurso(curso)
    //digitalHouse.registrarProfessorAdjunto(adjunto)
    //digitalHouse.registrarProfessorTitular(titular)
    //digitalHouse.excluirProfessor(professor)

    
}
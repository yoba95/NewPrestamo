import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

class MainControl {
    val grados = listOf<GradoAcademico>(
        GradoAcademico(1,"Bachillerato"),
        GradoAcademico(2,"Universidad"),
        GradoAcademico(3,"Postgrado"),
    )

    @Test
    fun main(){
        print("ingrese su nombre de usuario")
        val nombre = "Chavez Olivera"
        print("ingrese su curp")
        val curp = "CAPL88AFA"
        print("ingrese su fecha de ingreso")
        val fechaI = "2021-09-18"
        print("ingrese su género")
        val genero = "F"
        print("ingrese su clave presupuestal")
        val clavePresupuestal = "IJU8J"


        val personal: Personal = Personal(
            id_Personal = 1, nombre, curp,
            LocalDate.parse(fechaI), genero, grados[0],clavePresupuestal)

        print("por favor asigne un horario al trabajador")

        print("ingrese la hora de entrada")
        val horaE = "8:00"
        print("ingrese la hora de salida")
        val horaS = "15:00"
        println("ingrese el dia de la semana")
        val dia = 1

        val hora1: LocalTime = LocalTime.parse("10:00")
        val hora2: LocalTime = LocalTime.parse("15:00")
        val horaEntradaRetardo: LocalTime = LocalTime.parse("10:15")
        val horaSalidaFalta: LocalTime = LocalTime.parse("14:50")
        val rangoHoras = RangoHoras(hora1, hora2)
        val rangoHorasTarde = RangoHoras(horaEntradaRetardo, hora2)
        val rangoHorasFalta = RangoHoras(hora1, horaSalidaFalta)
//        println(rangoHoras.compararHoraInicial(horaEntada))

        val horarios: List<Horario> = listOf(
            Horario(1,rangoHoras,DayOfWeek.MONDAY),
            Horario(2,rangoHoras, DayOfWeek.TUESDAY),
            Horario(3,rangoHoras, DayOfWeek.WEDNESDAY),
            Horario(4,rangoHoras, DayOfWeek.THURSDAY),
            Horario(5,rangoHoras, DayOfWeek.FRIDAY),
        )
        val registros: List<Registro> = listOf(
            Registro(personal, "2021-09-13", rangoHoras),
            Registro(personal, "2021-09-14", rangoHorasTarde),//retardo
            Registro(personal, "2021-09-15", rangoHoras),
            Registro(personal, "2021-09-16", rangoHoras),
            Registro(personal, "2021-09-17", rangoHoras),
            Registro(personal, "2021-09-20", rangoHoras),//1
            Registro(personal, "2021-09-21", rangoHoras),
            Registro(personal, "2021-09-22", rangoHoras),
            Registro(personal, "2021-09-23", rangoHorasTarde),
            Registro(personal, "2021-09-24", rangoHorasTarde),
            Registro(personal, "2021-09-27", rangoHorasTarde),//2 faltas
            Registro(personal, "2021-09-28", rangoHorasTarde),
            Registro(personal, "2021-09-29", rangoHorasTarde),
            Registro(personal, "2021-09-30", rangoHorasTarde),
            Registro(personal, "2021-10-01", rangoHoras),
            Registro(personal, "2021-10-02", rangoHoras),
            Registro(personal, "2021-10-03", rangoHoras),
        )

        val registroAsistencias = Reporte(personal,registros,horarios,"2021-09-13","2021-10-03")
        println(registroAsistencias.personal.nombre + " ha tenido "+ registroAsistencias.retardos + " retardos")
        println(registroAsistencias.personal.nombre + " ha tenido "+ registroAsistencias.faltas + " faltas")

    }

}
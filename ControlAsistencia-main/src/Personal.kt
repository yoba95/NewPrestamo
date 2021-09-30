import java.time.LocalDate

data class Personal(val id_Personal: Int,val  nombre: String, val curp: String, var fecha_Ingreso:
LocalDate, val genero: String,val  gradoAcademico: GradoAcademico,val clavePresupuestal: String) {

    fun calcularAntigüedad() = LocalDate.now().year - fecha_Ingreso.year

}
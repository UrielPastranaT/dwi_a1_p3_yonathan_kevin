package beans;

/**
 *
 * @author Yonathan Uriel Pastrana Tepectzin y Kevin Ulises Garcia Camacho
 */
public class Alumno 
{
    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ddi;
    private int dwi;
    private int ecbd;
    private double prom;
    

    public Alumno() 
    {
        matricula = nombre = apellidoPaterno = apellidoMaterno = "";
        ddi = dwi = ecbd = 0;
        prom = 0;
    }
    
    

    public Alumno(String matricula, String nombre, String apellidoPaterno, String apellidoMaterno, int ddi, int dwi, int ecbd) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ddi = ddi;
        this.dwi = dwi;
        this.ecbd = ecbd;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDwi() {
        return dwi;
    }

    public void setDwi(int dwi) {
        this.dwi = dwi;
    }

    public int getEcbd() {
        return ecbd;
    }

    public void setEcbd(int ecbd) {
        this.ecbd = ecbd;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }
    
    public double calcularPromedio()
    {
        prom = (ddi + dwi + ecbd)/3;
        
        return prom;
    }
}

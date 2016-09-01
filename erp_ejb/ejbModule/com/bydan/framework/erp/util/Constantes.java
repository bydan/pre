package com.bydan.framework.erp.util;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class Constantes 
{
	//public static EntityManagerFactory JPAENTITYMANAGERFACTORY=null;//Persistence.createEntityManagerFactory(Constantes.SJPAPERSISTENCEUNITNAME);
	
	//public static EntityManagerFactory JPAENTITYMANAGERFACTORINHERITANCE= null;
	
	//public  static String SJPAPERSISTENCEUNITNAME="PersistenceUnitEnvioMail";//"PersistenceUnitAuditoria";//"PersistenceUnitSeguridad";
	
	public  static ConnexionType CONNEXIONTYPE=ConnexionType.JDBC32;
	
	public  static ParameterDbType PARAMETERDBTYPE=ParameterDbType.POSTGRES;
	
	public  static Boolean ISJBOSS=true;
	
	public  static Boolean ISDEVELOPING=false;
	
	public  static Boolean ISSETVERSIONROWUPDATE=false;
	
	public  static String SPREFIXJNDI="java:";
	
	public  static String SCONNEXIONDATASOURCE="erp_ds";
	
	public  static Boolean ISUSACONNECTIONFROMDATASOURCESSERVER=false;
	
	final public  static String SFINALQUERY=" order by id ";
	
	//CONSTANTES EJB
	public  static Boolean ISUSAEJBLOGICLAYER=true;
	
	public  static Boolean ISUSAEJBREMOTE=false;
	
	final public  static Boolean ISUSAEJBRMI=false;
	
	public  static Boolean ISUSAEJBREMOTEADDITIONAL=false;
	
	public  static Boolean ISUSAEJBHOME=false;
	
	final public  static String SCLIENTBINDURL="socket://localhost:3873";//usually="socket://localhost:3873";	http="http://bydan.homelinux.com:80/servlet-invoker/ServerInvokerServlet"
	
	public  static String INITIAL_CONTEXT_FACTORY="org.jnp.interfaces.NamingContextFactory";//usually="org.jnp.interfaces.NamingContextFactory";	http="org.jboss.naming.HttpNamingContextFactory"
		
	public  static String PROVIDER_URL="jnp://localhost:1099";//usually="jnp://localhost:1099";	http="http://bydan.homelinux.com:80/invoker/JNDIFactory"
	
	public  static String URL_PKG_PREFIXES="org.jboss.naming:org.jnp.interfaces";//usually="org.jboss.naming:org.jnp.interfaces";	http=org.jboss.naming
	
	final public  static String SEJBPACKAGE="seguridad";
	
	//GENERALMENTE VACIO, SE CAMBIA CUANDO SE TIENE NOMBRES REPETIDOS EN UN persistence.xml
	final public static String SPERSISTENCECONTEXTNAME="";//"_Seguridad";
	
	final public static String SEJBLOCAL="local";
	
	final public static String SEJBREMOTE="remote";
	
	final public static String SEJBADDITIONAL="Additional";
	
	final public static String SEJBSEGURIDAD="seguridad";
	
	final public static String SEJBSEPARATOR="/";
	
	final public static String SMENSAJES="mensajes";
	
	final public static String SCONTEXTSERVER="erp";
	
	final public static String SUNIDAD_ARCHIVOS="C";
	
	final public static String SS="s";
	
	final public static String SSESSIONBEAN="SessionBean";

	final public static String SREQUESTBEAN="RequestBean";
	
	final public static String SFACE_INI="#{";
	
	final public static String SFACE_FIN="}";
	
	//MENSAJES Y REGEX GENERALES VALIDACIONES
	final public static String SVALIDACIONCADENA="No es cadena";
	
	final public static String SVALIDACIONTODOS="No es todos";
	
	final public static String SREGEXCADENA="[0-9A-Za-z_)( .=:;-]*";//"[^�]*";
	
	final public static String SREGEXCADENATODOS="[^�]*";
	
	final public static String SVALIDACIONNUMEROENTERO="No es numero";
	
	final public static String SREGEXNUMEROENTERO="[^�]*";
	
	final public static String SVALIDACIONNOTNULL="Es nulo";
	
	final public static String SVALIDACIONSMALLINT="No es smallint";
	
	final public static String SVALIDACIONNOVACIO="No puede estar vacio";
	
	final public static String SVALIDACIONINT="No es int";
	
	final public static String SVALIDACIONBIGINT="No es bigint";
	
	final public static String SVALIDACIONDECIMAL="No es decimal";
	
	final public static String SVALIDACIONLENGTH="No tamanio";
	//MENSAJES Y REGEX GENERALES VALIDACIONES
	
	private static ArrayList<String> arrMailsVerificacionErrores=new ArrayList<String>();

	public static String SMAILIP="200.31.26.156";
	
	public static String SMAILPORT="";
	
	public static String SMAILDNS="tame.com.ec";
	
	final public static String SDNSNAMESERVER="localhost";
	
	final public static String SPORTSERVER="80";
		
	public  static Boolean ISMOSTRARMENSAJESMANTENIMIENTO=true;
	
	public static Long LIDPERFILTUTOR=2L;

	public static Long LIDPERFILALUMNO=2L;

	public static String SURLVIDEO="VIDEO";
		
	public static String SLABELARCHIVOS="Archivos";
	
	public static String SLABELRESUMENES="Resumenes";
	
	public static String SLABELURLS="Urls";
	
	public static String SLABELPREGUNTASOPCIONES="Preguntas";
	
	public static String SLABELPREGUNTASYRESPUESTAS="Preguntas Y Respuestas";
	
	public static String SLABELURLSYENLACES="Urls y Enlaces externos";
	
	public static String SLABELVERDESDEYOUTUBE="Ver desde Youtube";
	
	public static String SLABELVERDESDEVIDEOGOOGLE="Ver desde Video Google";
	
	public static String SLABELPREGUNTAS="Preguntas";
	
	public static String SLABELRESPUESTAS="Respuestas";
	
	public static String SLABELRESPUESTASCORRECTAS="Respuestas Correctas";
		
	public static String SPALABRACLAVEREEMPLAZARHTML="REEMPLAZAR";
	
	public static String SRAIZDESDEPAGINASCURSO="../../../../";
	
	public static String SURLVIDEOGOOGLE="GOOGLE";
	
	public static String SURLVIDEOYOUTUBE="YOUTUBE";
	
	public static String SNOMBRESISTEMACARPETA="AulaVirtual";
	
	public static String SLABELIMPRIMIR="Imprimir Pagina";
	
	public static String SNOMBREINICIOPARAMETROTITULO="sTitulo";
	
	public static String SNOMBREINICIOPARAMETROPARRAFO="sParrafo";
	
	public static String SNOMBREINICIOPARAMETROPATHIMAGEN="sPathImagen";
	
	public static String SLABELREESPUESTASSOLAMENTE="Respuestas de la p�gina ";
	
	public static String SRAIZDESDECURSO="../../../";

	public static Integer INUMEROELEMENTOSMINIMOPAGINA=4;

	public static Long LIDPERFILADMINISTRADORAULAVIRTUAL=2L;
	
	public static Long LIDPERFILADMINISTRADOR=1L;

	public static String SCARPETAPAGINAS="Paginas";

	public static String SPATHLOGGIN="C:\\";

	public static String SLOGGINPACKAGEFILE="bydan.enviomails_f";
	
	public static String SLOGGINPACKAGECONSOLE="bydan.enviomails_c";

	public static String SCONNEXION="127.0.0.1:3306/enviomails_dbo?user=root////password=root";
	
	public static String SCONNEXION_USER="postgres";//"root";
	
	public static String SCONNEXION_PASSWORD="postgres";//"root";
	
	public static String SCONNEXION_POSTGRES="127.0.0.1:5432/bydan_erp";//"127.0.0.1:5432/bydan_erp";"192.168.1.4:5432/bydan_erp"
	
	public static String SCONNEXIONAUDITORIA="127.0.0.1:3306/auditoria_dbo?user=root////password=root";
	
	public static String SCONNEXIONSEGURIDAD="127.0.0.1:3306/seguridads_dbo?user=root////password=root";
	
	//SERVICIO RMI
	public static String SSERVICIO_RMI_IP="192.168.1.4";
	public static Integer SSERVICIO_RMI_PORT=1099;
	//SERVICIO RMI
	
	public static String SLABELIMPRIMIRHASTA="Imprimir hasta la pagina";
	
	public static String SLABELIMPRIMIRCURSOUNIDADCURRICULAR="Imprimir Curso";
	
	public static Integer ITAMANIOPAGINA=600;
	
	final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOS=350;
	final public static Integer ISWING_TAMANIOMINIMO_TABLADATOS=260;
	
	//PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS(ISWING_TAMANIOMAXIMO_TABLADATOSREL,ISWING_TAMANIOMINIMO_TABLADATOSREL,ISWING_ALTO_TABPANE)
	final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
	final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260;
	
	final public static Integer ISWING_RESTOPARTE_DIFERENCIA_ANCHO=7;
	
	final public static Integer ISWING_RESTOPARTE_DIFERENCIA_ALTO=8;//5;
	
	final public static Integer ISWING_RESTOPARTE_DIFERENCIA_ANCHO_RELSCROLL=5;
	final public static Integer ISWING_RESTOPARTE_DIFERENCIA_ALTO_RELSCROLL=4;
	
	final public static Integer ISWING_ANCHO_CONTROL=150;
	final public static Integer ISWING_ANCHO_CONTROL_VALOR=100;
	final public static Integer ISWING_ANCHO_CONTROL_FECHA=100;//FuncionesSwing.getValorProporcion(Constantes.ISWING_ANCHO_CONTROL,80)
	final public static Integer ISWING_ANCHO_CONTROL_LABEL=150;
	final public static Integer ISWING_ANCHO_CONTROL_LABEL2=80;
	final public static Integer ISWING_ALTO_CONTROL=22;
	final public static Integer ISWING_ALTO_CONTROL_FECHA=26;//Constantes.ISWING_ALTO_CONTROL+ Constantes.ISWING_ALTO_FILA_TABLA_EXTRA_FECHA
	final public static Integer ISWING_ANCHO_COLUMNA=100;
	final public static Integer ISWING_ALTO_FILA=34;
	final public static Integer ISWING_ALTO_FILA_TABLA=21;
	final public static Integer ISWING_ALTO_FILA_TABLA_EXTRA_FECHA=4;
	//PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS(ISWING_TAMANIOMAXIMO_TABLADATOSREL,ISWING_TAMANIOMINIMO_TABLADATOSREL,ISWING_ALTO_TABPANE)
	final public static Integer ISWING_ALTO_TABPANE=350;//375;//400,260,430;
	final public static Integer ISWING_ALTO_TABPANE_BUSQUEDA=130;//150;
	
	public static String SAUDITORIABUSCAR="BUSQ";
	
	public static String SAUDITORIAINSERTAR="INS";
	
	public static String SAUDITORIAACTUALIZAR="ACT";
	
	public static String SAUDITORIAELIMINARLOGICAMENTE="ELMLGC";
	
	public static String SAUDITORIAELIMINARFISICAMENTE="ELMFSC";
	
	public static Long LIDSISTEMAACTUAL=14L;
	
	public static Long LIDMODULOACTUAL=2L;
	
	public static String SAREADEPARTAMENTO="INFORMATICA";
	
	public static final String SCHEMA="seguridad";
	public static final String SCHEMA_SEGURIDAD="seguridad";
	public static final String SCHEMA_AUDITORIA="auditoria";
	public static final String SCHEMA_GENERAL="general";
	public static final String SCHEMA_NOMINA="nomina";
	public static final String SCHEMA_COMISIONES="comisiones";
	public static final String SCHEMA_CONTABILIDAD="contabilidad";
	public static final String SCHEMA_ACTIVOSFIJOS="activosfijos";
	public static final String SCHEMA_PUNTOVENTA="puntoventa";
	public static final String SCHEMA_FACTURACION="facturacion";
	public static final String SCHEMA_TEMPORAL="temporal";
	public static final String SCHEMA_TESORERIA="tesoreria";
	public static final String SCHEMA_CARTERA="cartera";
	public static final String SCHEMA_INVENTARIO="inventario";
	public static final String SCHEMA_PRODUCCION="produccion";	
	public static final String SCHEMAAUDITORIA="auditoria";	
	public static final String SCHEMA_IMPORTACIONES="importaciones";
	public static final String SCHEMA_PROYECTOS="proyectos";
	public static final String SCHEMA_SRIS="sris";
	public static final String SCHEMA_ZAUXILIAR="zauxiliar";
	public static final String SCHEMA_NINGUNO="NINGUNO";	
	
	final public  static String SMODULO_IMPORTACIONES="Importaciones";
	
	public static String SNONE="NONE";
	
	public static String SCAMPONONE="NONE";
	
	public static String SCAMPOVERDADERO="Si";//Verdadero
	
	public static String SCAMPOFALSO="No";//Falso
	
	public static String SEXTENSIONARCHIVOJSP=".jsp";
	
	public static String SPREFIJOARCHIVOJSP="Mantenitmiento";
	
	//CONSTANTES PAGINATION
	public static String SPAGINATIONONE="NONE";
	
	public static String SPAGINATIONEXT="NEXT";
	
	public static String SPAGINATIOPREVIEW="PREVIEW";
	
	
	//CONSTANTES MENSAJE
	public static String SMENSAJEVERIFICARPERMISOSCODIGO="verificarpermisosmantenimiento";
	public static String SMENSAJEVERIFICARPERMISOSTITULO="Verificar permisos de usuario";
	public static String SMENSAJEAUXILIAR="Auxiliar";
	public static String SMENSAJEULTIMABUSQUEDA="Ultima Busqueda";
	public static String SMENSAJEREGISTROSESSION="Registro de sesion";
	public static String SMENSAJEEXCEPCIONDEAPLICACION="Excepcion de Aplicacion";
	public static String SMENSAJEERRORDEAPLICACION="Error de aplicacion";
	
	public static String SMENSAJEGRUPO="mensajegrupo";
	public static String SMENSAJETIPO="mensajetipo";
	public static String SMENSAJENOMBREMENSAJE="nombremensaje";
	public static String SMENSAJEESOPCIONAL="esopcional";
	public static String SMENSAJETITULO="titulo";
	public static String SMENSAJEMENSAJEUSUARIO="mensajeusuario";
	public static String SMENSAJEMENSAJETECNICO="mensajetecnico";
	public static String SMENSAJEAPLICACIONJ2EE="aplicacionj2ee";
	public static String SMENSAJEAPLICACION="aplicacion";
	
	final public static String SMENSAJE_ESCOJA_OPCION="Escoja una opcion";
	
	//CONSTANTES REPORTES
	public static String SREPORTEPATHCARPETA="Reportes/";
	public static String SREPORTESUFIJOREPORTE="Design.jasper";
	public static String SREPORTEMASTERRELACIONES="MasterRelaciones";
	public static String SREPORTETITULO="REPORTE DE  ";
	
	//CONSTANTES WEB 
	public static String SSESSIONVALUETREEAJAX="valueTreeAjax";
	public static String SSESSIONVALUEJAVASCRIPTTREEAJAX="valueJavaScriptTreeAjax";
	
	//CONSTANTES SWING
	public static int INUM_MAX_VENTANAS=5;
	public static int INUM_MAX_VENTANAS_DET_X=3;
	public static int INUM_MAX_VENTANAS_DET_Y=1;
	public static int INUM_MAX_VENTANAS_REL_X=3;
	public static int INUM_MAX_VENTANAS_REL_Y=1;
	public static Boolean CON_VARIAS_VENTANAS=false;
		
	public static ArrayList<String> getArrMailsVerificacionErrores() {
		return arrMailsVerificacionErrores;
	}

	public static void setArrMailsVerificacionErrores(
			ArrayList<String> arrMailsVerificacionErrores) {
		Constantes.arrMailsVerificacionErrores = arrMailsVerificacionErrores;
	}
	
	//CONSTANTES VERSION
	public static String SVERSION_JBOSS="8.1";
	
	//CONSTANTES FILES APPLICATION
	public static String SNANME_FILE_EAR_EJB="erp_ear";
	public static String SNANME_FILE_EJB="erp_ejb";
	
}

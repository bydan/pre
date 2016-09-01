/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.nomina.util.PlaniVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.PlaniVacacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PlaniVacacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PlaniVacacionConstantesFunciones extends PlaniVacacionConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PlaniVacacion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PlaniVacacion"+PlaniVacacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PlaniVacacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PlaniVacacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PlaniVacacionConstantesFunciones.SCHEMA+"_"+PlaniVacacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PlaniVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PlaniVacacionConstantesFunciones.SCHEMA+"_"+PlaniVacacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PlaniVacacionConstantesFunciones.SCHEMA+"_"+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PlaniVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PlaniVacacionConstantesFunciones.SCHEMA+"_"+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaniVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaniVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaniVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PlaniVacacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PlaniVacacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PlaniVacacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PlaniVacacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Plani Vacaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Plani Vacacion";
	public static final String SCLASSWEBTITULO_LOWER="Plani Vacacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PlaniVacacion";
	public static final String OBJECTNAME="planivacacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="plani_vacacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select planivacacion from "+PlaniVacacionConstantesFunciones.SPERSISTENCENAME+" planivacacion";
	public static String QUERYSELECTNATIVE="select "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".version_row,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_empresa,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_sucursal,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura_seccion,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura_cargo,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_empleado,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".fecha_inicio,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".fecha_fin,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_mes,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_anio,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_realizadas,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_pendiente,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_tomados,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_anticipadas,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".descripcion from "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME;//+" as "+PlaniVacacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PlaniVacacionConstantesFuncionesAdditional planivacacionConstantesFuncionesAdditional=null;
	
	public PlaniVacacionConstantesFuncionesAdditional getPlaniVacacionConstantesFuncionesAdditional() {
		return this.planivacacionConstantesFuncionesAdditional;
	}
	
	public void setPlaniVacacionConstantesFuncionesAdditional(PlaniVacacionConstantesFuncionesAdditional planivacacionConstantesFuncionesAdditional) {
		try {
			this.planivacacionConstantesFuncionesAdditional=planivacacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTRUCTURASECCION= "id_estructura_seccion";
    public static final String IDESTRUCTURACARGO= "id_estructura_cargo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String IDMES= "id_mes";
    public static final String DIASANIO= "dias_anio";
    public static final String DIASREALIZADAS= "dias_realizadas";
    public static final String DIASPENDIENTE= "dias_pendiente";
    public static final String DIASTOMADOS= "dias_tomados";
    public static final String DIASANTICIPADAS= "dias_anticipadas";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTRUCTURASECCION= "Estructura Seccion";
		public static final String LABEL_IDESTRUCTURASECCION_LOWER= "Estructura Seccion";
    	public static final String LABEL_IDESTRUCTURACARGO= "Estructura Cargo";
		public static final String LABEL_IDESTRUCTURACARGO_LOWER= "Estructura Cargo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_DIASANIO= "Dias Anio";
		public static final String LABEL_DIASANIO_LOWER= "Dias Anio";
    	public static final String LABEL_DIASREALIZADAS= "Dias Realizadas";
		public static final String LABEL_DIASREALIZADAS_LOWER= "Dias Realizadas";
    	public static final String LABEL_DIASPENDIENTE= "Dias Pendiente";
		public static final String LABEL_DIASPENDIENTE_LOWER= "Dias Pendiente";
    	public static final String LABEL_DIASTOMADOS= "Dias Tomados";
		public static final String LABEL_DIASTOMADOS_LOWER= "Dias Tomados";
    	public static final String LABEL_DIASANTICIPADAS= "Dias Anticipadas";
		public static final String LABEL_DIASANTICIPADAS_LOWER= "Dias Anticipadas";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPlaniVacacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURASECCION;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURACARGO;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.FECHAINICIO)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.FECHAFIN)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.IDMES)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DIASANIO)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DIASANIO;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DIASREALIZADAS)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DIASPENDIENTE)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DIASTOMADOS)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DIASANTICIPADAS)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS;}
		if(sNombreColumna.equals(PlaniVacacionConstantesFunciones.DESCRIPCION)) {sLabelColumna=PlaniVacacionConstantesFunciones.LABEL_DESCRIPCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPlaniVacacionDescripcion(PlaniVacacion planivacacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(planivacacion !=null/* && planivacacion.getId()!=0*/) {
			if(planivacacion.getId()!=null) {
				sDescripcion=planivacacion.getId().toString();
			}//planivacacionplanivacacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPlaniVacacionDescripcionDetallado(PlaniVacacion planivacacion) {
		String sDescripcion="";
			
		sDescripcion+=PlaniVacacionConstantesFunciones.ID+"=";
		sDescripcion+=planivacacion.getId().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=planivacacion.getVersionRow().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=planivacacion.getid_empresa().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=planivacacion.getid_sucursal().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=planivacacion.getid_estructura().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION+"=";
		sDescripcion+=planivacacion.getid_estructura_seccion().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO+"=";
		sDescripcion+=planivacacion.getid_estructura_cargo().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=planivacacion.getid_empleado().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=planivacacion.getfecha_inicio().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=planivacacion.getfecha_fin().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.IDMES+"=";
		sDescripcion+=planivacacion.getid_mes().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DIASANIO+"=";
		sDescripcion+=planivacacion.getdias_anio().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DIASREALIZADAS+"=";
		sDescripcion+=planivacacion.getdias_realizadas().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DIASPENDIENTE+"=";
		sDescripcion+=planivacacion.getdias_pendiente().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DIASTOMADOS+"=";
		sDescripcion+=planivacacion.getdias_tomados().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DIASANTICIPADAS+"=";
		sDescripcion+=planivacacion.getdias_anticipadas().toString()+",";
		sDescripcion+=PlaniVacacionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=planivacacion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPlaniVacacionDescripcion(PlaniVacacion planivacacion,String sValor) throws Exception {			
		if(planivacacion !=null) {
			//planivacacionplanivacacion.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEstructuraSeccionDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEstructuraCargoDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdEstructuraCargo")) {
			sNombreIndice="Tipo=  Por Estructura Cargo";
		} else if(sNombreIndice.equals("FK_IdEstructuraSeccion")) {
			sNombreIndice="Tipo=  Por Estructura Seccion";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructuraCargo(Long id_estructura_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura_cargo!=null) {sDetalleIndice+=" Codigo Unico De Estructura Cargo="+id_estructura_cargo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructuraSeccion(Long id_estructura_seccion) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura_seccion!=null) {sDetalleIndice+=" Codigo Unico De Estructura Seccion="+id_estructura_seccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPlaniVacacion(PlaniVacacion planivacacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		planivacacion.setdescripcion(planivacacion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPlaniVacacions(List<PlaniVacacion> planivacacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlaniVacacion planivacacion: planivacacions) {
			planivacacion.setdescripcion(planivacacion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaniVacacion(PlaniVacacion planivacacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && planivacacion.getConCambioAuxiliar()) {
			planivacacion.setIsDeleted(planivacacion.getIsDeletedAuxiliar());	
			planivacacion.setIsNew(planivacacion.getIsNewAuxiliar());	
			planivacacion.setIsChanged(planivacacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			planivacacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			planivacacion.setIsDeletedAuxiliar(false);	
			planivacacion.setIsNewAuxiliar(false);	
			planivacacion.setIsChangedAuxiliar(false);
			
			planivacacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaniVacacions(List<PlaniVacacion> planivacacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PlaniVacacion planivacacion : planivacacions) {
			if(conAsignarBase && planivacacion.getConCambioAuxiliar()) {
				planivacacion.setIsDeleted(planivacacion.getIsDeletedAuxiliar());	
				planivacacion.setIsNew(planivacacion.getIsNewAuxiliar());	
				planivacacion.setIsChanged(planivacacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				planivacacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				planivacacion.setIsDeletedAuxiliar(false);	
				planivacacion.setIsNewAuxiliar(false);	
				planivacacion.setIsChangedAuxiliar(false);
				
				planivacacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPlaniVacacion(PlaniVacacion planivacacion,Boolean conEnteros) throws Exception  {
		planivacacion.setdias_anio(0.0);
		planivacacion.setdias_realizadas(0.0);
		planivacacion.setdias_pendiente(0.0);
		planivacacion.setdias_tomados(0.0);
		planivacacion.setdias_anticipadas(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPlaniVacacions(List<PlaniVacacion> planivacacions,Boolean conEnteros) throws Exception  {
		
		for(PlaniVacacion planivacacion: planivacacions) {
			planivacacion.setdias_anio(0.0);
			planivacacion.setdias_realizadas(0.0);
			planivacacion.setdias_pendiente(0.0);
			planivacacion.setdias_tomados(0.0);
			planivacacion.setdias_anticipadas(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPlaniVacacion(List<PlaniVacacion> planivacacions,PlaniVacacion planivacacionAux) throws Exception  {
		PlaniVacacionConstantesFunciones.InicializarValoresPlaniVacacion(planivacacionAux,true);
		
		for(PlaniVacacion planivacacion: planivacacions) {
			if(planivacacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			planivacacionAux.setdias_anio(planivacacionAux.getdias_anio()+planivacacion.getdias_anio());			
			planivacacionAux.setdias_realizadas(planivacacionAux.getdias_realizadas()+planivacacion.getdias_realizadas());			
			planivacacionAux.setdias_pendiente(planivacacionAux.getdias_pendiente()+planivacacion.getdias_pendiente());			
			planivacacionAux.setdias_tomados(planivacacionAux.getdias_tomados()+planivacacion.getdias_tomados());			
			planivacacionAux.setdias_anticipadas(planivacacionAux.getdias_anticipadas()+planivacacion.getdias_anticipadas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaniVacacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PlaniVacacionConstantesFunciones.getArrayColumnasGlobalesPlaniVacacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaniVacacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaniVacacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaniVacacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaniVacacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaniVacacionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPlaniVacacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlaniVacacion> planivacacions,PlaniVacacion planivacacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlaniVacacion planivacacionAux: planivacacions) {
			if(planivacacionAux!=null && planivacacion!=null) {
				if((planivacacionAux.getId()==null && planivacacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(planivacacionAux.getId()!=null && planivacacion.getId()!=null){
					if(planivacacionAux.getId().equals(planivacacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlaniVacacion(List<PlaniVacacion> planivacacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double dias_anioTotal=0.0;
		Double dias_realizadasTotal=0.0;
		Double dias_pendienteTotal=0.0;
		Double dias_tomadosTotal=0.0;
		Double dias_anticipadasTotal=0.0;
	
		for(PlaniVacacion planivacacion: planivacacions) {			
			if(planivacacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			dias_anioTotal+=planivacacion.getdias_anio();
			dias_realizadasTotal+=planivacacion.getdias_realizadas();
			dias_pendienteTotal+=planivacacion.getdias_pendiente();
			dias_tomadosTotal+=planivacacion.getdias_tomados();
			dias_anticipadasTotal+=planivacacion.getdias_anticipadas();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaniVacacionConstantesFunciones.DIASANIO);
		datoGeneral.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASANIO);
		datoGeneral.setdValorDouble(dias_anioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaniVacacionConstantesFunciones.DIASREALIZADAS);
		datoGeneral.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS);
		datoGeneral.setdValorDouble(dias_realizadasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaniVacacionConstantesFunciones.DIASPENDIENTE);
		datoGeneral.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE);
		datoGeneral.setdValorDouble(dias_pendienteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaniVacacionConstantesFunciones.DIASTOMADOS);
		datoGeneral.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS);
		datoGeneral.setdValorDouble(dias_tomadosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaniVacacionConstantesFunciones.DIASANTICIPADAS);
		datoGeneral.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS);
		datoGeneral.setdValorDouble(dias_anticipadasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPlaniVacacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_ID, PlaniVacacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_VERSIONROW, PlaniVacacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDEMPRESA, PlaniVacacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDSUCURSAL, PlaniVacacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURA, PlaniVacacionConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURASECCION, PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURACARGO, PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDEMPLEADO, PlaniVacacionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_FECHAINICIO, PlaniVacacionConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_FECHAFIN, PlaniVacacionConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_IDMES, PlaniVacacionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DIASANIO, PlaniVacacionConstantesFunciones.DIASANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS, PlaniVacacionConstantesFunciones.DIASREALIZADAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE, PlaniVacacionConstantesFunciones.DIASPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS, PlaniVacacionConstantesFunciones.DIASTOMADOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS, PlaniVacacionConstantesFunciones.DIASANTICIPADAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaniVacacionConstantesFunciones.LABEL_DESCRIPCION, PlaniVacacionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPlaniVacacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DIASANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DIASREALIZADAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DIASPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DIASTOMADOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DIASANTICIPADAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaniVacacionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaniVacacion() throws Exception  {
		return PlaniVacacionConstantesFunciones.getTiposSeleccionarPlaniVacacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaniVacacion(Boolean conFk) throws Exception  {
		return PlaniVacacionConstantesFunciones.getTiposSeleccionarPlaniVacacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaniVacacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURASECCION);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURASECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURACARGO);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURACARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DIASANIO);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaniVacacionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PlaniVacacionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPlaniVacacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPlaniVacacion(PlaniVacacion planivacacionAux) throws Exception {
		
			planivacacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planivacacionAux.getEmpresa()));
			planivacacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(planivacacionAux.getSucursal()));
			planivacacionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructura()));
			planivacacionAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructuraSeccion()));
			planivacacionAux.setestructuracargo_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructuraCargo()));
			planivacacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(planivacacionAux.getEmpleado()));
			planivacacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(planivacacionAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPlaniVacacion(List<PlaniVacacion> planivacacionsTemp) throws Exception {
		for(PlaniVacacion planivacacionAux:planivacacionsTemp) {
			
			planivacacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planivacacionAux.getEmpresa()));
			planivacacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(planivacacionAux.getSucursal()));
			planivacacionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructura()));
			planivacacionAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructuraSeccion()));
			planivacacionAux.setestructuracargo_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(planivacacionAux.getEstructuraCargo()));
			planivacacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(planivacacionAux.getEmpleado()));
			planivacacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(planivacacionAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPlaniVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPlaniVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaniVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaniVacacionConstantesFunciones.getClassesRelationshipsOfPlaniVacacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaniVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaniVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaniVacacionConstantesFunciones.getClassesRelationshipsFromStringsOfPlaniVacacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaniVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PlaniVacacion planivacacion,List<PlaniVacacion> planivacacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PlaniVacacion planivacacionEncontrado=null;
			
			for(PlaniVacacion planivacacionLocal:planivacacions) {
				if(planivacacionLocal.getId().equals(planivacacion.getId())) {
					planivacacionEncontrado=planivacacionLocal;
					
					planivacacionLocal.setIsChanged(planivacacion.getIsChanged());
					planivacacionLocal.setIsNew(planivacacion.getIsNew());
					planivacacionLocal.setIsDeleted(planivacacion.getIsDeleted());
					
					planivacacionLocal.setGeneralEntityOriginal(planivacacion.getGeneralEntityOriginal());
					
					planivacacionLocal.setId(planivacacion.getId());	
					planivacacionLocal.setVersionRow(planivacacion.getVersionRow());	
					planivacacionLocal.setid_empresa(planivacacion.getid_empresa());	
					planivacacionLocal.setid_sucursal(planivacacion.getid_sucursal());	
					planivacacionLocal.setid_estructura(planivacacion.getid_estructura());	
					planivacacionLocal.setid_estructura_seccion(planivacacion.getid_estructura_seccion());	
					planivacacionLocal.setid_estructura_cargo(planivacacion.getid_estructura_cargo());	
					planivacacionLocal.setid_empleado(planivacacion.getid_empleado());	
					planivacacionLocal.setfecha_inicio(planivacacion.getfecha_inicio());	
					planivacacionLocal.setfecha_fin(planivacacion.getfecha_fin());	
					planivacacionLocal.setid_mes(planivacacion.getid_mes());	
					planivacacionLocal.setdias_anio(planivacacion.getdias_anio());	
					planivacacionLocal.setdias_realizadas(planivacacion.getdias_realizadas());	
					planivacacionLocal.setdias_pendiente(planivacacion.getdias_pendiente());	
					planivacacionLocal.setdias_tomados(planivacacion.getdias_tomados());	
					planivacacionLocal.setdias_anticipadas(planivacacion.getdias_anticipadas());	
					planivacacionLocal.setdescripcion(planivacacion.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!planivacacion.getIsDeleted()) {
				if(!existe) {
					planivacacions.add(planivacacion);
				}
			} else {
				if(planivacacionEncontrado!=null && permiteQuitar)  {
					planivacacions.remove(planivacacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PlaniVacacion planivacacion,List<PlaniVacacion> planivacacions) throws Exception {
		try	{			
			for(PlaniVacacion planivacacionLocal:planivacacions) {
				if(planivacacionLocal.getId().equals(planivacacion.getId())) {
					planivacacionLocal.setIsSelected(planivacacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPlaniVacacion(List<PlaniVacacion> planivacacionsAux) throws Exception {
		//this.planivacacionsAux=planivacacionsAux;
		
		for(PlaniVacacion planivacacionAux:planivacacionsAux) {
			if(planivacacionAux.getIsChanged()) {
				planivacacionAux.setIsChanged(false);
			}		
			
			if(planivacacionAux.getIsNew()) {
				planivacacionAux.setIsNew(false);
			}	
			
			if(planivacacionAux.getIsDeleted()) {
				planivacacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPlaniVacacion(PlaniVacacion planivacacionAux) throws Exception {
		//this.planivacacionAux=planivacacionAux;
		
			if(planivacacionAux.getIsChanged()) {
				planivacacionAux.setIsChanged(false);
			}		
			
			if(planivacacionAux.getIsNew()) {
				planivacacionAux.setIsNew(false);
			}	
			
			if(planivacacionAux.getIsDeleted()) {
				planivacacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PlaniVacacion planivacacionAsignar,PlaniVacacion planivacacion) throws Exception {
		planivacacionAsignar.setId(planivacacion.getId());	
		planivacacionAsignar.setVersionRow(planivacacion.getVersionRow());	
		planivacacionAsignar.setid_empresa(planivacacion.getid_empresa());
		planivacacionAsignar.setempresa_descripcion(planivacacion.getempresa_descripcion());	
		planivacacionAsignar.setid_sucursal(planivacacion.getid_sucursal());
		planivacacionAsignar.setsucursal_descripcion(planivacacion.getsucursal_descripcion());	
		planivacacionAsignar.setid_estructura(planivacacion.getid_estructura());
		planivacacionAsignar.setestructura_descripcion(planivacacion.getestructura_descripcion());	
		planivacacionAsignar.setid_estructura_seccion(planivacacion.getid_estructura_seccion());
		planivacacionAsignar.setestructuraseccion_descripcion(planivacacion.getestructuraseccion_descripcion());	
		planivacacionAsignar.setid_estructura_cargo(planivacacion.getid_estructura_cargo());
		planivacacionAsignar.setestructuracargo_descripcion(planivacacion.getestructuracargo_descripcion());	
		planivacacionAsignar.setid_empleado(planivacacion.getid_empleado());
		planivacacionAsignar.setempleado_descripcion(planivacacion.getempleado_descripcion());	
		planivacacionAsignar.setfecha_inicio(planivacacion.getfecha_inicio());	
		planivacacionAsignar.setfecha_fin(planivacacion.getfecha_fin());	
		planivacacionAsignar.setid_mes(planivacacion.getid_mes());
		planivacacionAsignar.setmes_descripcion(planivacacion.getmes_descripcion());	
		planivacacionAsignar.setdias_anio(planivacacion.getdias_anio());	
		planivacacionAsignar.setdias_realizadas(planivacacion.getdias_realizadas());	
		planivacacionAsignar.setdias_pendiente(planivacacion.getdias_pendiente());	
		planivacacionAsignar.setdias_tomados(planivacacion.getdias_tomados());	
		planivacacionAsignar.setdias_anticipadas(planivacacion.getdias_anticipadas());	
		planivacacionAsignar.setdescripcion(planivacacion.getdescripcion());	
	}
	
	public static void inicializarPlaniVacacion(PlaniVacacion planivacacion) throws Exception {
		try {
				planivacacion.setId(0L);	
					
				planivacacion.setid_empresa(-1L);	
				planivacacion.setid_sucursal(-1L);	
				planivacacion.setid_estructura(-1L);	
				planivacacion.setid_estructura_seccion(-1L);	
				planivacacion.setid_estructura_cargo(-1L);	
				planivacacion.setid_empleado(-1L);	
				planivacacion.setfecha_inicio(new Date());	
				planivacacion.setfecha_fin(new Date());	
				planivacacion.setid_mes(null);	
				planivacacion.setdias_anio(0.0);	
				planivacacion.setdias_realizadas(0.0);	
				planivacacion.setdias_pendiente(0.0);	
				planivacacion.setdias_tomados(0.0);	
				planivacacion.setdias_anticipadas(0.0);	
				planivacacion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPlaniVacacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURASECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDESTRUCTURACARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DIASANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DIASREALIZADAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DIASPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DIASTOMADOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DIASANTICIPADAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaniVacacionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPlaniVacacion(String sTipo,Row row,Workbook workbook,PlaniVacacion planivacacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getestructuraseccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getestructuracargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdias_anio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdias_realizadas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdias_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdias_tomados());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdias_anticipadas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planivacacion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPlaniVacacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPlaniVacacion() {
		return this.sFinalQueryPlaniVacacion;
	}
	
	public void setsFinalQueryPlaniVacacion(String sFinalQueryPlaniVacacion) {
		this.sFinalQueryPlaniVacacion= sFinalQueryPlaniVacacion;
	}
	
	public Border resaltarSeleccionarPlaniVacacion=null;
	
	public Border setResaltarSeleccionarPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPlaniVacacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPlaniVacacion() {
		return this.resaltarSeleccionarPlaniVacacion;
	}
	
	public void setResaltarSeleccionarPlaniVacacion(Border borderResaltarSeleccionarPlaniVacacion) {
		this.resaltarSeleccionarPlaniVacacion= borderResaltarSeleccionarPlaniVacacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPlaniVacacion=null;
	public Boolean mostraridPlaniVacacion=true;
	public Boolean activaridPlaniVacacion=true;

	public Border resaltarid_empresaPlaniVacacion=null;
	public Boolean mostrarid_empresaPlaniVacacion=true;
	public Boolean activarid_empresaPlaniVacacion=true;
	public Boolean cargarid_empresaPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalPlaniVacacion=null;
	public Boolean mostrarid_sucursalPlaniVacacion=true;
	public Boolean activarid_sucursalPlaniVacacion=true;
	public Boolean cargarid_sucursalPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarid_estructuraPlaniVacacion=null;
	public Boolean mostrarid_estructuraPlaniVacacion=true;
	public Boolean activarid_estructuraPlaniVacacion=true;
	public Boolean cargarid_estructuraPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarid_estructura_seccionPlaniVacacion=null;
	public Boolean mostrarid_estructura_seccionPlaniVacacion=true;
	public Boolean activarid_estructura_seccionPlaniVacacion=true;
	public Boolean cargarid_estructura_seccionPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructura_seccionPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarid_estructura_cargoPlaniVacacion=null;
	public Boolean mostrarid_estructura_cargoPlaniVacacion=true;
	public Boolean activarid_estructura_cargoPlaniVacacion=true;
	public Boolean cargarid_estructura_cargoPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructura_cargoPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarid_empleadoPlaniVacacion=null;
	public Boolean mostrarid_empleadoPlaniVacacion=true;
	public Boolean activarid_empleadoPlaniVacacion=true;
	public Boolean cargarid_empleadoPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPlaniVacacion=false;//ConEventDepend=true

	public Border resaltarfecha_inicioPlaniVacacion=null;
	public Boolean mostrarfecha_inicioPlaniVacacion=true;
	public Boolean activarfecha_inicioPlaniVacacion=false;

	public Border resaltarfecha_finPlaniVacacion=null;
	public Boolean mostrarfecha_finPlaniVacacion=true;
	public Boolean activarfecha_finPlaniVacacion=false;

	public Border resaltarid_mesPlaniVacacion=null;
	public Boolean mostrarid_mesPlaniVacacion=true;
	public Boolean activarid_mesPlaniVacacion=true;
	public Boolean cargarid_mesPlaniVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPlaniVacacion=false;//ConEventDepend=true

	public Border resaltardias_anioPlaniVacacion=null;
	public Boolean mostrardias_anioPlaniVacacion=true;
	public Boolean activardias_anioPlaniVacacion=true;

	public Border resaltardias_realizadasPlaniVacacion=null;
	public Boolean mostrardias_realizadasPlaniVacacion=true;
	public Boolean activardias_realizadasPlaniVacacion=true;

	public Border resaltardias_pendientePlaniVacacion=null;
	public Boolean mostrardias_pendientePlaniVacacion=true;
	public Boolean activardias_pendientePlaniVacacion=true;

	public Border resaltardias_tomadosPlaniVacacion=null;
	public Boolean mostrardias_tomadosPlaniVacacion=true;
	public Boolean activardias_tomadosPlaniVacacion=true;

	public Border resaltardias_anticipadasPlaniVacacion=null;
	public Boolean mostrardias_anticipadasPlaniVacacion=true;
	public Boolean activardias_anticipadasPlaniVacacion=true;

	public Border resaltardescripcionPlaniVacacion=null;
	public Boolean mostrardescripcionPlaniVacacion=true;
	public Boolean activardescripcionPlaniVacacion=true;

	
	

	public Border setResaltaridPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltaridPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPlaniVacacion() {
		return this.resaltaridPlaniVacacion;
	}

	public void setResaltaridPlaniVacacion(Border borderResaltar) {
		this.resaltaridPlaniVacacion= borderResaltar;
	}

	public Boolean getMostraridPlaniVacacion() {
		return this.mostraridPlaniVacacion;
	}

	public void setMostraridPlaniVacacion(Boolean mostraridPlaniVacacion) {
		this.mostraridPlaniVacacion= mostraridPlaniVacacion;
	}

	public Boolean getActivaridPlaniVacacion() {
		return this.activaridPlaniVacacion;
	}

	public void setActivaridPlaniVacacion(Boolean activaridPlaniVacacion) {
		this.activaridPlaniVacacion= activaridPlaniVacacion;
	}

	public Border setResaltarid_empresaPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPlaniVacacion() {
		return this.resaltarid_empresaPlaniVacacion;
	}

	public void setResaltarid_empresaPlaniVacacion(Border borderResaltar) {
		this.resaltarid_empresaPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaPlaniVacacion() {
		return this.mostrarid_empresaPlaniVacacion;
	}

	public void setMostrarid_empresaPlaniVacacion(Boolean mostrarid_empresaPlaniVacacion) {
		this.mostrarid_empresaPlaniVacacion= mostrarid_empresaPlaniVacacion;
	}

	public Boolean getActivarid_empresaPlaniVacacion() {
		return this.activarid_empresaPlaniVacacion;
	}

	public void setActivarid_empresaPlaniVacacion(Boolean activarid_empresaPlaniVacacion) {
		this.activarid_empresaPlaniVacacion= activarid_empresaPlaniVacacion;
	}

	public Boolean getCargarid_empresaPlaniVacacion() {
		return this.cargarid_empresaPlaniVacacion;
	}

	public void setCargarid_empresaPlaniVacacion(Boolean cargarid_empresaPlaniVacacion) {
		this.cargarid_empresaPlaniVacacion= cargarid_empresaPlaniVacacion;
	}

	public Border setResaltarid_sucursalPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPlaniVacacion() {
		return this.resaltarid_sucursalPlaniVacacion;
	}

	public void setResaltarid_sucursalPlaniVacacion(Border borderResaltar) {
		this.resaltarid_sucursalPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPlaniVacacion() {
		return this.mostrarid_sucursalPlaniVacacion;
	}

	public void setMostrarid_sucursalPlaniVacacion(Boolean mostrarid_sucursalPlaniVacacion) {
		this.mostrarid_sucursalPlaniVacacion= mostrarid_sucursalPlaniVacacion;
	}

	public Boolean getActivarid_sucursalPlaniVacacion() {
		return this.activarid_sucursalPlaniVacacion;
	}

	public void setActivarid_sucursalPlaniVacacion(Boolean activarid_sucursalPlaniVacacion) {
		this.activarid_sucursalPlaniVacacion= activarid_sucursalPlaniVacacion;
	}

	public Boolean getCargarid_sucursalPlaniVacacion() {
		return this.cargarid_sucursalPlaniVacacion;
	}

	public void setCargarid_sucursalPlaniVacacion(Boolean cargarid_sucursalPlaniVacacion) {
		this.cargarid_sucursalPlaniVacacion= cargarid_sucursalPlaniVacacion;
	}

	public Border setResaltarid_estructuraPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_estructuraPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraPlaniVacacion() {
		return this.resaltarid_estructuraPlaniVacacion;
	}

	public void setResaltarid_estructuraPlaniVacacion(Border borderResaltar) {
		this.resaltarid_estructuraPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_estructuraPlaniVacacion() {
		return this.mostrarid_estructuraPlaniVacacion;
	}

	public void setMostrarid_estructuraPlaniVacacion(Boolean mostrarid_estructuraPlaniVacacion) {
		this.mostrarid_estructuraPlaniVacacion= mostrarid_estructuraPlaniVacacion;
	}

	public Boolean getActivarid_estructuraPlaniVacacion() {
		return this.activarid_estructuraPlaniVacacion;
	}

	public void setActivarid_estructuraPlaniVacacion(Boolean activarid_estructuraPlaniVacacion) {
		this.activarid_estructuraPlaniVacacion= activarid_estructuraPlaniVacacion;
	}

	public Boolean getCargarid_estructuraPlaniVacacion() {
		return this.cargarid_estructuraPlaniVacacion;
	}

	public void setCargarid_estructuraPlaniVacacion(Boolean cargarid_estructuraPlaniVacacion) {
		this.cargarid_estructuraPlaniVacacion= cargarid_estructuraPlaniVacacion;
	}

	public Border setResaltarid_estructura_seccionPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_estructura_seccionPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructura_seccionPlaniVacacion() {
		return this.resaltarid_estructura_seccionPlaniVacacion;
	}

	public void setResaltarid_estructura_seccionPlaniVacacion(Border borderResaltar) {
		this.resaltarid_estructura_seccionPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_estructura_seccionPlaniVacacion() {
		return this.mostrarid_estructura_seccionPlaniVacacion;
	}

	public void setMostrarid_estructura_seccionPlaniVacacion(Boolean mostrarid_estructura_seccionPlaniVacacion) {
		this.mostrarid_estructura_seccionPlaniVacacion= mostrarid_estructura_seccionPlaniVacacion;
	}

	public Boolean getActivarid_estructura_seccionPlaniVacacion() {
		return this.activarid_estructura_seccionPlaniVacacion;
	}

	public void setActivarid_estructura_seccionPlaniVacacion(Boolean activarid_estructura_seccionPlaniVacacion) {
		this.activarid_estructura_seccionPlaniVacacion= activarid_estructura_seccionPlaniVacacion;
	}

	public Boolean getCargarid_estructura_seccionPlaniVacacion() {
		return this.cargarid_estructura_seccionPlaniVacacion;
	}

	public void setCargarid_estructura_seccionPlaniVacacion(Boolean cargarid_estructura_seccionPlaniVacacion) {
		this.cargarid_estructura_seccionPlaniVacacion= cargarid_estructura_seccionPlaniVacacion;
	}

	public Border setResaltarid_estructura_cargoPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_estructura_cargoPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructura_cargoPlaniVacacion() {
		return this.resaltarid_estructura_cargoPlaniVacacion;
	}

	public void setResaltarid_estructura_cargoPlaniVacacion(Border borderResaltar) {
		this.resaltarid_estructura_cargoPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_estructura_cargoPlaniVacacion() {
		return this.mostrarid_estructura_cargoPlaniVacacion;
	}

	public void setMostrarid_estructura_cargoPlaniVacacion(Boolean mostrarid_estructura_cargoPlaniVacacion) {
		this.mostrarid_estructura_cargoPlaniVacacion= mostrarid_estructura_cargoPlaniVacacion;
	}

	public Boolean getActivarid_estructura_cargoPlaniVacacion() {
		return this.activarid_estructura_cargoPlaniVacacion;
	}

	public void setActivarid_estructura_cargoPlaniVacacion(Boolean activarid_estructura_cargoPlaniVacacion) {
		this.activarid_estructura_cargoPlaniVacacion= activarid_estructura_cargoPlaniVacacion;
	}

	public Boolean getCargarid_estructura_cargoPlaniVacacion() {
		return this.cargarid_estructura_cargoPlaniVacacion;
	}

	public void setCargarid_estructura_cargoPlaniVacacion(Boolean cargarid_estructura_cargoPlaniVacacion) {
		this.cargarid_estructura_cargoPlaniVacacion= cargarid_estructura_cargoPlaniVacacion;
	}

	public Border setResaltarid_empleadoPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPlaniVacacion() {
		return this.resaltarid_empleadoPlaniVacacion;
	}

	public void setResaltarid_empleadoPlaniVacacion(Border borderResaltar) {
		this.resaltarid_empleadoPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPlaniVacacion() {
		return this.mostrarid_empleadoPlaniVacacion;
	}

	public void setMostrarid_empleadoPlaniVacacion(Boolean mostrarid_empleadoPlaniVacacion) {
		this.mostrarid_empleadoPlaniVacacion= mostrarid_empleadoPlaniVacacion;
	}

	public Boolean getActivarid_empleadoPlaniVacacion() {
		return this.activarid_empleadoPlaniVacacion;
	}

	public void setActivarid_empleadoPlaniVacacion(Boolean activarid_empleadoPlaniVacacion) {
		this.activarid_empleadoPlaniVacacion= activarid_empleadoPlaniVacacion;
	}

	public Boolean getCargarid_empleadoPlaniVacacion() {
		return this.cargarid_empleadoPlaniVacacion;
	}

	public void setCargarid_empleadoPlaniVacacion(Boolean cargarid_empleadoPlaniVacacion) {
		this.cargarid_empleadoPlaniVacacion= cargarid_empleadoPlaniVacacion;
	}

	public Border setResaltarfecha_inicioPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioPlaniVacacion() {
		return this.resaltarfecha_inicioPlaniVacacion;
	}

	public void setResaltarfecha_inicioPlaniVacacion(Border borderResaltar) {
		this.resaltarfecha_inicioPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioPlaniVacacion() {
		return this.mostrarfecha_inicioPlaniVacacion;
	}

	public void setMostrarfecha_inicioPlaniVacacion(Boolean mostrarfecha_inicioPlaniVacacion) {
		this.mostrarfecha_inicioPlaniVacacion= mostrarfecha_inicioPlaniVacacion;
	}

	public Boolean getActivarfecha_inicioPlaniVacacion() {
		return this.activarfecha_inicioPlaniVacacion;
	}

	public void setActivarfecha_inicioPlaniVacacion(Boolean activarfecha_inicioPlaniVacacion) {
		this.activarfecha_inicioPlaniVacacion= activarfecha_inicioPlaniVacacion;
	}

	public Border setResaltarfecha_finPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarfecha_finPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finPlaniVacacion() {
		return this.resaltarfecha_finPlaniVacacion;
	}

	public void setResaltarfecha_finPlaniVacacion(Border borderResaltar) {
		this.resaltarfecha_finPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarfecha_finPlaniVacacion() {
		return this.mostrarfecha_finPlaniVacacion;
	}

	public void setMostrarfecha_finPlaniVacacion(Boolean mostrarfecha_finPlaniVacacion) {
		this.mostrarfecha_finPlaniVacacion= mostrarfecha_finPlaniVacacion;
	}

	public Boolean getActivarfecha_finPlaniVacacion() {
		return this.activarfecha_finPlaniVacacion;
	}

	public void setActivarfecha_finPlaniVacacion(Boolean activarfecha_finPlaniVacacion) {
		this.activarfecha_finPlaniVacacion= activarfecha_finPlaniVacacion;
	}

	public Border setResaltarid_mesPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltarid_mesPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPlaniVacacion() {
		return this.resaltarid_mesPlaniVacacion;
	}

	public void setResaltarid_mesPlaniVacacion(Border borderResaltar) {
		this.resaltarid_mesPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrarid_mesPlaniVacacion() {
		return this.mostrarid_mesPlaniVacacion;
	}

	public void setMostrarid_mesPlaniVacacion(Boolean mostrarid_mesPlaniVacacion) {
		this.mostrarid_mesPlaniVacacion= mostrarid_mesPlaniVacacion;
	}

	public Boolean getActivarid_mesPlaniVacacion() {
		return this.activarid_mesPlaniVacacion;
	}

	public void setActivarid_mesPlaniVacacion(Boolean activarid_mesPlaniVacacion) {
		this.activarid_mesPlaniVacacion= activarid_mesPlaniVacacion;
	}

	public Boolean getCargarid_mesPlaniVacacion() {
		return this.cargarid_mesPlaniVacacion;
	}

	public void setCargarid_mesPlaniVacacion(Boolean cargarid_mesPlaniVacacion) {
		this.cargarid_mesPlaniVacacion= cargarid_mesPlaniVacacion;
	}

	public Border setResaltardias_anioPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardias_anioPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_anioPlaniVacacion() {
		return this.resaltardias_anioPlaniVacacion;
	}

	public void setResaltardias_anioPlaniVacacion(Border borderResaltar) {
		this.resaltardias_anioPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardias_anioPlaniVacacion() {
		return this.mostrardias_anioPlaniVacacion;
	}

	public void setMostrardias_anioPlaniVacacion(Boolean mostrardias_anioPlaniVacacion) {
		this.mostrardias_anioPlaniVacacion= mostrardias_anioPlaniVacacion;
	}

	public Boolean getActivardias_anioPlaniVacacion() {
		return this.activardias_anioPlaniVacacion;
	}

	public void setActivardias_anioPlaniVacacion(Boolean activardias_anioPlaniVacacion) {
		this.activardias_anioPlaniVacacion= activardias_anioPlaniVacacion;
	}

	public Border setResaltardias_realizadasPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardias_realizadasPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_realizadasPlaniVacacion() {
		return this.resaltardias_realizadasPlaniVacacion;
	}

	public void setResaltardias_realizadasPlaniVacacion(Border borderResaltar) {
		this.resaltardias_realizadasPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardias_realizadasPlaniVacacion() {
		return this.mostrardias_realizadasPlaniVacacion;
	}

	public void setMostrardias_realizadasPlaniVacacion(Boolean mostrardias_realizadasPlaniVacacion) {
		this.mostrardias_realizadasPlaniVacacion= mostrardias_realizadasPlaniVacacion;
	}

	public Boolean getActivardias_realizadasPlaniVacacion() {
		return this.activardias_realizadasPlaniVacacion;
	}

	public void setActivardias_realizadasPlaniVacacion(Boolean activardias_realizadasPlaniVacacion) {
		this.activardias_realizadasPlaniVacacion= activardias_realizadasPlaniVacacion;
	}

	public Border setResaltardias_pendientePlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardias_pendientePlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_pendientePlaniVacacion() {
		return this.resaltardias_pendientePlaniVacacion;
	}

	public void setResaltardias_pendientePlaniVacacion(Border borderResaltar) {
		this.resaltardias_pendientePlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardias_pendientePlaniVacacion() {
		return this.mostrardias_pendientePlaniVacacion;
	}

	public void setMostrardias_pendientePlaniVacacion(Boolean mostrardias_pendientePlaniVacacion) {
		this.mostrardias_pendientePlaniVacacion= mostrardias_pendientePlaniVacacion;
	}

	public Boolean getActivardias_pendientePlaniVacacion() {
		return this.activardias_pendientePlaniVacacion;
	}

	public void setActivardias_pendientePlaniVacacion(Boolean activardias_pendientePlaniVacacion) {
		this.activardias_pendientePlaniVacacion= activardias_pendientePlaniVacacion;
	}

	public Border setResaltardias_tomadosPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardias_tomadosPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_tomadosPlaniVacacion() {
		return this.resaltardias_tomadosPlaniVacacion;
	}

	public void setResaltardias_tomadosPlaniVacacion(Border borderResaltar) {
		this.resaltardias_tomadosPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardias_tomadosPlaniVacacion() {
		return this.mostrardias_tomadosPlaniVacacion;
	}

	public void setMostrardias_tomadosPlaniVacacion(Boolean mostrardias_tomadosPlaniVacacion) {
		this.mostrardias_tomadosPlaniVacacion= mostrardias_tomadosPlaniVacacion;
	}

	public Boolean getActivardias_tomadosPlaniVacacion() {
		return this.activardias_tomadosPlaniVacacion;
	}

	public void setActivardias_tomadosPlaniVacacion(Boolean activardias_tomadosPlaniVacacion) {
		this.activardias_tomadosPlaniVacacion= activardias_tomadosPlaniVacacion;
	}

	public Border setResaltardias_anticipadasPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardias_anticipadasPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_anticipadasPlaniVacacion() {
		return this.resaltardias_anticipadasPlaniVacacion;
	}

	public void setResaltardias_anticipadasPlaniVacacion(Border borderResaltar) {
		this.resaltardias_anticipadasPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardias_anticipadasPlaniVacacion() {
		return this.mostrardias_anticipadasPlaniVacacion;
	}

	public void setMostrardias_anticipadasPlaniVacacion(Boolean mostrardias_anticipadasPlaniVacacion) {
		this.mostrardias_anticipadasPlaniVacacion= mostrardias_anticipadasPlaniVacacion;
	}

	public Boolean getActivardias_anticipadasPlaniVacacion() {
		return this.activardias_anticipadasPlaniVacacion;
	}

	public void setActivardias_anticipadasPlaniVacacion(Boolean activardias_anticipadasPlaniVacacion) {
		this.activardias_anticipadasPlaniVacacion= activardias_anticipadasPlaniVacacion;
	}

	public Border setResaltardescripcionPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planivacacionBeanSwingJInternalFrame.jTtoolBarPlaniVacacion.setBorder(borderResaltar);
		
		this.resaltardescripcionPlaniVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPlaniVacacion() {
		return this.resaltardescripcionPlaniVacacion;
	}

	public void setResaltardescripcionPlaniVacacion(Border borderResaltar) {
		this.resaltardescripcionPlaniVacacion= borderResaltar;
	}

	public Boolean getMostrardescripcionPlaniVacacion() {
		return this.mostrardescripcionPlaniVacacion;
	}

	public void setMostrardescripcionPlaniVacacion(Boolean mostrardescripcionPlaniVacacion) {
		this.mostrardescripcionPlaniVacacion= mostrardescripcionPlaniVacacion;
	}

	public Boolean getActivardescripcionPlaniVacacion() {
		return this.activardescripcionPlaniVacacion;
	}

	public void setActivardescripcionPlaniVacacion(Boolean activardescripcionPlaniVacacion) {
		this.activardescripcionPlaniVacacion= activardescripcionPlaniVacacion;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridPlaniVacacion(esInicial);
		this.setMostrarid_empresaPlaniVacacion(esInicial);
		this.setMostrarid_sucursalPlaniVacacion(esInicial);
		this.setMostrarid_estructuraPlaniVacacion(esInicial);
		this.setMostrarid_estructura_seccionPlaniVacacion(esInicial);
		this.setMostrarid_estructura_cargoPlaniVacacion(esInicial);
		this.setMostrarid_empleadoPlaniVacacion(esInicial);
		this.setMostrarfecha_inicioPlaniVacacion(esInicial);
		this.setMostrarfecha_finPlaniVacacion(esInicial);
		this.setMostrarid_mesPlaniVacacion(esInicial);
		this.setMostrardias_anioPlaniVacacion(esInicial);
		this.setMostrardias_realizadasPlaniVacacion(esInicial);
		this.setMostrardias_pendientePlaniVacacion(esInicial);
		this.setMostrardias_tomadosPlaniVacacion(esInicial);
		this.setMostrardias_anticipadasPlaniVacacion(esInicial);
		this.setMostrardescripcionPlaniVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.ID)) {
				this.setMostraridPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setMostrarid_estructura_seccionPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO)) {
				this.setMostrarid_estructura_cargoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANIO)) {
				this.setMostrardias_anioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASREALIZADAS)) {
				this.setMostrardias_realizadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASPENDIENTE)) {
				this.setMostrardias_pendientePlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASTOMADOS)) {
				this.setMostrardias_tomadosPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANTICIPADAS)) {
				this.setMostrardias_anticipadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPlaniVacacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridPlaniVacacion(esInicial);
		this.setActivarid_empresaPlaniVacacion(esInicial);
		this.setActivarid_sucursalPlaniVacacion(esInicial);
		this.setActivarid_estructuraPlaniVacacion(esInicial);
		this.setActivarid_estructura_seccionPlaniVacacion(esInicial);
		this.setActivarid_estructura_cargoPlaniVacacion(esInicial);
		this.setActivarid_empleadoPlaniVacacion(esInicial);
		this.setActivarfecha_inicioPlaniVacacion(esInicial);
		this.setActivarfecha_finPlaniVacacion(esInicial);
		this.setActivarid_mesPlaniVacacion(esInicial);
		this.setActivardias_anioPlaniVacacion(esInicial);
		this.setActivardias_realizadasPlaniVacacion(esInicial);
		this.setActivardias_pendientePlaniVacacion(esInicial);
		this.setActivardias_tomadosPlaniVacacion(esInicial);
		this.setActivardias_anticipadasPlaniVacacion(esInicial);
		this.setActivardescripcionPlaniVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.ID)) {
				this.setActivaridPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setActivarid_estructura_seccionPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO)) {
				this.setActivarid_estructura_cargoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDMES)) {
				this.setActivarid_mesPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANIO)) {
				this.setActivardias_anioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASREALIZADAS)) {
				this.setActivardias_realizadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASPENDIENTE)) {
				this.setActivardias_pendientePlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASTOMADOS)) {
				this.setActivardias_tomadosPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANTICIPADAS)) {
				this.setActivardias_anticipadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPlaniVacacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPlaniVacacion(esInicial);
		this.setResaltarid_empresaPlaniVacacion(esInicial);
		this.setResaltarid_sucursalPlaniVacacion(esInicial);
		this.setResaltarid_estructuraPlaniVacacion(esInicial);
		this.setResaltarid_estructura_seccionPlaniVacacion(esInicial);
		this.setResaltarid_estructura_cargoPlaniVacacion(esInicial);
		this.setResaltarid_empleadoPlaniVacacion(esInicial);
		this.setResaltarfecha_inicioPlaniVacacion(esInicial);
		this.setResaltarfecha_finPlaniVacacion(esInicial);
		this.setResaltarid_mesPlaniVacacion(esInicial);
		this.setResaltardias_anioPlaniVacacion(esInicial);
		this.setResaltardias_realizadasPlaniVacacion(esInicial);
		this.setResaltardias_pendientePlaniVacacion(esInicial);
		this.setResaltardias_tomadosPlaniVacacion(esInicial);
		this.setResaltardias_anticipadasPlaniVacacion(esInicial);
		this.setResaltardescripcionPlaniVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.ID)) {
				this.setResaltaridPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setResaltarid_estructura_seccionPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO)) {
				this.setResaltarid_estructura_cargoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANIO)) {
				this.setResaltardias_anioPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASREALIZADAS)) {
				this.setResaltardias_realizadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASPENDIENTE)) {
				this.setResaltardias_pendientePlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASTOMADOS)) {
				this.setResaltardias_tomadosPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DIASANTICIPADAS)) {
				this.setResaltardias_anticipadasPlaniVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaniVacacionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPlaniVacacion(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpleadoPlaniVacacion=true;

	public Boolean getMostrarFK_IdEmpleadoPlaniVacacion() {
		return this.mostrarFK_IdEmpleadoPlaniVacacion;
	}

	public void setMostrarFK_IdEmpleadoPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPlaniVacacion=true;

	public Boolean getMostrarFK_IdEmpresaPlaniVacacion() {
		return this.mostrarFK_IdEmpresaPlaniVacacion;
	}

	public void setMostrarFK_IdEmpresaPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraPlaniVacacion=true;

	public Boolean getMostrarFK_IdEstructuraPlaniVacacion() {
		return this.mostrarFK_IdEstructuraPlaniVacacion;
	}

	public void setMostrarFK_IdEstructuraPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraCargoPlaniVacacion=true;

	public Boolean getMostrarFK_IdEstructuraCargoPlaniVacacion() {
		return this.mostrarFK_IdEstructuraCargoPlaniVacacion;
	}

	public void setMostrarFK_IdEstructuraCargoPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraCargoPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSeccionPlaniVacacion=true;

	public Boolean getMostrarFK_IdEstructuraSeccionPlaniVacacion() {
		return this.mostrarFK_IdEstructuraSeccionPlaniVacacion;
	}

	public void setMostrarFK_IdEstructuraSeccionPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSeccionPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesPlaniVacacion=true;

	public Boolean getMostrarFK_IdMesPlaniVacacion() {
		return this.mostrarFK_IdMesPlaniVacacion;
	}

	public void setMostrarFK_IdMesPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesPlaniVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPlaniVacacion=true;

	public Boolean getMostrarFK_IdSucursalPlaniVacacion() {
		return this.mostrarFK_IdSucursalPlaniVacacion;
	}

	public void setMostrarFK_IdSucursalPlaniVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPlaniVacacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoPlaniVacacion=true;

	public Boolean getActivarFK_IdEmpleadoPlaniVacacion() {
		return this.activarFK_IdEmpleadoPlaniVacacion;
	}

	public void setActivarFK_IdEmpleadoPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPlaniVacacion=true;

	public Boolean getActivarFK_IdEmpresaPlaniVacacion() {
		return this.activarFK_IdEmpresaPlaniVacacion;
	}

	public void setActivarFK_IdEmpresaPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraPlaniVacacion=true;

	public Boolean getActivarFK_IdEstructuraPlaniVacacion() {
		return this.activarFK_IdEstructuraPlaniVacacion;
	}

	public void setActivarFK_IdEstructuraPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraCargoPlaniVacacion=true;

	public Boolean getActivarFK_IdEstructuraCargoPlaniVacacion() {
		return this.activarFK_IdEstructuraCargoPlaniVacacion;
	}

	public void setActivarFK_IdEstructuraCargoPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraCargoPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSeccionPlaniVacacion=true;

	public Boolean getActivarFK_IdEstructuraSeccionPlaniVacacion() {
		return this.activarFK_IdEstructuraSeccionPlaniVacacion;
	}

	public void setActivarFK_IdEstructuraSeccionPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSeccionPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdMesPlaniVacacion=true;

	public Boolean getActivarFK_IdMesPlaniVacacion() {
		return this.activarFK_IdMesPlaniVacacion;
	}

	public void setActivarFK_IdMesPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdMesPlaniVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPlaniVacacion=true;

	public Boolean getActivarFK_IdSucursalPlaniVacacion() {
		return this.activarFK_IdSucursalPlaniVacacion;
	}

	public void setActivarFK_IdSucursalPlaniVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPlaniVacacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoPlaniVacacion=null;

	public Border getResaltarFK_IdEmpleadoPlaniVacacion() {
		return this.resaltarFK_IdEmpleadoPlaniVacacion;
	}

	public void setResaltarFK_IdEmpleadoPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPlaniVacacion=null;

	public Border getResaltarFK_IdEmpresaPlaniVacacion() {
		return this.resaltarFK_IdEmpresaPlaniVacacion;
	}

	public void setResaltarFK_IdEmpresaPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraPlaniVacacion=null;

	public Border getResaltarFK_IdEstructuraPlaniVacacion() {
		return this.resaltarFK_IdEstructuraPlaniVacacion;
	}

	public void setResaltarFK_IdEstructuraPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdEstructuraPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraCargoPlaniVacacion=null;

	public Border getResaltarFK_IdEstructuraCargoPlaniVacacion() {
		return this.resaltarFK_IdEstructuraCargoPlaniVacacion;
	}

	public void setResaltarFK_IdEstructuraCargoPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdEstructuraCargoPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraCargoPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraCargoPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSeccionPlaniVacacion=null;

	public Border getResaltarFK_IdEstructuraSeccionPlaniVacacion() {
		return this.resaltarFK_IdEstructuraSeccionPlaniVacacion;
	}

	public void setResaltarFK_IdEstructuraSeccionPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSeccionPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSeccionPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSeccionPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdMesPlaniVacacion=null;

	public Border getResaltarFK_IdMesPlaniVacacion() {
		return this.resaltarFK_IdMesPlaniVacacion;
	}

	public void setResaltarFK_IdMesPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdMesPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdMesPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesPlaniVacacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPlaniVacacion=null;

	public Border getResaltarFK_IdSucursalPlaniVacacion() {
		return this.resaltarFK_IdSucursalPlaniVacacion;
	}

	public void setResaltarFK_IdSucursalPlaniVacacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalPlaniVacacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPlaniVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*PlaniVacacionBeanSwingJInternalFrame planivacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPlaniVacacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
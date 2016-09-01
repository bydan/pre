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


import com.bydan.erp.nomina.util.AsistenciaMensualConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaMensualParameterGeneral;

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
final public class AsistenciaMensualConstantesFunciones extends AsistenciaMensualConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AsistenciaMensual";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AsistenciaMensual"+AsistenciaMensualConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AsistenciaMensualHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AsistenciaMensualHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AsistenciaMensualConstantesFunciones.SCHEMA+"_"+AsistenciaMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AsistenciaMensualConstantesFunciones.SCHEMA+"_"+AsistenciaMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AsistenciaMensualConstantesFunciones.SCHEMA+"_"+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AsistenciaMensualConstantesFunciones.SCHEMA+"_"+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AsistenciaMensualConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AsistenciaMensualConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AsistenciaMensualConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AsistenciaMensualConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asistencia Mensuales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Asistencia Mensual";
	public static final String SCLASSWEBTITULO_LOWER="Asistencia Mensual";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AsistenciaMensual";
	public static final String OBJECTNAME="asistenciamensual";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="asistencia_mensual";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select asistenciamensual from "+AsistenciaMensualConstantesFunciones.SPERSISTENCENAME+" asistenciamensual";
	public static String QUERYSELECTNATIVE="select "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".version_row,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_cargo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_estructura,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_anio,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_mes,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".fecha,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_trabajo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_atraso,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_faltas,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_permiso,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra25,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra50,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra100,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra150,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra0,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_enfermo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_maternidad,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_vacacion,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_dias,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_noches,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_feriados,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_trabajo from "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME;//+" as "+AsistenciaMensualConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AsistenciaMensualConstantesFuncionesAdditional asistenciamensualConstantesFuncionesAdditional=null;
	
	public AsistenciaMensualConstantesFuncionesAdditional getAsistenciaMensualConstantesFuncionesAdditional() {
		return this.asistenciamensualConstantesFuncionesAdditional;
	}
	
	public void setAsistenciaMensualConstantesFuncionesAdditional(AsistenciaMensualConstantesFuncionesAdditional asistenciamensualConstantesFuncionesAdditional) {
		try {
			this.asistenciamensualConstantesFuncionesAdditional=asistenciamensualConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDCARGO= "id_cargo";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String FECHA= "fecha";
    public static final String HORASTRABAJO= "horas_trabajo";
    public static final String HORASATRASO= "horas_atraso";
    public static final String HORASFALTAS= "horas_faltas";
    public static final String HORASPERMISO= "horas_permiso";
    public static final String HORASEXTRA25= "horas_extra25";
    public static final String HORASEXTRA50= "horas_extra50";
    public static final String HORASEXTRA100= "horas_extra100";
    public static final String HORASEXTRA150= "horas_extra150";
    public static final String HORASEXTRA0= "horas_extra0";
    public static final String HORASENFERMO= "horas_enfermo";
    public static final String HORASMATERNIDAD= "horas_maternidad";
    public static final String HORASVACACION= "horas_vacacion";
    public static final String NUMERODIAS= "numero_dias";
    public static final String NUMERONOCHES= "numero_noches";
    public static final String NUMEROFERIADOS= "numero_feriados";
    public static final String NUMEROTRABAJO= "numero_trabajo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDCARGO= "Cargo";
		public static final String LABEL_IDCARGO_LOWER= "Cargo";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORASTRABAJO= "Horas Trabajo";
		public static final String LABEL_HORASTRABAJO_LOWER= "Horas Trabajo";
    	public static final String LABEL_HORASATRASO= "Horas Atraso";
		public static final String LABEL_HORASATRASO_LOWER= "Horas Atraso";
    	public static final String LABEL_HORASFALTAS= "Horas Faltas";
		public static final String LABEL_HORASFALTAS_LOWER= "Horas Faltas";
    	public static final String LABEL_HORASPERMISO= "Horas Permiso";
		public static final String LABEL_HORASPERMISO_LOWER= "Horas Permiso";
    	public static final String LABEL_HORASEXTRA25= "Horas Extra25";
		public static final String LABEL_HORASEXTRA25_LOWER= "Horas Extra25";
    	public static final String LABEL_HORASEXTRA50= "Horas Extra50";
		public static final String LABEL_HORASEXTRA50_LOWER= "Horas Extra50";
    	public static final String LABEL_HORASEXTRA100= "Horas Extra100";
		public static final String LABEL_HORASEXTRA100_LOWER= "Horas Extra100";
    	public static final String LABEL_HORASEXTRA150= "Horas Extra150";
		public static final String LABEL_HORASEXTRA150_LOWER= "Horas Extra150";
    	public static final String LABEL_HORASEXTRA0= "Horas Extra0";
		public static final String LABEL_HORASEXTRA0_LOWER= "Horas Extra0";
    	public static final String LABEL_HORASENFERMO= "Horas Enfermo";
		public static final String LABEL_HORASENFERMO_LOWER= "Horas Enfermo";
    	public static final String LABEL_HORASMATERNIDAD= "Horas Maternidad";
		public static final String LABEL_HORASMATERNIDAD_LOWER= "Horas Maternidad";
    	public static final String LABEL_HORASVACACION= "Horas Vacacion";
		public static final String LABEL_HORASVACACION_LOWER= "Horas Vacacion";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_NUMERONOCHES= "Numero Noches";
		public static final String LABEL_NUMERONOCHES_LOWER= "Numero Noches";
    	public static final String LABEL_NUMEROFERIADOS= "Numero Feriados";
		public static final String LABEL_NUMEROFERIADOS_LOWER= "Numero Feriados";
    	public static final String LABEL_NUMEROTRABAJO= "Numero Trabajo";
		public static final String LABEL_NUMEROTRABAJO_LOWER= "Numero Trabajo";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getAsistenciaMensualLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDEMPRESA)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDCARGO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDANIO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.IDMES)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.FECHA)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASTRABAJO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASATRASO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASFALTAS)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASPERMISO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA25)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA50)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA100)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA150)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA0)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASENFERMO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.HORASVACACION)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.NUMERODIAS)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.NUMERONOCHES)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS;}
		if(sNombreColumna.equals(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO)) {sLabelColumna=AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAsistenciaMensualDescripcion(AsistenciaMensual asistenciamensual) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(asistenciamensual !=null/* && asistenciamensual.getId()!=0*/) {
			if(asistenciamensual.getId()!=null) {
				sDescripcion=asistenciamensual.getId().toString();
			}//asistenciamensualasistenciamensual.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAsistenciaMensualDescripcionDetallado(AsistenciaMensual asistenciamensual) {
		String sDescripcion="";
			
		sDescripcion+=AsistenciaMensualConstantesFunciones.ID+"=";
		sDescripcion+=asistenciamensual.getId().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=asistenciamensual.getVersionRow().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=asistenciamensual.getid_empresa().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=asistenciamensual.getid_empleado().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDCARGO+"=";
		sDescripcion+=asistenciamensual.getid_cargo().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=asistenciamensual.getid_estructura().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDANIO+"=";
		sDescripcion+=asistenciamensual.getid_anio().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.IDMES+"=";
		sDescripcion+=asistenciamensual.getid_mes().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.FECHA+"=";
		sDescripcion+=asistenciamensual.getfecha().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASTRABAJO+"=";
		sDescripcion+=asistenciamensual.gethoras_trabajo().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASATRASO+"=";
		sDescripcion+=asistenciamensual.gethoras_atraso().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASFALTAS+"=";
		sDescripcion+=asistenciamensual.gethoras_faltas().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASPERMISO+"=";
		sDescripcion+=asistenciamensual.gethoras_permiso().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASEXTRA25+"=";
		sDescripcion+=asistenciamensual.gethoras_extra25().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASEXTRA50+"=";
		sDescripcion+=asistenciamensual.gethoras_extra50().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASEXTRA100+"=";
		sDescripcion+=asistenciamensual.gethoras_extra100().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASEXTRA150+"=";
		sDescripcion+=asistenciamensual.gethoras_extra150().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASEXTRA0+"=";
		sDescripcion+=asistenciamensual.gethoras_extra0().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASENFERMO+"=";
		sDescripcion+=asistenciamensual.gethoras_enfermo().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASMATERNIDAD+"=";
		sDescripcion+=asistenciamensual.gethoras_maternidad().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.HORASVACACION+"=";
		sDescripcion+=asistenciamensual.gethoras_vacacion().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=asistenciamensual.getnumero_dias().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.NUMERONOCHES+"=";
		sDescripcion+=asistenciamensual.getnumero_noches().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.NUMEROFERIADOS+"=";
		sDescripcion+=asistenciamensual.getnumero_feriados().toString()+",";
		sDescripcion+=AsistenciaMensualConstantesFunciones.NUMEROTRABAJO+"=";
		sDescripcion+=asistenciamensual.getnumero_trabajo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAsistenciaMensualDescripcion(AsistenciaMensual asistenciamensual,String sValor) throws Exception {			
		if(asistenciamensual !=null) {
			//asistenciamensualasistenciamensual.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCargoDescripcion(Cargo cargo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cargo!=null/*&&cargo.getId()>0*/) {
			sDescripcion=CargoConstantesFunciones.getCargoDescripcion(cargo);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
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
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por Cargo";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCargo(Long id_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAsistenciaMensual(AsistenciaMensual asistenciamensual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaMensual(AsistenciaMensual asistenciamensual,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && asistenciamensual.getConCambioAuxiliar()) {
			asistenciamensual.setIsDeleted(asistenciamensual.getIsDeletedAuxiliar());	
			asistenciamensual.setIsNew(asistenciamensual.getIsNewAuxiliar());	
			asistenciamensual.setIsChanged(asistenciamensual.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			asistenciamensual.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			asistenciamensual.setIsDeletedAuxiliar(false);	
			asistenciamensual.setIsNewAuxiliar(false);	
			asistenciamensual.setIsChangedAuxiliar(false);
			
			asistenciamensual.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AsistenciaMensual asistenciamensual : asistenciamensuals) {
			if(conAsignarBase && asistenciamensual.getConCambioAuxiliar()) {
				asistenciamensual.setIsDeleted(asistenciamensual.getIsDeletedAuxiliar());	
				asistenciamensual.setIsNew(asistenciamensual.getIsNewAuxiliar());	
				asistenciamensual.setIsChanged(asistenciamensual.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				asistenciamensual.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				asistenciamensual.setIsDeletedAuxiliar(false);	
				asistenciamensual.setIsNewAuxiliar(false);	
				asistenciamensual.setIsChangedAuxiliar(false);
				
				asistenciamensual.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAsistenciaMensual(AsistenciaMensual asistenciamensual,Boolean conEnteros) throws Exception  {
		asistenciamensual.sethoras_trabajo(0.0);
		asistenciamensual.sethoras_atraso(0.0);
		asistenciamensual.sethoras_faltas(0.0);
		asistenciamensual.sethoras_permiso(0.0);
		asistenciamensual.sethoras_extra25(0.0);
		asistenciamensual.sethoras_extra50(0.0);
		asistenciamensual.sethoras_extra100(0.0);
		asistenciamensual.sethoras_extra150(0.0);
		asistenciamensual.sethoras_extra0(0.0);
		asistenciamensual.sethoras_enfermo(0.0);
		asistenciamensual.sethoras_maternidad(0.0);
		asistenciamensual.sethoras_vacacion(0.0);
		asistenciamensual.setnumero_dias(0.0);
		asistenciamensual.setnumero_noches(0.0);
		asistenciamensual.setnumero_feriados(0.0);
		asistenciamensual.setnumero_trabajo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals,Boolean conEnteros) throws Exception  {
		
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {
			asistenciamensual.sethoras_trabajo(0.0);
			asistenciamensual.sethoras_atraso(0.0);
			asistenciamensual.sethoras_faltas(0.0);
			asistenciamensual.sethoras_permiso(0.0);
			asistenciamensual.sethoras_extra25(0.0);
			asistenciamensual.sethoras_extra50(0.0);
			asistenciamensual.sethoras_extra100(0.0);
			asistenciamensual.sethoras_extra150(0.0);
			asistenciamensual.sethoras_extra0(0.0);
			asistenciamensual.sethoras_enfermo(0.0);
			asistenciamensual.sethoras_maternidad(0.0);
			asistenciamensual.sethoras_vacacion(0.0);
			asistenciamensual.setnumero_dias(0.0);
			asistenciamensual.setnumero_noches(0.0);
			asistenciamensual.setnumero_feriados(0.0);
			asistenciamensual.setnumero_trabajo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAsistenciaMensual(List<AsistenciaMensual> asistenciamensuals,AsistenciaMensual asistenciamensualAux) throws Exception  {
		AsistenciaMensualConstantesFunciones.InicializarValoresAsistenciaMensual(asistenciamensualAux,true);
		
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {
			if(asistenciamensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			asistenciamensualAux.sethoras_trabajo(asistenciamensualAux.gethoras_trabajo()+asistenciamensual.gethoras_trabajo());			
			asistenciamensualAux.sethoras_atraso(asistenciamensualAux.gethoras_atraso()+asistenciamensual.gethoras_atraso());			
			asistenciamensualAux.sethoras_faltas(asistenciamensualAux.gethoras_faltas()+asistenciamensual.gethoras_faltas());			
			asistenciamensualAux.sethoras_permiso(asistenciamensualAux.gethoras_permiso()+asistenciamensual.gethoras_permiso());			
			asistenciamensualAux.sethoras_extra25(asistenciamensualAux.gethoras_extra25()+asistenciamensual.gethoras_extra25());			
			asistenciamensualAux.sethoras_extra50(asistenciamensualAux.gethoras_extra50()+asistenciamensual.gethoras_extra50());			
			asistenciamensualAux.sethoras_extra100(asistenciamensualAux.gethoras_extra100()+asistenciamensual.gethoras_extra100());			
			asistenciamensualAux.sethoras_extra150(asistenciamensualAux.gethoras_extra150()+asistenciamensual.gethoras_extra150());			
			asistenciamensualAux.sethoras_extra0(asistenciamensualAux.gethoras_extra0()+asistenciamensual.gethoras_extra0());			
			asistenciamensualAux.sethoras_enfermo(asistenciamensualAux.gethoras_enfermo()+asistenciamensual.gethoras_enfermo());			
			asistenciamensualAux.sethoras_maternidad(asistenciamensualAux.gethoras_maternidad()+asistenciamensual.gethoras_maternidad());			
			asistenciamensualAux.sethoras_vacacion(asistenciamensualAux.gethoras_vacacion()+asistenciamensual.gethoras_vacacion());			
			asistenciamensualAux.setnumero_dias(asistenciamensualAux.getnumero_dias()+asistenciamensual.getnumero_dias());			
			asistenciamensualAux.setnumero_noches(asistenciamensualAux.getnumero_noches()+asistenciamensual.getnumero_noches());			
			asistenciamensualAux.setnumero_feriados(asistenciamensualAux.getnumero_feriados()+asistenciamensual.getnumero_feriados());			
			asistenciamensualAux.setnumero_trabajo(asistenciamensualAux.getnumero_trabajo()+asistenciamensual.getnumero_trabajo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AsistenciaMensualConstantesFunciones.getArrayColumnasGlobalesAsistenciaMensual(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaMensual(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsistenciaMensualConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsistenciaMensualConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAsistenciaMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsistenciaMensual> asistenciamensuals,AsistenciaMensual asistenciamensual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsistenciaMensual asistenciamensualAux: asistenciamensuals) {
			if(asistenciamensualAux!=null && asistenciamensual!=null) {
				if((asistenciamensualAux.getId()==null && asistenciamensual.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(asistenciamensualAux.getId()!=null && asistenciamensual.getId()!=null){
					if(asistenciamensualAux.getId().equals(asistenciamensual.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsistenciaMensual(List<AsistenciaMensual> asistenciamensuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double horas_trabajoTotal=0.0;
		Double horas_atrasoTotal=0.0;
		Double horas_faltasTotal=0.0;
		Double horas_permisoTotal=0.0;
		Double horas_extra25Total=0.0;
		Double horas_extra50Total=0.0;
		Double horas_extra100Total=0.0;
		Double horas_extra150Total=0.0;
		Double horas_extra0Total=0.0;
		Double horas_enfermoTotal=0.0;
		Double horas_maternidadTotal=0.0;
		Double horas_vacacionTotal=0.0;
		Double numero_diasTotal=0.0;
		Double numero_nochesTotal=0.0;
		Double numero_feriadosTotal=0.0;
		Double numero_trabajoTotal=0.0;
	
		for(AsistenciaMensual asistenciamensual: asistenciamensuals) {			
			if(asistenciamensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			horas_trabajoTotal+=asistenciamensual.gethoras_trabajo();
			horas_atrasoTotal+=asistenciamensual.gethoras_atraso();
			horas_faltasTotal+=asistenciamensual.gethoras_faltas();
			horas_permisoTotal+=asistenciamensual.gethoras_permiso();
			horas_extra25Total+=asistenciamensual.gethoras_extra25();
			horas_extra50Total+=asistenciamensual.gethoras_extra50();
			horas_extra100Total+=asistenciamensual.gethoras_extra100();
			horas_extra150Total+=asistenciamensual.gethoras_extra150();
			horas_extra0Total+=asistenciamensual.gethoras_extra0();
			horas_enfermoTotal+=asistenciamensual.gethoras_enfermo();
			horas_maternidadTotal+=asistenciamensual.gethoras_maternidad();
			horas_vacacionTotal+=asistenciamensual.gethoras_vacacion();
			numero_diasTotal+=asistenciamensual.getnumero_dias();
			numero_nochesTotal+=asistenciamensual.getnumero_noches();
			numero_feriadosTotal+=asistenciamensual.getnumero_feriados();
			numero_trabajoTotal+=asistenciamensual.getnumero_trabajo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASTRABAJO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO);
		datoGeneral.setdValorDouble(horas_trabajoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASATRASO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO);
		datoGeneral.setdValorDouble(horas_atrasoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASFALTAS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS);
		datoGeneral.setdValorDouble(horas_faltasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASPERMISO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO);
		datoGeneral.setdValorDouble(horas_permisoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA25);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25);
		datoGeneral.setdValorDouble(horas_extra25Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA50);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50);
		datoGeneral.setdValorDouble(horas_extra50Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA100);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100);
		datoGeneral.setdValorDouble(horas_extra100Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA150);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150);
		datoGeneral.setdValorDouble(horas_extra150Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASEXTRA0);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0);
		datoGeneral.setdValorDouble(horas_extra0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASENFERMO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO);
		datoGeneral.setdValorDouble(horas_enfermoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD);
		datoGeneral.setdValorDouble(horas_maternidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.HORASVACACION);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION);
		datoGeneral.setdValorDouble(horas_vacacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMERODIAS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS);
		datoGeneral.setdValorDouble(numero_diasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMERONOCHES);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES);
		datoGeneral.setdValorDouble(numero_nochesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS);
		datoGeneral.setdValorDouble(numero_feriadosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO);
		datoGeneral.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO);
		datoGeneral.setdValorDouble(numero_trabajoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAsistenciaMensual() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_ID, AsistenciaMensualConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_VERSIONROW, AsistenciaMensualConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDEMPRESA, AsistenciaMensualConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDEMPLEADO, AsistenciaMensualConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDCARGO, AsistenciaMensualConstantesFunciones.IDCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDESTRUCTURA, AsistenciaMensualConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDANIO, AsistenciaMensualConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_IDMES, AsistenciaMensualConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_FECHA, AsistenciaMensualConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO, AsistenciaMensualConstantesFunciones.HORASTRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO, AsistenciaMensualConstantesFunciones.HORASATRASO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS, AsistenciaMensualConstantesFunciones.HORASFALTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO, AsistenciaMensualConstantesFunciones.HORASPERMISO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25, AsistenciaMensualConstantesFunciones.HORASEXTRA25,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50, AsistenciaMensualConstantesFunciones.HORASEXTRA50,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100, AsistenciaMensualConstantesFunciones.HORASEXTRA100,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150, AsistenciaMensualConstantesFunciones.HORASEXTRA150,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0, AsistenciaMensualConstantesFunciones.HORASEXTRA0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO, AsistenciaMensualConstantesFunciones.HORASENFERMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD, AsistenciaMensualConstantesFunciones.HORASMATERNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION, AsistenciaMensualConstantesFunciones.HORASVACACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS, AsistenciaMensualConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES, AsistenciaMensualConstantesFunciones.NUMERONOCHES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS, AsistenciaMensualConstantesFunciones.NUMEROFERIADOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO, AsistenciaMensualConstantesFunciones.NUMEROTRABAJO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAsistenciaMensual() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASTRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASATRASO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASFALTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASPERMISO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASEXTRA25;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASEXTRA50;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASEXTRA100;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASEXTRA150;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASEXTRA0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASENFERMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASMATERNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.HORASVACACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.NUMERONOCHES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.NUMEROFERIADOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaMensualConstantesFunciones.NUMEROTRABAJO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaMensual() throws Exception  {
		return AsistenciaMensualConstantesFunciones.getTiposSeleccionarAsistenciaMensual(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaMensual(Boolean conFk) throws Exception  {
		return AsistenciaMensualConstantesFunciones.getTiposSeleccionarAsistenciaMensual(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaMensual(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO);
			reporte.setsDescripcion(AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAsistenciaMensual(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaMensual(AsistenciaMensual asistenciamensualAux) throws Exception {
		
			asistenciamensualAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciamensualAux.getEmpresa()));
			asistenciamensualAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciamensualAux.getEmpleado()));
			asistenciamensualAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(asistenciamensualAux.getCargo()));
			asistenciamensualAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciamensualAux.getEstructura()));
			asistenciamensualAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asistenciamensualAux.getAnio()));
			asistenciamensualAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asistenciamensualAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaMensual(List<AsistenciaMensual> asistenciamensualsTemp) throws Exception {
		for(AsistenciaMensual asistenciamensualAux:asistenciamensualsTemp) {
			
			asistenciamensualAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciamensualAux.getEmpresa()));
			asistenciamensualAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciamensualAux.getEmpleado()));
			asistenciamensualAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(asistenciamensualAux.getCargo()));
			asistenciamensualAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciamensualAux.getEstructura()));
			asistenciamensualAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asistenciamensualAux.getAnio()));
			asistenciamensualAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asistenciamensualAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Cargo.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAsistenciaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaMensualConstantesFunciones.getClassesRelationshipsOfAsistenciaMensual(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaMensualConstantesFunciones.getClassesRelationshipsFromStringsOfAsistenciaMensual(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AsistenciaMensual asistenciamensual,List<AsistenciaMensual> asistenciamensuals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AsistenciaMensual asistenciamensualEncontrado=null;
			
			for(AsistenciaMensual asistenciamensualLocal:asistenciamensuals) {
				if(asistenciamensualLocal.getId().equals(asistenciamensual.getId())) {
					asistenciamensualEncontrado=asistenciamensualLocal;
					
					asistenciamensualLocal.setIsChanged(asistenciamensual.getIsChanged());
					asistenciamensualLocal.setIsNew(asistenciamensual.getIsNew());
					asistenciamensualLocal.setIsDeleted(asistenciamensual.getIsDeleted());
					
					asistenciamensualLocal.setGeneralEntityOriginal(asistenciamensual.getGeneralEntityOriginal());
					
					asistenciamensualLocal.setId(asistenciamensual.getId());	
					asistenciamensualLocal.setVersionRow(asistenciamensual.getVersionRow());	
					asistenciamensualLocal.setid_empresa(asistenciamensual.getid_empresa());	
					asistenciamensualLocal.setid_empleado(asistenciamensual.getid_empleado());	
					asistenciamensualLocal.setid_cargo(asistenciamensual.getid_cargo());	
					asistenciamensualLocal.setid_estructura(asistenciamensual.getid_estructura());	
					asistenciamensualLocal.setid_anio(asistenciamensual.getid_anio());	
					asistenciamensualLocal.setid_mes(asistenciamensual.getid_mes());	
					asistenciamensualLocal.setfecha(asistenciamensual.getfecha());	
					asistenciamensualLocal.sethoras_trabajo(asistenciamensual.gethoras_trabajo());	
					asistenciamensualLocal.sethoras_atraso(asistenciamensual.gethoras_atraso());	
					asistenciamensualLocal.sethoras_faltas(asistenciamensual.gethoras_faltas());	
					asistenciamensualLocal.sethoras_permiso(asistenciamensual.gethoras_permiso());	
					asistenciamensualLocal.sethoras_extra25(asistenciamensual.gethoras_extra25());	
					asistenciamensualLocal.sethoras_extra50(asistenciamensual.gethoras_extra50());	
					asistenciamensualLocal.sethoras_extra100(asistenciamensual.gethoras_extra100());	
					asistenciamensualLocal.sethoras_extra150(asistenciamensual.gethoras_extra150());	
					asistenciamensualLocal.sethoras_extra0(asistenciamensual.gethoras_extra0());	
					asistenciamensualLocal.sethoras_enfermo(asistenciamensual.gethoras_enfermo());	
					asistenciamensualLocal.sethoras_maternidad(asistenciamensual.gethoras_maternidad());	
					asistenciamensualLocal.sethoras_vacacion(asistenciamensual.gethoras_vacacion());	
					asistenciamensualLocal.setnumero_dias(asistenciamensual.getnumero_dias());	
					asistenciamensualLocal.setnumero_noches(asistenciamensual.getnumero_noches());	
					asistenciamensualLocal.setnumero_feriados(asistenciamensual.getnumero_feriados());	
					asistenciamensualLocal.setnumero_trabajo(asistenciamensual.getnumero_trabajo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!asistenciamensual.getIsDeleted()) {
				if(!existe) {
					asistenciamensuals.add(asistenciamensual);
				}
			} else {
				if(asistenciamensualEncontrado!=null && permiteQuitar)  {
					asistenciamensuals.remove(asistenciamensualEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AsistenciaMensual asistenciamensual,List<AsistenciaMensual> asistenciamensuals) throws Exception {
		try	{			
			for(AsistenciaMensual asistenciamensualLocal:asistenciamensuals) {
				if(asistenciamensualLocal.getId().equals(asistenciamensual.getId())) {
					asistenciamensualLocal.setIsSelected(asistenciamensual.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAsistenciaMensual(List<AsistenciaMensual> asistenciamensualsAux) throws Exception {
		//this.asistenciamensualsAux=asistenciamensualsAux;
		
		for(AsistenciaMensual asistenciamensualAux:asistenciamensualsAux) {
			if(asistenciamensualAux.getIsChanged()) {
				asistenciamensualAux.setIsChanged(false);
			}		
			
			if(asistenciamensualAux.getIsNew()) {
				asistenciamensualAux.setIsNew(false);
			}	
			
			if(asistenciamensualAux.getIsDeleted()) {
				asistenciamensualAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAsistenciaMensual(AsistenciaMensual asistenciamensualAux) throws Exception {
		//this.asistenciamensualAux=asistenciamensualAux;
		
			if(asistenciamensualAux.getIsChanged()) {
				asistenciamensualAux.setIsChanged(false);
			}		
			
			if(asistenciamensualAux.getIsNew()) {
				asistenciamensualAux.setIsNew(false);
			}	
			
			if(asistenciamensualAux.getIsDeleted()) {
				asistenciamensualAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AsistenciaMensual asistenciamensualAsignar,AsistenciaMensual asistenciamensual) throws Exception {
		asistenciamensualAsignar.setId(asistenciamensual.getId());	
		asistenciamensualAsignar.setVersionRow(asistenciamensual.getVersionRow());	
		asistenciamensualAsignar.setid_empresa(asistenciamensual.getid_empresa());
		asistenciamensualAsignar.setempresa_descripcion(asistenciamensual.getempresa_descripcion());	
		asistenciamensualAsignar.setid_empleado(asistenciamensual.getid_empleado());
		asistenciamensualAsignar.setempleado_descripcion(asistenciamensual.getempleado_descripcion());	
		asistenciamensualAsignar.setid_cargo(asistenciamensual.getid_cargo());
		asistenciamensualAsignar.setcargo_descripcion(asistenciamensual.getcargo_descripcion());	
		asistenciamensualAsignar.setid_estructura(asistenciamensual.getid_estructura());
		asistenciamensualAsignar.setestructura_descripcion(asistenciamensual.getestructura_descripcion());	
		asistenciamensualAsignar.setid_anio(asistenciamensual.getid_anio());
		asistenciamensualAsignar.setanio_descripcion(asistenciamensual.getanio_descripcion());	
		asistenciamensualAsignar.setid_mes(asistenciamensual.getid_mes());
		asistenciamensualAsignar.setmes_descripcion(asistenciamensual.getmes_descripcion());	
		asistenciamensualAsignar.setfecha(asistenciamensual.getfecha());	
		asistenciamensualAsignar.sethoras_trabajo(asistenciamensual.gethoras_trabajo());	
		asistenciamensualAsignar.sethoras_atraso(asistenciamensual.gethoras_atraso());	
		asistenciamensualAsignar.sethoras_faltas(asistenciamensual.gethoras_faltas());	
		asistenciamensualAsignar.sethoras_permiso(asistenciamensual.gethoras_permiso());	
		asistenciamensualAsignar.sethoras_extra25(asistenciamensual.gethoras_extra25());	
		asistenciamensualAsignar.sethoras_extra50(asistenciamensual.gethoras_extra50());	
		asistenciamensualAsignar.sethoras_extra100(asistenciamensual.gethoras_extra100());	
		asistenciamensualAsignar.sethoras_extra150(asistenciamensual.gethoras_extra150());	
		asistenciamensualAsignar.sethoras_extra0(asistenciamensual.gethoras_extra0());	
		asistenciamensualAsignar.sethoras_enfermo(asistenciamensual.gethoras_enfermo());	
		asistenciamensualAsignar.sethoras_maternidad(asistenciamensual.gethoras_maternidad());	
		asistenciamensualAsignar.sethoras_vacacion(asistenciamensual.gethoras_vacacion());	
		asistenciamensualAsignar.setnumero_dias(asistenciamensual.getnumero_dias());	
		asistenciamensualAsignar.setnumero_noches(asistenciamensual.getnumero_noches());	
		asistenciamensualAsignar.setnumero_feriados(asistenciamensual.getnumero_feriados());	
		asistenciamensualAsignar.setnumero_trabajo(asistenciamensual.getnumero_trabajo());	
	}
	
	public static void inicializarAsistenciaMensual(AsistenciaMensual asistenciamensual) throws Exception {
		try {
				asistenciamensual.setId(0L);	
					
				asistenciamensual.setid_empresa(-1L);	
				asistenciamensual.setid_empleado(-1L);	
				asistenciamensual.setid_cargo(-1L);	
				asistenciamensual.setid_estructura(-1L);	
				asistenciamensual.setid_anio(null);	
				asistenciamensual.setid_mes(null);	
				asistenciamensual.setfecha(new Date());	
				asistenciamensual.sethoras_trabajo(0.0);	
				asistenciamensual.sethoras_atraso(0.0);	
				asistenciamensual.sethoras_faltas(0.0);	
				asistenciamensual.sethoras_permiso(0.0);	
				asistenciamensual.sethoras_extra25(0.0);	
				asistenciamensual.sethoras_extra50(0.0);	
				asistenciamensual.sethoras_extra100(0.0);	
				asistenciamensual.sethoras_extra150(0.0);	
				asistenciamensual.sethoras_extra0(0.0);	
				asistenciamensual.sethoras_enfermo(0.0);	
				asistenciamensual.sethoras_maternidad(0.0);	
				asistenciamensual.sethoras_vacacion(0.0);	
				asistenciamensual.setnumero_dias(0.0);	
				asistenciamensual.setnumero_noches(0.0);	
				asistenciamensual.setnumero_feriados(0.0);	
				asistenciamensual.setnumero_trabajo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAsistenciaMensual(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASTRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASATRASO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASFALTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASPERMISO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA25);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA50);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA100);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA150);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASEXTRA0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASENFERMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASMATERNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_HORASVACACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_NUMERONOCHES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_NUMEROFERIADOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaMensualConstantesFunciones.LABEL_NUMEROTRABAJO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAsistenciaMensual(String sTipo,Row row,Workbook workbook,AsistenciaMensual asistenciamensual,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_atraso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_faltas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_permiso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_extra25());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_extra50());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_extra100());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_extra150());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_extra0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_enfermo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_maternidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.gethoras_vacacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getnumero_noches());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getnumero_feriados());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciamensual.getnumero_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAsistenciaMensual=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAsistenciaMensual() {
		return this.sFinalQueryAsistenciaMensual;
	}
	
	public void setsFinalQueryAsistenciaMensual(String sFinalQueryAsistenciaMensual) {
		this.sFinalQueryAsistenciaMensual= sFinalQueryAsistenciaMensual;
	}
	
	public Border resaltarSeleccionarAsistenciaMensual=null;
	
	public Border setResaltarSeleccionarAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAsistenciaMensual= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAsistenciaMensual() {
		return this.resaltarSeleccionarAsistenciaMensual;
	}
	
	public void setResaltarSeleccionarAsistenciaMensual(Border borderResaltarSeleccionarAsistenciaMensual) {
		this.resaltarSeleccionarAsistenciaMensual= borderResaltarSeleccionarAsistenciaMensual;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAsistenciaMensual=null;
	public Boolean mostraridAsistenciaMensual=true;
	public Boolean activaridAsistenciaMensual=true;

	public Border resaltarid_empresaAsistenciaMensual=null;
	public Boolean mostrarid_empresaAsistenciaMensual=true;
	public Boolean activarid_empresaAsistenciaMensual=true;
	public Boolean cargarid_empresaAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarid_empleadoAsistenciaMensual=null;
	public Boolean mostrarid_empleadoAsistenciaMensual=true;
	public Boolean activarid_empleadoAsistenciaMensual=true;
	public Boolean cargarid_empleadoAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarid_cargoAsistenciaMensual=null;
	public Boolean mostrarid_cargoAsistenciaMensual=true;
	public Boolean activarid_cargoAsistenciaMensual=true;
	public Boolean cargarid_cargoAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarid_estructuraAsistenciaMensual=null;
	public Boolean mostrarid_estructuraAsistenciaMensual=true;
	public Boolean activarid_estructuraAsistenciaMensual=true;
	public Boolean cargarid_estructuraAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarid_anioAsistenciaMensual=null;
	public Boolean mostrarid_anioAsistenciaMensual=true;
	public Boolean activarid_anioAsistenciaMensual=true;
	public Boolean cargarid_anioAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarid_mesAsistenciaMensual=null;
	public Boolean mostrarid_mesAsistenciaMensual=true;
	public Boolean activarid_mesAsistenciaMensual=true;
	public Boolean cargarid_mesAsistenciaMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesAsistenciaMensual=false;//ConEventDepend=true

	public Border resaltarfechaAsistenciaMensual=null;
	public Boolean mostrarfechaAsistenciaMensual=true;
	public Boolean activarfechaAsistenciaMensual=false;

	public Border resaltarhoras_trabajoAsistenciaMensual=null;
	public Boolean mostrarhoras_trabajoAsistenciaMensual=true;
	public Boolean activarhoras_trabajoAsistenciaMensual=true;

	public Border resaltarhoras_atrasoAsistenciaMensual=null;
	public Boolean mostrarhoras_atrasoAsistenciaMensual=true;
	public Boolean activarhoras_atrasoAsistenciaMensual=true;

	public Border resaltarhoras_faltasAsistenciaMensual=null;
	public Boolean mostrarhoras_faltasAsistenciaMensual=true;
	public Boolean activarhoras_faltasAsistenciaMensual=true;

	public Border resaltarhoras_permisoAsistenciaMensual=null;
	public Boolean mostrarhoras_permisoAsistenciaMensual=true;
	public Boolean activarhoras_permisoAsistenciaMensual=true;

	public Border resaltarhoras_extra25AsistenciaMensual=null;
	public Boolean mostrarhoras_extra25AsistenciaMensual=true;
	public Boolean activarhoras_extra25AsistenciaMensual=true;

	public Border resaltarhoras_extra50AsistenciaMensual=null;
	public Boolean mostrarhoras_extra50AsistenciaMensual=true;
	public Boolean activarhoras_extra50AsistenciaMensual=true;

	public Border resaltarhoras_extra100AsistenciaMensual=null;
	public Boolean mostrarhoras_extra100AsistenciaMensual=true;
	public Boolean activarhoras_extra100AsistenciaMensual=true;

	public Border resaltarhoras_extra150AsistenciaMensual=null;
	public Boolean mostrarhoras_extra150AsistenciaMensual=true;
	public Boolean activarhoras_extra150AsistenciaMensual=true;

	public Border resaltarhoras_extra0AsistenciaMensual=null;
	public Boolean mostrarhoras_extra0AsistenciaMensual=true;
	public Boolean activarhoras_extra0AsistenciaMensual=true;

	public Border resaltarhoras_enfermoAsistenciaMensual=null;
	public Boolean mostrarhoras_enfermoAsistenciaMensual=true;
	public Boolean activarhoras_enfermoAsistenciaMensual=true;

	public Border resaltarhoras_maternidadAsistenciaMensual=null;
	public Boolean mostrarhoras_maternidadAsistenciaMensual=true;
	public Boolean activarhoras_maternidadAsistenciaMensual=true;

	public Border resaltarhoras_vacacionAsistenciaMensual=null;
	public Boolean mostrarhoras_vacacionAsistenciaMensual=true;
	public Boolean activarhoras_vacacionAsistenciaMensual=true;

	public Border resaltarnumero_diasAsistenciaMensual=null;
	public Boolean mostrarnumero_diasAsistenciaMensual=true;
	public Boolean activarnumero_diasAsistenciaMensual=true;

	public Border resaltarnumero_nochesAsistenciaMensual=null;
	public Boolean mostrarnumero_nochesAsistenciaMensual=true;
	public Boolean activarnumero_nochesAsistenciaMensual=true;

	public Border resaltarnumero_feriadosAsistenciaMensual=null;
	public Boolean mostrarnumero_feriadosAsistenciaMensual=true;
	public Boolean activarnumero_feriadosAsistenciaMensual=true;

	public Border resaltarnumero_trabajoAsistenciaMensual=null;
	public Boolean mostrarnumero_trabajoAsistenciaMensual=true;
	public Boolean activarnumero_trabajoAsistenciaMensual=true;

	
	

	public Border setResaltaridAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltaridAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAsistenciaMensual() {
		return this.resaltaridAsistenciaMensual;
	}

	public void setResaltaridAsistenciaMensual(Border borderResaltar) {
		this.resaltaridAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostraridAsistenciaMensual() {
		return this.mostraridAsistenciaMensual;
	}

	public void setMostraridAsistenciaMensual(Boolean mostraridAsistenciaMensual) {
		this.mostraridAsistenciaMensual= mostraridAsistenciaMensual;
	}

	public Boolean getActivaridAsistenciaMensual() {
		return this.activaridAsistenciaMensual;
	}

	public void setActivaridAsistenciaMensual(Boolean activaridAsistenciaMensual) {
		this.activaridAsistenciaMensual= activaridAsistenciaMensual;
	}

	public Border setResaltarid_empresaAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_empresaAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAsistenciaMensual() {
		return this.resaltarid_empresaAsistenciaMensual;
	}

	public void setResaltarid_empresaAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_empresaAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_empresaAsistenciaMensual() {
		return this.mostrarid_empresaAsistenciaMensual;
	}

	public void setMostrarid_empresaAsistenciaMensual(Boolean mostrarid_empresaAsistenciaMensual) {
		this.mostrarid_empresaAsistenciaMensual= mostrarid_empresaAsistenciaMensual;
	}

	public Boolean getActivarid_empresaAsistenciaMensual() {
		return this.activarid_empresaAsistenciaMensual;
	}

	public void setActivarid_empresaAsistenciaMensual(Boolean activarid_empresaAsistenciaMensual) {
		this.activarid_empresaAsistenciaMensual= activarid_empresaAsistenciaMensual;
	}

	public Boolean getCargarid_empresaAsistenciaMensual() {
		return this.cargarid_empresaAsistenciaMensual;
	}

	public void setCargarid_empresaAsistenciaMensual(Boolean cargarid_empresaAsistenciaMensual) {
		this.cargarid_empresaAsistenciaMensual= cargarid_empresaAsistenciaMensual;
	}

	public Border setResaltarid_empleadoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAsistenciaMensual() {
		return this.resaltarid_empleadoAsistenciaMensual;
	}

	public void setResaltarid_empleadoAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_empleadoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAsistenciaMensual() {
		return this.mostrarid_empleadoAsistenciaMensual;
	}

	public void setMostrarid_empleadoAsistenciaMensual(Boolean mostrarid_empleadoAsistenciaMensual) {
		this.mostrarid_empleadoAsistenciaMensual= mostrarid_empleadoAsistenciaMensual;
	}

	public Boolean getActivarid_empleadoAsistenciaMensual() {
		return this.activarid_empleadoAsistenciaMensual;
	}

	public void setActivarid_empleadoAsistenciaMensual(Boolean activarid_empleadoAsistenciaMensual) {
		this.activarid_empleadoAsistenciaMensual= activarid_empleadoAsistenciaMensual;
	}

	public Boolean getCargarid_empleadoAsistenciaMensual() {
		return this.cargarid_empleadoAsistenciaMensual;
	}

	public void setCargarid_empleadoAsistenciaMensual(Boolean cargarid_empleadoAsistenciaMensual) {
		this.cargarid_empleadoAsistenciaMensual= cargarid_empleadoAsistenciaMensual;
	}

	public Border setResaltarid_cargoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_cargoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoAsistenciaMensual() {
		return this.resaltarid_cargoAsistenciaMensual;
	}

	public void setResaltarid_cargoAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_cargoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_cargoAsistenciaMensual() {
		return this.mostrarid_cargoAsistenciaMensual;
	}

	public void setMostrarid_cargoAsistenciaMensual(Boolean mostrarid_cargoAsistenciaMensual) {
		this.mostrarid_cargoAsistenciaMensual= mostrarid_cargoAsistenciaMensual;
	}

	public Boolean getActivarid_cargoAsistenciaMensual() {
		return this.activarid_cargoAsistenciaMensual;
	}

	public void setActivarid_cargoAsistenciaMensual(Boolean activarid_cargoAsistenciaMensual) {
		this.activarid_cargoAsistenciaMensual= activarid_cargoAsistenciaMensual;
	}

	public Boolean getCargarid_cargoAsistenciaMensual() {
		return this.cargarid_cargoAsistenciaMensual;
	}

	public void setCargarid_cargoAsistenciaMensual(Boolean cargarid_cargoAsistenciaMensual) {
		this.cargarid_cargoAsistenciaMensual= cargarid_cargoAsistenciaMensual;
	}

	public Border setResaltarid_estructuraAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_estructuraAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraAsistenciaMensual() {
		return this.resaltarid_estructuraAsistenciaMensual;
	}

	public void setResaltarid_estructuraAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_estructuraAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_estructuraAsistenciaMensual() {
		return this.mostrarid_estructuraAsistenciaMensual;
	}

	public void setMostrarid_estructuraAsistenciaMensual(Boolean mostrarid_estructuraAsistenciaMensual) {
		this.mostrarid_estructuraAsistenciaMensual= mostrarid_estructuraAsistenciaMensual;
	}

	public Boolean getActivarid_estructuraAsistenciaMensual() {
		return this.activarid_estructuraAsistenciaMensual;
	}

	public void setActivarid_estructuraAsistenciaMensual(Boolean activarid_estructuraAsistenciaMensual) {
		this.activarid_estructuraAsistenciaMensual= activarid_estructuraAsistenciaMensual;
	}

	public Boolean getCargarid_estructuraAsistenciaMensual() {
		return this.cargarid_estructuraAsistenciaMensual;
	}

	public void setCargarid_estructuraAsistenciaMensual(Boolean cargarid_estructuraAsistenciaMensual) {
		this.cargarid_estructuraAsistenciaMensual= cargarid_estructuraAsistenciaMensual;
	}

	public Border setResaltarid_anioAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_anioAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioAsistenciaMensual() {
		return this.resaltarid_anioAsistenciaMensual;
	}

	public void setResaltarid_anioAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_anioAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_anioAsistenciaMensual() {
		return this.mostrarid_anioAsistenciaMensual;
	}

	public void setMostrarid_anioAsistenciaMensual(Boolean mostrarid_anioAsistenciaMensual) {
		this.mostrarid_anioAsistenciaMensual= mostrarid_anioAsistenciaMensual;
	}

	public Boolean getActivarid_anioAsistenciaMensual() {
		return this.activarid_anioAsistenciaMensual;
	}

	public void setActivarid_anioAsistenciaMensual(Boolean activarid_anioAsistenciaMensual) {
		this.activarid_anioAsistenciaMensual= activarid_anioAsistenciaMensual;
	}

	public Boolean getCargarid_anioAsistenciaMensual() {
		return this.cargarid_anioAsistenciaMensual;
	}

	public void setCargarid_anioAsistenciaMensual(Boolean cargarid_anioAsistenciaMensual) {
		this.cargarid_anioAsistenciaMensual= cargarid_anioAsistenciaMensual;
	}

	public Border setResaltarid_mesAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarid_mesAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesAsistenciaMensual() {
		return this.resaltarid_mesAsistenciaMensual;
	}

	public void setResaltarid_mesAsistenciaMensual(Border borderResaltar) {
		this.resaltarid_mesAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarid_mesAsistenciaMensual() {
		return this.mostrarid_mesAsistenciaMensual;
	}

	public void setMostrarid_mesAsistenciaMensual(Boolean mostrarid_mesAsistenciaMensual) {
		this.mostrarid_mesAsistenciaMensual= mostrarid_mesAsistenciaMensual;
	}

	public Boolean getActivarid_mesAsistenciaMensual() {
		return this.activarid_mesAsistenciaMensual;
	}

	public void setActivarid_mesAsistenciaMensual(Boolean activarid_mesAsistenciaMensual) {
		this.activarid_mesAsistenciaMensual= activarid_mesAsistenciaMensual;
	}

	public Boolean getCargarid_mesAsistenciaMensual() {
		return this.cargarid_mesAsistenciaMensual;
	}

	public void setCargarid_mesAsistenciaMensual(Boolean cargarid_mesAsistenciaMensual) {
		this.cargarid_mesAsistenciaMensual= cargarid_mesAsistenciaMensual;
	}

	public Border setResaltarfechaAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarfechaAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAsistenciaMensual() {
		return this.resaltarfechaAsistenciaMensual;
	}

	public void setResaltarfechaAsistenciaMensual(Border borderResaltar) {
		this.resaltarfechaAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarfechaAsistenciaMensual() {
		return this.mostrarfechaAsistenciaMensual;
	}

	public void setMostrarfechaAsistenciaMensual(Boolean mostrarfechaAsistenciaMensual) {
		this.mostrarfechaAsistenciaMensual= mostrarfechaAsistenciaMensual;
	}

	public Boolean getActivarfechaAsistenciaMensual() {
		return this.activarfechaAsistenciaMensual;
	}

	public void setActivarfechaAsistenciaMensual(Boolean activarfechaAsistenciaMensual) {
		this.activarfechaAsistenciaMensual= activarfechaAsistenciaMensual;
	}

	public Border setResaltarhoras_trabajoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_trabajoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_trabajoAsistenciaMensual() {
		return this.resaltarhoras_trabajoAsistenciaMensual;
	}

	public void setResaltarhoras_trabajoAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_trabajoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_trabajoAsistenciaMensual() {
		return this.mostrarhoras_trabajoAsistenciaMensual;
	}

	public void setMostrarhoras_trabajoAsistenciaMensual(Boolean mostrarhoras_trabajoAsistenciaMensual) {
		this.mostrarhoras_trabajoAsistenciaMensual= mostrarhoras_trabajoAsistenciaMensual;
	}

	public Boolean getActivarhoras_trabajoAsistenciaMensual() {
		return this.activarhoras_trabajoAsistenciaMensual;
	}

	public void setActivarhoras_trabajoAsistenciaMensual(Boolean activarhoras_trabajoAsistenciaMensual) {
		this.activarhoras_trabajoAsistenciaMensual= activarhoras_trabajoAsistenciaMensual;
	}

	public Border setResaltarhoras_atrasoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_atrasoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_atrasoAsistenciaMensual() {
		return this.resaltarhoras_atrasoAsistenciaMensual;
	}

	public void setResaltarhoras_atrasoAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_atrasoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_atrasoAsistenciaMensual() {
		return this.mostrarhoras_atrasoAsistenciaMensual;
	}

	public void setMostrarhoras_atrasoAsistenciaMensual(Boolean mostrarhoras_atrasoAsistenciaMensual) {
		this.mostrarhoras_atrasoAsistenciaMensual= mostrarhoras_atrasoAsistenciaMensual;
	}

	public Boolean getActivarhoras_atrasoAsistenciaMensual() {
		return this.activarhoras_atrasoAsistenciaMensual;
	}

	public void setActivarhoras_atrasoAsistenciaMensual(Boolean activarhoras_atrasoAsistenciaMensual) {
		this.activarhoras_atrasoAsistenciaMensual= activarhoras_atrasoAsistenciaMensual;
	}

	public Border setResaltarhoras_faltasAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_faltasAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_faltasAsistenciaMensual() {
		return this.resaltarhoras_faltasAsistenciaMensual;
	}

	public void setResaltarhoras_faltasAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_faltasAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_faltasAsistenciaMensual() {
		return this.mostrarhoras_faltasAsistenciaMensual;
	}

	public void setMostrarhoras_faltasAsistenciaMensual(Boolean mostrarhoras_faltasAsistenciaMensual) {
		this.mostrarhoras_faltasAsistenciaMensual= mostrarhoras_faltasAsistenciaMensual;
	}

	public Boolean getActivarhoras_faltasAsistenciaMensual() {
		return this.activarhoras_faltasAsistenciaMensual;
	}

	public void setActivarhoras_faltasAsistenciaMensual(Boolean activarhoras_faltasAsistenciaMensual) {
		this.activarhoras_faltasAsistenciaMensual= activarhoras_faltasAsistenciaMensual;
	}

	public Border setResaltarhoras_permisoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_permisoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_permisoAsistenciaMensual() {
		return this.resaltarhoras_permisoAsistenciaMensual;
	}

	public void setResaltarhoras_permisoAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_permisoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_permisoAsistenciaMensual() {
		return this.mostrarhoras_permisoAsistenciaMensual;
	}

	public void setMostrarhoras_permisoAsistenciaMensual(Boolean mostrarhoras_permisoAsistenciaMensual) {
		this.mostrarhoras_permisoAsistenciaMensual= mostrarhoras_permisoAsistenciaMensual;
	}

	public Boolean getActivarhoras_permisoAsistenciaMensual() {
		return this.activarhoras_permisoAsistenciaMensual;
	}

	public void setActivarhoras_permisoAsistenciaMensual(Boolean activarhoras_permisoAsistenciaMensual) {
		this.activarhoras_permisoAsistenciaMensual= activarhoras_permisoAsistenciaMensual;
	}

	public Border setResaltarhoras_extra25AsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_extra25AsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra25AsistenciaMensual() {
		return this.resaltarhoras_extra25AsistenciaMensual;
	}

	public void setResaltarhoras_extra25AsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_extra25AsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_extra25AsistenciaMensual() {
		return this.mostrarhoras_extra25AsistenciaMensual;
	}

	public void setMostrarhoras_extra25AsistenciaMensual(Boolean mostrarhoras_extra25AsistenciaMensual) {
		this.mostrarhoras_extra25AsistenciaMensual= mostrarhoras_extra25AsistenciaMensual;
	}

	public Boolean getActivarhoras_extra25AsistenciaMensual() {
		return this.activarhoras_extra25AsistenciaMensual;
	}

	public void setActivarhoras_extra25AsistenciaMensual(Boolean activarhoras_extra25AsistenciaMensual) {
		this.activarhoras_extra25AsistenciaMensual= activarhoras_extra25AsistenciaMensual;
	}

	public Border setResaltarhoras_extra50AsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_extra50AsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra50AsistenciaMensual() {
		return this.resaltarhoras_extra50AsistenciaMensual;
	}

	public void setResaltarhoras_extra50AsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_extra50AsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_extra50AsistenciaMensual() {
		return this.mostrarhoras_extra50AsistenciaMensual;
	}

	public void setMostrarhoras_extra50AsistenciaMensual(Boolean mostrarhoras_extra50AsistenciaMensual) {
		this.mostrarhoras_extra50AsistenciaMensual= mostrarhoras_extra50AsistenciaMensual;
	}

	public Boolean getActivarhoras_extra50AsistenciaMensual() {
		return this.activarhoras_extra50AsistenciaMensual;
	}

	public void setActivarhoras_extra50AsistenciaMensual(Boolean activarhoras_extra50AsistenciaMensual) {
		this.activarhoras_extra50AsistenciaMensual= activarhoras_extra50AsistenciaMensual;
	}

	public Border setResaltarhoras_extra100AsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_extra100AsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra100AsistenciaMensual() {
		return this.resaltarhoras_extra100AsistenciaMensual;
	}

	public void setResaltarhoras_extra100AsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_extra100AsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_extra100AsistenciaMensual() {
		return this.mostrarhoras_extra100AsistenciaMensual;
	}

	public void setMostrarhoras_extra100AsistenciaMensual(Boolean mostrarhoras_extra100AsistenciaMensual) {
		this.mostrarhoras_extra100AsistenciaMensual= mostrarhoras_extra100AsistenciaMensual;
	}

	public Boolean getActivarhoras_extra100AsistenciaMensual() {
		return this.activarhoras_extra100AsistenciaMensual;
	}

	public void setActivarhoras_extra100AsistenciaMensual(Boolean activarhoras_extra100AsistenciaMensual) {
		this.activarhoras_extra100AsistenciaMensual= activarhoras_extra100AsistenciaMensual;
	}

	public Border setResaltarhoras_extra150AsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_extra150AsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra150AsistenciaMensual() {
		return this.resaltarhoras_extra150AsistenciaMensual;
	}

	public void setResaltarhoras_extra150AsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_extra150AsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_extra150AsistenciaMensual() {
		return this.mostrarhoras_extra150AsistenciaMensual;
	}

	public void setMostrarhoras_extra150AsistenciaMensual(Boolean mostrarhoras_extra150AsistenciaMensual) {
		this.mostrarhoras_extra150AsistenciaMensual= mostrarhoras_extra150AsistenciaMensual;
	}

	public Boolean getActivarhoras_extra150AsistenciaMensual() {
		return this.activarhoras_extra150AsistenciaMensual;
	}

	public void setActivarhoras_extra150AsistenciaMensual(Boolean activarhoras_extra150AsistenciaMensual) {
		this.activarhoras_extra150AsistenciaMensual= activarhoras_extra150AsistenciaMensual;
	}

	public Border setResaltarhoras_extra0AsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_extra0AsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra0AsistenciaMensual() {
		return this.resaltarhoras_extra0AsistenciaMensual;
	}

	public void setResaltarhoras_extra0AsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_extra0AsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_extra0AsistenciaMensual() {
		return this.mostrarhoras_extra0AsistenciaMensual;
	}

	public void setMostrarhoras_extra0AsistenciaMensual(Boolean mostrarhoras_extra0AsistenciaMensual) {
		this.mostrarhoras_extra0AsistenciaMensual= mostrarhoras_extra0AsistenciaMensual;
	}

	public Boolean getActivarhoras_extra0AsistenciaMensual() {
		return this.activarhoras_extra0AsistenciaMensual;
	}

	public void setActivarhoras_extra0AsistenciaMensual(Boolean activarhoras_extra0AsistenciaMensual) {
		this.activarhoras_extra0AsistenciaMensual= activarhoras_extra0AsistenciaMensual;
	}

	public Border setResaltarhoras_enfermoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_enfermoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_enfermoAsistenciaMensual() {
		return this.resaltarhoras_enfermoAsistenciaMensual;
	}

	public void setResaltarhoras_enfermoAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_enfermoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_enfermoAsistenciaMensual() {
		return this.mostrarhoras_enfermoAsistenciaMensual;
	}

	public void setMostrarhoras_enfermoAsistenciaMensual(Boolean mostrarhoras_enfermoAsistenciaMensual) {
		this.mostrarhoras_enfermoAsistenciaMensual= mostrarhoras_enfermoAsistenciaMensual;
	}

	public Boolean getActivarhoras_enfermoAsistenciaMensual() {
		return this.activarhoras_enfermoAsistenciaMensual;
	}

	public void setActivarhoras_enfermoAsistenciaMensual(Boolean activarhoras_enfermoAsistenciaMensual) {
		this.activarhoras_enfermoAsistenciaMensual= activarhoras_enfermoAsistenciaMensual;
	}

	public Border setResaltarhoras_maternidadAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_maternidadAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_maternidadAsistenciaMensual() {
		return this.resaltarhoras_maternidadAsistenciaMensual;
	}

	public void setResaltarhoras_maternidadAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_maternidadAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_maternidadAsistenciaMensual() {
		return this.mostrarhoras_maternidadAsistenciaMensual;
	}

	public void setMostrarhoras_maternidadAsistenciaMensual(Boolean mostrarhoras_maternidadAsistenciaMensual) {
		this.mostrarhoras_maternidadAsistenciaMensual= mostrarhoras_maternidadAsistenciaMensual;
	}

	public Boolean getActivarhoras_maternidadAsistenciaMensual() {
		return this.activarhoras_maternidadAsistenciaMensual;
	}

	public void setActivarhoras_maternidadAsistenciaMensual(Boolean activarhoras_maternidadAsistenciaMensual) {
		this.activarhoras_maternidadAsistenciaMensual= activarhoras_maternidadAsistenciaMensual;
	}

	public Border setResaltarhoras_vacacionAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarhoras_vacacionAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_vacacionAsistenciaMensual() {
		return this.resaltarhoras_vacacionAsistenciaMensual;
	}

	public void setResaltarhoras_vacacionAsistenciaMensual(Border borderResaltar) {
		this.resaltarhoras_vacacionAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarhoras_vacacionAsistenciaMensual() {
		return this.mostrarhoras_vacacionAsistenciaMensual;
	}

	public void setMostrarhoras_vacacionAsistenciaMensual(Boolean mostrarhoras_vacacionAsistenciaMensual) {
		this.mostrarhoras_vacacionAsistenciaMensual= mostrarhoras_vacacionAsistenciaMensual;
	}

	public Boolean getActivarhoras_vacacionAsistenciaMensual() {
		return this.activarhoras_vacacionAsistenciaMensual;
	}

	public void setActivarhoras_vacacionAsistenciaMensual(Boolean activarhoras_vacacionAsistenciaMensual) {
		this.activarhoras_vacacionAsistenciaMensual= activarhoras_vacacionAsistenciaMensual;
	}

	public Border setResaltarnumero_diasAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarnumero_diasAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasAsistenciaMensual() {
		return this.resaltarnumero_diasAsistenciaMensual;
	}

	public void setResaltarnumero_diasAsistenciaMensual(Border borderResaltar) {
		this.resaltarnumero_diasAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarnumero_diasAsistenciaMensual() {
		return this.mostrarnumero_diasAsistenciaMensual;
	}

	public void setMostrarnumero_diasAsistenciaMensual(Boolean mostrarnumero_diasAsistenciaMensual) {
		this.mostrarnumero_diasAsistenciaMensual= mostrarnumero_diasAsistenciaMensual;
	}

	public Boolean getActivarnumero_diasAsistenciaMensual() {
		return this.activarnumero_diasAsistenciaMensual;
	}

	public void setActivarnumero_diasAsistenciaMensual(Boolean activarnumero_diasAsistenciaMensual) {
		this.activarnumero_diasAsistenciaMensual= activarnumero_diasAsistenciaMensual;
	}

	public Border setResaltarnumero_nochesAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarnumero_nochesAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nochesAsistenciaMensual() {
		return this.resaltarnumero_nochesAsistenciaMensual;
	}

	public void setResaltarnumero_nochesAsistenciaMensual(Border borderResaltar) {
		this.resaltarnumero_nochesAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarnumero_nochesAsistenciaMensual() {
		return this.mostrarnumero_nochesAsistenciaMensual;
	}

	public void setMostrarnumero_nochesAsistenciaMensual(Boolean mostrarnumero_nochesAsistenciaMensual) {
		this.mostrarnumero_nochesAsistenciaMensual= mostrarnumero_nochesAsistenciaMensual;
	}

	public Boolean getActivarnumero_nochesAsistenciaMensual() {
		return this.activarnumero_nochesAsistenciaMensual;
	}

	public void setActivarnumero_nochesAsistenciaMensual(Boolean activarnumero_nochesAsistenciaMensual) {
		this.activarnumero_nochesAsistenciaMensual= activarnumero_nochesAsistenciaMensual;
	}

	public Border setResaltarnumero_feriadosAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarnumero_feriadosAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_feriadosAsistenciaMensual() {
		return this.resaltarnumero_feriadosAsistenciaMensual;
	}

	public void setResaltarnumero_feriadosAsistenciaMensual(Border borderResaltar) {
		this.resaltarnumero_feriadosAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarnumero_feriadosAsistenciaMensual() {
		return this.mostrarnumero_feriadosAsistenciaMensual;
	}

	public void setMostrarnumero_feriadosAsistenciaMensual(Boolean mostrarnumero_feriadosAsistenciaMensual) {
		this.mostrarnumero_feriadosAsistenciaMensual= mostrarnumero_feriadosAsistenciaMensual;
	}

	public Boolean getActivarnumero_feriadosAsistenciaMensual() {
		return this.activarnumero_feriadosAsistenciaMensual;
	}

	public void setActivarnumero_feriadosAsistenciaMensual(Boolean activarnumero_feriadosAsistenciaMensual) {
		this.activarnumero_feriadosAsistenciaMensual= activarnumero_feriadosAsistenciaMensual;
	}

	public Border setResaltarnumero_trabajoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciamensualBeanSwingJInternalFrame.jTtoolBarAsistenciaMensual.setBorder(borderResaltar);
		
		this.resaltarnumero_trabajoAsistenciaMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_trabajoAsistenciaMensual() {
		return this.resaltarnumero_trabajoAsistenciaMensual;
	}

	public void setResaltarnumero_trabajoAsistenciaMensual(Border borderResaltar) {
		this.resaltarnumero_trabajoAsistenciaMensual= borderResaltar;
	}

	public Boolean getMostrarnumero_trabajoAsistenciaMensual() {
		return this.mostrarnumero_trabajoAsistenciaMensual;
	}

	public void setMostrarnumero_trabajoAsistenciaMensual(Boolean mostrarnumero_trabajoAsistenciaMensual) {
		this.mostrarnumero_trabajoAsistenciaMensual= mostrarnumero_trabajoAsistenciaMensual;
	}

	public Boolean getActivarnumero_trabajoAsistenciaMensual() {
		return this.activarnumero_trabajoAsistenciaMensual;
	}

	public void setActivarnumero_trabajoAsistenciaMensual(Boolean activarnumero_trabajoAsistenciaMensual) {
		this.activarnumero_trabajoAsistenciaMensual= activarnumero_trabajoAsistenciaMensual;
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
		
		
		this.setMostraridAsistenciaMensual(esInicial);
		this.setMostrarid_empresaAsistenciaMensual(esInicial);
		this.setMostrarid_empleadoAsistenciaMensual(esInicial);
		this.setMostrarid_cargoAsistenciaMensual(esInicial);
		this.setMostrarid_estructuraAsistenciaMensual(esInicial);
		this.setMostrarid_anioAsistenciaMensual(esInicial);
		this.setMostrarid_mesAsistenciaMensual(esInicial);
		this.setMostrarfechaAsistenciaMensual(esInicial);
		this.setMostrarhoras_trabajoAsistenciaMensual(esInicial);
		this.setMostrarhoras_atrasoAsistenciaMensual(esInicial);
		this.setMostrarhoras_faltasAsistenciaMensual(esInicial);
		this.setMostrarhoras_permisoAsistenciaMensual(esInicial);
		this.setMostrarhoras_extra25AsistenciaMensual(esInicial);
		this.setMostrarhoras_extra50AsistenciaMensual(esInicial);
		this.setMostrarhoras_extra100AsistenciaMensual(esInicial);
		this.setMostrarhoras_extra150AsistenciaMensual(esInicial);
		this.setMostrarhoras_extra0AsistenciaMensual(esInicial);
		this.setMostrarhoras_enfermoAsistenciaMensual(esInicial);
		this.setMostrarhoras_maternidadAsistenciaMensual(esInicial);
		this.setMostrarhoras_vacacionAsistenciaMensual(esInicial);
		this.setMostrarnumero_diasAsistenciaMensual(esInicial);
		this.setMostrarnumero_nochesAsistenciaMensual(esInicial);
		this.setMostrarnumero_feriadosAsistenciaMensual(esInicial);
		this.setMostrarnumero_trabajoAsistenciaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.ID)) {
				this.setMostraridAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDMES)) {
				this.setMostrarid_mesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.FECHA)) {
				this.setMostrarfechaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASTRABAJO)) {
				this.setMostrarhoras_trabajoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASATRASO)) {
				this.setMostrarhoras_atrasoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASFALTAS)) {
				this.setMostrarhoras_faltasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASPERMISO)) {
				this.setMostrarhoras_permisoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA25)) {
				this.setMostrarhoras_extra25AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA50)) {
				this.setMostrarhoras_extra50AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA100)) {
				this.setMostrarhoras_extra100AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA150)) {
				this.setMostrarhoras_extra150AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA0)) {
				this.setMostrarhoras_extra0AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASENFERMO)) {
				this.setMostrarhoras_enfermoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD)) {
				this.setMostrarhoras_maternidadAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASVACACION)) {
				this.setMostrarhoras_vacacionAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERONOCHES)) {
				this.setMostrarnumero_nochesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS)) {
				this.setMostrarnumero_feriadosAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO)) {
				this.setMostrarnumero_trabajoAsistenciaMensual(esAsigna);
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
		
		
		this.setActivaridAsistenciaMensual(esInicial);
		this.setActivarid_empresaAsistenciaMensual(esInicial);
		this.setActivarid_empleadoAsistenciaMensual(esInicial);
		this.setActivarid_cargoAsistenciaMensual(esInicial);
		this.setActivarid_estructuraAsistenciaMensual(esInicial);
		this.setActivarid_anioAsistenciaMensual(esInicial);
		this.setActivarid_mesAsistenciaMensual(esInicial);
		this.setActivarfechaAsistenciaMensual(esInicial);
		this.setActivarhoras_trabajoAsistenciaMensual(esInicial);
		this.setActivarhoras_atrasoAsistenciaMensual(esInicial);
		this.setActivarhoras_faltasAsistenciaMensual(esInicial);
		this.setActivarhoras_permisoAsistenciaMensual(esInicial);
		this.setActivarhoras_extra25AsistenciaMensual(esInicial);
		this.setActivarhoras_extra50AsistenciaMensual(esInicial);
		this.setActivarhoras_extra100AsistenciaMensual(esInicial);
		this.setActivarhoras_extra150AsistenciaMensual(esInicial);
		this.setActivarhoras_extra0AsistenciaMensual(esInicial);
		this.setActivarhoras_enfermoAsistenciaMensual(esInicial);
		this.setActivarhoras_maternidadAsistenciaMensual(esInicial);
		this.setActivarhoras_vacacionAsistenciaMensual(esInicial);
		this.setActivarnumero_diasAsistenciaMensual(esInicial);
		this.setActivarnumero_nochesAsistenciaMensual(esInicial);
		this.setActivarnumero_feriadosAsistenciaMensual(esInicial);
		this.setActivarnumero_trabajoAsistenciaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.ID)) {
				this.setActivaridAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDANIO)) {
				this.setActivarid_anioAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDMES)) {
				this.setActivarid_mesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.FECHA)) {
				this.setActivarfechaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASTRABAJO)) {
				this.setActivarhoras_trabajoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASATRASO)) {
				this.setActivarhoras_atrasoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASFALTAS)) {
				this.setActivarhoras_faltasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASPERMISO)) {
				this.setActivarhoras_permisoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA25)) {
				this.setActivarhoras_extra25AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA50)) {
				this.setActivarhoras_extra50AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA100)) {
				this.setActivarhoras_extra100AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA150)) {
				this.setActivarhoras_extra150AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA0)) {
				this.setActivarhoras_extra0AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASENFERMO)) {
				this.setActivarhoras_enfermoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD)) {
				this.setActivarhoras_maternidadAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASVACACION)) {
				this.setActivarhoras_vacacionAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERONOCHES)) {
				this.setActivarnumero_nochesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS)) {
				this.setActivarnumero_feriadosAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO)) {
				this.setActivarnumero_trabajoAsistenciaMensual(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAsistenciaMensual(esInicial);
		this.setResaltarid_empresaAsistenciaMensual(esInicial);
		this.setResaltarid_empleadoAsistenciaMensual(esInicial);
		this.setResaltarid_cargoAsistenciaMensual(esInicial);
		this.setResaltarid_estructuraAsistenciaMensual(esInicial);
		this.setResaltarid_anioAsistenciaMensual(esInicial);
		this.setResaltarid_mesAsistenciaMensual(esInicial);
		this.setResaltarfechaAsistenciaMensual(esInicial);
		this.setResaltarhoras_trabajoAsistenciaMensual(esInicial);
		this.setResaltarhoras_atrasoAsistenciaMensual(esInicial);
		this.setResaltarhoras_faltasAsistenciaMensual(esInicial);
		this.setResaltarhoras_permisoAsistenciaMensual(esInicial);
		this.setResaltarhoras_extra25AsistenciaMensual(esInicial);
		this.setResaltarhoras_extra50AsistenciaMensual(esInicial);
		this.setResaltarhoras_extra100AsistenciaMensual(esInicial);
		this.setResaltarhoras_extra150AsistenciaMensual(esInicial);
		this.setResaltarhoras_extra0AsistenciaMensual(esInicial);
		this.setResaltarhoras_enfermoAsistenciaMensual(esInicial);
		this.setResaltarhoras_maternidadAsistenciaMensual(esInicial);
		this.setResaltarhoras_vacacionAsistenciaMensual(esInicial);
		this.setResaltarnumero_diasAsistenciaMensual(esInicial);
		this.setResaltarnumero_nochesAsistenciaMensual(esInicial);
		this.setResaltarnumero_feriadosAsistenciaMensual(esInicial);
		this.setResaltarnumero_trabajoAsistenciaMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.ID)) {
				this.setResaltaridAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.IDMES)) {
				this.setResaltarid_mesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.FECHA)) {
				this.setResaltarfechaAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASTRABAJO)) {
				this.setResaltarhoras_trabajoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASATRASO)) {
				this.setResaltarhoras_atrasoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASFALTAS)) {
				this.setResaltarhoras_faltasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASPERMISO)) {
				this.setResaltarhoras_permisoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA25)) {
				this.setResaltarhoras_extra25AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA50)) {
				this.setResaltarhoras_extra50AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA100)) {
				this.setResaltarhoras_extra100AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA150)) {
				this.setResaltarhoras_extra150AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASEXTRA0)) {
				this.setResaltarhoras_extra0AsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASENFERMO)) {
				this.setResaltarhoras_enfermoAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASMATERNIDAD)) {
				this.setResaltarhoras_maternidadAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.HORASVACACION)) {
				this.setResaltarhoras_vacacionAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMERONOCHES)) {
				this.setResaltarnumero_nochesAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROFERIADOS)) {
				this.setResaltarnumero_feriadosAsistenciaMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaMensualConstantesFunciones.NUMEROTRABAJO)) {
				this.setResaltarnumero_trabajoAsistenciaMensual(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioAsistenciaMensual=true;

	public Boolean getMostrarFK_IdAnioAsistenciaMensual() {
		return this.mostrarFK_IdAnioAsistenciaMensual;
	}

	public void setMostrarFK_IdAnioAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioAsistenciaMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCargoAsistenciaMensual=true;

	public Boolean getMostrarFK_IdCargoAsistenciaMensual() {
		return this.mostrarFK_IdCargoAsistenciaMensual;
	}

	public void setMostrarFK_IdCargoAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoAsistenciaMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoAsistenciaMensual=true;

	public Boolean getMostrarFK_IdEmpleadoAsistenciaMensual() {
		return this.mostrarFK_IdEmpleadoAsistenciaMensual;
	}

	public void setMostrarFK_IdEmpleadoAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAsistenciaMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAsistenciaMensual=true;

	public Boolean getMostrarFK_IdEmpresaAsistenciaMensual() {
		return this.mostrarFK_IdEmpresaAsistenciaMensual;
	}

	public void setMostrarFK_IdEmpresaAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAsistenciaMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraAsistenciaMensual=true;

	public Boolean getMostrarFK_IdEstructuraAsistenciaMensual() {
		return this.mostrarFK_IdEstructuraAsistenciaMensual;
	}

	public void setMostrarFK_IdEstructuraAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraAsistenciaMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesAsistenciaMensual=true;

	public Boolean getMostrarFK_IdMesAsistenciaMensual() {
		return this.mostrarFK_IdMesAsistenciaMensual;
	}

	public void setMostrarFK_IdMesAsistenciaMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesAsistenciaMensual= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioAsistenciaMensual=true;

	public Boolean getActivarFK_IdAnioAsistenciaMensual() {
		return this.activarFK_IdAnioAsistenciaMensual;
	}

	public void setActivarFK_IdAnioAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdAnioAsistenciaMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdCargoAsistenciaMensual=true;

	public Boolean getActivarFK_IdCargoAsistenciaMensual() {
		return this.activarFK_IdCargoAsistenciaMensual;
	}

	public void setActivarFK_IdCargoAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdCargoAsistenciaMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoAsistenciaMensual=true;

	public Boolean getActivarFK_IdEmpleadoAsistenciaMensual() {
		return this.activarFK_IdEmpleadoAsistenciaMensual;
	}

	public void setActivarFK_IdEmpleadoAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAsistenciaMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAsistenciaMensual=true;

	public Boolean getActivarFK_IdEmpresaAsistenciaMensual() {
		return this.activarFK_IdEmpresaAsistenciaMensual;
	}

	public void setActivarFK_IdEmpresaAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAsistenciaMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraAsistenciaMensual=true;

	public Boolean getActivarFK_IdEstructuraAsistenciaMensual() {
		return this.activarFK_IdEstructuraAsistenciaMensual;
	}

	public void setActivarFK_IdEstructuraAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraAsistenciaMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdMesAsistenciaMensual=true;

	public Boolean getActivarFK_IdMesAsistenciaMensual() {
		return this.activarFK_IdMesAsistenciaMensual;
	}

	public void setActivarFK_IdMesAsistenciaMensual(Boolean habilitarResaltar) {
		this.activarFK_IdMesAsistenciaMensual= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioAsistenciaMensual=null;

	public Border getResaltarFK_IdAnioAsistenciaMensual() {
		return this.resaltarFK_IdAnioAsistenciaMensual;
	}

	public void setResaltarFK_IdAnioAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdAnioAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdAnioAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioAsistenciaMensual= borderResaltar;
	}

	public Border resaltarFK_IdCargoAsistenciaMensual=null;

	public Border getResaltarFK_IdCargoAsistenciaMensual() {
		return this.resaltarFK_IdCargoAsistenciaMensual;
	}

	public void setResaltarFK_IdCargoAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdCargoAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdCargoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoAsistenciaMensual= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoAsistenciaMensual=null;

	public Border getResaltarFK_IdEmpleadoAsistenciaMensual() {
		return this.resaltarFK_IdEmpleadoAsistenciaMensual;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAsistenciaMensual= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAsistenciaMensual=null;

	public Border getResaltarFK_IdEmpresaAsistenciaMensual() {
		return this.resaltarFK_IdEmpresaAsistenciaMensual;
	}

	public void setResaltarFK_IdEmpresaAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAsistenciaMensual= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraAsistenciaMensual=null;

	public Border getResaltarFK_IdEstructuraAsistenciaMensual() {
		return this.resaltarFK_IdEstructuraAsistenciaMensual;
	}

	public void setResaltarFK_IdEstructuraAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdEstructuraAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraAsistenciaMensual= borderResaltar;
	}

	public Border resaltarFK_IdMesAsistenciaMensual=null;

	public Border getResaltarFK_IdMesAsistenciaMensual() {
		return this.resaltarFK_IdMesAsistenciaMensual;
	}

	public void setResaltarFK_IdMesAsistenciaMensual(Border borderResaltar) {
		this.resaltarFK_IdMesAsistenciaMensual= borderResaltar;
	}

	public void setResaltarFK_IdMesAsistenciaMensual(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaMensualBeanSwingJInternalFrame asistenciamensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesAsistenciaMensual= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
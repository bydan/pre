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


import com.bydan.erp.nomina.util.GastoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.GastoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.GastoEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GastoEmpleadoConstantesFunciones extends GastoEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GastoEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GastoEmpleado"+GastoEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GastoEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GastoEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GastoEmpleadoConstantesFunciones.SCHEMA+"_"+GastoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GastoEmpleadoConstantesFunciones.SCHEMA+"_"+GastoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GastoEmpleadoConstantesFunciones.SCHEMA+"_"+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GastoEmpleadoConstantesFunciones.SCHEMA+"_"+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GastoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GastoEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GastoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GastoEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Gasto Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Gasto Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Gasto Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GastoEmpleado";
	public static final String OBJECTNAME="gastoempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="gasto_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select gastoempleado from "+GastoEmpleadoConstantesFunciones.SPERSISTENCENAME+" gastoempleado";
	public static String QUERYSELECTNATIVE="select "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_pais,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_ciudad,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".dia,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_usuario,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_estado_gasto_empleado,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso_actual,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso_otro,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_vivienda,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_educacion,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_salud,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_vestimenta,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_alimentacion,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_gasto_actual,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_gasto,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".fecha,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".porcentaje,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".valor_maximo,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".valor_maximo_porcentaje from "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+GastoEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GastoEmpleadoConstantesFuncionesAdditional gastoempleadoConstantesFuncionesAdditional=null;
	
	public GastoEmpleadoConstantesFuncionesAdditional getGastoEmpleadoConstantesFuncionesAdditional() {
		return this.gastoempleadoConstantesFuncionesAdditional;
	}
	
	public void setGastoEmpleadoConstantesFuncionesAdditional(GastoEmpleadoConstantesFuncionesAdditional gastoempleadoConstantesFuncionesAdditional) {
		try {
			this.gastoempleadoConstantesFuncionesAdditional=gastoempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String DIA= "dia";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDESTADOGASTOEMPLEADO= "id_estado_gasto_empleado";
    public static final String TOTALINGRESOACTUAL= "total_ingreso_actual";
    public static final String TOTALINGRESOOTRO= "total_ingreso_otro";
    public static final String TOTALINGRESO= "total_ingreso";
    public static final String GASTOVIVIENDA= "gasto_vivienda";
    public static final String GASTOEDUCACION= "gasto_educacion";
    public static final String GASTOSALUD= "gasto_salud";
    public static final String GASTOVESTIMENTA= "gasto_vestimenta";
    public static final String GASTOALIMENTACION= "gasto_alimentacion";
    public static final String TOTALGASTOACTUAL= "total_gasto_actual";
    public static final String TOTALGASTO= "total_gasto";
    public static final String FECHA= "fecha";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALORMAXIMO= "valor_maximo";
    public static final String VALORMAXIMOPORCENTAJE= "valor_maximo_porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_DIA= "Dia";
		public static final String LABEL_DIA_LOWER= "Dia";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDESTADOGASTOEMPLEADO= "Estado Gasto Empleado";
		public static final String LABEL_IDESTADOGASTOEMPLEADO_LOWER= "Estado Gasto Empleado";
    	public static final String LABEL_TOTALINGRESOACTUAL= "Total Ingreso Actual";
		public static final String LABEL_TOTALINGRESOACTUAL_LOWER= "Total Ingreso Actual";
    	public static final String LABEL_TOTALINGRESOOTRO= "Total Ingreso Otro";
		public static final String LABEL_TOTALINGRESOOTRO_LOWER= "Total Ingreso Otro";
    	public static final String LABEL_TOTALINGRESO= "Total Ingreso";
		public static final String LABEL_TOTALINGRESO_LOWER= "Total Ingreso";
    	public static final String LABEL_GASTOVIVIENDA= "Gasto Vivienda";
		public static final String LABEL_GASTOVIVIENDA_LOWER= "Gasto Vivienda";
    	public static final String LABEL_GASTOEDUCACION= "Gasto Educacion";
		public static final String LABEL_GASTOEDUCACION_LOWER= "Gasto Educacion";
    	public static final String LABEL_GASTOSALUD= "Gasto Salud";
		public static final String LABEL_GASTOSALUD_LOWER= "Gasto Salud";
    	public static final String LABEL_GASTOVESTIMENTA= "Gasto Vestimenta";
		public static final String LABEL_GASTOVESTIMENTA_LOWER= "Gasto Vestimenta";
    	public static final String LABEL_GASTOALIMENTACION= "Gasto Alimentacion";
		public static final String LABEL_GASTOALIMENTACION_LOWER= "Gasto Alimentacion";
    	public static final String LABEL_TOTALGASTOACTUAL= "Total Gasto Actual";
		public static final String LABEL_TOTALGASTOACTUAL_LOWER= "Total Gasto Actual";
    	public static final String LABEL_TOTALGASTO= "Total Gasto";
		public static final String LABEL_TOTALGASTO_LOWER= "Total Gasto";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALORMAXIMO= "Valor Maximo";
		public static final String LABEL_VALORMAXIMO_LOWER= "Valor Maximo";
    	public static final String LABEL_VALORMAXIMOPORCENTAJE= "Valor Maximo Porcentaje";
		public static final String LABEL_VALORMAXIMOPORCENTAJE_LOWER= "Valor Maximo Porcentaje";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getGastoEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDPAIS)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDCIUDAD)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDANIO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDMES)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.DIA)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_DIA;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDUSUARIO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_IDESTADOGASTOEMPLEADO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.GASTOEDUCACION)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.GASTOSALUD)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.TOTALGASTO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.FECHA)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.PORCENTAJE)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMO)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO;}
		if(sNombreColumna.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE)) {sLabelColumna=GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGastoEmpleadoDescripcion(GastoEmpleado gastoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(gastoempleado !=null/* && gastoempleado.getId()!=0*/) {
			if(gastoempleado.getId()!=null) {
				sDescripcion=gastoempleado.getId().toString();
			}//gastoempleadogastoempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGastoEmpleadoDescripcionDetallado(GastoEmpleado gastoempleado) {
		String sDescripcion="";
			
		sDescripcion+=GastoEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=gastoempleado.getId().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=gastoempleado.getVersionRow().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=gastoempleado.getid_empresa().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=gastoempleado.getid_sucursal().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=gastoempleado.getid_empleado().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=gastoempleado.getid_ejercicio().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=gastoempleado.getid_pais().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=gastoempleado.getid_ciudad().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=gastoempleado.getid_anio().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDMES+"=";
		sDescripcion+=gastoempleado.getid_mes().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.DIA+"=";
		sDescripcion+=gastoempleado.getdia().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=gastoempleado.getid_usuario().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO+"=";
		sDescripcion+=gastoempleado.getid_estado_gasto_empleado().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL+"=";
		sDescripcion+=gastoempleado.gettotal_ingreso_actual().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO+"=";
		sDescripcion+=gastoempleado.gettotal_ingreso_otro().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.TOTALINGRESO+"=";
		sDescripcion+=gastoempleado.gettotal_ingreso().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.GASTOVIVIENDA+"=";
		sDescripcion+=gastoempleado.getgasto_vivienda().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.GASTOEDUCACION+"=";
		sDescripcion+=gastoempleado.getgasto_educacion().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.GASTOSALUD+"=";
		sDescripcion+=gastoempleado.getgasto_salud().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA+"=";
		sDescripcion+=gastoempleado.getgasto_vestimenta().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.GASTOALIMENTACION+"=";
		sDescripcion+=gastoempleado.getgasto_alimentacion().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL+"=";
		sDescripcion+=gastoempleado.gettotal_gasto_actual().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.TOTALGASTO+"=";
		sDescripcion+=gastoempleado.gettotal_gasto().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.FECHA+"=";
		sDescripcion+=gastoempleado.getfecha().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=gastoempleado.getporcentaje().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.VALORMAXIMO+"=";
		sDescripcion+=gastoempleado.getvalor_maximo().toString()+",";
		sDescripcion+=GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE+"=";
		sDescripcion+=gastoempleado.getvalor_maximo_porcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGastoEmpleadoDescripcion(GastoEmpleado gastoempleado,String sValor) throws Exception {			
		if(gastoempleado !=null) {
			//gastoempleadogastoempleado.getId().toString();
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getEstadoGastoEmpleadoDescripcion(EstadoGastoEmpleado estadogastoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadogastoempleado!=null/*&&estadogastoempleado.getId()>0*/) {
			sDescripcion=EstadoGastoEmpleadoConstantesFunciones.getEstadoGastoEmpleadoDescripcion(estadogastoempleado);
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
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoGastoEmpleado")) {
			sNombreIndice="Tipo=  Por Estado Gasto Empleado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoGastoEmpleado(Long id_estado_gasto_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_gasto_empleado!=null) {sDetalleIndice+=" Codigo Unico De Estado Gasto Empleado="+id_estado_gasto_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGastoEmpleado(GastoEmpleado gastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosGastoEmpleados(List<GastoEmpleado> gastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GastoEmpleado gastoempleado: gastoempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoEmpleado(GastoEmpleado gastoempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && gastoempleado.getConCambioAuxiliar()) {
			gastoempleado.setIsDeleted(gastoempleado.getIsDeletedAuxiliar());	
			gastoempleado.setIsNew(gastoempleado.getIsNewAuxiliar());	
			gastoempleado.setIsChanged(gastoempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			gastoempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			gastoempleado.setIsDeletedAuxiliar(false);	
			gastoempleado.setIsNewAuxiliar(false);	
			gastoempleado.setIsChangedAuxiliar(false);
			
			gastoempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoEmpleados(List<GastoEmpleado> gastoempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GastoEmpleado gastoempleado : gastoempleados) {
			if(conAsignarBase && gastoempleado.getConCambioAuxiliar()) {
				gastoempleado.setIsDeleted(gastoempleado.getIsDeletedAuxiliar());	
				gastoempleado.setIsNew(gastoempleado.getIsNewAuxiliar());	
				gastoempleado.setIsChanged(gastoempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				gastoempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				gastoempleado.setIsDeletedAuxiliar(false);	
				gastoempleado.setIsNewAuxiliar(false);	
				gastoempleado.setIsChangedAuxiliar(false);
				
				gastoempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGastoEmpleado(GastoEmpleado gastoempleado,Boolean conEnteros) throws Exception  {
		gastoempleado.settotal_ingreso_actual(0.0);
		gastoempleado.settotal_ingreso_otro(0.0);
		gastoempleado.settotal_ingreso(0.0);
		gastoempleado.setgasto_vivienda(0.0);
		gastoempleado.setgasto_educacion(0.0);
		gastoempleado.setgasto_salud(0.0);
		gastoempleado.setgasto_vestimenta(0.0);
		gastoempleado.setgasto_alimentacion(0.0);
		gastoempleado.settotal_gasto_actual(0.0);
		gastoempleado.settotal_gasto(0.0);
		gastoempleado.setporcentaje(0.0);
		gastoempleado.setvalor_maximo(0.0);
		gastoempleado.setvalor_maximo_porcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			gastoempleado.setdia(0);
		}
	}		
	
	public static void InicializarValoresGastoEmpleados(List<GastoEmpleado> gastoempleados,Boolean conEnteros) throws Exception  {
		
		for(GastoEmpleado gastoempleado: gastoempleados) {
			gastoempleado.settotal_ingreso_actual(0.0);
			gastoempleado.settotal_ingreso_otro(0.0);
			gastoempleado.settotal_ingreso(0.0);
			gastoempleado.setgasto_vivienda(0.0);
			gastoempleado.setgasto_educacion(0.0);
			gastoempleado.setgasto_salud(0.0);
			gastoempleado.setgasto_vestimenta(0.0);
			gastoempleado.setgasto_alimentacion(0.0);
			gastoempleado.settotal_gasto_actual(0.0);
			gastoempleado.settotal_gasto(0.0);
			gastoempleado.setporcentaje(0.0);
			gastoempleado.setvalor_maximo(0.0);
			gastoempleado.setvalor_maximo_porcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				gastoempleado.setdia(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaGastoEmpleado(List<GastoEmpleado> gastoempleados,GastoEmpleado gastoempleadoAux) throws Exception  {
		GastoEmpleadoConstantesFunciones.InicializarValoresGastoEmpleado(gastoempleadoAux,true);
		
		for(GastoEmpleado gastoempleado: gastoempleados) {
			if(gastoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			gastoempleadoAux.setdia(gastoempleadoAux.getdia()+gastoempleado.getdia());			
			gastoempleadoAux.settotal_ingreso_actual(gastoempleadoAux.gettotal_ingreso_actual()+gastoempleado.gettotal_ingreso_actual());			
			gastoempleadoAux.settotal_ingreso_otro(gastoempleadoAux.gettotal_ingreso_otro()+gastoempleado.gettotal_ingreso_otro());			
			gastoempleadoAux.settotal_ingreso(gastoempleadoAux.gettotal_ingreso()+gastoempleado.gettotal_ingreso());			
			gastoempleadoAux.setgasto_vivienda(gastoempleadoAux.getgasto_vivienda()+gastoempleado.getgasto_vivienda());			
			gastoempleadoAux.setgasto_educacion(gastoempleadoAux.getgasto_educacion()+gastoempleado.getgasto_educacion());			
			gastoempleadoAux.setgasto_salud(gastoempleadoAux.getgasto_salud()+gastoempleado.getgasto_salud());			
			gastoempleadoAux.setgasto_vestimenta(gastoempleadoAux.getgasto_vestimenta()+gastoempleado.getgasto_vestimenta());			
			gastoempleadoAux.setgasto_alimentacion(gastoempleadoAux.getgasto_alimentacion()+gastoempleado.getgasto_alimentacion());			
			gastoempleadoAux.settotal_gasto_actual(gastoempleadoAux.gettotal_gasto_actual()+gastoempleado.gettotal_gasto_actual());			
			gastoempleadoAux.settotal_gasto(gastoempleadoAux.gettotal_gasto()+gastoempleado.gettotal_gasto());			
			gastoempleadoAux.setporcentaje(gastoempleadoAux.getporcentaje()+gastoempleado.getporcentaje());			
			gastoempleadoAux.setvalor_maximo(gastoempleadoAux.getvalor_maximo()+gastoempleado.getvalor_maximo());			
			gastoempleadoAux.setvalor_maximo_porcentaje(gastoempleadoAux.getvalor_maximo_porcentaje()+gastoempleado.getvalor_maximo_porcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GastoEmpleadoConstantesFunciones.getArrayColumnasGlobalesGastoEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoEmpleadoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoEmpleadoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoEmpleadoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoEmpleadoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GastoEmpleado> gastoempleados,GastoEmpleado gastoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GastoEmpleado gastoempleadoAux: gastoempleados) {
			if(gastoempleadoAux!=null && gastoempleado!=null) {
				if((gastoempleadoAux.getId()==null && gastoempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(gastoempleadoAux.getId()!=null && gastoempleado.getId()!=null){
					if(gastoempleadoAux.getId().equals(gastoempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGastoEmpleado(List<GastoEmpleado> gastoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ingreso_actualTotal=0.0;
		Double total_ingreso_otroTotal=0.0;
		Double total_ingresoTotal=0.0;
		Double gasto_viviendaTotal=0.0;
		Double gasto_educacionTotal=0.0;
		Double gasto_saludTotal=0.0;
		Double gasto_vestimentaTotal=0.0;
		Double gasto_alimentacionTotal=0.0;
		Double total_gasto_actualTotal=0.0;
		Double total_gastoTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valor_maximoTotal=0.0;
		Double valor_maximo_porcentajeTotal=0.0;
	
		for(GastoEmpleado gastoempleado: gastoempleados) {			
			if(gastoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ingreso_actualTotal+=gastoempleado.gettotal_ingreso_actual();
			total_ingreso_otroTotal+=gastoempleado.gettotal_ingreso_otro();
			total_ingresoTotal+=gastoempleado.gettotal_ingreso();
			gasto_viviendaTotal+=gastoempleado.getgasto_vivienda();
			gasto_educacionTotal+=gastoempleado.getgasto_educacion();
			gasto_saludTotal+=gastoempleado.getgasto_salud();
			gasto_vestimentaTotal+=gastoempleado.getgasto_vestimenta();
			gasto_alimentacionTotal+=gastoempleado.getgasto_alimentacion();
			total_gasto_actualTotal+=gastoempleado.gettotal_gasto_actual();
			total_gastoTotal+=gastoempleado.gettotal_gasto();
			porcentajeTotal+=gastoempleado.getporcentaje();
			valor_maximoTotal+=gastoempleado.getvalor_maximo();
			valor_maximo_porcentajeTotal+=gastoempleado.getvalor_maximo_porcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL);
		datoGeneral.setdValorDouble(total_ingreso_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO);
		datoGeneral.setdValorDouble(total_ingreso_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALINGRESO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO);
		datoGeneral.setdValorDouble(total_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA);
		datoGeneral.setdValorDouble(gasto_viviendaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOEDUCACION);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION);
		datoGeneral.setdValorDouble(gasto_educacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOSALUD);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD);
		datoGeneral.setdValorDouble(gasto_saludTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA);
		datoGeneral.setdValorDouble(gasto_vestimentaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION);
		datoGeneral.setdValorDouble(gasto_alimentacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL);
		datoGeneral.setdValorDouble(total_gasto_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.TOTALGASTO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO);
		datoGeneral.setdValorDouble(total_gastoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.VALORMAXIMO);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO);
		datoGeneral.setdValorDouble(valor_maximoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE);
		datoGeneral.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE);
		datoGeneral.setdValorDouble(valor_maximo_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGastoEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_ID, GastoEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_VERSIONROW, GastoEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDEMPRESA, GastoEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDSUCURSAL, GastoEmpleadoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, GastoEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDEJERCICIO, GastoEmpleadoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDPAIS, GastoEmpleadoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDCIUDAD, GastoEmpleadoConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDANIO, GastoEmpleadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDMES, GastoEmpleadoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_DIA, GastoEmpleadoConstantesFunciones.DIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDUSUARIO, GastoEmpleadoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_IDESTADOGASTOEMPLEADO, GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL, GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO, GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO, GastoEmpleadoConstantesFunciones.TOTALINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA, GastoEmpleadoConstantesFunciones.GASTOVIVIENDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION, GastoEmpleadoConstantesFunciones.GASTOEDUCACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD, GastoEmpleadoConstantesFunciones.GASTOSALUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA, GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION, GastoEmpleadoConstantesFunciones.GASTOALIMENTACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL, GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO, GastoEmpleadoConstantesFunciones.TOTALGASTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_FECHA, GastoEmpleadoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE, GastoEmpleadoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO, GastoEmpleadoConstantesFunciones.VALORMAXIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE, GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGastoEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.DIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.TOTALINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.GASTOVIVIENDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.GASTOEDUCACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.GASTOSALUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.GASTOALIMENTACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.TOTALGASTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.VALORMAXIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoEmpleado() throws Exception  {
		return GastoEmpleadoConstantesFunciones.getTiposSeleccionarGastoEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoEmpleado(Boolean conFk) throws Exception  {
		return GastoEmpleadoConstantesFunciones.getTiposSeleccionarGastoEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_DIA);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_DIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_IDESTADOGASTOEMPLEADO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_IDESTADOGASTOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE);
			reporte.setsDescripcion(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGastoEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGastoEmpleado(GastoEmpleado gastoempleadoAux) throws Exception {
		
			gastoempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastoempleadoAux.getEmpresa()));
			gastoempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(gastoempleadoAux.getSucursal()));
			gastoempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(gastoempleadoAux.getEmpleado()));
			gastoempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(gastoempleadoAux.getEjercicio()));
			gastoempleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(gastoempleadoAux.getPais()));
			gastoempleadoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(gastoempleadoAux.getCiudad()));
			gastoempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(gastoempleadoAux.getAnio()));
			gastoempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(gastoempleadoAux.getMes()));
			gastoempleadoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(gastoempleadoAux.getUsuario()));
			gastoempleadoAux.setestadogastoempleado_descripcion(EstadoGastoEmpleadoConstantesFunciones.getEstadoGastoEmpleadoDescripcion(gastoempleadoAux.getEstadoGastoEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGastoEmpleado(List<GastoEmpleado> gastoempleadosTemp) throws Exception {
		for(GastoEmpleado gastoempleadoAux:gastoempleadosTemp) {
			
			gastoempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastoempleadoAux.getEmpresa()));
			gastoempleadoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(gastoempleadoAux.getSucursal()));
			gastoempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(gastoempleadoAux.getEmpleado()));
			gastoempleadoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(gastoempleadoAux.getEjercicio()));
			gastoempleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(gastoempleadoAux.getPais()));
			gastoempleadoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(gastoempleadoAux.getCiudad()));
			gastoempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(gastoempleadoAux.getAnio()));
			gastoempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(gastoempleadoAux.getMes()));
			gastoempleadoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(gastoempleadoAux.getUsuario()));
			gastoempleadoAux.setestadogastoempleado_descripcion(EstadoGastoEmpleadoConstantesFunciones.getEstadoGastoEmpleadoDescripcion(gastoempleadoAux.getEstadoGastoEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(EstadoGastoEmpleado.class));
				
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
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoGastoEmpleado.class)) {
						classes.add(new Classe(EstadoGastoEmpleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(EstadoGastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoGastoEmpleado.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(EstadoGastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoGastoEmpleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoEmpleadoConstantesFunciones.getClassesRelationshipsOfGastoEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfGastoEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(GastoEmpleado gastoempleado,List<GastoEmpleado> gastoempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GastoEmpleado gastoempleadoEncontrado=null;
			
			for(GastoEmpleado gastoempleadoLocal:gastoempleados) {
				if(gastoempleadoLocal.getId().equals(gastoempleado.getId())) {
					gastoempleadoEncontrado=gastoempleadoLocal;
					
					gastoempleadoLocal.setIsChanged(gastoempleado.getIsChanged());
					gastoempleadoLocal.setIsNew(gastoempleado.getIsNew());
					gastoempleadoLocal.setIsDeleted(gastoempleado.getIsDeleted());
					
					gastoempleadoLocal.setGeneralEntityOriginal(gastoempleado.getGeneralEntityOriginal());
					
					gastoempleadoLocal.setId(gastoempleado.getId());	
					gastoempleadoLocal.setVersionRow(gastoempleado.getVersionRow());	
					gastoempleadoLocal.setid_empresa(gastoempleado.getid_empresa());	
					gastoempleadoLocal.setid_sucursal(gastoempleado.getid_sucursal());	
					gastoempleadoLocal.setid_empleado(gastoempleado.getid_empleado());	
					gastoempleadoLocal.setid_ejercicio(gastoempleado.getid_ejercicio());	
					gastoempleadoLocal.setid_pais(gastoempleado.getid_pais());	
					gastoempleadoLocal.setid_ciudad(gastoempleado.getid_ciudad());	
					gastoempleadoLocal.setid_anio(gastoempleado.getid_anio());	
					gastoempleadoLocal.setid_mes(gastoempleado.getid_mes());	
					gastoempleadoLocal.setdia(gastoempleado.getdia());	
					gastoempleadoLocal.setid_usuario(gastoempleado.getid_usuario());	
					gastoempleadoLocal.setid_estado_gasto_empleado(gastoempleado.getid_estado_gasto_empleado());	
					gastoempleadoLocal.settotal_ingreso_actual(gastoempleado.gettotal_ingreso_actual());	
					gastoempleadoLocal.settotal_ingreso_otro(gastoempleado.gettotal_ingreso_otro());	
					gastoempleadoLocal.settotal_ingreso(gastoempleado.gettotal_ingreso());	
					gastoempleadoLocal.setgasto_vivienda(gastoempleado.getgasto_vivienda());	
					gastoempleadoLocal.setgasto_educacion(gastoempleado.getgasto_educacion());	
					gastoempleadoLocal.setgasto_salud(gastoempleado.getgasto_salud());	
					gastoempleadoLocal.setgasto_vestimenta(gastoempleado.getgasto_vestimenta());	
					gastoempleadoLocal.setgasto_alimentacion(gastoempleado.getgasto_alimentacion());	
					gastoempleadoLocal.settotal_gasto_actual(gastoempleado.gettotal_gasto_actual());	
					gastoempleadoLocal.settotal_gasto(gastoempleado.gettotal_gasto());	
					gastoempleadoLocal.setfecha(gastoempleado.getfecha());	
					gastoempleadoLocal.setporcentaje(gastoempleado.getporcentaje());	
					gastoempleadoLocal.setvalor_maximo(gastoempleado.getvalor_maximo());	
					gastoempleadoLocal.setvalor_maximo_porcentaje(gastoempleado.getvalor_maximo_porcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!gastoempleado.getIsDeleted()) {
				if(!existe) {
					gastoempleados.add(gastoempleado);
				}
			} else {
				if(gastoempleadoEncontrado!=null && permiteQuitar)  {
					gastoempleados.remove(gastoempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GastoEmpleado gastoempleado,List<GastoEmpleado> gastoempleados) throws Exception {
		try	{			
			for(GastoEmpleado gastoempleadoLocal:gastoempleados) {
				if(gastoempleadoLocal.getId().equals(gastoempleado.getId())) {
					gastoempleadoLocal.setIsSelected(gastoempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGastoEmpleado(List<GastoEmpleado> gastoempleadosAux) throws Exception {
		//this.gastoempleadosAux=gastoempleadosAux;
		
		for(GastoEmpleado gastoempleadoAux:gastoempleadosAux) {
			if(gastoempleadoAux.getIsChanged()) {
				gastoempleadoAux.setIsChanged(false);
			}		
			
			if(gastoempleadoAux.getIsNew()) {
				gastoempleadoAux.setIsNew(false);
			}	
			
			if(gastoempleadoAux.getIsDeleted()) {
				gastoempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGastoEmpleado(GastoEmpleado gastoempleadoAux) throws Exception {
		//this.gastoempleadoAux=gastoempleadoAux;
		
			if(gastoempleadoAux.getIsChanged()) {
				gastoempleadoAux.setIsChanged(false);
			}		
			
			if(gastoempleadoAux.getIsNew()) {
				gastoempleadoAux.setIsNew(false);
			}	
			
			if(gastoempleadoAux.getIsDeleted()) {
				gastoempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GastoEmpleado gastoempleadoAsignar,GastoEmpleado gastoempleado) throws Exception {
		gastoempleadoAsignar.setId(gastoempleado.getId());	
		gastoempleadoAsignar.setVersionRow(gastoempleado.getVersionRow());	
		gastoempleadoAsignar.setid_empresa(gastoempleado.getid_empresa());
		gastoempleadoAsignar.setempresa_descripcion(gastoempleado.getempresa_descripcion());	
		gastoempleadoAsignar.setid_sucursal(gastoempleado.getid_sucursal());
		gastoempleadoAsignar.setsucursal_descripcion(gastoempleado.getsucursal_descripcion());	
		gastoempleadoAsignar.setid_empleado(gastoempleado.getid_empleado());
		gastoempleadoAsignar.setempleado_descripcion(gastoempleado.getempleado_descripcion());	
		gastoempleadoAsignar.setid_ejercicio(gastoempleado.getid_ejercicio());
		gastoempleadoAsignar.setejercicio_descripcion(gastoempleado.getejercicio_descripcion());	
		gastoempleadoAsignar.setid_pais(gastoempleado.getid_pais());
		gastoempleadoAsignar.setpais_descripcion(gastoempleado.getpais_descripcion());	
		gastoempleadoAsignar.setid_ciudad(gastoempleado.getid_ciudad());
		gastoempleadoAsignar.setciudad_descripcion(gastoempleado.getciudad_descripcion());	
		gastoempleadoAsignar.setid_anio(gastoempleado.getid_anio());
		gastoempleadoAsignar.setanio_descripcion(gastoempleado.getanio_descripcion());	
		gastoempleadoAsignar.setid_mes(gastoempleado.getid_mes());
		gastoempleadoAsignar.setmes_descripcion(gastoempleado.getmes_descripcion());	
		gastoempleadoAsignar.setdia(gastoempleado.getdia());	
		gastoempleadoAsignar.setid_usuario(gastoempleado.getid_usuario());
		gastoempleadoAsignar.setusuario_descripcion(gastoempleado.getusuario_descripcion());	
		gastoempleadoAsignar.setid_estado_gasto_empleado(gastoempleado.getid_estado_gasto_empleado());
		gastoempleadoAsignar.setestadogastoempleado_descripcion(gastoempleado.getestadogastoempleado_descripcion());	
		gastoempleadoAsignar.settotal_ingreso_actual(gastoempleado.gettotal_ingreso_actual());	
		gastoempleadoAsignar.settotal_ingreso_otro(gastoempleado.gettotal_ingreso_otro());	
		gastoempleadoAsignar.settotal_ingreso(gastoempleado.gettotal_ingreso());	
		gastoempleadoAsignar.setgasto_vivienda(gastoempleado.getgasto_vivienda());	
		gastoempleadoAsignar.setgasto_educacion(gastoempleado.getgasto_educacion());	
		gastoempleadoAsignar.setgasto_salud(gastoempleado.getgasto_salud());	
		gastoempleadoAsignar.setgasto_vestimenta(gastoempleado.getgasto_vestimenta());	
		gastoempleadoAsignar.setgasto_alimentacion(gastoempleado.getgasto_alimentacion());	
		gastoempleadoAsignar.settotal_gasto_actual(gastoempleado.gettotal_gasto_actual());	
		gastoempleadoAsignar.settotal_gasto(gastoempleado.gettotal_gasto());	
		gastoempleadoAsignar.setfecha(gastoempleado.getfecha());	
		gastoempleadoAsignar.setporcentaje(gastoempleado.getporcentaje());	
		gastoempleadoAsignar.setvalor_maximo(gastoempleado.getvalor_maximo());	
		gastoempleadoAsignar.setvalor_maximo_porcentaje(gastoempleado.getvalor_maximo_porcentaje());	
	}
	
	public static void inicializarGastoEmpleado(GastoEmpleado gastoempleado) throws Exception {
		try {
				gastoempleado.setId(0L);	
					
				gastoempleado.setid_empresa(-1L);	
				gastoempleado.setid_sucursal(-1L);	
				gastoempleado.setid_empleado(-1L);	
				gastoempleado.setid_ejercicio(-1L);	
				gastoempleado.setid_pais(-1L);	
				gastoempleado.setid_ciudad(-1L);	
				gastoempleado.setid_anio(null);	
				gastoempleado.setid_mes(null);	
				gastoempleado.setdia(0);	
				gastoempleado.setid_usuario(-1L);	
				gastoempleado.setid_estado_gasto_empleado(-1L);	
				gastoempleado.settotal_ingreso_actual(0.0);	
				gastoempleado.settotal_ingreso_otro(0.0);	
				gastoempleado.settotal_ingreso(0.0);	
				gastoempleado.setgasto_vivienda(0.0);	
				gastoempleado.setgasto_educacion(0.0);	
				gastoempleado.setgasto_salud(0.0);	
				gastoempleado.setgasto_vestimenta(0.0);	
				gastoempleado.setgasto_alimentacion(0.0);	
				gastoempleado.settotal_gasto_actual(0.0);	
				gastoempleado.settotal_gasto(0.0);	
				gastoempleado.setfecha(new Date());	
				gastoempleado.setporcentaje(0.0);	
				gastoempleado.setvalor_maximo(0.0);	
				gastoempleado.setvalor_maximo_porcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGastoEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_DIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_IDESTADOGASTOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESOOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_TOTALINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_GASTOVIVIENDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_GASTOEDUCACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_GASTOSALUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_GASTOVESTIMENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_GASTOALIMENTACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTOACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_TOTALGASTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoEmpleadoConstantesFunciones.LABEL_VALORMAXIMOPORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGastoEmpleado(String sTipo,Row row,Workbook workbook,GastoEmpleado gastoempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getdia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getestadogastoempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.gettotal_ingreso_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.gettotal_ingreso_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.gettotal_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getgasto_vivienda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getgasto_educacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getgasto_salud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getgasto_vestimenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getgasto_alimentacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.gettotal_gasto_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.gettotal_gasto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getvalor_maximo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastoempleado.getvalor_maximo_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGastoEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGastoEmpleado() {
		return this.sFinalQueryGastoEmpleado;
	}
	
	public void setsFinalQueryGastoEmpleado(String sFinalQueryGastoEmpleado) {
		this.sFinalQueryGastoEmpleado= sFinalQueryGastoEmpleado;
	}
	
	public Border resaltarSeleccionarGastoEmpleado=null;
	
	public Border setResaltarSeleccionarGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGastoEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGastoEmpleado() {
		return this.resaltarSeleccionarGastoEmpleado;
	}
	
	public void setResaltarSeleccionarGastoEmpleado(Border borderResaltarSeleccionarGastoEmpleado) {
		this.resaltarSeleccionarGastoEmpleado= borderResaltarSeleccionarGastoEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGastoEmpleado=null;
	public Boolean mostraridGastoEmpleado=true;
	public Boolean activaridGastoEmpleado=true;

	public Border resaltarid_empresaGastoEmpleado=null;
	public Boolean mostrarid_empresaGastoEmpleado=true;
	public Boolean activarid_empresaGastoEmpleado=true;
	public Boolean cargarid_empresaGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_sucursalGastoEmpleado=null;
	public Boolean mostrarid_sucursalGastoEmpleado=true;
	public Boolean activarid_sucursalGastoEmpleado=true;
	public Boolean cargarid_sucursalGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoGastoEmpleado=null;
	public Boolean mostrarid_empleadoGastoEmpleado=true;
	public Boolean activarid_empleadoGastoEmpleado=true;
	public Boolean cargarid_empleadoGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_ejercicioGastoEmpleado=null;
	public Boolean mostrarid_ejercicioGastoEmpleado=true;
	public Boolean activarid_ejercicioGastoEmpleado=true;
	public Boolean cargarid_ejercicioGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_paisGastoEmpleado=null;
	public Boolean mostrarid_paisGastoEmpleado=true;
	public Boolean activarid_paisGastoEmpleado=true;
	public Boolean cargarid_paisGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_ciudadGastoEmpleado=null;
	public Boolean mostrarid_ciudadGastoEmpleado=true;
	public Boolean activarid_ciudadGastoEmpleado=true;
	public Boolean cargarid_ciudadGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_anioGastoEmpleado=null;
	public Boolean mostrarid_anioGastoEmpleado=true;
	public Boolean activarid_anioGastoEmpleado=true;
	public Boolean cargarid_anioGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_mesGastoEmpleado=null;
	public Boolean mostrarid_mesGastoEmpleado=true;
	public Boolean activarid_mesGastoEmpleado=true;
	public Boolean cargarid_mesGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesGastoEmpleado=false;//ConEventDepend=true

	public Border resaltardiaGastoEmpleado=null;
	public Boolean mostrardiaGastoEmpleado=true;
	public Boolean activardiaGastoEmpleado=true;

	public Border resaltarid_usuarioGastoEmpleado=null;
	public Boolean mostrarid_usuarioGastoEmpleado=true;
	public Boolean activarid_usuarioGastoEmpleado=true;
	public Boolean cargarid_usuarioGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioGastoEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estado_gasto_empleadoGastoEmpleado=null;
	public Boolean mostrarid_estado_gasto_empleadoGastoEmpleado=true;
	public Boolean activarid_estado_gasto_empleadoGastoEmpleado=true;
	public Boolean cargarid_estado_gasto_empleadoGastoEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_gasto_empleadoGastoEmpleado=false;//ConEventDepend=true

	public Border resaltartotal_ingreso_actualGastoEmpleado=null;
	public Boolean mostrartotal_ingreso_actualGastoEmpleado=true;
	public Boolean activartotal_ingreso_actualGastoEmpleado=true;

	public Border resaltartotal_ingreso_otroGastoEmpleado=null;
	public Boolean mostrartotal_ingreso_otroGastoEmpleado=true;
	public Boolean activartotal_ingreso_otroGastoEmpleado=true;

	public Border resaltartotal_ingresoGastoEmpleado=null;
	public Boolean mostrartotal_ingresoGastoEmpleado=true;
	public Boolean activartotal_ingresoGastoEmpleado=true;

	public Border resaltargasto_viviendaGastoEmpleado=null;
	public Boolean mostrargasto_viviendaGastoEmpleado=true;
	public Boolean activargasto_viviendaGastoEmpleado=true;

	public Border resaltargasto_educacionGastoEmpleado=null;
	public Boolean mostrargasto_educacionGastoEmpleado=true;
	public Boolean activargasto_educacionGastoEmpleado=true;

	public Border resaltargasto_saludGastoEmpleado=null;
	public Boolean mostrargasto_saludGastoEmpleado=true;
	public Boolean activargasto_saludGastoEmpleado=true;

	public Border resaltargasto_vestimentaGastoEmpleado=null;
	public Boolean mostrargasto_vestimentaGastoEmpleado=true;
	public Boolean activargasto_vestimentaGastoEmpleado=true;

	public Border resaltargasto_alimentacionGastoEmpleado=null;
	public Boolean mostrargasto_alimentacionGastoEmpleado=true;
	public Boolean activargasto_alimentacionGastoEmpleado=true;

	public Border resaltartotal_gasto_actualGastoEmpleado=null;
	public Boolean mostrartotal_gasto_actualGastoEmpleado=true;
	public Boolean activartotal_gasto_actualGastoEmpleado=true;

	public Border resaltartotal_gastoGastoEmpleado=null;
	public Boolean mostrartotal_gastoGastoEmpleado=true;
	public Boolean activartotal_gastoGastoEmpleado=true;

	public Border resaltarfechaGastoEmpleado=null;
	public Boolean mostrarfechaGastoEmpleado=true;
	public Boolean activarfechaGastoEmpleado=false;

	public Border resaltarporcentajeGastoEmpleado=null;
	public Boolean mostrarporcentajeGastoEmpleado=true;
	public Boolean activarporcentajeGastoEmpleado=true;

	public Border resaltarvalor_maximoGastoEmpleado=null;
	public Boolean mostrarvalor_maximoGastoEmpleado=true;
	public Boolean activarvalor_maximoGastoEmpleado=true;

	public Border resaltarvalor_maximo_porcentajeGastoEmpleado=null;
	public Boolean mostrarvalor_maximo_porcentajeGastoEmpleado=true;
	public Boolean activarvalor_maximo_porcentajeGastoEmpleado=true;

	
	

	public Border setResaltaridGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltaridGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGastoEmpleado() {
		return this.resaltaridGastoEmpleado;
	}

	public void setResaltaridGastoEmpleado(Border borderResaltar) {
		this.resaltaridGastoEmpleado= borderResaltar;
	}

	public Boolean getMostraridGastoEmpleado() {
		return this.mostraridGastoEmpleado;
	}

	public void setMostraridGastoEmpleado(Boolean mostraridGastoEmpleado) {
		this.mostraridGastoEmpleado= mostraridGastoEmpleado;
	}

	public Boolean getActivaridGastoEmpleado() {
		return this.activaridGastoEmpleado;
	}

	public void setActivaridGastoEmpleado(Boolean activaridGastoEmpleado) {
		this.activaridGastoEmpleado= activaridGastoEmpleado;
	}

	public Border setResaltarid_empresaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGastoEmpleado() {
		return this.resaltarid_empresaGastoEmpleado;
	}

	public void setResaltarid_empresaGastoEmpleado(Border borderResaltar) {
		this.resaltarid_empresaGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaGastoEmpleado() {
		return this.mostrarid_empresaGastoEmpleado;
	}

	public void setMostrarid_empresaGastoEmpleado(Boolean mostrarid_empresaGastoEmpleado) {
		this.mostrarid_empresaGastoEmpleado= mostrarid_empresaGastoEmpleado;
	}

	public Boolean getActivarid_empresaGastoEmpleado() {
		return this.activarid_empresaGastoEmpleado;
	}

	public void setActivarid_empresaGastoEmpleado(Boolean activarid_empresaGastoEmpleado) {
		this.activarid_empresaGastoEmpleado= activarid_empresaGastoEmpleado;
	}

	public Boolean getCargarid_empresaGastoEmpleado() {
		return this.cargarid_empresaGastoEmpleado;
	}

	public void setCargarid_empresaGastoEmpleado(Boolean cargarid_empresaGastoEmpleado) {
		this.cargarid_empresaGastoEmpleado= cargarid_empresaGastoEmpleado;
	}

	public Border setResaltarid_sucursalGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_sucursalGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalGastoEmpleado() {
		return this.resaltarid_sucursalGastoEmpleado;
	}

	public void setResaltarid_sucursalGastoEmpleado(Border borderResaltar) {
		this.resaltarid_sucursalGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_sucursalGastoEmpleado() {
		return this.mostrarid_sucursalGastoEmpleado;
	}

	public void setMostrarid_sucursalGastoEmpleado(Boolean mostrarid_sucursalGastoEmpleado) {
		this.mostrarid_sucursalGastoEmpleado= mostrarid_sucursalGastoEmpleado;
	}

	public Boolean getActivarid_sucursalGastoEmpleado() {
		return this.activarid_sucursalGastoEmpleado;
	}

	public void setActivarid_sucursalGastoEmpleado(Boolean activarid_sucursalGastoEmpleado) {
		this.activarid_sucursalGastoEmpleado= activarid_sucursalGastoEmpleado;
	}

	public Boolean getCargarid_sucursalGastoEmpleado() {
		return this.cargarid_sucursalGastoEmpleado;
	}

	public void setCargarid_sucursalGastoEmpleado(Boolean cargarid_sucursalGastoEmpleado) {
		this.cargarid_sucursalGastoEmpleado= cargarid_sucursalGastoEmpleado;
	}

	public Border setResaltarid_empleadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoGastoEmpleado() {
		return this.resaltarid_empleadoGastoEmpleado;
	}

	public void setResaltarid_empleadoGastoEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoGastoEmpleado() {
		return this.mostrarid_empleadoGastoEmpleado;
	}

	public void setMostrarid_empleadoGastoEmpleado(Boolean mostrarid_empleadoGastoEmpleado) {
		this.mostrarid_empleadoGastoEmpleado= mostrarid_empleadoGastoEmpleado;
	}

	public Boolean getActivarid_empleadoGastoEmpleado() {
		return this.activarid_empleadoGastoEmpleado;
	}

	public void setActivarid_empleadoGastoEmpleado(Boolean activarid_empleadoGastoEmpleado) {
		this.activarid_empleadoGastoEmpleado= activarid_empleadoGastoEmpleado;
	}

	public Boolean getCargarid_empleadoGastoEmpleado() {
		return this.cargarid_empleadoGastoEmpleado;
	}

	public void setCargarid_empleadoGastoEmpleado(Boolean cargarid_empleadoGastoEmpleado) {
		this.cargarid_empleadoGastoEmpleado= cargarid_empleadoGastoEmpleado;
	}

	public Border setResaltarid_ejercicioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioGastoEmpleado() {
		return this.resaltarid_ejercicioGastoEmpleado;
	}

	public void setResaltarid_ejercicioGastoEmpleado(Border borderResaltar) {
		this.resaltarid_ejercicioGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioGastoEmpleado() {
		return this.mostrarid_ejercicioGastoEmpleado;
	}

	public void setMostrarid_ejercicioGastoEmpleado(Boolean mostrarid_ejercicioGastoEmpleado) {
		this.mostrarid_ejercicioGastoEmpleado= mostrarid_ejercicioGastoEmpleado;
	}

	public Boolean getActivarid_ejercicioGastoEmpleado() {
		return this.activarid_ejercicioGastoEmpleado;
	}

	public void setActivarid_ejercicioGastoEmpleado(Boolean activarid_ejercicioGastoEmpleado) {
		this.activarid_ejercicioGastoEmpleado= activarid_ejercicioGastoEmpleado;
	}

	public Boolean getCargarid_ejercicioGastoEmpleado() {
		return this.cargarid_ejercicioGastoEmpleado;
	}

	public void setCargarid_ejercicioGastoEmpleado(Boolean cargarid_ejercicioGastoEmpleado) {
		this.cargarid_ejercicioGastoEmpleado= cargarid_ejercicioGastoEmpleado;
	}

	public Border setResaltarid_paisGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_paisGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisGastoEmpleado() {
		return this.resaltarid_paisGastoEmpleado;
	}

	public void setResaltarid_paisGastoEmpleado(Border borderResaltar) {
		this.resaltarid_paisGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_paisGastoEmpleado() {
		return this.mostrarid_paisGastoEmpleado;
	}

	public void setMostrarid_paisGastoEmpleado(Boolean mostrarid_paisGastoEmpleado) {
		this.mostrarid_paisGastoEmpleado= mostrarid_paisGastoEmpleado;
	}

	public Boolean getActivarid_paisGastoEmpleado() {
		return this.activarid_paisGastoEmpleado;
	}

	public void setActivarid_paisGastoEmpleado(Boolean activarid_paisGastoEmpleado) {
		this.activarid_paisGastoEmpleado= activarid_paisGastoEmpleado;
	}

	public Boolean getCargarid_paisGastoEmpleado() {
		return this.cargarid_paisGastoEmpleado;
	}

	public void setCargarid_paisGastoEmpleado(Boolean cargarid_paisGastoEmpleado) {
		this.cargarid_paisGastoEmpleado= cargarid_paisGastoEmpleado;
	}

	public Border setResaltarid_ciudadGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_ciudadGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadGastoEmpleado() {
		return this.resaltarid_ciudadGastoEmpleado;
	}

	public void setResaltarid_ciudadGastoEmpleado(Border borderResaltar) {
		this.resaltarid_ciudadGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_ciudadGastoEmpleado() {
		return this.mostrarid_ciudadGastoEmpleado;
	}

	public void setMostrarid_ciudadGastoEmpleado(Boolean mostrarid_ciudadGastoEmpleado) {
		this.mostrarid_ciudadGastoEmpleado= mostrarid_ciudadGastoEmpleado;
	}

	public Boolean getActivarid_ciudadGastoEmpleado() {
		return this.activarid_ciudadGastoEmpleado;
	}

	public void setActivarid_ciudadGastoEmpleado(Boolean activarid_ciudadGastoEmpleado) {
		this.activarid_ciudadGastoEmpleado= activarid_ciudadGastoEmpleado;
	}

	public Boolean getCargarid_ciudadGastoEmpleado() {
		return this.cargarid_ciudadGastoEmpleado;
	}

	public void setCargarid_ciudadGastoEmpleado(Boolean cargarid_ciudadGastoEmpleado) {
		this.cargarid_ciudadGastoEmpleado= cargarid_ciudadGastoEmpleado;
	}

	public Border setResaltarid_anioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anioGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioGastoEmpleado() {
		return this.resaltarid_anioGastoEmpleado;
	}

	public void setResaltarid_anioGastoEmpleado(Border borderResaltar) {
		this.resaltarid_anioGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anioGastoEmpleado() {
		return this.mostrarid_anioGastoEmpleado;
	}

	public void setMostrarid_anioGastoEmpleado(Boolean mostrarid_anioGastoEmpleado) {
		this.mostrarid_anioGastoEmpleado= mostrarid_anioGastoEmpleado;
	}

	public Boolean getActivarid_anioGastoEmpleado() {
		return this.activarid_anioGastoEmpleado;
	}

	public void setActivarid_anioGastoEmpleado(Boolean activarid_anioGastoEmpleado) {
		this.activarid_anioGastoEmpleado= activarid_anioGastoEmpleado;
	}

	public Boolean getCargarid_anioGastoEmpleado() {
		return this.cargarid_anioGastoEmpleado;
	}

	public void setCargarid_anioGastoEmpleado(Boolean cargarid_anioGastoEmpleado) {
		this.cargarid_anioGastoEmpleado= cargarid_anioGastoEmpleado;
	}

	public Border setResaltarid_mesGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_mesGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesGastoEmpleado() {
		return this.resaltarid_mesGastoEmpleado;
	}

	public void setResaltarid_mesGastoEmpleado(Border borderResaltar) {
		this.resaltarid_mesGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_mesGastoEmpleado() {
		return this.mostrarid_mesGastoEmpleado;
	}

	public void setMostrarid_mesGastoEmpleado(Boolean mostrarid_mesGastoEmpleado) {
		this.mostrarid_mesGastoEmpleado= mostrarid_mesGastoEmpleado;
	}

	public Boolean getActivarid_mesGastoEmpleado() {
		return this.activarid_mesGastoEmpleado;
	}

	public void setActivarid_mesGastoEmpleado(Boolean activarid_mesGastoEmpleado) {
		this.activarid_mesGastoEmpleado= activarid_mesGastoEmpleado;
	}

	public Boolean getCargarid_mesGastoEmpleado() {
		return this.cargarid_mesGastoEmpleado;
	}

	public void setCargarid_mesGastoEmpleado(Boolean cargarid_mesGastoEmpleado) {
		this.cargarid_mesGastoEmpleado= cargarid_mesGastoEmpleado;
	}

	public Border setResaltardiaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltardiaGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiaGastoEmpleado() {
		return this.resaltardiaGastoEmpleado;
	}

	public void setResaltardiaGastoEmpleado(Border borderResaltar) {
		this.resaltardiaGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrardiaGastoEmpleado() {
		return this.mostrardiaGastoEmpleado;
	}

	public void setMostrardiaGastoEmpleado(Boolean mostrardiaGastoEmpleado) {
		this.mostrardiaGastoEmpleado= mostrardiaGastoEmpleado;
	}

	public Boolean getActivardiaGastoEmpleado() {
		return this.activardiaGastoEmpleado;
	}

	public void setActivardiaGastoEmpleado(Boolean activardiaGastoEmpleado) {
		this.activardiaGastoEmpleado= activardiaGastoEmpleado;
	}

	public Border setResaltarid_usuarioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_usuarioGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioGastoEmpleado() {
		return this.resaltarid_usuarioGastoEmpleado;
	}

	public void setResaltarid_usuarioGastoEmpleado(Border borderResaltar) {
		this.resaltarid_usuarioGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_usuarioGastoEmpleado() {
		return this.mostrarid_usuarioGastoEmpleado;
	}

	public void setMostrarid_usuarioGastoEmpleado(Boolean mostrarid_usuarioGastoEmpleado) {
		this.mostrarid_usuarioGastoEmpleado= mostrarid_usuarioGastoEmpleado;
	}

	public Boolean getActivarid_usuarioGastoEmpleado() {
		return this.activarid_usuarioGastoEmpleado;
	}

	public void setActivarid_usuarioGastoEmpleado(Boolean activarid_usuarioGastoEmpleado) {
		this.activarid_usuarioGastoEmpleado= activarid_usuarioGastoEmpleado;
	}

	public Boolean getCargarid_usuarioGastoEmpleado() {
		return this.cargarid_usuarioGastoEmpleado;
	}

	public void setCargarid_usuarioGastoEmpleado(Boolean cargarid_usuarioGastoEmpleado) {
		this.cargarid_usuarioGastoEmpleado= cargarid_usuarioGastoEmpleado;
	}

	public Border setResaltarid_estado_gasto_empleadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estado_gasto_empleadoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_gasto_empleadoGastoEmpleado() {
		return this.resaltarid_estado_gasto_empleadoGastoEmpleado;
	}

	public void setResaltarid_estado_gasto_empleadoGastoEmpleado(Border borderResaltar) {
		this.resaltarid_estado_gasto_empleadoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estado_gasto_empleadoGastoEmpleado() {
		return this.mostrarid_estado_gasto_empleadoGastoEmpleado;
	}

	public void setMostrarid_estado_gasto_empleadoGastoEmpleado(Boolean mostrarid_estado_gasto_empleadoGastoEmpleado) {
		this.mostrarid_estado_gasto_empleadoGastoEmpleado= mostrarid_estado_gasto_empleadoGastoEmpleado;
	}

	public Boolean getActivarid_estado_gasto_empleadoGastoEmpleado() {
		return this.activarid_estado_gasto_empleadoGastoEmpleado;
	}

	public void setActivarid_estado_gasto_empleadoGastoEmpleado(Boolean activarid_estado_gasto_empleadoGastoEmpleado) {
		this.activarid_estado_gasto_empleadoGastoEmpleado= activarid_estado_gasto_empleadoGastoEmpleado;
	}

	public Boolean getCargarid_estado_gasto_empleadoGastoEmpleado() {
		return this.cargarid_estado_gasto_empleadoGastoEmpleado;
	}

	public void setCargarid_estado_gasto_empleadoGastoEmpleado(Boolean cargarid_estado_gasto_empleadoGastoEmpleado) {
		this.cargarid_estado_gasto_empleadoGastoEmpleado= cargarid_estado_gasto_empleadoGastoEmpleado;
	}

	public Border setResaltartotal_ingreso_actualGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltartotal_ingreso_actualGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ingreso_actualGastoEmpleado() {
		return this.resaltartotal_ingreso_actualGastoEmpleado;
	}

	public void setResaltartotal_ingreso_actualGastoEmpleado(Border borderResaltar) {
		this.resaltartotal_ingreso_actualGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrartotal_ingreso_actualGastoEmpleado() {
		return this.mostrartotal_ingreso_actualGastoEmpleado;
	}

	public void setMostrartotal_ingreso_actualGastoEmpleado(Boolean mostrartotal_ingreso_actualGastoEmpleado) {
		this.mostrartotal_ingreso_actualGastoEmpleado= mostrartotal_ingreso_actualGastoEmpleado;
	}

	public Boolean getActivartotal_ingreso_actualGastoEmpleado() {
		return this.activartotal_ingreso_actualGastoEmpleado;
	}

	public void setActivartotal_ingreso_actualGastoEmpleado(Boolean activartotal_ingreso_actualGastoEmpleado) {
		this.activartotal_ingreso_actualGastoEmpleado= activartotal_ingreso_actualGastoEmpleado;
	}

	public Border setResaltartotal_ingreso_otroGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltartotal_ingreso_otroGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ingreso_otroGastoEmpleado() {
		return this.resaltartotal_ingreso_otroGastoEmpleado;
	}

	public void setResaltartotal_ingreso_otroGastoEmpleado(Border borderResaltar) {
		this.resaltartotal_ingreso_otroGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrartotal_ingreso_otroGastoEmpleado() {
		return this.mostrartotal_ingreso_otroGastoEmpleado;
	}

	public void setMostrartotal_ingreso_otroGastoEmpleado(Boolean mostrartotal_ingreso_otroGastoEmpleado) {
		this.mostrartotal_ingreso_otroGastoEmpleado= mostrartotal_ingreso_otroGastoEmpleado;
	}

	public Boolean getActivartotal_ingreso_otroGastoEmpleado() {
		return this.activartotal_ingreso_otroGastoEmpleado;
	}

	public void setActivartotal_ingreso_otroGastoEmpleado(Boolean activartotal_ingreso_otroGastoEmpleado) {
		this.activartotal_ingreso_otroGastoEmpleado= activartotal_ingreso_otroGastoEmpleado;
	}

	public Border setResaltartotal_ingresoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltartotal_ingresoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ingresoGastoEmpleado() {
		return this.resaltartotal_ingresoGastoEmpleado;
	}

	public void setResaltartotal_ingresoGastoEmpleado(Border borderResaltar) {
		this.resaltartotal_ingresoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrartotal_ingresoGastoEmpleado() {
		return this.mostrartotal_ingresoGastoEmpleado;
	}

	public void setMostrartotal_ingresoGastoEmpleado(Boolean mostrartotal_ingresoGastoEmpleado) {
		this.mostrartotal_ingresoGastoEmpleado= mostrartotal_ingresoGastoEmpleado;
	}

	public Boolean getActivartotal_ingresoGastoEmpleado() {
		return this.activartotal_ingresoGastoEmpleado;
	}

	public void setActivartotal_ingresoGastoEmpleado(Boolean activartotal_ingresoGastoEmpleado) {
		this.activartotal_ingresoGastoEmpleado= activartotal_ingresoGastoEmpleado;
	}

	public Border setResaltargasto_viviendaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltargasto_viviendaGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_viviendaGastoEmpleado() {
		return this.resaltargasto_viviendaGastoEmpleado;
	}

	public void setResaltargasto_viviendaGastoEmpleado(Border borderResaltar) {
		this.resaltargasto_viviendaGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrargasto_viviendaGastoEmpleado() {
		return this.mostrargasto_viviendaGastoEmpleado;
	}

	public void setMostrargasto_viviendaGastoEmpleado(Boolean mostrargasto_viviendaGastoEmpleado) {
		this.mostrargasto_viviendaGastoEmpleado= mostrargasto_viviendaGastoEmpleado;
	}

	public Boolean getActivargasto_viviendaGastoEmpleado() {
		return this.activargasto_viviendaGastoEmpleado;
	}

	public void setActivargasto_viviendaGastoEmpleado(Boolean activargasto_viviendaGastoEmpleado) {
		this.activargasto_viviendaGastoEmpleado= activargasto_viviendaGastoEmpleado;
	}

	public Border setResaltargasto_educacionGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltargasto_educacionGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_educacionGastoEmpleado() {
		return this.resaltargasto_educacionGastoEmpleado;
	}

	public void setResaltargasto_educacionGastoEmpleado(Border borderResaltar) {
		this.resaltargasto_educacionGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrargasto_educacionGastoEmpleado() {
		return this.mostrargasto_educacionGastoEmpleado;
	}

	public void setMostrargasto_educacionGastoEmpleado(Boolean mostrargasto_educacionGastoEmpleado) {
		this.mostrargasto_educacionGastoEmpleado= mostrargasto_educacionGastoEmpleado;
	}

	public Boolean getActivargasto_educacionGastoEmpleado() {
		return this.activargasto_educacionGastoEmpleado;
	}

	public void setActivargasto_educacionGastoEmpleado(Boolean activargasto_educacionGastoEmpleado) {
		this.activargasto_educacionGastoEmpleado= activargasto_educacionGastoEmpleado;
	}

	public Border setResaltargasto_saludGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltargasto_saludGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_saludGastoEmpleado() {
		return this.resaltargasto_saludGastoEmpleado;
	}

	public void setResaltargasto_saludGastoEmpleado(Border borderResaltar) {
		this.resaltargasto_saludGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrargasto_saludGastoEmpleado() {
		return this.mostrargasto_saludGastoEmpleado;
	}

	public void setMostrargasto_saludGastoEmpleado(Boolean mostrargasto_saludGastoEmpleado) {
		this.mostrargasto_saludGastoEmpleado= mostrargasto_saludGastoEmpleado;
	}

	public Boolean getActivargasto_saludGastoEmpleado() {
		return this.activargasto_saludGastoEmpleado;
	}

	public void setActivargasto_saludGastoEmpleado(Boolean activargasto_saludGastoEmpleado) {
		this.activargasto_saludGastoEmpleado= activargasto_saludGastoEmpleado;
	}

	public Border setResaltargasto_vestimentaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltargasto_vestimentaGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_vestimentaGastoEmpleado() {
		return this.resaltargasto_vestimentaGastoEmpleado;
	}

	public void setResaltargasto_vestimentaGastoEmpleado(Border borderResaltar) {
		this.resaltargasto_vestimentaGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrargasto_vestimentaGastoEmpleado() {
		return this.mostrargasto_vestimentaGastoEmpleado;
	}

	public void setMostrargasto_vestimentaGastoEmpleado(Boolean mostrargasto_vestimentaGastoEmpleado) {
		this.mostrargasto_vestimentaGastoEmpleado= mostrargasto_vestimentaGastoEmpleado;
	}

	public Boolean getActivargasto_vestimentaGastoEmpleado() {
		return this.activargasto_vestimentaGastoEmpleado;
	}

	public void setActivargasto_vestimentaGastoEmpleado(Boolean activargasto_vestimentaGastoEmpleado) {
		this.activargasto_vestimentaGastoEmpleado= activargasto_vestimentaGastoEmpleado;
	}

	public Border setResaltargasto_alimentacionGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltargasto_alimentacionGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_alimentacionGastoEmpleado() {
		return this.resaltargasto_alimentacionGastoEmpleado;
	}

	public void setResaltargasto_alimentacionGastoEmpleado(Border borderResaltar) {
		this.resaltargasto_alimentacionGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrargasto_alimentacionGastoEmpleado() {
		return this.mostrargasto_alimentacionGastoEmpleado;
	}

	public void setMostrargasto_alimentacionGastoEmpleado(Boolean mostrargasto_alimentacionGastoEmpleado) {
		this.mostrargasto_alimentacionGastoEmpleado= mostrargasto_alimentacionGastoEmpleado;
	}

	public Boolean getActivargasto_alimentacionGastoEmpleado() {
		return this.activargasto_alimentacionGastoEmpleado;
	}

	public void setActivargasto_alimentacionGastoEmpleado(Boolean activargasto_alimentacionGastoEmpleado) {
		this.activargasto_alimentacionGastoEmpleado= activargasto_alimentacionGastoEmpleado;
	}

	public Border setResaltartotal_gasto_actualGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltartotal_gasto_actualGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_gasto_actualGastoEmpleado() {
		return this.resaltartotal_gasto_actualGastoEmpleado;
	}

	public void setResaltartotal_gasto_actualGastoEmpleado(Border borderResaltar) {
		this.resaltartotal_gasto_actualGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrartotal_gasto_actualGastoEmpleado() {
		return this.mostrartotal_gasto_actualGastoEmpleado;
	}

	public void setMostrartotal_gasto_actualGastoEmpleado(Boolean mostrartotal_gasto_actualGastoEmpleado) {
		this.mostrartotal_gasto_actualGastoEmpleado= mostrartotal_gasto_actualGastoEmpleado;
	}

	public Boolean getActivartotal_gasto_actualGastoEmpleado() {
		return this.activartotal_gasto_actualGastoEmpleado;
	}

	public void setActivartotal_gasto_actualGastoEmpleado(Boolean activartotal_gasto_actualGastoEmpleado) {
		this.activartotal_gasto_actualGastoEmpleado= activartotal_gasto_actualGastoEmpleado;
	}

	public Border setResaltartotal_gastoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltartotal_gastoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_gastoGastoEmpleado() {
		return this.resaltartotal_gastoGastoEmpleado;
	}

	public void setResaltartotal_gastoGastoEmpleado(Border borderResaltar) {
		this.resaltartotal_gastoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrartotal_gastoGastoEmpleado() {
		return this.mostrartotal_gastoGastoEmpleado;
	}

	public void setMostrartotal_gastoGastoEmpleado(Boolean mostrartotal_gastoGastoEmpleado) {
		this.mostrartotal_gastoGastoEmpleado= mostrartotal_gastoGastoEmpleado;
	}

	public Boolean getActivartotal_gastoGastoEmpleado() {
		return this.activartotal_gastoGastoEmpleado;
	}

	public void setActivartotal_gastoGastoEmpleado(Boolean activartotal_gastoGastoEmpleado) {
		this.activartotal_gastoGastoEmpleado= activartotal_gastoGastoEmpleado;
	}

	public Border setResaltarfechaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarfechaGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaGastoEmpleado() {
		return this.resaltarfechaGastoEmpleado;
	}

	public void setResaltarfechaGastoEmpleado(Border borderResaltar) {
		this.resaltarfechaGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarfechaGastoEmpleado() {
		return this.mostrarfechaGastoEmpleado;
	}

	public void setMostrarfechaGastoEmpleado(Boolean mostrarfechaGastoEmpleado) {
		this.mostrarfechaGastoEmpleado= mostrarfechaGastoEmpleado;
	}

	public Boolean getActivarfechaGastoEmpleado() {
		return this.activarfechaGastoEmpleado;
	}

	public void setActivarfechaGastoEmpleado(Boolean activarfechaGastoEmpleado) {
		this.activarfechaGastoEmpleado= activarfechaGastoEmpleado;
	}

	public Border setResaltarporcentajeGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarporcentajeGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeGastoEmpleado() {
		return this.resaltarporcentajeGastoEmpleado;
	}

	public void setResaltarporcentajeGastoEmpleado(Border borderResaltar) {
		this.resaltarporcentajeGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarporcentajeGastoEmpleado() {
		return this.mostrarporcentajeGastoEmpleado;
	}

	public void setMostrarporcentajeGastoEmpleado(Boolean mostrarporcentajeGastoEmpleado) {
		this.mostrarporcentajeGastoEmpleado= mostrarporcentajeGastoEmpleado;
	}

	public Boolean getActivarporcentajeGastoEmpleado() {
		return this.activarporcentajeGastoEmpleado;
	}

	public void setActivarporcentajeGastoEmpleado(Boolean activarporcentajeGastoEmpleado) {
		this.activarporcentajeGastoEmpleado= activarporcentajeGastoEmpleado;
	}

	public Border setResaltarvalor_maximoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_maximoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_maximoGastoEmpleado() {
		return this.resaltarvalor_maximoGastoEmpleado;
	}

	public void setResaltarvalor_maximoGastoEmpleado(Border borderResaltar) {
		this.resaltarvalor_maximoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_maximoGastoEmpleado() {
		return this.mostrarvalor_maximoGastoEmpleado;
	}

	public void setMostrarvalor_maximoGastoEmpleado(Boolean mostrarvalor_maximoGastoEmpleado) {
		this.mostrarvalor_maximoGastoEmpleado= mostrarvalor_maximoGastoEmpleado;
	}

	public Boolean getActivarvalor_maximoGastoEmpleado() {
		return this.activarvalor_maximoGastoEmpleado;
	}

	public void setActivarvalor_maximoGastoEmpleado(Boolean activarvalor_maximoGastoEmpleado) {
		this.activarvalor_maximoGastoEmpleado= activarvalor_maximoGastoEmpleado;
	}

	public Border setResaltarvalor_maximo_porcentajeGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastoempleadoBeanSwingJInternalFrame.jTtoolBarGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_maximo_porcentajeGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_maximo_porcentajeGastoEmpleado() {
		return this.resaltarvalor_maximo_porcentajeGastoEmpleado;
	}

	public void setResaltarvalor_maximo_porcentajeGastoEmpleado(Border borderResaltar) {
		this.resaltarvalor_maximo_porcentajeGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_maximo_porcentajeGastoEmpleado() {
		return this.mostrarvalor_maximo_porcentajeGastoEmpleado;
	}

	public void setMostrarvalor_maximo_porcentajeGastoEmpleado(Boolean mostrarvalor_maximo_porcentajeGastoEmpleado) {
		this.mostrarvalor_maximo_porcentajeGastoEmpleado= mostrarvalor_maximo_porcentajeGastoEmpleado;
	}

	public Boolean getActivarvalor_maximo_porcentajeGastoEmpleado() {
		return this.activarvalor_maximo_porcentajeGastoEmpleado;
	}

	public void setActivarvalor_maximo_porcentajeGastoEmpleado(Boolean activarvalor_maximo_porcentajeGastoEmpleado) {
		this.activarvalor_maximo_porcentajeGastoEmpleado= activarvalor_maximo_porcentajeGastoEmpleado;
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
		
		
		this.setMostraridGastoEmpleado(esInicial);
		this.setMostrarid_empresaGastoEmpleado(esInicial);
		this.setMostrarid_sucursalGastoEmpleado(esInicial);
		this.setMostrarid_empleadoGastoEmpleado(esInicial);
		this.setMostrarid_ejercicioGastoEmpleado(esInicial);
		this.setMostrarid_paisGastoEmpleado(esInicial);
		this.setMostrarid_ciudadGastoEmpleado(esInicial);
		this.setMostrarid_anioGastoEmpleado(esInicial);
		this.setMostrarid_mesGastoEmpleado(esInicial);
		this.setMostrardiaGastoEmpleado(esInicial);
		this.setMostrarid_usuarioGastoEmpleado(esInicial);
		this.setMostrarid_estado_gasto_empleadoGastoEmpleado(esInicial);
		this.setMostrartotal_ingreso_actualGastoEmpleado(esInicial);
		this.setMostrartotal_ingreso_otroGastoEmpleado(esInicial);
		this.setMostrartotal_ingresoGastoEmpleado(esInicial);
		this.setMostrargasto_viviendaGastoEmpleado(esInicial);
		this.setMostrargasto_educacionGastoEmpleado(esInicial);
		this.setMostrargasto_saludGastoEmpleado(esInicial);
		this.setMostrargasto_vestimentaGastoEmpleado(esInicial);
		this.setMostrargasto_alimentacionGastoEmpleado(esInicial);
		this.setMostrartotal_gasto_actualGastoEmpleado(esInicial);
		this.setMostrartotal_gastoGastoEmpleado(esInicial);
		this.setMostrarfechaGastoEmpleado(esInicial);
		this.setMostrarporcentajeGastoEmpleado(esInicial);
		this.setMostrarvalor_maximoGastoEmpleado(esInicial);
		this.setMostrarvalor_maximo_porcentajeGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.ID)) {
				this.setMostraridGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.DIA)) {
				this.setMostrardiaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO)) {
				this.setMostrarid_estado_gasto_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL)) {
				this.setMostrartotal_ingreso_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO)) {
				this.setMostrartotal_ingreso_otroGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESO)) {
				this.setMostrartotal_ingresoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA)) {
				this.setMostrargasto_viviendaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOEDUCACION)) {
				this.setMostrargasto_educacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOSALUD)) {
				this.setMostrargasto_saludGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA)) {
				this.setMostrargasto_vestimentaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION)) {
				this.setMostrargasto_alimentacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL)) {
				this.setMostrartotal_gasto_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTO)) {
				this.setMostrartotal_gastoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.FECHA)) {
				this.setMostrarfechaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMO)) {
				this.setMostrarvalor_maximoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE)) {
				this.setMostrarvalor_maximo_porcentajeGastoEmpleado(esAsigna);
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
		
		
		this.setActivaridGastoEmpleado(esInicial);
		this.setActivarid_empresaGastoEmpleado(esInicial);
		this.setActivarid_sucursalGastoEmpleado(esInicial);
		this.setActivarid_empleadoGastoEmpleado(esInicial);
		this.setActivarid_ejercicioGastoEmpleado(esInicial);
		this.setActivarid_paisGastoEmpleado(esInicial);
		this.setActivarid_ciudadGastoEmpleado(esInicial);
		this.setActivarid_anioGastoEmpleado(esInicial);
		this.setActivarid_mesGastoEmpleado(esInicial);
		this.setActivardiaGastoEmpleado(esInicial);
		this.setActivarid_usuarioGastoEmpleado(esInicial);
		this.setActivarid_estado_gasto_empleadoGastoEmpleado(esInicial);
		this.setActivartotal_ingreso_actualGastoEmpleado(esInicial);
		this.setActivartotal_ingreso_otroGastoEmpleado(esInicial);
		this.setActivartotal_ingresoGastoEmpleado(esInicial);
		this.setActivargasto_viviendaGastoEmpleado(esInicial);
		this.setActivargasto_educacionGastoEmpleado(esInicial);
		this.setActivargasto_saludGastoEmpleado(esInicial);
		this.setActivargasto_vestimentaGastoEmpleado(esInicial);
		this.setActivargasto_alimentacionGastoEmpleado(esInicial);
		this.setActivartotal_gasto_actualGastoEmpleado(esInicial);
		this.setActivartotal_gastoGastoEmpleado(esInicial);
		this.setActivarfechaGastoEmpleado(esInicial);
		this.setActivarporcentajeGastoEmpleado(esInicial);
		this.setActivarvalor_maximoGastoEmpleado(esInicial);
		this.setActivarvalor_maximo_porcentajeGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.ID)) {
				this.setActivaridGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDMES)) {
				this.setActivarid_mesGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.DIA)) {
				this.setActivardiaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO)) {
				this.setActivarid_estado_gasto_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL)) {
				this.setActivartotal_ingreso_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO)) {
				this.setActivartotal_ingreso_otroGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESO)) {
				this.setActivartotal_ingresoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA)) {
				this.setActivargasto_viviendaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOEDUCACION)) {
				this.setActivargasto_educacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOSALUD)) {
				this.setActivargasto_saludGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA)) {
				this.setActivargasto_vestimentaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION)) {
				this.setActivargasto_alimentacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL)) {
				this.setActivartotal_gasto_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTO)) {
				this.setActivartotal_gastoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.FECHA)) {
				this.setActivarfechaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMO)) {
				this.setActivarvalor_maximoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE)) {
				this.setActivarvalor_maximo_porcentajeGastoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGastoEmpleado(esInicial);
		this.setResaltarid_empresaGastoEmpleado(esInicial);
		this.setResaltarid_sucursalGastoEmpleado(esInicial);
		this.setResaltarid_empleadoGastoEmpleado(esInicial);
		this.setResaltarid_ejercicioGastoEmpleado(esInicial);
		this.setResaltarid_paisGastoEmpleado(esInicial);
		this.setResaltarid_ciudadGastoEmpleado(esInicial);
		this.setResaltarid_anioGastoEmpleado(esInicial);
		this.setResaltarid_mesGastoEmpleado(esInicial);
		this.setResaltardiaGastoEmpleado(esInicial);
		this.setResaltarid_usuarioGastoEmpleado(esInicial);
		this.setResaltarid_estado_gasto_empleadoGastoEmpleado(esInicial);
		this.setResaltartotal_ingreso_actualGastoEmpleado(esInicial);
		this.setResaltartotal_ingreso_otroGastoEmpleado(esInicial);
		this.setResaltartotal_ingresoGastoEmpleado(esInicial);
		this.setResaltargasto_viviendaGastoEmpleado(esInicial);
		this.setResaltargasto_educacionGastoEmpleado(esInicial);
		this.setResaltargasto_saludGastoEmpleado(esInicial);
		this.setResaltargasto_vestimentaGastoEmpleado(esInicial);
		this.setResaltargasto_alimentacionGastoEmpleado(esInicial);
		this.setResaltartotal_gasto_actualGastoEmpleado(esInicial);
		this.setResaltartotal_gastoGastoEmpleado(esInicial);
		this.setResaltarfechaGastoEmpleado(esInicial);
		this.setResaltarporcentajeGastoEmpleado(esInicial);
		this.setResaltarvalor_maximoGastoEmpleado(esInicial);
		this.setResaltarvalor_maximo_porcentajeGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.DIA)) {
				this.setResaltardiaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO)) {
				this.setResaltarid_estado_gasto_empleadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL)) {
				this.setResaltartotal_ingreso_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO)) {
				this.setResaltartotal_ingreso_otroGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALINGRESO)) {
				this.setResaltartotal_ingresoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVIVIENDA)) {
				this.setResaltargasto_viviendaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOEDUCACION)) {
				this.setResaltargasto_educacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOSALUD)) {
				this.setResaltargasto_saludGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA)) {
				this.setResaltargasto_vestimentaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.GASTOALIMENTACION)) {
				this.setResaltargasto_alimentacionGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL)) {
				this.setResaltartotal_gasto_actualGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.TOTALGASTO)) {
				this.setResaltartotal_gastoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.FECHA)) {
				this.setResaltarfechaGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMO)) {
				this.setResaltarvalor_maximoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE)) {
				this.setResaltarvalor_maximo_porcentajeGastoEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioGastoEmpleado=true;

	public Boolean getMostrarFK_IdAnioGastoEmpleado() {
		return this.mostrarFK_IdAnioGastoEmpleado;
	}

	public void setMostrarFK_IdAnioGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCiudadGastoEmpleado=true;

	public Boolean getMostrarFK_IdCiudadGastoEmpleado() {
		return this.mostrarFK_IdCiudadGastoEmpleado;
	}

	public void setMostrarFK_IdCiudadGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioGastoEmpleado=true;

	public Boolean getMostrarFK_IdEjercicioGastoEmpleado() {
		return this.mostrarFK_IdEjercicioGastoEmpleado;
	}

	public void setMostrarFK_IdEjercicioGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoGastoEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoGastoEmpleado() {
		return this.mostrarFK_IdEmpleadoGastoEmpleado;
	}

	public void setMostrarFK_IdEmpleadoGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGastoEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaGastoEmpleado() {
		return this.mostrarFK_IdEmpresaGastoEmpleado;
	}

	public void setMostrarFK_IdEmpresaGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoGastoEmpleadoGastoEmpleado=true;

	public Boolean getMostrarFK_IdEstadoGastoEmpleadoGastoEmpleado() {
		return this.mostrarFK_IdEstadoGastoEmpleadoGastoEmpleado;
	}

	public void setMostrarFK_IdEstadoGastoEmpleadoGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoGastoEmpleadoGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesGastoEmpleado=true;

	public Boolean getMostrarFK_IdMesGastoEmpleado() {
		return this.mostrarFK_IdMesGastoEmpleado;
	}

	public void setMostrarFK_IdMesGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisGastoEmpleado=true;

	public Boolean getMostrarFK_IdPaisGastoEmpleado() {
		return this.mostrarFK_IdPaisGastoEmpleado;
	}

	public void setMostrarFK_IdPaisGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalGastoEmpleado=true;

	public Boolean getMostrarFK_IdSucursalGastoEmpleado() {
		return this.mostrarFK_IdSucursalGastoEmpleado;
	}

	public void setMostrarFK_IdSucursalGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalGastoEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioGastoEmpleado=true;

	public Boolean getMostrarFK_IdUsuarioGastoEmpleado() {
		return this.mostrarFK_IdUsuarioGastoEmpleado;
	}

	public void setMostrarFK_IdUsuarioGastoEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioGastoEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioGastoEmpleado=true;

	public Boolean getActivarFK_IdAnioGastoEmpleado() {
		return this.activarFK_IdAnioGastoEmpleado;
	}

	public void setActivarFK_IdAnioGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdCiudadGastoEmpleado=true;

	public Boolean getActivarFK_IdCiudadGastoEmpleado() {
		return this.activarFK_IdCiudadGastoEmpleado;
	}

	public void setActivarFK_IdCiudadGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioGastoEmpleado=true;

	public Boolean getActivarFK_IdEjercicioGastoEmpleado() {
		return this.activarFK_IdEjercicioGastoEmpleado;
	}

	public void setActivarFK_IdEjercicioGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoGastoEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoGastoEmpleado() {
		return this.activarFK_IdEmpleadoGastoEmpleado;
	}

	public void setActivarFK_IdEmpleadoGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGastoEmpleado=true;

	public Boolean getActivarFK_IdEmpresaGastoEmpleado() {
		return this.activarFK_IdEmpresaGastoEmpleado;
	}

	public void setActivarFK_IdEmpresaGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoGastoEmpleadoGastoEmpleado=true;

	public Boolean getActivarFK_IdEstadoGastoEmpleadoGastoEmpleado() {
		return this.activarFK_IdEstadoGastoEmpleadoGastoEmpleado;
	}

	public void setActivarFK_IdEstadoGastoEmpleadoGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoGastoEmpleadoGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesGastoEmpleado=true;

	public Boolean getActivarFK_IdMesGastoEmpleado() {
		return this.activarFK_IdMesGastoEmpleado;
	}

	public void setActivarFK_IdMesGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMesGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisGastoEmpleado=true;

	public Boolean getActivarFK_IdPaisGastoEmpleado() {
		return this.activarFK_IdPaisGastoEmpleado;
	}

	public void setActivarFK_IdPaisGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdPaisGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalGastoEmpleado=true;

	public Boolean getActivarFK_IdSucursalGastoEmpleado() {
		return this.activarFK_IdSucursalGastoEmpleado;
	}

	public void setActivarFK_IdSucursalGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalGastoEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioGastoEmpleado=true;

	public Boolean getActivarFK_IdUsuarioGastoEmpleado() {
		return this.activarFK_IdUsuarioGastoEmpleado;
	}

	public void setActivarFK_IdUsuarioGastoEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioGastoEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioGastoEmpleado=null;

	public Border getResaltarFK_IdAnioGastoEmpleado() {
		return this.resaltarFK_IdAnioGastoEmpleado;
	}

	public void setResaltarFK_IdAnioGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdCiudadGastoEmpleado=null;

	public Border getResaltarFK_IdCiudadGastoEmpleado() {
		return this.resaltarFK_IdCiudadGastoEmpleado;
	}

	public void setResaltarFK_IdCiudadGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdCiudadGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdCiudadGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioGastoEmpleado=null;

	public Border getResaltarFK_IdEjercicioGastoEmpleado() {
		return this.resaltarFK_IdEjercicioGastoEmpleado;
	}

	public void setResaltarFK_IdEjercicioGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEjercicioGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoGastoEmpleado=null;

	public Border getResaltarFK_IdEmpleadoGastoEmpleado() {
		return this.resaltarFK_IdEmpleadoGastoEmpleado;
	}

	public void setResaltarFK_IdEmpleadoGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGastoEmpleado=null;

	public Border getResaltarFK_IdEmpresaGastoEmpleado() {
		return this.resaltarFK_IdEmpresaGastoEmpleado;
	}

	public void setResaltarFK_IdEmpresaGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstadoGastoEmpleadoGastoEmpleado=null;

	public Border getResaltarFK_IdEstadoGastoEmpleadoGastoEmpleado() {
		return this.resaltarFK_IdEstadoGastoEmpleadoGastoEmpleado;
	}

	public void setResaltarFK_IdEstadoGastoEmpleadoGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstadoGastoEmpleadoGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstadoGastoEmpleadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoGastoEmpleadoGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMesGastoEmpleado=null;

	public Border getResaltarFK_IdMesGastoEmpleado() {
		return this.resaltarFK_IdMesGastoEmpleado;
	}

	public void setResaltarFK_IdMesGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMesGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMesGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdPaisGastoEmpleado=null;

	public Border getResaltarFK_IdPaisGastoEmpleado() {
		return this.resaltarFK_IdPaisGastoEmpleado;
	}

	public void setResaltarFK_IdPaisGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdPaisGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdPaisGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdSucursalGastoEmpleado=null;

	public Border getResaltarFK_IdSucursalGastoEmpleado() {
		return this.resaltarFK_IdSucursalGastoEmpleado;
	}

	public void setResaltarFK_IdSucursalGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdSucursalGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdSucursalGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalGastoEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioGastoEmpleado=null;

	public Border getResaltarFK_IdUsuarioGastoEmpleado() {
		return this.resaltarFK_IdUsuarioGastoEmpleado;
	}

	public void setResaltarFK_IdUsuarioGastoEmpleado(Border borderResaltar) {
		this.resaltarFK_IdUsuarioGastoEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*GastoEmpleadoBeanSwingJInternalFrame gastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioGastoEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
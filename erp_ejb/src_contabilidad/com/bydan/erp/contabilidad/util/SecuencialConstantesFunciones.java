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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.SecuencialConstantesFunciones;
import com.bydan.erp.contabilidad.util.SecuencialParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SecuencialParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SecuencialConstantesFunciones extends SecuencialConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Secuencial";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Secuencial"+SecuencialConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SecuencialHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SecuencialHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SecuencialConstantesFunciones.SCHEMA+"_"+SecuencialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SecuencialConstantesFunciones.SCHEMA+"_"+SecuencialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SecuencialConstantesFunciones.SCHEMA+"_"+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SecuencialConstantesFunciones.SCHEMA+"_"+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SecuencialConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SecuencialConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SecuencialConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SecuencialConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Secuenciales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Secuencial";
	public static final String SCLASSWEBTITULO_LOWER="Secuencial";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Secuencial";
	public static final String OBJECTNAME="secuencial";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="secuencial";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select secuencial from "+SecuencialConstantesFunciones.SPERSISTENCENAME+" secuencial";
	public static String QUERYSELECTNATIVE="select "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".version_row,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_empresa,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_sucursal,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_ejercicio,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_periodo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_anio,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_mes,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_modulo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_documento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_asiento,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_ingreso,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_egreso,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_diario,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_iva,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_fuente,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_asiento_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_ingreso_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_egreso_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_diario_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_fuente_formato,"+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME+".numero_retencion_iva_formato from "+SecuencialConstantesFunciones.SCHEMA+"."+SecuencialConstantesFunciones.TABLENAME;//+" as "+SecuencialConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SecuencialConstantesFuncionesAdditional secuencialConstantesFuncionesAdditional=null;
	
	public SecuencialConstantesFuncionesAdditional getSecuencialConstantesFuncionesAdditional() {
		return this.secuencialConstantesFuncionesAdditional;
	}
	
	public void setSecuencialConstantesFuncionesAdditional(SecuencialConstantesFuncionesAdditional secuencialConstantesFuncionesAdditional) {
		try {
			this.secuencialConstantesFuncionesAdditional=secuencialConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String NUMEROASIENTO= "numero_asiento";
    public static final String NUMEROINGRESO= "numero_ingreso";
    public static final String NUMEROEGRESO= "numero_egreso";
    public static final String NUMERODIARIO= "numero_diario";
    public static final String NUMERORETENCIONIVA= "numero_retencion_iva";
    public static final String NUMERORETENCIONFUENTE= "numero_retencion_fuente";
    public static final String NUMEROASIENTOFORMATO= "numero_asiento_formato";
    public static final String NUMEROINGRESOFORMATO= "numero_ingreso_formato";
    public static final String NUMEROEGRESOFORMATO= "numero_egreso_formato";
    public static final String NUMERODIARIOFORMATO= "numero_diario_formato";
    public static final String NUMERORETENCIONFUENTEFORMATO= "numero_retencion_fuente_formato";
    public static final String NUMERORETENCIONIVAFORMATO= "numero_retencion_iva_formato";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMEROASIENTO= "No Asiento";
		public static final String LABEL_NUMEROASIENTO_LOWER= "Numero Asiento";
    	public static final String LABEL_NUMEROINGRESO= "No Ingreso";
		public static final String LABEL_NUMEROINGRESO_LOWER= "Numero Ingreso";
    	public static final String LABEL_NUMEROEGRESO= "No Egreso";
		public static final String LABEL_NUMEROEGRESO_LOWER= "Numero Egreso";
    	public static final String LABEL_NUMERODIARIO= "No Diario";
		public static final String LABEL_NUMERODIARIO_LOWER= "Numero Diario";
    	public static final String LABEL_NUMERORETENCIONIVA= "No Ret Iva";
		public static final String LABEL_NUMERORETENCIONIVA_LOWER= "Numero Retencion Iva";
    	public static final String LABEL_NUMERORETENCIONFUENTE= "No Ret Fuente";
		public static final String LABEL_NUMERORETENCIONFUENTE_LOWER= "Numero Retencion Fuente";
    	public static final String LABEL_NUMEROASIENTOFORMATO= "No Asiento.";
		public static final String LABEL_NUMEROASIENTOFORMATO_LOWER= "Numero Asiento Formato";
    	public static final String LABEL_NUMEROINGRESOFORMATO= "No Ingreso.";
		public static final String LABEL_NUMEROINGRESOFORMATO_LOWER= "Numero Ingreso Formato";
    	public static final String LABEL_NUMEROEGRESOFORMATO= "No Egreso.";
		public static final String LABEL_NUMEROEGRESOFORMATO_LOWER= "Numero Egreso Formato";
    	public static final String LABEL_NUMERODIARIOFORMATO= "No Diario.";
		public static final String LABEL_NUMERODIARIOFORMATO_LOWER= "Numero Diario Formato";
    	public static final String LABEL_NUMERORETENCIONFUENTEFORMATO= "No Ret Fuente.";
		public static final String LABEL_NUMERORETENCIONFUENTEFORMATO_LOWER= "Numero Retencion Fuente Formato";
    	public static final String LABEL_NUMERORETENCIONIVAFORMATO= "No Ret Iva.";
		public static final String LABEL_NUMERORETENCIONIVAFORMATO_LOWER= "Numero Retencion Iva Formato";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_ASIENTO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_ASIENTO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_INGRESO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_INGRESO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_EGRESO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_EGRESO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DIARIO_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DIARIO_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_RETENCION_FUENTE_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION_FUENTE_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_RETENCION_IVA_FORMATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION_IVA_FORMATO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSecuencialLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDEMPRESA)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDEJERCICIO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDPERIODO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDANIO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDMES)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDMODULO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROASIENTO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROASIENTO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROINGRESO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROINGRESO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROEGRESO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROEGRESO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERODIARIO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERODIARIO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVA)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVA;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTE)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTE;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROASIENTOFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROASIENTOFORMATO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROINGRESOFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROINGRESOFORMATO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMEROEGRESOFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMEROEGRESOFORMATO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERODIARIOFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERODIARIOFORMATO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTEFORMATO;}
		if(sNombreColumna.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO)) {sLabelColumna=SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVAFORMATO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSecuencialDescripcion(Secuencial secuencial) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(secuencial !=null/* && secuencial.getId()!=0*/) {
			if(secuencial.getId()!=null) {
				sDescripcion=secuencial.getId().toString();
			}//secuencialsecuencial.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSecuencialDescripcionDetallado(Secuencial secuencial) {
		String sDescripcion="";
			
		sDescripcion+=SecuencialConstantesFunciones.ID+"=";
		sDescripcion+=secuencial.getId().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=secuencial.getVersionRow().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=secuencial.getid_empresa().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=secuencial.getid_sucursal().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=secuencial.getid_ejercicio().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=secuencial.getid_periodo().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDANIO+"=";
		sDescripcion+=secuencial.getid_anio().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDMES+"=";
		sDescripcion+=secuencial.getid_mes().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDMODULO+"=";
		sDescripcion+=secuencial.getid_modulo().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=secuencial.getid_tipo_movimiento_modulo().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=secuencial.getid_tipo_documento().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=secuencial.getid_tipo_movimiento().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROASIENTO+"=";
		sDescripcion+=secuencial.getnumero_asiento().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROINGRESO+"=";
		sDescripcion+=secuencial.getnumero_ingreso().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROEGRESO+"=";
		sDescripcion+=secuencial.getnumero_egreso().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERODIARIO+"=";
		sDescripcion+=secuencial.getnumero_diario().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERORETENCIONIVA+"=";
		sDescripcion+=secuencial.getnumero_retencion_iva().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERORETENCIONFUENTE+"=";
		sDescripcion+=secuencial.getnumero_retencion_fuente().toString()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROASIENTOFORMATO+"=";
		sDescripcion+=secuencial.getnumero_asiento_formato()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROINGRESOFORMATO+"=";
		sDescripcion+=secuencial.getnumero_ingreso_formato()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMEROEGRESOFORMATO+"=";
		sDescripcion+=secuencial.getnumero_egreso_formato()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERODIARIOFORMATO+"=";
		sDescripcion+=secuencial.getnumero_diario_formato()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO+"=";
		sDescripcion+=secuencial.getnumero_retencion_fuente_formato()+",";
		sDescripcion+=SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO+"=";
		sDescripcion+=secuencial.getnumero_retencion_iva_formato()+",";
			
		return sDescripcion;
	}
	
	public static void setSecuencialDescripcion(Secuencial secuencial,String sValor) throws Exception {			
		if(secuencial !=null) {
			//secuencialsecuencial.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimientomodulo!=null/*&&tipomovimientomodulo.getId()>0*/) {
			sDescripcion=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipomovimientomodulo);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorEjercicioPorModuloPorMovimiento")) {
			sNombreIndice="Tipo=  Por Modulo Por Ejercicio Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorEjercicioPorModuloPorMovimiento(Long id_modulo,Long id_ejercicio,Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSecuencial(Secuencial secuencial,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		secuencial.setnumero_asiento_formato(secuencial.getnumero_asiento_formato().trim());
		secuencial.setnumero_ingreso_formato(secuencial.getnumero_ingreso_formato().trim());
		secuencial.setnumero_egreso_formato(secuencial.getnumero_egreso_formato().trim());
		secuencial.setnumero_diario_formato(secuencial.getnumero_diario_formato().trim());
		secuencial.setnumero_retencion_fuente_formato(secuencial.getnumero_retencion_fuente_formato().trim());
		secuencial.setnumero_retencion_iva_formato(secuencial.getnumero_retencion_iva_formato().trim());
	}
	
	public static void quitarEspaciosSecuencials(List<Secuencial> secuencials,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Secuencial secuencial: secuencials) {
			secuencial.setnumero_asiento_formato(secuencial.getnumero_asiento_formato().trim());
			secuencial.setnumero_ingreso_formato(secuencial.getnumero_ingreso_formato().trim());
			secuencial.setnumero_egreso_formato(secuencial.getnumero_egreso_formato().trim());
			secuencial.setnumero_diario_formato(secuencial.getnumero_diario_formato().trim());
			secuencial.setnumero_retencion_fuente_formato(secuencial.getnumero_retencion_fuente_formato().trim());
			secuencial.setnumero_retencion_iva_formato(secuencial.getnumero_retencion_iva_formato().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSecuencial(Secuencial secuencial,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && secuencial.getConCambioAuxiliar()) {
			secuencial.setIsDeleted(secuencial.getIsDeletedAuxiliar());	
			secuencial.setIsNew(secuencial.getIsNewAuxiliar());	
			secuencial.setIsChanged(secuencial.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			secuencial.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			secuencial.setIsDeletedAuxiliar(false);	
			secuencial.setIsNewAuxiliar(false);	
			secuencial.setIsChangedAuxiliar(false);
			
			secuencial.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSecuencials(List<Secuencial> secuencials,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Secuencial secuencial : secuencials) {
			if(conAsignarBase && secuencial.getConCambioAuxiliar()) {
				secuencial.setIsDeleted(secuencial.getIsDeletedAuxiliar());	
				secuencial.setIsNew(secuencial.getIsNewAuxiliar());	
				secuencial.setIsChanged(secuencial.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				secuencial.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				secuencial.setIsDeletedAuxiliar(false);	
				secuencial.setIsNewAuxiliar(false);	
				secuencial.setIsChangedAuxiliar(false);
				
				secuencial.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSecuencial(Secuencial secuencial,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			secuencial.setnumero_asiento(0L);
			secuencial.setnumero_ingreso(0L);
			secuencial.setnumero_egreso(0L);
			secuencial.setnumero_diario(0L);
			secuencial.setnumero_retencion_iva(0L);
			secuencial.setnumero_retencion_fuente(0L);
		}
	}		
	
	public static void InicializarValoresSecuencials(List<Secuencial> secuencials,Boolean conEnteros) throws Exception  {
		
		for(Secuencial secuencial: secuencials) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				secuencial.setnumero_asiento(0L);
				secuencial.setnumero_ingreso(0L);
				secuencial.setnumero_egreso(0L);
				secuencial.setnumero_diario(0L);
				secuencial.setnumero_retencion_iva(0L);
				secuencial.setnumero_retencion_fuente(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSecuencial(List<Secuencial> secuencials,Secuencial secuencialAux) throws Exception  {
		SecuencialConstantesFunciones.InicializarValoresSecuencial(secuencialAux,true);
		
		for(Secuencial secuencial: secuencials) {
			if(secuencial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			secuencialAux.setnumero_asiento(secuencialAux.getnumero_asiento()+secuencial.getnumero_asiento());			
			secuencialAux.setnumero_ingreso(secuencialAux.getnumero_ingreso()+secuencial.getnumero_ingreso());			
			secuencialAux.setnumero_egreso(secuencialAux.getnumero_egreso()+secuencial.getnumero_egreso());			
			secuencialAux.setnumero_diario(secuencialAux.getnumero_diario()+secuencial.getnumero_diario());			
			secuencialAux.setnumero_retencion_iva(secuencialAux.getnumero_retencion_iva()+secuencial.getnumero_retencion_iva());			
			secuencialAux.setnumero_retencion_fuente(secuencialAux.getnumero_retencion_fuente()+secuencial.getnumero_retencion_fuente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSecuencial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SecuencialConstantesFunciones.getArrayColumnasGlobalesSecuencial(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSecuencial(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SecuencialConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SecuencialConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSecuencial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SecuencialConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(SecuencialConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(SecuencialConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Secuencial> secuencials,Secuencial secuencial,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Secuencial secuencialAux: secuencials) {
			if(secuencialAux!=null && secuencial!=null) {
				if((secuencialAux.getId()==null && secuencial.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(secuencialAux.getId()!=null && secuencial.getId()!=null){
					if(secuencialAux.getId().equals(secuencial.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSecuencial(List<Secuencial> secuencials) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Secuencial secuencial: secuencials) {			
			if(secuencial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSecuencial() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_ID, SecuencialConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_VERSIONROW, SecuencialConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDEMPRESA, SecuencialConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDSUCURSAL, SecuencialConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDEJERCICIO, SecuencialConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDPERIODO, SecuencialConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDANIO, SecuencialConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDMES, SecuencialConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDMODULO, SecuencialConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTO, SecuencialConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, SecuencialConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROASIENTO, SecuencialConstantesFunciones.NUMEROASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROINGRESO, SecuencialConstantesFunciones.NUMEROINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROEGRESO, SecuencialConstantesFunciones.NUMEROEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERODIARIO, SecuencialConstantesFunciones.NUMERODIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVA, SecuencialConstantesFunciones.NUMERORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTE, SecuencialConstantesFunciones.NUMERORETENCIONFUENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROASIENTOFORMATO, SecuencialConstantesFunciones.NUMEROASIENTOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROINGRESOFORMATO, SecuencialConstantesFunciones.NUMEROINGRESOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMEROEGRESOFORMATO, SecuencialConstantesFunciones.NUMEROEGRESOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERODIARIOFORMATO, SecuencialConstantesFunciones.NUMERODIARIOFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTEFORMATO, SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVAFORMATO, SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSecuencial() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERODIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERORETENCIONFUENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROASIENTOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROINGRESOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMEROEGRESOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERODIARIOFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencial() throws Exception  {
		return SecuencialConstantesFunciones.getTiposSeleccionarSecuencial(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencial(Boolean conFk) throws Exception  {
		return SecuencialConstantesFunciones.getTiposSeleccionarSecuencial(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSecuencial(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROASIENTO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROINGRESO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROEGRESO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERODIARIO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERODIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVA);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTE);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROASIENTOFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROASIENTOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROINGRESOFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROINGRESOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMEROEGRESOFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMEROEGRESOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERODIARIOFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERODIARIOFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTEFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTEFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVAFORMATO);
			reporte.setsDescripcion(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVAFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSecuencial(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSecuencial(Secuencial secuencialAux) throws Exception {
		
			secuencialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(secuencialAux.getEmpresa()));
			secuencialAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(secuencialAux.getSucursal()));
			secuencialAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(secuencialAux.getEjercicio()));
			secuencialAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(secuencialAux.getPeriodo()));
			secuencialAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(secuencialAux.getAnio()));
			secuencialAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(secuencialAux.getMes()));
			secuencialAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(secuencialAux.getModulo()));
			secuencialAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(secuencialAux.getTipoMovimientoModulo()));
			secuencialAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(secuencialAux.getTipoDocumento()));
			secuencialAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(secuencialAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSecuencial(List<Secuencial> secuencialsTemp) throws Exception {
		for(Secuencial secuencialAux:secuencialsTemp) {
			
			secuencialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(secuencialAux.getEmpresa()));
			secuencialAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(secuencialAux.getSucursal()));
			secuencialAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(secuencialAux.getEjercicio()));
			secuencialAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(secuencialAux.getPeriodo()));
			secuencialAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(secuencialAux.getAnio()));
			secuencialAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(secuencialAux.getMes()));
			secuencialAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(secuencialAux.getModulo()));
			secuencialAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(secuencialAux.getTipoMovimientoModulo()));
			secuencialAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(secuencialAux.getTipoDocumento()));
			secuencialAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(secuencialAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimientoModulo.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimientoModulo.class)) {
						classes.add(new Classe(TipoMovimientoModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SecuencialConstantesFunciones.getClassesRelationshipsOfSecuencial(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SecuencialConstantesFunciones.getClassesRelationshipsFromStringsOfSecuencial(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Secuencial secuencial,List<Secuencial> secuencials,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Secuencial secuencialEncontrado=null;
			
			for(Secuencial secuencialLocal:secuencials) {
				if(secuencialLocal.getId().equals(secuencial.getId())) {
					secuencialEncontrado=secuencialLocal;
					
					secuencialLocal.setIsChanged(secuencial.getIsChanged());
					secuencialLocal.setIsNew(secuencial.getIsNew());
					secuencialLocal.setIsDeleted(secuencial.getIsDeleted());
					
					secuencialLocal.setGeneralEntityOriginal(secuencial.getGeneralEntityOriginal());
					
					secuencialLocal.setId(secuencial.getId());	
					secuencialLocal.setVersionRow(secuencial.getVersionRow());	
					secuencialLocal.setid_empresa(secuencial.getid_empresa());	
					secuencialLocal.setid_sucursal(secuencial.getid_sucursal());	
					secuencialLocal.setid_ejercicio(secuencial.getid_ejercicio());	
					secuencialLocal.setid_periodo(secuencial.getid_periodo());	
					secuencialLocal.setid_anio(secuencial.getid_anio());	
					secuencialLocal.setid_mes(secuencial.getid_mes());	
					secuencialLocal.setid_modulo(secuencial.getid_modulo());	
					secuencialLocal.setid_tipo_movimiento_modulo(secuencial.getid_tipo_movimiento_modulo());	
					secuencialLocal.setid_tipo_documento(secuencial.getid_tipo_documento());	
					secuencialLocal.setid_tipo_movimiento(secuencial.getid_tipo_movimiento());	
					secuencialLocal.setnumero_asiento(secuencial.getnumero_asiento());	
					secuencialLocal.setnumero_ingreso(secuencial.getnumero_ingreso());	
					secuencialLocal.setnumero_egreso(secuencial.getnumero_egreso());	
					secuencialLocal.setnumero_diario(secuencial.getnumero_diario());	
					secuencialLocal.setnumero_retencion_iva(secuencial.getnumero_retencion_iva());	
					secuencialLocal.setnumero_retencion_fuente(secuencial.getnumero_retencion_fuente());	
					secuencialLocal.setnumero_asiento_formato(secuencial.getnumero_asiento_formato());	
					secuencialLocal.setnumero_ingreso_formato(secuencial.getnumero_ingreso_formato());	
					secuencialLocal.setnumero_egreso_formato(secuencial.getnumero_egreso_formato());	
					secuencialLocal.setnumero_diario_formato(secuencial.getnumero_diario_formato());	
					secuencialLocal.setnumero_retencion_fuente_formato(secuencial.getnumero_retencion_fuente_formato());	
					secuencialLocal.setnumero_retencion_iva_formato(secuencial.getnumero_retencion_iva_formato());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!secuencial.getIsDeleted()) {
				if(!existe) {
					secuencials.add(secuencial);
				}
			} else {
				if(secuencialEncontrado!=null && permiteQuitar)  {
					secuencials.remove(secuencialEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Secuencial secuencial,List<Secuencial> secuencials) throws Exception {
		try	{			
			for(Secuencial secuencialLocal:secuencials) {
				if(secuencialLocal.getId().equals(secuencial.getId())) {
					secuencialLocal.setIsSelected(secuencial.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSecuencial(List<Secuencial> secuencialsAux) throws Exception {
		//this.secuencialsAux=secuencialsAux;
		
		for(Secuencial secuencialAux:secuencialsAux) {
			if(secuencialAux.getIsChanged()) {
				secuencialAux.setIsChanged(false);
			}		
			
			if(secuencialAux.getIsNew()) {
				secuencialAux.setIsNew(false);
			}	
			
			if(secuencialAux.getIsDeleted()) {
				secuencialAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSecuencial(Secuencial secuencialAux) throws Exception {
		//this.secuencialAux=secuencialAux;
		
			if(secuencialAux.getIsChanged()) {
				secuencialAux.setIsChanged(false);
			}		
			
			if(secuencialAux.getIsNew()) {
				secuencialAux.setIsNew(false);
			}	
			
			if(secuencialAux.getIsDeleted()) {
				secuencialAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Secuencial secuencialAsignar,Secuencial secuencial) throws Exception {
		secuencialAsignar.setId(secuencial.getId());	
		secuencialAsignar.setVersionRow(secuencial.getVersionRow());	
		secuencialAsignar.setid_empresa(secuencial.getid_empresa());
		secuencialAsignar.setempresa_descripcion(secuencial.getempresa_descripcion());	
		secuencialAsignar.setid_sucursal(secuencial.getid_sucursal());
		secuencialAsignar.setsucursal_descripcion(secuencial.getsucursal_descripcion());	
		secuencialAsignar.setid_ejercicio(secuencial.getid_ejercicio());
		secuencialAsignar.setejercicio_descripcion(secuencial.getejercicio_descripcion());	
		secuencialAsignar.setid_periodo(secuencial.getid_periodo());
		secuencialAsignar.setperiodo_descripcion(secuencial.getperiodo_descripcion());	
		secuencialAsignar.setid_anio(secuencial.getid_anio());
		secuencialAsignar.setanio_descripcion(secuencial.getanio_descripcion());	
		secuencialAsignar.setid_mes(secuencial.getid_mes());
		secuencialAsignar.setmes_descripcion(secuencial.getmes_descripcion());	
		secuencialAsignar.setid_modulo(secuencial.getid_modulo());
		secuencialAsignar.setmodulo_descripcion(secuencial.getmodulo_descripcion());	
		secuencialAsignar.setid_tipo_movimiento_modulo(secuencial.getid_tipo_movimiento_modulo());
		secuencialAsignar.settipomovimientomodulo_descripcion(secuencial.gettipomovimientomodulo_descripcion());	
		secuencialAsignar.setid_tipo_documento(secuencial.getid_tipo_documento());
		secuencialAsignar.settipodocumento_descripcion(secuencial.gettipodocumento_descripcion());	
		secuencialAsignar.setid_tipo_movimiento(secuencial.getid_tipo_movimiento());
		secuencialAsignar.settipomovimiento_descripcion(secuencial.gettipomovimiento_descripcion());	
		secuencialAsignar.setnumero_asiento(secuencial.getnumero_asiento());	
		secuencialAsignar.setnumero_ingreso(secuencial.getnumero_ingreso());	
		secuencialAsignar.setnumero_egreso(secuencial.getnumero_egreso());	
		secuencialAsignar.setnumero_diario(secuencial.getnumero_diario());	
		secuencialAsignar.setnumero_retencion_iva(secuencial.getnumero_retencion_iva());	
		secuencialAsignar.setnumero_retencion_fuente(secuencial.getnumero_retencion_fuente());	
		secuencialAsignar.setnumero_asiento_formato(secuencial.getnumero_asiento_formato());	
		secuencialAsignar.setnumero_ingreso_formato(secuencial.getnumero_ingreso_formato());	
		secuencialAsignar.setnumero_egreso_formato(secuencial.getnumero_egreso_formato());	
		secuencialAsignar.setnumero_diario_formato(secuencial.getnumero_diario_formato());	
		secuencialAsignar.setnumero_retencion_fuente_formato(secuencial.getnumero_retencion_fuente_formato());	
		secuencialAsignar.setnumero_retencion_iva_formato(secuencial.getnumero_retencion_iva_formato());	
	}
	
	public static void inicializarSecuencial(Secuencial secuencial) throws Exception {
		try {
				secuencial.setId(0L);	
					
				secuencial.setid_empresa(-1L);	
				secuencial.setid_sucursal(-1L);	
				secuencial.setid_ejercicio(-1L);	
				secuencial.setid_periodo(-1L);	
				secuencial.setid_anio(null);	
				secuencial.setid_mes(null);	
				secuencial.setid_modulo(-1L);	
				secuencial.setid_tipo_movimiento_modulo(-1L);	
				secuencial.setid_tipo_documento(-1L);	
				secuencial.setid_tipo_movimiento(-1L);	
				secuencial.setnumero_asiento(0L);	
				secuencial.setnumero_ingreso(0L);	
				secuencial.setnumero_egreso(0L);	
				secuencial.setnumero_diario(0L);	
				secuencial.setnumero_retencion_iva(0L);	
				secuencial.setnumero_retencion_fuente(0L);	
				secuencial.setnumero_asiento_formato("");	
				secuencial.setnumero_ingreso_formato("");	
				secuencial.setnumero_egreso_formato("");	
				secuencial.setnumero_diario_formato("");	
				secuencial.setnumero_retencion_fuente_formato("");	
				secuencial.setnumero_retencion_iva_formato("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSecuencial(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERODIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROASIENTOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROINGRESOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMEROEGRESOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERODIARIOFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONFUENTEFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SecuencialConstantesFunciones.LABEL_NUMERORETENCIONIVAFORMATO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSecuencial(String sTipo,Row row,Workbook workbook,Secuencial secuencial,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_diario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_retencion_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_retencion_fuente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_asiento_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_ingreso_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_egreso_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_diario_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_retencion_fuente_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(secuencial.getnumero_retencion_iva_formato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySecuencial=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySecuencial() {
		return this.sFinalQuerySecuencial;
	}
	
	public void setsFinalQuerySecuencial(String sFinalQuerySecuencial) {
		this.sFinalQuerySecuencial= sFinalQuerySecuencial;
	}
	
	public Border resaltarSeleccionarSecuencial=null;
	
	public Border setResaltarSeleccionarSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSecuencial= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSecuencial() {
		return this.resaltarSeleccionarSecuencial;
	}
	
	public void setResaltarSeleccionarSecuencial(Border borderResaltarSeleccionarSecuencial) {
		this.resaltarSeleccionarSecuencial= borderResaltarSeleccionarSecuencial;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSecuencial=null;
	public Boolean mostraridSecuencial=true;
	public Boolean activaridSecuencial=true;

	public Border resaltarid_empresaSecuencial=null;
	public Boolean mostrarid_empresaSecuencial=true;
	public Boolean activarid_empresaSecuencial=true;
	public Boolean cargarid_empresaSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSecuencial=false;//ConEventDepend=true

	public Border resaltarid_sucursalSecuencial=null;
	public Boolean mostrarid_sucursalSecuencial=true;
	public Boolean activarid_sucursalSecuencial=true;
	public Boolean cargarid_sucursalSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSecuencial=false;//ConEventDepend=true

	public Border resaltarid_ejercicioSecuencial=null;
	public Boolean mostrarid_ejercicioSecuencial=true;
	public Boolean activarid_ejercicioSecuencial=true;
	public Boolean cargarid_ejercicioSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioSecuencial=false;//ConEventDepend=true

	public Border resaltarid_periodoSecuencial=null;
	public Boolean mostrarid_periodoSecuencial=true;
	public Boolean activarid_periodoSecuencial=true;
	public Boolean cargarid_periodoSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoSecuencial=true;//ConEventDepend=true

	public Border resaltarid_anioSecuencial=null;
	public Boolean mostrarid_anioSecuencial=true;
	public Boolean activarid_anioSecuencial=false;
	public Boolean cargarid_anioSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioSecuencial=false;//ConEventDepend=true

	public Border resaltarid_mesSecuencial=null;
	public Boolean mostrarid_mesSecuencial=true;
	public Boolean activarid_mesSecuencial=false;
	public Boolean cargarid_mesSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesSecuencial=false;//ConEventDepend=true

	public Border resaltarid_moduloSecuencial=null;
	public Boolean mostrarid_moduloSecuencial=true;
	public Boolean activarid_moduloSecuencial=true;
	public Boolean cargarid_moduloSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloSecuencial=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloSecuencial=null;
	public Boolean mostrarid_tipo_movimiento_moduloSecuencial=true;
	public Boolean activarid_tipo_movimiento_moduloSecuencial=false;
	public Boolean cargarid_tipo_movimiento_moduloSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloSecuencial=true;//ConEventDepend=true

	public Border resaltarid_tipo_documentoSecuencial=null;
	public Boolean mostrarid_tipo_documentoSecuencial=true;
	public Boolean activarid_tipo_documentoSecuencial=true;
	public Boolean cargarid_tipo_documentoSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoSecuencial=true;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoSecuencial=null;
	public Boolean mostrarid_tipo_movimientoSecuencial=true;
	public Boolean activarid_tipo_movimientoSecuencial=true;
	public Boolean cargarid_tipo_movimientoSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoSecuencial=false;//ConEventDepend=true

	public Border resaltarnumero_asientoSecuencial=null;
	public Boolean mostrarnumero_asientoSecuencial=true;
	public Boolean activarnumero_asientoSecuencial=true;

	public Border resaltarnumero_ingresoSecuencial=null;
	public Boolean mostrarnumero_ingresoSecuencial=true;
	public Boolean activarnumero_ingresoSecuencial=true;

	public Border resaltarnumero_egresoSecuencial=null;
	public Boolean mostrarnumero_egresoSecuencial=true;
	public Boolean activarnumero_egresoSecuencial=true;

	public Border resaltarnumero_diarioSecuencial=null;
	public Boolean mostrarnumero_diarioSecuencial=true;
	public Boolean activarnumero_diarioSecuencial=true;

	public Border resaltarnumero_retencion_ivaSecuencial=null;
	public Boolean mostrarnumero_retencion_ivaSecuencial=true;
	public Boolean activarnumero_retencion_ivaSecuencial=true;

	public Border resaltarnumero_retencion_fuenteSecuencial=null;
	public Boolean mostrarnumero_retencion_fuenteSecuencial=true;
	public Boolean activarnumero_retencion_fuenteSecuencial=true;

	public Border resaltarnumero_asiento_formatoSecuencial=null;
	public Boolean mostrarnumero_asiento_formatoSecuencial=true;
	public Boolean activarnumero_asiento_formatoSecuencial=true;

	public Border resaltarnumero_ingreso_formatoSecuencial=null;
	public Boolean mostrarnumero_ingreso_formatoSecuencial=true;
	public Boolean activarnumero_ingreso_formatoSecuencial=true;

	public Border resaltarnumero_egreso_formatoSecuencial=null;
	public Boolean mostrarnumero_egreso_formatoSecuencial=true;
	public Boolean activarnumero_egreso_formatoSecuencial=true;

	public Border resaltarnumero_diario_formatoSecuencial=null;
	public Boolean mostrarnumero_diario_formatoSecuencial=true;
	public Boolean activarnumero_diario_formatoSecuencial=true;

	public Border resaltarnumero_retencion_fuente_formatoSecuencial=null;
	public Boolean mostrarnumero_retencion_fuente_formatoSecuencial=true;
	public Boolean activarnumero_retencion_fuente_formatoSecuencial=true;

	public Border resaltarnumero_retencion_iva_formatoSecuencial=null;
	public Boolean mostrarnumero_retencion_iva_formatoSecuencial=true;
	public Boolean activarnumero_retencion_iva_formatoSecuencial=true;

	
	

	public Border setResaltaridSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltaridSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSecuencial() {
		return this.resaltaridSecuencial;
	}

	public void setResaltaridSecuencial(Border borderResaltar) {
		this.resaltaridSecuencial= borderResaltar;
	}

	public Boolean getMostraridSecuencial() {
		return this.mostraridSecuencial;
	}

	public void setMostraridSecuencial(Boolean mostraridSecuencial) {
		this.mostraridSecuencial= mostraridSecuencial;
	}

	public Boolean getActivaridSecuencial() {
		return this.activaridSecuencial;
	}

	public void setActivaridSecuencial(Boolean activaridSecuencial) {
		this.activaridSecuencial= activaridSecuencial;
	}

	public Border setResaltarid_empresaSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_empresaSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSecuencial() {
		return this.resaltarid_empresaSecuencial;
	}

	public void setResaltarid_empresaSecuencial(Border borderResaltar) {
		this.resaltarid_empresaSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_empresaSecuencial() {
		return this.mostrarid_empresaSecuencial;
	}

	public void setMostrarid_empresaSecuencial(Boolean mostrarid_empresaSecuencial) {
		this.mostrarid_empresaSecuencial= mostrarid_empresaSecuencial;
	}

	public Boolean getActivarid_empresaSecuencial() {
		return this.activarid_empresaSecuencial;
	}

	public void setActivarid_empresaSecuencial(Boolean activarid_empresaSecuencial) {
		this.activarid_empresaSecuencial= activarid_empresaSecuencial;
	}

	public Boolean getCargarid_empresaSecuencial() {
		return this.cargarid_empresaSecuencial;
	}

	public void setCargarid_empresaSecuencial(Boolean cargarid_empresaSecuencial) {
		this.cargarid_empresaSecuencial= cargarid_empresaSecuencial;
	}

	public Border setResaltarid_sucursalSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSecuencial() {
		return this.resaltarid_sucursalSecuencial;
	}

	public void setResaltarid_sucursalSecuencial(Border borderResaltar) {
		this.resaltarid_sucursalSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSecuencial() {
		return this.mostrarid_sucursalSecuencial;
	}

	public void setMostrarid_sucursalSecuencial(Boolean mostrarid_sucursalSecuencial) {
		this.mostrarid_sucursalSecuencial= mostrarid_sucursalSecuencial;
	}

	public Boolean getActivarid_sucursalSecuencial() {
		return this.activarid_sucursalSecuencial;
	}

	public void setActivarid_sucursalSecuencial(Boolean activarid_sucursalSecuencial) {
		this.activarid_sucursalSecuencial= activarid_sucursalSecuencial;
	}

	public Boolean getCargarid_sucursalSecuencial() {
		return this.cargarid_sucursalSecuencial;
	}

	public void setCargarid_sucursalSecuencial(Boolean cargarid_sucursalSecuencial) {
		this.cargarid_sucursalSecuencial= cargarid_sucursalSecuencial;
	}

	public Border setResaltarid_ejercicioSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioSecuencial() {
		return this.resaltarid_ejercicioSecuencial;
	}

	public void setResaltarid_ejercicioSecuencial(Border borderResaltar) {
		this.resaltarid_ejercicioSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioSecuencial() {
		return this.mostrarid_ejercicioSecuencial;
	}

	public void setMostrarid_ejercicioSecuencial(Boolean mostrarid_ejercicioSecuencial) {
		this.mostrarid_ejercicioSecuencial= mostrarid_ejercicioSecuencial;
	}

	public Boolean getActivarid_ejercicioSecuencial() {
		return this.activarid_ejercicioSecuencial;
	}

	public void setActivarid_ejercicioSecuencial(Boolean activarid_ejercicioSecuencial) {
		this.activarid_ejercicioSecuencial= activarid_ejercicioSecuencial;
	}

	public Boolean getCargarid_ejercicioSecuencial() {
		return this.cargarid_ejercicioSecuencial;
	}

	public void setCargarid_ejercicioSecuencial(Boolean cargarid_ejercicioSecuencial) {
		this.cargarid_ejercicioSecuencial= cargarid_ejercicioSecuencial;
	}

	public Border setResaltarid_periodoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_periodoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoSecuencial() {
		return this.resaltarid_periodoSecuencial;
	}

	public void setResaltarid_periodoSecuencial(Border borderResaltar) {
		this.resaltarid_periodoSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_periodoSecuencial() {
		return this.mostrarid_periodoSecuencial;
	}

	public void setMostrarid_periodoSecuencial(Boolean mostrarid_periodoSecuencial) {
		this.mostrarid_periodoSecuencial= mostrarid_periodoSecuencial;
	}

	public Boolean getActivarid_periodoSecuencial() {
		return this.activarid_periodoSecuencial;
	}

	public void setActivarid_periodoSecuencial(Boolean activarid_periodoSecuencial) {
		this.activarid_periodoSecuencial= activarid_periodoSecuencial;
	}

	public Boolean getCargarid_periodoSecuencial() {
		return this.cargarid_periodoSecuencial;
	}

	public void setCargarid_periodoSecuencial(Boolean cargarid_periodoSecuencial) {
		this.cargarid_periodoSecuencial= cargarid_periodoSecuencial;
	}

	public Border setResaltarid_anioSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_anioSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioSecuencial() {
		return this.resaltarid_anioSecuencial;
	}

	public void setResaltarid_anioSecuencial(Border borderResaltar) {
		this.resaltarid_anioSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_anioSecuencial() {
		return this.mostrarid_anioSecuencial;
	}

	public void setMostrarid_anioSecuencial(Boolean mostrarid_anioSecuencial) {
		this.mostrarid_anioSecuencial= mostrarid_anioSecuencial;
	}

	public Boolean getActivarid_anioSecuencial() {
		return this.activarid_anioSecuencial;
	}

	public void setActivarid_anioSecuencial(Boolean activarid_anioSecuencial) {
		this.activarid_anioSecuencial= activarid_anioSecuencial;
	}

	public Boolean getCargarid_anioSecuencial() {
		return this.cargarid_anioSecuencial;
	}

	public void setCargarid_anioSecuencial(Boolean cargarid_anioSecuencial) {
		this.cargarid_anioSecuencial= cargarid_anioSecuencial;
	}

	public Border setResaltarid_mesSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_mesSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesSecuencial() {
		return this.resaltarid_mesSecuencial;
	}

	public void setResaltarid_mesSecuencial(Border borderResaltar) {
		this.resaltarid_mesSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_mesSecuencial() {
		return this.mostrarid_mesSecuencial;
	}

	public void setMostrarid_mesSecuencial(Boolean mostrarid_mesSecuencial) {
		this.mostrarid_mesSecuencial= mostrarid_mesSecuencial;
	}

	public Boolean getActivarid_mesSecuencial() {
		return this.activarid_mesSecuencial;
	}

	public void setActivarid_mesSecuencial(Boolean activarid_mesSecuencial) {
		this.activarid_mesSecuencial= activarid_mesSecuencial;
	}

	public Boolean getCargarid_mesSecuencial() {
		return this.cargarid_mesSecuencial;
	}

	public void setCargarid_mesSecuencial(Boolean cargarid_mesSecuencial) {
		this.cargarid_mesSecuencial= cargarid_mesSecuencial;
	}

	public Border setResaltarid_moduloSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_moduloSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloSecuencial() {
		return this.resaltarid_moduloSecuencial;
	}

	public void setResaltarid_moduloSecuencial(Border borderResaltar) {
		this.resaltarid_moduloSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_moduloSecuencial() {
		return this.mostrarid_moduloSecuencial;
	}

	public void setMostrarid_moduloSecuencial(Boolean mostrarid_moduloSecuencial) {
		this.mostrarid_moduloSecuencial= mostrarid_moduloSecuencial;
	}

	public Boolean getActivarid_moduloSecuencial() {
		return this.activarid_moduloSecuencial;
	}

	public void setActivarid_moduloSecuencial(Boolean activarid_moduloSecuencial) {
		this.activarid_moduloSecuencial= activarid_moduloSecuencial;
	}

	public Boolean getCargarid_moduloSecuencial() {
		return this.cargarid_moduloSecuencial;
	}

	public void setCargarid_moduloSecuencial(Boolean cargarid_moduloSecuencial) {
		this.cargarid_moduloSecuencial= cargarid_moduloSecuencial;
	}

	public Border setResaltarid_tipo_movimiento_moduloSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloSecuencial() {
		return this.resaltarid_tipo_movimiento_moduloSecuencial;
	}

	public void setResaltarid_tipo_movimiento_moduloSecuencial(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloSecuencial() {
		return this.mostrarid_tipo_movimiento_moduloSecuencial;
	}

	public void setMostrarid_tipo_movimiento_moduloSecuencial(Boolean mostrarid_tipo_movimiento_moduloSecuencial) {
		this.mostrarid_tipo_movimiento_moduloSecuencial= mostrarid_tipo_movimiento_moduloSecuencial;
	}

	public Boolean getActivarid_tipo_movimiento_moduloSecuencial() {
		return this.activarid_tipo_movimiento_moduloSecuencial;
	}

	public void setActivarid_tipo_movimiento_moduloSecuencial(Boolean activarid_tipo_movimiento_moduloSecuencial) {
		this.activarid_tipo_movimiento_moduloSecuencial= activarid_tipo_movimiento_moduloSecuencial;
	}

	public Boolean getCargarid_tipo_movimiento_moduloSecuencial() {
		return this.cargarid_tipo_movimiento_moduloSecuencial;
	}

	public void setCargarid_tipo_movimiento_moduloSecuencial(Boolean cargarid_tipo_movimiento_moduloSecuencial) {
		this.cargarid_tipo_movimiento_moduloSecuencial= cargarid_tipo_movimiento_moduloSecuencial;
	}

	public Border setResaltarid_tipo_documentoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoSecuencial() {
		return this.resaltarid_tipo_documentoSecuencial;
	}

	public void setResaltarid_tipo_documentoSecuencial(Border borderResaltar) {
		this.resaltarid_tipo_documentoSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoSecuencial() {
		return this.mostrarid_tipo_documentoSecuencial;
	}

	public void setMostrarid_tipo_documentoSecuencial(Boolean mostrarid_tipo_documentoSecuencial) {
		this.mostrarid_tipo_documentoSecuencial= mostrarid_tipo_documentoSecuencial;
	}

	public Boolean getActivarid_tipo_documentoSecuencial() {
		return this.activarid_tipo_documentoSecuencial;
	}

	public void setActivarid_tipo_documentoSecuencial(Boolean activarid_tipo_documentoSecuencial) {
		this.activarid_tipo_documentoSecuencial= activarid_tipo_documentoSecuencial;
	}

	public Boolean getCargarid_tipo_documentoSecuencial() {
		return this.cargarid_tipo_documentoSecuencial;
	}

	public void setCargarid_tipo_documentoSecuencial(Boolean cargarid_tipo_documentoSecuencial) {
		this.cargarid_tipo_documentoSecuencial= cargarid_tipo_documentoSecuencial;
	}

	public Border setResaltarid_tipo_movimientoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoSecuencial() {
		return this.resaltarid_tipo_movimientoSecuencial;
	}

	public void setResaltarid_tipo_movimientoSecuencial(Border borderResaltar) {
		this.resaltarid_tipo_movimientoSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoSecuencial() {
		return this.mostrarid_tipo_movimientoSecuencial;
	}

	public void setMostrarid_tipo_movimientoSecuencial(Boolean mostrarid_tipo_movimientoSecuencial) {
		this.mostrarid_tipo_movimientoSecuencial= mostrarid_tipo_movimientoSecuencial;
	}

	public Boolean getActivarid_tipo_movimientoSecuencial() {
		return this.activarid_tipo_movimientoSecuencial;
	}

	public void setActivarid_tipo_movimientoSecuencial(Boolean activarid_tipo_movimientoSecuencial) {
		this.activarid_tipo_movimientoSecuencial= activarid_tipo_movimientoSecuencial;
	}

	public Boolean getCargarid_tipo_movimientoSecuencial() {
		return this.cargarid_tipo_movimientoSecuencial;
	}

	public void setCargarid_tipo_movimientoSecuencial(Boolean cargarid_tipo_movimientoSecuencial) {
		this.cargarid_tipo_movimientoSecuencial= cargarid_tipo_movimientoSecuencial;
	}

	public Border setResaltarnumero_asientoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_asientoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_asientoSecuencial() {
		return this.resaltarnumero_asientoSecuencial;
	}

	public void setResaltarnumero_asientoSecuencial(Border borderResaltar) {
		this.resaltarnumero_asientoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_asientoSecuencial() {
		return this.mostrarnumero_asientoSecuencial;
	}

	public void setMostrarnumero_asientoSecuencial(Boolean mostrarnumero_asientoSecuencial) {
		this.mostrarnumero_asientoSecuencial= mostrarnumero_asientoSecuencial;
	}

	public Boolean getActivarnumero_asientoSecuencial() {
		return this.activarnumero_asientoSecuencial;
	}

	public void setActivarnumero_asientoSecuencial(Boolean activarnumero_asientoSecuencial) {
		this.activarnumero_asientoSecuencial= activarnumero_asientoSecuencial;
	}

	public Border setResaltarnumero_ingresoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_ingresoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_ingresoSecuencial() {
		return this.resaltarnumero_ingresoSecuencial;
	}

	public void setResaltarnumero_ingresoSecuencial(Border borderResaltar) {
		this.resaltarnumero_ingresoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_ingresoSecuencial() {
		return this.mostrarnumero_ingresoSecuencial;
	}

	public void setMostrarnumero_ingresoSecuencial(Boolean mostrarnumero_ingresoSecuencial) {
		this.mostrarnumero_ingresoSecuencial= mostrarnumero_ingresoSecuencial;
	}

	public Boolean getActivarnumero_ingresoSecuencial() {
		return this.activarnumero_ingresoSecuencial;
	}

	public void setActivarnumero_ingresoSecuencial(Boolean activarnumero_ingresoSecuencial) {
		this.activarnumero_ingresoSecuencial= activarnumero_ingresoSecuencial;
	}

	public Border setResaltarnumero_egresoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_egresoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_egresoSecuencial() {
		return this.resaltarnumero_egresoSecuencial;
	}

	public void setResaltarnumero_egresoSecuencial(Border borderResaltar) {
		this.resaltarnumero_egresoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_egresoSecuencial() {
		return this.mostrarnumero_egresoSecuencial;
	}

	public void setMostrarnumero_egresoSecuencial(Boolean mostrarnumero_egresoSecuencial) {
		this.mostrarnumero_egresoSecuencial= mostrarnumero_egresoSecuencial;
	}

	public Boolean getActivarnumero_egresoSecuencial() {
		return this.activarnumero_egresoSecuencial;
	}

	public void setActivarnumero_egresoSecuencial(Boolean activarnumero_egresoSecuencial) {
		this.activarnumero_egresoSecuencial= activarnumero_egresoSecuencial;
	}

	public Border setResaltarnumero_diarioSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_diarioSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diarioSecuencial() {
		return this.resaltarnumero_diarioSecuencial;
	}

	public void setResaltarnumero_diarioSecuencial(Border borderResaltar) {
		this.resaltarnumero_diarioSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_diarioSecuencial() {
		return this.mostrarnumero_diarioSecuencial;
	}

	public void setMostrarnumero_diarioSecuencial(Boolean mostrarnumero_diarioSecuencial) {
		this.mostrarnumero_diarioSecuencial= mostrarnumero_diarioSecuencial;
	}

	public Boolean getActivarnumero_diarioSecuencial() {
		return this.activarnumero_diarioSecuencial;
	}

	public void setActivarnumero_diarioSecuencial(Boolean activarnumero_diarioSecuencial) {
		this.activarnumero_diarioSecuencial= activarnumero_diarioSecuencial;
	}

	public Border setResaltarnumero_retencion_ivaSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_retencion_ivaSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencion_ivaSecuencial() {
		return this.resaltarnumero_retencion_ivaSecuencial;
	}

	public void setResaltarnumero_retencion_ivaSecuencial(Border borderResaltar) {
		this.resaltarnumero_retencion_ivaSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_retencion_ivaSecuencial() {
		return this.mostrarnumero_retencion_ivaSecuencial;
	}

	public void setMostrarnumero_retencion_ivaSecuencial(Boolean mostrarnumero_retencion_ivaSecuencial) {
		this.mostrarnumero_retencion_ivaSecuencial= mostrarnumero_retencion_ivaSecuencial;
	}

	public Boolean getActivarnumero_retencion_ivaSecuencial() {
		return this.activarnumero_retencion_ivaSecuencial;
	}

	public void setActivarnumero_retencion_ivaSecuencial(Boolean activarnumero_retencion_ivaSecuencial) {
		this.activarnumero_retencion_ivaSecuencial= activarnumero_retencion_ivaSecuencial;
	}

	public Border setResaltarnumero_retencion_fuenteSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_retencion_fuenteSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencion_fuenteSecuencial() {
		return this.resaltarnumero_retencion_fuenteSecuencial;
	}

	public void setResaltarnumero_retencion_fuenteSecuencial(Border borderResaltar) {
		this.resaltarnumero_retencion_fuenteSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_retencion_fuenteSecuencial() {
		return this.mostrarnumero_retencion_fuenteSecuencial;
	}

	public void setMostrarnumero_retencion_fuenteSecuencial(Boolean mostrarnumero_retencion_fuenteSecuencial) {
		this.mostrarnumero_retencion_fuenteSecuencial= mostrarnumero_retencion_fuenteSecuencial;
	}

	public Boolean getActivarnumero_retencion_fuenteSecuencial() {
		return this.activarnumero_retencion_fuenteSecuencial;
	}

	public void setActivarnumero_retencion_fuenteSecuencial(Boolean activarnumero_retencion_fuenteSecuencial) {
		this.activarnumero_retencion_fuenteSecuencial= activarnumero_retencion_fuenteSecuencial;
	}

	public Border setResaltarnumero_asiento_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_asiento_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_asiento_formatoSecuencial() {
		return this.resaltarnumero_asiento_formatoSecuencial;
	}

	public void setResaltarnumero_asiento_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_asiento_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_asiento_formatoSecuencial() {
		return this.mostrarnumero_asiento_formatoSecuencial;
	}

	public void setMostrarnumero_asiento_formatoSecuencial(Boolean mostrarnumero_asiento_formatoSecuencial) {
		this.mostrarnumero_asiento_formatoSecuencial= mostrarnumero_asiento_formatoSecuencial;
	}

	public Boolean getActivarnumero_asiento_formatoSecuencial() {
		return this.activarnumero_asiento_formatoSecuencial;
	}

	public void setActivarnumero_asiento_formatoSecuencial(Boolean activarnumero_asiento_formatoSecuencial) {
		this.activarnumero_asiento_formatoSecuencial= activarnumero_asiento_formatoSecuencial;
	}

	public Border setResaltarnumero_ingreso_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_ingreso_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_ingreso_formatoSecuencial() {
		return this.resaltarnumero_ingreso_formatoSecuencial;
	}

	public void setResaltarnumero_ingreso_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_ingreso_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_ingreso_formatoSecuencial() {
		return this.mostrarnumero_ingreso_formatoSecuencial;
	}

	public void setMostrarnumero_ingreso_formatoSecuencial(Boolean mostrarnumero_ingreso_formatoSecuencial) {
		this.mostrarnumero_ingreso_formatoSecuencial= mostrarnumero_ingreso_formatoSecuencial;
	}

	public Boolean getActivarnumero_ingreso_formatoSecuencial() {
		return this.activarnumero_ingreso_formatoSecuencial;
	}

	public void setActivarnumero_ingreso_formatoSecuencial(Boolean activarnumero_ingreso_formatoSecuencial) {
		this.activarnumero_ingreso_formatoSecuencial= activarnumero_ingreso_formatoSecuencial;
	}

	public Border setResaltarnumero_egreso_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_egreso_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_egreso_formatoSecuencial() {
		return this.resaltarnumero_egreso_formatoSecuencial;
	}

	public void setResaltarnumero_egreso_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_egreso_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_egreso_formatoSecuencial() {
		return this.mostrarnumero_egreso_formatoSecuencial;
	}

	public void setMostrarnumero_egreso_formatoSecuencial(Boolean mostrarnumero_egreso_formatoSecuencial) {
		this.mostrarnumero_egreso_formatoSecuencial= mostrarnumero_egreso_formatoSecuencial;
	}

	public Boolean getActivarnumero_egreso_formatoSecuencial() {
		return this.activarnumero_egreso_formatoSecuencial;
	}

	public void setActivarnumero_egreso_formatoSecuencial(Boolean activarnumero_egreso_formatoSecuencial) {
		this.activarnumero_egreso_formatoSecuencial= activarnumero_egreso_formatoSecuencial;
	}

	public Border setResaltarnumero_diario_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_diario_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diario_formatoSecuencial() {
		return this.resaltarnumero_diario_formatoSecuencial;
	}

	public void setResaltarnumero_diario_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_diario_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_diario_formatoSecuencial() {
		return this.mostrarnumero_diario_formatoSecuencial;
	}

	public void setMostrarnumero_diario_formatoSecuencial(Boolean mostrarnumero_diario_formatoSecuencial) {
		this.mostrarnumero_diario_formatoSecuencial= mostrarnumero_diario_formatoSecuencial;
	}

	public Boolean getActivarnumero_diario_formatoSecuencial() {
		return this.activarnumero_diario_formatoSecuencial;
	}

	public void setActivarnumero_diario_formatoSecuencial(Boolean activarnumero_diario_formatoSecuencial) {
		this.activarnumero_diario_formatoSecuencial= activarnumero_diario_formatoSecuencial;
	}

	public Border setResaltarnumero_retencion_fuente_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_retencion_fuente_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencion_fuente_formatoSecuencial() {
		return this.resaltarnumero_retencion_fuente_formatoSecuencial;
	}

	public void setResaltarnumero_retencion_fuente_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_retencion_fuente_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_retencion_fuente_formatoSecuencial() {
		return this.mostrarnumero_retencion_fuente_formatoSecuencial;
	}

	public void setMostrarnumero_retencion_fuente_formatoSecuencial(Boolean mostrarnumero_retencion_fuente_formatoSecuencial) {
		this.mostrarnumero_retencion_fuente_formatoSecuencial= mostrarnumero_retencion_fuente_formatoSecuencial;
	}

	public Boolean getActivarnumero_retencion_fuente_formatoSecuencial() {
		return this.activarnumero_retencion_fuente_formatoSecuencial;
	}

	public void setActivarnumero_retencion_fuente_formatoSecuencial(Boolean activarnumero_retencion_fuente_formatoSecuencial) {
		this.activarnumero_retencion_fuente_formatoSecuencial= activarnumero_retencion_fuente_formatoSecuencial;
	}

	public Border setResaltarnumero_retencion_iva_formatoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//secuencialBeanSwingJInternalFrame.jTtoolBarSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_retencion_iva_formatoSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencion_iva_formatoSecuencial() {
		return this.resaltarnumero_retencion_iva_formatoSecuencial;
	}

	public void setResaltarnumero_retencion_iva_formatoSecuencial(Border borderResaltar) {
		this.resaltarnumero_retencion_iva_formatoSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_retencion_iva_formatoSecuencial() {
		return this.mostrarnumero_retencion_iva_formatoSecuencial;
	}

	public void setMostrarnumero_retencion_iva_formatoSecuencial(Boolean mostrarnumero_retencion_iva_formatoSecuencial) {
		this.mostrarnumero_retencion_iva_formatoSecuencial= mostrarnumero_retencion_iva_formatoSecuencial;
	}

	public Boolean getActivarnumero_retencion_iva_formatoSecuencial() {
		return this.activarnumero_retencion_iva_formatoSecuencial;
	}

	public void setActivarnumero_retencion_iva_formatoSecuencial(Boolean activarnumero_retencion_iva_formatoSecuencial) {
		this.activarnumero_retencion_iva_formatoSecuencial= activarnumero_retencion_iva_formatoSecuencial;
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
		
		
		this.setMostraridSecuencial(esInicial);
		this.setMostrarid_empresaSecuencial(esInicial);
		this.setMostrarid_sucursalSecuencial(esInicial);
		this.setMostrarid_ejercicioSecuencial(esInicial);
		this.setMostrarid_periodoSecuencial(esInicial);
		this.setMostrarid_anioSecuencial(esInicial);
		this.setMostrarid_mesSecuencial(esInicial);
		this.setMostrarid_moduloSecuencial(esInicial);
		this.setMostrarid_tipo_movimiento_moduloSecuencial(esInicial);
		this.setMostrarid_tipo_documentoSecuencial(esInicial);
		this.setMostrarid_tipo_movimientoSecuencial(esInicial);
		this.setMostrarnumero_asientoSecuencial(esInicial);
		this.setMostrarnumero_ingresoSecuencial(esInicial);
		this.setMostrarnumero_egresoSecuencial(esInicial);
		this.setMostrarnumero_diarioSecuencial(esInicial);
		this.setMostrarnumero_retencion_ivaSecuencial(esInicial);
		this.setMostrarnumero_retencion_fuenteSecuencial(esInicial);
		this.setMostrarnumero_asiento_formatoSecuencial(esInicial);
		this.setMostrarnumero_ingreso_formatoSecuencial(esInicial);
		this.setMostrarnumero_egreso_formatoSecuencial(esInicial);
		this.setMostrarnumero_diario_formatoSecuencial(esInicial);
		this.setMostrarnumero_retencion_fuente_formatoSecuencial(esInicial);
		this.setMostrarnumero_retencion_iva_formatoSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialConstantesFunciones.ID)) {
				this.setMostraridSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMES)) {
				this.setMostrarid_mesSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTO)) {
				this.setMostrarnumero_asientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESO)) {
				this.setMostrarnumero_ingresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESO)) {
				this.setMostrarnumero_egresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIO)) {
				this.setMostrarnumero_diarioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setMostrarnumero_retencion_ivaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTE)) {
				this.setMostrarnumero_retencion_fuenteSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTOFORMATO)) {
				this.setMostrarnumero_asiento_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESOFORMATO)) {
				this.setMostrarnumero_ingreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESOFORMATO)) {
				this.setMostrarnumero_egreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIOFORMATO)) {
				this.setMostrarnumero_diario_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO)) {
				this.setMostrarnumero_retencion_fuente_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO)) {
				this.setMostrarnumero_retencion_iva_formatoSecuencial(esAsigna);
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
		
		
		this.setActivaridSecuencial(esInicial);
		this.setActivarid_empresaSecuencial(esInicial);
		this.setActivarid_sucursalSecuencial(esInicial);
		this.setActivarid_ejercicioSecuencial(esInicial);
		this.setActivarid_periodoSecuencial(esInicial);
		this.setActivarid_anioSecuencial(esInicial);
		this.setActivarid_mesSecuencial(esInicial);
		this.setActivarid_moduloSecuencial(esInicial);
		this.setActivarid_tipo_movimiento_moduloSecuencial(esInicial);
		this.setActivarid_tipo_documentoSecuencial(esInicial);
		this.setActivarid_tipo_movimientoSecuencial(esInicial);
		this.setActivarnumero_asientoSecuencial(esInicial);
		this.setActivarnumero_ingresoSecuencial(esInicial);
		this.setActivarnumero_egresoSecuencial(esInicial);
		this.setActivarnumero_diarioSecuencial(esInicial);
		this.setActivarnumero_retencion_ivaSecuencial(esInicial);
		this.setActivarnumero_retencion_fuenteSecuencial(esInicial);
		this.setActivarnumero_asiento_formatoSecuencial(esInicial);
		this.setActivarnumero_ingreso_formatoSecuencial(esInicial);
		this.setActivarnumero_egreso_formatoSecuencial(esInicial);
		this.setActivarnumero_diario_formatoSecuencial(esInicial);
		this.setActivarnumero_retencion_fuente_formatoSecuencial(esInicial);
		this.setActivarnumero_retencion_iva_formatoSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialConstantesFunciones.ID)) {
				this.setActivaridSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDANIO)) {
				this.setActivarid_anioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMES)) {
				this.setActivarid_mesSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTO)) {
				this.setActivarnumero_asientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESO)) {
				this.setActivarnumero_ingresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESO)) {
				this.setActivarnumero_egresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIO)) {
				this.setActivarnumero_diarioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setActivarnumero_retencion_ivaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTE)) {
				this.setActivarnumero_retencion_fuenteSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTOFORMATO)) {
				this.setActivarnumero_asiento_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESOFORMATO)) {
				this.setActivarnumero_ingreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESOFORMATO)) {
				this.setActivarnumero_egreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIOFORMATO)) {
				this.setActivarnumero_diario_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO)) {
				this.setActivarnumero_retencion_fuente_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO)) {
				this.setActivarnumero_retencion_iva_formatoSecuencial(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSecuencial(esInicial);
		this.setResaltarid_empresaSecuencial(esInicial);
		this.setResaltarid_sucursalSecuencial(esInicial);
		this.setResaltarid_ejercicioSecuencial(esInicial);
		this.setResaltarid_periodoSecuencial(esInicial);
		this.setResaltarid_anioSecuencial(esInicial);
		this.setResaltarid_mesSecuencial(esInicial);
		this.setResaltarid_moduloSecuencial(esInicial);
		this.setResaltarid_tipo_movimiento_moduloSecuencial(esInicial);
		this.setResaltarid_tipo_documentoSecuencial(esInicial);
		this.setResaltarid_tipo_movimientoSecuencial(esInicial);
		this.setResaltarnumero_asientoSecuencial(esInicial);
		this.setResaltarnumero_ingresoSecuencial(esInicial);
		this.setResaltarnumero_egresoSecuencial(esInicial);
		this.setResaltarnumero_diarioSecuencial(esInicial);
		this.setResaltarnumero_retencion_ivaSecuencial(esInicial);
		this.setResaltarnumero_retencion_fuenteSecuencial(esInicial);
		this.setResaltarnumero_asiento_formatoSecuencial(esInicial);
		this.setResaltarnumero_ingreso_formatoSecuencial(esInicial);
		this.setResaltarnumero_egreso_formatoSecuencial(esInicial);
		this.setResaltarnumero_diario_formatoSecuencial(esInicial);
		this.setResaltarnumero_retencion_fuente_formatoSecuencial(esInicial);
		this.setResaltarnumero_retencion_iva_formatoSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SecuencialConstantesFunciones.ID)) {
				this.setResaltaridSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMES)) {
				this.setResaltarid_mesSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTO)) {
				this.setResaltarnumero_asientoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESO)) {
				this.setResaltarnumero_ingresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESO)) {
				this.setResaltarnumero_egresoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIO)) {
				this.setResaltarnumero_diarioSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setResaltarnumero_retencion_ivaSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTE)) {
				this.setResaltarnumero_retencion_fuenteSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROASIENTOFORMATO)) {
				this.setResaltarnumero_asiento_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROINGRESOFORMATO)) {
				this.setResaltarnumero_ingreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMEROEGRESOFORMATO)) {
				this.setResaltarnumero_egreso_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERODIARIOFORMATO)) {
				this.setResaltarnumero_diario_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO)) {
				this.setResaltarnumero_retencion_fuente_formatoSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO)) {
				this.setResaltarnumero_retencion_iva_formatoSecuencial(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial=true;

	public Boolean getMostrarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial() {
		return this.mostrarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial;
	}

	public void setMostrarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSecuencial=true;

	public Boolean getMostrarFK_IdEmpresaSecuencial() {
		return this.mostrarFK_IdEmpresaSecuencial;
	}

	public void setMostrarFK_IdEmpresaSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSecuencial=true;

	public Boolean getMostrarFK_IdSucursalSecuencial() {
		return this.mostrarFK_IdSucursalSecuencial;
	}

	public void setMostrarFK_IdSucursalSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSecuencial= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial=true;

	public Boolean getActivarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial() {
		return this.activarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial;
	}

	public void setActivarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial(Boolean habilitarResaltar) {
		this.activarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSecuencial=true;

	public Boolean getActivarFK_IdEmpresaSecuencial() {
		return this.activarFK_IdEmpresaSecuencial;
	}

	public void setActivarFK_IdEmpresaSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSecuencial=true;

	public Boolean getActivarFK_IdSucursalSecuencial() {
		return this.activarFK_IdSucursalSecuencial;
	}

	public void setActivarFK_IdSucursalSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSecuencial= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial=null;

	public Border getResaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial() {
		return this.resaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial;
	}

	public void setResaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial(Border borderResaltar) {
		this.resaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial= borderResaltar;
	}

	public void setResaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorEjercicioPorModuloPorMovimientoSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSecuencial=null;

	public Border getResaltarFK_IdEmpresaSecuencial() {
		return this.resaltarFK_IdEmpresaSecuencial;
	}

	public void setResaltarFK_IdEmpresaSecuencial(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSecuencial=null;

	public Border getResaltarFK_IdSucursalSecuencial() {
		return this.resaltarFK_IdSucursalSecuencial;
	}

	public void setResaltarFK_IdSucursalSecuencial(Border borderResaltar) {
		this.resaltarFK_IdSucursalSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*SecuencialBeanSwingJInternalFrame secuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSecuencial= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
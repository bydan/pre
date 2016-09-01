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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.ComprobantesAnuladosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ComprobantesAnuladosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ComprobantesAnuladosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComprobantesAnuladosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ComprobantesAnulados";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobantesAnulados"+ComprobantesAnuladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobantesAnuladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobantesAnuladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobantesAnuladosConstantesFunciones.SCHEMA+"_"+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobantesAnuladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobantesAnuladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobantesAnuladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobantesAnuladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobantesAnuladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobantesAnuladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobantes Anuladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Comprobantes Anulados";
	public static final String SCLASSWEBTITULO_LOWER="Comprobantes Anulados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobantesAnulados";
	public static final String OBJECTNAME="comprobantesanulados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="comprobantes_anulados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobantesanulados from "+ComprobantesAnuladosConstantesFunciones.SPERSISTENCENAME+" comprobantesanulados";
	public static String QUERYSELECTNATIVE="select "+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".version_row,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_empresa,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_sucursal,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_ejercicio,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_modulo,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_desde,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_hasta,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".tipo_movimiento,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".valor,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".numero_mayor,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".beneficiario,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_emision,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".fecha_finalizacion,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".nombre_usuario,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".detalle,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".numero_cheque,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".nombre_empresa,"+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME+".ruc_empresa from "+ComprobantesAnuladosConstantesFunciones.SCHEMA+"."+ComprobantesAnuladosConstantesFunciones.TABLENAME;//+" as "+ComprobantesAnuladosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String VALOR= "valor";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String FECHA= "fecha";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAFINALIZACION= "fecha_finalizacion";
    public static final String NOMBREUSUARIO= "nombre_usuario";
    public static final String DETALLE= "detalle";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String NOMBREEMPRESA= "nombre_empresa";
    public static final String RUCEMPRESA= "ruc_empresa";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento Base";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAFINALIZACION= "Fecha Finalizacion";
		public static final String LABEL_FECHAFINALIZACION_LOWER= "Fecha Finalizacion";
    	public static final String LABEL_NOMBREUSUARIO= "Nombre Usuario";
		public static final String LABEL_NOMBREUSUARIO_LOWER= "Nombre Usuario";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_RUCEMPRESA= "Ruc Empresa";
		public static final String LABEL_RUCEMPRESA_LOWER= "Ruc Empresa";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNOMBRE_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComprobantesAnuladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDMODULO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHADESDE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAHASTA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.VALOR)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_FECHAFINALIZACION;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREUSUARIO;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ComprobantesAnuladosConstantesFunciones.RUCEMPRESA)) {sLabelColumna=ComprobantesAnuladosConstantesFunciones.LABEL_RUCEMPRESA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobantesAnuladosDescripcion(ComprobantesAnulados comprobantesanulados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobantesanulados !=null/* && comprobantesanulados.getId()!=0*/) {
			if(comprobantesanulados.getId()!=null) {
				sDescripcion=comprobantesanulados.getId().toString();
			}//comprobantesanuladoscomprobantesanulados.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobantesAnuladosDescripcionDetallado(ComprobantesAnulados comprobantesanulados) {
		String sDescripcion="";
			
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.ID+"=";
		sDescripcion+=comprobantesanulados.getId().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobantesanulados.getVersionRow().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobantesanulados.getid_empresa().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=comprobantesanulados.getid_sucursal().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=comprobantesanulados.getid_ejercicio().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDMODULO+"=";
		sDescripcion+=comprobantesanulados.getid_modulo().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=comprobantesanulados.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=comprobantesanulados.getfecha_desde().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=comprobantesanulados.getfecha_hasta().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=comprobantesanulados.gettipo_movimiento()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.VALOR+"=";
		sDescripcion+=comprobantesanulados.getvalor().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=comprobantesanulados.getnumero_mayor()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=comprobantesanulados.getbeneficiario()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHA+"=";
		sDescripcion+=comprobantesanulados.getfecha().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=comprobantesanulados.getfecha_emision().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION+"=";
		sDescripcion+=comprobantesanulados.getfecha_finalizacion().toString()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO+"=";
		sDescripcion+=comprobantesanulados.getnombre_usuario()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.DETALLE+"=";
		sDescripcion+=comprobantesanulados.getdetalle()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=comprobantesanulados.getnumero_cheque()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=comprobantesanulados.getnombre_empresa()+",";
		sDescripcion+=ComprobantesAnuladosConstantesFunciones.RUCEMPRESA+"=";
		sDescripcion+=comprobantesanulados.getruc_empresa()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobantesAnuladosDescripcion(ComprobantesAnulados comprobantesanulados,String sValor) throws Exception {			
		if(comprobantesanulados !=null) {
			//comprobantesanuladoscomprobantesanulados.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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
		} else if(sNombreIndice.equals("BusquedaComprobantesAnulados")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Modulo Por Tipo Movimiento Base Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Base";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaComprobantesAnulados(Long id_ejercicio,Long id_modulo,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComprobantesAnulados(ComprobantesAnulados comprobantesanulados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantesanulados.settipo_movimiento(comprobantesanulados.gettipo_movimiento().trim());
		comprobantesanulados.setnumero_mayor(comprobantesanulados.getnumero_mayor().trim());
		comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
		comprobantesanulados.setnombre_usuario(comprobantesanulados.getnombre_usuario().trim());
		comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
		comprobantesanulados.setnumero_cheque(comprobantesanulados.getnumero_cheque().trim());
		comprobantesanulados.setnombre_empresa(comprobantesanulados.getnombre_empresa().trim());
		comprobantesanulados.setruc_empresa(comprobantesanulados.getruc_empresa().trim());
	}
	
	public static void quitarEspaciosComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			comprobantesanulados.settipo_movimiento(comprobantesanulados.gettipo_movimiento().trim());
			comprobantesanulados.setnumero_mayor(comprobantesanulados.getnumero_mayor().trim());
			comprobantesanulados.setbeneficiario(comprobantesanulados.getbeneficiario().trim());
			comprobantesanulados.setnombre_usuario(comprobantesanulados.getnombre_usuario().trim());
			comprobantesanulados.setdetalle(comprobantesanulados.getdetalle().trim());
			comprobantesanulados.setnumero_cheque(comprobantesanulados.getnumero_cheque().trim());
			comprobantesanulados.setnombre_empresa(comprobantesanulados.getnombre_empresa().trim());
			comprobantesanulados.setruc_empresa(comprobantesanulados.getruc_empresa().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobantesAnulados(ComprobantesAnulados comprobantesanulados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobantesanulados.getConCambioAuxiliar()) {
			comprobantesanulados.setIsDeleted(comprobantesanulados.getIsDeletedAuxiliar());	
			comprobantesanulados.setIsNew(comprobantesanulados.getIsNewAuxiliar());	
			comprobantesanulados.setIsChanged(comprobantesanulados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobantesanulados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobantesanulados.setIsDeletedAuxiliar(false);	
			comprobantesanulados.setIsNewAuxiliar(false);	
			comprobantesanulados.setIsChangedAuxiliar(false);
			
			comprobantesanulados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados : comprobantesanuladoss) {
			if(conAsignarBase && comprobantesanulados.getConCambioAuxiliar()) {
				comprobantesanulados.setIsDeleted(comprobantesanulados.getIsDeletedAuxiliar());	
				comprobantesanulados.setIsNew(comprobantesanulados.getIsNewAuxiliar());	
				comprobantesanulados.setIsChanged(comprobantesanulados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobantesanulados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobantesanulados.setIsDeletedAuxiliar(false);	
				comprobantesanulados.setIsNewAuxiliar(false);	
				comprobantesanulados.setIsChangedAuxiliar(false);
				
				comprobantesanulados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobantesAnulados(ComprobantesAnulados comprobantesanulados,Boolean conEnteros) throws Exception  {
		comprobantesanulados.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComprobantesAnuladoss(List<ComprobantesAnulados> comprobantesanuladoss,Boolean conEnteros) throws Exception  {
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			comprobantesanulados.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnulados comprobantesanuladosAux) throws Exception  {
		ComprobantesAnuladosConstantesFunciones.InicializarValoresComprobantesAnulados(comprobantesanuladosAux,true);
		
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {
			if(comprobantesanulados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobantesanuladosAux.setvalor(comprobantesanuladosAux.getvalor()+comprobantesanulados.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobantesAnuladosConstantesFunciones.getArrayColumnasGlobalesComprobantesAnulados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobantesAnuladosConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobantesAnuladosConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobantesAnulados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobantesAnulados> comprobantesanuladoss,ComprobantesAnulados comprobantesanulados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobantesAnulados comprobantesanuladosAux: comprobantesanuladoss) {
			if(comprobantesanuladosAux!=null && comprobantesanulados!=null) {
				if((comprobantesanuladosAux.getId()==null && comprobantesanulados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobantesanuladosAux.getId()!=null && comprobantesanulados.getId()!=null){
					if(comprobantesanuladosAux.getId().equals(comprobantesanulados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ComprobantesAnulados comprobantesanulados: comprobantesanuladoss) {			
			if(comprobantesanulados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=comprobantesanulados.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobantesAnuladosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobantesAnulados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_ID, ComprobantesAnuladosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_VERSIONROW, ComprobantesAnuladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_TIPOMOVIMIENTO, ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_VALOR, ComprobantesAnuladosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR, ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO, ComprobantesAnuladosConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_FECHA, ComprobantesAnuladosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION, ComprobantesAnuladosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_FECHAFINALIZACION, ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREUSUARIO, ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE, ComprobantesAnuladosConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROCHEQUE, ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREEMPRESA, ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobantesAnuladosConstantesFunciones.LABEL_RUCEMPRESA, ComprobantesAnuladosConstantesFunciones.RUCEMPRESA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobantesAnulados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobantesAnuladosConstantesFunciones.RUCEMPRESA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados() throws Exception  {
		return ComprobantesAnuladosConstantesFunciones.getTiposSeleccionarComprobantesAnulados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados(Boolean conFk) throws Exception  {
		return ComprobantesAnuladosConstantesFunciones.getTiposSeleccionarComprobantesAnulados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobantesAnulados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAFINALIZACION);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAFINALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREUSUARIO);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobantesAnuladosConstantesFunciones.LABEL_RUCEMPRESA);
			reporte.setsDescripcion(ComprobantesAnuladosConstantesFunciones.LABEL_RUCEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobantesAnulados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobantesAnulados(ComprobantesAnulados comprobantesanuladosAux) throws Exception {
		
			comprobantesanuladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantesanuladosAux.getEmpresa()));
			comprobantesanuladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantesanuladosAux.getSucursal()));
			comprobantesanuladosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comprobantesanuladosAux.getEjercicio()));
			comprobantesanuladosAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(comprobantesanuladosAux.getModulo()));
			comprobantesanuladosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(comprobantesanuladosAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladossTemp) throws Exception {
		for(ComprobantesAnulados comprobantesanuladosAux:comprobantesanuladossTemp) {
			
			comprobantesanuladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantesanuladosAux.getEmpresa()));
			comprobantesanuladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantesanuladosAux.getSucursal()));
			comprobantesanuladosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comprobantesanuladosAux.getEjercicio()));
			comprobantesanuladosAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(comprobantesanuladosAux.getModulo()));
			comprobantesanuladosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(comprobantesanuladosAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobantesAnuladosConstantesFunciones.getClassesRelationshipsOfComprobantesAnulados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobantesAnulados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobantesAnuladosConstantesFunciones.getClassesRelationshipsFromStringsOfComprobantesAnulados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobantesAnulados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobantesAnulados comprobantesanulados,List<ComprobantesAnulados> comprobantesanuladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobantesAnulados comprobantesanulados,List<ComprobantesAnulados> comprobantesanuladoss) throws Exception {
		try	{			
			for(ComprobantesAnulados comprobantesanuladosLocal:comprobantesanuladoss) {
				if(comprobantesanuladosLocal.getId().equals(comprobantesanulados.getId())) {
					comprobantesanuladosLocal.setIsSelected(comprobantesanulados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobantesAnulados(List<ComprobantesAnulados> comprobantesanuladossAux) throws Exception {
		//this.comprobantesanuladossAux=comprobantesanuladossAux;
		
		for(ComprobantesAnulados comprobantesanuladosAux:comprobantesanuladossAux) {
			if(comprobantesanuladosAux.getIsChanged()) {
				comprobantesanuladosAux.setIsChanged(false);
			}		
			
			if(comprobantesanuladosAux.getIsNew()) {
				comprobantesanuladosAux.setIsNew(false);
			}	
			
			if(comprobantesanuladosAux.getIsDeleted()) {
				comprobantesanuladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobantesAnulados(ComprobantesAnulados comprobantesanuladosAux) throws Exception {
		//this.comprobantesanuladosAux=comprobantesanuladosAux;
		
			if(comprobantesanuladosAux.getIsChanged()) {
				comprobantesanuladosAux.setIsChanged(false);
			}		
			
			if(comprobantesanuladosAux.getIsNew()) {
				comprobantesanuladosAux.setIsNew(false);
			}	
			
			if(comprobantesanuladosAux.getIsDeleted()) {
				comprobantesanuladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobantesAnulados comprobantesanuladosAsignar,ComprobantesAnulados comprobantesanulados) throws Exception {
		comprobantesanuladosAsignar.setId(comprobantesanulados.getId());	
		comprobantesanuladosAsignar.setVersionRow(comprobantesanulados.getVersionRow());	
		comprobantesanuladosAsignar.settipo_movimiento(comprobantesanulados.gettipo_movimiento());	
		comprobantesanuladosAsignar.setvalor(comprobantesanulados.getvalor());	
		comprobantesanuladosAsignar.setnumero_mayor(comprobantesanulados.getnumero_mayor());	
		comprobantesanuladosAsignar.setbeneficiario(comprobantesanulados.getbeneficiario());	
		comprobantesanuladosAsignar.setfecha(comprobantesanulados.getfecha());	
		comprobantesanuladosAsignar.setfecha_emision(comprobantesanulados.getfecha_emision());	
		comprobantesanuladosAsignar.setfecha_finalizacion(comprobantesanulados.getfecha_finalizacion());	
		comprobantesanuladosAsignar.setnombre_usuario(comprobantesanulados.getnombre_usuario());	
		comprobantesanuladosAsignar.setdetalle(comprobantesanulados.getdetalle());	
		comprobantesanuladosAsignar.setnumero_cheque(comprobantesanulados.getnumero_cheque());	
		comprobantesanuladosAsignar.setnombre_empresa(comprobantesanulados.getnombre_empresa());	
		comprobantesanuladosAsignar.setruc_empresa(comprobantesanulados.getruc_empresa());	
	}
	
	public static void inicializarComprobantesAnulados(ComprobantesAnulados comprobantesanulados) throws Exception {
		try {
				comprobantesanulados.setId(0L);	
					
				comprobantesanulados.settipo_movimiento("");	
				comprobantesanulados.setvalor(0.0);	
				comprobantesanulados.setnumero_mayor("");	
				comprobantesanulados.setbeneficiario("");	
				comprobantesanulados.setfecha(new Date());	
				comprobantesanulados.setfecha_emision(new Date());	
				comprobantesanulados.setfecha_finalizacion(new Date());	
				comprobantesanulados.setnombre_usuario("");	
				comprobantesanulados.setdetalle("");	
				comprobantesanulados.setnumero_cheque("");	
				comprobantesanulados.setnombre_empresa("");	
				comprobantesanulados.setruc_empresa("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobantesAnulados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_FECHAFINALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobantesAnuladosConstantesFunciones.LABEL_RUCEMPRESA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobantesAnulados(String sTipo,Row row,Workbook workbook,ComprobantesAnulados comprobantesanulados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getfecha_finalizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnombre_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getnombre_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantesanulados.getruc_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobantesAnulados="";
	
	public String getsFinalQueryComprobantesAnulados() {
		return this.sFinalQueryComprobantesAnulados;
	}
	
	public void setsFinalQueryComprobantesAnulados(String sFinalQueryComprobantesAnulados) {
		this.sFinalQueryComprobantesAnulados= sFinalQueryComprobantesAnulados;
	}
	
	public Border resaltarSeleccionarComprobantesAnulados=null;
	
	public Border setResaltarSeleccionarComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobantesAnulados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobantesAnulados() {
		return this.resaltarSeleccionarComprobantesAnulados;
	}
	
	public void setResaltarSeleccionarComprobantesAnulados(Border borderResaltarSeleccionarComprobantesAnulados) {
		this.resaltarSeleccionarComprobantesAnulados= borderResaltarSeleccionarComprobantesAnulados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobantesAnulados=null;
	public Boolean mostraridComprobantesAnulados=true;
	public Boolean activaridComprobantesAnulados=true;

	public Border resaltarid_empresaComprobantesAnulados=null;
	public Boolean mostrarid_empresaComprobantesAnulados=true;
	public Boolean activarid_empresaComprobantesAnulados=true;
	public Boolean cargarid_empresaComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_sucursalComprobantesAnulados=null;
	public Boolean mostrarid_sucursalComprobantesAnulados=true;
	public Boolean activarid_sucursalComprobantesAnulados=true;
	public Boolean cargarid_sucursalComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_ejercicioComprobantesAnulados=null;
	public Boolean mostrarid_ejercicioComprobantesAnulados=true;
	public Boolean activarid_ejercicioComprobantesAnulados=true;
	public Boolean cargarid_ejercicioComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_moduloComprobantesAnulados=null;
	public Boolean mostrarid_moduloComprobantesAnulados=true;
	public Boolean activarid_moduloComprobantesAnulados=true;
	public Boolean cargarid_moduloComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoComprobantesAnulados=null;
	public Boolean mostrarid_tipo_movimientoComprobantesAnulados=true;
	public Boolean activarid_tipo_movimientoComprobantesAnulados=true;
	public Boolean cargarid_tipo_movimientoComprobantesAnulados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoComprobantesAnulados=false;//ConEventDepend=true

	public Border resaltarfecha_desdeComprobantesAnulados=null;
	public Boolean mostrarfecha_desdeComprobantesAnulados=true;
	public Boolean activarfecha_desdeComprobantesAnulados=true;

	public Border resaltarfecha_hastaComprobantesAnulados=null;
	public Boolean mostrarfecha_hastaComprobantesAnulados=true;
	public Boolean activarfecha_hastaComprobantesAnulados=true;

	public Border resaltartipo_movimientoComprobantesAnulados=null;
	public Boolean mostrartipo_movimientoComprobantesAnulados=true;
	public Boolean activartipo_movimientoComprobantesAnulados=true;

	public Border resaltarvalorComprobantesAnulados=null;
	public Boolean mostrarvalorComprobantesAnulados=true;
	public Boolean activarvalorComprobantesAnulados=true;

	public Border resaltarnumero_mayorComprobantesAnulados=null;
	public Boolean mostrarnumero_mayorComprobantesAnulados=true;
	public Boolean activarnumero_mayorComprobantesAnulados=true;

	public Border resaltarbeneficiarioComprobantesAnulados=null;
	public Boolean mostrarbeneficiarioComprobantesAnulados=true;
	public Boolean activarbeneficiarioComprobantesAnulados=true;

	public Border resaltarfechaComprobantesAnulados=null;
	public Boolean mostrarfechaComprobantesAnulados=true;
	public Boolean activarfechaComprobantesAnulados=true;

	public Border resaltarfecha_emisionComprobantesAnulados=null;
	public Boolean mostrarfecha_emisionComprobantesAnulados=true;
	public Boolean activarfecha_emisionComprobantesAnulados=true;

	public Border resaltarfecha_finalizacionComprobantesAnulados=null;
	public Boolean mostrarfecha_finalizacionComprobantesAnulados=true;
	public Boolean activarfecha_finalizacionComprobantesAnulados=true;

	public Border resaltarnombre_usuarioComprobantesAnulados=null;
	public Boolean mostrarnombre_usuarioComprobantesAnulados=true;
	public Boolean activarnombre_usuarioComprobantesAnulados=true;

	public Border resaltardetalleComprobantesAnulados=null;
	public Boolean mostrardetalleComprobantesAnulados=true;
	public Boolean activardetalleComprobantesAnulados=true;

	public Border resaltarnumero_chequeComprobantesAnulados=null;
	public Boolean mostrarnumero_chequeComprobantesAnulados=true;
	public Boolean activarnumero_chequeComprobantesAnulados=true;

	public Border resaltarnombre_empresaComprobantesAnulados=null;
	public Boolean mostrarnombre_empresaComprobantesAnulados=true;
	public Boolean activarnombre_empresaComprobantesAnulados=true;

	public Border resaltarruc_empresaComprobantesAnulados=null;
	public Boolean mostrarruc_empresaComprobantesAnulados=true;
	public Boolean activarruc_empresaComprobantesAnulados=true;

	
	

	public Border setResaltaridComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltaridComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobantesAnulados() {
		return this.resaltaridComprobantesAnulados;
	}

	public void setResaltaridComprobantesAnulados(Border borderResaltar) {
		this.resaltaridComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostraridComprobantesAnulados() {
		return this.mostraridComprobantesAnulados;
	}

	public void setMostraridComprobantesAnulados(Boolean mostraridComprobantesAnulados) {
		this.mostraridComprobantesAnulados= mostraridComprobantesAnulados;
	}

	public Boolean getActivaridComprobantesAnulados() {
		return this.activaridComprobantesAnulados;
	}

	public void setActivaridComprobantesAnulados(Boolean activaridComprobantesAnulados) {
		this.activaridComprobantesAnulados= activaridComprobantesAnulados;
	}

	public Border setResaltarid_empresaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobantesAnulados() {
		return this.resaltarid_empresaComprobantesAnulados;
	}

	public void setResaltarid_empresaComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_empresaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobantesAnulados() {
		return this.mostrarid_empresaComprobantesAnulados;
	}

	public void setMostrarid_empresaComprobantesAnulados(Boolean mostrarid_empresaComprobantesAnulados) {
		this.mostrarid_empresaComprobantesAnulados= mostrarid_empresaComprobantesAnulados;
	}

	public Boolean getActivarid_empresaComprobantesAnulados() {
		return this.activarid_empresaComprobantesAnulados;
	}

	public void setActivarid_empresaComprobantesAnulados(Boolean activarid_empresaComprobantesAnulados) {
		this.activarid_empresaComprobantesAnulados= activarid_empresaComprobantesAnulados;
	}

	public Boolean getCargarid_empresaComprobantesAnulados() {
		return this.cargarid_empresaComprobantesAnulados;
	}

	public void setCargarid_empresaComprobantesAnulados(Boolean cargarid_empresaComprobantesAnulados) {
		this.cargarid_empresaComprobantesAnulados= cargarid_empresaComprobantesAnulados;
	}

	public Border setResaltarid_sucursalComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_sucursalComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalComprobantesAnulados() {
		return this.resaltarid_sucursalComprobantesAnulados;
	}

	public void setResaltarid_sucursalComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_sucursalComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_sucursalComprobantesAnulados() {
		return this.mostrarid_sucursalComprobantesAnulados;
	}

	public void setMostrarid_sucursalComprobantesAnulados(Boolean mostrarid_sucursalComprobantesAnulados) {
		this.mostrarid_sucursalComprobantesAnulados= mostrarid_sucursalComprobantesAnulados;
	}

	public Boolean getActivarid_sucursalComprobantesAnulados() {
		return this.activarid_sucursalComprobantesAnulados;
	}

	public void setActivarid_sucursalComprobantesAnulados(Boolean activarid_sucursalComprobantesAnulados) {
		this.activarid_sucursalComprobantesAnulados= activarid_sucursalComprobantesAnulados;
	}

	public Boolean getCargarid_sucursalComprobantesAnulados() {
		return this.cargarid_sucursalComprobantesAnulados;
	}

	public void setCargarid_sucursalComprobantesAnulados(Boolean cargarid_sucursalComprobantesAnulados) {
		this.cargarid_sucursalComprobantesAnulados= cargarid_sucursalComprobantesAnulados;
	}

	public Border setResaltarid_ejercicioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioComprobantesAnulados() {
		return this.resaltarid_ejercicioComprobantesAnulados;
	}

	public void setResaltarid_ejercicioComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_ejercicioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioComprobantesAnulados() {
		return this.mostrarid_ejercicioComprobantesAnulados;
	}

	public void setMostrarid_ejercicioComprobantesAnulados(Boolean mostrarid_ejercicioComprobantesAnulados) {
		this.mostrarid_ejercicioComprobantesAnulados= mostrarid_ejercicioComprobantesAnulados;
	}

	public Boolean getActivarid_ejercicioComprobantesAnulados() {
		return this.activarid_ejercicioComprobantesAnulados;
	}

	public void setActivarid_ejercicioComprobantesAnulados(Boolean activarid_ejercicioComprobantesAnulados) {
		this.activarid_ejercicioComprobantesAnulados= activarid_ejercicioComprobantesAnulados;
	}

	public Boolean getCargarid_ejercicioComprobantesAnulados() {
		return this.cargarid_ejercicioComprobantesAnulados;
	}

	public void setCargarid_ejercicioComprobantesAnulados(Boolean cargarid_ejercicioComprobantesAnulados) {
		this.cargarid_ejercicioComprobantesAnulados= cargarid_ejercicioComprobantesAnulados;
	}

	public Border setResaltarid_moduloComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_moduloComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloComprobantesAnulados() {
		return this.resaltarid_moduloComprobantesAnulados;
	}

	public void setResaltarid_moduloComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_moduloComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_moduloComprobantesAnulados() {
		return this.mostrarid_moduloComprobantesAnulados;
	}

	public void setMostrarid_moduloComprobantesAnulados(Boolean mostrarid_moduloComprobantesAnulados) {
		this.mostrarid_moduloComprobantesAnulados= mostrarid_moduloComprobantesAnulados;
	}

	public Boolean getActivarid_moduloComprobantesAnulados() {
		return this.activarid_moduloComprobantesAnulados;
	}

	public void setActivarid_moduloComprobantesAnulados(Boolean activarid_moduloComprobantesAnulados) {
		this.activarid_moduloComprobantesAnulados= activarid_moduloComprobantesAnulados;
	}

	public Boolean getCargarid_moduloComprobantesAnulados() {
		return this.cargarid_moduloComprobantesAnulados;
	}

	public void setCargarid_moduloComprobantesAnulados(Boolean cargarid_moduloComprobantesAnulados) {
		this.cargarid_moduloComprobantesAnulados= cargarid_moduloComprobantesAnulados;
	}

	public Border setResaltarid_tipo_movimientoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoComprobantesAnulados() {
		return this.resaltarid_tipo_movimientoComprobantesAnulados;
	}

	public void setResaltarid_tipo_movimientoComprobantesAnulados(Border borderResaltar) {
		this.resaltarid_tipo_movimientoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoComprobantesAnulados() {
		return this.mostrarid_tipo_movimientoComprobantesAnulados;
	}

	public void setMostrarid_tipo_movimientoComprobantesAnulados(Boolean mostrarid_tipo_movimientoComprobantesAnulados) {
		this.mostrarid_tipo_movimientoComprobantesAnulados= mostrarid_tipo_movimientoComprobantesAnulados;
	}

	public Boolean getActivarid_tipo_movimientoComprobantesAnulados() {
		return this.activarid_tipo_movimientoComprobantesAnulados;
	}

	public void setActivarid_tipo_movimientoComprobantesAnulados(Boolean activarid_tipo_movimientoComprobantesAnulados) {
		this.activarid_tipo_movimientoComprobantesAnulados= activarid_tipo_movimientoComprobantesAnulados;
	}

	public Boolean getCargarid_tipo_movimientoComprobantesAnulados() {
		return this.cargarid_tipo_movimientoComprobantesAnulados;
	}

	public void setCargarid_tipo_movimientoComprobantesAnulados(Boolean cargarid_tipo_movimientoComprobantesAnulados) {
		this.cargarid_tipo_movimientoComprobantesAnulados= cargarid_tipo_movimientoComprobantesAnulados;
	}

	public Border setResaltarfecha_desdeComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeComprobantesAnulados() {
		return this.resaltarfecha_desdeComprobantesAnulados;
	}

	public void setResaltarfecha_desdeComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_desdeComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeComprobantesAnulados() {
		return this.mostrarfecha_desdeComprobantesAnulados;
	}

	public void setMostrarfecha_desdeComprobantesAnulados(Boolean mostrarfecha_desdeComprobantesAnulados) {
		this.mostrarfecha_desdeComprobantesAnulados= mostrarfecha_desdeComprobantesAnulados;
	}

	public Boolean getActivarfecha_desdeComprobantesAnulados() {
		return this.activarfecha_desdeComprobantesAnulados;
	}

	public void setActivarfecha_desdeComprobantesAnulados(Boolean activarfecha_desdeComprobantesAnulados) {
		this.activarfecha_desdeComprobantesAnulados= activarfecha_desdeComprobantesAnulados;
	}

	public Border setResaltarfecha_hastaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaComprobantesAnulados() {
		return this.resaltarfecha_hastaComprobantesAnulados;
	}

	public void setResaltarfecha_hastaComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_hastaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaComprobantesAnulados() {
		return this.mostrarfecha_hastaComprobantesAnulados;
	}

	public void setMostrarfecha_hastaComprobantesAnulados(Boolean mostrarfecha_hastaComprobantesAnulados) {
		this.mostrarfecha_hastaComprobantesAnulados= mostrarfecha_hastaComprobantesAnulados;
	}

	public Boolean getActivarfecha_hastaComprobantesAnulados() {
		return this.activarfecha_hastaComprobantesAnulados;
	}

	public void setActivarfecha_hastaComprobantesAnulados(Boolean activarfecha_hastaComprobantesAnulados) {
		this.activarfecha_hastaComprobantesAnulados= activarfecha_hastaComprobantesAnulados;
	}

	public Border setResaltartipo_movimientoComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoComprobantesAnulados() {
		return this.resaltartipo_movimientoComprobantesAnulados;
	}

	public void setResaltartipo_movimientoComprobantesAnulados(Border borderResaltar) {
		this.resaltartipo_movimientoComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoComprobantesAnulados() {
		return this.mostrartipo_movimientoComprobantesAnulados;
	}

	public void setMostrartipo_movimientoComprobantesAnulados(Boolean mostrartipo_movimientoComprobantesAnulados) {
		this.mostrartipo_movimientoComprobantesAnulados= mostrartipo_movimientoComprobantesAnulados;
	}

	public Boolean getActivartipo_movimientoComprobantesAnulados() {
		return this.activartipo_movimientoComprobantesAnulados;
	}

	public void setActivartipo_movimientoComprobantesAnulados(Boolean activartipo_movimientoComprobantesAnulados) {
		this.activartipo_movimientoComprobantesAnulados= activartipo_movimientoComprobantesAnulados;
	}

	public Border setResaltarvalorComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarvalorComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorComprobantesAnulados() {
		return this.resaltarvalorComprobantesAnulados;
	}

	public void setResaltarvalorComprobantesAnulados(Border borderResaltar) {
		this.resaltarvalorComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarvalorComprobantesAnulados() {
		return this.mostrarvalorComprobantesAnulados;
	}

	public void setMostrarvalorComprobantesAnulados(Boolean mostrarvalorComprobantesAnulados) {
		this.mostrarvalorComprobantesAnulados= mostrarvalorComprobantesAnulados;
	}

	public Boolean getActivarvalorComprobantesAnulados() {
		return this.activarvalorComprobantesAnulados;
	}

	public void setActivarvalorComprobantesAnulados(Boolean activarvalorComprobantesAnulados) {
		this.activarvalorComprobantesAnulados= activarvalorComprobantesAnulados;
	}

	public Border setResaltarnumero_mayorComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorComprobantesAnulados() {
		return this.resaltarnumero_mayorComprobantesAnulados;
	}

	public void setResaltarnumero_mayorComprobantesAnulados(Border borderResaltar) {
		this.resaltarnumero_mayorComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorComprobantesAnulados() {
		return this.mostrarnumero_mayorComprobantesAnulados;
	}

	public void setMostrarnumero_mayorComprobantesAnulados(Boolean mostrarnumero_mayorComprobantesAnulados) {
		this.mostrarnumero_mayorComprobantesAnulados= mostrarnumero_mayorComprobantesAnulados;
	}

	public Boolean getActivarnumero_mayorComprobantesAnulados() {
		return this.activarnumero_mayorComprobantesAnulados;
	}

	public void setActivarnumero_mayorComprobantesAnulados(Boolean activarnumero_mayorComprobantesAnulados) {
		this.activarnumero_mayorComprobantesAnulados= activarnumero_mayorComprobantesAnulados;
	}

	public Border setResaltarbeneficiarioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioComprobantesAnulados() {
		return this.resaltarbeneficiarioComprobantesAnulados;
	}

	public void setResaltarbeneficiarioComprobantesAnulados(Border borderResaltar) {
		this.resaltarbeneficiarioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioComprobantesAnulados() {
		return this.mostrarbeneficiarioComprobantesAnulados;
	}

	public void setMostrarbeneficiarioComprobantesAnulados(Boolean mostrarbeneficiarioComprobantesAnulados) {
		this.mostrarbeneficiarioComprobantesAnulados= mostrarbeneficiarioComprobantesAnulados;
	}

	public Boolean getActivarbeneficiarioComprobantesAnulados() {
		return this.activarbeneficiarioComprobantesAnulados;
	}

	public void setActivarbeneficiarioComprobantesAnulados(Boolean activarbeneficiarioComprobantesAnulados) {
		this.activarbeneficiarioComprobantesAnulados= activarbeneficiarioComprobantesAnulados;
	}

	public Border setResaltarfechaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfechaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaComprobantesAnulados() {
		return this.resaltarfechaComprobantesAnulados;
	}

	public void setResaltarfechaComprobantesAnulados(Border borderResaltar) {
		this.resaltarfechaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfechaComprobantesAnulados() {
		return this.mostrarfechaComprobantesAnulados;
	}

	public void setMostrarfechaComprobantesAnulados(Boolean mostrarfechaComprobantesAnulados) {
		this.mostrarfechaComprobantesAnulados= mostrarfechaComprobantesAnulados;
	}

	public Boolean getActivarfechaComprobantesAnulados() {
		return this.activarfechaComprobantesAnulados;
	}

	public void setActivarfechaComprobantesAnulados(Boolean activarfechaComprobantesAnulados) {
		this.activarfechaComprobantesAnulados= activarfechaComprobantesAnulados;
	}

	public Border setResaltarfecha_emisionComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionComprobantesAnulados() {
		return this.resaltarfecha_emisionComprobantesAnulados;
	}

	public void setResaltarfecha_emisionComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_emisionComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionComprobantesAnulados() {
		return this.mostrarfecha_emisionComprobantesAnulados;
	}

	public void setMostrarfecha_emisionComprobantesAnulados(Boolean mostrarfecha_emisionComprobantesAnulados) {
		this.mostrarfecha_emisionComprobantesAnulados= mostrarfecha_emisionComprobantesAnulados;
	}

	public Boolean getActivarfecha_emisionComprobantesAnulados() {
		return this.activarfecha_emisionComprobantesAnulados;
	}

	public void setActivarfecha_emisionComprobantesAnulados(Boolean activarfecha_emisionComprobantesAnulados) {
		this.activarfecha_emisionComprobantesAnulados= activarfecha_emisionComprobantesAnulados;
	}

	public Border setResaltarfecha_finalizacionComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarfecha_finalizacionComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalizacionComprobantesAnulados() {
		return this.resaltarfecha_finalizacionComprobantesAnulados;
	}

	public void setResaltarfecha_finalizacionComprobantesAnulados(Border borderResaltar) {
		this.resaltarfecha_finalizacionComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarfecha_finalizacionComprobantesAnulados() {
		return this.mostrarfecha_finalizacionComprobantesAnulados;
	}

	public void setMostrarfecha_finalizacionComprobantesAnulados(Boolean mostrarfecha_finalizacionComprobantesAnulados) {
		this.mostrarfecha_finalizacionComprobantesAnulados= mostrarfecha_finalizacionComprobantesAnulados;
	}

	public Boolean getActivarfecha_finalizacionComprobantesAnulados() {
		return this.activarfecha_finalizacionComprobantesAnulados;
	}

	public void setActivarfecha_finalizacionComprobantesAnulados(Boolean activarfecha_finalizacionComprobantesAnulados) {
		this.activarfecha_finalizacionComprobantesAnulados= activarfecha_finalizacionComprobantesAnulados;
	}

	public Border setResaltarnombre_usuarioComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnombre_usuarioComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_usuarioComprobantesAnulados() {
		return this.resaltarnombre_usuarioComprobantesAnulados;
	}

	public void setResaltarnombre_usuarioComprobantesAnulados(Border borderResaltar) {
		this.resaltarnombre_usuarioComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnombre_usuarioComprobantesAnulados() {
		return this.mostrarnombre_usuarioComprobantesAnulados;
	}

	public void setMostrarnombre_usuarioComprobantesAnulados(Boolean mostrarnombre_usuarioComprobantesAnulados) {
		this.mostrarnombre_usuarioComprobantesAnulados= mostrarnombre_usuarioComprobantesAnulados;
	}

	public Boolean getActivarnombre_usuarioComprobantesAnulados() {
		return this.activarnombre_usuarioComprobantesAnulados;
	}

	public void setActivarnombre_usuarioComprobantesAnulados(Boolean activarnombre_usuarioComprobantesAnulados) {
		this.activarnombre_usuarioComprobantesAnulados= activarnombre_usuarioComprobantesAnulados;
	}

	public Border setResaltardetalleComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltardetalleComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleComprobantesAnulados() {
		return this.resaltardetalleComprobantesAnulados;
	}

	public void setResaltardetalleComprobantesAnulados(Border borderResaltar) {
		this.resaltardetalleComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrardetalleComprobantesAnulados() {
		return this.mostrardetalleComprobantesAnulados;
	}

	public void setMostrardetalleComprobantesAnulados(Boolean mostrardetalleComprobantesAnulados) {
		this.mostrardetalleComprobantesAnulados= mostrardetalleComprobantesAnulados;
	}

	public Boolean getActivardetalleComprobantesAnulados() {
		return this.activardetalleComprobantesAnulados;
	}

	public void setActivardetalleComprobantesAnulados(Boolean activardetalleComprobantesAnulados) {
		this.activardetalleComprobantesAnulados= activardetalleComprobantesAnulados;
	}

	public Border setResaltarnumero_chequeComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeComprobantesAnulados() {
		return this.resaltarnumero_chequeComprobantesAnulados;
	}

	public void setResaltarnumero_chequeComprobantesAnulados(Border borderResaltar) {
		this.resaltarnumero_chequeComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeComprobantesAnulados() {
		return this.mostrarnumero_chequeComprobantesAnulados;
	}

	public void setMostrarnumero_chequeComprobantesAnulados(Boolean mostrarnumero_chequeComprobantesAnulados) {
		this.mostrarnumero_chequeComprobantesAnulados= mostrarnumero_chequeComprobantesAnulados;
	}

	public Boolean getActivarnumero_chequeComprobantesAnulados() {
		return this.activarnumero_chequeComprobantesAnulados;
	}

	public void setActivarnumero_chequeComprobantesAnulados(Boolean activarnumero_chequeComprobantesAnulados) {
		this.activarnumero_chequeComprobantesAnulados= activarnumero_chequeComprobantesAnulados;
	}

	public Border setResaltarnombre_empresaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarnombre_empresaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empresaComprobantesAnulados() {
		return this.resaltarnombre_empresaComprobantesAnulados;
	}

	public void setResaltarnombre_empresaComprobantesAnulados(Border borderResaltar) {
		this.resaltarnombre_empresaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarnombre_empresaComprobantesAnulados() {
		return this.mostrarnombre_empresaComprobantesAnulados;
	}

	public void setMostrarnombre_empresaComprobantesAnulados(Boolean mostrarnombre_empresaComprobantesAnulados) {
		this.mostrarnombre_empresaComprobantesAnulados= mostrarnombre_empresaComprobantesAnulados;
	}

	public Boolean getActivarnombre_empresaComprobantesAnulados() {
		return this.activarnombre_empresaComprobantesAnulados;
	}

	public void setActivarnombre_empresaComprobantesAnulados(Boolean activarnombre_empresaComprobantesAnulados) {
		this.activarnombre_empresaComprobantesAnulados= activarnombre_empresaComprobantesAnulados;
	}

	public Border setResaltarruc_empresaComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantesanuladosBeanSwingJInternalFrame.jTtoolBarComprobantesAnulados.setBorder(borderResaltar);
		
		this.resaltarruc_empresaComprobantesAnulados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_empresaComprobantesAnulados() {
		return this.resaltarruc_empresaComprobantesAnulados;
	}

	public void setResaltarruc_empresaComprobantesAnulados(Border borderResaltar) {
		this.resaltarruc_empresaComprobantesAnulados= borderResaltar;
	}

	public Boolean getMostrarruc_empresaComprobantesAnulados() {
		return this.mostrarruc_empresaComprobantesAnulados;
	}

	public void setMostrarruc_empresaComprobantesAnulados(Boolean mostrarruc_empresaComprobantesAnulados) {
		this.mostrarruc_empresaComprobantesAnulados= mostrarruc_empresaComprobantesAnulados;
	}

	public Boolean getActivarruc_empresaComprobantesAnulados() {
		return this.activarruc_empresaComprobantesAnulados;
	}

	public void setActivarruc_empresaComprobantesAnulados(Boolean activarruc_empresaComprobantesAnulados) {
		this.activarruc_empresaComprobantesAnulados= activarruc_empresaComprobantesAnulados;
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
		
		
		this.setMostraridComprobantesAnulados(esInicial);
		this.setMostrarid_empresaComprobantesAnulados(esInicial);
		this.setMostrarid_sucursalComprobantesAnulados(esInicial);
		this.setMostrarid_ejercicioComprobantesAnulados(esInicial);
		this.setMostrarid_moduloComprobantesAnulados(esInicial);
		this.setMostrarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setMostrarfecha_desdeComprobantesAnulados(esInicial);
		this.setMostrarfecha_hastaComprobantesAnulados(esInicial);
		this.setMostrartipo_movimientoComprobantesAnulados(esInicial);
		this.setMostrarvalorComprobantesAnulados(esInicial);
		this.setMostrarnumero_mayorComprobantesAnulados(esInicial);
		this.setMostrarbeneficiarioComprobantesAnulados(esInicial);
		this.setMostrarfechaComprobantesAnulados(esInicial);
		this.setMostrarfecha_emisionComprobantesAnulados(esInicial);
		this.setMostrarfecha_finalizacionComprobantesAnulados(esInicial);
		this.setMostrarnombre_usuarioComprobantesAnulados(esInicial);
		this.setMostrardetalleComprobantesAnulados(esInicial);
		this.setMostrarnumero_chequeComprobantesAnulados(esInicial);
		this.setMostrarnombre_empresaComprobantesAnulados(esInicial);
		this.setMostrarruc_empresaComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setMostraridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.VALOR)) {
				this.setMostrarvalorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHA)) {
				this.setMostrarfechaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION)) {
				this.setMostrarfecha_finalizacionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO)) {
				this.setMostrarnombre_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setMostrardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombre_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.RUCEMPRESA)) {
				this.setMostrarruc_empresaComprobantesAnulados(esAsigna);
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
		
		
		this.setActivaridComprobantesAnulados(esInicial);
		this.setActivarid_empresaComprobantesAnulados(esInicial);
		this.setActivarid_sucursalComprobantesAnulados(esInicial);
		this.setActivarid_ejercicioComprobantesAnulados(esInicial);
		this.setActivarid_moduloComprobantesAnulados(esInicial);
		this.setActivarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setActivarfecha_desdeComprobantesAnulados(esInicial);
		this.setActivarfecha_hastaComprobantesAnulados(esInicial);
		this.setActivartipo_movimientoComprobantesAnulados(esInicial);
		this.setActivarvalorComprobantesAnulados(esInicial);
		this.setActivarnumero_mayorComprobantesAnulados(esInicial);
		this.setActivarbeneficiarioComprobantesAnulados(esInicial);
		this.setActivarfechaComprobantesAnulados(esInicial);
		this.setActivarfecha_emisionComprobantesAnulados(esInicial);
		this.setActivarfecha_finalizacionComprobantesAnulados(esInicial);
		this.setActivarnombre_usuarioComprobantesAnulados(esInicial);
		this.setActivardetalleComprobantesAnulados(esInicial);
		this.setActivarnumero_chequeComprobantesAnulados(esInicial);
		this.setActivarnombre_empresaComprobantesAnulados(esInicial);
		this.setActivarruc_empresaComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setActivaridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.VALOR)) {
				this.setActivarvalorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHA)) {
				this.setActivarfechaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION)) {
				this.setActivarfecha_finalizacionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO)) {
				this.setActivarnombre_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setActivardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombre_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.RUCEMPRESA)) {
				this.setActivarruc_empresaComprobantesAnulados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobantesAnulados(esInicial);
		this.setResaltarid_empresaComprobantesAnulados(esInicial);
		this.setResaltarid_sucursalComprobantesAnulados(esInicial);
		this.setResaltarid_ejercicioComprobantesAnulados(esInicial);
		this.setResaltarid_moduloComprobantesAnulados(esInicial);
		this.setResaltarid_tipo_movimientoComprobantesAnulados(esInicial);
		this.setResaltarfecha_desdeComprobantesAnulados(esInicial);
		this.setResaltarfecha_hastaComprobantesAnulados(esInicial);
		this.setResaltartipo_movimientoComprobantesAnulados(esInicial);
		this.setResaltarvalorComprobantesAnulados(esInicial);
		this.setResaltarnumero_mayorComprobantesAnulados(esInicial);
		this.setResaltarbeneficiarioComprobantesAnulados(esInicial);
		this.setResaltarfechaComprobantesAnulados(esInicial);
		this.setResaltarfecha_emisionComprobantesAnulados(esInicial);
		this.setResaltarfecha_finalizacionComprobantesAnulados(esInicial);
		this.setResaltarnombre_usuarioComprobantesAnulados(esInicial);
		this.setResaltardetalleComprobantesAnulados(esInicial);
		this.setResaltarnumero_chequeComprobantesAnulados(esInicial);
		this.setResaltarnombre_empresaComprobantesAnulados(esInicial);
		this.setResaltarruc_empresaComprobantesAnulados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.ID)) {
				this.setResaltaridComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.VALOR)) {
				this.setResaltarvalorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHA)) {
				this.setResaltarfechaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.FECHAFINALIZACION)) {
				this.setResaltarfecha_finalizacionComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREUSUARIO)) {
				this.setResaltarnombre_usuarioComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.DETALLE)) {
				this.setResaltardetalleComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombre_empresaComprobantesAnulados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobantesAnuladosConstantesFunciones.RUCEMPRESA)) {
				this.setResaltarruc_empresaComprobantesAnulados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobantesAnuladosComprobantesAnulados=true;

	public Boolean getMostrarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.mostrarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setMostrarBusquedaComprobantesAnuladosComprobantesAnulados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobantesAnuladosComprobantesAnulados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobantesAnuladosComprobantesAnulados=true;

	public Boolean getActivarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.activarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setActivarBusquedaComprobantesAnuladosComprobantesAnulados(Boolean habilitarResaltar) {
		this.activarBusquedaComprobantesAnuladosComprobantesAnulados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobantesAnuladosComprobantesAnulados=null;

	public Border getResaltarBusquedaComprobantesAnuladosComprobantesAnulados() {
		return this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados;
	}

	public void setResaltarBusquedaComprobantesAnuladosComprobantesAnulados(Border borderResaltar) {
		this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados= borderResaltar;
	}

	public void setResaltarBusquedaComprobantesAnuladosComprobantesAnulados(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobantesAnuladosBeanSwingJInternalFrame comprobantesanuladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobantesAnuladosComprobantesAnulados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
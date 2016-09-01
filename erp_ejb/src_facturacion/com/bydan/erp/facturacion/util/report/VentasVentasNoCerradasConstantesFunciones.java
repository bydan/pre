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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasVentasNoCerradasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentasVentasNoCerradasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasVentasNoCerradas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasVentasNoCerradas"+VentasVentasNoCerradasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasVentasNoCerradasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasVentasNoCerradasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasVentasNoCerradasConstantesFunciones.SCHEMA+"_"+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasVentasNoCerradasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasVentasNoCerradasConstantesFunciones.SCHEMA+"_"+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasVentasNoCerradasConstantesFunciones.SCHEMA+"_"+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasVentasNoCerradasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasVentasNoCerradasConstantesFunciones.SCHEMA+"_"+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasVentasNoCerradasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasVentasNoCerradasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasVentasNoCerradasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasVentasNoCerradasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasVentasNoCerradasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasVentasNoCerradasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasVentasNoCerradasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Ventas No Cerradases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Ventas No Cerradas";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Ventas No Cerradas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasVentasNoCerradas";
	public static final String OBJECTNAME="ventasventasnocerradas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_ventas_no_cerradas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventasventasnocerradas from "+VentasVentasNoCerradasConstantesFunciones.SPERSISTENCENAME+" ventasventasnocerradas";
	public static String QUERYSELECTNATIVE="select "+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".id,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".version_row,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".id_empresa,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".id_sucursal,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".codigo,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".nombre_completo,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".fecha_emision,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".numero_pre_impreso,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".numero_documento,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".total,"+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME+".efectivo from "+VentasVentasNoCerradasConstantesFunciones.SCHEMA+"."+VentasVentasNoCerradasConstantesFunciones.TABLENAME;//+" as "+VentasVentasNoCerradasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String TOTAL= "total";
    public static final String EFECTIVO= "efectivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_EFECTIVO= "Efectivo";
		public static final String LABEL_EFECTIVO_LOWER= "Efectivo";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getVentasVentasNoCerradasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.CODIGO)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISION)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.TOTAL)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(VentasVentasNoCerradasConstantesFunciones.EFECTIVO)) {sLabelColumna=VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasVentasNoCerradasDescripcion(VentasVentasNoCerradas ventasventasnocerradas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventasventasnocerradas !=null/* && ventasventasnocerradas.getId()!=0*/) {
			sDescripcion=ventasventasnocerradas.getcodigo();//ventasventasnocerradasventasventasnocerradas.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasVentasNoCerradasDescripcionDetallado(VentasVentasNoCerradas ventasventasnocerradas) {
		String sDescripcion="";
			
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.ID+"=";
		sDescripcion+=ventasventasnocerradas.getId().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventasventasnocerradas.getVersionRow().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventasventasnocerradas.getid_empresa().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventasventasnocerradas.getid_sucursal().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventasventasnocerradas.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventasventasnocerradas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.CODIGO+"=";
		sDescripcion+=ventasventasnocerradas.getcodigo()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=ventasventasnocerradas.getnombre_completo()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=ventasventasnocerradas.getfecha_emision().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=ventasventasnocerradas.getnumero_pre_impreso()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=ventasventasnocerradas.getnumero_documento()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.TOTAL+"=";
		sDescripcion+=ventasventasnocerradas.gettotal().toString()+",";
		sDescripcion+=VentasVentasNoCerradasConstantesFunciones.EFECTIVO+"=";
		sDescripcion+=ventasventasnocerradas.getefectivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasVentasNoCerradasDescripcion(VentasVentasNoCerradas ventasventasnocerradas,String sValor) throws Exception {			
		if(ventasventasnocerradas !=null) {
			ventasventasnocerradas.setcodigo(sValor);;//ventasventasnocerradasventasventasnocerradas.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentasVentasNoCerradas")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasVentasNoCerradas(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasventasnocerradas.setcodigo(ventasventasnocerradas.getcodigo().trim());
		ventasventasnocerradas.setnombre_completo(ventasventasnocerradas.getnombre_completo().trim());
		ventasventasnocerradas.setnumero_pre_impreso(ventasventasnocerradas.getnumero_pre_impreso().trim());
		ventasventasnocerradas.setnumero_documento(ventasventasnocerradas.getnumero_documento().trim());
	}
	
	public static void quitarEspaciosVentasVentasNoCerradass(List<VentasVentasNoCerradas> ventasventasnocerradass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {
			ventasventasnocerradas.setcodigo(ventasventasnocerradas.getcodigo().trim());
			ventasventasnocerradas.setnombre_completo(ventasventasnocerradas.getnombre_completo().trim());
			ventasventasnocerradas.setnumero_pre_impreso(ventasventasnocerradas.getnumero_pre_impreso().trim());
			ventasventasnocerradas.setnumero_documento(ventasventasnocerradas.getnumero_documento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventasventasnocerradas.getConCambioAuxiliar()) {
			ventasventasnocerradas.setIsDeleted(ventasventasnocerradas.getIsDeletedAuxiliar());	
			ventasventasnocerradas.setIsNew(ventasventasnocerradas.getIsNewAuxiliar());	
			ventasventasnocerradas.setIsChanged(ventasventasnocerradas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventasventasnocerradas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventasventasnocerradas.setIsDeletedAuxiliar(false);	
			ventasventasnocerradas.setIsNewAuxiliar(false);	
			ventasventasnocerradas.setIsChangedAuxiliar(false);
			
			ventasventasnocerradas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasVentasNoCerradass(List<VentasVentasNoCerradas> ventasventasnocerradass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasVentasNoCerradas ventasventasnocerradas : ventasventasnocerradass) {
			if(conAsignarBase && ventasventasnocerradas.getConCambioAuxiliar()) {
				ventasventasnocerradas.setIsDeleted(ventasventasnocerradas.getIsDeletedAuxiliar());	
				ventasventasnocerradas.setIsNew(ventasventasnocerradas.getIsNewAuxiliar());	
				ventasventasnocerradas.setIsChanged(ventasventasnocerradas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventasventasnocerradas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventasventasnocerradas.setIsDeletedAuxiliar(false);	
				ventasventasnocerradas.setIsNewAuxiliar(false);	
				ventasventasnocerradas.setIsChangedAuxiliar(false);
				
				ventasventasnocerradas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradas,Boolean conEnteros) throws Exception  {
		ventasventasnocerradas.settotal(0.0);
		ventasventasnocerradas.setefectivo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasVentasNoCerradass(List<VentasVentasNoCerradas> ventasventasnocerradass,Boolean conEnteros) throws Exception  {
		
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {
			ventasventasnocerradas.settotal(0.0);
			ventasventasnocerradas.setefectivo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasVentasNoCerradas(List<VentasVentasNoCerradas> ventasventasnocerradass,VentasVentasNoCerradas ventasventasnocerradasAux) throws Exception  {
		VentasVentasNoCerradasConstantesFunciones.InicializarValoresVentasVentasNoCerradas(ventasventasnocerradasAux,true);
		
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {
			if(ventasventasnocerradas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventasventasnocerradasAux.settotal(ventasventasnocerradasAux.gettotal()+ventasventasnocerradas.gettotal());			
			ventasventasnocerradasAux.setefectivo(ventasventasnocerradasAux.getefectivo()+ventasventasnocerradas.getefectivo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasVentasNoCerradas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasVentasNoCerradasConstantesFunciones.getArrayColumnasGlobalesVentasVentasNoCerradas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasVentasNoCerradas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasVentasNoCerradas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasVentasNoCerradas> ventasventasnocerradass,VentasVentasNoCerradas ventasventasnocerradas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasVentasNoCerradas ventasventasnocerradasAux: ventasventasnocerradass) {
			if(ventasventasnocerradasAux!=null && ventasventasnocerradas!=null) {
				if((ventasventasnocerradasAux.getId()==null && ventasventasnocerradas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventasventasnocerradasAux.getId()!=null && ventasventasnocerradas.getId()!=null){
					if(ventasventasnocerradasAux.getId().equals(ventasventasnocerradas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasVentasNoCerradas(List<VentasVentasNoCerradas> ventasventasnocerradass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double efectivoTotal=0.0;
	
		for(VentasVentasNoCerradas ventasventasnocerradas: ventasventasnocerradass) {			
			if(ventasventasnocerradas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=ventasventasnocerradas.gettotal();
			efectivoTotal+=ventasventasnocerradas.getefectivo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasVentasNoCerradasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasVentasNoCerradasConstantesFunciones.EFECTIVO);
		datoGeneral.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO);
		datoGeneral.setdValorDouble(efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasVentasNoCerradas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_ID, VentasVentasNoCerradasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_VERSIONROW, VentasVentasNoCerradasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_CODIGO, VentasVentasNoCerradasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_NOMBRECOMPLETO, VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISION, VentasVentasNoCerradasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_NUMEROPREIMPRESO, VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_NUMERODOCUMENTO, VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL, VentasVentasNoCerradasConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO, VentasVentasNoCerradasConstantesFunciones.EFECTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasVentasNoCerradas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasVentasNoCerradasConstantesFunciones.EFECTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasVentasNoCerradas() throws Exception  {
		return VentasVentasNoCerradasConstantesFunciones.getTiposSeleccionarVentasVentasNoCerradas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasVentasNoCerradas(Boolean conFk) throws Exception  {
		return VentasVentasNoCerradasConstantesFunciones.getTiposSeleccionarVentasVentasNoCerradas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasVentasNoCerradas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO);
			reporte.setsDescripcion(VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasVentasNoCerradas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradasAux) throws Exception {
		
			ventasventasnocerradasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasventasnocerradasAux.getEmpresa()));
			ventasventasnocerradasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasventasnocerradasAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasVentasNoCerradas(List<VentasVentasNoCerradas> ventasventasnocerradassTemp) throws Exception {
		for(VentasVentasNoCerradas ventasventasnocerradasAux:ventasventasnocerradassTemp) {
			
			ventasventasnocerradasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasventasnocerradasAux.getEmpresa()));
			ventasventasnocerradasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasventasnocerradasAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasVentasNoCerradas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasVentasNoCerradas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasVentasNoCerradas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasVentasNoCerradasConstantesFunciones.getClassesRelationshipsOfVentasVentasNoCerradas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasVentasNoCerradas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasVentasNoCerradas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasVentasNoCerradasConstantesFunciones.getClassesRelationshipsFromStringsOfVentasVentasNoCerradas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasVentasNoCerradas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasVentasNoCerradas ventasventasnocerradas,List<VentasVentasNoCerradas> ventasventasnocerradass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasVentasNoCerradas ventasventasnocerradas,List<VentasVentasNoCerradas> ventasventasnocerradass) throws Exception {
		try	{			
			for(VentasVentasNoCerradas ventasventasnocerradasLocal:ventasventasnocerradass) {
				if(ventasventasnocerradasLocal.getId().equals(ventasventasnocerradas.getId())) {
					ventasventasnocerradasLocal.setIsSelected(ventasventasnocerradas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasVentasNoCerradas(List<VentasVentasNoCerradas> ventasventasnocerradassAux) throws Exception {
		//this.ventasventasnocerradassAux=ventasventasnocerradassAux;
		
		for(VentasVentasNoCerradas ventasventasnocerradasAux:ventasventasnocerradassAux) {
			if(ventasventasnocerradasAux.getIsChanged()) {
				ventasventasnocerradasAux.setIsChanged(false);
			}		
			
			if(ventasventasnocerradasAux.getIsNew()) {
				ventasventasnocerradasAux.setIsNew(false);
			}	
			
			if(ventasventasnocerradasAux.getIsDeleted()) {
				ventasventasnocerradasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradasAux) throws Exception {
		//this.ventasventasnocerradasAux=ventasventasnocerradasAux;
		
			if(ventasventasnocerradasAux.getIsChanged()) {
				ventasventasnocerradasAux.setIsChanged(false);
			}		
			
			if(ventasventasnocerradasAux.getIsNew()) {
				ventasventasnocerradasAux.setIsNew(false);
			}	
			
			if(ventasventasnocerradasAux.getIsDeleted()) {
				ventasventasnocerradasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasVentasNoCerradas ventasventasnocerradasAsignar,VentasVentasNoCerradas ventasventasnocerradas) throws Exception {
		ventasventasnocerradasAsignar.setId(ventasventasnocerradas.getId());	
		ventasventasnocerradasAsignar.setVersionRow(ventasventasnocerradas.getVersionRow());	
		ventasventasnocerradasAsignar.setcodigo(ventasventasnocerradas.getcodigo());	
		ventasventasnocerradasAsignar.setnombre_completo(ventasventasnocerradas.getnombre_completo());	
		ventasventasnocerradasAsignar.setfecha_emision(ventasventasnocerradas.getfecha_emision());	
		ventasventasnocerradasAsignar.setnumero_pre_impreso(ventasventasnocerradas.getnumero_pre_impreso());	
		ventasventasnocerradasAsignar.setnumero_documento(ventasventasnocerradas.getnumero_documento());	
		ventasventasnocerradasAsignar.settotal(ventasventasnocerradas.gettotal());	
		ventasventasnocerradasAsignar.setefectivo(ventasventasnocerradas.getefectivo());	
	}
	
	public static void inicializarVentasVentasNoCerradas(VentasVentasNoCerradas ventasventasnocerradas) throws Exception {
		try {
				ventasventasnocerradas.setId(0L);	
					
				ventasventasnocerradas.setcodigo("");	
				ventasventasnocerradas.setnombre_completo("");	
				ventasventasnocerradas.setfecha_emision(new Date());	
				ventasventasnocerradas.setnumero_pre_impreso("");	
				ventasventasnocerradas.setnumero_documento("");	
				ventasventasnocerradas.settotal(0.0);	
				ventasventasnocerradas.setefectivo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasVentasNoCerradas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasVentasNoCerradasConstantesFunciones.LABEL_EFECTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasVentasNoCerradas(String sTipo,Row row,Workbook workbook,VentasVentasNoCerradas ventasventasnocerradas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasventasnocerradas.getefectivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasVentasNoCerradas="";
	
	public String getsFinalQueryVentasVentasNoCerradas() {
		return this.sFinalQueryVentasVentasNoCerradas;
	}
	
	public void setsFinalQueryVentasVentasNoCerradas(String sFinalQueryVentasVentasNoCerradas) {
		this.sFinalQueryVentasVentasNoCerradas= sFinalQueryVentasVentasNoCerradas;
	}
	
	public Border resaltarSeleccionarVentasVentasNoCerradas=null;
	
	public Border setResaltarSeleccionarVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasVentasNoCerradas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasVentasNoCerradas() {
		return this.resaltarSeleccionarVentasVentasNoCerradas;
	}
	
	public void setResaltarSeleccionarVentasVentasNoCerradas(Border borderResaltarSeleccionarVentasVentasNoCerradas) {
		this.resaltarSeleccionarVentasVentasNoCerradas= borderResaltarSeleccionarVentasVentasNoCerradas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasVentasNoCerradas=null;
	public Boolean mostraridVentasVentasNoCerradas=true;
	public Boolean activaridVentasVentasNoCerradas=true;

	public Border resaltarid_empresaVentasVentasNoCerradas=null;
	public Boolean mostrarid_empresaVentasVentasNoCerradas=true;
	public Boolean activarid_empresaVentasVentasNoCerradas=true;
	public Boolean cargarid_empresaVentasVentasNoCerradas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasVentasNoCerradas=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentasVentasNoCerradas=null;
	public Boolean mostrarid_sucursalVentasVentasNoCerradas=true;
	public Boolean activarid_sucursalVentasVentasNoCerradas=true;
	public Boolean cargarid_sucursalVentasVentasNoCerradas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentasVentasNoCerradas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasVentasNoCerradas=null;
	public Boolean mostrarfecha_emision_desdeVentasVentasNoCerradas=true;
	public Boolean activarfecha_emision_desdeVentasVentasNoCerradas=true;

	public Border resaltarfecha_emision_hastaVentasVentasNoCerradas=null;
	public Boolean mostrarfecha_emision_hastaVentasVentasNoCerradas=true;
	public Boolean activarfecha_emision_hastaVentasVentasNoCerradas=true;

	public Border resaltarcodigoVentasVentasNoCerradas=null;
	public Boolean mostrarcodigoVentasVentasNoCerradas=true;
	public Boolean activarcodigoVentasVentasNoCerradas=true;

	public Border resaltarnombre_completoVentasVentasNoCerradas=null;
	public Boolean mostrarnombre_completoVentasVentasNoCerradas=true;
	public Boolean activarnombre_completoVentasVentasNoCerradas=true;

	public Border resaltarfecha_emisionVentasVentasNoCerradas=null;
	public Boolean mostrarfecha_emisionVentasVentasNoCerradas=true;
	public Boolean activarfecha_emisionVentasVentasNoCerradas=true;

	public Border resaltarnumero_pre_impresoVentasVentasNoCerradas=null;
	public Boolean mostrarnumero_pre_impresoVentasVentasNoCerradas=true;
	public Boolean activarnumero_pre_impresoVentasVentasNoCerradas=true;

	public Border resaltarnumero_documentoVentasVentasNoCerradas=null;
	public Boolean mostrarnumero_documentoVentasVentasNoCerradas=true;
	public Boolean activarnumero_documentoVentasVentasNoCerradas=true;

	public Border resaltartotalVentasVentasNoCerradas=null;
	public Boolean mostrartotalVentasVentasNoCerradas=true;
	public Boolean activartotalVentasVentasNoCerradas=true;

	public Border resaltarefectivoVentasVentasNoCerradas=null;
	public Boolean mostrarefectivoVentasVentasNoCerradas=true;
	public Boolean activarefectivoVentasVentasNoCerradas=true;

	
	

	public Border setResaltaridVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltaridVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasVentasNoCerradas() {
		return this.resaltaridVentasVentasNoCerradas;
	}

	public void setResaltaridVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltaridVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostraridVentasVentasNoCerradas() {
		return this.mostraridVentasVentasNoCerradas;
	}

	public void setMostraridVentasVentasNoCerradas(Boolean mostraridVentasVentasNoCerradas) {
		this.mostraridVentasVentasNoCerradas= mostraridVentasVentasNoCerradas;
	}

	public Boolean getActivaridVentasVentasNoCerradas() {
		return this.activaridVentasVentasNoCerradas;
	}

	public void setActivaridVentasVentasNoCerradas(Boolean activaridVentasVentasNoCerradas) {
		this.activaridVentasVentasNoCerradas= activaridVentasVentasNoCerradas;
	}

	public Border setResaltarid_empresaVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasVentasNoCerradas() {
		return this.resaltarid_empresaVentasVentasNoCerradas;
	}

	public void setResaltarid_empresaVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarid_empresaVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasVentasNoCerradas() {
		return this.mostrarid_empresaVentasVentasNoCerradas;
	}

	public void setMostrarid_empresaVentasVentasNoCerradas(Boolean mostrarid_empresaVentasVentasNoCerradas) {
		this.mostrarid_empresaVentasVentasNoCerradas= mostrarid_empresaVentasVentasNoCerradas;
	}

	public Boolean getActivarid_empresaVentasVentasNoCerradas() {
		return this.activarid_empresaVentasVentasNoCerradas;
	}

	public void setActivarid_empresaVentasVentasNoCerradas(Boolean activarid_empresaVentasVentasNoCerradas) {
		this.activarid_empresaVentasVentasNoCerradas= activarid_empresaVentasVentasNoCerradas;
	}

	public Boolean getCargarid_empresaVentasVentasNoCerradas() {
		return this.cargarid_empresaVentasVentasNoCerradas;
	}

	public void setCargarid_empresaVentasVentasNoCerradas(Boolean cargarid_empresaVentasVentasNoCerradas) {
		this.cargarid_empresaVentasVentasNoCerradas= cargarid_empresaVentasVentasNoCerradas;
	}

	public Border setResaltarid_sucursalVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentasVentasNoCerradas() {
		return this.resaltarid_sucursalVentasVentasNoCerradas;
	}

	public void setResaltarid_sucursalVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarid_sucursalVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentasVentasNoCerradas() {
		return this.mostrarid_sucursalVentasVentasNoCerradas;
	}

	public void setMostrarid_sucursalVentasVentasNoCerradas(Boolean mostrarid_sucursalVentasVentasNoCerradas) {
		this.mostrarid_sucursalVentasVentasNoCerradas= mostrarid_sucursalVentasVentasNoCerradas;
	}

	public Boolean getActivarid_sucursalVentasVentasNoCerradas() {
		return this.activarid_sucursalVentasVentasNoCerradas;
	}

	public void setActivarid_sucursalVentasVentasNoCerradas(Boolean activarid_sucursalVentasVentasNoCerradas) {
		this.activarid_sucursalVentasVentasNoCerradas= activarid_sucursalVentasVentasNoCerradas;
	}

	public Boolean getCargarid_sucursalVentasVentasNoCerradas() {
		return this.cargarid_sucursalVentasVentasNoCerradas;
	}

	public void setCargarid_sucursalVentasVentasNoCerradas(Boolean cargarid_sucursalVentasVentasNoCerradas) {
		this.cargarid_sucursalVentasVentasNoCerradas= cargarid_sucursalVentasVentasNoCerradas;
	}

	public Border setResaltarfecha_emision_desdeVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasVentasNoCerradas() {
		return this.resaltarfecha_emision_desdeVentasVentasNoCerradas;
	}

	public void setResaltarfecha_emision_desdeVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasVentasNoCerradas() {
		return this.mostrarfecha_emision_desdeVentasVentasNoCerradas;
	}

	public void setMostrarfecha_emision_desdeVentasVentasNoCerradas(Boolean mostrarfecha_emision_desdeVentasVentasNoCerradas) {
		this.mostrarfecha_emision_desdeVentasVentasNoCerradas= mostrarfecha_emision_desdeVentasVentasNoCerradas;
	}

	public Boolean getActivarfecha_emision_desdeVentasVentasNoCerradas() {
		return this.activarfecha_emision_desdeVentasVentasNoCerradas;
	}

	public void setActivarfecha_emision_desdeVentasVentasNoCerradas(Boolean activarfecha_emision_desdeVentasVentasNoCerradas) {
		this.activarfecha_emision_desdeVentasVentasNoCerradas= activarfecha_emision_desdeVentasVentasNoCerradas;
	}

	public Border setResaltarfecha_emision_hastaVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasVentasNoCerradas() {
		return this.resaltarfecha_emision_hastaVentasVentasNoCerradas;
	}

	public void setResaltarfecha_emision_hastaVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasVentasNoCerradas() {
		return this.mostrarfecha_emision_hastaVentasVentasNoCerradas;
	}

	public void setMostrarfecha_emision_hastaVentasVentasNoCerradas(Boolean mostrarfecha_emision_hastaVentasVentasNoCerradas) {
		this.mostrarfecha_emision_hastaVentasVentasNoCerradas= mostrarfecha_emision_hastaVentasVentasNoCerradas;
	}

	public Boolean getActivarfecha_emision_hastaVentasVentasNoCerradas() {
		return this.activarfecha_emision_hastaVentasVentasNoCerradas;
	}

	public void setActivarfecha_emision_hastaVentasVentasNoCerradas(Boolean activarfecha_emision_hastaVentasVentasNoCerradas) {
		this.activarfecha_emision_hastaVentasVentasNoCerradas= activarfecha_emision_hastaVentasVentasNoCerradas;
	}

	public Border setResaltarcodigoVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarcodigoVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoVentasVentasNoCerradas() {
		return this.resaltarcodigoVentasVentasNoCerradas;
	}

	public void setResaltarcodigoVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarcodigoVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarcodigoVentasVentasNoCerradas() {
		return this.mostrarcodigoVentasVentasNoCerradas;
	}

	public void setMostrarcodigoVentasVentasNoCerradas(Boolean mostrarcodigoVentasVentasNoCerradas) {
		this.mostrarcodigoVentasVentasNoCerradas= mostrarcodigoVentasVentasNoCerradas;
	}

	public Boolean getActivarcodigoVentasVentasNoCerradas() {
		return this.activarcodigoVentasVentasNoCerradas;
	}

	public void setActivarcodigoVentasVentasNoCerradas(Boolean activarcodigoVentasVentasNoCerradas) {
		this.activarcodigoVentasVentasNoCerradas= activarcodigoVentasVentasNoCerradas;
	}

	public Border setResaltarnombre_completoVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarnombre_completoVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoVentasVentasNoCerradas() {
		return this.resaltarnombre_completoVentasVentasNoCerradas;
	}

	public void setResaltarnombre_completoVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarnombre_completoVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarnombre_completoVentasVentasNoCerradas() {
		return this.mostrarnombre_completoVentasVentasNoCerradas;
	}

	public void setMostrarnombre_completoVentasVentasNoCerradas(Boolean mostrarnombre_completoVentasVentasNoCerradas) {
		this.mostrarnombre_completoVentasVentasNoCerradas= mostrarnombre_completoVentasVentasNoCerradas;
	}

	public Boolean getActivarnombre_completoVentasVentasNoCerradas() {
		return this.activarnombre_completoVentasVentasNoCerradas;
	}

	public void setActivarnombre_completoVentasVentasNoCerradas(Boolean activarnombre_completoVentasVentasNoCerradas) {
		this.activarnombre_completoVentasVentasNoCerradas= activarnombre_completoVentasVentasNoCerradas;
	}

	public Border setResaltarfecha_emisionVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionVentasVentasNoCerradas() {
		return this.resaltarfecha_emisionVentasVentasNoCerradas;
	}

	public void setResaltarfecha_emisionVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarfecha_emisionVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionVentasVentasNoCerradas() {
		return this.mostrarfecha_emisionVentasVentasNoCerradas;
	}

	public void setMostrarfecha_emisionVentasVentasNoCerradas(Boolean mostrarfecha_emisionVentasVentasNoCerradas) {
		this.mostrarfecha_emisionVentasVentasNoCerradas= mostrarfecha_emisionVentasVentasNoCerradas;
	}

	public Boolean getActivarfecha_emisionVentasVentasNoCerradas() {
		return this.activarfecha_emisionVentasVentasNoCerradas;
	}

	public void setActivarfecha_emisionVentasVentasNoCerradas(Boolean activarfecha_emisionVentasVentasNoCerradas) {
		this.activarfecha_emisionVentasVentasNoCerradas= activarfecha_emisionVentasVentasNoCerradas;
	}

	public Border setResaltarnumero_pre_impresoVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoVentasVentasNoCerradas() {
		return this.resaltarnumero_pre_impresoVentasVentasNoCerradas;
	}

	public void setResaltarnumero_pre_impresoVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarnumero_pre_impresoVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoVentasVentasNoCerradas() {
		return this.mostrarnumero_pre_impresoVentasVentasNoCerradas;
	}

	public void setMostrarnumero_pre_impresoVentasVentasNoCerradas(Boolean mostrarnumero_pre_impresoVentasVentasNoCerradas) {
		this.mostrarnumero_pre_impresoVentasVentasNoCerradas= mostrarnumero_pre_impresoVentasVentasNoCerradas;
	}

	public Boolean getActivarnumero_pre_impresoVentasVentasNoCerradas() {
		return this.activarnumero_pre_impresoVentasVentasNoCerradas;
	}

	public void setActivarnumero_pre_impresoVentasVentasNoCerradas(Boolean activarnumero_pre_impresoVentasVentasNoCerradas) {
		this.activarnumero_pre_impresoVentasVentasNoCerradas= activarnumero_pre_impresoVentasVentasNoCerradas;
	}

	public Border setResaltarnumero_documentoVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoVentasVentasNoCerradas() {
		return this.resaltarnumero_documentoVentasVentasNoCerradas;
	}

	public void setResaltarnumero_documentoVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarnumero_documentoVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoVentasVentasNoCerradas() {
		return this.mostrarnumero_documentoVentasVentasNoCerradas;
	}

	public void setMostrarnumero_documentoVentasVentasNoCerradas(Boolean mostrarnumero_documentoVentasVentasNoCerradas) {
		this.mostrarnumero_documentoVentasVentasNoCerradas= mostrarnumero_documentoVentasVentasNoCerradas;
	}

	public Boolean getActivarnumero_documentoVentasVentasNoCerradas() {
		return this.activarnumero_documentoVentasVentasNoCerradas;
	}

	public void setActivarnumero_documentoVentasVentasNoCerradas(Boolean activarnumero_documentoVentasVentasNoCerradas) {
		this.activarnumero_documentoVentasVentasNoCerradas= activarnumero_documentoVentasVentasNoCerradas;
	}

	public Border setResaltartotalVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltartotalVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalVentasVentasNoCerradas() {
		return this.resaltartotalVentasVentasNoCerradas;
	}

	public void setResaltartotalVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltartotalVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrartotalVentasVentasNoCerradas() {
		return this.mostrartotalVentasVentasNoCerradas;
	}

	public void setMostrartotalVentasVentasNoCerradas(Boolean mostrartotalVentasVentasNoCerradas) {
		this.mostrartotalVentasVentasNoCerradas= mostrartotalVentasVentasNoCerradas;
	}

	public Boolean getActivartotalVentasVentasNoCerradas() {
		return this.activartotalVentasVentasNoCerradas;
	}

	public void setActivartotalVentasVentasNoCerradas(Boolean activartotalVentasVentasNoCerradas) {
		this.activartotalVentasVentasNoCerradas= activartotalVentasVentasNoCerradas;
	}

	public Border setResaltarefectivoVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasventasnocerradasBeanSwingJInternalFrame.jTtoolBarVentasVentasNoCerradas.setBorder(borderResaltar);
		
		this.resaltarefectivoVentasVentasNoCerradas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarefectivoVentasVentasNoCerradas() {
		return this.resaltarefectivoVentasVentasNoCerradas;
	}

	public void setResaltarefectivoVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarefectivoVentasVentasNoCerradas= borderResaltar;
	}

	public Boolean getMostrarefectivoVentasVentasNoCerradas() {
		return this.mostrarefectivoVentasVentasNoCerradas;
	}

	public void setMostrarefectivoVentasVentasNoCerradas(Boolean mostrarefectivoVentasVentasNoCerradas) {
		this.mostrarefectivoVentasVentasNoCerradas= mostrarefectivoVentasVentasNoCerradas;
	}

	public Boolean getActivarefectivoVentasVentasNoCerradas() {
		return this.activarefectivoVentasVentasNoCerradas;
	}

	public void setActivarefectivoVentasVentasNoCerradas(Boolean activarefectivoVentasVentasNoCerradas) {
		this.activarefectivoVentasVentasNoCerradas= activarefectivoVentasVentasNoCerradas;
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
		
		
		this.setMostraridVentasVentasNoCerradas(esInicial);
		this.setMostrarid_empresaVentasVentasNoCerradas(esInicial);
		this.setMostrarid_sucursalVentasVentasNoCerradas(esInicial);
		this.setMostrarfecha_emision_desdeVentasVentasNoCerradas(esInicial);
		this.setMostrarfecha_emision_hastaVentasVentasNoCerradas(esInicial);
		this.setMostrarcodigoVentasVentasNoCerradas(esInicial);
		this.setMostrarnombre_completoVentasVentasNoCerradas(esInicial);
		this.setMostrarfecha_emisionVentasVentasNoCerradas(esInicial);
		this.setMostrarnumero_pre_impresoVentasVentasNoCerradas(esInicial);
		this.setMostrarnumero_documentoVentasVentasNoCerradas(esInicial);
		this.setMostrartotalVentasVentasNoCerradas(esInicial);
		this.setMostrarefectivoVentasVentasNoCerradas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.ID)) {
				this.setMostraridVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.TOTAL)) {
				this.setMostrartotalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.EFECTIVO)) {
				this.setMostrarefectivoVentasVentasNoCerradas(esAsigna);
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
		
		
		this.setActivaridVentasVentasNoCerradas(esInicial);
		this.setActivarid_empresaVentasVentasNoCerradas(esInicial);
		this.setActivarid_sucursalVentasVentasNoCerradas(esInicial);
		this.setActivarfecha_emision_desdeVentasVentasNoCerradas(esInicial);
		this.setActivarfecha_emision_hastaVentasVentasNoCerradas(esInicial);
		this.setActivarcodigoVentasVentasNoCerradas(esInicial);
		this.setActivarnombre_completoVentasVentasNoCerradas(esInicial);
		this.setActivarfecha_emisionVentasVentasNoCerradas(esInicial);
		this.setActivarnumero_pre_impresoVentasVentasNoCerradas(esInicial);
		this.setActivarnumero_documentoVentasVentasNoCerradas(esInicial);
		this.setActivartotalVentasVentasNoCerradas(esInicial);
		this.setActivarefectivoVentasVentasNoCerradas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.ID)) {
				this.setActivaridVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.TOTAL)) {
				this.setActivartotalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.EFECTIVO)) {
				this.setActivarefectivoVentasVentasNoCerradas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasVentasNoCerradas(esInicial);
		this.setResaltarid_empresaVentasVentasNoCerradas(esInicial);
		this.setResaltarid_sucursalVentasVentasNoCerradas(esInicial);
		this.setResaltarfecha_emision_desdeVentasVentasNoCerradas(esInicial);
		this.setResaltarfecha_emision_hastaVentasVentasNoCerradas(esInicial);
		this.setResaltarcodigoVentasVentasNoCerradas(esInicial);
		this.setResaltarnombre_completoVentasVentasNoCerradas(esInicial);
		this.setResaltarfecha_emisionVentasVentasNoCerradas(esInicial);
		this.setResaltarnumero_pre_impresoVentasVentasNoCerradas(esInicial);
		this.setResaltarnumero_documentoVentasVentasNoCerradas(esInicial);
		this.setResaltartotalVentasVentasNoCerradas(esInicial);
		this.setResaltarefectivoVentasVentasNoCerradas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.ID)) {
				this.setResaltaridVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.TOTAL)) {
				this.setResaltartotalVentasVentasNoCerradas(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasVentasNoCerradasConstantesFunciones.EFECTIVO)) {
				this.setResaltarefectivoVentasVentasNoCerradas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas=true;

	public Boolean getMostrarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas() {
		return this.mostrarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas;
	}

	public void setMostrarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas=true;

	public Boolean getActivarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas() {
		return this.activarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas;
	}

	public void setActivarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas(Boolean habilitarResaltar) {
		this.activarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas=null;

	public Border getResaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas() {
		return this.resaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas;
	}

	public void setResaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas(Border borderResaltar) {
		this.resaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas= borderResaltar;
	}

	public void setResaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas(ParametroGeneralUsuario parametroGeneralUsuario/*VentasVentasNoCerradasBeanSwingJInternalFrame ventasventasnocerradasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasVentasNoCerradasVentasVentasNoCerradas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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


import com.bydan.erp.facturacion.util.report.VentasCajasResumidosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasCajasResumidosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasCajasResumidosParameterGeneral;

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
final public class VentasCajasResumidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasCajasResumidos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasCajasResumidos"+VentasCajasResumidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasCajasResumidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasCajasResumidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasCajasResumidosConstantesFunciones.SCHEMA+"_"+VentasCajasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasCajasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasCajasResumidosConstantesFunciones.SCHEMA+"_"+VentasCajasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasCajasResumidosConstantesFunciones.SCHEMA+"_"+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasCajasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasCajasResumidosConstantesFunciones.SCHEMA+"_"+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasCajasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasCajasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCajasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasCajasResumidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasCajasResumidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasCajasResumidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasCajasResumidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Cajas Resumidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Cajas Resumidos";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Cajas Resumidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasCajasResumidos";
	public static final String OBJECTNAME="ventascajasresumidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_cajas_resumidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventascajasresumidos from "+VentasCajasResumidosConstantesFunciones.SPERSISTENCENAME+" ventascajasresumidos";
	public static String QUERYSELECTNATIVE="select "+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".id,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".version_row,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".id_empresa,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".id_sucursal,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".codigo,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".nombre_completo,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".fecha_emision,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".numero_pre_impreso,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".numero_documento,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".total,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".efectivo,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".tarjeta,"+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME+".credito from "+VentasCajasResumidosConstantesFunciones.SCHEMA+"."+VentasCajasResumidosConstantesFunciones.TABLENAME;//+" as "+VentasCajasResumidosConstantesFunciones.TABLENAME;
	
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
    public static final String TARJETA= "tarjeta";
    public static final String CREDITO= "credito";
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
    	public static final String LABEL_TARJETA= "Tarjeta";
		public static final String LABEL_TARJETA_LOWER= "Tarjeta";
    	public static final String LABEL_CREDITO= "Credito";
		public static final String LABEL_CREDITO_LOWER= "Credito";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getVentasCajasResumidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.CODIGO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISION)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.TOTAL)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.EFECTIVO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.TARJETA)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_TARJETA;}
		if(sNombreColumna.equals(VentasCajasResumidosConstantesFunciones.CREDITO)) {sLabelColumna=VentasCajasResumidosConstantesFunciones.LABEL_CREDITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasCajasResumidosDescripcion(VentasCajasResumidos ventascajasresumidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventascajasresumidos !=null/* && ventascajasresumidos.getId()!=0*/) {
			sDescripcion=ventascajasresumidos.getcodigo();//ventascajasresumidosventascajasresumidos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasCajasResumidosDescripcionDetallado(VentasCajasResumidos ventascajasresumidos) {
		String sDescripcion="";
			
		sDescripcion+=VentasCajasResumidosConstantesFunciones.ID+"=";
		sDescripcion+=ventascajasresumidos.getId().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventascajasresumidos.getVersionRow().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventascajasresumidos.getid_empresa().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventascajasresumidos.getid_sucursal().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventascajasresumidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventascajasresumidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.CODIGO+"=";
		sDescripcion+=ventascajasresumidos.getcodigo()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=ventascajasresumidos.getnombre_completo()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=ventascajasresumidos.getfecha_emision().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=ventascajasresumidos.getnumero_pre_impreso()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=ventascajasresumidos.getnumero_documento()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.TOTAL+"=";
		sDescripcion+=ventascajasresumidos.gettotal().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.EFECTIVO+"=";
		sDescripcion+=ventascajasresumidos.getefectivo().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.TARJETA+"=";
		sDescripcion+=ventascajasresumidos.gettarjeta().toString()+",";
		sDescripcion+=VentasCajasResumidosConstantesFunciones.CREDITO+"=";
		sDescripcion+=ventascajasresumidos.getcredito().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasCajasResumidosDescripcion(VentasCajasResumidos ventascajasresumidos,String sValor) throws Exception {			
		if(ventascajasresumidos !=null) {
			ventascajasresumidos.setcodigo(sValor);;//ventascajasresumidosventascajasresumidos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaVentasCajasResumidos")) {
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

	public static String getDetalleIndiceBusquedaVentasCajasResumidos(Date fecha_emision_desde,Date fecha_emision_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosVentasCajasResumidos(VentasCajasResumidos ventascajasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventascajasresumidos.setcodigo(ventascajasresumidos.getcodigo().trim());
		ventascajasresumidos.setnombre_completo(ventascajasresumidos.getnombre_completo().trim());
		ventascajasresumidos.setnumero_pre_impreso(ventascajasresumidos.getnumero_pre_impreso().trim());
		ventascajasresumidos.setnumero_documento(ventascajasresumidos.getnumero_documento().trim());
	}
	
	public static void quitarEspaciosVentasCajasResumidoss(List<VentasCajasResumidos> ventascajasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {
			ventascajasresumidos.setcodigo(ventascajasresumidos.getcodigo().trim());
			ventascajasresumidos.setnombre_completo(ventascajasresumidos.getnombre_completo().trim());
			ventascajasresumidos.setnumero_pre_impreso(ventascajasresumidos.getnumero_pre_impreso().trim());
			ventascajasresumidos.setnumero_documento(ventascajasresumidos.getnumero_documento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasCajasResumidos(VentasCajasResumidos ventascajasresumidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventascajasresumidos.getConCambioAuxiliar()) {
			ventascajasresumidos.setIsDeleted(ventascajasresumidos.getIsDeletedAuxiliar());	
			ventascajasresumidos.setIsNew(ventascajasresumidos.getIsNewAuxiliar());	
			ventascajasresumidos.setIsChanged(ventascajasresumidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventascajasresumidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventascajasresumidos.setIsDeletedAuxiliar(false);	
			ventascajasresumidos.setIsNewAuxiliar(false);	
			ventascajasresumidos.setIsChangedAuxiliar(false);
			
			ventascajasresumidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasCajasResumidoss(List<VentasCajasResumidos> ventascajasresumidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasCajasResumidos ventascajasresumidos : ventascajasresumidoss) {
			if(conAsignarBase && ventascajasresumidos.getConCambioAuxiliar()) {
				ventascajasresumidos.setIsDeleted(ventascajasresumidos.getIsDeletedAuxiliar());	
				ventascajasresumidos.setIsNew(ventascajasresumidos.getIsNewAuxiliar());	
				ventascajasresumidos.setIsChanged(ventascajasresumidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventascajasresumidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventascajasresumidos.setIsDeletedAuxiliar(false);	
				ventascajasresumidos.setIsNewAuxiliar(false);	
				ventascajasresumidos.setIsChangedAuxiliar(false);
				
				ventascajasresumidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasCajasResumidos(VentasCajasResumidos ventascajasresumidos,Boolean conEnteros) throws Exception  {
		ventascajasresumidos.settotal(0.0);
		ventascajasresumidos.setefectivo(0.0);
		ventascajasresumidos.settarjeta(0.0);
		ventascajasresumidos.setcredito(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasCajasResumidoss(List<VentasCajasResumidos> ventascajasresumidoss,Boolean conEnteros) throws Exception  {
		
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {
			ventascajasresumidos.settotal(0.0);
			ventascajasresumidos.setefectivo(0.0);
			ventascajasresumidos.settarjeta(0.0);
			ventascajasresumidos.setcredito(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasCajasResumidos(List<VentasCajasResumidos> ventascajasresumidoss,VentasCajasResumidos ventascajasresumidosAux) throws Exception  {
		VentasCajasResumidosConstantesFunciones.InicializarValoresVentasCajasResumidos(ventascajasresumidosAux,true);
		
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {
			if(ventascajasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventascajasresumidosAux.settotal(ventascajasresumidosAux.gettotal()+ventascajasresumidos.gettotal());			
			ventascajasresumidosAux.setefectivo(ventascajasresumidosAux.getefectivo()+ventascajasresumidos.getefectivo());			
			ventascajasresumidosAux.settarjeta(ventascajasresumidosAux.gettarjeta()+ventascajasresumidos.gettarjeta());			
			ventascajasresumidosAux.setcredito(ventascajasresumidosAux.getcredito()+ventascajasresumidos.getcredito());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCajasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasCajasResumidosConstantesFunciones.getArrayColumnasGlobalesVentasCajasResumidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCajasResumidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasCajasResumidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasCajasResumidosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasCajasResumidosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasCajasResumidosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasCajasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasCajasResumidos> ventascajasresumidoss,VentasCajasResumidos ventascajasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasCajasResumidos ventascajasresumidosAux: ventascajasresumidoss) {
			if(ventascajasresumidosAux!=null && ventascajasresumidos!=null) {
				if((ventascajasresumidosAux.getId()==null && ventascajasresumidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventascajasresumidosAux.getId()!=null && ventascajasresumidos.getId()!=null){
					if(ventascajasresumidosAux.getId().equals(ventascajasresumidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasCajasResumidos(List<VentasCajasResumidos> ventascajasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double efectivoTotal=0.0;
		Double tarjetaTotal=0.0;
		Double creditoTotal=0.0;
	
		for(VentasCajasResumidos ventascajasresumidos: ventascajasresumidoss) {			
			if(ventascajasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=ventascajasresumidos.gettotal();
			efectivoTotal+=ventascajasresumidos.getefectivo();
			tarjetaTotal+=ventascajasresumidos.gettarjeta();
			creditoTotal+=ventascajasresumidos.getcredito();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.EFECTIVO);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO);
		datoGeneral.setdValorDouble(efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.TARJETA);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TARJETA);
		datoGeneral.setdValorDouble(tarjetaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCajasResumidosConstantesFunciones.CREDITO);
		datoGeneral.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_CREDITO);
		datoGeneral.setdValorDouble(creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasCajasResumidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_ID, VentasCajasResumidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_VERSIONROW, VentasCajasResumidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_CODIGO, VentasCajasResumidosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO, VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISION, VentasCajasResumidosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_NUMEROPREIMPRESO, VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_NUMERODOCUMENTO, VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_TOTAL, VentasCajasResumidosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO, VentasCajasResumidosConstantesFunciones.EFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_TARJETA, VentasCajasResumidosConstantesFunciones.TARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCajasResumidosConstantesFunciones.LABEL_CREDITO, VentasCajasResumidosConstantesFunciones.CREDITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasCajasResumidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.EFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.TARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCajasResumidosConstantesFunciones.CREDITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCajasResumidos() throws Exception  {
		return VentasCajasResumidosConstantesFunciones.getTiposSeleccionarVentasCajasResumidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCajasResumidos(Boolean conFk) throws Exception  {
		return VentasCajasResumidosConstantesFunciones.getTiposSeleccionarVentasCajasResumidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCajasResumidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_TARJETA);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_TARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCajasResumidosConstantesFunciones.LABEL_CREDITO);
			reporte.setsDescripcion(VentasCajasResumidosConstantesFunciones.LABEL_CREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasCajasResumidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasCajasResumidos(VentasCajasResumidos ventascajasresumidosAux) throws Exception {
		
			ventascajasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventascajasresumidosAux.getEmpresa()));
			ventascajasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventascajasresumidosAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasCajasResumidos(List<VentasCajasResumidos> ventascajasresumidossTemp) throws Exception {
		for(VentasCajasResumidos ventascajasresumidosAux:ventascajasresumidossTemp) {
			
			ventascajasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventascajasresumidosAux.getEmpresa()));
			ventascajasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventascajasresumidosAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasCajasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasCajasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasCajasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasCajasResumidosConstantesFunciones.getClassesRelationshipsOfVentasCajasResumidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasCajasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasCajasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasCajasResumidosConstantesFunciones.getClassesRelationshipsFromStringsOfVentasCajasResumidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasCajasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasCajasResumidos ventascajasresumidos,List<VentasCajasResumidos> ventascajasresumidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasCajasResumidos ventascajasresumidos,List<VentasCajasResumidos> ventascajasresumidoss) throws Exception {
		try	{			
			for(VentasCajasResumidos ventascajasresumidosLocal:ventascajasresumidoss) {
				if(ventascajasresumidosLocal.getId().equals(ventascajasresumidos.getId())) {
					ventascajasresumidosLocal.setIsSelected(ventascajasresumidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasCajasResumidos(List<VentasCajasResumidos> ventascajasresumidossAux) throws Exception {
		//this.ventascajasresumidossAux=ventascajasresumidossAux;
		
		for(VentasCajasResumidos ventascajasresumidosAux:ventascajasresumidossAux) {
			if(ventascajasresumidosAux.getIsChanged()) {
				ventascajasresumidosAux.setIsChanged(false);
			}		
			
			if(ventascajasresumidosAux.getIsNew()) {
				ventascajasresumidosAux.setIsNew(false);
			}	
			
			if(ventascajasresumidosAux.getIsDeleted()) {
				ventascajasresumidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasCajasResumidos(VentasCajasResumidos ventascajasresumidosAux) throws Exception {
		//this.ventascajasresumidosAux=ventascajasresumidosAux;
		
			if(ventascajasresumidosAux.getIsChanged()) {
				ventascajasresumidosAux.setIsChanged(false);
			}		
			
			if(ventascajasresumidosAux.getIsNew()) {
				ventascajasresumidosAux.setIsNew(false);
			}	
			
			if(ventascajasresumidosAux.getIsDeleted()) {
				ventascajasresumidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasCajasResumidos ventascajasresumidosAsignar,VentasCajasResumidos ventascajasresumidos) throws Exception {
		ventascajasresumidosAsignar.setId(ventascajasresumidos.getId());	
		ventascajasresumidosAsignar.setVersionRow(ventascajasresumidos.getVersionRow());	
		ventascajasresumidosAsignar.setcodigo(ventascajasresumidos.getcodigo());	
		ventascajasresumidosAsignar.setnombre_completo(ventascajasresumidos.getnombre_completo());	
		ventascajasresumidosAsignar.setfecha_emision(ventascajasresumidos.getfecha_emision());	
		ventascajasresumidosAsignar.setnumero_pre_impreso(ventascajasresumidos.getnumero_pre_impreso());	
		ventascajasresumidosAsignar.setnumero_documento(ventascajasresumidos.getnumero_documento());	
		ventascajasresumidosAsignar.settotal(ventascajasresumidos.gettotal());	
		ventascajasresumidosAsignar.setefectivo(ventascajasresumidos.getefectivo());	
		ventascajasresumidosAsignar.settarjeta(ventascajasresumidos.gettarjeta());	
		ventascajasresumidosAsignar.setcredito(ventascajasresumidos.getcredito());	
	}
	
	public static void inicializarVentasCajasResumidos(VentasCajasResumidos ventascajasresumidos) throws Exception {
		try {
				ventascajasresumidos.setId(0L);	
					
				ventascajasresumidos.setcodigo("");	
				ventascajasresumidos.setnombre_completo("");	
				ventascajasresumidos.setfecha_emision(new Date());	
				ventascajasresumidos.setnumero_pre_impreso("");	
				ventascajasresumidos.setnumero_documento("");	
				ventascajasresumidos.settotal(0.0);	
				ventascajasresumidos.setefectivo(0.0);	
				ventascajasresumidos.settarjeta(0.0);	
				ventascajasresumidos.setcredito(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasCajasResumidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_EFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_TARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCajasResumidosConstantesFunciones.LABEL_CREDITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasCajasResumidos(String sTipo,Row row,Workbook workbook,VentasCajasResumidos ventascajasresumidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getefectivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.gettarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascajasresumidos.getcredito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasCajasResumidos="";
	
	public String getsFinalQueryVentasCajasResumidos() {
		return this.sFinalQueryVentasCajasResumidos;
	}
	
	public void setsFinalQueryVentasCajasResumidos(String sFinalQueryVentasCajasResumidos) {
		this.sFinalQueryVentasCajasResumidos= sFinalQueryVentasCajasResumidos;
	}
	
	public Border resaltarSeleccionarVentasCajasResumidos=null;
	
	public Border setResaltarSeleccionarVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasCajasResumidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasCajasResumidos() {
		return this.resaltarSeleccionarVentasCajasResumidos;
	}
	
	public void setResaltarSeleccionarVentasCajasResumidos(Border borderResaltarSeleccionarVentasCajasResumidos) {
		this.resaltarSeleccionarVentasCajasResumidos= borderResaltarSeleccionarVentasCajasResumidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasCajasResumidos=null;
	public Boolean mostraridVentasCajasResumidos=true;
	public Boolean activaridVentasCajasResumidos=true;

	public Border resaltarid_empresaVentasCajasResumidos=null;
	public Boolean mostrarid_empresaVentasCajasResumidos=true;
	public Boolean activarid_empresaVentasCajasResumidos=true;
	public Boolean cargarid_empresaVentasCajasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasCajasResumidos=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentasCajasResumidos=null;
	public Boolean mostrarid_sucursalVentasCajasResumidos=true;
	public Boolean activarid_sucursalVentasCajasResumidos=true;
	public Boolean cargarid_sucursalVentasCajasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentasCajasResumidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasCajasResumidos=null;
	public Boolean mostrarfecha_emision_desdeVentasCajasResumidos=true;
	public Boolean activarfecha_emision_desdeVentasCajasResumidos=true;

	public Border resaltarfecha_emision_hastaVentasCajasResumidos=null;
	public Boolean mostrarfecha_emision_hastaVentasCajasResumidos=true;
	public Boolean activarfecha_emision_hastaVentasCajasResumidos=true;

	public Border resaltarcodigoVentasCajasResumidos=null;
	public Boolean mostrarcodigoVentasCajasResumidos=true;
	public Boolean activarcodigoVentasCajasResumidos=true;

	public Border resaltarnombre_completoVentasCajasResumidos=null;
	public Boolean mostrarnombre_completoVentasCajasResumidos=true;
	public Boolean activarnombre_completoVentasCajasResumidos=true;

	public Border resaltarfecha_emisionVentasCajasResumidos=null;
	public Boolean mostrarfecha_emisionVentasCajasResumidos=true;
	public Boolean activarfecha_emisionVentasCajasResumidos=true;

	public Border resaltarnumero_pre_impresoVentasCajasResumidos=null;
	public Boolean mostrarnumero_pre_impresoVentasCajasResumidos=true;
	public Boolean activarnumero_pre_impresoVentasCajasResumidos=true;

	public Border resaltarnumero_documentoVentasCajasResumidos=null;
	public Boolean mostrarnumero_documentoVentasCajasResumidos=true;
	public Boolean activarnumero_documentoVentasCajasResumidos=true;

	public Border resaltartotalVentasCajasResumidos=null;
	public Boolean mostrartotalVentasCajasResumidos=true;
	public Boolean activartotalVentasCajasResumidos=true;

	public Border resaltarefectivoVentasCajasResumidos=null;
	public Boolean mostrarefectivoVentasCajasResumidos=true;
	public Boolean activarefectivoVentasCajasResumidos=true;

	public Border resaltartarjetaVentasCajasResumidos=null;
	public Boolean mostrartarjetaVentasCajasResumidos=true;
	public Boolean activartarjetaVentasCajasResumidos=true;

	public Border resaltarcreditoVentasCajasResumidos=null;
	public Boolean mostrarcreditoVentasCajasResumidos=true;
	public Boolean activarcreditoVentasCajasResumidos=true;

	
	

	public Border setResaltaridVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltaridVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasCajasResumidos() {
		return this.resaltaridVentasCajasResumidos;
	}

	public void setResaltaridVentasCajasResumidos(Border borderResaltar) {
		this.resaltaridVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostraridVentasCajasResumidos() {
		return this.mostraridVentasCajasResumidos;
	}

	public void setMostraridVentasCajasResumidos(Boolean mostraridVentasCajasResumidos) {
		this.mostraridVentasCajasResumidos= mostraridVentasCajasResumidos;
	}

	public Boolean getActivaridVentasCajasResumidos() {
		return this.activaridVentasCajasResumidos;
	}

	public void setActivaridVentasCajasResumidos(Boolean activaridVentasCajasResumidos) {
		this.activaridVentasCajasResumidos= activaridVentasCajasResumidos;
	}

	public Border setResaltarid_empresaVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasCajasResumidos() {
		return this.resaltarid_empresaVentasCajasResumidos;
	}

	public void setResaltarid_empresaVentasCajasResumidos(Border borderResaltar) {
		this.resaltarid_empresaVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasCajasResumidos() {
		return this.mostrarid_empresaVentasCajasResumidos;
	}

	public void setMostrarid_empresaVentasCajasResumidos(Boolean mostrarid_empresaVentasCajasResumidos) {
		this.mostrarid_empresaVentasCajasResumidos= mostrarid_empresaVentasCajasResumidos;
	}

	public Boolean getActivarid_empresaVentasCajasResumidos() {
		return this.activarid_empresaVentasCajasResumidos;
	}

	public void setActivarid_empresaVentasCajasResumidos(Boolean activarid_empresaVentasCajasResumidos) {
		this.activarid_empresaVentasCajasResumidos= activarid_empresaVentasCajasResumidos;
	}

	public Boolean getCargarid_empresaVentasCajasResumidos() {
		return this.cargarid_empresaVentasCajasResumidos;
	}

	public void setCargarid_empresaVentasCajasResumidos(Boolean cargarid_empresaVentasCajasResumidos) {
		this.cargarid_empresaVentasCajasResumidos= cargarid_empresaVentasCajasResumidos;
	}

	public Border setResaltarid_sucursalVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentasCajasResumidos() {
		return this.resaltarid_sucursalVentasCajasResumidos;
	}

	public void setResaltarid_sucursalVentasCajasResumidos(Border borderResaltar) {
		this.resaltarid_sucursalVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentasCajasResumidos() {
		return this.mostrarid_sucursalVentasCajasResumidos;
	}

	public void setMostrarid_sucursalVentasCajasResumidos(Boolean mostrarid_sucursalVentasCajasResumidos) {
		this.mostrarid_sucursalVentasCajasResumidos= mostrarid_sucursalVentasCajasResumidos;
	}

	public Boolean getActivarid_sucursalVentasCajasResumidos() {
		return this.activarid_sucursalVentasCajasResumidos;
	}

	public void setActivarid_sucursalVentasCajasResumidos(Boolean activarid_sucursalVentasCajasResumidos) {
		this.activarid_sucursalVentasCajasResumidos= activarid_sucursalVentasCajasResumidos;
	}

	public Boolean getCargarid_sucursalVentasCajasResumidos() {
		return this.cargarid_sucursalVentasCajasResumidos;
	}

	public void setCargarid_sucursalVentasCajasResumidos(Boolean cargarid_sucursalVentasCajasResumidos) {
		this.cargarid_sucursalVentasCajasResumidos= cargarid_sucursalVentasCajasResumidos;
	}

	public Border setResaltarfecha_emision_desdeVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasCajasResumidos() {
		return this.resaltarfecha_emision_desdeVentasCajasResumidos;
	}

	public void setResaltarfecha_emision_desdeVentasCajasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasCajasResumidos() {
		return this.mostrarfecha_emision_desdeVentasCajasResumidos;
	}

	public void setMostrarfecha_emision_desdeVentasCajasResumidos(Boolean mostrarfecha_emision_desdeVentasCajasResumidos) {
		this.mostrarfecha_emision_desdeVentasCajasResumidos= mostrarfecha_emision_desdeVentasCajasResumidos;
	}

	public Boolean getActivarfecha_emision_desdeVentasCajasResumidos() {
		return this.activarfecha_emision_desdeVentasCajasResumidos;
	}

	public void setActivarfecha_emision_desdeVentasCajasResumidos(Boolean activarfecha_emision_desdeVentasCajasResumidos) {
		this.activarfecha_emision_desdeVentasCajasResumidos= activarfecha_emision_desdeVentasCajasResumidos;
	}

	public Border setResaltarfecha_emision_hastaVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasCajasResumidos() {
		return this.resaltarfecha_emision_hastaVentasCajasResumidos;
	}

	public void setResaltarfecha_emision_hastaVentasCajasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasCajasResumidos() {
		return this.mostrarfecha_emision_hastaVentasCajasResumidos;
	}

	public void setMostrarfecha_emision_hastaVentasCajasResumidos(Boolean mostrarfecha_emision_hastaVentasCajasResumidos) {
		this.mostrarfecha_emision_hastaVentasCajasResumidos= mostrarfecha_emision_hastaVentasCajasResumidos;
	}

	public Boolean getActivarfecha_emision_hastaVentasCajasResumidos() {
		return this.activarfecha_emision_hastaVentasCajasResumidos;
	}

	public void setActivarfecha_emision_hastaVentasCajasResumidos(Boolean activarfecha_emision_hastaVentasCajasResumidos) {
		this.activarfecha_emision_hastaVentasCajasResumidos= activarfecha_emision_hastaVentasCajasResumidos;
	}

	public Border setResaltarcodigoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarcodigoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoVentasCajasResumidos() {
		return this.resaltarcodigoVentasCajasResumidos;
	}

	public void setResaltarcodigoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarcodigoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarcodigoVentasCajasResumidos() {
		return this.mostrarcodigoVentasCajasResumidos;
	}

	public void setMostrarcodigoVentasCajasResumidos(Boolean mostrarcodigoVentasCajasResumidos) {
		this.mostrarcodigoVentasCajasResumidos= mostrarcodigoVentasCajasResumidos;
	}

	public Boolean getActivarcodigoVentasCajasResumidos() {
		return this.activarcodigoVentasCajasResumidos;
	}

	public void setActivarcodigoVentasCajasResumidos(Boolean activarcodigoVentasCajasResumidos) {
		this.activarcodigoVentasCajasResumidos= activarcodigoVentasCajasResumidos;
	}

	public Border setResaltarnombre_completoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoVentasCajasResumidos() {
		return this.resaltarnombre_completoVentasCajasResumidos;
	}

	public void setResaltarnombre_completoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarnombre_completoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoVentasCajasResumidos() {
		return this.mostrarnombre_completoVentasCajasResumidos;
	}

	public void setMostrarnombre_completoVentasCajasResumidos(Boolean mostrarnombre_completoVentasCajasResumidos) {
		this.mostrarnombre_completoVentasCajasResumidos= mostrarnombre_completoVentasCajasResumidos;
	}

	public Boolean getActivarnombre_completoVentasCajasResumidos() {
		return this.activarnombre_completoVentasCajasResumidos;
	}

	public void setActivarnombre_completoVentasCajasResumidos(Boolean activarnombre_completoVentasCajasResumidos) {
		this.activarnombre_completoVentasCajasResumidos= activarnombre_completoVentasCajasResumidos;
	}

	public Border setResaltarfecha_emisionVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionVentasCajasResumidos() {
		return this.resaltarfecha_emisionVentasCajasResumidos;
	}

	public void setResaltarfecha_emisionVentasCajasResumidos(Border borderResaltar) {
		this.resaltarfecha_emisionVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionVentasCajasResumidos() {
		return this.mostrarfecha_emisionVentasCajasResumidos;
	}

	public void setMostrarfecha_emisionVentasCajasResumidos(Boolean mostrarfecha_emisionVentasCajasResumidos) {
		this.mostrarfecha_emisionVentasCajasResumidos= mostrarfecha_emisionVentasCajasResumidos;
	}

	public Boolean getActivarfecha_emisionVentasCajasResumidos() {
		return this.activarfecha_emisionVentasCajasResumidos;
	}

	public void setActivarfecha_emisionVentasCajasResumidos(Boolean activarfecha_emisionVentasCajasResumidos) {
		this.activarfecha_emisionVentasCajasResumidos= activarfecha_emisionVentasCajasResumidos;
	}

	public Border setResaltarnumero_pre_impresoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoVentasCajasResumidos() {
		return this.resaltarnumero_pre_impresoVentasCajasResumidos;
	}

	public void setResaltarnumero_pre_impresoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarnumero_pre_impresoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoVentasCajasResumidos() {
		return this.mostrarnumero_pre_impresoVentasCajasResumidos;
	}

	public void setMostrarnumero_pre_impresoVentasCajasResumidos(Boolean mostrarnumero_pre_impresoVentasCajasResumidos) {
		this.mostrarnumero_pre_impresoVentasCajasResumidos= mostrarnumero_pre_impresoVentasCajasResumidos;
	}

	public Boolean getActivarnumero_pre_impresoVentasCajasResumidos() {
		return this.activarnumero_pre_impresoVentasCajasResumidos;
	}

	public void setActivarnumero_pre_impresoVentasCajasResumidos(Boolean activarnumero_pre_impresoVentasCajasResumidos) {
		this.activarnumero_pre_impresoVentasCajasResumidos= activarnumero_pre_impresoVentasCajasResumidos;
	}

	public Border setResaltarnumero_documentoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoVentasCajasResumidos() {
		return this.resaltarnumero_documentoVentasCajasResumidos;
	}

	public void setResaltarnumero_documentoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarnumero_documentoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoVentasCajasResumidos() {
		return this.mostrarnumero_documentoVentasCajasResumidos;
	}

	public void setMostrarnumero_documentoVentasCajasResumidos(Boolean mostrarnumero_documentoVentasCajasResumidos) {
		this.mostrarnumero_documentoVentasCajasResumidos= mostrarnumero_documentoVentasCajasResumidos;
	}

	public Boolean getActivarnumero_documentoVentasCajasResumidos() {
		return this.activarnumero_documentoVentasCajasResumidos;
	}

	public void setActivarnumero_documentoVentasCajasResumidos(Boolean activarnumero_documentoVentasCajasResumidos) {
		this.activarnumero_documentoVentasCajasResumidos= activarnumero_documentoVentasCajasResumidos;
	}

	public Border setResaltartotalVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltartotalVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalVentasCajasResumidos() {
		return this.resaltartotalVentasCajasResumidos;
	}

	public void setResaltartotalVentasCajasResumidos(Border borderResaltar) {
		this.resaltartotalVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrartotalVentasCajasResumidos() {
		return this.mostrartotalVentasCajasResumidos;
	}

	public void setMostrartotalVentasCajasResumidos(Boolean mostrartotalVentasCajasResumidos) {
		this.mostrartotalVentasCajasResumidos= mostrartotalVentasCajasResumidos;
	}

	public Boolean getActivartotalVentasCajasResumidos() {
		return this.activartotalVentasCajasResumidos;
	}

	public void setActivartotalVentasCajasResumidos(Boolean activartotalVentasCajasResumidos) {
		this.activartotalVentasCajasResumidos= activartotalVentasCajasResumidos;
	}

	public Border setResaltarefectivoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarefectivoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarefectivoVentasCajasResumidos() {
		return this.resaltarefectivoVentasCajasResumidos;
	}

	public void setResaltarefectivoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarefectivoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarefectivoVentasCajasResumidos() {
		return this.mostrarefectivoVentasCajasResumidos;
	}

	public void setMostrarefectivoVentasCajasResumidos(Boolean mostrarefectivoVentasCajasResumidos) {
		this.mostrarefectivoVentasCajasResumidos= mostrarefectivoVentasCajasResumidos;
	}

	public Boolean getActivarefectivoVentasCajasResumidos() {
		return this.activarefectivoVentasCajasResumidos;
	}

	public void setActivarefectivoVentasCajasResumidos(Boolean activarefectivoVentasCajasResumidos) {
		this.activarefectivoVentasCajasResumidos= activarefectivoVentasCajasResumidos;
	}

	public Border setResaltartarjetaVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltartarjetaVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjetaVentasCajasResumidos() {
		return this.resaltartarjetaVentasCajasResumidos;
	}

	public void setResaltartarjetaVentasCajasResumidos(Border borderResaltar) {
		this.resaltartarjetaVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrartarjetaVentasCajasResumidos() {
		return this.mostrartarjetaVentasCajasResumidos;
	}

	public void setMostrartarjetaVentasCajasResumidos(Boolean mostrartarjetaVentasCajasResumidos) {
		this.mostrartarjetaVentasCajasResumidos= mostrartarjetaVentasCajasResumidos;
	}

	public Boolean getActivartarjetaVentasCajasResumidos() {
		return this.activartarjetaVentasCajasResumidos;
	}

	public void setActivartarjetaVentasCajasResumidos(Boolean activartarjetaVentasCajasResumidos) {
		this.activartarjetaVentasCajasResumidos= activartarjetaVentasCajasResumidos;
	}

	public Border setResaltarcreditoVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascajasresumidosBeanSwingJInternalFrame.jTtoolBarVentasCajasResumidos.setBorder(borderResaltar);
		
		this.resaltarcreditoVentasCajasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcreditoVentasCajasResumidos() {
		return this.resaltarcreditoVentasCajasResumidos;
	}

	public void setResaltarcreditoVentasCajasResumidos(Border borderResaltar) {
		this.resaltarcreditoVentasCajasResumidos= borderResaltar;
	}

	public Boolean getMostrarcreditoVentasCajasResumidos() {
		return this.mostrarcreditoVentasCajasResumidos;
	}

	public void setMostrarcreditoVentasCajasResumidos(Boolean mostrarcreditoVentasCajasResumidos) {
		this.mostrarcreditoVentasCajasResumidos= mostrarcreditoVentasCajasResumidos;
	}

	public Boolean getActivarcreditoVentasCajasResumidos() {
		return this.activarcreditoVentasCajasResumidos;
	}

	public void setActivarcreditoVentasCajasResumidos(Boolean activarcreditoVentasCajasResumidos) {
		this.activarcreditoVentasCajasResumidos= activarcreditoVentasCajasResumidos;
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
		
		
		this.setMostraridVentasCajasResumidos(esInicial);
		this.setMostrarid_empresaVentasCajasResumidos(esInicial);
		this.setMostrarid_sucursalVentasCajasResumidos(esInicial);
		this.setMostrarfecha_emision_desdeVentasCajasResumidos(esInicial);
		this.setMostrarfecha_emision_hastaVentasCajasResumidos(esInicial);
		this.setMostrarcodigoVentasCajasResumidos(esInicial);
		this.setMostrarnombre_completoVentasCajasResumidos(esInicial);
		this.setMostrarfecha_emisionVentasCajasResumidos(esInicial);
		this.setMostrarnumero_pre_impresoVentasCajasResumidos(esInicial);
		this.setMostrarnumero_documentoVentasCajasResumidos(esInicial);
		this.setMostrartotalVentasCajasResumidos(esInicial);
		this.setMostrarefectivoVentasCajasResumidos(esInicial);
		this.setMostrartarjetaVentasCajasResumidos(esInicial);
		this.setMostrarcreditoVentasCajasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.ID)) {
				this.setMostraridVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TOTAL)) {
				this.setMostrartotalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.EFECTIVO)) {
				this.setMostrarefectivoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TARJETA)) {
				this.setMostrartarjetaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CREDITO)) {
				this.setMostrarcreditoVentasCajasResumidos(esAsigna);
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
		
		
		this.setActivaridVentasCajasResumidos(esInicial);
		this.setActivarid_empresaVentasCajasResumidos(esInicial);
		this.setActivarid_sucursalVentasCajasResumidos(esInicial);
		this.setActivarfecha_emision_desdeVentasCajasResumidos(esInicial);
		this.setActivarfecha_emision_hastaVentasCajasResumidos(esInicial);
		this.setActivarcodigoVentasCajasResumidos(esInicial);
		this.setActivarnombre_completoVentasCajasResumidos(esInicial);
		this.setActivarfecha_emisionVentasCajasResumidos(esInicial);
		this.setActivarnumero_pre_impresoVentasCajasResumidos(esInicial);
		this.setActivarnumero_documentoVentasCajasResumidos(esInicial);
		this.setActivartotalVentasCajasResumidos(esInicial);
		this.setActivarefectivoVentasCajasResumidos(esInicial);
		this.setActivartarjetaVentasCajasResumidos(esInicial);
		this.setActivarcreditoVentasCajasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.ID)) {
				this.setActivaridVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TOTAL)) {
				this.setActivartotalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.EFECTIVO)) {
				this.setActivarefectivoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TARJETA)) {
				this.setActivartarjetaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CREDITO)) {
				this.setActivarcreditoVentasCajasResumidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasCajasResumidos(esInicial);
		this.setResaltarid_empresaVentasCajasResumidos(esInicial);
		this.setResaltarid_sucursalVentasCajasResumidos(esInicial);
		this.setResaltarfecha_emision_desdeVentasCajasResumidos(esInicial);
		this.setResaltarfecha_emision_hastaVentasCajasResumidos(esInicial);
		this.setResaltarcodigoVentasCajasResumidos(esInicial);
		this.setResaltarnombre_completoVentasCajasResumidos(esInicial);
		this.setResaltarfecha_emisionVentasCajasResumidos(esInicial);
		this.setResaltarnumero_pre_impresoVentasCajasResumidos(esInicial);
		this.setResaltarnumero_documentoVentasCajasResumidos(esInicial);
		this.setResaltartotalVentasCajasResumidos(esInicial);
		this.setResaltarefectivoVentasCajasResumidos(esInicial);
		this.setResaltartarjetaVentasCajasResumidos(esInicial);
		this.setResaltarcreditoVentasCajasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.ID)) {
				this.setResaltaridVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TOTAL)) {
				this.setResaltartotalVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.EFECTIVO)) {
				this.setResaltarefectivoVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.TARJETA)) {
				this.setResaltartarjetaVentasCajasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCajasResumidosConstantesFunciones.CREDITO)) {
				this.setResaltarcreditoVentasCajasResumidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasCajasResumidosVentasCajasResumidos=true;

	public Boolean getMostrarBusquedaVentasCajasResumidosVentasCajasResumidos() {
		return this.mostrarBusquedaVentasCajasResumidosVentasCajasResumidos;
	}

	public void setMostrarBusquedaVentasCajasResumidosVentasCajasResumidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasCajasResumidosVentasCajasResumidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasCajasResumidosVentasCajasResumidos=true;

	public Boolean getActivarBusquedaVentasCajasResumidosVentasCajasResumidos() {
		return this.activarBusquedaVentasCajasResumidosVentasCajasResumidos;
	}

	public void setActivarBusquedaVentasCajasResumidosVentasCajasResumidos(Boolean habilitarResaltar) {
		this.activarBusquedaVentasCajasResumidosVentasCajasResumidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasCajasResumidosVentasCajasResumidos=null;

	public Border getResaltarBusquedaVentasCajasResumidosVentasCajasResumidos() {
		return this.resaltarBusquedaVentasCajasResumidosVentasCajasResumidos;
	}

	public void setResaltarBusquedaVentasCajasResumidosVentasCajasResumidos(Border borderResaltar) {
		this.resaltarBusquedaVentasCajasResumidosVentasCajasResumidos= borderResaltar;
	}

	public void setResaltarBusquedaVentasCajasResumidosVentasCajasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCajasResumidosBeanSwingJInternalFrame ventascajasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasCajasResumidosVentasCajasResumidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
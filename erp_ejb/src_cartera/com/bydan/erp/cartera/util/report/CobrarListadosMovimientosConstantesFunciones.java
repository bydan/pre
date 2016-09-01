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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarListadosMovimientosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarListadosMovimientos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarListadosMovimientos"+CobrarListadosMovimientosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarListadosMovimientosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarListadosMovimientosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarListadosMovimientosConstantesFunciones.SCHEMA+"_"+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarListadosMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarListadosMovimientosConstantesFunciones.SCHEMA+"_"+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarListadosMovimientosConstantesFunciones.SCHEMA+"_"+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarListadosMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarListadosMovimientosConstantesFunciones.SCHEMA+"_"+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarListadosMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarListadosMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadosMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarListadosMovimientosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarListadosMovimientosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarListadosMovimientosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarListadosMovimientosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Listados Movimientoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Listados Movimientos";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Listados Movimientos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarListadosMovimientos";
	public static final String OBJECTNAME="cobrarlistadosmovimientos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_listados_movimientos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarlistadosmovimientos from "+CobrarListadosMovimientosConstantesFunciones.SPERSISTENCENAME+" cobrarlistadosmovimientos";
	public static String QUERYSELECTNATIVE="select "+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".id,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".version_row,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".codigo,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".nombre_transaccion,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".fecha_vence,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".fecha_emision,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".numero_comprobante,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".numero_factura,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".debito_mone_local,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".credito_mone_local,"+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME+".descripcion from "+CobrarListadosMovimientosConstantesFunciones.SCHEMA+"."+CobrarListadosMovimientosConstantesFunciones.TABLENAME;//+" as "+CobrarListadosMovimientosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarListadosMovimientosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.FECHAVENCE)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISION)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarListadosMovimientosConstantesFunciones.DESCRIPCION)) {sLabelColumna=CobrarListadosMovimientosConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarListadosMovimientosDescripcion(CobrarListadosMovimientos cobrarlistadosmovimientos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarlistadosmovimientos !=null/* && cobrarlistadosmovimientos.getId()!=0*/) {
			sDescripcion=cobrarlistadosmovimientos.getcodigo();//cobrarlistadosmovimientoscobrarlistadosmovimientos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarListadosMovimientosDescripcionDetallado(CobrarListadosMovimientos cobrarlistadosmovimientos) {
		String sDescripcion="";
			
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarlistadosmovimientos.getId().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarlistadosmovimientos.getVersionRow().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarlistadosmovimientos.getid_empresa().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=cobrarlistadosmovimientos.getfecha_emision_desde().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=cobrarlistadosmovimientos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarlistadosmovimientos.getcodigo()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarlistadosmovimientos.getnombre_completo()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=cobrarlistadosmovimientos.getnombre_transaccion()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=cobrarlistadosmovimientos.getfecha_vence().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=cobrarlistadosmovimientos.getfecha_emision().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=cobrarlistadosmovimientos.getnumero_comprobante()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=cobrarlistadosmovimientos.getnumero_factura()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=cobrarlistadosmovimientos.getdebito_mone_local().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=cobrarlistadosmovimientos.getcredito_mone_local().toString()+",";
		sDescripcion+=CobrarListadosMovimientosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cobrarlistadosmovimientos.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarListadosMovimientosDescripcion(CobrarListadosMovimientos cobrarlistadosmovimientos,String sValor) throws Exception {			
		if(cobrarlistadosmovimientos !=null) {
			cobrarlistadosmovimientos.setcodigo(sValor);;//cobrarlistadosmovimientoscobrarlistadosmovimientos.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarListadosMovimientos")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarListadosMovimientos(Date fecha_emision_desde,Date fecha_emision_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarlistadosmovimientos.setcodigo(cobrarlistadosmovimientos.getcodigo().trim());
		cobrarlistadosmovimientos.setnombre_completo(cobrarlistadosmovimientos.getnombre_completo().trim());
		cobrarlistadosmovimientos.setnombre_transaccion(cobrarlistadosmovimientos.getnombre_transaccion().trim());
		cobrarlistadosmovimientos.setnumero_comprobante(cobrarlistadosmovimientos.getnumero_comprobante().trim());
		cobrarlistadosmovimientos.setnumero_factura(cobrarlistadosmovimientos.getnumero_factura().trim());
		cobrarlistadosmovimientos.setdescripcion(cobrarlistadosmovimientos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarListadosMovimientoss(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {
			cobrarlistadosmovimientos.setcodigo(cobrarlistadosmovimientos.getcodigo().trim());
			cobrarlistadosmovimientos.setnombre_completo(cobrarlistadosmovimientos.getnombre_completo().trim());
			cobrarlistadosmovimientos.setnombre_transaccion(cobrarlistadosmovimientos.getnombre_transaccion().trim());
			cobrarlistadosmovimientos.setnumero_comprobante(cobrarlistadosmovimientos.getnumero_comprobante().trim());
			cobrarlistadosmovimientos.setnumero_factura(cobrarlistadosmovimientos.getnumero_factura().trim());
			cobrarlistadosmovimientos.setdescripcion(cobrarlistadosmovimientos.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarlistadosmovimientos.getConCambioAuxiliar()) {
			cobrarlistadosmovimientos.setIsDeleted(cobrarlistadosmovimientos.getIsDeletedAuxiliar());	
			cobrarlistadosmovimientos.setIsNew(cobrarlistadosmovimientos.getIsNewAuxiliar());	
			cobrarlistadosmovimientos.setIsChanged(cobrarlistadosmovimientos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarlistadosmovimientos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarlistadosmovimientos.setIsDeletedAuxiliar(false);	
			cobrarlistadosmovimientos.setIsNewAuxiliar(false);	
			cobrarlistadosmovimientos.setIsChangedAuxiliar(false);
			
			cobrarlistadosmovimientos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarListadosMovimientoss(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos : cobrarlistadosmovimientoss) {
			if(conAsignarBase && cobrarlistadosmovimientos.getConCambioAuxiliar()) {
				cobrarlistadosmovimientos.setIsDeleted(cobrarlistadosmovimientos.getIsDeletedAuxiliar());	
				cobrarlistadosmovimientos.setIsNew(cobrarlistadosmovimientos.getIsNewAuxiliar());	
				cobrarlistadosmovimientos.setIsChanged(cobrarlistadosmovimientos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarlistadosmovimientos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarlistadosmovimientos.setIsDeletedAuxiliar(false);	
				cobrarlistadosmovimientos.setIsNewAuxiliar(false);	
				cobrarlistadosmovimientos.setIsChangedAuxiliar(false);
				
				cobrarlistadosmovimientos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientos,Boolean conEnteros) throws Exception  {
		cobrarlistadosmovimientos.setdebito_mone_local(0.0);
		cobrarlistadosmovimientos.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarListadosMovimientoss(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {
			cobrarlistadosmovimientos.setdebito_mone_local(0.0);
			cobrarlistadosmovimientos.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarListadosMovimientos(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,CobrarListadosMovimientos cobrarlistadosmovimientosAux) throws Exception  {
		CobrarListadosMovimientosConstantesFunciones.InicializarValoresCobrarListadosMovimientos(cobrarlistadosmovimientosAux,true);
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {
			if(cobrarlistadosmovimientos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarlistadosmovimientosAux.setdebito_mone_local(cobrarlistadosmovimientosAux.getdebito_mone_local()+cobrarlistadosmovimientos.getdebito_mone_local());			
			cobrarlistadosmovimientosAux.setcredito_mone_local(cobrarlistadosmovimientosAux.getcredito_mone_local()+cobrarlistadosmovimientos.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadosMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarListadosMovimientosConstantesFunciones.getArrayColumnasGlobalesCobrarListadosMovimientos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadosMovimientos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarListadosMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,CobrarListadosMovimientos cobrarlistadosmovimientos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientosAux: cobrarlistadosmovimientoss) {
			if(cobrarlistadosmovimientosAux!=null && cobrarlistadosmovimientos!=null) {
				if((cobrarlistadosmovimientosAux.getId()==null && cobrarlistadosmovimientos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarlistadosmovimientosAux.getId()!=null && cobrarlistadosmovimientos.getId()!=null){
					if(cobrarlistadosmovimientosAux.getId().equals(cobrarlistadosmovimientos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarListadosMovimientos(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {			
			if(cobrarlistadosmovimientos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=cobrarlistadosmovimientos.getdebito_mone_local();
			credito_mone_localTotal+=cobrarlistadosmovimientos.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarListadosMovimientos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_ID, CobrarListadosMovimientosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_VERSIONROW, CobrarListadosMovimientosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_CODIGO, CobrarListadosMovimientosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION, CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAVENCE, CobrarListadosMovimientosConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISION, CobrarListadosMovimientosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROFACTURA, CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL, CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL, CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadosMovimientosConstantesFunciones.LABEL_DESCRIPCION, CobrarListadosMovimientosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarListadosMovimientos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadosMovimientosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadosMovimientos() throws Exception  {
		return CobrarListadosMovimientosConstantesFunciones.getTiposSeleccionarCobrarListadosMovimientos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadosMovimientos(Boolean conFk) throws Exception  {
		return CobrarListadosMovimientosConstantesFunciones.getTiposSeleccionarCobrarListadosMovimientos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadosMovimientos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadosMovimientosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarListadosMovimientos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientosAux) throws Exception {
		
			cobrarlistadosmovimientosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarlistadosmovimientosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarListadosMovimientos(List<CobrarListadosMovimientos> cobrarlistadosmovimientossTemp) throws Exception {
		for(CobrarListadosMovimientos cobrarlistadosmovimientosAux:cobrarlistadosmovimientossTemp) {
			
			cobrarlistadosmovimientosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarlistadosmovimientosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarListadosMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarListadosMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarListadosMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarListadosMovimientosConstantesFunciones.getClassesRelationshipsOfCobrarListadosMovimientos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarListadosMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarListadosMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarListadosMovimientosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarListadosMovimientos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarListadosMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarListadosMovimientos cobrarlistadosmovimientos,List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarListadosMovimientos cobrarlistadosmovimientos,List<CobrarListadosMovimientos> cobrarlistadosmovimientoss) throws Exception {
		try	{			
			for(CobrarListadosMovimientos cobrarlistadosmovimientosLocal:cobrarlistadosmovimientoss) {
				if(cobrarlistadosmovimientosLocal.getId().equals(cobrarlistadosmovimientos.getId())) {
					cobrarlistadosmovimientosLocal.setIsSelected(cobrarlistadosmovimientos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarListadosMovimientos(List<CobrarListadosMovimientos> cobrarlistadosmovimientossAux) throws Exception {
		//this.cobrarlistadosmovimientossAux=cobrarlistadosmovimientossAux;
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientosAux:cobrarlistadosmovimientossAux) {
			if(cobrarlistadosmovimientosAux.getIsChanged()) {
				cobrarlistadosmovimientosAux.setIsChanged(false);
			}		
			
			if(cobrarlistadosmovimientosAux.getIsNew()) {
				cobrarlistadosmovimientosAux.setIsNew(false);
			}	
			
			if(cobrarlistadosmovimientosAux.getIsDeleted()) {
				cobrarlistadosmovimientosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientosAux) throws Exception {
		//this.cobrarlistadosmovimientosAux=cobrarlistadosmovimientosAux;
		
			if(cobrarlistadosmovimientosAux.getIsChanged()) {
				cobrarlistadosmovimientosAux.setIsChanged(false);
			}		
			
			if(cobrarlistadosmovimientosAux.getIsNew()) {
				cobrarlistadosmovimientosAux.setIsNew(false);
			}	
			
			if(cobrarlistadosmovimientosAux.getIsDeleted()) {
				cobrarlistadosmovimientosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarListadosMovimientos cobrarlistadosmovimientosAsignar,CobrarListadosMovimientos cobrarlistadosmovimientos) throws Exception {
		cobrarlistadosmovimientosAsignar.setId(cobrarlistadosmovimientos.getId());	
		cobrarlistadosmovimientosAsignar.setVersionRow(cobrarlistadosmovimientos.getVersionRow());	
		cobrarlistadosmovimientosAsignar.setcodigo(cobrarlistadosmovimientos.getcodigo());	
		cobrarlistadosmovimientosAsignar.setnombre_completo(cobrarlistadosmovimientos.getnombre_completo());	
		cobrarlistadosmovimientosAsignar.setnombre_transaccion(cobrarlistadosmovimientos.getnombre_transaccion());	
		cobrarlistadosmovimientosAsignar.setfecha_vence(cobrarlistadosmovimientos.getfecha_vence());	
		cobrarlistadosmovimientosAsignar.setfecha_emision(cobrarlistadosmovimientos.getfecha_emision());	
		cobrarlistadosmovimientosAsignar.setnumero_comprobante(cobrarlistadosmovimientos.getnumero_comprobante());	
		cobrarlistadosmovimientosAsignar.setnumero_factura(cobrarlistadosmovimientos.getnumero_factura());	
		cobrarlistadosmovimientosAsignar.setdebito_mone_local(cobrarlistadosmovimientos.getdebito_mone_local());	
		cobrarlistadosmovimientosAsignar.setcredito_mone_local(cobrarlistadosmovimientos.getcredito_mone_local());	
		cobrarlistadosmovimientosAsignar.setdescripcion(cobrarlistadosmovimientos.getdescripcion());	
	}
	
	public static void inicializarCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientos) throws Exception {
		try {
				cobrarlistadosmovimientos.setId(0L);	
					
				cobrarlistadosmovimientos.setcodigo("");	
				cobrarlistadosmovimientos.setnombre_completo("");	
				cobrarlistadosmovimientos.setnombre_transaccion("");	
				cobrarlistadosmovimientos.setfecha_vence(new Date());	
				cobrarlistadosmovimientos.setfecha_emision(new Date());	
				cobrarlistadosmovimientos.setnumero_comprobante("");	
				cobrarlistadosmovimientos.setnumero_factura("");	
				cobrarlistadosmovimientos.setdebito_mone_local(0.0);	
				cobrarlistadosmovimientos.setcredito_mone_local(0.0);	
				cobrarlistadosmovimientos.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarListadosMovimientos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadosMovimientosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarListadosMovimientos(String sTipo,Row row,Workbook workbook,CobrarListadosMovimientos cobrarlistadosmovimientos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadosmovimientos.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarListadosMovimientos="";
	
	public String getsFinalQueryCobrarListadosMovimientos() {
		return this.sFinalQueryCobrarListadosMovimientos;
	}
	
	public void setsFinalQueryCobrarListadosMovimientos(String sFinalQueryCobrarListadosMovimientos) {
		this.sFinalQueryCobrarListadosMovimientos= sFinalQueryCobrarListadosMovimientos;
	}
	
	public Border resaltarSeleccionarCobrarListadosMovimientos=null;
	
	public Border setResaltarSeleccionarCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarListadosMovimientos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarListadosMovimientos() {
		return this.resaltarSeleccionarCobrarListadosMovimientos;
	}
	
	public void setResaltarSeleccionarCobrarListadosMovimientos(Border borderResaltarSeleccionarCobrarListadosMovimientos) {
		this.resaltarSeleccionarCobrarListadosMovimientos= borderResaltarSeleccionarCobrarListadosMovimientos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarListadosMovimientos=null;
	public Boolean mostraridCobrarListadosMovimientos=true;
	public Boolean activaridCobrarListadosMovimientos=true;

	public Border resaltarid_empresaCobrarListadosMovimientos=null;
	public Boolean mostrarid_empresaCobrarListadosMovimientos=true;
	public Boolean activarid_empresaCobrarListadosMovimientos=true;
	public Boolean cargarid_empresaCobrarListadosMovimientos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarListadosMovimientos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeCobrarListadosMovimientos=null;
	public Boolean mostrarfecha_emision_desdeCobrarListadosMovimientos=true;
	public Boolean activarfecha_emision_desdeCobrarListadosMovimientos=true;

	public Border resaltarfecha_emision_hastaCobrarListadosMovimientos=null;
	public Boolean mostrarfecha_emision_hastaCobrarListadosMovimientos=true;
	public Boolean activarfecha_emision_hastaCobrarListadosMovimientos=true;

	public Border resaltarcodigoCobrarListadosMovimientos=null;
	public Boolean mostrarcodigoCobrarListadosMovimientos=true;
	public Boolean activarcodigoCobrarListadosMovimientos=true;

	public Border resaltarnombre_completoCobrarListadosMovimientos=null;
	public Boolean mostrarnombre_completoCobrarListadosMovimientos=true;
	public Boolean activarnombre_completoCobrarListadosMovimientos=true;

	public Border resaltarnombre_transaccionCobrarListadosMovimientos=null;
	public Boolean mostrarnombre_transaccionCobrarListadosMovimientos=true;
	public Boolean activarnombre_transaccionCobrarListadosMovimientos=true;

	public Border resaltarfecha_venceCobrarListadosMovimientos=null;
	public Boolean mostrarfecha_venceCobrarListadosMovimientos=true;
	public Boolean activarfecha_venceCobrarListadosMovimientos=true;

	public Border resaltarfecha_emisionCobrarListadosMovimientos=null;
	public Boolean mostrarfecha_emisionCobrarListadosMovimientos=true;
	public Boolean activarfecha_emisionCobrarListadosMovimientos=true;

	public Border resaltarnumero_comprobanteCobrarListadosMovimientos=null;
	public Boolean mostrarnumero_comprobanteCobrarListadosMovimientos=true;
	public Boolean activarnumero_comprobanteCobrarListadosMovimientos=true;

	public Border resaltarnumero_facturaCobrarListadosMovimientos=null;
	public Boolean mostrarnumero_facturaCobrarListadosMovimientos=true;
	public Boolean activarnumero_facturaCobrarListadosMovimientos=true;

	public Border resaltardebito_mone_localCobrarListadosMovimientos=null;
	public Boolean mostrardebito_mone_localCobrarListadosMovimientos=true;
	public Boolean activardebito_mone_localCobrarListadosMovimientos=true;

	public Border resaltarcredito_mone_localCobrarListadosMovimientos=null;
	public Boolean mostrarcredito_mone_localCobrarListadosMovimientos=true;
	public Boolean activarcredito_mone_localCobrarListadosMovimientos=true;

	public Border resaltardescripcionCobrarListadosMovimientos=null;
	public Boolean mostrardescripcionCobrarListadosMovimientos=true;
	public Boolean activardescripcionCobrarListadosMovimientos=true;

	
	

	public Border setResaltaridCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltaridCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarListadosMovimientos() {
		return this.resaltaridCobrarListadosMovimientos;
	}

	public void setResaltaridCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltaridCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostraridCobrarListadosMovimientos() {
		return this.mostraridCobrarListadosMovimientos;
	}

	public void setMostraridCobrarListadosMovimientos(Boolean mostraridCobrarListadosMovimientos) {
		this.mostraridCobrarListadosMovimientos= mostraridCobrarListadosMovimientos;
	}

	public Boolean getActivaridCobrarListadosMovimientos() {
		return this.activaridCobrarListadosMovimientos;
	}

	public void setActivaridCobrarListadosMovimientos(Boolean activaridCobrarListadosMovimientos) {
		this.activaridCobrarListadosMovimientos= activaridCobrarListadosMovimientos;
	}

	public Border setResaltarid_empresaCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarListadosMovimientos() {
		return this.resaltarid_empresaCobrarListadosMovimientos;
	}

	public void setResaltarid_empresaCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarid_empresaCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarListadosMovimientos() {
		return this.mostrarid_empresaCobrarListadosMovimientos;
	}

	public void setMostrarid_empresaCobrarListadosMovimientos(Boolean mostrarid_empresaCobrarListadosMovimientos) {
		this.mostrarid_empresaCobrarListadosMovimientos= mostrarid_empresaCobrarListadosMovimientos;
	}

	public Boolean getActivarid_empresaCobrarListadosMovimientos() {
		return this.activarid_empresaCobrarListadosMovimientos;
	}

	public void setActivarid_empresaCobrarListadosMovimientos(Boolean activarid_empresaCobrarListadosMovimientos) {
		this.activarid_empresaCobrarListadosMovimientos= activarid_empresaCobrarListadosMovimientos;
	}

	public Boolean getCargarid_empresaCobrarListadosMovimientos() {
		return this.cargarid_empresaCobrarListadosMovimientos;
	}

	public void setCargarid_empresaCobrarListadosMovimientos(Boolean cargarid_empresaCobrarListadosMovimientos) {
		this.cargarid_empresaCobrarListadosMovimientos= cargarid_empresaCobrarListadosMovimientos;
	}

	public Border setResaltarfecha_emision_desdeCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeCobrarListadosMovimientos() {
		return this.resaltarfecha_emision_desdeCobrarListadosMovimientos;
	}

	public void setResaltarfecha_emision_desdeCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeCobrarListadosMovimientos() {
		return this.mostrarfecha_emision_desdeCobrarListadosMovimientos;
	}

	public void setMostrarfecha_emision_desdeCobrarListadosMovimientos(Boolean mostrarfecha_emision_desdeCobrarListadosMovimientos) {
		this.mostrarfecha_emision_desdeCobrarListadosMovimientos= mostrarfecha_emision_desdeCobrarListadosMovimientos;
	}

	public Boolean getActivarfecha_emision_desdeCobrarListadosMovimientos() {
		return this.activarfecha_emision_desdeCobrarListadosMovimientos;
	}

	public void setActivarfecha_emision_desdeCobrarListadosMovimientos(Boolean activarfecha_emision_desdeCobrarListadosMovimientos) {
		this.activarfecha_emision_desdeCobrarListadosMovimientos= activarfecha_emision_desdeCobrarListadosMovimientos;
	}

	public Border setResaltarfecha_emision_hastaCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaCobrarListadosMovimientos() {
		return this.resaltarfecha_emision_hastaCobrarListadosMovimientos;
	}

	public void setResaltarfecha_emision_hastaCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaCobrarListadosMovimientos() {
		return this.mostrarfecha_emision_hastaCobrarListadosMovimientos;
	}

	public void setMostrarfecha_emision_hastaCobrarListadosMovimientos(Boolean mostrarfecha_emision_hastaCobrarListadosMovimientos) {
		this.mostrarfecha_emision_hastaCobrarListadosMovimientos= mostrarfecha_emision_hastaCobrarListadosMovimientos;
	}

	public Boolean getActivarfecha_emision_hastaCobrarListadosMovimientos() {
		return this.activarfecha_emision_hastaCobrarListadosMovimientos;
	}

	public void setActivarfecha_emision_hastaCobrarListadosMovimientos(Boolean activarfecha_emision_hastaCobrarListadosMovimientos) {
		this.activarfecha_emision_hastaCobrarListadosMovimientos= activarfecha_emision_hastaCobrarListadosMovimientos;
	}

	public Border setResaltarcodigoCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarListadosMovimientos() {
		return this.resaltarcodigoCobrarListadosMovimientos;
	}

	public void setResaltarcodigoCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarcodigoCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarListadosMovimientos() {
		return this.mostrarcodigoCobrarListadosMovimientos;
	}

	public void setMostrarcodigoCobrarListadosMovimientos(Boolean mostrarcodigoCobrarListadosMovimientos) {
		this.mostrarcodigoCobrarListadosMovimientos= mostrarcodigoCobrarListadosMovimientos;
	}

	public Boolean getActivarcodigoCobrarListadosMovimientos() {
		return this.activarcodigoCobrarListadosMovimientos;
	}

	public void setActivarcodigoCobrarListadosMovimientos(Boolean activarcodigoCobrarListadosMovimientos) {
		this.activarcodigoCobrarListadosMovimientos= activarcodigoCobrarListadosMovimientos;
	}

	public Border setResaltarnombre_completoCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarListadosMovimientos() {
		return this.resaltarnombre_completoCobrarListadosMovimientos;
	}

	public void setResaltarnombre_completoCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarnombre_completoCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarListadosMovimientos() {
		return this.mostrarnombre_completoCobrarListadosMovimientos;
	}

	public void setMostrarnombre_completoCobrarListadosMovimientos(Boolean mostrarnombre_completoCobrarListadosMovimientos) {
		this.mostrarnombre_completoCobrarListadosMovimientos= mostrarnombre_completoCobrarListadosMovimientos;
	}

	public Boolean getActivarnombre_completoCobrarListadosMovimientos() {
		return this.activarnombre_completoCobrarListadosMovimientos;
	}

	public void setActivarnombre_completoCobrarListadosMovimientos(Boolean activarnombre_completoCobrarListadosMovimientos) {
		this.activarnombre_completoCobrarListadosMovimientos= activarnombre_completoCobrarListadosMovimientos;
	}

	public Border setResaltarnombre_transaccionCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionCobrarListadosMovimientos() {
		return this.resaltarnombre_transaccionCobrarListadosMovimientos;
	}

	public void setResaltarnombre_transaccionCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarnombre_transaccionCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionCobrarListadosMovimientos() {
		return this.mostrarnombre_transaccionCobrarListadosMovimientos;
	}

	public void setMostrarnombre_transaccionCobrarListadosMovimientos(Boolean mostrarnombre_transaccionCobrarListadosMovimientos) {
		this.mostrarnombre_transaccionCobrarListadosMovimientos= mostrarnombre_transaccionCobrarListadosMovimientos;
	}

	public Boolean getActivarnombre_transaccionCobrarListadosMovimientos() {
		return this.activarnombre_transaccionCobrarListadosMovimientos;
	}

	public void setActivarnombre_transaccionCobrarListadosMovimientos(Boolean activarnombre_transaccionCobrarListadosMovimientos) {
		this.activarnombre_transaccionCobrarListadosMovimientos= activarnombre_transaccionCobrarListadosMovimientos;
	}

	public Border setResaltarfecha_venceCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_venceCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceCobrarListadosMovimientos() {
		return this.resaltarfecha_venceCobrarListadosMovimientos;
	}

	public void setResaltarfecha_venceCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarfecha_venceCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_venceCobrarListadosMovimientos() {
		return this.mostrarfecha_venceCobrarListadosMovimientos;
	}

	public void setMostrarfecha_venceCobrarListadosMovimientos(Boolean mostrarfecha_venceCobrarListadosMovimientos) {
		this.mostrarfecha_venceCobrarListadosMovimientos= mostrarfecha_venceCobrarListadosMovimientos;
	}

	public Boolean getActivarfecha_venceCobrarListadosMovimientos() {
		return this.activarfecha_venceCobrarListadosMovimientos;
	}

	public void setActivarfecha_venceCobrarListadosMovimientos(Boolean activarfecha_venceCobrarListadosMovimientos) {
		this.activarfecha_venceCobrarListadosMovimientos= activarfecha_venceCobrarListadosMovimientos;
	}

	public Border setResaltarfecha_emisionCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionCobrarListadosMovimientos() {
		return this.resaltarfecha_emisionCobrarListadosMovimientos;
	}

	public void setResaltarfecha_emisionCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarfecha_emisionCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionCobrarListadosMovimientos() {
		return this.mostrarfecha_emisionCobrarListadosMovimientos;
	}

	public void setMostrarfecha_emisionCobrarListadosMovimientos(Boolean mostrarfecha_emisionCobrarListadosMovimientos) {
		this.mostrarfecha_emisionCobrarListadosMovimientos= mostrarfecha_emisionCobrarListadosMovimientos;
	}

	public Boolean getActivarfecha_emisionCobrarListadosMovimientos() {
		return this.activarfecha_emisionCobrarListadosMovimientos;
	}

	public void setActivarfecha_emisionCobrarListadosMovimientos(Boolean activarfecha_emisionCobrarListadosMovimientos) {
		this.activarfecha_emisionCobrarListadosMovimientos= activarfecha_emisionCobrarListadosMovimientos;
	}

	public Border setResaltarnumero_comprobanteCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCobrarListadosMovimientos() {
		return this.resaltarnumero_comprobanteCobrarListadosMovimientos;
	}

	public void setResaltarnumero_comprobanteCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarnumero_comprobanteCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCobrarListadosMovimientos() {
		return this.mostrarnumero_comprobanteCobrarListadosMovimientos;
	}

	public void setMostrarnumero_comprobanteCobrarListadosMovimientos(Boolean mostrarnumero_comprobanteCobrarListadosMovimientos) {
		this.mostrarnumero_comprobanteCobrarListadosMovimientos= mostrarnumero_comprobanteCobrarListadosMovimientos;
	}

	public Boolean getActivarnumero_comprobanteCobrarListadosMovimientos() {
		return this.activarnumero_comprobanteCobrarListadosMovimientos;
	}

	public void setActivarnumero_comprobanteCobrarListadosMovimientos(Boolean activarnumero_comprobanteCobrarListadosMovimientos) {
		this.activarnumero_comprobanteCobrarListadosMovimientos= activarnumero_comprobanteCobrarListadosMovimientos;
	}

	public Border setResaltarnumero_facturaCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaCobrarListadosMovimientos() {
		return this.resaltarnumero_facturaCobrarListadosMovimientos;
	}

	public void setResaltarnumero_facturaCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarnumero_facturaCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaCobrarListadosMovimientos() {
		return this.mostrarnumero_facturaCobrarListadosMovimientos;
	}

	public void setMostrarnumero_facturaCobrarListadosMovimientos(Boolean mostrarnumero_facturaCobrarListadosMovimientos) {
		this.mostrarnumero_facturaCobrarListadosMovimientos= mostrarnumero_facturaCobrarListadosMovimientos;
	}

	public Boolean getActivarnumero_facturaCobrarListadosMovimientos() {
		return this.activarnumero_facturaCobrarListadosMovimientos;
	}

	public void setActivarnumero_facturaCobrarListadosMovimientos(Boolean activarnumero_facturaCobrarListadosMovimientos) {
		this.activarnumero_facturaCobrarListadosMovimientos= activarnumero_facturaCobrarListadosMovimientos;
	}

	public Border setResaltardebito_mone_localCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localCobrarListadosMovimientos() {
		return this.resaltardebito_mone_localCobrarListadosMovimientos;
	}

	public void setResaltardebito_mone_localCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltardebito_mone_localCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localCobrarListadosMovimientos() {
		return this.mostrardebito_mone_localCobrarListadosMovimientos;
	}

	public void setMostrardebito_mone_localCobrarListadosMovimientos(Boolean mostrardebito_mone_localCobrarListadosMovimientos) {
		this.mostrardebito_mone_localCobrarListadosMovimientos= mostrardebito_mone_localCobrarListadosMovimientos;
	}

	public Boolean getActivardebito_mone_localCobrarListadosMovimientos() {
		return this.activardebito_mone_localCobrarListadosMovimientos;
	}

	public void setActivardebito_mone_localCobrarListadosMovimientos(Boolean activardebito_mone_localCobrarListadosMovimientos) {
		this.activardebito_mone_localCobrarListadosMovimientos= activardebito_mone_localCobrarListadosMovimientos;
	}

	public Border setResaltarcredito_mone_localCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localCobrarListadosMovimientos() {
		return this.resaltarcredito_mone_localCobrarListadosMovimientos;
	}

	public void setResaltarcredito_mone_localCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarcredito_mone_localCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localCobrarListadosMovimientos() {
		return this.mostrarcredito_mone_localCobrarListadosMovimientos;
	}

	public void setMostrarcredito_mone_localCobrarListadosMovimientos(Boolean mostrarcredito_mone_localCobrarListadosMovimientos) {
		this.mostrarcredito_mone_localCobrarListadosMovimientos= mostrarcredito_mone_localCobrarListadosMovimientos;
	}

	public Boolean getActivarcredito_mone_localCobrarListadosMovimientos() {
		return this.activarcredito_mone_localCobrarListadosMovimientos;
	}

	public void setActivarcredito_mone_localCobrarListadosMovimientos(Boolean activarcredito_mone_localCobrarListadosMovimientos) {
		this.activarcredito_mone_localCobrarListadosMovimientos= activarcredito_mone_localCobrarListadosMovimientos;
	}

	public Border setResaltardescripcionCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadosmovimientosBeanSwingJInternalFrame.jTtoolBarCobrarListadosMovimientos.setBorder(borderResaltar);
		
		this.resaltardescripcionCobrarListadosMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCobrarListadosMovimientos() {
		return this.resaltardescripcionCobrarListadosMovimientos;
	}

	public void setResaltardescripcionCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltardescripcionCobrarListadosMovimientos= borderResaltar;
	}

	public Boolean getMostrardescripcionCobrarListadosMovimientos() {
		return this.mostrardescripcionCobrarListadosMovimientos;
	}

	public void setMostrardescripcionCobrarListadosMovimientos(Boolean mostrardescripcionCobrarListadosMovimientos) {
		this.mostrardescripcionCobrarListadosMovimientos= mostrardescripcionCobrarListadosMovimientos;
	}

	public Boolean getActivardescripcionCobrarListadosMovimientos() {
		return this.activardescripcionCobrarListadosMovimientos;
	}

	public void setActivardescripcionCobrarListadosMovimientos(Boolean activardescripcionCobrarListadosMovimientos) {
		this.activardescripcionCobrarListadosMovimientos= activardescripcionCobrarListadosMovimientos;
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
		
		
		this.setMostraridCobrarListadosMovimientos(esInicial);
		this.setMostrarid_empresaCobrarListadosMovimientos(esInicial);
		this.setMostrarfecha_emision_desdeCobrarListadosMovimientos(esInicial);
		this.setMostrarfecha_emision_hastaCobrarListadosMovimientos(esInicial);
		this.setMostrarcodigoCobrarListadosMovimientos(esInicial);
		this.setMostrarnombre_completoCobrarListadosMovimientos(esInicial);
		this.setMostrarnombre_transaccionCobrarListadosMovimientos(esInicial);
		this.setMostrarfecha_venceCobrarListadosMovimientos(esInicial);
		this.setMostrarfecha_emisionCobrarListadosMovimientos(esInicial);
		this.setMostrarnumero_comprobanteCobrarListadosMovimientos(esInicial);
		this.setMostrarnumero_facturaCobrarListadosMovimientos(esInicial);
		this.setMostrardebito_mone_localCobrarListadosMovimientos(esInicial);
		this.setMostrarcredito_mone_localCobrarListadosMovimientos(esInicial);
		this.setMostrardescripcionCobrarListadosMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.ID)) {
				this.setMostraridCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCobrarListadosMovimientos(esAsigna);
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
		
		
		this.setActivaridCobrarListadosMovimientos(esInicial);
		this.setActivarid_empresaCobrarListadosMovimientos(esInicial);
		this.setActivarfecha_emision_desdeCobrarListadosMovimientos(esInicial);
		this.setActivarfecha_emision_hastaCobrarListadosMovimientos(esInicial);
		this.setActivarcodigoCobrarListadosMovimientos(esInicial);
		this.setActivarnombre_completoCobrarListadosMovimientos(esInicial);
		this.setActivarnombre_transaccionCobrarListadosMovimientos(esInicial);
		this.setActivarfecha_venceCobrarListadosMovimientos(esInicial);
		this.setActivarfecha_emisionCobrarListadosMovimientos(esInicial);
		this.setActivarnumero_comprobanteCobrarListadosMovimientos(esInicial);
		this.setActivarnumero_facturaCobrarListadosMovimientos(esInicial);
		this.setActivardebito_mone_localCobrarListadosMovimientos(esInicial);
		this.setActivarcredito_mone_localCobrarListadosMovimientos(esInicial);
		this.setActivardescripcionCobrarListadosMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.ID)) {
				this.setActivaridCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCobrarListadosMovimientos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarListadosMovimientos(esInicial);
		this.setResaltarid_empresaCobrarListadosMovimientos(esInicial);
		this.setResaltarfecha_emision_desdeCobrarListadosMovimientos(esInicial);
		this.setResaltarfecha_emision_hastaCobrarListadosMovimientos(esInicial);
		this.setResaltarcodigoCobrarListadosMovimientos(esInicial);
		this.setResaltarnombre_completoCobrarListadosMovimientos(esInicial);
		this.setResaltarnombre_transaccionCobrarListadosMovimientos(esInicial);
		this.setResaltarfecha_venceCobrarListadosMovimientos(esInicial);
		this.setResaltarfecha_emisionCobrarListadosMovimientos(esInicial);
		this.setResaltarnumero_comprobanteCobrarListadosMovimientos(esInicial);
		this.setResaltarnumero_facturaCobrarListadosMovimientos(esInicial);
		this.setResaltardebito_mone_localCobrarListadosMovimientos(esInicial);
		this.setResaltarcredito_mone_localCobrarListadosMovimientos(esInicial);
		this.setResaltardescripcionCobrarListadosMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.ID)) {
				this.setResaltaridCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localCobrarListadosMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadosMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCobrarListadosMovimientos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos=true;

	public Boolean getMostrarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos() {
		return this.mostrarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos;
	}

	public void setMostrarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos=true;

	public Boolean getActivarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos() {
		return this.activarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos;
	}

	public void setActivarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos=null;

	public Border getResaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos() {
		return this.resaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos;
	}

	public void setResaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos(Border borderResaltar) {
		this.resaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos= borderResaltar;
	}

	public void setResaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadosMovimientosBeanSwingJInternalFrame cobrarlistadosmovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarListadosMovimientosCobrarListadosMovimientos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
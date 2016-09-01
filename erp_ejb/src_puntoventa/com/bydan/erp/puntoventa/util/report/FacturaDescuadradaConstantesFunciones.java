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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.FacturaDescuadradaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.FacturaDescuadradaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.FacturaDescuadradaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaDescuadradaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturaDescuadrada";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaDescuadrada"+FacturaDescuadradaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaDescuadradaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaDescuadradaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaDescuadradaConstantesFunciones.SCHEMA+"_"+FacturaDescuadradaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaDescuadradaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaDescuadradaConstantesFunciones.SCHEMA+"_"+FacturaDescuadradaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaDescuadradaConstantesFunciones.SCHEMA+"_"+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaDescuadradaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaDescuadradaConstantesFunciones.SCHEMA+"_"+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaDescuadradaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaDescuadradaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaDescuadradaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaDescuadradaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaDescuadradaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaDescuadradaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaDescuadradaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Descuadradas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura Descuadrada";
	public static final String SCLASSWEBTITULO_LOWER="Factura Descuadrada";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaDescuadrada";
	public static final String OBJECTNAME="facturadescuadrada";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="factura_descuadrada";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturadescuadrada from "+FacturaDescuadradaConstantesFunciones.SPERSISTENCENAME+" facturadescuadrada";
	public static String QUERYSELECTNATIVE="select "+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".id,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".version_row,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".id_empresa,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".fecha_inicio,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".fecha_fin,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".secuencial,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".fecha,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".subtotal,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".iva,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".descuento,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".financiamiento,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".flete,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".ice,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".total,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".total_formas_pago,"+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME+".descuento_real from "+FacturaDescuadradaConstantesFunciones.SCHEMA+"."+FacturaDescuadradaConstantesFunciones.TABLENAME;//+" as "+FacturaDescuadradaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String SUBTOTAL= "subtotal";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
    public static final String TOTALFORMASPAGO= "total_formas_pago";
    public static final String DESCUENTOREAL= "descuento_real";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_TOTALFORMASPAGO= "Total Formas Pago";
		public static final String LABEL_TOTALFORMASPAGO_LOWER= "Total Formas Pago";
    	public static final String LABEL_DESCUENTOREAL= "Descuento Real";
		public static final String LABEL_DESCUENTOREAL_LOWER= "Descuento Real";
	
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	
	public static String getFacturaDescuadradaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.FECHAINICIO)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.FECHAFIN)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.SECUENCIAL)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.FECHA)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.SUBTOTAL)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.IVA)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.DESCUENTO)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.FLETE)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.ICE)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.TOTAL)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO;}
		if(sNombreColumna.equals(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL)) {sLabelColumna=FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturaDescuadradaDescripcion(FacturaDescuadrada facturadescuadrada) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturadescuadrada !=null/* && facturadescuadrada.getId()!=0*/) {
			sDescripcion=facturadescuadrada.getfecha_fin().toString();//facturadescuadradafacturadescuadrada.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaDescuadradaDescripcionDetallado(FacturaDescuadrada facturadescuadrada) {
		String sDescripcion="";
			
		sDescripcion+=FacturaDescuadradaConstantesFunciones.ID+"=";
		sDescripcion+=facturadescuadrada.getId().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturadescuadrada.getVersionRow().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturadescuadrada.getid_empresa().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=facturadescuadrada.getfecha_inicio().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=facturadescuadrada.getfecha_fin().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=facturadescuadrada.getsecuencial()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.FECHA+"=";
		sDescripcion+=facturadescuadrada.getfecha().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=facturadescuadrada.getsubtotal().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.IVA+"=";
		sDescripcion+=facturadescuadrada.getiva().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=facturadescuadrada.getdescuento().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=facturadescuadrada.getfinanciamiento().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.FLETE+"=";
		sDescripcion+=facturadescuadrada.getflete().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.ICE+"=";
		sDescripcion+=facturadescuadrada.getice().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturadescuadrada.gettotal().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO+"=";
		sDescripcion+=facturadescuadrada.gettotal_formas_pago().toString()+",";
		sDescripcion+=FacturaDescuadradaConstantesFunciones.DESCUENTOREAL+"=";
		sDescripcion+=facturadescuadrada.getdescuento_real().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaDescuadradaDescripcion(FacturaDescuadrada facturadescuadrada,String sValor) throws Exception {			
		if(facturadescuadrada !=null) {
			//facturadescuadradafacturadescuadrada.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaFacturaDescuadrada")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaFacturaDescuadrada(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaDescuadrada(FacturaDescuadrada facturadescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturadescuadrada.setsecuencial(facturadescuadrada.getsecuencial().trim());
	}
	
	public static void quitarEspaciosFacturaDescuadradas(List<FacturaDescuadrada> facturadescuadradas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {
			facturadescuadrada.setsecuencial(facturadescuadrada.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaDescuadrada(FacturaDescuadrada facturadescuadrada,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturadescuadrada.getConCambioAuxiliar()) {
			facturadescuadrada.setIsDeleted(facturadescuadrada.getIsDeletedAuxiliar());	
			facturadescuadrada.setIsNew(facturadescuadrada.getIsNewAuxiliar());	
			facturadescuadrada.setIsChanged(facturadescuadrada.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturadescuadrada.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturadescuadrada.setIsDeletedAuxiliar(false);	
			facturadescuadrada.setIsNewAuxiliar(false);	
			facturadescuadrada.setIsChangedAuxiliar(false);
			
			facturadescuadrada.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaDescuadradas(List<FacturaDescuadrada> facturadescuadradas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaDescuadrada facturadescuadrada : facturadescuadradas) {
			if(conAsignarBase && facturadescuadrada.getConCambioAuxiliar()) {
				facturadescuadrada.setIsDeleted(facturadescuadrada.getIsDeletedAuxiliar());	
				facturadescuadrada.setIsNew(facturadescuadrada.getIsNewAuxiliar());	
				facturadescuadrada.setIsChanged(facturadescuadrada.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturadescuadrada.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturadescuadrada.setIsDeletedAuxiliar(false);	
				facturadescuadrada.setIsNewAuxiliar(false);	
				facturadescuadrada.setIsChangedAuxiliar(false);
				
				facturadescuadrada.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaDescuadrada(FacturaDescuadrada facturadescuadrada,Boolean conEnteros) throws Exception  {
		facturadescuadrada.setsubtotal(0.0);
		facturadescuadrada.setiva(0.0);
		facturadescuadrada.setdescuento(0.0);
		facturadescuadrada.setfinanciamiento(0.0);
		facturadescuadrada.setflete(0.0);
		facturadescuadrada.setice(0.0);
		facturadescuadrada.settotal(0.0);
		facturadescuadrada.settotal_formas_pago(0.0);
		facturadescuadrada.setdescuento_real(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturaDescuadradas(List<FacturaDescuadrada> facturadescuadradas,Boolean conEnteros) throws Exception  {
		
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {
			facturadescuadrada.setsubtotal(0.0);
			facturadescuadrada.setiva(0.0);
			facturadescuadrada.setdescuento(0.0);
			facturadescuadrada.setfinanciamiento(0.0);
			facturadescuadrada.setflete(0.0);
			facturadescuadrada.setice(0.0);
			facturadescuadrada.settotal(0.0);
			facturadescuadrada.settotal_formas_pago(0.0);
			facturadescuadrada.setdescuento_real(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaDescuadrada(List<FacturaDescuadrada> facturadescuadradas,FacturaDescuadrada facturadescuadradaAux) throws Exception  {
		FacturaDescuadradaConstantesFunciones.InicializarValoresFacturaDescuadrada(facturadescuadradaAux,true);
		
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {
			if(facturadescuadrada.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturadescuadradaAux.setsubtotal(facturadescuadradaAux.getsubtotal()+facturadescuadrada.getsubtotal());			
			facturadescuadradaAux.setiva(facturadescuadradaAux.getiva()+facturadescuadrada.getiva());			
			facturadescuadradaAux.setdescuento(facturadescuadradaAux.getdescuento()+facturadescuadrada.getdescuento());			
			facturadescuadradaAux.setfinanciamiento(facturadescuadradaAux.getfinanciamiento()+facturadescuadrada.getfinanciamiento());			
			facturadescuadradaAux.setflete(facturadescuadradaAux.getflete()+facturadescuadrada.getflete());			
			facturadescuadradaAux.setice(facturadescuadradaAux.getice()+facturadescuadrada.getice());			
			facturadescuadradaAux.settotal(facturadescuadradaAux.gettotal()+facturadescuadrada.gettotal());			
			facturadescuadradaAux.settotal_formas_pago(facturadescuadradaAux.gettotal_formas_pago()+facturadescuadrada.gettotal_formas_pago());			
			facturadescuadradaAux.setdescuento_real(facturadescuadradaAux.getdescuento_real()+facturadescuadrada.getdescuento_real());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaDescuadrada(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaDescuadradaConstantesFunciones.getArrayColumnasGlobalesFacturaDescuadrada(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaDescuadrada(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaDescuadradaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaDescuadradaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaDescuadrada(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaDescuadrada> facturadescuadradas,FacturaDescuadrada facturadescuadrada,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaDescuadrada facturadescuadradaAux: facturadescuadradas) {
			if(facturadescuadradaAux!=null && facturadescuadrada!=null) {
				if((facturadescuadradaAux.getId()==null && facturadescuadrada.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturadescuadradaAux.getId()!=null && facturadescuadrada.getId()!=null){
					if(facturadescuadradaAux.getId().equals(facturadescuadrada.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaDescuadrada(List<FacturaDescuadrada> facturadescuadradas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double total_formas_pagoTotal=0.0;
		Double descuento_realTotal=0.0;
	
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {			
			if(facturadescuadrada.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=facturadescuadrada.getsubtotal();
			ivaTotal+=facturadescuadrada.getiva();
			descuentoTotal+=facturadescuadrada.getdescuento();
			financiamientoTotal+=facturadescuadrada.getfinanciamiento();
			fleteTotal+=facturadescuadrada.getflete();
			iceTotal+=facturadescuadrada.getice();
			totalTotal+=facturadescuadrada.gettotal();
			total_formas_pagoTotal+=facturadescuadrada.gettotal_formas_pago();
			descuento_realTotal+=facturadescuadrada.getdescuento_real();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO);
		datoGeneral.setdValorDouble(total_formas_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL);
		datoGeneral.setdValorDouble(descuento_realTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaDescuadrada() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_ID, FacturaDescuadradaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_VERSIONROW, FacturaDescuadradaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_SECUENCIAL, FacturaDescuadradaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_FECHA, FacturaDescuadradaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL, FacturaDescuadradaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_IVA, FacturaDescuadradaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO, FacturaDescuadradaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO, FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_FLETE, FacturaDescuadradaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_ICE, FacturaDescuadradaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_TOTAL, FacturaDescuadradaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO, FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL, FacturaDescuadradaConstantesFunciones.DESCUENTOREAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaDescuadrada() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaDescuadradaConstantesFunciones.DESCUENTOREAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDescuadrada() throws Exception  {
		return FacturaDescuadradaConstantesFunciones.getTiposSeleccionarFacturaDescuadrada(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDescuadrada(Boolean conFk) throws Exception  {
		return FacturaDescuadradaConstantesFunciones.getTiposSeleccionarFacturaDescuadrada(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaDescuadrada(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL);
			reporte.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaDescuadrada(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaDescuadrada(FacturaDescuadrada facturadescuadradaAux) throws Exception {
		
			facturadescuadradaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturadescuadradaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaDescuadrada(List<FacturaDescuadrada> facturadescuadradasTemp) throws Exception {
		for(FacturaDescuadrada facturadescuadradaAux:facturadescuadradasTemp) {
			
			facturadescuadradaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturadescuadradaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaDescuadrada(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaDescuadrada(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaDescuadrada(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaDescuadradaConstantesFunciones.getClassesRelationshipsOfFacturaDescuadrada(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaDescuadrada(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaDescuadrada(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaDescuadradaConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaDescuadrada(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaDescuadrada(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturaDescuadrada facturadescuadrada,List<FacturaDescuadrada> facturadescuadradas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturaDescuadrada facturadescuadrada,List<FacturaDescuadrada> facturadescuadradas) throws Exception {
		try	{			
			for(FacturaDescuadrada facturadescuadradaLocal:facturadescuadradas) {
				if(facturadescuadradaLocal.getId().equals(facturadescuadrada.getId())) {
					facturadescuadradaLocal.setIsSelected(facturadescuadrada.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaDescuadrada(List<FacturaDescuadrada> facturadescuadradasAux) throws Exception {
		//this.facturadescuadradasAux=facturadescuadradasAux;
		
		for(FacturaDescuadrada facturadescuadradaAux:facturadescuadradasAux) {
			if(facturadescuadradaAux.getIsChanged()) {
				facturadescuadradaAux.setIsChanged(false);
			}		
			
			if(facturadescuadradaAux.getIsNew()) {
				facturadescuadradaAux.setIsNew(false);
			}	
			
			if(facturadescuadradaAux.getIsDeleted()) {
				facturadescuadradaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaDescuadrada(FacturaDescuadrada facturadescuadradaAux) throws Exception {
		//this.facturadescuadradaAux=facturadescuadradaAux;
		
			if(facturadescuadradaAux.getIsChanged()) {
				facturadescuadradaAux.setIsChanged(false);
			}		
			
			if(facturadescuadradaAux.getIsNew()) {
				facturadescuadradaAux.setIsNew(false);
			}	
			
			if(facturadescuadradaAux.getIsDeleted()) {
				facturadescuadradaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaDescuadrada facturadescuadradaAsignar,FacturaDescuadrada facturadescuadrada) throws Exception {
		facturadescuadradaAsignar.setId(facturadescuadrada.getId());	
		facturadescuadradaAsignar.setVersionRow(facturadescuadrada.getVersionRow());	
		facturadescuadradaAsignar.setsecuencial(facturadescuadrada.getsecuencial());	
		facturadescuadradaAsignar.setfecha(facturadescuadrada.getfecha());	
		facturadescuadradaAsignar.setsubtotal(facturadescuadrada.getsubtotal());	
		facturadescuadradaAsignar.setiva(facturadescuadrada.getiva());	
		facturadescuadradaAsignar.setdescuento(facturadescuadrada.getdescuento());	
		facturadescuadradaAsignar.setfinanciamiento(facturadescuadrada.getfinanciamiento());	
		facturadescuadradaAsignar.setflete(facturadescuadrada.getflete());	
		facturadescuadradaAsignar.setice(facturadescuadrada.getice());	
		facturadescuadradaAsignar.settotal(facturadescuadrada.gettotal());	
		facturadescuadradaAsignar.settotal_formas_pago(facturadescuadrada.gettotal_formas_pago());	
		facturadescuadradaAsignar.setdescuento_real(facturadescuadrada.getdescuento_real());	
	}
	
	public static void inicializarFacturaDescuadrada(FacturaDescuadrada facturadescuadrada) throws Exception {
		try {
				facturadescuadrada.setId(0L);	
					
				facturadescuadrada.setsecuencial("");	
				facturadescuadrada.setfecha(new Date());	
				facturadescuadrada.setsubtotal(0.0);	
				facturadescuadrada.setiva(0.0);	
				facturadescuadrada.setdescuento(0.0);	
				facturadescuadrada.setfinanciamiento(0.0);	
				facturadescuadrada.setflete(0.0);	
				facturadescuadrada.setice(0.0);	
				facturadescuadrada.settotal(0.0);	
				facturadescuadrada.settotal_formas_pago(0.0);	
				facturadescuadrada.setdescuento_real(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaDescuadrada(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaDescuadrada(String sTipo,Row row,Workbook workbook,FacturaDescuadrada facturadescuadrada,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.gettotal_formas_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturadescuadrada.getdescuento_real());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaDescuadrada="";
	
	public String getsFinalQueryFacturaDescuadrada() {
		return this.sFinalQueryFacturaDescuadrada;
	}
	
	public void setsFinalQueryFacturaDescuadrada(String sFinalQueryFacturaDescuadrada) {
		this.sFinalQueryFacturaDescuadrada= sFinalQueryFacturaDescuadrada;
	}
	
	public Border resaltarSeleccionarFacturaDescuadrada=null;
	
	public Border setResaltarSeleccionarFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaDescuadrada= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaDescuadrada() {
		return this.resaltarSeleccionarFacturaDescuadrada;
	}
	
	public void setResaltarSeleccionarFacturaDescuadrada(Border borderResaltarSeleccionarFacturaDescuadrada) {
		this.resaltarSeleccionarFacturaDescuadrada= borderResaltarSeleccionarFacturaDescuadrada;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaDescuadrada=null;
	public Boolean mostraridFacturaDescuadrada=true;
	public Boolean activaridFacturaDescuadrada=true;

	public Border resaltarid_empresaFacturaDescuadrada=null;
	public Boolean mostrarid_empresaFacturaDescuadrada=true;
	public Boolean activarid_empresaFacturaDescuadrada=true;
	public Boolean cargarid_empresaFacturaDescuadrada=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaDescuadrada=false;//ConEventDepend=true

	public Border resaltarfecha_inicioFacturaDescuadrada=null;
	public Boolean mostrarfecha_inicioFacturaDescuadrada=true;
	public Boolean activarfecha_inicioFacturaDescuadrada=true;

	public Border resaltarfecha_finFacturaDescuadrada=null;
	public Boolean mostrarfecha_finFacturaDescuadrada=true;
	public Boolean activarfecha_finFacturaDescuadrada=true;

	public Border resaltarsecuencialFacturaDescuadrada=null;
	public Boolean mostrarsecuencialFacturaDescuadrada=true;
	public Boolean activarsecuencialFacturaDescuadrada=true;

	public Border resaltarfechaFacturaDescuadrada=null;
	public Boolean mostrarfechaFacturaDescuadrada=true;
	public Boolean activarfechaFacturaDescuadrada=true;

	public Border resaltarsubtotalFacturaDescuadrada=null;
	public Boolean mostrarsubtotalFacturaDescuadrada=true;
	public Boolean activarsubtotalFacturaDescuadrada=true;

	public Border resaltarivaFacturaDescuadrada=null;
	public Boolean mostrarivaFacturaDescuadrada=true;
	public Boolean activarivaFacturaDescuadrada=true;

	public Border resaltardescuentoFacturaDescuadrada=null;
	public Boolean mostrardescuentoFacturaDescuadrada=true;
	public Boolean activardescuentoFacturaDescuadrada=true;

	public Border resaltarfinanciamientoFacturaDescuadrada=null;
	public Boolean mostrarfinanciamientoFacturaDescuadrada=true;
	public Boolean activarfinanciamientoFacturaDescuadrada=true;

	public Border resaltarfleteFacturaDescuadrada=null;
	public Boolean mostrarfleteFacturaDescuadrada=true;
	public Boolean activarfleteFacturaDescuadrada=true;

	public Border resaltariceFacturaDescuadrada=null;
	public Boolean mostrariceFacturaDescuadrada=true;
	public Boolean activariceFacturaDescuadrada=true;

	public Border resaltartotalFacturaDescuadrada=null;
	public Boolean mostrartotalFacturaDescuadrada=true;
	public Boolean activartotalFacturaDescuadrada=true;

	public Border resaltartotal_formas_pagoFacturaDescuadrada=null;
	public Boolean mostrartotal_formas_pagoFacturaDescuadrada=true;
	public Boolean activartotal_formas_pagoFacturaDescuadrada=true;

	public Border resaltardescuento_realFacturaDescuadrada=null;
	public Boolean mostrardescuento_realFacturaDescuadrada=true;
	public Boolean activardescuento_realFacturaDescuadrada=true;

	
	

	public Border setResaltaridFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltaridFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaDescuadrada() {
		return this.resaltaridFacturaDescuadrada;
	}

	public void setResaltaridFacturaDescuadrada(Border borderResaltar) {
		this.resaltaridFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostraridFacturaDescuadrada() {
		return this.mostraridFacturaDescuadrada;
	}

	public void setMostraridFacturaDescuadrada(Boolean mostraridFacturaDescuadrada) {
		this.mostraridFacturaDescuadrada= mostraridFacturaDescuadrada;
	}

	public Boolean getActivaridFacturaDescuadrada() {
		return this.activaridFacturaDescuadrada;
	}

	public void setActivaridFacturaDescuadrada(Boolean activaridFacturaDescuadrada) {
		this.activaridFacturaDescuadrada= activaridFacturaDescuadrada;
	}

	public Border setResaltarid_empresaFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaDescuadrada() {
		return this.resaltarid_empresaFacturaDescuadrada;
	}

	public void setResaltarid_empresaFacturaDescuadrada(Border borderResaltar) {
		this.resaltarid_empresaFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaDescuadrada() {
		return this.mostrarid_empresaFacturaDescuadrada;
	}

	public void setMostrarid_empresaFacturaDescuadrada(Boolean mostrarid_empresaFacturaDescuadrada) {
		this.mostrarid_empresaFacturaDescuadrada= mostrarid_empresaFacturaDescuadrada;
	}

	public Boolean getActivarid_empresaFacturaDescuadrada() {
		return this.activarid_empresaFacturaDescuadrada;
	}

	public void setActivarid_empresaFacturaDescuadrada(Boolean activarid_empresaFacturaDescuadrada) {
		this.activarid_empresaFacturaDescuadrada= activarid_empresaFacturaDescuadrada;
	}

	public Boolean getCargarid_empresaFacturaDescuadrada() {
		return this.cargarid_empresaFacturaDescuadrada;
	}

	public void setCargarid_empresaFacturaDescuadrada(Boolean cargarid_empresaFacturaDescuadrada) {
		this.cargarid_empresaFacturaDescuadrada= cargarid_empresaFacturaDescuadrada;
	}

	public Border setResaltarfecha_inicioFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioFacturaDescuadrada() {
		return this.resaltarfecha_inicioFacturaDescuadrada;
	}

	public void setResaltarfecha_inicioFacturaDescuadrada(Border borderResaltar) {
		this.resaltarfecha_inicioFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioFacturaDescuadrada() {
		return this.mostrarfecha_inicioFacturaDescuadrada;
	}

	public void setMostrarfecha_inicioFacturaDescuadrada(Boolean mostrarfecha_inicioFacturaDescuadrada) {
		this.mostrarfecha_inicioFacturaDescuadrada= mostrarfecha_inicioFacturaDescuadrada;
	}

	public Boolean getActivarfecha_inicioFacturaDescuadrada() {
		return this.activarfecha_inicioFacturaDescuadrada;
	}

	public void setActivarfecha_inicioFacturaDescuadrada(Boolean activarfecha_inicioFacturaDescuadrada) {
		this.activarfecha_inicioFacturaDescuadrada= activarfecha_inicioFacturaDescuadrada;
	}

	public Border setResaltarfecha_finFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarfecha_finFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finFacturaDescuadrada() {
		return this.resaltarfecha_finFacturaDescuadrada;
	}

	public void setResaltarfecha_finFacturaDescuadrada(Border borderResaltar) {
		this.resaltarfecha_finFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarfecha_finFacturaDescuadrada() {
		return this.mostrarfecha_finFacturaDescuadrada;
	}

	public void setMostrarfecha_finFacturaDescuadrada(Boolean mostrarfecha_finFacturaDescuadrada) {
		this.mostrarfecha_finFacturaDescuadrada= mostrarfecha_finFacturaDescuadrada;
	}

	public Boolean getActivarfecha_finFacturaDescuadrada() {
		return this.activarfecha_finFacturaDescuadrada;
	}

	public void setActivarfecha_finFacturaDescuadrada(Boolean activarfecha_finFacturaDescuadrada) {
		this.activarfecha_finFacturaDescuadrada= activarfecha_finFacturaDescuadrada;
	}

	public Border setResaltarsecuencialFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarsecuencialFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialFacturaDescuadrada() {
		return this.resaltarsecuencialFacturaDescuadrada;
	}

	public void setResaltarsecuencialFacturaDescuadrada(Border borderResaltar) {
		this.resaltarsecuencialFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarsecuencialFacturaDescuadrada() {
		return this.mostrarsecuencialFacturaDescuadrada;
	}

	public void setMostrarsecuencialFacturaDescuadrada(Boolean mostrarsecuencialFacturaDescuadrada) {
		this.mostrarsecuencialFacturaDescuadrada= mostrarsecuencialFacturaDescuadrada;
	}

	public Boolean getActivarsecuencialFacturaDescuadrada() {
		return this.activarsecuencialFacturaDescuadrada;
	}

	public void setActivarsecuencialFacturaDescuadrada(Boolean activarsecuencialFacturaDescuadrada) {
		this.activarsecuencialFacturaDescuadrada= activarsecuencialFacturaDescuadrada;
	}

	public Border setResaltarfechaFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarfechaFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFacturaDescuadrada() {
		return this.resaltarfechaFacturaDescuadrada;
	}

	public void setResaltarfechaFacturaDescuadrada(Border borderResaltar) {
		this.resaltarfechaFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarfechaFacturaDescuadrada() {
		return this.mostrarfechaFacturaDescuadrada;
	}

	public void setMostrarfechaFacturaDescuadrada(Boolean mostrarfechaFacturaDescuadrada) {
		this.mostrarfechaFacturaDescuadrada= mostrarfechaFacturaDescuadrada;
	}

	public Boolean getActivarfechaFacturaDescuadrada() {
		return this.activarfechaFacturaDescuadrada;
	}

	public void setActivarfechaFacturaDescuadrada(Boolean activarfechaFacturaDescuadrada) {
		this.activarfechaFacturaDescuadrada= activarfechaFacturaDescuadrada;
	}

	public Border setResaltarsubtotalFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarsubtotalFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalFacturaDescuadrada() {
		return this.resaltarsubtotalFacturaDescuadrada;
	}

	public void setResaltarsubtotalFacturaDescuadrada(Border borderResaltar) {
		this.resaltarsubtotalFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarsubtotalFacturaDescuadrada() {
		return this.mostrarsubtotalFacturaDescuadrada;
	}

	public void setMostrarsubtotalFacturaDescuadrada(Boolean mostrarsubtotalFacturaDescuadrada) {
		this.mostrarsubtotalFacturaDescuadrada= mostrarsubtotalFacturaDescuadrada;
	}

	public Boolean getActivarsubtotalFacturaDescuadrada() {
		return this.activarsubtotalFacturaDescuadrada;
	}

	public void setActivarsubtotalFacturaDescuadrada(Boolean activarsubtotalFacturaDescuadrada) {
		this.activarsubtotalFacturaDescuadrada= activarsubtotalFacturaDescuadrada;
	}

	public Border setResaltarivaFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarivaFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFacturaDescuadrada() {
		return this.resaltarivaFacturaDescuadrada;
	}

	public void setResaltarivaFacturaDescuadrada(Border borderResaltar) {
		this.resaltarivaFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarivaFacturaDescuadrada() {
		return this.mostrarivaFacturaDescuadrada;
	}

	public void setMostrarivaFacturaDescuadrada(Boolean mostrarivaFacturaDescuadrada) {
		this.mostrarivaFacturaDescuadrada= mostrarivaFacturaDescuadrada;
	}

	public Boolean getActivarivaFacturaDescuadrada() {
		return this.activarivaFacturaDescuadrada;
	}

	public void setActivarivaFacturaDescuadrada(Boolean activarivaFacturaDescuadrada) {
		this.activarivaFacturaDescuadrada= activarivaFacturaDescuadrada;
	}

	public Border setResaltardescuentoFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltardescuentoFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoFacturaDescuadrada() {
		return this.resaltardescuentoFacturaDescuadrada;
	}

	public void setResaltardescuentoFacturaDescuadrada(Border borderResaltar) {
		this.resaltardescuentoFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrardescuentoFacturaDescuadrada() {
		return this.mostrardescuentoFacturaDescuadrada;
	}

	public void setMostrardescuentoFacturaDescuadrada(Boolean mostrardescuentoFacturaDescuadrada) {
		this.mostrardescuentoFacturaDescuadrada= mostrardescuentoFacturaDescuadrada;
	}

	public Boolean getActivardescuentoFacturaDescuadrada() {
		return this.activardescuentoFacturaDescuadrada;
	}

	public void setActivardescuentoFacturaDescuadrada(Boolean activardescuentoFacturaDescuadrada) {
		this.activardescuentoFacturaDescuadrada= activardescuentoFacturaDescuadrada;
	}

	public Border setResaltarfinanciamientoFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoFacturaDescuadrada() {
		return this.resaltarfinanciamientoFacturaDescuadrada;
	}

	public void setResaltarfinanciamientoFacturaDescuadrada(Border borderResaltar) {
		this.resaltarfinanciamientoFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoFacturaDescuadrada() {
		return this.mostrarfinanciamientoFacturaDescuadrada;
	}

	public void setMostrarfinanciamientoFacturaDescuadrada(Boolean mostrarfinanciamientoFacturaDescuadrada) {
		this.mostrarfinanciamientoFacturaDescuadrada= mostrarfinanciamientoFacturaDescuadrada;
	}

	public Boolean getActivarfinanciamientoFacturaDescuadrada() {
		return this.activarfinanciamientoFacturaDescuadrada;
	}

	public void setActivarfinanciamientoFacturaDescuadrada(Boolean activarfinanciamientoFacturaDescuadrada) {
		this.activarfinanciamientoFacturaDescuadrada= activarfinanciamientoFacturaDescuadrada;
	}

	public Border setResaltarfleteFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltarfleteFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteFacturaDescuadrada() {
		return this.resaltarfleteFacturaDescuadrada;
	}

	public void setResaltarfleteFacturaDescuadrada(Border borderResaltar) {
		this.resaltarfleteFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrarfleteFacturaDescuadrada() {
		return this.mostrarfleteFacturaDescuadrada;
	}

	public void setMostrarfleteFacturaDescuadrada(Boolean mostrarfleteFacturaDescuadrada) {
		this.mostrarfleteFacturaDescuadrada= mostrarfleteFacturaDescuadrada;
	}

	public Boolean getActivarfleteFacturaDescuadrada() {
		return this.activarfleteFacturaDescuadrada;
	}

	public void setActivarfleteFacturaDescuadrada(Boolean activarfleteFacturaDescuadrada) {
		this.activarfleteFacturaDescuadrada= activarfleteFacturaDescuadrada;
	}

	public Border setResaltariceFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltariceFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceFacturaDescuadrada() {
		return this.resaltariceFacturaDescuadrada;
	}

	public void setResaltariceFacturaDescuadrada(Border borderResaltar) {
		this.resaltariceFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrariceFacturaDescuadrada() {
		return this.mostrariceFacturaDescuadrada;
	}

	public void setMostrariceFacturaDescuadrada(Boolean mostrariceFacturaDescuadrada) {
		this.mostrariceFacturaDescuadrada= mostrariceFacturaDescuadrada;
	}

	public Boolean getActivariceFacturaDescuadrada() {
		return this.activariceFacturaDescuadrada;
	}

	public void setActivariceFacturaDescuadrada(Boolean activariceFacturaDescuadrada) {
		this.activariceFacturaDescuadrada= activariceFacturaDescuadrada;
	}

	public Border setResaltartotalFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltartotalFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturaDescuadrada() {
		return this.resaltartotalFacturaDescuadrada;
	}

	public void setResaltartotalFacturaDescuadrada(Border borderResaltar) {
		this.resaltartotalFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrartotalFacturaDescuadrada() {
		return this.mostrartotalFacturaDescuadrada;
	}

	public void setMostrartotalFacturaDescuadrada(Boolean mostrartotalFacturaDescuadrada) {
		this.mostrartotalFacturaDescuadrada= mostrartotalFacturaDescuadrada;
	}

	public Boolean getActivartotalFacturaDescuadrada() {
		return this.activartotalFacturaDescuadrada;
	}

	public void setActivartotalFacturaDescuadrada(Boolean activartotalFacturaDescuadrada) {
		this.activartotalFacturaDescuadrada= activartotalFacturaDescuadrada;
	}

	public Border setResaltartotal_formas_pagoFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltartotal_formas_pagoFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_formas_pagoFacturaDescuadrada() {
		return this.resaltartotal_formas_pagoFacturaDescuadrada;
	}

	public void setResaltartotal_formas_pagoFacturaDescuadrada(Border borderResaltar) {
		this.resaltartotal_formas_pagoFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrartotal_formas_pagoFacturaDescuadrada() {
		return this.mostrartotal_formas_pagoFacturaDescuadrada;
	}

	public void setMostrartotal_formas_pagoFacturaDescuadrada(Boolean mostrartotal_formas_pagoFacturaDescuadrada) {
		this.mostrartotal_formas_pagoFacturaDescuadrada= mostrartotal_formas_pagoFacturaDescuadrada;
	}

	public Boolean getActivartotal_formas_pagoFacturaDescuadrada() {
		return this.activartotal_formas_pagoFacturaDescuadrada;
	}

	public void setActivartotal_formas_pagoFacturaDescuadrada(Boolean activartotal_formas_pagoFacturaDescuadrada) {
		this.activartotal_formas_pagoFacturaDescuadrada= activartotal_formas_pagoFacturaDescuadrada;
	}

	public Border setResaltardescuento_realFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturadescuadradaBeanSwingJInternalFrame.jTtoolBarFacturaDescuadrada.setBorder(borderResaltar);
		
		this.resaltardescuento_realFacturaDescuadrada= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_realFacturaDescuadrada() {
		return this.resaltardescuento_realFacturaDescuadrada;
	}

	public void setResaltardescuento_realFacturaDescuadrada(Border borderResaltar) {
		this.resaltardescuento_realFacturaDescuadrada= borderResaltar;
	}

	public Boolean getMostrardescuento_realFacturaDescuadrada() {
		return this.mostrardescuento_realFacturaDescuadrada;
	}

	public void setMostrardescuento_realFacturaDescuadrada(Boolean mostrardescuento_realFacturaDescuadrada) {
		this.mostrardescuento_realFacturaDescuadrada= mostrardescuento_realFacturaDescuadrada;
	}

	public Boolean getActivardescuento_realFacturaDescuadrada() {
		return this.activardescuento_realFacturaDescuadrada;
	}

	public void setActivardescuento_realFacturaDescuadrada(Boolean activardescuento_realFacturaDescuadrada) {
		this.activardescuento_realFacturaDescuadrada= activardescuento_realFacturaDescuadrada;
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
		
		
		this.setMostraridFacturaDescuadrada(esInicial);
		this.setMostrarid_empresaFacturaDescuadrada(esInicial);
		this.setMostrarfecha_inicioFacturaDescuadrada(esInicial);
		this.setMostrarfecha_finFacturaDescuadrada(esInicial);
		this.setMostrarsecuencialFacturaDescuadrada(esInicial);
		this.setMostrarfechaFacturaDescuadrada(esInicial);
		this.setMostrarsubtotalFacturaDescuadrada(esInicial);
		this.setMostrarivaFacturaDescuadrada(esInicial);
		this.setMostrardescuentoFacturaDescuadrada(esInicial);
		this.setMostrarfinanciamientoFacturaDescuadrada(esInicial);
		this.setMostrarfleteFacturaDescuadrada(esInicial);
		this.setMostrariceFacturaDescuadrada(esInicial);
		this.setMostrartotalFacturaDescuadrada(esInicial);
		this.setMostrartotal_formas_pagoFacturaDescuadrada(esInicial);
		this.setMostrardescuento_realFacturaDescuadrada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ID)) {
				this.setMostraridFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHA)) {
				this.setMostrarfechaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IVA)) {
				this.setMostrarivaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FLETE)) {
				this.setMostrarfleteFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ICE)) {
				this.setMostrariceFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO)) {
				this.setMostrartotal_formas_pagoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL)) {
				this.setMostrardescuento_realFacturaDescuadrada(esAsigna);
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
		
		
		this.setActivaridFacturaDescuadrada(esInicial);
		this.setActivarid_empresaFacturaDescuadrada(esInicial);
		this.setActivarfecha_inicioFacturaDescuadrada(esInicial);
		this.setActivarfecha_finFacturaDescuadrada(esInicial);
		this.setActivarsecuencialFacturaDescuadrada(esInicial);
		this.setActivarfechaFacturaDescuadrada(esInicial);
		this.setActivarsubtotalFacturaDescuadrada(esInicial);
		this.setActivarivaFacturaDescuadrada(esInicial);
		this.setActivardescuentoFacturaDescuadrada(esInicial);
		this.setActivarfinanciamientoFacturaDescuadrada(esInicial);
		this.setActivarfleteFacturaDescuadrada(esInicial);
		this.setActivariceFacturaDescuadrada(esInicial);
		this.setActivartotalFacturaDescuadrada(esInicial);
		this.setActivartotal_formas_pagoFacturaDescuadrada(esInicial);
		this.setActivardescuento_realFacturaDescuadrada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ID)) {
				this.setActivaridFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHA)) {
				this.setActivarfechaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IVA)) {
				this.setActivarivaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FLETE)) {
				this.setActivarfleteFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ICE)) {
				this.setActivariceFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO)) {
				this.setActivartotal_formas_pagoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL)) {
				this.setActivardescuento_realFacturaDescuadrada(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaDescuadrada(esInicial);
		this.setResaltarid_empresaFacturaDescuadrada(esInicial);
		this.setResaltarfecha_inicioFacturaDescuadrada(esInicial);
		this.setResaltarfecha_finFacturaDescuadrada(esInicial);
		this.setResaltarsecuencialFacturaDescuadrada(esInicial);
		this.setResaltarfechaFacturaDescuadrada(esInicial);
		this.setResaltarsubtotalFacturaDescuadrada(esInicial);
		this.setResaltarivaFacturaDescuadrada(esInicial);
		this.setResaltardescuentoFacturaDescuadrada(esInicial);
		this.setResaltarfinanciamientoFacturaDescuadrada(esInicial);
		this.setResaltarfleteFacturaDescuadrada(esInicial);
		this.setResaltariceFacturaDescuadrada(esInicial);
		this.setResaltartotalFacturaDescuadrada(esInicial);
		this.setResaltartotal_formas_pagoFacturaDescuadrada(esInicial);
		this.setResaltardescuento_realFacturaDescuadrada(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ID)) {
				this.setResaltaridFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FECHA)) {
				this.setResaltarfechaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.IVA)) {
				this.setResaltarivaFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.FLETE)) {
				this.setResaltarfleteFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.ICE)) {
				this.setResaltariceFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO)) {
				this.setResaltartotal_formas_pagoFacturaDescuadrada(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL)) {
				this.setResaltardescuento_realFacturaDescuadrada(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturaDescuadradaFacturaDescuadrada=true;

	public Boolean getMostrarBusquedaFacturaDescuadradaFacturaDescuadrada() {
		return this.mostrarBusquedaFacturaDescuadradaFacturaDescuadrada;
	}

	public void setMostrarBusquedaFacturaDescuadradaFacturaDescuadrada(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturaDescuadradaFacturaDescuadrada= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturaDescuadradaFacturaDescuadrada=true;

	public Boolean getActivarBusquedaFacturaDescuadradaFacturaDescuadrada() {
		return this.activarBusquedaFacturaDescuadradaFacturaDescuadrada;
	}

	public void setActivarBusquedaFacturaDescuadradaFacturaDescuadrada(Boolean habilitarResaltar) {
		this.activarBusquedaFacturaDescuadradaFacturaDescuadrada= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturaDescuadradaFacturaDescuadrada=null;

	public Border getResaltarBusquedaFacturaDescuadradaFacturaDescuadrada() {
		return this.resaltarBusquedaFacturaDescuadradaFacturaDescuadrada;
	}

	public void setResaltarBusquedaFacturaDescuadradaFacturaDescuadrada(Border borderResaltar) {
		this.resaltarBusquedaFacturaDescuadradaFacturaDescuadrada= borderResaltar;
	}

	public void setResaltarBusquedaFacturaDescuadradaFacturaDescuadrada(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaDescuadradaBeanSwingJInternalFrame facturadescuadradaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturaDescuadradaFacturaDescuadrada= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
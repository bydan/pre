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
package com.bydan.erp.sris.util.report;

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


import com.bydan.erp.sris.util.report.FacturasPuntoVentaConstantesFunciones;
import com.bydan.erp.sris.util.report.FacturasPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.FacturasPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturasPuntoVentaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturasPuntoVenta";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturasPuntoVenta"+FacturasPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturasPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturasPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturasPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturasPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturasPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturasPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturasPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturasPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturasPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturasPuntoVentaConstantesFunciones.SCHEMA+"_"+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturasPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturasPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturasPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturasPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturas Punto Ventas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Facturas Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Facturas Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturasPuntoVenta";
	public static final String OBJECTNAME="facturaspuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="facturas_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturaspuntoventa from "+FacturasPuntoVentaConstantesFunciones.SPERSISTENCENAME+" facturaspuntoventa";
	public static String QUERYSELECTNATIVE="select "+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".id,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".fecha_desde,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".fecha_hasta,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".total_iva,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".total_sin_iva,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".iva,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".total,"+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME+".ruc_cliente from "+FacturasPuntoVentaConstantesFunciones.SCHEMA+"."+FacturasPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FacturasPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String TOTAL= "total";
    public static final String RUCCLIENTE= "ruc_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFacturasPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.FECHADESDE)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.FECHAHASTA)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.TOTALIVA)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.TOTALSINIVA)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturasPuntoVentaConstantesFunciones.RUCCLIENTE)) {sLabelColumna=FacturasPuntoVentaConstantesFunciones.LABEL_RUCCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturasPuntoVentaDescripcion(FacturasPuntoVenta facturaspuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturaspuntoventa !=null/* && facturaspuntoventa.getId()!=0*/) {
			sDescripcion=facturaspuntoventa.getfecha_hasta().toString();//facturaspuntoventafacturaspuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturasPuntoVentaDescripcionDetallado(FacturasPuntoVenta facturaspuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=facturaspuntoventa.getId().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturaspuntoventa.getVersionRow().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturaspuntoventa.getid_empresa().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=facturaspuntoventa.getfecha_desde().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=facturaspuntoventa.getfecha_hasta().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=facturaspuntoventa.getnombre_completo_cliente()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=facturaspuntoventa.gettotal_iva().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=facturaspuntoventa.gettotal_sin_iva().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=facturaspuntoventa.getiva().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=facturaspuntoventa.getdescuento().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturaspuntoventa.gettotal().toString()+",";
		sDescripcion+=FacturasPuntoVentaConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=facturaspuntoventa.getruc_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturasPuntoVentaDescripcion(FacturasPuntoVenta facturaspuntoventa,String sValor) throws Exception {			
		if(facturaspuntoventa !=null) {
			//facturaspuntoventafacturaspuntoventa.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaFacturasPuntoVenta")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaFacturasPuntoVenta(Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturaspuntoventa.setnombre_completo_cliente(facturaspuntoventa.getnombre_completo_cliente().trim());
		facturaspuntoventa.setruc_cliente(facturaspuntoventa.getruc_cliente().trim());
	}
	
	public static void quitarEspaciosFacturasPuntoVentas(List<FacturasPuntoVenta> facturaspuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasPuntoVenta facturaspuntoventa: facturaspuntoventas) {
			facturaspuntoventa.setnombre_completo_cliente(facturaspuntoventa.getnombre_completo_cliente().trim());
			facturaspuntoventa.setruc_cliente(facturaspuntoventa.getruc_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturaspuntoventa.getConCambioAuxiliar()) {
			facturaspuntoventa.setIsDeleted(facturaspuntoventa.getIsDeletedAuxiliar());	
			facturaspuntoventa.setIsNew(facturaspuntoventa.getIsNewAuxiliar());	
			facturaspuntoventa.setIsChanged(facturaspuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturaspuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturaspuntoventa.setIsDeletedAuxiliar(false);	
			facturaspuntoventa.setIsNewAuxiliar(false);	
			facturaspuntoventa.setIsChangedAuxiliar(false);
			
			facturaspuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasPuntoVentas(List<FacturasPuntoVenta> facturaspuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturasPuntoVenta facturaspuntoventa : facturaspuntoventas) {
			if(conAsignarBase && facturaspuntoventa.getConCambioAuxiliar()) {
				facturaspuntoventa.setIsDeleted(facturaspuntoventa.getIsDeletedAuxiliar());	
				facturaspuntoventa.setIsNew(facturaspuntoventa.getIsNewAuxiliar());	
				facturaspuntoventa.setIsChanged(facturaspuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturaspuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturaspuntoventa.setIsDeletedAuxiliar(false);	
				facturaspuntoventa.setIsNewAuxiliar(false);	
				facturaspuntoventa.setIsChangedAuxiliar(false);
				
				facturaspuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventa,Boolean conEnteros) throws Exception  {
		facturaspuntoventa.settotal_iva(0.0);
		facturaspuntoventa.settotal_sin_iva(0.0);
		facturaspuntoventa.setiva(0.0);
		facturaspuntoventa.setdescuento(0.0);
		facturaspuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturasPuntoVentas(List<FacturasPuntoVenta> facturaspuntoventas,Boolean conEnteros) throws Exception  {
		
		for(FacturasPuntoVenta facturaspuntoventa: facturaspuntoventas) {
			facturaspuntoventa.settotal_iva(0.0);
			facturaspuntoventa.settotal_sin_iva(0.0);
			facturaspuntoventa.setiva(0.0);
			facturaspuntoventa.setdescuento(0.0);
			facturaspuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturasPuntoVenta(List<FacturasPuntoVenta> facturaspuntoventas,FacturasPuntoVenta facturaspuntoventaAux) throws Exception  {
		FacturasPuntoVentaConstantesFunciones.InicializarValoresFacturasPuntoVenta(facturaspuntoventaAux,true);
		
		for(FacturasPuntoVenta facturaspuntoventa: facturaspuntoventas) {
			if(facturaspuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturaspuntoventaAux.settotal_iva(facturaspuntoventaAux.gettotal_iva()+facturaspuntoventa.gettotal_iva());			
			facturaspuntoventaAux.settotal_sin_iva(facturaspuntoventaAux.gettotal_sin_iva()+facturaspuntoventa.gettotal_sin_iva());			
			facturaspuntoventaAux.setiva(facturaspuntoventaAux.getiva()+facturaspuntoventa.getiva());			
			facturaspuntoventaAux.setdescuento(facturaspuntoventaAux.getdescuento()+facturaspuntoventa.getdescuento());			
			facturaspuntoventaAux.settotal(facturaspuntoventaAux.gettotal()+facturaspuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturasPuntoVentaConstantesFunciones.getArrayColumnasGlobalesFacturasPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasPuntoVentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturasPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasPuntoVenta> facturaspuntoventas,FacturasPuntoVenta facturaspuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasPuntoVenta facturaspuntoventaAux: facturaspuntoventas) {
			if(facturaspuntoventaAux!=null && facturaspuntoventa!=null) {
				if((facturaspuntoventaAux.getId()==null && facturaspuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturaspuntoventaAux.getId()!=null && facturaspuntoventa.getId()!=null){
					if(facturaspuntoventaAux.getId().equals(facturaspuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasPuntoVenta(List<FacturasPuntoVenta> facturaspuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double totalTotal=0.0;
	
		for(FacturasPuntoVenta facturaspuntoventa: facturaspuntoventas) {			
			if(facturaspuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=facturaspuntoventa.gettotal_iva();
			total_sin_ivaTotal+=facturaspuntoventa.gettotal_sin_iva();
			ivaTotal+=facturaspuntoventa.getiva();
			descuentoTotal+=facturaspuntoventa.getdescuento();
			totalTotal+=facturaspuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasPuntoVentaConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasPuntoVentaConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturasPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_ID, FacturasPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_VERSIONROW, FacturasPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA, FacturasPuntoVentaConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA, FacturasPuntoVentaConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_IVA, FacturasPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO, FacturasPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL, FacturasPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasPuntoVentaConstantesFunciones.LABEL_RUCCLIENTE, FacturasPuntoVentaConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturasPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasPuntoVentaConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasPuntoVenta() throws Exception  {
		return FacturasPuntoVentaConstantesFunciones.getTiposSeleccionarFacturasPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasPuntoVenta(Boolean conFk) throws Exception  {
		return FacturasPuntoVentaConstantesFunciones.getTiposSeleccionarFacturasPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasPuntoVentaConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(FacturasPuntoVentaConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturasPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventaAux) throws Exception {
		
			facturaspuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaspuntoventaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasPuntoVenta(List<FacturasPuntoVenta> facturaspuntoventasTemp) throws Exception {
		for(FacturasPuntoVenta facturaspuntoventaAux:facturaspuntoventasTemp) {
			
			facturaspuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaspuntoventaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturasPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturasPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasPuntoVentaConstantesFunciones.getClassesRelationshipsOfFacturasPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfFacturasPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturasPuntoVenta facturaspuntoventa,List<FacturasPuntoVenta> facturaspuntoventas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturasPuntoVenta facturaspuntoventa,List<FacturasPuntoVenta> facturaspuntoventas) throws Exception {
		try	{			
			for(FacturasPuntoVenta facturaspuntoventaLocal:facturaspuntoventas) {
				if(facturaspuntoventaLocal.getId().equals(facturaspuntoventa.getId())) {
					facturaspuntoventaLocal.setIsSelected(facturaspuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturasPuntoVenta(List<FacturasPuntoVenta> facturaspuntoventasAux) throws Exception {
		//this.facturaspuntoventasAux=facturaspuntoventasAux;
		
		for(FacturasPuntoVenta facturaspuntoventaAux:facturaspuntoventasAux) {
			if(facturaspuntoventaAux.getIsChanged()) {
				facturaspuntoventaAux.setIsChanged(false);
			}		
			
			if(facturaspuntoventaAux.getIsNew()) {
				facturaspuntoventaAux.setIsNew(false);
			}	
			
			if(facturaspuntoventaAux.getIsDeleted()) {
				facturaspuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventaAux) throws Exception {
		//this.facturaspuntoventaAux=facturaspuntoventaAux;
		
			if(facturaspuntoventaAux.getIsChanged()) {
				facturaspuntoventaAux.setIsChanged(false);
			}		
			
			if(facturaspuntoventaAux.getIsNew()) {
				facturaspuntoventaAux.setIsNew(false);
			}	
			
			if(facturaspuntoventaAux.getIsDeleted()) {
				facturaspuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturasPuntoVenta facturaspuntoventaAsignar,FacturasPuntoVenta facturaspuntoventa) throws Exception {
		facturaspuntoventaAsignar.setId(facturaspuntoventa.getId());	
		facturaspuntoventaAsignar.setVersionRow(facturaspuntoventa.getVersionRow());	
		facturaspuntoventaAsignar.setnombre_completo_cliente(facturaspuntoventa.getnombre_completo_cliente());	
		facturaspuntoventaAsignar.settotal_iva(facturaspuntoventa.gettotal_iva());	
		facturaspuntoventaAsignar.settotal_sin_iva(facturaspuntoventa.gettotal_sin_iva());	
		facturaspuntoventaAsignar.setiva(facturaspuntoventa.getiva());	
		facturaspuntoventaAsignar.setdescuento(facturaspuntoventa.getdescuento());	
		facturaspuntoventaAsignar.settotal(facturaspuntoventa.gettotal());	
		facturaspuntoventaAsignar.setruc_cliente(facturaspuntoventa.getruc_cliente());	
	}
	
	public static void inicializarFacturasPuntoVenta(FacturasPuntoVenta facturaspuntoventa) throws Exception {
		try {
				facturaspuntoventa.setId(0L);	
					
				facturaspuntoventa.setnombre_completo_cliente("");	
				facturaspuntoventa.settotal_iva(0.0);	
				facturaspuntoventa.settotal_sin_iva(0.0);	
				facturaspuntoventa.setiva(0.0);	
				facturaspuntoventa.setdescuento(0.0);	
				facturaspuntoventa.settotal(0.0);	
				facturaspuntoventa.setruc_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturasPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasPuntoVentaConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturasPuntoVenta(String sTipo,Row row,Workbook workbook,FacturasPuntoVenta facturaspuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaspuntoventa.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturasPuntoVenta="";
	
	public String getsFinalQueryFacturasPuntoVenta() {
		return this.sFinalQueryFacturasPuntoVenta;
	}
	
	public void setsFinalQueryFacturasPuntoVenta(String sFinalQueryFacturasPuntoVenta) {
		this.sFinalQueryFacturasPuntoVenta= sFinalQueryFacturasPuntoVenta;
	}
	
	public Border resaltarSeleccionarFacturasPuntoVenta=null;
	
	public Border setResaltarSeleccionarFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturasPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturasPuntoVenta() {
		return this.resaltarSeleccionarFacturasPuntoVenta;
	}
	
	public void setResaltarSeleccionarFacturasPuntoVenta(Border borderResaltarSeleccionarFacturasPuntoVenta) {
		this.resaltarSeleccionarFacturasPuntoVenta= borderResaltarSeleccionarFacturasPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturasPuntoVenta=null;
	public Boolean mostraridFacturasPuntoVenta=true;
	public Boolean activaridFacturasPuntoVenta=true;

	public Border resaltarid_empresaFacturasPuntoVenta=null;
	public Boolean mostrarid_empresaFacturasPuntoVenta=true;
	public Boolean activarid_empresaFacturasPuntoVenta=true;
	public Boolean cargarid_empresaFacturasPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturasPuntoVenta=false;//ConEventDepend=true

	public Border resaltarfecha_desdeFacturasPuntoVenta=null;
	public Boolean mostrarfecha_desdeFacturasPuntoVenta=true;
	public Boolean activarfecha_desdeFacturasPuntoVenta=true;

	public Border resaltarfecha_hastaFacturasPuntoVenta=null;
	public Boolean mostrarfecha_hastaFacturasPuntoVenta=true;
	public Boolean activarfecha_hastaFacturasPuntoVenta=true;

	public Border resaltarnombre_completo_clienteFacturasPuntoVenta=null;
	public Boolean mostrarnombre_completo_clienteFacturasPuntoVenta=true;
	public Boolean activarnombre_completo_clienteFacturasPuntoVenta=true;

	public Border resaltartotal_ivaFacturasPuntoVenta=null;
	public Boolean mostrartotal_ivaFacturasPuntoVenta=true;
	public Boolean activartotal_ivaFacturasPuntoVenta=true;

	public Border resaltartotal_sin_ivaFacturasPuntoVenta=null;
	public Boolean mostrartotal_sin_ivaFacturasPuntoVenta=true;
	public Boolean activartotal_sin_ivaFacturasPuntoVenta=true;

	public Border resaltarivaFacturasPuntoVenta=null;
	public Boolean mostrarivaFacturasPuntoVenta=true;
	public Boolean activarivaFacturasPuntoVenta=true;

	public Border resaltardescuentoFacturasPuntoVenta=null;
	public Boolean mostrardescuentoFacturasPuntoVenta=true;
	public Boolean activardescuentoFacturasPuntoVenta=true;

	public Border resaltartotalFacturasPuntoVenta=null;
	public Boolean mostrartotalFacturasPuntoVenta=true;
	public Boolean activartotalFacturasPuntoVenta=true;

	public Border resaltarruc_clienteFacturasPuntoVenta=null;
	public Boolean mostrarruc_clienteFacturasPuntoVenta=true;
	public Boolean activarruc_clienteFacturasPuntoVenta=true;

	
	

	public Border setResaltaridFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturasPuntoVenta() {
		return this.resaltaridFacturasPuntoVenta;
	}

	public void setResaltaridFacturasPuntoVenta(Border borderResaltar) {
		this.resaltaridFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridFacturasPuntoVenta() {
		return this.mostraridFacturasPuntoVenta;
	}

	public void setMostraridFacturasPuntoVenta(Boolean mostraridFacturasPuntoVenta) {
		this.mostraridFacturasPuntoVenta= mostraridFacturasPuntoVenta;
	}

	public Boolean getActivaridFacturasPuntoVenta() {
		return this.activaridFacturasPuntoVenta;
	}

	public void setActivaridFacturasPuntoVenta(Boolean activaridFacturasPuntoVenta) {
		this.activaridFacturasPuntoVenta= activaridFacturasPuntoVenta;
	}

	public Border setResaltarid_empresaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturasPuntoVenta() {
		return this.resaltarid_empresaFacturasPuntoVenta;
	}

	public void setResaltarid_empresaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturasPuntoVenta() {
		return this.mostrarid_empresaFacturasPuntoVenta;
	}

	public void setMostrarid_empresaFacturasPuntoVenta(Boolean mostrarid_empresaFacturasPuntoVenta) {
		this.mostrarid_empresaFacturasPuntoVenta= mostrarid_empresaFacturasPuntoVenta;
	}

	public Boolean getActivarid_empresaFacturasPuntoVenta() {
		return this.activarid_empresaFacturasPuntoVenta;
	}

	public void setActivarid_empresaFacturasPuntoVenta(Boolean activarid_empresaFacturasPuntoVenta) {
		this.activarid_empresaFacturasPuntoVenta= activarid_empresaFacturasPuntoVenta;
	}

	public Boolean getCargarid_empresaFacturasPuntoVenta() {
		return this.cargarid_empresaFacturasPuntoVenta;
	}

	public void setCargarid_empresaFacturasPuntoVenta(Boolean cargarid_empresaFacturasPuntoVenta) {
		this.cargarid_empresaFacturasPuntoVenta= cargarid_empresaFacturasPuntoVenta;
	}

	public Border setResaltarfecha_desdeFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeFacturasPuntoVenta() {
		return this.resaltarfecha_desdeFacturasPuntoVenta;
	}

	public void setResaltarfecha_desdeFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarfecha_desdeFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeFacturasPuntoVenta() {
		return this.mostrarfecha_desdeFacturasPuntoVenta;
	}

	public void setMostrarfecha_desdeFacturasPuntoVenta(Boolean mostrarfecha_desdeFacturasPuntoVenta) {
		this.mostrarfecha_desdeFacturasPuntoVenta= mostrarfecha_desdeFacturasPuntoVenta;
	}

	public Boolean getActivarfecha_desdeFacturasPuntoVenta() {
		return this.activarfecha_desdeFacturasPuntoVenta;
	}

	public void setActivarfecha_desdeFacturasPuntoVenta(Boolean activarfecha_desdeFacturasPuntoVenta) {
		this.activarfecha_desdeFacturasPuntoVenta= activarfecha_desdeFacturasPuntoVenta;
	}

	public Border setResaltarfecha_hastaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaFacturasPuntoVenta() {
		return this.resaltarfecha_hastaFacturasPuntoVenta;
	}

	public void setResaltarfecha_hastaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarfecha_hastaFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaFacturasPuntoVenta() {
		return this.mostrarfecha_hastaFacturasPuntoVenta;
	}

	public void setMostrarfecha_hastaFacturasPuntoVenta(Boolean mostrarfecha_hastaFacturasPuntoVenta) {
		this.mostrarfecha_hastaFacturasPuntoVenta= mostrarfecha_hastaFacturasPuntoVenta;
	}

	public Boolean getActivarfecha_hastaFacturasPuntoVenta() {
		return this.activarfecha_hastaFacturasPuntoVenta;
	}

	public void setActivarfecha_hastaFacturasPuntoVenta(Boolean activarfecha_hastaFacturasPuntoVenta) {
		this.activarfecha_hastaFacturasPuntoVenta= activarfecha_hastaFacturasPuntoVenta;
	}

	public Border setResaltarnombre_completo_clienteFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteFacturasPuntoVenta() {
		return this.resaltarnombre_completo_clienteFacturasPuntoVenta;
	}

	public void setResaltarnombre_completo_clienteFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarnombre_completo_clienteFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteFacturasPuntoVenta() {
		return this.mostrarnombre_completo_clienteFacturasPuntoVenta;
	}

	public void setMostrarnombre_completo_clienteFacturasPuntoVenta(Boolean mostrarnombre_completo_clienteFacturasPuntoVenta) {
		this.mostrarnombre_completo_clienteFacturasPuntoVenta= mostrarnombre_completo_clienteFacturasPuntoVenta;
	}

	public Boolean getActivarnombre_completo_clienteFacturasPuntoVenta() {
		return this.activarnombre_completo_clienteFacturasPuntoVenta;
	}

	public void setActivarnombre_completo_clienteFacturasPuntoVenta(Boolean activarnombre_completo_clienteFacturasPuntoVenta) {
		this.activarnombre_completo_clienteFacturasPuntoVenta= activarnombre_completo_clienteFacturasPuntoVenta;
	}

	public Border setResaltartotal_ivaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_ivaFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaFacturasPuntoVenta() {
		return this.resaltartotal_ivaFacturasPuntoVenta;
	}

	public void setResaltartotal_ivaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltartotal_ivaFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_ivaFacturasPuntoVenta() {
		return this.mostrartotal_ivaFacturasPuntoVenta;
	}

	public void setMostrartotal_ivaFacturasPuntoVenta(Boolean mostrartotal_ivaFacturasPuntoVenta) {
		this.mostrartotal_ivaFacturasPuntoVenta= mostrartotal_ivaFacturasPuntoVenta;
	}

	public Boolean getActivartotal_ivaFacturasPuntoVenta() {
		return this.activartotal_ivaFacturasPuntoVenta;
	}

	public void setActivartotal_ivaFacturasPuntoVenta(Boolean activartotal_ivaFacturasPuntoVenta) {
		this.activartotal_ivaFacturasPuntoVenta= activartotal_ivaFacturasPuntoVenta;
	}

	public Border setResaltartotal_sin_ivaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaFacturasPuntoVenta() {
		return this.resaltartotal_sin_ivaFacturasPuntoVenta;
	}

	public void setResaltartotal_sin_ivaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltartotal_sin_ivaFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaFacturasPuntoVenta() {
		return this.mostrartotal_sin_ivaFacturasPuntoVenta;
	}

	public void setMostrartotal_sin_ivaFacturasPuntoVenta(Boolean mostrartotal_sin_ivaFacturasPuntoVenta) {
		this.mostrartotal_sin_ivaFacturasPuntoVenta= mostrartotal_sin_ivaFacturasPuntoVenta;
	}

	public Boolean getActivartotal_sin_ivaFacturasPuntoVenta() {
		return this.activartotal_sin_ivaFacturasPuntoVenta;
	}

	public void setActivartotal_sin_ivaFacturasPuntoVenta(Boolean activartotal_sin_ivaFacturasPuntoVenta) {
		this.activartotal_sin_ivaFacturasPuntoVenta= activartotal_sin_ivaFacturasPuntoVenta;
	}

	public Border setResaltarivaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFacturasPuntoVenta() {
		return this.resaltarivaFacturasPuntoVenta;
	}

	public void setResaltarivaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarivaFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaFacturasPuntoVenta() {
		return this.mostrarivaFacturasPuntoVenta;
	}

	public void setMostrarivaFacturasPuntoVenta(Boolean mostrarivaFacturasPuntoVenta) {
		this.mostrarivaFacturasPuntoVenta= mostrarivaFacturasPuntoVenta;
	}

	public Boolean getActivarivaFacturasPuntoVenta() {
		return this.activarivaFacturasPuntoVenta;
	}

	public void setActivarivaFacturasPuntoVenta(Boolean activarivaFacturasPuntoVenta) {
		this.activarivaFacturasPuntoVenta= activarivaFacturasPuntoVenta;
	}

	public Border setResaltardescuentoFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoFacturasPuntoVenta() {
		return this.resaltardescuentoFacturasPuntoVenta;
	}

	public void setResaltardescuentoFacturasPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoFacturasPuntoVenta() {
		return this.mostrardescuentoFacturasPuntoVenta;
	}

	public void setMostrardescuentoFacturasPuntoVenta(Boolean mostrardescuentoFacturasPuntoVenta) {
		this.mostrardescuentoFacturasPuntoVenta= mostrardescuentoFacturasPuntoVenta;
	}

	public Boolean getActivardescuentoFacturasPuntoVenta() {
		return this.activardescuentoFacturasPuntoVenta;
	}

	public void setActivardescuentoFacturasPuntoVenta(Boolean activardescuentoFacturasPuntoVenta) {
		this.activardescuentoFacturasPuntoVenta= activardescuentoFacturasPuntoVenta;
	}

	public Border setResaltartotalFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturasPuntoVenta() {
		return this.resaltartotalFacturasPuntoVenta;
	}

	public void setResaltartotalFacturasPuntoVenta(Border borderResaltar) {
		this.resaltartotalFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalFacturasPuntoVenta() {
		return this.mostrartotalFacturasPuntoVenta;
	}

	public void setMostrartotalFacturasPuntoVenta(Boolean mostrartotalFacturasPuntoVenta) {
		this.mostrartotalFacturasPuntoVenta= mostrartotalFacturasPuntoVenta;
	}

	public Boolean getActivartotalFacturasPuntoVenta() {
		return this.activartotalFacturasPuntoVenta;
	}

	public void setActivartotalFacturasPuntoVenta(Boolean activartotalFacturasPuntoVenta) {
		this.activartotalFacturasPuntoVenta= activartotalFacturasPuntoVenta;
	}

	public Border setResaltarruc_clienteFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaspuntoventaBeanSwingJInternalFrame.jTtoolBarFacturasPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarruc_clienteFacturasPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteFacturasPuntoVenta() {
		return this.resaltarruc_clienteFacturasPuntoVenta;
	}

	public void setResaltarruc_clienteFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarruc_clienteFacturasPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarruc_clienteFacturasPuntoVenta() {
		return this.mostrarruc_clienteFacturasPuntoVenta;
	}

	public void setMostrarruc_clienteFacturasPuntoVenta(Boolean mostrarruc_clienteFacturasPuntoVenta) {
		this.mostrarruc_clienteFacturasPuntoVenta= mostrarruc_clienteFacturasPuntoVenta;
	}

	public Boolean getActivarruc_clienteFacturasPuntoVenta() {
		return this.activarruc_clienteFacturasPuntoVenta;
	}

	public void setActivarruc_clienteFacturasPuntoVenta(Boolean activarruc_clienteFacturasPuntoVenta) {
		this.activarruc_clienteFacturasPuntoVenta= activarruc_clienteFacturasPuntoVenta;
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
		
		
		this.setMostraridFacturasPuntoVenta(esInicial);
		this.setMostrarid_empresaFacturasPuntoVenta(esInicial);
		this.setMostrarfecha_desdeFacturasPuntoVenta(esInicial);
		this.setMostrarfecha_hastaFacturasPuntoVenta(esInicial);
		this.setMostrarnombre_completo_clienteFacturasPuntoVenta(esInicial);
		this.setMostrartotal_ivaFacturasPuntoVenta(esInicial);
		this.setMostrartotal_sin_ivaFacturasPuntoVenta(esInicial);
		this.setMostrarivaFacturasPuntoVenta(esInicial);
		this.setMostrardescuentoFacturasPuntoVenta(esInicial);
		this.setMostrartotalFacturasPuntoVenta(esInicial);
		this.setMostrarruc_clienteFacturasPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteFacturasPuntoVenta(esAsigna);
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
		
		
		this.setActivaridFacturasPuntoVenta(esInicial);
		this.setActivarid_empresaFacturasPuntoVenta(esInicial);
		this.setActivarfecha_desdeFacturasPuntoVenta(esInicial);
		this.setActivarfecha_hastaFacturasPuntoVenta(esInicial);
		this.setActivarnombre_completo_clienteFacturasPuntoVenta(esInicial);
		this.setActivartotal_ivaFacturasPuntoVenta(esInicial);
		this.setActivartotal_sin_ivaFacturasPuntoVenta(esInicial);
		this.setActivarivaFacturasPuntoVenta(esInicial);
		this.setActivardescuentoFacturasPuntoVenta(esInicial);
		this.setActivartotalFacturasPuntoVenta(esInicial);
		this.setActivarruc_clienteFacturasPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteFacturasPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturasPuntoVenta(esInicial);
		this.setResaltarid_empresaFacturasPuntoVenta(esInicial);
		this.setResaltarfecha_desdeFacturasPuntoVenta(esInicial);
		this.setResaltarfecha_hastaFacturasPuntoVenta(esInicial);
		this.setResaltarnombre_completo_clienteFacturasPuntoVenta(esInicial);
		this.setResaltartotal_ivaFacturasPuntoVenta(esInicial);
		this.setResaltartotal_sin_ivaFacturasPuntoVenta(esInicial);
		this.setResaltarivaFacturasPuntoVenta(esInicial);
		this.setResaltardescuentoFacturasPuntoVenta(esInicial);
		this.setResaltartotalFacturasPuntoVenta(esInicial);
		this.setResaltarruc_clienteFacturasPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturasPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasPuntoVentaConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteFacturasPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturasPuntoVentaFacturasPuntoVenta=true;

	public Boolean getMostrarBusquedaFacturasPuntoVentaFacturasPuntoVenta() {
		return this.mostrarBusquedaFacturasPuntoVentaFacturasPuntoVenta;
	}

	public void setMostrarBusquedaFacturasPuntoVentaFacturasPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturasPuntoVentaFacturasPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturasPuntoVentaFacturasPuntoVenta=true;

	public Boolean getActivarBusquedaFacturasPuntoVentaFacturasPuntoVenta() {
		return this.activarBusquedaFacturasPuntoVentaFacturasPuntoVenta;
	}

	public void setActivarBusquedaFacturasPuntoVentaFacturasPuntoVenta(Boolean habilitarResaltar) {
		this.activarBusquedaFacturasPuntoVentaFacturasPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta=null;

	public Border getResaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta() {
		return this.resaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta;
	}

	public void setResaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta(Border borderResaltar) {
		this.resaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta= borderResaltar;
	}

	public void setResaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasPuntoVentaBeanSwingJInternalFrame facturaspuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturasPuntoVentaFacturasPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
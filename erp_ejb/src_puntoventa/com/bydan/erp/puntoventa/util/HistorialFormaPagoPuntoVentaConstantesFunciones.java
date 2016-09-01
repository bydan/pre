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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



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
final public class HistorialFormaPagoPuntoVentaConstantesFunciones extends HistorialFormaPagoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialFormaPagoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialFormaPagoPuntoVenta"+HistorialFormaPagoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialFormaPagoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialFormaPagoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialFormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialFormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialFormaPagoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialFormaPagoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialFormaPagoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialFormaPagoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Forma Pago Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Historial Forma Pago Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Historial Forma Pago Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialFormaPagoPuntoVenta";
	public static final String OBJECTNAME="historialformapagopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="historial_forma_pago_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialformapagopuntoventa from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" historialformapagopuntoventa";
	public static String QUERYSELECTNATIVE="select "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal from "+HistorialFormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+HistorialFormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HistorialFormaPagoPuntoVentaConstantesFuncionesAdditional historialformapagopuntoventaConstantesFuncionesAdditional=null;
	
	public HistorialFormaPagoPuntoVentaConstantesFuncionesAdditional getHistorialFormaPagoPuntoVentaConstantesFuncionesAdditional() {
		return this.historialformapagopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setHistorialFormaPagoPuntoVentaConstantesFuncionesAdditional(HistorialFormaPagoPuntoVentaConstantesFuncionesAdditional historialformapagopuntoventaConstantesFuncionesAdditional) {
		try {
			this.historialformapagopuntoventaConstantesFuncionesAdditional=historialformapagopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDFACTURAPUNTOVENTA= "id_factura_punto_venta";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDFACTURAPUNTOVENTA= "Factura Punto Venta";
		public static final String LABEL_IDFACTURAPUNTOVENTA_LOWER= "Factura Punto Venta";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
	
		
		
		
		
		
	
	public static String getHistorialFormaPagoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {sLabelColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getHistorialFormaPagoPuntoVentaDescripcion(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialformapagopuntoventa !=null/* && historialformapagopuntoventa.getId()!=0*/) {
			if(historialformapagopuntoventa.getId()!=null) {
				sDescripcion=historialformapagopuntoventa.getId().toString();
			}//historialformapagopuntoventahistorialformapagopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialFormaPagoPuntoVentaDescripcionDetallado(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=HistorialFormaPagoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=historialformapagopuntoventa.getId().toString()+",";
		sDescripcion+=HistorialFormaPagoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialformapagopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA+"=";
		sDescripcion+=historialformapagopuntoventa.getid_factura_punto_venta().toString()+",";
		sDescripcion+=HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=historialformapagopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=historialformapagopuntoventa.getid_sucursal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialFormaPagoPuntoVentaDescripcion(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,String sValor) throws Exception {			
		if(historialformapagopuntoventa !=null) {
			//historialformapagopuntoventahistorialformapagopuntoventa.getId().toString();
		}		
	}
	
		

	public static String getFacturaPuntoVentaDescripcion(FacturaPuntoVenta facturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(facturapuntoventa!=null/*&&facturapuntoventa.getId()>0*/) {
			sDescripcion=FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(facturapuntoventa);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFacturaPuntoVenta")) {
			sNombreIndice="Tipo=  Por Factura Punto Venta";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFacturaPuntoVenta(Long id_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Factura Punto Venta="+id_factura_punto_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa: historialformapagopuntoventas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialformapagopuntoventa.getConCambioAuxiliar()) {
			historialformapagopuntoventa.setIsDeleted(historialformapagopuntoventa.getIsDeletedAuxiliar());	
			historialformapagopuntoventa.setIsNew(historialformapagopuntoventa.getIsNewAuxiliar());	
			historialformapagopuntoventa.setIsChanged(historialformapagopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialformapagopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialformapagopuntoventa.setIsDeletedAuxiliar(false);	
			historialformapagopuntoventa.setIsNewAuxiliar(false);	
			historialformapagopuntoventa.setIsChangedAuxiliar(false);
			
			historialformapagopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa : historialformapagopuntoventas) {
			if(conAsignarBase && historialformapagopuntoventa.getConCambioAuxiliar()) {
				historialformapagopuntoventa.setIsDeleted(historialformapagopuntoventa.getIsDeletedAuxiliar());	
				historialformapagopuntoventa.setIsNew(historialformapagopuntoventa.getIsNewAuxiliar());	
				historialformapagopuntoventa.setIsChanged(historialformapagopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialformapagopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialformapagopuntoventa.setIsDeletedAuxiliar(false);	
				historialformapagopuntoventa.setIsNewAuxiliar(false);	
				historialformapagopuntoventa.setIsChangedAuxiliar(false);
				
				historialformapagopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa: historialformapagopuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux) throws Exception  {
		HistorialFormaPagoPuntoVentaConstantesFunciones.InicializarValoresHistorialFormaPagoPuntoVenta(historialformapagopuntoventaAux,true);
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa: historialformapagopuntoventas) {
			if(historialformapagopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialFormaPagoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesHistorialFormaPagoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,HistorialFormaPagoPuntoVenta historialformapagopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux: historialformapagopuntoventas) {
			if(historialformapagopuntoventaAux!=null && historialformapagopuntoventa!=null) {
				if((historialformapagopuntoventaAux.getId()==null && historialformapagopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialformapagopuntoventaAux.getId()!=null && historialformapagopuntoventa.getId()!=null){
					if(historialformapagopuntoventaAux.getId().equals(historialformapagopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventa: historialformapagopuntoventas) {			
			if(historialformapagopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialFormaPagoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_ID, HistorialFormaPagoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, HistorialFormaPagoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA, HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialFormaPagoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPagoPuntoVenta() throws Exception  {
		return HistorialFormaPagoPuntoVentaConstantesFunciones.getTiposSeleccionarHistorialFormaPagoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPagoPuntoVenta(Boolean conFk) throws Exception  {
		return HistorialFormaPagoPuntoVentaConstantesFunciones.getTiposSeleccionarHistorialFormaPagoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialFormaPagoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
			reporte.setsDescripcion(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialFormaPagoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux) throws Exception {
		
			historialformapagopuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(historialformapagopuntoventaAux.getFacturaPuntoVenta()));
			historialformapagopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialformapagopuntoventaAux.getEmpresa()));
			historialformapagopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(historialformapagopuntoventaAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventasTemp) throws Exception {
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux:historialformapagopuntoventasTemp) {
			
			historialformapagopuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(historialformapagopuntoventaAux.getFacturaPuntoVenta()));
			historialformapagopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialformapagopuntoventaAux.getEmpresa()));
			historialformapagopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(historialformapagopuntoventaAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialFormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsOfHistorialFormaPagoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialFormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialFormaPagoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HistorialFormaPagoPuntoVenta historialformapagopuntoventaEncontrado=null;
			
			for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal:historialformapagopuntoventas) {
				if(historialformapagopuntoventaLocal.getId().equals(historialformapagopuntoventa.getId())) {
					historialformapagopuntoventaEncontrado=historialformapagopuntoventaLocal;
					
					historialformapagopuntoventaLocal.setIsChanged(historialformapagopuntoventa.getIsChanged());
					historialformapagopuntoventaLocal.setIsNew(historialformapagopuntoventa.getIsNew());
					historialformapagopuntoventaLocal.setIsDeleted(historialformapagopuntoventa.getIsDeleted());
					
					historialformapagopuntoventaLocal.setGeneralEntityOriginal(historialformapagopuntoventa.getGeneralEntityOriginal());
					
					historialformapagopuntoventaLocal.setId(historialformapagopuntoventa.getId());	
					historialformapagopuntoventaLocal.setVersionRow(historialformapagopuntoventa.getVersionRow());	
					historialformapagopuntoventaLocal.setid_factura_punto_venta(historialformapagopuntoventa.getid_factura_punto_venta());	
					historialformapagopuntoventaLocal.setid_empresa(historialformapagopuntoventa.getid_empresa());	
					historialformapagopuntoventaLocal.setid_sucursal(historialformapagopuntoventa.getid_sucursal());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!historialformapagopuntoventa.getIsDeleted()) {
				if(!existe) {
					historialformapagopuntoventas.add(historialformapagopuntoventa);
				}
			} else {
				if(historialformapagopuntoventaEncontrado!=null && permiteQuitar)  {
					historialformapagopuntoventas.remove(historialformapagopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HistorialFormaPagoPuntoVenta historialformapagopuntoventa,List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas) throws Exception {
		try	{			
			for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal:historialformapagopuntoventas) {
				if(historialformapagopuntoventaLocal.getId().equals(historialformapagopuntoventa.getId())) {
					historialformapagopuntoventaLocal.setIsSelected(historialformapagopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialFormaPagoPuntoVenta(List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventasAux) throws Exception {
		//this.historialformapagopuntoventasAux=historialformapagopuntoventasAux;
		
		for(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux:historialformapagopuntoventasAux) {
			if(historialformapagopuntoventaAux.getIsChanged()) {
				historialformapagopuntoventaAux.setIsChanged(false);
			}		
			
			if(historialformapagopuntoventaAux.getIsNew()) {
				historialformapagopuntoventaAux.setIsNew(false);
			}	
			
			if(historialformapagopuntoventaAux.getIsDeleted()) {
				historialformapagopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAux) throws Exception {
		//this.historialformapagopuntoventaAux=historialformapagopuntoventaAux;
		
			if(historialformapagopuntoventaAux.getIsChanged()) {
				historialformapagopuntoventaAux.setIsChanged(false);
			}		
			
			if(historialformapagopuntoventaAux.getIsNew()) {
				historialformapagopuntoventaAux.setIsNew(false);
			}	
			
			if(historialformapagopuntoventaAux.getIsDeleted()) {
				historialformapagopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialFormaPagoPuntoVenta historialformapagopuntoventaAsignar,HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {
		historialformapagopuntoventaAsignar.setId(historialformapagopuntoventa.getId());	
		historialformapagopuntoventaAsignar.setVersionRow(historialformapagopuntoventa.getVersionRow());	
		historialformapagopuntoventaAsignar.setid_factura_punto_venta(historialformapagopuntoventa.getid_factura_punto_venta());
		historialformapagopuntoventaAsignar.setfacturapuntoventa_descripcion(historialformapagopuntoventa.getfacturapuntoventa_descripcion());	
		historialformapagopuntoventaAsignar.setid_empresa(historialformapagopuntoventa.getid_empresa());
		historialformapagopuntoventaAsignar.setempresa_descripcion(historialformapagopuntoventa.getempresa_descripcion());	
		historialformapagopuntoventaAsignar.setid_sucursal(historialformapagopuntoventa.getid_sucursal());
		historialformapagopuntoventaAsignar.setsucursal_descripcion(historialformapagopuntoventa.getsucursal_descripcion());	
	}
	
	public static void inicializarHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) throws Exception {
		try {
				historialformapagopuntoventa.setId(0L);	
					
				historialformapagopuntoventa.setid_factura_punto_venta(-1L);	
				historialformapagopuntoventa.setid_empresa(-1L);	
				historialformapagopuntoventa.setid_sucursal(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialFormaPagoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialFormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialFormaPagoPuntoVenta(String sTipo,Row row,Workbook workbook,HistorialFormaPagoPuntoVenta historialformapagopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapagopuntoventa.getfacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapagopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialformapagopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialFormaPagoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHistorialFormaPagoPuntoVenta() {
		return this.sFinalQueryHistorialFormaPagoPuntoVenta;
	}
	
	public void setsFinalQueryHistorialFormaPagoPuntoVenta(String sFinalQueryHistorialFormaPagoPuntoVenta) {
		this.sFinalQueryHistorialFormaPagoPuntoVenta= sFinalQueryHistorialFormaPagoPuntoVenta;
	}
	
	public Border resaltarSeleccionarHistorialFormaPagoPuntoVenta=null;
	
	public Border setResaltarSeleccionarHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialformapagopuntoventaBeanSwingJInternalFrame.jTtoolBarHistorialFormaPagoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialFormaPagoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialFormaPagoPuntoVenta() {
		return this.resaltarSeleccionarHistorialFormaPagoPuntoVenta;
	}
	
	public void setResaltarSeleccionarHistorialFormaPagoPuntoVenta(Border borderResaltarSeleccionarHistorialFormaPagoPuntoVenta) {
		this.resaltarSeleccionarHistorialFormaPagoPuntoVenta= borderResaltarSeleccionarHistorialFormaPagoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialFormaPagoPuntoVenta=null;
	public Boolean mostraridHistorialFormaPagoPuntoVenta=true;
	public Boolean activaridHistorialFormaPagoPuntoVenta=true;

	public Border resaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta=null;
	public Boolean mostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta=true;
	public Boolean activarid_factura_punto_ventaHistorialFormaPagoPuntoVenta=true;
	public Boolean cargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factura_punto_ventaHistorialFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_empresaHistorialFormaPagoPuntoVenta=null;
	public Boolean mostrarid_empresaHistorialFormaPagoPuntoVenta=true;
	public Boolean activarid_empresaHistorialFormaPagoPuntoVenta=true;
	public Boolean cargarid_empresaHistorialFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHistorialFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalHistorialFormaPagoPuntoVenta=null;
	public Boolean mostrarid_sucursalHistorialFormaPagoPuntoVenta=true;
	public Boolean activarid_sucursalHistorialFormaPagoPuntoVenta=true;
	public Boolean cargarid_sucursalHistorialFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalHistorialFormaPagoPuntoVenta=false;//ConEventDepend=true

	
	

	public Border setResaltaridHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagopuntoventaBeanSwingJInternalFrame.jTtoolBarHistorialFormaPagoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridHistorialFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialFormaPagoPuntoVenta() {
		return this.resaltaridHistorialFormaPagoPuntoVenta;
	}

	public void setResaltaridHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltaridHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridHistorialFormaPagoPuntoVenta() {
		return this.mostraridHistorialFormaPagoPuntoVenta;
	}

	public void setMostraridHistorialFormaPagoPuntoVenta(Boolean mostraridHistorialFormaPagoPuntoVenta) {
		this.mostraridHistorialFormaPagoPuntoVenta= mostraridHistorialFormaPagoPuntoVenta;
	}

	public Boolean getActivaridHistorialFormaPagoPuntoVenta() {
		return this.activaridHistorialFormaPagoPuntoVenta;
	}

	public void setActivaridHistorialFormaPagoPuntoVenta(Boolean activaridHistorialFormaPagoPuntoVenta) {
		this.activaridHistorialFormaPagoPuntoVenta= activaridHistorialFormaPagoPuntoVenta;
	}

	public Border setResaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagopuntoventaBeanSwingJInternalFrame.jTtoolBarHistorialFormaPagoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta() {
		return this.resaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta() {
		return this.mostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(Boolean mostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta) {
		this.mostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta= mostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_factura_punto_ventaHistorialFormaPagoPuntoVenta() {
		return this.activarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public void setActivarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(Boolean activarid_factura_punto_ventaHistorialFormaPagoPuntoVenta) {
		this.activarid_factura_punto_ventaHistorialFormaPagoPuntoVenta= activarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta() {
		return this.cargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public void setCargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(Boolean cargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta) {
		this.cargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta= cargarid_factura_punto_ventaHistorialFormaPagoPuntoVenta;
	}

	public Border setResaltarid_empresaHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagopuntoventaBeanSwingJInternalFrame.jTtoolBarHistorialFormaPagoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaHistorialFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHistorialFormaPagoPuntoVenta() {
		return this.resaltarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarid_empresaHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaHistorialFormaPagoPuntoVenta() {
		return this.mostrarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarid_empresaHistorialFormaPagoPuntoVenta(Boolean mostrarid_empresaHistorialFormaPagoPuntoVenta) {
		this.mostrarid_empresaHistorialFormaPagoPuntoVenta= mostrarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_empresaHistorialFormaPagoPuntoVenta() {
		return this.activarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public void setActivarid_empresaHistorialFormaPagoPuntoVenta(Boolean activarid_empresaHistorialFormaPagoPuntoVenta) {
		this.activarid_empresaHistorialFormaPagoPuntoVenta= activarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_empresaHistorialFormaPagoPuntoVenta() {
		return this.cargarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public void setCargarid_empresaHistorialFormaPagoPuntoVenta(Boolean cargarid_empresaHistorialFormaPagoPuntoVenta) {
		this.cargarid_empresaHistorialFormaPagoPuntoVenta= cargarid_empresaHistorialFormaPagoPuntoVenta;
	}

	public Border setResaltarid_sucursalHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialformapagopuntoventaBeanSwingJInternalFrame.jTtoolBarHistorialFormaPagoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalHistorialFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalHistorialFormaPagoPuntoVenta() {
		return this.resaltarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarid_sucursalHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalHistorialFormaPagoPuntoVenta() {
		return this.mostrarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarid_sucursalHistorialFormaPagoPuntoVenta(Boolean mostrarid_sucursalHistorialFormaPagoPuntoVenta) {
		this.mostrarid_sucursalHistorialFormaPagoPuntoVenta= mostrarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_sucursalHistorialFormaPagoPuntoVenta() {
		return this.activarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public void setActivarid_sucursalHistorialFormaPagoPuntoVenta(Boolean activarid_sucursalHistorialFormaPagoPuntoVenta) {
		this.activarid_sucursalHistorialFormaPagoPuntoVenta= activarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_sucursalHistorialFormaPagoPuntoVenta() {
		return this.cargarid_sucursalHistorialFormaPagoPuntoVenta;
	}

	public void setCargarid_sucursalHistorialFormaPagoPuntoVenta(Boolean cargarid_sucursalHistorialFormaPagoPuntoVenta) {
		this.cargarid_sucursalHistorialFormaPagoPuntoVenta= cargarid_sucursalHistorialFormaPagoPuntoVenta;
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
		
		
		this.setMostraridHistorialFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_empresaHistorialFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_sucursalHistorialFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setMostrarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalHistorialFormaPagoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridHistorialFormaPagoPuntoVenta(esInicial);
		this.setActivarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esInicial);
		this.setActivarid_empresaHistorialFormaPagoPuntoVenta(esInicial);
		this.setActivarid_sucursalHistorialFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setActivarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_empresaHistorialFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_sucursalHistorialFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setResaltarid_factura_punto_ventaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHistorialFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialFormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalHistorialFormaPagoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaHistorialFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaHistorialFormaPagoPuntoVenta() {
		return this.mostrarFK_IdEmpresaHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaHistorialFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHistorialFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta() {
		return this.mostrarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalHistorialFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalHistorialFormaPagoPuntoVenta() {
		return this.mostrarFK_IdSucursalHistorialFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalHistorialFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalHistorialFormaPagoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaHistorialFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaHistorialFormaPagoPuntoVenta() {
		return this.activarFK_IdEmpresaHistorialFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaHistorialFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHistorialFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta() {
		return this.activarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalHistorialFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalHistorialFormaPagoPuntoVenta() {
		return this.activarFK_IdSucursalHistorialFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdSucursalHistorialFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalHistorialFormaPagoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta() {
		return this.resaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta() {
		return this.resaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaPuntoVentaHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalHistorialFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalHistorialFormaPagoPuntoVenta() {
		return this.resaltarFK_IdSucursalHistorialFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalHistorialFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalHistorialFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalHistorialFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialFormaPagoPuntoVentaBeanSwingJInternalFrame historialformapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalHistorialFormaPagoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
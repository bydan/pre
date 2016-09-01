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


import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFacturaPuntoVentaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFacturaPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFacturaPuntoVenta"+TipoFacturaPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFacturaPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFacturaPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFacturaPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFacturaPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Factura Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Factura Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Factura Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFacturaPuntoVenta";
	public static final String OBJECTNAME="tipofacturapuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tipo_factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipofacturapuntoventa from "+TipoFacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" tipofacturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre,"+TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME+".descripcion from "+TipoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+TipoFacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoFacturaPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFacturaPuntoVentaDescripcion(TipoFacturaPuntoVenta tipofacturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipofacturapuntoventa !=null/* && tipofacturapuntoventa.getId()!=0*/) {
			sDescripcion=tipofacturapuntoventa.getnombre();//tipofacturapuntoventatipofacturapuntoventa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFacturaPuntoVentaDescripcionDetallado(TipoFacturaPuntoVenta tipofacturapuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=TipoFacturaPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=tipofacturapuntoventa.getId().toString()+",";
		sDescripcion+=TipoFacturaPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipofacturapuntoventa.getVersionRow().toString()+",";
		sDescripcion+=TipoFacturaPuntoVentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipofacturapuntoventa.getnombre()+",";
		sDescripcion+=TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipofacturapuntoventa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFacturaPuntoVentaDescripcion(TipoFacturaPuntoVenta tipofacturapuntoventa,String sValor) throws Exception {			
		if(tipofacturapuntoventa !=null) {
			tipofacturapuntoventa.setnombre(sValor);;//tipofacturapuntoventatipofacturapuntoventa.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipofacturapuntoventa.setnombre(tipofacturapuntoventa.getnombre().trim());
		tipofacturapuntoventa.setdescripcion(tipofacturapuntoventa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoFacturaPuntoVentas(List<TipoFacturaPuntoVenta> tipofacturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa: tipofacturapuntoventas) {
			tipofacturapuntoventa.setnombre(tipofacturapuntoventa.getnombre().trim());
			tipofacturapuntoventa.setdescripcion(tipofacturapuntoventa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipofacturapuntoventa.getConCambioAuxiliar()) {
			tipofacturapuntoventa.setIsDeleted(tipofacturapuntoventa.getIsDeletedAuxiliar());	
			tipofacturapuntoventa.setIsNew(tipofacturapuntoventa.getIsNewAuxiliar());	
			tipofacturapuntoventa.setIsChanged(tipofacturapuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipofacturapuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipofacturapuntoventa.setIsDeletedAuxiliar(false);	
			tipofacturapuntoventa.setIsNewAuxiliar(false);	
			tipofacturapuntoventa.setIsChangedAuxiliar(false);
			
			tipofacturapuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFacturaPuntoVentas(List<TipoFacturaPuntoVenta> tipofacturapuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa : tipofacturapuntoventas) {
			if(conAsignarBase && tipofacturapuntoventa.getConCambioAuxiliar()) {
				tipofacturapuntoventa.setIsDeleted(tipofacturapuntoventa.getIsDeletedAuxiliar());	
				tipofacturapuntoventa.setIsNew(tipofacturapuntoventa.getIsNewAuxiliar());	
				tipofacturapuntoventa.setIsChanged(tipofacturapuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipofacturapuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipofacturapuntoventa.setIsDeletedAuxiliar(false);	
				tipofacturapuntoventa.setIsNewAuxiliar(false);	
				tipofacturapuntoventa.setIsChangedAuxiliar(false);
				
				tipofacturapuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFacturaPuntoVentas(List<TipoFacturaPuntoVenta> tipofacturapuntoventas,Boolean conEnteros) throws Exception  {
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa: tipofacturapuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVenta tipofacturapuntoventaAux) throws Exception  {
		TipoFacturaPuntoVentaConstantesFunciones.InicializarValoresTipoFacturaPuntoVenta(tipofacturapuntoventaAux,true);
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventa: tipofacturapuntoventas) {
			if(tipofacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFacturaPuntoVentaConstantesFunciones.getArrayColumnasGlobalesTipoFacturaPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFacturaPuntoVenta> tipofacturapuntoventas,TipoFacturaPuntoVenta tipofacturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventaAux: tipofacturapuntoventas) {
			if(tipofacturapuntoventaAux!=null && tipofacturapuntoventa!=null) {
				if((tipofacturapuntoventaAux.getId()==null && tipofacturapuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipofacturapuntoventaAux.getId()!=null && tipofacturapuntoventa.getId()!=null){
					if(tipofacturapuntoventaAux.getId().equals(tipofacturapuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> tipofacturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFacturaPuntoVenta tipofacturapuntoventa: tipofacturapuntoventas) {			
			if(tipofacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFacturaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFacturaPuntoVentaConstantesFunciones.LABEL_ID, TipoFacturaPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaPuntoVentaConstantesFunciones.LABEL_VERSIONROW, TipoFacturaPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE, TipoFacturaPuntoVentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION, TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFacturaPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaPuntoVentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFacturaPuntoVenta() throws Exception  {
		return TipoFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarTipoFacturaPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFacturaPuntoVenta(Boolean conFk) throws Exception  {
		return TipoFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarTipoFacturaPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFacturaPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFacturaPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> tipofacturapuntoventasTemp) throws Exception {
		for(TipoFacturaPuntoVenta tipofacturapuntoventaAux:tipofacturapuntoventasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfTipoFacturaPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFacturaPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoFacturaPuntoVenta tipofacturapuntoventa,List<TipoFacturaPuntoVenta> tipofacturapuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFacturaPuntoVenta tipofacturapuntoventaEncontrado=null;
			
			for(TipoFacturaPuntoVenta tipofacturapuntoventaLocal:tipofacturapuntoventas) {
				if(tipofacturapuntoventaLocal.getId().equals(tipofacturapuntoventa.getId())) {
					tipofacturapuntoventaEncontrado=tipofacturapuntoventaLocal;
					
					tipofacturapuntoventaLocal.setIsChanged(tipofacturapuntoventa.getIsChanged());
					tipofacturapuntoventaLocal.setIsNew(tipofacturapuntoventa.getIsNew());
					tipofacturapuntoventaLocal.setIsDeleted(tipofacturapuntoventa.getIsDeleted());
					
					tipofacturapuntoventaLocal.setGeneralEntityOriginal(tipofacturapuntoventa.getGeneralEntityOriginal());
					
					tipofacturapuntoventaLocal.setId(tipofacturapuntoventa.getId());	
					tipofacturapuntoventaLocal.setVersionRow(tipofacturapuntoventa.getVersionRow());	
					tipofacturapuntoventaLocal.setnombre(tipofacturapuntoventa.getnombre());	
					tipofacturapuntoventaLocal.setdescripcion(tipofacturapuntoventa.getdescripcion());	
					
					
					tipofacturapuntoventaLocal.setFacturaPuntoVentas(tipofacturapuntoventa.getFacturaPuntoVentas());
					tipofacturapuntoventaLocal.setNotaCreditoPuntoVentas(tipofacturapuntoventa.getNotaCreditoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipofacturapuntoventa.getIsDeleted()) {
				if(!existe) {
					tipofacturapuntoventas.add(tipofacturapuntoventa);
				}
			} else {
				if(tipofacturapuntoventaEncontrado!=null && permiteQuitar)  {
					tipofacturapuntoventas.remove(tipofacturapuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFacturaPuntoVenta tipofacturapuntoventa,List<TipoFacturaPuntoVenta> tipofacturapuntoventas) throws Exception {
		try	{			
			for(TipoFacturaPuntoVenta tipofacturapuntoventaLocal:tipofacturapuntoventas) {
				if(tipofacturapuntoventaLocal.getId().equals(tipofacturapuntoventa.getId())) {
					tipofacturapuntoventaLocal.setIsSelected(tipofacturapuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFacturaPuntoVenta(List<TipoFacturaPuntoVenta> tipofacturapuntoventasAux) throws Exception {
		//this.tipofacturapuntoventasAux=tipofacturapuntoventasAux;
		
		for(TipoFacturaPuntoVenta tipofacturapuntoventaAux:tipofacturapuntoventasAux) {
			if(tipofacturapuntoventaAux.getIsChanged()) {
				tipofacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(tipofacturapuntoventaAux.getIsNew()) {
				tipofacturapuntoventaAux.setIsNew(false);
			}	
			
			if(tipofacturapuntoventaAux.getIsDeleted()) {
				tipofacturapuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventaAux) throws Exception {
		//this.tipofacturapuntoventaAux=tipofacturapuntoventaAux;
		
			if(tipofacturapuntoventaAux.getIsChanged()) {
				tipofacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(tipofacturapuntoventaAux.getIsNew()) {
				tipofacturapuntoventaAux.setIsNew(false);
			}	
			
			if(tipofacturapuntoventaAux.getIsDeleted()) {
				tipofacturapuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFacturaPuntoVenta tipofacturapuntoventaAsignar,TipoFacturaPuntoVenta tipofacturapuntoventa) throws Exception {
		tipofacturapuntoventaAsignar.setId(tipofacturapuntoventa.getId());	
		tipofacturapuntoventaAsignar.setVersionRow(tipofacturapuntoventa.getVersionRow());	
		tipofacturapuntoventaAsignar.setnombre(tipofacturapuntoventa.getnombre());	
		tipofacturapuntoventaAsignar.setdescripcion(tipofacturapuntoventa.getdescripcion());	
	}
	
	public static void inicializarTipoFacturaPuntoVenta(TipoFacturaPuntoVenta tipofacturapuntoventa) throws Exception {
		try {
				tipofacturapuntoventa.setId(0L);	
					
				tipofacturapuntoventa.setnombre("");	
				tipofacturapuntoventa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFacturaPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFacturaPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFacturaPuntoVenta(String sTipo,Row row,Workbook workbook,TipoFacturaPuntoVenta tipofacturapuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofacturapuntoventa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipofacturapuntoventa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFacturaPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFacturaPuntoVenta() {
		return this.sFinalQueryTipoFacturaPuntoVenta;
	}
	
	public void setsFinalQueryTipoFacturaPuntoVenta(String sFinalQueryTipoFacturaPuntoVenta) {
		this.sFinalQueryTipoFacturaPuntoVenta= sFinalQueryTipoFacturaPuntoVenta;
	}
	
	public Border resaltarSeleccionarTipoFacturaPuntoVenta=null;
	
	public Border setResaltarSeleccionarTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFacturaPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFacturaPuntoVenta() {
		return this.resaltarSeleccionarTipoFacturaPuntoVenta;
	}
	
	public void setResaltarSeleccionarTipoFacturaPuntoVenta(Border borderResaltarSeleccionarTipoFacturaPuntoVenta) {
		this.resaltarSeleccionarTipoFacturaPuntoVenta= borderResaltarSeleccionarTipoFacturaPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFacturaPuntoVenta=null;
	public Boolean mostraridTipoFacturaPuntoVenta=true;
	public Boolean activaridTipoFacturaPuntoVenta=true;

	public Border resaltarnombreTipoFacturaPuntoVenta=null;
	public Boolean mostrarnombreTipoFacturaPuntoVenta=true;
	public Boolean activarnombreTipoFacturaPuntoVenta=true;

	public Border resaltardescripcionTipoFacturaPuntoVenta=null;
	public Boolean mostrardescripcionTipoFacturaPuntoVenta=true;
	public Boolean activardescripcionTipoFacturaPuntoVenta=true;

	
	

	public Border setResaltaridTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridTipoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFacturaPuntoVenta() {
		return this.resaltaridTipoFacturaPuntoVenta;
	}

	public void setResaltaridTipoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltaridTipoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridTipoFacturaPuntoVenta() {
		return this.mostraridTipoFacturaPuntoVenta;
	}

	public void setMostraridTipoFacturaPuntoVenta(Boolean mostraridTipoFacturaPuntoVenta) {
		this.mostraridTipoFacturaPuntoVenta= mostraridTipoFacturaPuntoVenta;
	}

	public Boolean getActivaridTipoFacturaPuntoVenta() {
		return this.activaridTipoFacturaPuntoVenta;
	}

	public void setActivaridTipoFacturaPuntoVenta(Boolean activaridTipoFacturaPuntoVenta) {
		this.activaridTipoFacturaPuntoVenta= activaridTipoFacturaPuntoVenta;
	}

	public Border setResaltarnombreTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFacturaPuntoVenta() {
		return this.resaltarnombreTipoFacturaPuntoVenta;
	}

	public void setResaltarnombreTipoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarnombreTipoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFacturaPuntoVenta() {
		return this.mostrarnombreTipoFacturaPuntoVenta;
	}

	public void setMostrarnombreTipoFacturaPuntoVenta(Boolean mostrarnombreTipoFacturaPuntoVenta) {
		this.mostrarnombreTipoFacturaPuntoVenta= mostrarnombreTipoFacturaPuntoVenta;
	}

	public Boolean getActivarnombreTipoFacturaPuntoVenta() {
		return this.activarnombreTipoFacturaPuntoVenta;
	}

	public void setActivarnombreTipoFacturaPuntoVenta(Boolean activarnombreTipoFacturaPuntoVenta) {
		this.activarnombreTipoFacturaPuntoVenta= activarnombreTipoFacturaPuntoVenta;
	}

	public Border setResaltardescripcionTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoFacturaPuntoVenta() {
		return this.resaltardescripcionTipoFacturaPuntoVenta;
	}

	public void setResaltardescripcionTipoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltardescripcionTipoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoFacturaPuntoVenta() {
		return this.mostrardescripcionTipoFacturaPuntoVenta;
	}

	public void setMostrardescripcionTipoFacturaPuntoVenta(Boolean mostrardescripcionTipoFacturaPuntoVenta) {
		this.mostrardescripcionTipoFacturaPuntoVenta= mostrardescripcionTipoFacturaPuntoVenta;
	}

	public Boolean getActivardescripcionTipoFacturaPuntoVenta() {
		return this.activardescripcionTipoFacturaPuntoVenta;
	}

	public void setActivardescripcionTipoFacturaPuntoVenta(Boolean activardescripcionTipoFacturaPuntoVenta) {
		this.activardescripcionTipoFacturaPuntoVenta= activardescripcionTipoFacturaPuntoVenta;
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
		
		
		this.setMostraridTipoFacturaPuntoVenta(esInicial);
		this.setMostrarnombreTipoFacturaPuntoVenta(esInicial);
		this.setMostrardescripcionTipoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoFacturaPuntoVenta(esAsigna);
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
		
		
		this.setActivaridTipoFacturaPuntoVenta(esInicial);
		this.setActivarnombreTipoFacturaPuntoVenta(esInicial);
		this.setActivardescripcionTipoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFacturaPuntoVenta(esInicial);
		this.setResaltarnombreTipoFacturaPuntoVenta(esInicial);
		this.setResaltardescripcionTipoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFacturaPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaPuntoVentaTipoFacturaPuntoVenta=null;

	public Border getResaltarFacturaPuntoVentaTipoFacturaPuntoVenta() {
		return this.resaltarFacturaPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setResaltarFacturaPuntoVentaTipoFacturaPuntoVenta(Border borderResaltarFacturaPuntoVenta) {
		if(borderResaltarFacturaPuntoVenta!=null) {
			this.resaltarFacturaPuntoVentaTipoFacturaPuntoVenta= borderResaltarFacturaPuntoVenta;
		}
	}

	public Border setResaltarFacturaPuntoVentaTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltarFacturaPuntoVenta);
			
		this.resaltarFacturaPuntoVentaTipoFacturaPuntoVenta= borderResaltarFacturaPuntoVenta;

		 return borderResaltarFacturaPuntoVenta;
	}



	public Boolean mostrarFacturaPuntoVentaTipoFacturaPuntoVenta=true;

	public Boolean getMostrarFacturaPuntoVentaTipoFacturaPuntoVenta() {
		return this.mostrarFacturaPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setMostrarFacturaPuntoVentaTipoFacturaPuntoVenta(Boolean visibilidadResaltarFacturaPuntoVenta) {
		this.mostrarFacturaPuntoVentaTipoFacturaPuntoVenta= visibilidadResaltarFacturaPuntoVenta;
	}



	public Boolean activarFacturaPuntoVentaTipoFacturaPuntoVenta=true;

	public Boolean gethabilitarResaltarFacturaPuntoVentaTipoFacturaPuntoVenta() {
		return this.activarFacturaPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setActivarFacturaPuntoVentaTipoFacturaPuntoVenta(Boolean habilitarResaltarFacturaPuntoVenta) {
		this.activarFacturaPuntoVentaTipoFacturaPuntoVenta= habilitarResaltarFacturaPuntoVenta;
	}


	public Border resaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta=null;

	public Border getResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta() {
		return this.resaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarTipoFacturaPuntoVenta.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta=true;

	public Boolean getMostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta() {
		return this.mostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setMostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaTipoFacturaPuntoVenta=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta() {
		return this.activarNotaCreditoPuntoVentaTipoFacturaPuntoVenta;
	}

	public void setActivarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaTipoFacturaPuntoVenta= habilitarResaltarNotaCreditoPuntoVenta;
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

		this.setMostrarFacturaPuntoVentaTipoFacturaPuntoVenta(esInicial);
		this.setMostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setMostrarFacturaPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}
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

		this.setActivarFacturaPuntoVentaTipoFacturaPuntoVenta(esInicial);
		this.setActivarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setActivarFacturaPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFacturaPuntoVentaBeanSwingJInternalFrame tipofacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaPuntoVentaTipoFacturaPuntoVenta(esInicial);
		this.setResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setResaltarFacturaPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaTipoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}
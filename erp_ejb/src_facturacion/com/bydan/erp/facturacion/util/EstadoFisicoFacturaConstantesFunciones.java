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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoFisicoFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFisicoFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



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
final public class EstadoFisicoFacturaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoFisicoFactura";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoFisicoFactura"+EstadoFisicoFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoFisicoFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoFisicoFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoFisicoFacturaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoFisicoFacturaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoFisicoFacturaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoFisicoFacturaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoFisicoFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoFisicoFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoFisicoFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoFisicoFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Fisico Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Fisico Factura";
	public static final String SCLASSWEBTITULO_LOWER="Estado Fisico Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoFisicoFactura";
	public static final String OBJECTNAME="estadofisicofactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_fisico_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadofisicofactura from "+EstadoFisicoFacturaConstantesFunciones.SPERSISTENCENAME+" estadofisicofactura";
	public static String QUERYSELECTNATIVE="select "+EstadoFisicoFacturaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaConstantesFunciones.TABLENAME+".id,"+EstadoFisicoFacturaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaConstantesFunciones.TABLENAME+".version_row,"+EstadoFisicoFacturaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaConstantesFunciones.TABLENAME+".id_pais,"+EstadoFisicoFacturaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaConstantesFunciones.TABLENAME+".nombre from "+EstadoFisicoFacturaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaConstantesFunciones.TABLENAME;//+" as "+EstadoFisicoFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoFisicoFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoFisicoFacturaConstantesFunciones.IDPAIS)) {sLabelColumna=EstadoFisicoFacturaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(EstadoFisicoFacturaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoFisicoFacturaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoFisicoFacturaDescripcion(EstadoFisicoFactura estadofisicofactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadofisicofactura !=null/* && estadofisicofactura.getId()!=0*/) {
			sDescripcion=estadofisicofactura.getnombre();//estadofisicofacturaestadofisicofactura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoFisicoFacturaDescripcionDetallado(EstadoFisicoFactura estadofisicofactura) {
		String sDescripcion="";
			
		sDescripcion+=EstadoFisicoFacturaConstantesFunciones.ID+"=";
		sDescripcion+=estadofisicofactura.getId().toString()+",";
		sDescripcion+=EstadoFisicoFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadofisicofactura.getVersionRow().toString()+",";
		sDescripcion+=EstadoFisicoFacturaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=estadofisicofactura.getid_pais().toString()+",";
		sDescripcion+=EstadoFisicoFacturaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadofisicofactura.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoFisicoFacturaDescripcion(EstadoFisicoFactura estadofisicofactura,String sValor) throws Exception {			
		if(estadofisicofactura !=null) {
			estadofisicofactura.setnombre(sValor);//estadofisicofacturaestadofisicofactura.getId().toString();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoFisicoFactura(EstadoFisicoFactura estadofisicofactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadofisicofactura.setnombre(estadofisicofactura.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoFisicoFacturas(List<EstadoFisicoFactura> estadofisicofacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoFisicoFactura estadofisicofactura: estadofisicofacturas) {
			estadofisicofactura.setnombre(estadofisicofactura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFisicoFactura(EstadoFisicoFactura estadofisicofactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadofisicofactura.getConCambioAuxiliar()) {
			estadofisicofactura.setIsDeleted(estadofisicofactura.getIsDeletedAuxiliar());	
			estadofisicofactura.setIsNew(estadofisicofactura.getIsNewAuxiliar());	
			estadofisicofactura.setIsChanged(estadofisicofactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadofisicofactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadofisicofactura.setIsDeletedAuxiliar(false);	
			estadofisicofactura.setIsNewAuxiliar(false);	
			estadofisicofactura.setIsChangedAuxiliar(false);
			
			estadofisicofactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFisicoFacturas(List<EstadoFisicoFactura> estadofisicofacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoFisicoFactura estadofisicofactura : estadofisicofacturas) {
			if(conAsignarBase && estadofisicofactura.getConCambioAuxiliar()) {
				estadofisicofactura.setIsDeleted(estadofisicofactura.getIsDeletedAuxiliar());	
				estadofisicofactura.setIsNew(estadofisicofactura.getIsNewAuxiliar());	
				estadofisicofactura.setIsChanged(estadofisicofactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadofisicofactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadofisicofactura.setIsDeletedAuxiliar(false);	
				estadofisicofactura.setIsNewAuxiliar(false);	
				estadofisicofactura.setIsChangedAuxiliar(false);
				
				estadofisicofactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoFisicoFactura(EstadoFisicoFactura estadofisicofactura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoFisicoFacturas(List<EstadoFisicoFactura> estadofisicofacturas,Boolean conEnteros) throws Exception  {
		
		for(EstadoFisicoFactura estadofisicofactura: estadofisicofacturas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoFisicoFactura(List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFactura estadofisicofacturaAux) throws Exception  {
		EstadoFisicoFacturaConstantesFunciones.InicializarValoresEstadoFisicoFactura(estadofisicofacturaAux,true);
		
		for(EstadoFisicoFactura estadofisicofactura: estadofisicofacturas) {
			if(estadofisicofactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFisicoFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoFisicoFacturaConstantesFunciones.getArrayColumnasGlobalesEstadoFisicoFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFisicoFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoFisicoFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFactura estadofisicofactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoFisicoFactura estadofisicofacturaAux: estadofisicofacturas) {
			if(estadofisicofacturaAux!=null && estadofisicofactura!=null) {
				if((estadofisicofacturaAux.getId()==null && estadofisicofactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadofisicofacturaAux.getId()!=null && estadofisicofactura.getId()!=null){
					if(estadofisicofacturaAux.getId().equals(estadofisicofactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoFisicoFactura(List<EstadoFisicoFactura> estadofisicofacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoFisicoFactura estadofisicofactura: estadofisicofacturas) {			
			if(estadofisicofactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoFisicoFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoFisicoFacturaConstantesFunciones.LABEL_ID, EstadoFisicoFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaConstantesFunciones.LABEL_VERSIONROW, EstadoFisicoFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaConstantesFunciones.LABEL_IDPAIS, EstadoFisicoFacturaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaConstantesFunciones.LABEL_NOMBRE, EstadoFisicoFacturaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoFisicoFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFactura() throws Exception  {
		return EstadoFisicoFacturaConstantesFunciones.getTiposSeleccionarEstadoFisicoFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFactura(Boolean conFk) throws Exception  {
		return EstadoFisicoFacturaConstantesFunciones.getTiposSeleccionarEstadoFisicoFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(EstadoFisicoFacturaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoFisicoFacturaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoFisicoFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFisicoFactura(EstadoFisicoFactura estadofisicofacturaAux) throws Exception {
		
			estadofisicofacturaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(estadofisicofacturaAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFisicoFactura(List<EstadoFisicoFactura> estadofisicofacturasTemp) throws Exception {
		for(EstadoFisicoFactura estadofisicofacturaAux:estadofisicofacturasTemp) {
			
			estadofisicofacturaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(estadofisicofacturaAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFisicoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoFisicoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFisicoFacturaConstantesFunciones.getClassesRelationshipsOfEstadoFisicoFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFisicoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFisicoFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoFisicoFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFisicoFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EstadoFisicoFactura estadofisicofactura,List<EstadoFisicoFactura> estadofisicofacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoFisicoFactura estadofisicofacturaEncontrado=null;
			
			for(EstadoFisicoFactura estadofisicofacturaLocal:estadofisicofacturas) {
				if(estadofisicofacturaLocal.getId().equals(estadofisicofactura.getId())) {
					estadofisicofacturaEncontrado=estadofisicofacturaLocal;
					
					estadofisicofacturaLocal.setIsChanged(estadofisicofactura.getIsChanged());
					estadofisicofacturaLocal.setIsNew(estadofisicofactura.getIsNew());
					estadofisicofacturaLocal.setIsDeleted(estadofisicofactura.getIsDeleted());
					
					estadofisicofacturaLocal.setGeneralEntityOriginal(estadofisicofactura.getGeneralEntityOriginal());
					
					estadofisicofacturaLocal.setId(estadofisicofactura.getId());	
					estadofisicofacturaLocal.setVersionRow(estadofisicofactura.getVersionRow());	
					estadofisicofacturaLocal.setid_pais(estadofisicofactura.getid_pais());	
					estadofisicofacturaLocal.setnombre(estadofisicofactura.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadofisicofactura.getIsDeleted()) {
				if(!existe) {
					estadofisicofacturas.add(estadofisicofactura);
				}
			} else {
				if(estadofisicofacturaEncontrado!=null && permiteQuitar)  {
					estadofisicofacturas.remove(estadofisicofacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoFisicoFactura estadofisicofactura,List<EstadoFisicoFactura> estadofisicofacturas) throws Exception {
		try	{			
			for(EstadoFisicoFactura estadofisicofacturaLocal:estadofisicofacturas) {
				if(estadofisicofacturaLocal.getId().equals(estadofisicofactura.getId())) {
					estadofisicofacturaLocal.setIsSelected(estadofisicofactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoFisicoFactura(List<EstadoFisicoFactura> estadofisicofacturasAux) throws Exception {
		//this.estadofisicofacturasAux=estadofisicofacturasAux;
		
		for(EstadoFisicoFactura estadofisicofacturaAux:estadofisicofacturasAux) {
			if(estadofisicofacturaAux.getIsChanged()) {
				estadofisicofacturaAux.setIsChanged(false);
			}		
			
			if(estadofisicofacturaAux.getIsNew()) {
				estadofisicofacturaAux.setIsNew(false);
			}	
			
			if(estadofisicofacturaAux.getIsDeleted()) {
				estadofisicofacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoFisicoFactura(EstadoFisicoFactura estadofisicofacturaAux) throws Exception {
		//this.estadofisicofacturaAux=estadofisicofacturaAux;
		
			if(estadofisicofacturaAux.getIsChanged()) {
				estadofisicofacturaAux.setIsChanged(false);
			}		
			
			if(estadofisicofacturaAux.getIsNew()) {
				estadofisicofacturaAux.setIsNew(false);
			}	
			
			if(estadofisicofacturaAux.getIsDeleted()) {
				estadofisicofacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoFisicoFactura estadofisicofacturaAsignar,EstadoFisicoFactura estadofisicofactura) throws Exception {
		estadofisicofacturaAsignar.setId(estadofisicofactura.getId());	
		estadofisicofacturaAsignar.setVersionRow(estadofisicofactura.getVersionRow());	
		estadofisicofacturaAsignar.setid_pais(estadofisicofactura.getid_pais());
		estadofisicofacturaAsignar.setpais_descripcion(estadofisicofactura.getpais_descripcion());	
		estadofisicofacturaAsignar.setnombre(estadofisicofactura.getnombre());	
	}
	
	public static void inicializarEstadoFisicoFactura(EstadoFisicoFactura estadofisicofactura) throws Exception {
		try {
				estadofisicofactura.setId(0L);	
					
				estadofisicofactura.setid_pais(-1L);	
				estadofisicofactura.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoFisicoFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoFisicoFactura(String sTipo,Row row,Workbook workbook,EstadoFisicoFactura estadofisicofactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofisicofactura.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofisicofactura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoFisicoFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoFisicoFactura() {
		return this.sFinalQueryEstadoFisicoFactura;
	}
	
	public void setsFinalQueryEstadoFisicoFactura(String sFinalQueryEstadoFisicoFactura) {
		this.sFinalQueryEstadoFisicoFactura= sFinalQueryEstadoFisicoFactura;
	}
	
	public Border resaltarSeleccionarEstadoFisicoFactura=null;
	
	public Border setResaltarSeleccionarEstadoFisicoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadofisicofacturaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoFisicoFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoFisicoFactura() {
		return this.resaltarSeleccionarEstadoFisicoFactura;
	}
	
	public void setResaltarSeleccionarEstadoFisicoFactura(Border borderResaltarSeleccionarEstadoFisicoFactura) {
		this.resaltarSeleccionarEstadoFisicoFactura= borderResaltarSeleccionarEstadoFisicoFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoFisicoFactura=null;
	public Boolean mostraridEstadoFisicoFactura=true;
	public Boolean activaridEstadoFisicoFactura=true;

	public Border resaltarid_paisEstadoFisicoFactura=null;
	public Boolean mostrarid_paisEstadoFisicoFactura=true;
	public Boolean activarid_paisEstadoFisicoFactura=true;
	public Boolean cargarid_paisEstadoFisicoFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisEstadoFisicoFactura=false;//ConEventDepend=true

	public Border resaltarnombreEstadoFisicoFactura=null;
	public Boolean mostrarnombreEstadoFisicoFactura=true;
	public Boolean activarnombreEstadoFisicoFactura=true;

	
	

	public Border setResaltaridEstadoFisicoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFactura.setBorder(borderResaltar);
		
		this.resaltaridEstadoFisicoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoFisicoFactura() {
		return this.resaltaridEstadoFisicoFactura;
	}

	public void setResaltaridEstadoFisicoFactura(Border borderResaltar) {
		this.resaltaridEstadoFisicoFactura= borderResaltar;
	}

	public Boolean getMostraridEstadoFisicoFactura() {
		return this.mostraridEstadoFisicoFactura;
	}

	public void setMostraridEstadoFisicoFactura(Boolean mostraridEstadoFisicoFactura) {
		this.mostraridEstadoFisicoFactura= mostraridEstadoFisicoFactura;
	}

	public Boolean getActivaridEstadoFisicoFactura() {
		return this.activaridEstadoFisicoFactura;
	}

	public void setActivaridEstadoFisicoFactura(Boolean activaridEstadoFisicoFactura) {
		this.activaridEstadoFisicoFactura= activaridEstadoFisicoFactura;
	}

	public Border setResaltarid_paisEstadoFisicoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFactura.setBorder(borderResaltar);
		
		this.resaltarid_paisEstadoFisicoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisEstadoFisicoFactura() {
		return this.resaltarid_paisEstadoFisicoFactura;
	}

	public void setResaltarid_paisEstadoFisicoFactura(Border borderResaltar) {
		this.resaltarid_paisEstadoFisicoFactura= borderResaltar;
	}

	public Boolean getMostrarid_paisEstadoFisicoFactura() {
		return this.mostrarid_paisEstadoFisicoFactura;
	}

	public void setMostrarid_paisEstadoFisicoFactura(Boolean mostrarid_paisEstadoFisicoFactura) {
		this.mostrarid_paisEstadoFisicoFactura= mostrarid_paisEstadoFisicoFactura;
	}

	public Boolean getActivarid_paisEstadoFisicoFactura() {
		return this.activarid_paisEstadoFisicoFactura;
	}

	public void setActivarid_paisEstadoFisicoFactura(Boolean activarid_paisEstadoFisicoFactura) {
		this.activarid_paisEstadoFisicoFactura= activarid_paisEstadoFisicoFactura;
	}

	public Boolean getCargarid_paisEstadoFisicoFactura() {
		return this.cargarid_paisEstadoFisicoFactura;
	}

	public void setCargarid_paisEstadoFisicoFactura(Boolean cargarid_paisEstadoFisicoFactura) {
		this.cargarid_paisEstadoFisicoFactura= cargarid_paisEstadoFisicoFactura;
	}

	public Border setResaltarnombreEstadoFisicoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFactura.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoFisicoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoFisicoFactura() {
		return this.resaltarnombreEstadoFisicoFactura;
	}

	public void setResaltarnombreEstadoFisicoFactura(Border borderResaltar) {
		this.resaltarnombreEstadoFisicoFactura= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoFisicoFactura() {
		return this.mostrarnombreEstadoFisicoFactura;
	}

	public void setMostrarnombreEstadoFisicoFactura(Boolean mostrarnombreEstadoFisicoFactura) {
		this.mostrarnombreEstadoFisicoFactura= mostrarnombreEstadoFisicoFactura;
	}

	public Boolean getActivarnombreEstadoFisicoFactura() {
		return this.activarnombreEstadoFisicoFactura;
	}

	public void setActivarnombreEstadoFisicoFactura(Boolean activarnombreEstadoFisicoFactura) {
		this.activarnombreEstadoFisicoFactura= activarnombreEstadoFisicoFactura;
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
		
		
		this.setMostraridEstadoFisicoFactura(esInicial);
		this.setMostrarid_paisEstadoFisicoFactura(esInicial);
		this.setMostrarnombreEstadoFisicoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.ID)) {
				this.setMostraridEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoFisicoFactura(esAsigna);
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
		
		
		this.setActivaridEstadoFisicoFactura(esInicial);
		this.setActivarid_paisEstadoFisicoFactura(esInicial);
		this.setActivarnombreEstadoFisicoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.ID)) {
				this.setActivaridEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoFisicoFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoFisicoFactura(esInicial);
		this.setResaltarid_paisEstadoFisicoFactura(esInicial);
		this.setResaltarnombreEstadoFisicoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.ID)) {
				this.setResaltaridEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisEstadoFisicoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoFisicoFactura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisEstadoFisicoFactura=true;

	public Boolean getMostrarFK_IdPaisEstadoFisicoFactura() {
		return this.mostrarFK_IdPaisEstadoFisicoFactura;
	}

	public void setMostrarFK_IdPaisEstadoFisicoFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisEstadoFisicoFactura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisEstadoFisicoFactura=true;

	public Boolean getActivarFK_IdPaisEstadoFisicoFactura() {
		return this.activarFK_IdPaisEstadoFisicoFactura;
	}

	public void setActivarFK_IdPaisEstadoFisicoFactura(Boolean habilitarResaltar) {
		this.activarFK_IdPaisEstadoFisicoFactura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisEstadoFisicoFactura=null;

	public Border getResaltarFK_IdPaisEstadoFisicoFactura() {
		return this.resaltarFK_IdPaisEstadoFisicoFactura;
	}

	public void setResaltarFK_IdPaisEstadoFisicoFactura(Border borderResaltar) {
		this.resaltarFK_IdPaisEstadoFisicoFactura= borderResaltar;
	}

	public void setResaltarFK_IdPaisEstadoFisicoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaBeanSwingJInternalFrame estadofisicofacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisEstadoFisicoFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
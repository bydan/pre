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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoVentaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoVentaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



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
final public class TipoVentaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoVenta";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoVenta"+TipoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoVentaConstantesFunciones.SCHEMA+"_"+TipoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoVentaConstantesFunciones.SCHEMA+"_"+TipoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoVentaConstantesFunciones.SCHEMA+"_"+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoVentaConstantesFunciones.SCHEMA+"_"+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Venta";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoVenta";
	public static final String OBJECTNAME="tipoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoventa from "+TipoVentaConstantesFunciones.SPERSISTENCENAME+" tipoventa";
	public static String QUERYSELECTNATIVE="select "+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME+".id,"+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME+".version_row,"+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME+".id_empresa,"+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME+".codigo,"+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME+".nombre from "+TipoVentaConstantesFunciones.SCHEMA+"."+TipoVentaConstantesFunciones.TABLENAME;//+" as "+TipoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoVentaConstantesFunciones.CODIGO)) {sLabelColumna=TipoVentaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoVentaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoVentaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoVentaDescripcion(TipoVenta tipoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoventa !=null/* && tipoventa.getId()!=0*/) {
			sDescripcion=tipoventa.getcodigo();//tipoventatipoventa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoVentaDescripcionDetallado(TipoVenta tipoventa) {
		String sDescripcion="";
			
		sDescripcion+=TipoVentaConstantesFunciones.ID+"=";
		sDescripcion+=tipoventa.getId().toString()+",";
		sDescripcion+=TipoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoventa.getVersionRow().toString()+",";
		sDescripcion+=TipoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoventa.getid_empresa().toString()+",";
		sDescripcion+=TipoVentaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoventa.getcodigo()+",";
		sDescripcion+=TipoVentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoventa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoVentaDescripcion(TipoVenta tipoventa,String sValor) throws Exception {			
		if(tipoventa !=null) {
			tipoventa.setcodigo(sValor);;//tipoventatipoventa.getcodigo().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoVenta(TipoVenta tipoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoventa.setcodigo(tipoventa.getcodigo().trim());
		tipoventa.setnombre(tipoventa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoVentas(List<TipoVenta> tipoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoVenta tipoventa: tipoventas) {
			tipoventa.setcodigo(tipoventa.getcodigo().trim());
			tipoventa.setnombre(tipoventa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVenta(TipoVenta tipoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoventa.getConCambioAuxiliar()) {
			tipoventa.setIsDeleted(tipoventa.getIsDeletedAuxiliar());	
			tipoventa.setIsNew(tipoventa.getIsNewAuxiliar());	
			tipoventa.setIsChanged(tipoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoventa.setIsDeletedAuxiliar(false);	
			tipoventa.setIsNewAuxiliar(false);	
			tipoventa.setIsChangedAuxiliar(false);
			
			tipoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVentas(List<TipoVenta> tipoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoVenta tipoventa : tipoventas) {
			if(conAsignarBase && tipoventa.getConCambioAuxiliar()) {
				tipoventa.setIsDeleted(tipoventa.getIsDeletedAuxiliar());	
				tipoventa.setIsNew(tipoventa.getIsNewAuxiliar());	
				tipoventa.setIsChanged(tipoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoventa.setIsDeletedAuxiliar(false);	
				tipoventa.setIsNewAuxiliar(false);	
				tipoventa.setIsChangedAuxiliar(false);
				
				tipoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoVenta(TipoVenta tipoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoVentas(List<TipoVenta> tipoventas,Boolean conEnteros) throws Exception  {
		
		for(TipoVenta tipoventa: tipoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoVenta(List<TipoVenta> tipoventas,TipoVenta tipoventaAux) throws Exception  {
		TipoVentaConstantesFunciones.InicializarValoresTipoVenta(tipoventaAux,true);
		
		for(TipoVenta tipoventa: tipoventas) {
			if(tipoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoVentaConstantesFunciones.getArrayColumnasGlobalesTipoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoVentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoVenta> tipoventas,TipoVenta tipoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoVenta tipoventaAux: tipoventas) {
			if(tipoventaAux!=null && tipoventa!=null) {
				if((tipoventaAux.getId()==null && tipoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoventaAux.getId()!=null && tipoventa.getId()!=null){
					if(tipoventaAux.getId().equals(tipoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoVenta(List<TipoVenta> tipoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoVenta tipoventa: tipoventas) {			
			if(tipoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoVentaConstantesFunciones.LABEL_ID, TipoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVentaConstantesFunciones.LABEL_VERSIONROW, TipoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVentaConstantesFunciones.LABEL_IDEMPRESA, TipoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVentaConstantesFunciones.LABEL_CODIGO, TipoVentaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVentaConstantesFunciones.LABEL_NOMBRE, TipoVentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVentaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVenta() throws Exception  {
		return TipoVentaConstantesFunciones.getTiposSeleccionarTipoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVenta(Boolean conFk) throws Exception  {
		return TipoVentaConstantesFunciones.getTiposSeleccionarTipoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVentaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoVentaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoVentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVenta(TipoVenta tipoventaAux) throws Exception {
		
			tipoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoventaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVenta(List<TipoVenta> tipoventasTemp) throws Exception {
		for(TipoVenta tipoventaAux:tipoventasTemp) {
			
			tipoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoventaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVentaConstantesFunciones.getClassesRelationshipsOfTipoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoVenta tipoventa,List<TipoVenta> tipoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoVenta tipoventaEncontrado=null;
			
			for(TipoVenta tipoventaLocal:tipoventas) {
				if(tipoventaLocal.getId().equals(tipoventa.getId())) {
					tipoventaEncontrado=tipoventaLocal;
					
					tipoventaLocal.setIsChanged(tipoventa.getIsChanged());
					tipoventaLocal.setIsNew(tipoventa.getIsNew());
					tipoventaLocal.setIsDeleted(tipoventa.getIsDeleted());
					
					tipoventaLocal.setGeneralEntityOriginal(tipoventa.getGeneralEntityOriginal());
					
					tipoventaLocal.setId(tipoventa.getId());	
					tipoventaLocal.setVersionRow(tipoventa.getVersionRow());	
					tipoventaLocal.setid_empresa(tipoventa.getid_empresa());	
					tipoventaLocal.setcodigo(tipoventa.getcodigo());	
					tipoventaLocal.setnombre(tipoventa.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoventa.getIsDeleted()) {
				if(!existe) {
					tipoventas.add(tipoventa);
				}
			} else {
				if(tipoventaEncontrado!=null && permiteQuitar)  {
					tipoventas.remove(tipoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoVenta tipoventa,List<TipoVenta> tipoventas) throws Exception {
		try	{			
			for(TipoVenta tipoventaLocal:tipoventas) {
				if(tipoventaLocal.getId().equals(tipoventa.getId())) {
					tipoventaLocal.setIsSelected(tipoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoVenta(List<TipoVenta> tipoventasAux) throws Exception {
		//this.tipoventasAux=tipoventasAux;
		
		for(TipoVenta tipoventaAux:tipoventasAux) {
			if(tipoventaAux.getIsChanged()) {
				tipoventaAux.setIsChanged(false);
			}		
			
			if(tipoventaAux.getIsNew()) {
				tipoventaAux.setIsNew(false);
			}	
			
			if(tipoventaAux.getIsDeleted()) {
				tipoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoVenta(TipoVenta tipoventaAux) throws Exception {
		//this.tipoventaAux=tipoventaAux;
		
			if(tipoventaAux.getIsChanged()) {
				tipoventaAux.setIsChanged(false);
			}		
			
			if(tipoventaAux.getIsNew()) {
				tipoventaAux.setIsNew(false);
			}	
			
			if(tipoventaAux.getIsDeleted()) {
				tipoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoVenta tipoventaAsignar,TipoVenta tipoventa) throws Exception {
		tipoventaAsignar.setId(tipoventa.getId());	
		tipoventaAsignar.setVersionRow(tipoventa.getVersionRow());	
		tipoventaAsignar.setid_empresa(tipoventa.getid_empresa());
		tipoventaAsignar.setempresa_descripcion(tipoventa.getempresa_descripcion());	
		tipoventaAsignar.setcodigo(tipoventa.getcodigo());	
		tipoventaAsignar.setnombre(tipoventa.getnombre());	
	}
	
	public static void inicializarTipoVenta(TipoVenta tipoventa) throws Exception {
		try {
				tipoventa.setId(0L);	
					
				tipoventa.setid_empresa(-1L);	
				tipoventa.setcodigo("");	
				tipoventa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVentaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoVenta(String sTipo,Row row,Workbook workbook,TipoVenta tipoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoventa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoventa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoVenta() {
		return this.sFinalQueryTipoVenta;
	}
	
	public void setsFinalQueryTipoVenta(String sFinalQueryTipoVenta) {
		this.sFinalQueryTipoVenta= sFinalQueryTipoVenta;
	}
	
	public Border resaltarSeleccionarTipoVenta=null;
	
	public Border setResaltarSeleccionarTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoventaBeanSwingJInternalFrame.jTtoolBarTipoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoVenta() {
		return this.resaltarSeleccionarTipoVenta;
	}
	
	public void setResaltarSeleccionarTipoVenta(Border borderResaltarSeleccionarTipoVenta) {
		this.resaltarSeleccionarTipoVenta= borderResaltarSeleccionarTipoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoVenta=null;
	public Boolean mostraridTipoVenta=true;
	public Boolean activaridTipoVenta=true;

	public Border resaltarid_empresaTipoVenta=null;
	public Boolean mostrarid_empresaTipoVenta=true;
	public Boolean activarid_empresaTipoVenta=true;
	public Boolean cargarid_empresaTipoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoVenta=false;//ConEventDepend=true

	public Border resaltarcodigoTipoVenta=null;
	public Boolean mostrarcodigoTipoVenta=true;
	public Boolean activarcodigoTipoVenta=true;

	public Border resaltarnombreTipoVenta=null;
	public Boolean mostrarnombreTipoVenta=true;
	public Boolean activarnombreTipoVenta=true;

	
	

	public Border setResaltaridTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoventaBeanSwingJInternalFrame.jTtoolBarTipoVenta.setBorder(borderResaltar);
		
		this.resaltaridTipoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoVenta() {
		return this.resaltaridTipoVenta;
	}

	public void setResaltaridTipoVenta(Border borderResaltar) {
		this.resaltaridTipoVenta= borderResaltar;
	}

	public Boolean getMostraridTipoVenta() {
		return this.mostraridTipoVenta;
	}

	public void setMostraridTipoVenta(Boolean mostraridTipoVenta) {
		this.mostraridTipoVenta= mostraridTipoVenta;
	}

	public Boolean getActivaridTipoVenta() {
		return this.activaridTipoVenta;
	}

	public void setActivaridTipoVenta(Boolean activaridTipoVenta) {
		this.activaridTipoVenta= activaridTipoVenta;
	}

	public Border setResaltarid_empresaTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoventaBeanSwingJInternalFrame.jTtoolBarTipoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoVenta() {
		return this.resaltarid_empresaTipoVenta;
	}

	public void setResaltarid_empresaTipoVenta(Border borderResaltar) {
		this.resaltarid_empresaTipoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoVenta() {
		return this.mostrarid_empresaTipoVenta;
	}

	public void setMostrarid_empresaTipoVenta(Boolean mostrarid_empresaTipoVenta) {
		this.mostrarid_empresaTipoVenta= mostrarid_empresaTipoVenta;
	}

	public Boolean getActivarid_empresaTipoVenta() {
		return this.activarid_empresaTipoVenta;
	}

	public void setActivarid_empresaTipoVenta(Boolean activarid_empresaTipoVenta) {
		this.activarid_empresaTipoVenta= activarid_empresaTipoVenta;
	}

	public Boolean getCargarid_empresaTipoVenta() {
		return this.cargarid_empresaTipoVenta;
	}

	public void setCargarid_empresaTipoVenta(Boolean cargarid_empresaTipoVenta) {
		this.cargarid_empresaTipoVenta= cargarid_empresaTipoVenta;
	}

	public Border setResaltarcodigoTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoventaBeanSwingJInternalFrame.jTtoolBarTipoVenta.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoVenta() {
		return this.resaltarcodigoTipoVenta;
	}

	public void setResaltarcodigoTipoVenta(Border borderResaltar) {
		this.resaltarcodigoTipoVenta= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoVenta() {
		return this.mostrarcodigoTipoVenta;
	}

	public void setMostrarcodigoTipoVenta(Boolean mostrarcodigoTipoVenta) {
		this.mostrarcodigoTipoVenta= mostrarcodigoTipoVenta;
	}

	public Boolean getActivarcodigoTipoVenta() {
		return this.activarcodigoTipoVenta;
	}

	public void setActivarcodigoTipoVenta(Boolean activarcodigoTipoVenta) {
		this.activarcodigoTipoVenta= activarcodigoTipoVenta;
	}

	public Border setResaltarnombreTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoventaBeanSwingJInternalFrame.jTtoolBarTipoVenta.setBorder(borderResaltar);
		
		this.resaltarnombreTipoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoVenta() {
		return this.resaltarnombreTipoVenta;
	}

	public void setResaltarnombreTipoVenta(Border borderResaltar) {
		this.resaltarnombreTipoVenta= borderResaltar;
	}

	public Boolean getMostrarnombreTipoVenta() {
		return this.mostrarnombreTipoVenta;
	}

	public void setMostrarnombreTipoVenta(Boolean mostrarnombreTipoVenta) {
		this.mostrarnombreTipoVenta= mostrarnombreTipoVenta;
	}

	public Boolean getActivarnombreTipoVenta() {
		return this.activarnombreTipoVenta;
	}

	public void setActivarnombreTipoVenta(Boolean activarnombreTipoVenta) {
		this.activarnombreTipoVenta= activarnombreTipoVenta;
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
		
		
		this.setMostraridTipoVenta(esInicial);
		this.setMostrarid_empresaTipoVenta(esInicial);
		this.setMostrarcodigoTipoVenta(esInicial);
		this.setMostrarnombreTipoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVentaConstantesFunciones.ID)) {
				this.setMostraridTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoVenta(esAsigna);
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
		
		
		this.setActivaridTipoVenta(esInicial);
		this.setActivarid_empresaTipoVenta(esInicial);
		this.setActivarcodigoTipoVenta(esInicial);
		this.setActivarnombreTipoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVentaConstantesFunciones.ID)) {
				this.setActivaridTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoVenta(esInicial);
		this.setResaltarid_empresaTipoVenta(esInicial);
		this.setResaltarcodigoTipoVenta(esInicial);
		this.setResaltarnombreTipoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVentaConstantesFunciones.ID)) {
				this.setResaltaridTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoVenta=true;

	public Boolean getMostrarFK_IdEmpresaTipoVenta() {
		return this.mostrarFK_IdEmpresaTipoVenta;
	}

	public void setMostrarFK_IdEmpresaTipoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoVenta=true;

	public Boolean getActivarFK_IdEmpresaTipoVenta() {
		return this.activarFK_IdEmpresaTipoVenta;
	}

	public void setActivarFK_IdEmpresaTipoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoVenta=null;

	public Border getResaltarFK_IdEmpresaTipoVenta() {
		return this.resaltarFK_IdEmpresaTipoVenta;
	}

	public void setResaltarFK_IdEmpresaTipoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVentaBeanSwingJInternalFrame tipoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
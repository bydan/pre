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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDetalleMovimientoInventarioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDetalleMovimientoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDetalleMovimientoInventario"+TipoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDetalleMovimientoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDetalleMovimientoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"_"+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetalleMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDetalleMovimientoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDetalleMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDetalleMovimientoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Costo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Detalle Movimiento Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDetalleMovimientoInventario";
	public static final String OBJECTNAME="tipodetallemovimientoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_detalle_movimiento_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodetallemovimientoinventario from "+TipoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" tipodetallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".nombre from "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoDetalleMovimientoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {sLabelColumna=TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoDetalleMovimientoInventarioDescripcion(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodetallemovimientoinventario !=null/* && tipodetallemovimientoinventario.getId()!=0*/) {
			sDescripcion=tipodetallemovimientoinventario.getcodigo();//tipodetallemovimientoinventariotipodetallemovimientoinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDetalleMovimientoInventarioDescripcionDetallado(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) {
		String sDescripcion="";
			
		sDescripcion+=TipoDetalleMovimientoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=tipodetallemovimientoinventario.getId().toString()+",";
		sDescripcion+=TipoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodetallemovimientoinventario.getVersionRow().toString()+",";
		sDescripcion+=TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodetallemovimientoinventario.getcodigo()+",";
		sDescripcion+=TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodetallemovimientoinventario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDetalleMovimientoInventarioDescripcion(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,String sValor) throws Exception {			
		if(tipodetallemovimientoinventario !=null) {
			tipodetallemovimientoinventario.setcodigo(sValor);;//tipodetallemovimientoinventariotipodetallemovimientoinventario.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodetallemovimientoinventario.setcodigo(tipodetallemovimientoinventario.getcodigo().trim());
		tipodetallemovimientoinventario.setnombre(tipodetallemovimientoinventario.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDetalleMovimientoInventarios(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario: tipodetallemovimientoinventarios) {
			tipodetallemovimientoinventario.setcodigo(tipodetallemovimientoinventario.getcodigo().trim());
			tipodetallemovimientoinventario.setnombre(tipodetallemovimientoinventario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodetallemovimientoinventario.getConCambioAuxiliar()) {
			tipodetallemovimientoinventario.setIsDeleted(tipodetallemovimientoinventario.getIsDeletedAuxiliar());	
			tipodetallemovimientoinventario.setIsNew(tipodetallemovimientoinventario.getIsNewAuxiliar());	
			tipodetallemovimientoinventario.setIsChanged(tipodetallemovimientoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodetallemovimientoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodetallemovimientoinventario.setIsDeletedAuxiliar(false);	
			tipodetallemovimientoinventario.setIsNewAuxiliar(false);	
			tipodetallemovimientoinventario.setIsChangedAuxiliar(false);
			
			tipodetallemovimientoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetalleMovimientoInventarios(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario : tipodetallemovimientoinventarios) {
			if(conAsignarBase && tipodetallemovimientoinventario.getConCambioAuxiliar()) {
				tipodetallemovimientoinventario.setIsDeleted(tipodetallemovimientoinventario.getIsDeletedAuxiliar());	
				tipodetallemovimientoinventario.setIsNew(tipodetallemovimientoinventario.getIsNewAuxiliar());	
				tipodetallemovimientoinventario.setIsChanged(tipodetallemovimientoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodetallemovimientoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodetallemovimientoinventario.setIsDeletedAuxiliar(false);	
				tipodetallemovimientoinventario.setIsNewAuxiliar(false);	
				tipodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
				tipodetallemovimientoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDetalleMovimientoInventarios(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,Boolean conEnteros) throws Exception  {
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario: tipodetallemovimientoinventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux) throws Exception  {
		TipoDetalleMovimientoInventarioConstantesFunciones.InicializarValoresTipoDetalleMovimientoInventario(tipodetallemovimientoinventarioAux,true);
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario: tipodetallemovimientoinventarios) {
			if(tipodetallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDetalleMovimientoInventarioConstantesFunciones.getArrayColumnasGlobalesTipoDetalleMovimientoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventario tipodetallemovimientoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux: tipodetallemovimientoinventarios) {
			if(tipodetallemovimientoinventarioAux!=null && tipodetallemovimientoinventario!=null) {
				if((tipodetallemovimientoinventarioAux.getId()==null && tipodetallemovimientoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodetallemovimientoinventarioAux.getId()!=null && tipodetallemovimientoinventario.getId()!=null){
					if(tipodetallemovimientoinventarioAux.getId().equals(tipodetallemovimientoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario: tipodetallemovimientoinventarios) {			
			if(tipodetallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDetalleMovimientoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_ID, TipoDetalleMovimientoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_VERSIONROW, TipoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO, TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE, TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDetalleMovimientoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleMovimientoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleMovimientoInventario() throws Exception  {
		return TipoDetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarTipoDetalleMovimientoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleMovimientoInventario(Boolean conFk) throws Exception  {
		return TipoDetalleMovimientoInventarioConstantesFunciones.getTiposSeleccionarTipoDetalleMovimientoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleMovimientoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDetalleMovimientoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosTemp) throws Exception {
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux:tipodetallemovimientoinventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfTipoDetalleMovimientoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleMovimientoInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDetalleMovimientoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetalleMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
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
	public static void actualizarLista(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDetalleMovimientoInventario tipodetallemovimientoinventarioEncontrado=null;
			
			for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal:tipodetallemovimientoinventarios) {
				if(tipodetallemovimientoinventarioLocal.getId().equals(tipodetallemovimientoinventario.getId())) {
					tipodetallemovimientoinventarioEncontrado=tipodetallemovimientoinventarioLocal;
					
					tipodetallemovimientoinventarioLocal.setIsChanged(tipodetallemovimientoinventario.getIsChanged());
					tipodetallemovimientoinventarioLocal.setIsNew(tipodetallemovimientoinventario.getIsNew());
					tipodetallemovimientoinventarioLocal.setIsDeleted(tipodetallemovimientoinventario.getIsDeleted());
					
					tipodetallemovimientoinventarioLocal.setGeneralEntityOriginal(tipodetallemovimientoinventario.getGeneralEntityOriginal());
					
					tipodetallemovimientoinventarioLocal.setId(tipodetallemovimientoinventario.getId());	
					tipodetallemovimientoinventarioLocal.setVersionRow(tipodetallemovimientoinventario.getVersionRow());	
					tipodetallemovimientoinventarioLocal.setcodigo(tipodetallemovimientoinventario.getcodigo());	
					tipodetallemovimientoinventarioLocal.setnombre(tipodetallemovimientoinventario.getnombre());	
					
					
					tipodetallemovimientoinventarioLocal.setDetalleMovimientoInventarios(tipodetallemovimientoinventario.getDetalleMovimientoInventarios());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodetallemovimientoinventario.getIsDeleted()) {
				if(!existe) {
					tipodetallemovimientoinventarios.add(tipodetallemovimientoinventario);
				}
			} else {
				if(tipodetallemovimientoinventarioEncontrado!=null && permiteQuitar)  {
					tipodetallemovimientoinventarios.remove(tipodetallemovimientoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios) throws Exception {
		try	{			
			for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal:tipodetallemovimientoinventarios) {
				if(tipodetallemovimientoinventarioLocal.getId().equals(tipodetallemovimientoinventario.getId())) {
					tipodetallemovimientoinventarioLocal.setIsSelected(tipodetallemovimientoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosAux) throws Exception {
		//this.tipodetallemovimientoinventariosAux=tipodetallemovimientoinventariosAux;
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux:tipodetallemovimientoinventariosAux) {
			if(tipodetallemovimientoinventarioAux.getIsChanged()) {
				tipodetallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(tipodetallemovimientoinventarioAux.getIsNew()) {
				tipodetallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(tipodetallemovimientoinventarioAux.getIsDeleted()) {
				tipodetallemovimientoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux) throws Exception {
		//this.tipodetallemovimientoinventarioAux=tipodetallemovimientoinventarioAux;
		
			if(tipodetallemovimientoinventarioAux.getIsChanged()) {
				tipodetallemovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(tipodetallemovimientoinventarioAux.getIsNew()) {
				tipodetallemovimientoinventarioAux.setIsNew(false);
			}	
			
			if(tipodetallemovimientoinventarioAux.getIsDeleted()) {
				tipodetallemovimientoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAsignar,TipoDetalleMovimientoInventario tipodetallemovimientoinventario) throws Exception {
		tipodetallemovimientoinventarioAsignar.setId(tipodetallemovimientoinventario.getId());	
		tipodetallemovimientoinventarioAsignar.setVersionRow(tipodetallemovimientoinventario.getVersionRow());	
		tipodetallemovimientoinventarioAsignar.setcodigo(tipodetallemovimientoinventario.getcodigo());	
		tipodetallemovimientoinventarioAsignar.setnombre(tipodetallemovimientoinventario.getnombre());	
	}
	
	public static void inicializarTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) throws Exception {
		try {
				tipodetallemovimientoinventario.setId(0L);	
					
				tipodetallemovimientoinventario.setcodigo("");	
				tipodetallemovimientoinventario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetalleMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDetalleMovimientoInventario(String sTipo,Row row,Workbook workbook,TipoDetalleMovimientoInventario tipodetallemovimientoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetallemovimientoinventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetallemovimientoinventario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDetalleMovimientoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDetalleMovimientoInventario() {
		return this.sFinalQueryTipoDetalleMovimientoInventario;
	}
	
	public void setsFinalQueryTipoDetalleMovimientoInventario(String sFinalQueryTipoDetalleMovimientoInventario) {
		this.sFinalQueryTipoDetalleMovimientoInventario= sFinalQueryTipoDetalleMovimientoInventario;
	}
	
	public Border resaltarSeleccionarTipoDetalleMovimientoInventario=null;
	
	public Border setResaltarSeleccionarTipoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarTipoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDetalleMovimientoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDetalleMovimientoInventario() {
		return this.resaltarSeleccionarTipoDetalleMovimientoInventario;
	}
	
	public void setResaltarSeleccionarTipoDetalleMovimientoInventario(Border borderResaltarSeleccionarTipoDetalleMovimientoInventario) {
		this.resaltarSeleccionarTipoDetalleMovimientoInventario= borderResaltarSeleccionarTipoDetalleMovimientoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDetalleMovimientoInventario=null;
	public Boolean mostraridTipoDetalleMovimientoInventario=true;
	public Boolean activaridTipoDetalleMovimientoInventario=true;

	public Border resaltarcodigoTipoDetalleMovimientoInventario=null;
	public Boolean mostrarcodigoTipoDetalleMovimientoInventario=true;
	public Boolean activarcodigoTipoDetalleMovimientoInventario=true;

	public Border resaltarnombreTipoDetalleMovimientoInventario=null;
	public Boolean mostrarnombreTipoDetalleMovimientoInventario=true;
	public Boolean activarnombreTipoDetalleMovimientoInventario=true;

	
	

	public Border setResaltaridTipoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarTipoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltaridTipoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDetalleMovimientoInventario() {
		return this.resaltaridTipoDetalleMovimientoInventario;
	}

	public void setResaltaridTipoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltaridTipoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostraridTipoDetalleMovimientoInventario() {
		return this.mostraridTipoDetalleMovimientoInventario;
	}

	public void setMostraridTipoDetalleMovimientoInventario(Boolean mostraridTipoDetalleMovimientoInventario) {
		this.mostraridTipoDetalleMovimientoInventario= mostraridTipoDetalleMovimientoInventario;
	}

	public Boolean getActivaridTipoDetalleMovimientoInventario() {
		return this.activaridTipoDetalleMovimientoInventario;
	}

	public void setActivaridTipoDetalleMovimientoInventario(Boolean activaridTipoDetalleMovimientoInventario) {
		this.activaridTipoDetalleMovimientoInventario= activaridTipoDetalleMovimientoInventario;
	}

	public Border setResaltarcodigoTipoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarTipoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDetalleMovimientoInventario() {
		return this.resaltarcodigoTipoDetalleMovimientoInventario;
	}

	public void setResaltarcodigoTipoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarcodigoTipoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDetalleMovimientoInventario() {
		return this.mostrarcodigoTipoDetalleMovimientoInventario;
	}

	public void setMostrarcodigoTipoDetalleMovimientoInventario(Boolean mostrarcodigoTipoDetalleMovimientoInventario) {
		this.mostrarcodigoTipoDetalleMovimientoInventario= mostrarcodigoTipoDetalleMovimientoInventario;
	}

	public Boolean getActivarcodigoTipoDetalleMovimientoInventario() {
		return this.activarcodigoTipoDetalleMovimientoInventario;
	}

	public void setActivarcodigoTipoDetalleMovimientoInventario(Boolean activarcodigoTipoDetalleMovimientoInventario) {
		this.activarcodigoTipoDetalleMovimientoInventario= activarcodigoTipoDetalleMovimientoInventario;
	}

	public Border setResaltarnombreTipoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarTipoDetalleMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDetalleMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDetalleMovimientoInventario() {
		return this.resaltarnombreTipoDetalleMovimientoInventario;
	}

	public void setResaltarnombreTipoDetalleMovimientoInventario(Border borderResaltar) {
		this.resaltarnombreTipoDetalleMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDetalleMovimientoInventario() {
		return this.mostrarnombreTipoDetalleMovimientoInventario;
	}

	public void setMostrarnombreTipoDetalleMovimientoInventario(Boolean mostrarnombreTipoDetalleMovimientoInventario) {
		this.mostrarnombreTipoDetalleMovimientoInventario= mostrarnombreTipoDetalleMovimientoInventario;
	}

	public Boolean getActivarnombreTipoDetalleMovimientoInventario() {
		return this.activarnombreTipoDetalleMovimientoInventario;
	}

	public void setActivarnombreTipoDetalleMovimientoInventario(Boolean activarnombreTipoDetalleMovimientoInventario) {
		this.activarnombreTipoDetalleMovimientoInventario= activarnombreTipoDetalleMovimientoInventario;
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
		
		
		this.setMostraridTipoDetalleMovimientoInventario(esInicial);
		this.setMostrarcodigoTipoDetalleMovimientoInventario(esInicial);
		this.setMostrarnombreTipoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setMostraridTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDetalleMovimientoInventario(esAsigna);
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
		
		
		this.setActivaridTipoDetalleMovimientoInventario(esInicial);
		this.setActivarcodigoTipoDetalleMovimientoInventario(esInicial);
		this.setActivarnombreTipoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setActivaridTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDetalleMovimientoInventario(esInicial);
		this.setResaltarcodigoTipoDetalleMovimientoInventario(esInicial);
		this.setResaltarnombreTipoDetalleMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.ID)) {
				this.setResaltaridTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario=null;

	public Border getResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario() {
		return this.resaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario;
	}

	public void setResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(Border borderResaltarDetalleMovimientoInventario) {
		if(borderResaltarDetalleMovimientoInventario!=null) {
			this.resaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario= borderResaltarDetalleMovimientoInventario;
		}
	}

	public Border setResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMovimientoInventario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodetallemovimientoinventarioBeanSwingJInternalFrame.jTtoolBarTipoDetalleMovimientoInventario.setBorder(borderResaltarDetalleMovimientoInventario);
			
		this.resaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario= borderResaltarDetalleMovimientoInventario;

		 return borderResaltarDetalleMovimientoInventario;
	}



	public Boolean mostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario=true;

	public Boolean getMostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario() {
		return this.mostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario;
	}

	public void setMostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(Boolean visibilidadResaltarDetalleMovimientoInventario) {
		this.mostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario= visibilidadResaltarDetalleMovimientoInventario;
	}



	public Boolean activarDetalleMovimientoInventarioTipoDetalleMovimientoInventario=true;

	public Boolean gethabilitarResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario() {
		return this.activarDetalleMovimientoInventarioTipoDetalleMovimientoInventario;
	}

	public void setActivarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(Boolean habilitarResaltarDetalleMovimientoInventario) {
		this.activarDetalleMovimientoInventarioTipoDetalleMovimientoInventario= habilitarResaltarDetalleMovimientoInventario;
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

		this.setMostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setMostrarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esAsigna);
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

		this.setActivarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setActivarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetalleMovimientoInventarioBeanSwingJInternalFrame tipodetallemovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setResaltarDetalleMovimientoInventarioTipoDetalleMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}
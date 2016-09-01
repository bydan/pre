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


import com.bydan.erp.facturacion.util.TipoEstadoPedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoEstadoPedidoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoEstadoPedidoParameterGeneral;

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
final public class TipoEstadoPedidoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEstadoPedido";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEstadoPedido"+TipoEstadoPedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEstadoPedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEstadoPedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEstadoPedidoConstantesFunciones.SCHEMA+"_"+TipoEstadoPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEstadoPedidoConstantesFunciones.SCHEMA+"_"+TipoEstadoPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEstadoPedidoConstantesFunciones.SCHEMA+"_"+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEstadoPedidoConstantesFunciones.SCHEMA+"_"+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstadoPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEstadoPedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEstadoPedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEstadoPedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEstadoPedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Estado Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Estado Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Estado Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEstadoPedido";
	public static final String OBJECTNAME="tipoestadopedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_estado_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoestadopedido from "+TipoEstadoPedidoConstantesFunciones.SPERSISTENCENAME+" tipoestadopedido";
	public static String QUERYSELECTNATIVE="select "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".id,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".id_pais,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoPedidoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoEstadoPedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEstadoPedidoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoEstadoPedidoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoEstadoPedidoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEstadoPedidoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoEstadoPedidoDescripcion(TipoEstadoPedido tipoestadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoestadopedido !=null/* && tipoestadopedido.getId()!=0*/) {
			sDescripcion=tipoestadopedido.getnombre();//tipoestadopedidotipoestadopedido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEstadoPedidoDescripcionDetallado(TipoEstadoPedido tipoestadopedido) {
		String sDescripcion="";
			
		sDescripcion+=TipoEstadoPedidoConstantesFunciones.ID+"=";
		sDescripcion+=tipoestadopedido.getId().toString()+",";
		sDescripcion+=TipoEstadoPedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoestadopedido.getVersionRow().toString()+",";
		sDescripcion+=TipoEstadoPedidoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipoestadopedido.getid_pais().toString()+",";
		sDescripcion+=TipoEstadoPedidoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoestadopedido.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEstadoPedidoDescripcion(TipoEstadoPedido tipoestadopedido,String sValor) throws Exception {			
		if(tipoestadopedido !=null) {
			tipoestadopedido.setnombre(sValor);//tipoestadopedidotipoestadopedido.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoEstadoPedido(TipoEstadoPedido tipoestadopedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoestadopedido.setnombre(tipoestadopedido.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEstadoPedidos(List<TipoEstadoPedido> tipoestadopedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEstadoPedido tipoestadopedido: tipoestadopedidos) {
			tipoestadopedido.setnombre(tipoestadopedido.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstadoPedido(TipoEstadoPedido tipoestadopedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoestadopedido.getConCambioAuxiliar()) {
			tipoestadopedido.setIsDeleted(tipoestadopedido.getIsDeletedAuxiliar());	
			tipoestadopedido.setIsNew(tipoestadopedido.getIsNewAuxiliar());	
			tipoestadopedido.setIsChanged(tipoestadopedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoestadopedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoestadopedido.setIsDeletedAuxiliar(false);	
			tipoestadopedido.setIsNewAuxiliar(false);	
			tipoestadopedido.setIsChangedAuxiliar(false);
			
			tipoestadopedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstadoPedidos(List<TipoEstadoPedido> tipoestadopedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEstadoPedido tipoestadopedido : tipoestadopedidos) {
			if(conAsignarBase && tipoestadopedido.getConCambioAuxiliar()) {
				tipoestadopedido.setIsDeleted(tipoestadopedido.getIsDeletedAuxiliar());	
				tipoestadopedido.setIsNew(tipoestadopedido.getIsNewAuxiliar());	
				tipoestadopedido.setIsChanged(tipoestadopedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoestadopedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoestadopedido.setIsDeletedAuxiliar(false);	
				tipoestadopedido.setIsNewAuxiliar(false);	
				tipoestadopedido.setIsChangedAuxiliar(false);
				
				tipoestadopedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEstadoPedido(TipoEstadoPedido tipoestadopedido,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEstadoPedidos(List<TipoEstadoPedido> tipoestadopedidos,Boolean conEnteros) throws Exception  {
		
		for(TipoEstadoPedido tipoestadopedido: tipoestadopedidos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEstadoPedido(List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedido tipoestadopedidoAux) throws Exception  {
		TipoEstadoPedidoConstantesFunciones.InicializarValoresTipoEstadoPedido(tipoestadopedidoAux,true);
		
		for(TipoEstadoPedido tipoestadopedido: tipoestadopedidos) {
			if(tipoestadopedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEstadoPedidoConstantesFunciones.getArrayColumnasGlobalesTipoEstadoPedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEstadoPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEstadoPedido> tipoestadopedidos,TipoEstadoPedido tipoestadopedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEstadoPedido tipoestadopedidoAux: tipoestadopedidos) {
			if(tipoestadopedidoAux!=null && tipoestadopedido!=null) {
				if((tipoestadopedidoAux.getId()==null && tipoestadopedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoestadopedidoAux.getId()!=null && tipoestadopedido.getId()!=null){
					if(tipoestadopedidoAux.getId().equals(tipoestadopedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEstadoPedido(List<TipoEstadoPedido> tipoestadopedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEstadoPedido tipoestadopedido: tipoestadopedidos) {			
			if(tipoestadopedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEstadoPedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEstadoPedidoConstantesFunciones.LABEL_ID, TipoEstadoPedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoPedidoConstantesFunciones.LABEL_VERSIONROW, TipoEstadoPedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoPedidoConstantesFunciones.LABEL_IDPAIS, TipoEstadoPedidoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoPedidoConstantesFunciones.LABEL_NOMBRE, TipoEstadoPedidoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEstadoPedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoPedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoPedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoPedidoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoPedidoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoPedido() throws Exception  {
		return TipoEstadoPedidoConstantesFunciones.getTiposSeleccionarTipoEstadoPedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoPedido(Boolean conFk) throws Exception  {
		return TipoEstadoPedidoConstantesFunciones.getTiposSeleccionarTipoEstadoPedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoPedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstadoPedidoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoEstadoPedidoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstadoPedidoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEstadoPedidoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEstadoPedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstadoPedido(TipoEstadoPedido tipoestadopedidoAux) throws Exception {
		
			tipoestadopedidoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoestadopedidoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstadoPedido(List<TipoEstadoPedido> tipoestadopedidosTemp) throws Exception {
		for(TipoEstadoPedido tipoestadopedidoAux:tipoestadopedidosTemp) {
			
			tipoestadopedidoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoestadopedidoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstadoPedidoConstantesFunciones.getClassesRelationshipsOfTipoEstadoPedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstadoPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstadoPedidoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEstadoPedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstadoPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoEstadoPedido tipoestadopedido,List<TipoEstadoPedido> tipoestadopedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEstadoPedido tipoestadopedidoEncontrado=null;
			
			for(TipoEstadoPedido tipoestadopedidoLocal:tipoestadopedidos) {
				if(tipoestadopedidoLocal.getId().equals(tipoestadopedido.getId())) {
					tipoestadopedidoEncontrado=tipoestadopedidoLocal;
					
					tipoestadopedidoLocal.setIsChanged(tipoestadopedido.getIsChanged());
					tipoestadopedidoLocal.setIsNew(tipoestadopedido.getIsNew());
					tipoestadopedidoLocal.setIsDeleted(tipoestadopedido.getIsDeleted());
					
					tipoestadopedidoLocal.setGeneralEntityOriginal(tipoestadopedido.getGeneralEntityOriginal());
					
					tipoestadopedidoLocal.setId(tipoestadopedido.getId());	
					tipoestadopedidoLocal.setVersionRow(tipoestadopedido.getVersionRow());	
					tipoestadopedidoLocal.setid_pais(tipoestadopedido.getid_pais());	
					tipoestadopedidoLocal.setnombre(tipoestadopedido.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoestadopedido.getIsDeleted()) {
				if(!existe) {
					tipoestadopedidos.add(tipoestadopedido);
				}
			} else {
				if(tipoestadopedidoEncontrado!=null && permiteQuitar)  {
					tipoestadopedidos.remove(tipoestadopedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEstadoPedido tipoestadopedido,List<TipoEstadoPedido> tipoestadopedidos) throws Exception {
		try	{			
			for(TipoEstadoPedido tipoestadopedidoLocal:tipoestadopedidos) {
				if(tipoestadopedidoLocal.getId().equals(tipoestadopedido.getId())) {
					tipoestadopedidoLocal.setIsSelected(tipoestadopedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEstadoPedido(List<TipoEstadoPedido> tipoestadopedidosAux) throws Exception {
		//this.tipoestadopedidosAux=tipoestadopedidosAux;
		
		for(TipoEstadoPedido tipoestadopedidoAux:tipoestadopedidosAux) {
			if(tipoestadopedidoAux.getIsChanged()) {
				tipoestadopedidoAux.setIsChanged(false);
			}		
			
			if(tipoestadopedidoAux.getIsNew()) {
				tipoestadopedidoAux.setIsNew(false);
			}	
			
			if(tipoestadopedidoAux.getIsDeleted()) {
				tipoestadopedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEstadoPedido(TipoEstadoPedido tipoestadopedidoAux) throws Exception {
		//this.tipoestadopedidoAux=tipoestadopedidoAux;
		
			if(tipoestadopedidoAux.getIsChanged()) {
				tipoestadopedidoAux.setIsChanged(false);
			}		
			
			if(tipoestadopedidoAux.getIsNew()) {
				tipoestadopedidoAux.setIsNew(false);
			}	
			
			if(tipoestadopedidoAux.getIsDeleted()) {
				tipoestadopedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEstadoPedido tipoestadopedidoAsignar,TipoEstadoPedido tipoestadopedido) throws Exception {
		tipoestadopedidoAsignar.setId(tipoestadopedido.getId());	
		tipoestadopedidoAsignar.setVersionRow(tipoestadopedido.getVersionRow());	
		tipoestadopedidoAsignar.setid_pais(tipoestadopedido.getid_pais());
		tipoestadopedidoAsignar.setpais_descripcion(tipoestadopedido.getpais_descripcion());	
		tipoestadopedidoAsignar.setnombre(tipoestadopedido.getnombre());	
	}
	
	public static void inicializarTipoEstadoPedido(TipoEstadoPedido tipoestadopedido) throws Exception {
		try {
				tipoestadopedido.setId(0L);	
					
				tipoestadopedido.setid_pais(-1L);	
				tipoestadopedido.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEstadoPedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstadoPedidoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstadoPedidoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEstadoPedido(String sTipo,Row row,Workbook workbook,TipoEstadoPedido tipoestadopedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestadopedido.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestadopedido.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEstadoPedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEstadoPedido() {
		return this.sFinalQueryTipoEstadoPedido;
	}
	
	public void setsFinalQueryTipoEstadoPedido(String sFinalQueryTipoEstadoPedido) {
		this.sFinalQueryTipoEstadoPedido= sFinalQueryTipoEstadoPedido;
	}
	
	public Border resaltarSeleccionarTipoEstadoPedido=null;
	
	public Border setResaltarSeleccionarTipoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoestadopedidoBeanSwingJInternalFrame.jTtoolBarTipoEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEstadoPedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEstadoPedido() {
		return this.resaltarSeleccionarTipoEstadoPedido;
	}
	
	public void setResaltarSeleccionarTipoEstadoPedido(Border borderResaltarSeleccionarTipoEstadoPedido) {
		this.resaltarSeleccionarTipoEstadoPedido= borderResaltarSeleccionarTipoEstadoPedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEstadoPedido=null;
	public Boolean mostraridTipoEstadoPedido=true;
	public Boolean activaridTipoEstadoPedido=true;

	public Border resaltarid_paisTipoEstadoPedido=null;
	public Boolean mostrarid_paisTipoEstadoPedido=true;
	public Boolean activarid_paisTipoEstadoPedido=true;
	public Boolean cargarid_paisTipoEstadoPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoEstadoPedido=false;//ConEventDepend=true

	public Border resaltarnombreTipoEstadoPedido=null;
	public Boolean mostrarnombreTipoEstadoPedido=true;
	public Boolean activarnombreTipoEstadoPedido=true;

	
	

	public Border setResaltaridTipoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadopedidoBeanSwingJInternalFrame.jTtoolBarTipoEstadoPedido.setBorder(borderResaltar);
		
		this.resaltaridTipoEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEstadoPedido() {
		return this.resaltaridTipoEstadoPedido;
	}

	public void setResaltaridTipoEstadoPedido(Border borderResaltar) {
		this.resaltaridTipoEstadoPedido= borderResaltar;
	}

	public Boolean getMostraridTipoEstadoPedido() {
		return this.mostraridTipoEstadoPedido;
	}

	public void setMostraridTipoEstadoPedido(Boolean mostraridTipoEstadoPedido) {
		this.mostraridTipoEstadoPedido= mostraridTipoEstadoPedido;
	}

	public Boolean getActivaridTipoEstadoPedido() {
		return this.activaridTipoEstadoPedido;
	}

	public void setActivaridTipoEstadoPedido(Boolean activaridTipoEstadoPedido) {
		this.activaridTipoEstadoPedido= activaridTipoEstadoPedido;
	}

	public Border setResaltarid_paisTipoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadopedidoBeanSwingJInternalFrame.jTtoolBarTipoEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoEstadoPedido() {
		return this.resaltarid_paisTipoEstadoPedido;
	}

	public void setResaltarid_paisTipoEstadoPedido(Border borderResaltar) {
		this.resaltarid_paisTipoEstadoPedido= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoEstadoPedido() {
		return this.mostrarid_paisTipoEstadoPedido;
	}

	public void setMostrarid_paisTipoEstadoPedido(Boolean mostrarid_paisTipoEstadoPedido) {
		this.mostrarid_paisTipoEstadoPedido= mostrarid_paisTipoEstadoPedido;
	}

	public Boolean getActivarid_paisTipoEstadoPedido() {
		return this.activarid_paisTipoEstadoPedido;
	}

	public void setActivarid_paisTipoEstadoPedido(Boolean activarid_paisTipoEstadoPedido) {
		this.activarid_paisTipoEstadoPedido= activarid_paisTipoEstadoPedido;
	}

	public Boolean getCargarid_paisTipoEstadoPedido() {
		return this.cargarid_paisTipoEstadoPedido;
	}

	public void setCargarid_paisTipoEstadoPedido(Boolean cargarid_paisTipoEstadoPedido) {
		this.cargarid_paisTipoEstadoPedido= cargarid_paisTipoEstadoPedido;
	}

	public Border setResaltarnombreTipoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadopedidoBeanSwingJInternalFrame.jTtoolBarTipoEstadoPedido.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEstadoPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEstadoPedido() {
		return this.resaltarnombreTipoEstadoPedido;
	}

	public void setResaltarnombreTipoEstadoPedido(Border borderResaltar) {
		this.resaltarnombreTipoEstadoPedido= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEstadoPedido() {
		return this.mostrarnombreTipoEstadoPedido;
	}

	public void setMostrarnombreTipoEstadoPedido(Boolean mostrarnombreTipoEstadoPedido) {
		this.mostrarnombreTipoEstadoPedido= mostrarnombreTipoEstadoPedido;
	}

	public Boolean getActivarnombreTipoEstadoPedido() {
		return this.activarnombreTipoEstadoPedido;
	}

	public void setActivarnombreTipoEstadoPedido(Boolean activarnombreTipoEstadoPedido) {
		this.activarnombreTipoEstadoPedido= activarnombreTipoEstadoPedido;
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
		
		
		this.setMostraridTipoEstadoPedido(esInicial);
		this.setMostrarid_paisTipoEstadoPedido(esInicial);
		this.setMostrarnombreTipoEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.ID)) {
				this.setMostraridTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEstadoPedido(esAsigna);
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
		
		
		this.setActivaridTipoEstadoPedido(esInicial);
		this.setActivarid_paisTipoEstadoPedido(esInicial);
		this.setActivarnombreTipoEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.ID)) {
				this.setActivaridTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEstadoPedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEstadoPedido(esInicial);
		this.setResaltarid_paisTipoEstadoPedido(esInicial);
		this.setResaltarnombreTipoEstadoPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.ID)) {
				this.setResaltaridTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoEstadoPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoPedidoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEstadoPedido(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoEstadoPedido=true;

	public Boolean getMostrarFK_IdPaisTipoEstadoPedido() {
		return this.mostrarFK_IdPaisTipoEstadoPedido;
	}

	public void setMostrarFK_IdPaisTipoEstadoPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoEstadoPedido= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoEstadoPedido=true;

	public Boolean getActivarFK_IdPaisTipoEstadoPedido() {
		return this.activarFK_IdPaisTipoEstadoPedido;
	}

	public void setActivarFK_IdPaisTipoEstadoPedido(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoEstadoPedido= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoEstadoPedido=null;

	public Border getResaltarFK_IdPaisTipoEstadoPedido() {
		return this.resaltarFK_IdPaisTipoEstadoPedido;
	}

	public void setResaltarFK_IdPaisTipoEstadoPedido(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoEstadoPedido= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoEstadoPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoPedidoBeanSwingJInternalFrame tipoestadopedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoEstadoPedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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


import com.bydan.erp.inventario.util.TipoPrioridadPedidoConstantesFunciones;
import com.bydan.erp.inventario.util.TipoPrioridadPedidoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoPrioridadPedidoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPrioridadPedidoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPrioridadPedido";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPrioridadPedido"+TipoPrioridadPedidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPrioridadPedidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPrioridadPedidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPrioridadPedidoConstantesFunciones.SCHEMA+"_"+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPrioridadPedidoConstantesFunciones.SCHEMA+"_"+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPrioridadPedidoConstantesFunciones.SCHEMA+"_"+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPrioridadPedidoConstantesFunciones.SCHEMA+"_"+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrioridadPedidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrioridadPedidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPrioridadPedidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPrioridadPedidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPrioridadPedidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPrioridadPedidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Prioridad Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Prioridad Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Prioridad Pedido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPrioridadPedido";
	public static final String OBJECTNAME="tipoprioridadpedido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_prioridad_pedido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprioridadpedido from "+TipoPrioridadPedidoConstantesFunciones.SPERSISTENCENAME+" tipoprioridadpedido";
	public static String QUERYSELECTNATIVE="select "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".id,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".id_pais,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadPedidoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoPrioridadPedidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPrioridadPedidoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoPrioridadPedidoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoPrioridadPedidoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPrioridadPedidoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoPrioridadPedidoDescripcion(TipoPrioridadPedido tipoprioridadpedido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprioridadpedido !=null/* && tipoprioridadpedido.getId()!=0*/) {
			sDescripcion=tipoprioridadpedido.getnombre();//tipoprioridadpedidotipoprioridadpedido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPrioridadPedidoDescripcionDetallado(TipoPrioridadPedido tipoprioridadpedido) {
		String sDescripcion="";
			
		sDescripcion+=TipoPrioridadPedidoConstantesFunciones.ID+"=";
		sDescripcion+=tipoprioridadpedido.getId().toString()+",";
		sDescripcion+=TipoPrioridadPedidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprioridadpedido.getVersionRow().toString()+",";
		sDescripcion+=TipoPrioridadPedidoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipoprioridadpedido.getid_pais().toString()+",";
		sDescripcion+=TipoPrioridadPedidoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprioridadpedido.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPrioridadPedidoDescripcion(TipoPrioridadPedido tipoprioridadpedido,String sValor) throws Exception {			
		if(tipoprioridadpedido !=null) {
			tipoprioridadpedido.setnombre(sValor);//tipoprioridadpedidotipoprioridadpedido.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
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

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprioridadpedido.setnombre(tipoprioridadpedido.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPrioridadPedidos(List<TipoPrioridadPedido> tipoprioridadpedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrioridadPedido tipoprioridadpedido: tipoprioridadpedidos) {
			tipoprioridadpedido.setnombre(tipoprioridadpedido.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprioridadpedido.getConCambioAuxiliar()) {
			tipoprioridadpedido.setIsDeleted(tipoprioridadpedido.getIsDeletedAuxiliar());	
			tipoprioridadpedido.setIsNew(tipoprioridadpedido.getIsNewAuxiliar());	
			tipoprioridadpedido.setIsChanged(tipoprioridadpedido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprioridadpedido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprioridadpedido.setIsDeletedAuxiliar(false);	
			tipoprioridadpedido.setIsNewAuxiliar(false);	
			tipoprioridadpedido.setIsChangedAuxiliar(false);
			
			tipoprioridadpedido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrioridadPedidos(List<TipoPrioridadPedido> tipoprioridadpedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPrioridadPedido tipoprioridadpedido : tipoprioridadpedidos) {
			if(conAsignarBase && tipoprioridadpedido.getConCambioAuxiliar()) {
				tipoprioridadpedido.setIsDeleted(tipoprioridadpedido.getIsDeletedAuxiliar());	
				tipoprioridadpedido.setIsNew(tipoprioridadpedido.getIsNewAuxiliar());	
				tipoprioridadpedido.setIsChanged(tipoprioridadpedido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprioridadpedido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprioridadpedido.setIsDeletedAuxiliar(false);	
				tipoprioridadpedido.setIsNewAuxiliar(false);	
				tipoprioridadpedido.setIsChangedAuxiliar(false);
				
				tipoprioridadpedido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPrioridadPedidos(List<TipoPrioridadPedido> tipoprioridadpedidos,Boolean conEnteros) throws Exception  {
		
		for(TipoPrioridadPedido tipoprioridadpedido: tipoprioridadpedidos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPrioridadPedido(List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedido tipoprioridadpedidoAux) throws Exception  {
		TipoPrioridadPedidoConstantesFunciones.InicializarValoresTipoPrioridadPedido(tipoprioridadpedidoAux,true);
		
		for(TipoPrioridadPedido tipoprioridadpedido: tipoprioridadpedidos) {
			if(tipoprioridadpedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPrioridadPedidoConstantesFunciones.getArrayColumnasGlobalesTipoPrioridadPedido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPrioridadPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrioridadPedido> tipoprioridadpedidos,TipoPrioridadPedido tipoprioridadpedido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrioridadPedido tipoprioridadpedidoAux: tipoprioridadpedidos) {
			if(tipoprioridadpedidoAux!=null && tipoprioridadpedido!=null) {
				if((tipoprioridadpedidoAux.getId()==null && tipoprioridadpedido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprioridadpedidoAux.getId()!=null && tipoprioridadpedido.getId()!=null){
					if(tipoprioridadpedidoAux.getId().equals(tipoprioridadpedido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrioridadPedido(List<TipoPrioridadPedido> tipoprioridadpedidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPrioridadPedido tipoprioridadpedido: tipoprioridadpedidos) {			
			if(tipoprioridadpedido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPrioridadPedido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPrioridadPedidoConstantesFunciones.LABEL_ID, TipoPrioridadPedidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadPedidoConstantesFunciones.LABEL_VERSIONROW, TipoPrioridadPedidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadPedidoConstantesFunciones.LABEL_IDPAIS, TipoPrioridadPedidoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrioridadPedidoConstantesFunciones.LABEL_NOMBRE, TipoPrioridadPedidoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPrioridadPedido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadPedidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadPedidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadPedidoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrioridadPedidoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadPedido() throws Exception  {
		return TipoPrioridadPedidoConstantesFunciones.getTiposSeleccionarTipoPrioridadPedido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadPedido(Boolean conFk) throws Exception  {
		return TipoPrioridadPedidoConstantesFunciones.getTiposSeleccionarTipoPrioridadPedido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrioridadPedido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrioridadPedidoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoPrioridadPedidoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrioridadPedidoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPrioridadPedidoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPrioridadPedido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedidoAux) throws Exception {
		
			tipoprioridadpedidoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoprioridadpedidoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrioridadPedido(List<TipoPrioridadPedido> tipoprioridadpedidosTemp) throws Exception {
		for(TipoPrioridadPedido tipoprioridadpedidoAux:tipoprioridadpedidosTemp) {
			
			tipoprioridadpedidoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoprioridadpedidoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrioridadPedidoConstantesFunciones.getClassesRelationshipsOfTipoPrioridadPedido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadPedido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrioridadPedidoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPrioridadPedido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrioridadPedido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPrioridadPedido tipoprioridadpedido,List<TipoPrioridadPedido> tipoprioridadpedidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPrioridadPedido tipoprioridadpedidoEncontrado=null;
			
			for(TipoPrioridadPedido tipoprioridadpedidoLocal:tipoprioridadpedidos) {
				if(tipoprioridadpedidoLocal.getId().equals(tipoprioridadpedido.getId())) {
					tipoprioridadpedidoEncontrado=tipoprioridadpedidoLocal;
					
					tipoprioridadpedidoLocal.setIsChanged(tipoprioridadpedido.getIsChanged());
					tipoprioridadpedidoLocal.setIsNew(tipoprioridadpedido.getIsNew());
					tipoprioridadpedidoLocal.setIsDeleted(tipoprioridadpedido.getIsDeleted());
					
					tipoprioridadpedidoLocal.setGeneralEntityOriginal(tipoprioridadpedido.getGeneralEntityOriginal());
					
					tipoprioridadpedidoLocal.setId(tipoprioridadpedido.getId());	
					tipoprioridadpedidoLocal.setVersionRow(tipoprioridadpedido.getVersionRow());	
					tipoprioridadpedidoLocal.setid_pais(tipoprioridadpedido.getid_pais());	
					tipoprioridadpedidoLocal.setnombre(tipoprioridadpedido.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprioridadpedido.getIsDeleted()) {
				if(!existe) {
					tipoprioridadpedidos.add(tipoprioridadpedido);
				}
			} else {
				if(tipoprioridadpedidoEncontrado!=null && permiteQuitar)  {
					tipoprioridadpedidos.remove(tipoprioridadpedidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPrioridadPedido tipoprioridadpedido,List<TipoPrioridadPedido> tipoprioridadpedidos) throws Exception {
		try	{			
			for(TipoPrioridadPedido tipoprioridadpedidoLocal:tipoprioridadpedidos) {
				if(tipoprioridadpedidoLocal.getId().equals(tipoprioridadpedido.getId())) {
					tipoprioridadpedidoLocal.setIsSelected(tipoprioridadpedido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPrioridadPedido(List<TipoPrioridadPedido> tipoprioridadpedidosAux) throws Exception {
		//this.tipoprioridadpedidosAux=tipoprioridadpedidosAux;
		
		for(TipoPrioridadPedido tipoprioridadpedidoAux:tipoprioridadpedidosAux) {
			if(tipoprioridadpedidoAux.getIsChanged()) {
				tipoprioridadpedidoAux.setIsChanged(false);
			}		
			
			if(tipoprioridadpedidoAux.getIsNew()) {
				tipoprioridadpedidoAux.setIsNew(false);
			}	
			
			if(tipoprioridadpedidoAux.getIsDeleted()) {
				tipoprioridadpedidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedidoAux) throws Exception {
		//this.tipoprioridadpedidoAux=tipoprioridadpedidoAux;
		
			if(tipoprioridadpedidoAux.getIsChanged()) {
				tipoprioridadpedidoAux.setIsChanged(false);
			}		
			
			if(tipoprioridadpedidoAux.getIsNew()) {
				tipoprioridadpedidoAux.setIsNew(false);
			}	
			
			if(tipoprioridadpedidoAux.getIsDeleted()) {
				tipoprioridadpedidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPrioridadPedido tipoprioridadpedidoAsignar,TipoPrioridadPedido tipoprioridadpedido) throws Exception {
		tipoprioridadpedidoAsignar.setId(tipoprioridadpedido.getId());	
		tipoprioridadpedidoAsignar.setVersionRow(tipoprioridadpedido.getVersionRow());	
		tipoprioridadpedidoAsignar.setid_pais(tipoprioridadpedido.getid_pais());
		tipoprioridadpedidoAsignar.setpais_descripcion(tipoprioridadpedido.getpais_descripcion());	
		tipoprioridadpedidoAsignar.setnombre(tipoprioridadpedido.getnombre());	
	}
	
	public static void inicializarTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido) throws Exception {
		try {
				tipoprioridadpedido.setId(0L);	
					
				tipoprioridadpedido.setid_pais(-1L);	
				tipoprioridadpedido.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPrioridadPedido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrioridadPedidoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrioridadPedidoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPrioridadPedido(String sTipo,Row row,Workbook workbook,TipoPrioridadPedido tipoprioridadpedido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprioridadpedido.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprioridadpedido.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPrioridadPedido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPrioridadPedido() {
		return this.sFinalQueryTipoPrioridadPedido;
	}
	
	public void setsFinalQueryTipoPrioridadPedido(String sFinalQueryTipoPrioridadPedido) {
		this.sFinalQueryTipoPrioridadPedido= sFinalQueryTipoPrioridadPedido;
	}
	
	public Border resaltarSeleccionarTipoPrioridadPedido=null;
	
	public Border setResaltarSeleccionarTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprioridadpedidoBeanSwingJInternalFrame.jTtoolBarTipoPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPrioridadPedido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPrioridadPedido() {
		return this.resaltarSeleccionarTipoPrioridadPedido;
	}
	
	public void setResaltarSeleccionarTipoPrioridadPedido(Border borderResaltarSeleccionarTipoPrioridadPedido) {
		this.resaltarSeleccionarTipoPrioridadPedido= borderResaltarSeleccionarTipoPrioridadPedido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPrioridadPedido=null;
	public Boolean mostraridTipoPrioridadPedido=true;
	public Boolean activaridTipoPrioridadPedido=true;

	public Border resaltarid_paisTipoPrioridadPedido=null;
	public Boolean mostrarid_paisTipoPrioridadPedido=true;
	public Boolean activarid_paisTipoPrioridadPedido=true;
	public Boolean cargarid_paisTipoPrioridadPedido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoPrioridadPedido=false;//ConEventDepend=true

	public Border resaltarnombreTipoPrioridadPedido=null;
	public Boolean mostrarnombreTipoPrioridadPedido=true;
	public Boolean activarnombreTipoPrioridadPedido=true;

	
	

	public Border setResaltaridTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadpedidoBeanSwingJInternalFrame.jTtoolBarTipoPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltaridTipoPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPrioridadPedido() {
		return this.resaltaridTipoPrioridadPedido;
	}

	public void setResaltaridTipoPrioridadPedido(Border borderResaltar) {
		this.resaltaridTipoPrioridadPedido= borderResaltar;
	}

	public Boolean getMostraridTipoPrioridadPedido() {
		return this.mostraridTipoPrioridadPedido;
	}

	public void setMostraridTipoPrioridadPedido(Boolean mostraridTipoPrioridadPedido) {
		this.mostraridTipoPrioridadPedido= mostraridTipoPrioridadPedido;
	}

	public Boolean getActivaridTipoPrioridadPedido() {
		return this.activaridTipoPrioridadPedido;
	}

	public void setActivaridTipoPrioridadPedido(Boolean activaridTipoPrioridadPedido) {
		this.activaridTipoPrioridadPedido= activaridTipoPrioridadPedido;
	}

	public Border setResaltarid_paisTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadpedidoBeanSwingJInternalFrame.jTtoolBarTipoPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoPrioridadPedido() {
		return this.resaltarid_paisTipoPrioridadPedido;
	}

	public void setResaltarid_paisTipoPrioridadPedido(Border borderResaltar) {
		this.resaltarid_paisTipoPrioridadPedido= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoPrioridadPedido() {
		return this.mostrarid_paisTipoPrioridadPedido;
	}

	public void setMostrarid_paisTipoPrioridadPedido(Boolean mostrarid_paisTipoPrioridadPedido) {
		this.mostrarid_paisTipoPrioridadPedido= mostrarid_paisTipoPrioridadPedido;
	}

	public Boolean getActivarid_paisTipoPrioridadPedido() {
		return this.activarid_paisTipoPrioridadPedido;
	}

	public void setActivarid_paisTipoPrioridadPedido(Boolean activarid_paisTipoPrioridadPedido) {
		this.activarid_paisTipoPrioridadPedido= activarid_paisTipoPrioridadPedido;
	}

	public Boolean getCargarid_paisTipoPrioridadPedido() {
		return this.cargarid_paisTipoPrioridadPedido;
	}

	public void setCargarid_paisTipoPrioridadPedido(Boolean cargarid_paisTipoPrioridadPedido) {
		this.cargarid_paisTipoPrioridadPedido= cargarid_paisTipoPrioridadPedido;
	}

	public Border setResaltarnombreTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprioridadpedidoBeanSwingJInternalFrame.jTtoolBarTipoPrioridadPedido.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPrioridadPedido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPrioridadPedido() {
		return this.resaltarnombreTipoPrioridadPedido;
	}

	public void setResaltarnombreTipoPrioridadPedido(Border borderResaltar) {
		this.resaltarnombreTipoPrioridadPedido= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPrioridadPedido() {
		return this.mostrarnombreTipoPrioridadPedido;
	}

	public void setMostrarnombreTipoPrioridadPedido(Boolean mostrarnombreTipoPrioridadPedido) {
		this.mostrarnombreTipoPrioridadPedido= mostrarnombreTipoPrioridadPedido;
	}

	public Boolean getActivarnombreTipoPrioridadPedido() {
		return this.activarnombreTipoPrioridadPedido;
	}

	public void setActivarnombreTipoPrioridadPedido(Boolean activarnombreTipoPrioridadPedido) {
		this.activarnombreTipoPrioridadPedido= activarnombreTipoPrioridadPedido;
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
		
		
		this.setMostraridTipoPrioridadPedido(esInicial);
		this.setMostrarid_paisTipoPrioridadPedido(esInicial);
		this.setMostrarnombreTipoPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.ID)) {
				this.setMostraridTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPrioridadPedido(esAsigna);
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
		
		
		this.setActivaridTipoPrioridadPedido(esInicial);
		this.setActivarid_paisTipoPrioridadPedido(esInicial);
		this.setActivarnombreTipoPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.ID)) {
				this.setActivaridTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPrioridadPedido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPrioridadPedido(esInicial);
		this.setResaltarid_paisTipoPrioridadPedido(esInicial);
		this.setResaltarnombreTipoPrioridadPedido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.ID)) {
				this.setResaltaridTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoPrioridadPedido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrioridadPedidoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPrioridadPedido(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoPrioridadPedido=true;

	public Boolean getMostrarBusquedaPorNombreTipoPrioridadPedido() {
		return this.mostrarBusquedaPorNombreTipoPrioridadPedido;
	}

	public void setMostrarBusquedaPorNombreTipoPrioridadPedido(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoPrioridadPedido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoPrioridadPedido=true;

	public Boolean getMostrarFK_IdPaisTipoPrioridadPedido() {
		return this.mostrarFK_IdPaisTipoPrioridadPedido;
	}

	public void setMostrarFK_IdPaisTipoPrioridadPedido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoPrioridadPedido= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoPrioridadPedido=true;

	public Boolean getActivarBusquedaPorNombreTipoPrioridadPedido() {
		return this.activarBusquedaPorNombreTipoPrioridadPedido;
	}

	public void setActivarBusquedaPorNombreTipoPrioridadPedido(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoPrioridadPedido= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoPrioridadPedido=true;

	public Boolean getActivarFK_IdPaisTipoPrioridadPedido() {
		return this.activarFK_IdPaisTipoPrioridadPedido;
	}

	public void setActivarFK_IdPaisTipoPrioridadPedido(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoPrioridadPedido= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoPrioridadPedido=null;

	public Border getResaltarBusquedaPorNombreTipoPrioridadPedido() {
		return this.resaltarBusquedaPorNombreTipoPrioridadPedido;
	}

	public void setResaltarBusquedaPorNombreTipoPrioridadPedido(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoPrioridadPedido= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoPrioridadPedido= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoPrioridadPedido=null;

	public Border getResaltarFK_IdPaisTipoPrioridadPedido() {
		return this.resaltarFK_IdPaisTipoPrioridadPedido;
	}

	public void setResaltarFK_IdPaisTipoPrioridadPedido(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoPrioridadPedido= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoPrioridadPedido(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrioridadPedidoBeanSwingJInternalFrame tipoprioridadpedidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoPrioridadPedido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
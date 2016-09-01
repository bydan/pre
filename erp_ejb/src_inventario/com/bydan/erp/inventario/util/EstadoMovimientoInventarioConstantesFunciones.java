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


import com.bydan.erp.inventario.util.EstadoMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoMovimientoInventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoMovimientoInventarioConstantesFunciones extends EstadoMovimientoInventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoMovimientoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoMovimientoInventario"+EstadoMovimientoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoMovimientoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoMovimientoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"_"+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoMovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoMovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoMovimientoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoMovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoMovimientoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Movimiento Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Movimiento Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Estado Movimiento Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoMovimientoInventario";
	public static final String OBJECTNAME="estadomovimientoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_movimiento_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadomovimientoinventario from "+EstadoMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" estadomovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoMovimientoInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoMovimientoInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoMovimientoInventarioConstantesFuncionesAdditional estadomovimientoinventarioConstantesFuncionesAdditional=null;
	
	public EstadoMovimientoInventarioConstantesFuncionesAdditional getEstadoMovimientoInventarioConstantesFuncionesAdditional() {
		return this.estadomovimientoinventarioConstantesFuncionesAdditional;
	}
	
	public void setEstadoMovimientoInventarioConstantesFuncionesAdditional(EstadoMovimientoInventarioConstantesFuncionesAdditional estadomovimientoinventarioConstantesFuncionesAdditional) {
		try {
			this.estadomovimientoinventarioConstantesFuncionesAdditional=estadomovimientoinventarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getEstadoMovimientoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoMovimientoInventarioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoMovimientoInventarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoMovimientoInventarioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoMovimientoInventarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoMovimientoInventarioDescripcion(EstadoMovimientoInventario estadomovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadomovimientoinventario !=null/* && estadomovimientoinventario.getId()!=0*/) {
			sDescripcion=estadomovimientoinventario.getcodigo();//estadomovimientoinventarioestadomovimientoinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoMovimientoInventarioDescripcionDetallado(EstadoMovimientoInventario estadomovimientoinventario) {
		String sDescripcion="";
			
		sDescripcion+=EstadoMovimientoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=estadomovimientoinventario.getId().toString()+",";
		sDescripcion+=EstadoMovimientoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadomovimientoinventario.getVersionRow().toString()+",";
		sDescripcion+=EstadoMovimientoInventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadomovimientoinventario.getcodigo()+",";
		sDescripcion+=EstadoMovimientoInventarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadomovimientoinventario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoMovimientoInventarioDescripcion(EstadoMovimientoInventario estadomovimientoinventario,String sValor) throws Exception {			
		if(estadomovimientoinventario !=null) {
			estadomovimientoinventario.setcodigo(sValor);;//estadomovimientoinventarioestadomovimientoinventario.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadomovimientoinventario.setcodigo(estadomovimientoinventario.getcodigo().trim());
		estadomovimientoinventario.setnombre(estadomovimientoinventario.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoMovimientoInventarios(List<EstadoMovimientoInventario> estadomovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoMovimientoInventario estadomovimientoinventario: estadomovimientoinventarios) {
			estadomovimientoinventario.setcodigo(estadomovimientoinventario.getcodigo().trim());
			estadomovimientoinventario.setnombre(estadomovimientoinventario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadomovimientoinventario.getConCambioAuxiliar()) {
			estadomovimientoinventario.setIsDeleted(estadomovimientoinventario.getIsDeletedAuxiliar());	
			estadomovimientoinventario.setIsNew(estadomovimientoinventario.getIsNewAuxiliar());	
			estadomovimientoinventario.setIsChanged(estadomovimientoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadomovimientoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadomovimientoinventario.setIsDeletedAuxiliar(false);	
			estadomovimientoinventario.setIsNewAuxiliar(false);	
			estadomovimientoinventario.setIsChangedAuxiliar(false);
			
			estadomovimientoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoMovimientoInventarios(List<EstadoMovimientoInventario> estadomovimientoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoMovimientoInventario estadomovimientoinventario : estadomovimientoinventarios) {
			if(conAsignarBase && estadomovimientoinventario.getConCambioAuxiliar()) {
				estadomovimientoinventario.setIsDeleted(estadomovimientoinventario.getIsDeletedAuxiliar());	
				estadomovimientoinventario.setIsNew(estadomovimientoinventario.getIsNewAuxiliar());	
				estadomovimientoinventario.setIsChanged(estadomovimientoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadomovimientoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadomovimientoinventario.setIsDeletedAuxiliar(false);	
				estadomovimientoinventario.setIsNewAuxiliar(false);	
				estadomovimientoinventario.setIsChangedAuxiliar(false);
				
				estadomovimientoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoMovimientoInventarios(List<EstadoMovimientoInventario> estadomovimientoinventarios,Boolean conEnteros) throws Exception  {
		
		for(EstadoMovimientoInventario estadomovimientoinventario: estadomovimientoinventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoMovimientoInventario(List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventario estadomovimientoinventarioAux) throws Exception  {
		EstadoMovimientoInventarioConstantesFunciones.InicializarValoresEstadoMovimientoInventario(estadomovimientoinventarioAux,true);
		
		for(EstadoMovimientoInventario estadomovimientoinventario: estadomovimientoinventarios) {
			if(estadomovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoMovimientoInventarioConstantesFunciones.getArrayColumnasGlobalesEstadoMovimientoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoMovimientoInventario> estadomovimientoinventarios,EstadoMovimientoInventario estadomovimientoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoMovimientoInventario estadomovimientoinventarioAux: estadomovimientoinventarios) {
			if(estadomovimientoinventarioAux!=null && estadomovimientoinventario!=null) {
				if((estadomovimientoinventarioAux.getId()==null && estadomovimientoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadomovimientoinventarioAux.getId()!=null && estadomovimientoinventario.getId()!=null){
					if(estadomovimientoinventarioAux.getId().equals(estadomovimientoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoMovimientoInventario(List<EstadoMovimientoInventario> estadomovimientoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoMovimientoInventario estadomovimientoinventario: estadomovimientoinventarios) {			
			if(estadomovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoMovimientoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoMovimientoInventarioConstantesFunciones.LABEL_ID, EstadoMovimientoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoMovimientoInventarioConstantesFunciones.LABEL_VERSIONROW, EstadoMovimientoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoMovimientoInventarioConstantesFunciones.LABEL_CODIGO, EstadoMovimientoInventarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoMovimientoInventarioConstantesFunciones.LABEL_NOMBRE, EstadoMovimientoInventarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoMovimientoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoMovimientoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoMovimientoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoMovimientoInventarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoMovimientoInventarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoMovimientoInventario() throws Exception  {
		return EstadoMovimientoInventarioConstantesFunciones.getTiposSeleccionarEstadoMovimientoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoMovimientoInventario(Boolean conFk) throws Exception  {
		return EstadoMovimientoInventarioConstantesFunciones.getTiposSeleccionarEstadoMovimientoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoMovimientoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoMovimientoInventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoMovimientoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoMovimientoInventario(List<EstadoMovimientoInventario> estadomovimientoinventariosTemp) throws Exception {
		for(EstadoMovimientoInventario estadomovimientoinventarioAux:estadomovimientoinventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoMovimientoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MovimientoInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoInventario.class)) {
						classes.add(new Classe(MovimientoInventario.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoMovimientoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoMovimientoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
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
	public static void actualizarLista(EstadoMovimientoInventario estadomovimientoinventario,List<EstadoMovimientoInventario> estadomovimientoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoMovimientoInventario estadomovimientoinventarioEncontrado=null;
			
			for(EstadoMovimientoInventario estadomovimientoinventarioLocal:estadomovimientoinventarios) {
				if(estadomovimientoinventarioLocal.getId().equals(estadomovimientoinventario.getId())) {
					estadomovimientoinventarioEncontrado=estadomovimientoinventarioLocal;
					
					estadomovimientoinventarioLocal.setIsChanged(estadomovimientoinventario.getIsChanged());
					estadomovimientoinventarioLocal.setIsNew(estadomovimientoinventario.getIsNew());
					estadomovimientoinventarioLocal.setIsDeleted(estadomovimientoinventario.getIsDeleted());
					
					estadomovimientoinventarioLocal.setGeneralEntityOriginal(estadomovimientoinventario.getGeneralEntityOriginal());
					
					estadomovimientoinventarioLocal.setId(estadomovimientoinventario.getId());	
					estadomovimientoinventarioLocal.setVersionRow(estadomovimientoinventario.getVersionRow());	
					estadomovimientoinventarioLocal.setcodigo(estadomovimientoinventario.getcodigo());	
					estadomovimientoinventarioLocal.setnombre(estadomovimientoinventario.getnombre());	
					
					
					estadomovimientoinventarioLocal.setMovimientoInventarios(estadomovimientoinventario.getMovimientoInventarios());
					
					existe=true;
					break;
				}
			}
			
			if(!estadomovimientoinventario.getIsDeleted()) {
				if(!existe) {
					estadomovimientoinventarios.add(estadomovimientoinventario);
				}
			} else {
				if(estadomovimientoinventarioEncontrado!=null && permiteQuitar)  {
					estadomovimientoinventarios.remove(estadomovimientoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoMovimientoInventario estadomovimientoinventario,List<EstadoMovimientoInventario> estadomovimientoinventarios) throws Exception {
		try	{			
			for(EstadoMovimientoInventario estadomovimientoinventarioLocal:estadomovimientoinventarios) {
				if(estadomovimientoinventarioLocal.getId().equals(estadomovimientoinventario.getId())) {
					estadomovimientoinventarioLocal.setIsSelected(estadomovimientoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoMovimientoInventario(List<EstadoMovimientoInventario> estadomovimientoinventariosAux) throws Exception {
		//this.estadomovimientoinventariosAux=estadomovimientoinventariosAux;
		
		for(EstadoMovimientoInventario estadomovimientoinventarioAux:estadomovimientoinventariosAux) {
			if(estadomovimientoinventarioAux.getIsChanged()) {
				estadomovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(estadomovimientoinventarioAux.getIsNew()) {
				estadomovimientoinventarioAux.setIsNew(false);
			}	
			
			if(estadomovimientoinventarioAux.getIsDeleted()) {
				estadomovimientoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventarioAux) throws Exception {
		//this.estadomovimientoinventarioAux=estadomovimientoinventarioAux;
		
			if(estadomovimientoinventarioAux.getIsChanged()) {
				estadomovimientoinventarioAux.setIsChanged(false);
			}		
			
			if(estadomovimientoinventarioAux.getIsNew()) {
				estadomovimientoinventarioAux.setIsNew(false);
			}	
			
			if(estadomovimientoinventarioAux.getIsDeleted()) {
				estadomovimientoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoMovimientoInventario estadomovimientoinventarioAsignar,EstadoMovimientoInventario estadomovimientoinventario) throws Exception {
		estadomovimientoinventarioAsignar.setId(estadomovimientoinventario.getId());	
		estadomovimientoinventarioAsignar.setVersionRow(estadomovimientoinventario.getVersionRow());	
		estadomovimientoinventarioAsignar.setcodigo(estadomovimientoinventario.getcodigo());	
		estadomovimientoinventarioAsignar.setnombre(estadomovimientoinventario.getnombre());	
	}
	
	public static void inicializarEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario) throws Exception {
		try {
				estadomovimientoinventario.setId(0L);	
					
				estadomovimientoinventario.setcodigo("");	
				estadomovimientoinventario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoMovimientoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoMovimientoInventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoMovimientoInventarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoMovimientoInventario(String sTipo,Row row,Workbook workbook,EstadoMovimientoInventario estadomovimientoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadomovimientoinventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadomovimientoinventario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoMovimientoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoMovimientoInventario() {
		return this.sFinalQueryEstadoMovimientoInventario;
	}
	
	public void setsFinalQueryEstadoMovimientoInventario(String sFinalQueryEstadoMovimientoInventario) {
		this.sFinalQueryEstadoMovimientoInventario= sFinalQueryEstadoMovimientoInventario;
	}
	
	public Border resaltarSeleccionarEstadoMovimientoInventario=null;
	
	public Border setResaltarSeleccionarEstadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadomovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoMovimientoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoMovimientoInventario() {
		return this.resaltarSeleccionarEstadoMovimientoInventario;
	}
	
	public void setResaltarSeleccionarEstadoMovimientoInventario(Border borderResaltarSeleccionarEstadoMovimientoInventario) {
		this.resaltarSeleccionarEstadoMovimientoInventario= borderResaltarSeleccionarEstadoMovimientoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoMovimientoInventario=null;
	public Boolean mostraridEstadoMovimientoInventario=true;
	public Boolean activaridEstadoMovimientoInventario=true;

	public Border resaltarcodigoEstadoMovimientoInventario=null;
	public Boolean mostrarcodigoEstadoMovimientoInventario=true;
	public Boolean activarcodigoEstadoMovimientoInventario=true;

	public Border resaltarnombreEstadoMovimientoInventario=null;
	public Boolean mostrarnombreEstadoMovimientoInventario=true;
	public Boolean activarnombreEstadoMovimientoInventario=true;

	
	

	public Border setResaltaridEstadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadomovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltaridEstadoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoMovimientoInventario() {
		return this.resaltaridEstadoMovimientoInventario;
	}

	public void setResaltaridEstadoMovimientoInventario(Border borderResaltar) {
		this.resaltaridEstadoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostraridEstadoMovimientoInventario() {
		return this.mostraridEstadoMovimientoInventario;
	}

	public void setMostraridEstadoMovimientoInventario(Boolean mostraridEstadoMovimientoInventario) {
		this.mostraridEstadoMovimientoInventario= mostraridEstadoMovimientoInventario;
	}

	public Boolean getActivaridEstadoMovimientoInventario() {
		return this.activaridEstadoMovimientoInventario;
	}

	public void setActivaridEstadoMovimientoInventario(Boolean activaridEstadoMovimientoInventario) {
		this.activaridEstadoMovimientoInventario= activaridEstadoMovimientoInventario;
	}

	public Border setResaltarcodigoEstadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadomovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoMovimientoInventario() {
		return this.resaltarcodigoEstadoMovimientoInventario;
	}

	public void setResaltarcodigoEstadoMovimientoInventario(Border borderResaltar) {
		this.resaltarcodigoEstadoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoMovimientoInventario() {
		return this.mostrarcodigoEstadoMovimientoInventario;
	}

	public void setMostrarcodigoEstadoMovimientoInventario(Boolean mostrarcodigoEstadoMovimientoInventario) {
		this.mostrarcodigoEstadoMovimientoInventario= mostrarcodigoEstadoMovimientoInventario;
	}

	public Boolean getActivarcodigoEstadoMovimientoInventario() {
		return this.activarcodigoEstadoMovimientoInventario;
	}

	public void setActivarcodigoEstadoMovimientoInventario(Boolean activarcodigoEstadoMovimientoInventario) {
		this.activarcodigoEstadoMovimientoInventario= activarcodigoEstadoMovimientoInventario;
	}

	public Border setResaltarnombreEstadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadomovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoMovimientoInventario() {
		return this.resaltarnombreEstadoMovimientoInventario;
	}

	public void setResaltarnombreEstadoMovimientoInventario(Border borderResaltar) {
		this.resaltarnombreEstadoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoMovimientoInventario() {
		return this.mostrarnombreEstadoMovimientoInventario;
	}

	public void setMostrarnombreEstadoMovimientoInventario(Boolean mostrarnombreEstadoMovimientoInventario) {
		this.mostrarnombreEstadoMovimientoInventario= mostrarnombreEstadoMovimientoInventario;
	}

	public Boolean getActivarnombreEstadoMovimientoInventario() {
		return this.activarnombreEstadoMovimientoInventario;
	}

	public void setActivarnombreEstadoMovimientoInventario(Boolean activarnombreEstadoMovimientoInventario) {
		this.activarnombreEstadoMovimientoInventario= activarnombreEstadoMovimientoInventario;
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
		
		
		this.setMostraridEstadoMovimientoInventario(esInicial);
		this.setMostrarcodigoEstadoMovimientoInventario(esInicial);
		this.setMostrarnombreEstadoMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.ID)) {
				this.setMostraridEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoMovimientoInventario(esAsigna);
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
		
		
		this.setActivaridEstadoMovimientoInventario(esInicial);
		this.setActivarcodigoEstadoMovimientoInventario(esInicial);
		this.setActivarnombreEstadoMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.ID)) {
				this.setActivaridEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoMovimientoInventario(esInicial);
		this.setResaltarcodigoEstadoMovimientoInventario(esInicial);
		this.setResaltarnombreEstadoMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.ID)) {
				this.setResaltaridEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoMovimientoInventarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarMovimientoInventarioEstadoMovimientoInventario=null;

	public Border getResaltarMovimientoInventarioEstadoMovimientoInventario() {
		return this.resaltarMovimientoInventarioEstadoMovimientoInventario;
	}

	public void setResaltarMovimientoInventarioEstadoMovimientoInventario(Border borderResaltarMovimientoInventario) {
		if(borderResaltarMovimientoInventario!=null) {
			this.resaltarMovimientoInventarioEstadoMovimientoInventario= borderResaltarMovimientoInventario;
		}
	}

	public Border setResaltarMovimientoInventarioEstadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarMovimientoInventario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadomovimientoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoMovimientoInventario.setBorder(borderResaltarMovimientoInventario);
			
		this.resaltarMovimientoInventarioEstadoMovimientoInventario= borderResaltarMovimientoInventario;

		 return borderResaltarMovimientoInventario;
	}



	public Boolean mostrarMovimientoInventarioEstadoMovimientoInventario=true;

	public Boolean getMostrarMovimientoInventarioEstadoMovimientoInventario() {
		return this.mostrarMovimientoInventarioEstadoMovimientoInventario;
	}

	public void setMostrarMovimientoInventarioEstadoMovimientoInventario(Boolean visibilidadResaltarMovimientoInventario) {
		this.mostrarMovimientoInventarioEstadoMovimientoInventario= visibilidadResaltarMovimientoInventario;
	}



	public Boolean activarMovimientoInventarioEstadoMovimientoInventario=true;

	public Boolean gethabilitarResaltarMovimientoInventarioEstadoMovimientoInventario() {
		return this.activarMovimientoInventarioEstadoMovimientoInventario;
	}

	public void setActivarMovimientoInventarioEstadoMovimientoInventario(Boolean habilitarResaltarMovimientoInventario) {
		this.activarMovimientoInventarioEstadoMovimientoInventario= habilitarResaltarMovimientoInventario;
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

		this.setMostrarMovimientoInventarioEstadoMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MovimientoInventario.class)) {
				this.setMostrarMovimientoInventarioEstadoMovimientoInventario(esAsigna);
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

		this.setActivarMovimientoInventarioEstadoMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MovimientoInventario.class)) {
				this.setActivarMovimientoInventarioEstadoMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoMovimientoInventarioBeanSwingJInternalFrame estadomovimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarMovimientoInventarioEstadoMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MovimientoInventario.class)) {
				this.setResaltarMovimientoInventarioEstadoMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}
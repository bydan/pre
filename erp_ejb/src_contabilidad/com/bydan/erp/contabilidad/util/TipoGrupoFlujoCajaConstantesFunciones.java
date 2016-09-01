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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoGrupoFlujoCajaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGrupoFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGrupoFlujoCaja"+TipoGrupoFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGrupoFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGrupoFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"_"+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGrupoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGrupoFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGrupoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGrupoFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Grupo Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Grupo Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Grupo Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGrupoFlujoCaja";
	public static final String OBJECTNAME="tipogrupoflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_grupo_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogrupoflujocaja from "+TipoGrupoFlujoCajaConstantesFunciones.SPERSISTENCENAME+" tipogrupoflujocaja";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME+".id,"+TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME+".codigo,"+TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoFlujoCajaConstantesFunciones.SCHEMA+"."+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME;//+" as "+TipoGrupoFlujoCajaConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoGrupoFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGrupoFlujoCajaConstantesFunciones.CODIGO)) {sLabelColumna=TipoGrupoFlujoCajaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGrupoFlujoCajaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGrupoFlujoCajaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGrupoFlujoCajaDescripcion(TipoGrupoFlujoCaja tipogrupoflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogrupoflujocaja !=null/* && tipogrupoflujocaja.getId()!=0*/) {
			sDescripcion=tipogrupoflujocaja.getcodigo();//tipogrupoflujocajatipogrupoflujocaja.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGrupoFlujoCajaDescripcionDetallado(TipoGrupoFlujoCaja tipogrupoflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=TipoGrupoFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=tipogrupoflujocaja.getId().toString()+",";
		sDescripcion+=TipoGrupoFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogrupoflujocaja.getVersionRow().toString()+",";
		sDescripcion+=TipoGrupoFlujoCajaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipogrupoflujocaja.getcodigo()+",";
		sDescripcion+=TipoGrupoFlujoCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogrupoflujocaja.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGrupoFlujoCajaDescripcion(TipoGrupoFlujoCaja tipogrupoflujocaja,String sValor) throws Exception {			
		if(tipogrupoflujocaja !=null) {
			tipogrupoflujocaja.setcodigo(sValor);;//tipogrupoflujocajatipogrupoflujocaja.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogrupoflujocaja.setcodigo(tipogrupoflujocaja.getcodigo().trim());
		tipogrupoflujocaja.setnombre(tipogrupoflujocaja.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGrupoFlujoCajas(List<TipoGrupoFlujoCaja> tipogrupoflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja: tipogrupoflujocajas) {
			tipogrupoflujocaja.setcodigo(tipogrupoflujocaja.getcodigo().trim());
			tipogrupoflujocaja.setnombre(tipogrupoflujocaja.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogrupoflujocaja.getConCambioAuxiliar()) {
			tipogrupoflujocaja.setIsDeleted(tipogrupoflujocaja.getIsDeletedAuxiliar());	
			tipogrupoflujocaja.setIsNew(tipogrupoflujocaja.getIsNewAuxiliar());	
			tipogrupoflujocaja.setIsChanged(tipogrupoflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogrupoflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogrupoflujocaja.setIsDeletedAuxiliar(false);	
			tipogrupoflujocaja.setIsNewAuxiliar(false);	
			tipogrupoflujocaja.setIsChangedAuxiliar(false);
			
			tipogrupoflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoFlujoCajas(List<TipoGrupoFlujoCaja> tipogrupoflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja : tipogrupoflujocajas) {
			if(conAsignarBase && tipogrupoflujocaja.getConCambioAuxiliar()) {
				tipogrupoflujocaja.setIsDeleted(tipogrupoflujocaja.getIsDeletedAuxiliar());	
				tipogrupoflujocaja.setIsNew(tipogrupoflujocaja.getIsNewAuxiliar());	
				tipogrupoflujocaja.setIsChanged(tipogrupoflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogrupoflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogrupoflujocaja.setIsDeletedAuxiliar(false);	
				tipogrupoflujocaja.setIsNewAuxiliar(false);	
				tipogrupoflujocaja.setIsChangedAuxiliar(false);
				
				tipogrupoflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGrupoFlujoCajas(List<TipoGrupoFlujoCaja> tipogrupoflujocajas,Boolean conEnteros) throws Exception  {
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja: tipogrupoflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCaja tipogrupoflujocajaAux) throws Exception  {
		TipoGrupoFlujoCajaConstantesFunciones.InicializarValoresTipoGrupoFlujoCaja(tipogrupoflujocajaAux,true);
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja: tipogrupoflujocajas) {
			if(tipogrupoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGrupoFlujoCajaConstantesFunciones.getArrayColumnasGlobalesTipoGrupoFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGrupoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCaja tipogrupoflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGrupoFlujoCaja tipogrupoflujocajaAux: tipogrupoflujocajas) {
			if(tipogrupoflujocajaAux!=null && tipogrupoflujocaja!=null) {
				if((tipogrupoflujocajaAux.getId()==null && tipogrupoflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogrupoflujocajaAux.getId()!=null && tipogrupoflujocaja.getId()!=null){
					if(tipogrupoflujocajaAux.getId().equals(tipogrupoflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> tipogrupoflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGrupoFlujoCaja tipogrupoflujocaja: tipogrupoflujocajas) {			
			if(tipogrupoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGrupoFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGrupoFlujoCajaConstantesFunciones.LABEL_ID, TipoGrupoFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoFlujoCajaConstantesFunciones.LABEL_VERSIONROW, TipoGrupoFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoFlujoCajaConstantesFunciones.LABEL_CODIGO, TipoGrupoFlujoCajaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoFlujoCajaConstantesFunciones.LABEL_NOMBRE, TipoGrupoFlujoCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGrupoFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFlujoCajaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoFlujoCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFlujoCaja() throws Exception  {
		return TipoGrupoFlujoCajaConstantesFunciones.getTiposSeleccionarTipoGrupoFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFlujoCaja(Boolean conFk) throws Exception  {
		return TipoGrupoFlujoCajaConstantesFunciones.getTiposSeleccionarTipoGrupoFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoFlujoCajaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGrupoFlujoCajaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoFlujoCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGrupoFlujoCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGrupoFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocajaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> tipogrupoflujocajasTemp) throws Exception {
		for(TipoGrupoFlujoCaja tipogrupoflujocajaAux:tipogrupoflujocajasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGrupoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoGrupoFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(LineaFlujoCaja.class));
				classes.add(new Classe(CentroActividad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(LineaFlujoCaja.class)) {
						classes.add(new Classe(LineaFlujoCaja.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGrupoFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(LineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaFlujoCaja.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(LineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaFlujoCaja.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
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
	public static void actualizarLista(TipoGrupoFlujoCaja tipogrupoflujocaja,List<TipoGrupoFlujoCaja> tipogrupoflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGrupoFlujoCaja tipogrupoflujocajaEncontrado=null;
			
			for(TipoGrupoFlujoCaja tipogrupoflujocajaLocal:tipogrupoflujocajas) {
				if(tipogrupoflujocajaLocal.getId().equals(tipogrupoflujocaja.getId())) {
					tipogrupoflujocajaEncontrado=tipogrupoflujocajaLocal;
					
					tipogrupoflujocajaLocal.setIsChanged(tipogrupoflujocaja.getIsChanged());
					tipogrupoflujocajaLocal.setIsNew(tipogrupoflujocaja.getIsNew());
					tipogrupoflujocajaLocal.setIsDeleted(tipogrupoflujocaja.getIsDeleted());
					
					tipogrupoflujocajaLocal.setGeneralEntityOriginal(tipogrupoflujocaja.getGeneralEntityOriginal());
					
					tipogrupoflujocajaLocal.setId(tipogrupoflujocaja.getId());	
					tipogrupoflujocajaLocal.setVersionRow(tipogrupoflujocaja.getVersionRow());	
					tipogrupoflujocajaLocal.setcodigo(tipogrupoflujocaja.getcodigo());	
					tipogrupoflujocajaLocal.setnombre(tipogrupoflujocaja.getnombre());	
					
					
					tipogrupoflujocajaLocal.setLineaFlujoCajas(tipogrupoflujocaja.getLineaFlujoCajas());
					tipogrupoflujocajaLocal.setCentroActividads(tipogrupoflujocaja.getCentroActividads());
					
					existe=true;
					break;
				}
			}
			
			if(!tipogrupoflujocaja.getIsDeleted()) {
				if(!existe) {
					tipogrupoflujocajas.add(tipogrupoflujocaja);
				}
			} else {
				if(tipogrupoflujocajaEncontrado!=null && permiteQuitar)  {
					tipogrupoflujocajas.remove(tipogrupoflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGrupoFlujoCaja tipogrupoflujocaja,List<TipoGrupoFlujoCaja> tipogrupoflujocajas) throws Exception {
		try	{			
			for(TipoGrupoFlujoCaja tipogrupoflujocajaLocal:tipogrupoflujocajas) {
				if(tipogrupoflujocajaLocal.getId().equals(tipogrupoflujocaja.getId())) {
					tipogrupoflujocajaLocal.setIsSelected(tipogrupoflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> tipogrupoflujocajasAux) throws Exception {
		//this.tipogrupoflujocajasAux=tipogrupoflujocajasAux;
		
		for(TipoGrupoFlujoCaja tipogrupoflujocajaAux:tipogrupoflujocajasAux) {
			if(tipogrupoflujocajaAux.getIsChanged()) {
				tipogrupoflujocajaAux.setIsChanged(false);
			}		
			
			if(tipogrupoflujocajaAux.getIsNew()) {
				tipogrupoflujocajaAux.setIsNew(false);
			}	
			
			if(tipogrupoflujocajaAux.getIsDeleted()) {
				tipogrupoflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocajaAux) throws Exception {
		//this.tipogrupoflujocajaAux=tipogrupoflujocajaAux;
		
			if(tipogrupoflujocajaAux.getIsChanged()) {
				tipogrupoflujocajaAux.setIsChanged(false);
			}		
			
			if(tipogrupoflujocajaAux.getIsNew()) {
				tipogrupoflujocajaAux.setIsNew(false);
			}	
			
			if(tipogrupoflujocajaAux.getIsDeleted()) {
				tipogrupoflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGrupoFlujoCaja tipogrupoflujocajaAsignar,TipoGrupoFlujoCaja tipogrupoflujocaja) throws Exception {
		tipogrupoflujocajaAsignar.setId(tipogrupoflujocaja.getId());	
		tipogrupoflujocajaAsignar.setVersionRow(tipogrupoflujocaja.getVersionRow());	
		tipogrupoflujocajaAsignar.setcodigo(tipogrupoflujocaja.getcodigo());	
		tipogrupoflujocajaAsignar.setnombre(tipogrupoflujocaja.getnombre());	
	}
	
	public static void inicializarTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja) throws Exception {
		try {
				tipogrupoflujocaja.setId(0L);	
					
				tipogrupoflujocaja.setcodigo("");	
				tipogrupoflujocaja.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGrupoFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoFlujoCajaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoFlujoCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGrupoFlujoCaja(String sTipo,Row row,Workbook workbook,TipoGrupoFlujoCaja tipogrupoflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogrupoflujocaja.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogrupoflujocaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGrupoFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGrupoFlujoCaja() {
		return this.sFinalQueryTipoGrupoFlujoCaja;
	}
	
	public void setsFinalQueryTipoGrupoFlujoCaja(String sFinalQueryTipoGrupoFlujoCaja) {
		this.sFinalQueryTipoGrupoFlujoCaja= sFinalQueryTipoGrupoFlujoCaja;
	}
	
	public Border resaltarSeleccionarTipoGrupoFlujoCaja=null;
	
	public Border setResaltarSeleccionarTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGrupoFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGrupoFlujoCaja() {
		return this.resaltarSeleccionarTipoGrupoFlujoCaja;
	}
	
	public void setResaltarSeleccionarTipoGrupoFlujoCaja(Border borderResaltarSeleccionarTipoGrupoFlujoCaja) {
		this.resaltarSeleccionarTipoGrupoFlujoCaja= borderResaltarSeleccionarTipoGrupoFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGrupoFlujoCaja=null;
	public Boolean mostraridTipoGrupoFlujoCaja=true;
	public Boolean activaridTipoGrupoFlujoCaja=true;

	public Border resaltarcodigoTipoGrupoFlujoCaja=null;
	public Boolean mostrarcodigoTipoGrupoFlujoCaja=true;
	public Boolean activarcodigoTipoGrupoFlujoCaja=true;

	public Border resaltarnombreTipoGrupoFlujoCaja=null;
	public Boolean mostrarnombreTipoGrupoFlujoCaja=true;
	public Boolean activarnombreTipoGrupoFlujoCaja=true;

	
	

	public Border setResaltaridTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridTipoGrupoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGrupoFlujoCaja() {
		return this.resaltaridTipoGrupoFlujoCaja;
	}

	public void setResaltaridTipoGrupoFlujoCaja(Border borderResaltar) {
		this.resaltaridTipoGrupoFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridTipoGrupoFlujoCaja() {
		return this.mostraridTipoGrupoFlujoCaja;
	}

	public void setMostraridTipoGrupoFlujoCaja(Boolean mostraridTipoGrupoFlujoCaja) {
		this.mostraridTipoGrupoFlujoCaja= mostraridTipoGrupoFlujoCaja;
	}

	public Boolean getActivaridTipoGrupoFlujoCaja() {
		return this.activaridTipoGrupoFlujoCaja;
	}

	public void setActivaridTipoGrupoFlujoCaja(Boolean activaridTipoGrupoFlujoCaja) {
		this.activaridTipoGrupoFlujoCaja= activaridTipoGrupoFlujoCaja;
	}

	public Border setResaltarcodigoTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGrupoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGrupoFlujoCaja() {
		return this.resaltarcodigoTipoGrupoFlujoCaja;
	}

	public void setResaltarcodigoTipoGrupoFlujoCaja(Border borderResaltar) {
		this.resaltarcodigoTipoGrupoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGrupoFlujoCaja() {
		return this.mostrarcodigoTipoGrupoFlujoCaja;
	}

	public void setMostrarcodigoTipoGrupoFlujoCaja(Boolean mostrarcodigoTipoGrupoFlujoCaja) {
		this.mostrarcodigoTipoGrupoFlujoCaja= mostrarcodigoTipoGrupoFlujoCaja;
	}

	public Boolean getActivarcodigoTipoGrupoFlujoCaja() {
		return this.activarcodigoTipoGrupoFlujoCaja;
	}

	public void setActivarcodigoTipoGrupoFlujoCaja(Boolean activarcodigoTipoGrupoFlujoCaja) {
		this.activarcodigoTipoGrupoFlujoCaja= activarcodigoTipoGrupoFlujoCaja;
	}

	public Border setResaltarnombreTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGrupoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGrupoFlujoCaja() {
		return this.resaltarnombreTipoGrupoFlujoCaja;
	}

	public void setResaltarnombreTipoGrupoFlujoCaja(Border borderResaltar) {
		this.resaltarnombreTipoGrupoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGrupoFlujoCaja() {
		return this.mostrarnombreTipoGrupoFlujoCaja;
	}

	public void setMostrarnombreTipoGrupoFlujoCaja(Boolean mostrarnombreTipoGrupoFlujoCaja) {
		this.mostrarnombreTipoGrupoFlujoCaja= mostrarnombreTipoGrupoFlujoCaja;
	}

	public Boolean getActivarnombreTipoGrupoFlujoCaja() {
		return this.activarnombreTipoGrupoFlujoCaja;
	}

	public void setActivarnombreTipoGrupoFlujoCaja(Boolean activarnombreTipoGrupoFlujoCaja) {
		this.activarnombreTipoGrupoFlujoCaja= activarnombreTipoGrupoFlujoCaja;
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
		
		
		this.setMostraridTipoGrupoFlujoCaja(esInicial);
		this.setMostrarcodigoTipoGrupoFlujoCaja(esInicial);
		this.setMostrarnombreTipoGrupoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGrupoFlujoCaja(esAsigna);
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
		
		
		this.setActivaridTipoGrupoFlujoCaja(esInicial);
		this.setActivarcodigoTipoGrupoFlujoCaja(esInicial);
		this.setActivarnombreTipoGrupoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGrupoFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGrupoFlujoCaja(esInicial);
		this.setResaltarcodigoTipoGrupoFlujoCaja(esInicial);
		this.setResaltarnombreTipoGrupoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGrupoFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarLineaFlujoCajaTipoGrupoFlujoCaja=null;

	public Border getResaltarLineaFlujoCajaTipoGrupoFlujoCaja() {
		return this.resaltarLineaFlujoCajaTipoGrupoFlujoCaja;
	}

	public void setResaltarLineaFlujoCajaTipoGrupoFlujoCaja(Border borderResaltarLineaFlujoCaja) {
		if(borderResaltarLineaFlujoCaja!=null) {
			this.resaltarLineaFlujoCajaTipoGrupoFlujoCaja= borderResaltarLineaFlujoCaja;
		}
	}

	public Border setResaltarLineaFlujoCajaTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltarLineaFlujoCaja=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltarLineaFlujoCaja);
			
		this.resaltarLineaFlujoCajaTipoGrupoFlujoCaja= borderResaltarLineaFlujoCaja;

		 return borderResaltarLineaFlujoCaja;
	}



	public Boolean mostrarLineaFlujoCajaTipoGrupoFlujoCaja=true;

	public Boolean getMostrarLineaFlujoCajaTipoGrupoFlujoCaja() {
		return this.mostrarLineaFlujoCajaTipoGrupoFlujoCaja;
	}

	public void setMostrarLineaFlujoCajaTipoGrupoFlujoCaja(Boolean visibilidadResaltarLineaFlujoCaja) {
		this.mostrarLineaFlujoCajaTipoGrupoFlujoCaja= visibilidadResaltarLineaFlujoCaja;
	}



	public Boolean activarLineaFlujoCajaTipoGrupoFlujoCaja=true;

	public Boolean gethabilitarResaltarLineaFlujoCajaTipoGrupoFlujoCaja() {
		return this.activarLineaFlujoCajaTipoGrupoFlujoCaja;
	}

	public void setActivarLineaFlujoCajaTipoGrupoFlujoCaja(Boolean habilitarResaltarLineaFlujoCaja) {
		this.activarLineaFlujoCajaTipoGrupoFlujoCaja= habilitarResaltarLineaFlujoCaja;
	}


	public Border resaltarCentroActividadTipoGrupoFlujoCaja=null;

	public Border getResaltarCentroActividadTipoGrupoFlujoCaja() {
		return this.resaltarCentroActividadTipoGrupoFlujoCaja;
	}

	public void setResaltarCentroActividadTipoGrupoFlujoCaja(Border borderResaltarCentroActividad) {
		if(borderResaltarCentroActividad!=null) {
			this.resaltarCentroActividadTipoGrupoFlujoCaja= borderResaltarCentroActividad;
		}
	}

	public Border setResaltarCentroActividadTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltarCentroActividad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipogrupoflujocajaBeanSwingJInternalFrame.jTtoolBarTipoGrupoFlujoCaja.setBorder(borderResaltarCentroActividad);
			
		this.resaltarCentroActividadTipoGrupoFlujoCaja= borderResaltarCentroActividad;

		 return borderResaltarCentroActividad;
	}



	public Boolean mostrarCentroActividadTipoGrupoFlujoCaja=true;

	public Boolean getMostrarCentroActividadTipoGrupoFlujoCaja() {
		return this.mostrarCentroActividadTipoGrupoFlujoCaja;
	}

	public void setMostrarCentroActividadTipoGrupoFlujoCaja(Boolean visibilidadResaltarCentroActividad) {
		this.mostrarCentroActividadTipoGrupoFlujoCaja= visibilidadResaltarCentroActividad;
	}



	public Boolean activarCentroActividadTipoGrupoFlujoCaja=true;

	public Boolean gethabilitarResaltarCentroActividadTipoGrupoFlujoCaja() {
		return this.activarCentroActividadTipoGrupoFlujoCaja;
	}

	public void setActivarCentroActividadTipoGrupoFlujoCaja(Boolean habilitarResaltarCentroActividad) {
		this.activarCentroActividadTipoGrupoFlujoCaja= habilitarResaltarCentroActividad;
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

		this.setMostrarLineaFlujoCajaTipoGrupoFlujoCaja(esInicial);
		this.setMostrarCentroActividadTipoGrupoFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setMostrarLineaFlujoCajaTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroActividad.class)) {
				this.setMostrarCentroActividadTipoGrupoFlujoCaja(esAsigna);
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

		this.setActivarLineaFlujoCajaTipoGrupoFlujoCaja(esInicial);
		this.setActivarCentroActividadTipoGrupoFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setActivarLineaFlujoCajaTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroActividad.class)) {
				this.setActivarCentroActividadTipoGrupoFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarLineaFlujoCajaTipoGrupoFlujoCaja(esInicial);
		this.setResaltarCentroActividadTipoGrupoFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(LineaFlujoCaja.class)) {
				this.setResaltarLineaFlujoCajaTipoGrupoFlujoCaja(esAsigna);
				continue;
			}

			if(clase.clas.equals(CentroActividad.class)) {
				this.setResaltarCentroActividadTipoGrupoFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoGrupoFlujoCaja=true;

	public Boolean getMostrarBusquedaPorCodigoTipoGrupoFlujoCaja() {
		return this.mostrarBusquedaPorCodigoTipoGrupoFlujoCaja;
	}

	public void setMostrarBusquedaPorCodigoTipoGrupoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoGrupoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoGrupoFlujoCaja=true;

	public Boolean getMostrarBusquedaPorNombreTipoGrupoFlujoCaja() {
		return this.mostrarBusquedaPorNombreTipoGrupoFlujoCaja;
	}

	public void setMostrarBusquedaPorNombreTipoGrupoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoGrupoFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoGrupoFlujoCaja=true;

	public Boolean getActivarBusquedaPorCodigoTipoGrupoFlujoCaja() {
		return this.activarBusquedaPorCodigoTipoGrupoFlujoCaja;
	}

	public void setActivarBusquedaPorCodigoTipoGrupoFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoGrupoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoGrupoFlujoCaja=true;

	public Boolean getActivarBusquedaPorNombreTipoGrupoFlujoCaja() {
		return this.activarBusquedaPorNombreTipoGrupoFlujoCaja;
	}

	public void setActivarBusquedaPorNombreTipoGrupoFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoGrupoFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoGrupoFlujoCaja=null;

	public Border getResaltarBusquedaPorCodigoTipoGrupoFlujoCaja() {
		return this.resaltarBusquedaPorCodigoTipoGrupoFlujoCaja;
	}

	public void setResaltarBusquedaPorCodigoTipoGrupoFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoGrupoFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoGrupoFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoGrupoFlujoCaja=null;

	public Border getResaltarBusquedaPorNombreTipoGrupoFlujoCaja() {
		return this.resaltarBusquedaPorNombreTipoGrupoFlujoCaja;
	}

	public void setResaltarBusquedaPorNombreTipoGrupoFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoGrupoFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoGrupoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoFlujoCajaBeanSwingJInternalFrame tipogrupoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoGrupoFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
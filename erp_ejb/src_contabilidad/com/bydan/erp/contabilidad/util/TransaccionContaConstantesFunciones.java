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


import com.bydan.erp.contabilidad.util.TransaccionContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TransaccionContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TransaccionContaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransaccionContaConstantesFunciones extends TransaccionContaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TransaccionConta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionConta"+TransaccionContaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionContaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionContaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionContaConstantesFunciones.SCHEMA+"_"+TransaccionContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionContaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionContaConstantesFunciones.SCHEMA+"_"+TransaccionContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionContaConstantesFunciones.SCHEMA+"_"+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionContaConstantesFunciones.SCHEMA+"_"+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionContaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionContaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionContaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionContaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionContaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transaccion Contablilidads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Transaccion Contablilidad";
	public static final String SCLASSWEBTITULO_LOWER="Transaccion Conta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionConta";
	public static final String OBJECTNAME="transaccionconta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="transaccion_conta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccionconta from "+TransaccionContaConstantesFunciones.SPERSISTENCENAME+" transaccionconta";
	public static String QUERYSELECTNATIVE="select "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".id,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".version_row,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".codigo,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".nombre from "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME;//+" as "+TransaccionContaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransaccionContaConstantesFuncionesAdditional transaccioncontaConstantesFuncionesAdditional=null;
	
	public TransaccionContaConstantesFuncionesAdditional getTransaccionContaConstantesFuncionesAdditional() {
		return this.transaccioncontaConstantesFuncionesAdditional;
	}
	
	public void setTransaccionContaConstantesFuncionesAdditional(TransaccionContaConstantesFuncionesAdditional transaccioncontaConstantesFuncionesAdditional) {
		try {
			this.transaccioncontaConstantesFuncionesAdditional=transaccioncontaConstantesFuncionesAdditional;
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
	
	public static String getTransaccionContaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionContaConstantesFunciones.CODIGO)) {sLabelColumna=TransaccionContaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TransaccionContaConstantesFunciones.NOMBRE)) {sLabelColumna=TransaccionContaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTransaccionContaDescripcion(TransaccionConta transaccionconta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccionconta !=null/* && transaccionconta.getId()!=0*/) {
			sDescripcion=transaccionconta.getcodigo();//transaccioncontatransaccionconta.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionContaDescripcionDetallado(TransaccionConta transaccionconta) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionContaConstantesFunciones.ID+"=";
		sDescripcion+=transaccionconta.getId().toString()+",";
		sDescripcion+=TransaccionContaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccionconta.getVersionRow().toString()+",";
		sDescripcion+=TransaccionContaConstantesFunciones.CODIGO+"=";
		sDescripcion+=transaccionconta.getcodigo()+",";
		sDescripcion+=TransaccionContaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=transaccionconta.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionContaDescripcion(TransaccionConta transaccionconta,String sValor) throws Exception {			
		if(transaccionconta !=null) {
			transaccionconta.setcodigo(sValor);;//transaccioncontatransaccionconta.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
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

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionConta(TransaccionConta transaccionconta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccionconta.setcodigo(transaccionconta.getcodigo().trim());
		transaccionconta.setnombre(transaccionconta.getnombre().trim());
	}
	
	public static void quitarEspaciosTransaccionContas(List<TransaccionConta> transaccioncontas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionConta transaccionconta: transaccioncontas) {
			transaccionconta.setcodigo(transaccionconta.getcodigo().trim());
			transaccionconta.setnombre(transaccionconta.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionConta(TransaccionConta transaccionconta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccionconta.getConCambioAuxiliar()) {
			transaccionconta.setIsDeleted(transaccionconta.getIsDeletedAuxiliar());	
			transaccionconta.setIsNew(transaccionconta.getIsNewAuxiliar());	
			transaccionconta.setIsChanged(transaccionconta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccionconta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccionconta.setIsDeletedAuxiliar(false);	
			transaccionconta.setIsNewAuxiliar(false);	
			transaccionconta.setIsChangedAuxiliar(false);
			
			transaccionconta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionContas(List<TransaccionConta> transaccioncontas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionConta transaccionconta : transaccioncontas) {
			if(conAsignarBase && transaccionconta.getConCambioAuxiliar()) {
				transaccionconta.setIsDeleted(transaccionconta.getIsDeletedAuxiliar());	
				transaccionconta.setIsNew(transaccionconta.getIsNewAuxiliar());	
				transaccionconta.setIsChanged(transaccionconta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccionconta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccionconta.setIsDeletedAuxiliar(false);	
				transaccionconta.setIsNewAuxiliar(false);	
				transaccionconta.setIsChangedAuxiliar(false);
				
				transaccionconta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionConta(TransaccionConta transaccionconta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionContas(List<TransaccionConta> transaccioncontas,Boolean conEnteros) throws Exception  {
		
		for(TransaccionConta transaccionconta: transaccioncontas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionConta(List<TransaccionConta> transaccioncontas,TransaccionConta transaccioncontaAux) throws Exception  {
		TransaccionContaConstantesFunciones.InicializarValoresTransaccionConta(transaccioncontaAux,true);
		
		for(TransaccionConta transaccionconta: transaccioncontas) {
			if(transaccionconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionContaConstantesFunciones.getArrayColumnasGlobalesTransaccionConta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionConta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionConta> transaccioncontas,TransaccionConta transaccionconta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionConta transaccioncontaAux: transaccioncontas) {
			if(transaccioncontaAux!=null && transaccionconta!=null) {
				if((transaccioncontaAux.getId()==null && transaccionconta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccioncontaAux.getId()!=null && transaccionconta.getId()!=null){
					if(transaccioncontaAux.getId().equals(transaccionconta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionConta(List<TransaccionConta> transaccioncontas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TransaccionConta transaccionconta: transaccioncontas) {			
			if(transaccionconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionConta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionContaConstantesFunciones.LABEL_ID, TransaccionContaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionContaConstantesFunciones.LABEL_VERSIONROW, TransaccionContaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionContaConstantesFunciones.LABEL_CODIGO, TransaccionContaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionContaConstantesFunciones.LABEL_NOMBRE, TransaccionContaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionConta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionContaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionContaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionContaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionContaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionConta() throws Exception  {
		return TransaccionContaConstantesFunciones.getTiposSeleccionarTransaccionConta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionConta(Boolean conFk) throws Exception  {
		return TransaccionContaConstantesFunciones.getTiposSeleccionarTransaccionConta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionConta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionContaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TransaccionContaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionContaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TransaccionContaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionConta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionConta(TransaccionConta transaccioncontaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionConta(List<TransaccionConta> transaccioncontasTemp) throws Exception {
		for(TransaccionConta transaccioncontaAux:transaccioncontasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionContaConstantesFunciones.getClassesRelationshipsOfTransaccionConta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(TransaccionLocal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionContaConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionConta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
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
	public static void actualizarLista(TransaccionConta transaccionconta,List<TransaccionConta> transaccioncontas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TransaccionConta transaccioncontaEncontrado=null;
			
			for(TransaccionConta transaccioncontaLocal:transaccioncontas) {
				if(transaccioncontaLocal.getId().equals(transaccionconta.getId())) {
					transaccioncontaEncontrado=transaccioncontaLocal;
					
					transaccioncontaLocal.setIsChanged(transaccionconta.getIsChanged());
					transaccioncontaLocal.setIsNew(transaccionconta.getIsNew());
					transaccioncontaLocal.setIsDeleted(transaccionconta.getIsDeleted());
					
					transaccioncontaLocal.setGeneralEntityOriginal(transaccionconta.getGeneralEntityOriginal());
					
					transaccioncontaLocal.setId(transaccionconta.getId());	
					transaccioncontaLocal.setVersionRow(transaccionconta.getVersionRow());	
					transaccioncontaLocal.setcodigo(transaccionconta.getcodigo());	
					transaccioncontaLocal.setnombre(transaccionconta.getnombre());	
					
					
					transaccioncontaLocal.setTransaccionLocals(transaccionconta.getTransaccionLocals());
					
					existe=true;
					break;
				}
			}
			
			if(!transaccionconta.getIsDeleted()) {
				if(!existe) {
					transaccioncontas.add(transaccionconta);
				}
			} else {
				if(transaccioncontaEncontrado!=null && permiteQuitar)  {
					transaccioncontas.remove(transaccioncontaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TransaccionConta transaccionconta,List<TransaccionConta> transaccioncontas) throws Exception {
		try	{			
			for(TransaccionConta transaccioncontaLocal:transaccioncontas) {
				if(transaccioncontaLocal.getId().equals(transaccionconta.getId())) {
					transaccioncontaLocal.setIsSelected(transaccionconta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionConta(List<TransaccionConta> transaccioncontasAux) throws Exception {
		//this.transaccioncontasAux=transaccioncontasAux;
		
		for(TransaccionConta transaccioncontaAux:transaccioncontasAux) {
			if(transaccioncontaAux.getIsChanged()) {
				transaccioncontaAux.setIsChanged(false);
			}		
			
			if(transaccioncontaAux.getIsNew()) {
				transaccioncontaAux.setIsNew(false);
			}	
			
			if(transaccioncontaAux.getIsDeleted()) {
				transaccioncontaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionConta(TransaccionConta transaccioncontaAux) throws Exception {
		//this.transaccioncontaAux=transaccioncontaAux;
		
			if(transaccioncontaAux.getIsChanged()) {
				transaccioncontaAux.setIsChanged(false);
			}		
			
			if(transaccioncontaAux.getIsNew()) {
				transaccioncontaAux.setIsNew(false);
			}	
			
			if(transaccioncontaAux.getIsDeleted()) {
				transaccioncontaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionConta transaccioncontaAsignar,TransaccionConta transaccionconta) throws Exception {
		transaccioncontaAsignar.setId(transaccionconta.getId());	
		transaccioncontaAsignar.setVersionRow(transaccionconta.getVersionRow());	
		transaccioncontaAsignar.setcodigo(transaccionconta.getcodigo());	
		transaccioncontaAsignar.setnombre(transaccionconta.getnombre());	
	}
	
	public static void inicializarTransaccionConta(TransaccionConta transaccionconta) throws Exception {
		try {
				transaccionconta.setId(0L);	
					
				transaccionconta.setcodigo("");	
				transaccionconta.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionConta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionContaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionContaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionConta(String sTipo,Row row,Workbook workbook,TransaccionConta transaccionconta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionconta.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccionconta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionConta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransaccionConta() {
		return this.sFinalQueryTransaccionConta;
	}
	
	public void setsFinalQueryTransaccionConta(String sFinalQueryTransaccionConta) {
		this.sFinalQueryTransaccionConta= sFinalQueryTransaccionConta;
	}
	
	public Border resaltarSeleccionarTransaccionConta=null;
	
	public Border setResaltarSeleccionarTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccioncontaBeanSwingJInternalFrame.jTtoolBarTransaccionConta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionConta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionConta() {
		return this.resaltarSeleccionarTransaccionConta;
	}
	
	public void setResaltarSeleccionarTransaccionConta(Border borderResaltarSeleccionarTransaccionConta) {
		this.resaltarSeleccionarTransaccionConta= borderResaltarSeleccionarTransaccionConta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionConta=null;
	public Boolean mostraridTransaccionConta=true;
	public Boolean activaridTransaccionConta=true;

	public Border resaltarcodigoTransaccionConta=null;
	public Boolean mostrarcodigoTransaccionConta=true;
	public Boolean activarcodigoTransaccionConta=true;

	public Border resaltarnombreTransaccionConta=null;
	public Boolean mostrarnombreTransaccionConta=true;
	public Boolean activarnombreTransaccionConta=true;

	
	

	public Border setResaltaridTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioncontaBeanSwingJInternalFrame.jTtoolBarTransaccionConta.setBorder(borderResaltar);
		
		this.resaltaridTransaccionConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionConta() {
		return this.resaltaridTransaccionConta;
	}

	public void setResaltaridTransaccionConta(Border borderResaltar) {
		this.resaltaridTransaccionConta= borderResaltar;
	}

	public Boolean getMostraridTransaccionConta() {
		return this.mostraridTransaccionConta;
	}

	public void setMostraridTransaccionConta(Boolean mostraridTransaccionConta) {
		this.mostraridTransaccionConta= mostraridTransaccionConta;
	}

	public Boolean getActivaridTransaccionConta() {
		return this.activaridTransaccionConta;
	}

	public void setActivaridTransaccionConta(Boolean activaridTransaccionConta) {
		this.activaridTransaccionConta= activaridTransaccionConta;
	}

	public Border setResaltarcodigoTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioncontaBeanSwingJInternalFrame.jTtoolBarTransaccionConta.setBorder(borderResaltar);
		
		this.resaltarcodigoTransaccionConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTransaccionConta() {
		return this.resaltarcodigoTransaccionConta;
	}

	public void setResaltarcodigoTransaccionConta(Border borderResaltar) {
		this.resaltarcodigoTransaccionConta= borderResaltar;
	}

	public Boolean getMostrarcodigoTransaccionConta() {
		return this.mostrarcodigoTransaccionConta;
	}

	public void setMostrarcodigoTransaccionConta(Boolean mostrarcodigoTransaccionConta) {
		this.mostrarcodigoTransaccionConta= mostrarcodigoTransaccionConta;
	}

	public Boolean getActivarcodigoTransaccionConta() {
		return this.activarcodigoTransaccionConta;
	}

	public void setActivarcodigoTransaccionConta(Boolean activarcodigoTransaccionConta) {
		this.activarcodigoTransaccionConta= activarcodigoTransaccionConta;
	}

	public Border setResaltarnombreTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioncontaBeanSwingJInternalFrame.jTtoolBarTransaccionConta.setBorder(borderResaltar);
		
		this.resaltarnombreTransaccionConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTransaccionConta() {
		return this.resaltarnombreTransaccionConta;
	}

	public void setResaltarnombreTransaccionConta(Border borderResaltar) {
		this.resaltarnombreTransaccionConta= borderResaltar;
	}

	public Boolean getMostrarnombreTransaccionConta() {
		return this.mostrarnombreTransaccionConta;
	}

	public void setMostrarnombreTransaccionConta(Boolean mostrarnombreTransaccionConta) {
		this.mostrarnombreTransaccionConta= mostrarnombreTransaccionConta;
	}

	public Boolean getActivarnombreTransaccionConta() {
		return this.activarnombreTransaccionConta;
	}

	public void setActivarnombreTransaccionConta(Boolean activarnombreTransaccionConta) {
		this.activarnombreTransaccionConta= activarnombreTransaccionConta;
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
		
		
		this.setMostraridTransaccionConta(esInicial);
		this.setMostrarcodigoTransaccionConta(esInicial);
		this.setMostrarnombreTransaccionConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionContaConstantesFunciones.ID)) {
				this.setMostraridTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTransaccionConta(esAsigna);
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
		
		
		this.setActivaridTransaccionConta(esInicial);
		this.setActivarcodigoTransaccionConta(esInicial);
		this.setActivarnombreTransaccionConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionContaConstantesFunciones.ID)) {
				this.setActivaridTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTransaccionConta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionConta(esInicial);
		this.setResaltarcodigoTransaccionConta(esInicial);
		this.setResaltarnombreTransaccionConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionContaConstantesFunciones.ID)) {
				this.setResaltaridTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTransaccionConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionContaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTransaccionConta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalTransaccionConta=null;

	public Border getResaltarTransaccionLocalTransaccionConta() {
		return this.resaltarTransaccionLocalTransaccionConta;
	}

	public void setResaltarTransaccionLocalTransaccionConta(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalTransaccionConta= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//transaccioncontaBeanSwingJInternalFrame.jTtoolBarTransaccionConta.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalTransaccionConta= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalTransaccionConta=true;

	public Boolean getMostrarTransaccionLocalTransaccionConta() {
		return this.mostrarTransaccionLocalTransaccionConta;
	}

	public void setMostrarTransaccionLocalTransaccionConta(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalTransaccionConta= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalTransaccionConta=true;

	public Boolean gethabilitarResaltarTransaccionLocalTransaccionConta() {
		return this.activarTransaccionLocalTransaccionConta;
	}

	public void setActivarTransaccionLocalTransaccionConta(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalTransaccionConta= habilitarResaltarTransaccionLocal;
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

		this.setMostrarTransaccionLocalTransaccionConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalTransaccionConta(esAsigna);
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

		this.setActivarTransaccionLocalTransaccionConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalTransaccionConta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalTransaccionConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalTransaccionConta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTransaccionConta=true;

	public Boolean getMostrarBusquedaPorCodigoTransaccionConta() {
		return this.mostrarBusquedaPorCodigoTransaccionConta;
	}

	public void setMostrarBusquedaPorCodigoTransaccionConta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTransaccionConta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTransaccionConta=true;

	public Boolean getMostrarBusquedaPorIdTransaccionConta() {
		return this.mostrarBusquedaPorIdTransaccionConta;
	}

	public void setMostrarBusquedaPorIdTransaccionConta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTransaccionConta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTransaccionConta=true;

	public Boolean getMostrarBusquedaPorNombreTransaccionConta() {
		return this.mostrarBusquedaPorNombreTransaccionConta;
	}

	public void setMostrarBusquedaPorNombreTransaccionConta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTransaccionConta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTransaccionConta=true;

	public Boolean getActivarBusquedaPorCodigoTransaccionConta() {
		return this.activarBusquedaPorCodigoTransaccionConta;
	}

	public void setActivarBusquedaPorCodigoTransaccionConta(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTransaccionConta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTransaccionConta=true;

	public Boolean getActivarBusquedaPorIdTransaccionConta() {
		return this.activarBusquedaPorIdTransaccionConta;
	}

	public void setActivarBusquedaPorIdTransaccionConta(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTransaccionConta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTransaccionConta=true;

	public Boolean getActivarBusquedaPorNombreTransaccionConta() {
		return this.activarBusquedaPorNombreTransaccionConta;
	}

	public void setActivarBusquedaPorNombreTransaccionConta(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTransaccionConta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTransaccionConta=null;

	public Border getResaltarBusquedaPorCodigoTransaccionConta() {
		return this.resaltarBusquedaPorCodigoTransaccionConta;
	}

	public void setResaltarBusquedaPorCodigoTransaccionConta(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTransaccionConta= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTransaccionConta= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTransaccionConta=null;

	public Border getResaltarBusquedaPorIdTransaccionConta() {
		return this.resaltarBusquedaPorIdTransaccionConta;
	}

	public void setResaltarBusquedaPorIdTransaccionConta(Border borderResaltar) {
		this.resaltarBusquedaPorIdTransaccionConta= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTransaccionConta= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTransaccionConta=null;

	public Border getResaltarBusquedaPorNombreTransaccionConta() {
		return this.resaltarBusquedaPorNombreTransaccionConta;
	}

	public void setResaltarBusquedaPorNombreTransaccionConta(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTransaccionConta= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTransaccionConta(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionContaBeanSwingJInternalFrame transaccioncontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTransaccionConta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
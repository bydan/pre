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


import com.bydan.erp.contabilidad.util.TipoAutoPagoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoAutoPagoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoAutoPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoAutoPagoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAutoPago";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAutoPago"+TipoAutoPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAutoPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAutoPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAutoPagoConstantesFunciones.SCHEMA+"_"+TipoAutoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAutoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAutoPagoConstantesFunciones.SCHEMA+"_"+TipoAutoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAutoPagoConstantesFunciones.SCHEMA+"_"+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAutoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAutoPagoConstantesFunciones.SCHEMA+"_"+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAutoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAutoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAutoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAutoPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAutoPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAutoPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAutoPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Auto Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Auto Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Auto Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAutoPago";
	public static final String OBJECTNAME="tipoautopago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_auto_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoautopago from "+TipoAutoPagoConstantesFunciones.SPERSISTENCENAME+" tipoautopago";
	public static String QUERYSELECTNATIVE="select "+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME+".id,"+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME+".version_row,"+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME+".codigo,"+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME+".nombre from "+TipoAutoPagoConstantesFunciones.SCHEMA+"."+TipoAutoPagoConstantesFunciones.TABLENAME;//+" as "+TipoAutoPagoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoAutoPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAutoPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoAutoPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoAutoPagoConstantesFunciones.CODIGO)) {sLabelColumna=TipoAutoPagoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoAutoPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAutoPagoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoAutoPagoDescripcion(TipoAutoPago tipoautopago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoautopago !=null/* && tipoautopago.getId()!=0*/) {
			sDescripcion=tipoautopago.getcodigo();//tipoautopagotipoautopago.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAutoPagoDescripcionDetallado(TipoAutoPago tipoautopago) {
		String sDescripcion="";
			
		sDescripcion+=TipoAutoPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipoautopago.getId().toString()+",";
		sDescripcion+=TipoAutoPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoautopago.getVersionRow().toString()+",";
		sDescripcion+=TipoAutoPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoautopago.getid_empresa().toString()+",";
		sDescripcion+=TipoAutoPagoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoautopago.getcodigo()+",";
		sDescripcion+=TipoAutoPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoautopago.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAutoPagoDescripcion(TipoAutoPago tipoautopago,String sValor) throws Exception {			
		if(tipoautopago !=null) {
			tipoautopago.setcodigo(sValor);;//tipoautopagotipoautopago.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoAutoPago(TipoAutoPago tipoautopago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoautopago.setcodigo(tipoautopago.getcodigo().trim());
		tipoautopago.setnombre(tipoautopago.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoAutoPagos(List<TipoAutoPago> tipoautopagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAutoPago tipoautopago: tipoautopagos) {
			tipoautopago.setcodigo(tipoautopago.getcodigo().trim());
			tipoautopago.setnombre(tipoautopago.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAutoPago(TipoAutoPago tipoautopago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoautopago.getConCambioAuxiliar()) {
			tipoautopago.setIsDeleted(tipoautopago.getIsDeletedAuxiliar());	
			tipoautopago.setIsNew(tipoautopago.getIsNewAuxiliar());	
			tipoautopago.setIsChanged(tipoautopago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoautopago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoautopago.setIsDeletedAuxiliar(false);	
			tipoautopago.setIsNewAuxiliar(false);	
			tipoautopago.setIsChangedAuxiliar(false);
			
			tipoautopago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAutoPagos(List<TipoAutoPago> tipoautopagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAutoPago tipoautopago : tipoautopagos) {
			if(conAsignarBase && tipoautopago.getConCambioAuxiliar()) {
				tipoautopago.setIsDeleted(tipoautopago.getIsDeletedAuxiliar());	
				tipoautopago.setIsNew(tipoautopago.getIsNewAuxiliar());	
				tipoautopago.setIsChanged(tipoautopago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoautopago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoautopago.setIsDeletedAuxiliar(false);	
				tipoautopago.setIsNewAuxiliar(false);	
				tipoautopago.setIsChangedAuxiliar(false);
				
				tipoautopago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAutoPago(TipoAutoPago tipoautopago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAutoPagos(List<TipoAutoPago> tipoautopagos,Boolean conEnteros) throws Exception  {
		
		for(TipoAutoPago tipoautopago: tipoautopagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAutoPago(List<TipoAutoPago> tipoautopagos,TipoAutoPago tipoautopagoAux) throws Exception  {
		TipoAutoPagoConstantesFunciones.InicializarValoresTipoAutoPago(tipoautopagoAux,true);
		
		for(TipoAutoPago tipoautopago: tipoautopagos) {
			if(tipoautopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAutoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAutoPagoConstantesFunciones.getArrayColumnasGlobalesTipoAutoPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAutoPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoAutoPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoAutoPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAutoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAutoPago> tipoautopagos,TipoAutoPago tipoautopago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAutoPago tipoautopagoAux: tipoautopagos) {
			if(tipoautopagoAux!=null && tipoautopago!=null) {
				if((tipoautopagoAux.getId()==null && tipoautopago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoautopagoAux.getId()!=null && tipoautopago.getId()!=null){
					if(tipoautopagoAux.getId().equals(tipoautopago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAutoPago(List<TipoAutoPago> tipoautopagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoAutoPago tipoautopago: tipoautopagos) {			
			if(tipoautopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAutoPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAutoPagoConstantesFunciones.LABEL_ID, TipoAutoPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoPagoConstantesFunciones.LABEL_VERSIONROW, TipoAutoPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoPagoConstantesFunciones.LABEL_IDEMPRESA, TipoAutoPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoPagoConstantesFunciones.LABEL_CODIGO, TipoAutoPagoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAutoPagoConstantesFunciones.LABEL_NOMBRE, TipoAutoPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAutoPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAutoPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoPagoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAutoPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoPago() throws Exception  {
		return TipoAutoPagoConstantesFunciones.getTiposSeleccionarTipoAutoPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoPago(Boolean conFk) throws Exception  {
		return TipoAutoPagoConstantesFunciones.getTiposSeleccionarTipoAutoPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAutoPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAutoPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoAutoPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAutoPagoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoAutoPagoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAutoPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAutoPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAutoPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAutoPago(TipoAutoPago tipoautopagoAux) throws Exception {
		
			tipoautopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoautopagoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAutoPago(List<TipoAutoPago> tipoautopagosTemp) throws Exception {
		for(TipoAutoPago tipoautopagoAux:tipoautopagosTemp) {
			
			tipoautopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoautopagoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAutoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAutoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAutoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAutoPagoConstantesFunciones.getClassesRelationshipsOfTipoAutoPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAutoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroCartera.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCartera.class)) {
						classes.add(new Classe(ParametroCartera.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAutoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAutoPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAutoPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAutoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCartera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCartera.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCartera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCartera.class)); continue;
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
	public static void actualizarLista(TipoAutoPago tipoautopago,List<TipoAutoPago> tipoautopagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAutoPago tipoautopagoEncontrado=null;
			
			for(TipoAutoPago tipoautopagoLocal:tipoautopagos) {
				if(tipoautopagoLocal.getId().equals(tipoautopago.getId())) {
					tipoautopagoEncontrado=tipoautopagoLocal;
					
					tipoautopagoLocal.setIsChanged(tipoautopago.getIsChanged());
					tipoautopagoLocal.setIsNew(tipoautopago.getIsNew());
					tipoautopagoLocal.setIsDeleted(tipoautopago.getIsDeleted());
					
					tipoautopagoLocal.setGeneralEntityOriginal(tipoautopago.getGeneralEntityOriginal());
					
					tipoautopagoLocal.setId(tipoautopago.getId());	
					tipoautopagoLocal.setVersionRow(tipoautopago.getVersionRow());	
					tipoautopagoLocal.setid_empresa(tipoautopago.getid_empresa());	
					tipoautopagoLocal.setcodigo(tipoautopago.getcodigo());	
					tipoautopagoLocal.setnombre(tipoautopago.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoautopago.getIsDeleted()) {
				if(!existe) {
					tipoautopagos.add(tipoautopago);
				}
			} else {
				if(tipoautopagoEncontrado!=null && permiteQuitar)  {
					tipoautopagos.remove(tipoautopagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAutoPago tipoautopago,List<TipoAutoPago> tipoautopagos) throws Exception {
		try	{			
			for(TipoAutoPago tipoautopagoLocal:tipoautopagos) {
				if(tipoautopagoLocal.getId().equals(tipoautopago.getId())) {
					tipoautopagoLocal.setIsSelected(tipoautopago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAutoPago(List<TipoAutoPago> tipoautopagosAux) throws Exception {
		//this.tipoautopagosAux=tipoautopagosAux;
		
		for(TipoAutoPago tipoautopagoAux:tipoautopagosAux) {
			if(tipoautopagoAux.getIsChanged()) {
				tipoautopagoAux.setIsChanged(false);
			}		
			
			if(tipoautopagoAux.getIsNew()) {
				tipoautopagoAux.setIsNew(false);
			}	
			
			if(tipoautopagoAux.getIsDeleted()) {
				tipoautopagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAutoPago(TipoAutoPago tipoautopagoAux) throws Exception {
		//this.tipoautopagoAux=tipoautopagoAux;
		
			if(tipoautopagoAux.getIsChanged()) {
				tipoautopagoAux.setIsChanged(false);
			}		
			
			if(tipoautopagoAux.getIsNew()) {
				tipoautopagoAux.setIsNew(false);
			}	
			
			if(tipoautopagoAux.getIsDeleted()) {
				tipoautopagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAutoPago tipoautopagoAsignar,TipoAutoPago tipoautopago) throws Exception {
		tipoautopagoAsignar.setId(tipoautopago.getId());	
		tipoautopagoAsignar.setVersionRow(tipoautopago.getVersionRow());	
		tipoautopagoAsignar.setid_empresa(tipoautopago.getid_empresa());
		tipoautopagoAsignar.setempresa_descripcion(tipoautopago.getempresa_descripcion());	
		tipoautopagoAsignar.setcodigo(tipoautopago.getcodigo());	
		tipoautopagoAsignar.setnombre(tipoautopago.getnombre());	
	}
	
	public static void inicializarTipoAutoPago(TipoAutoPago tipoautopago) throws Exception {
		try {
				tipoautopago.setId(0L);	
					
				tipoautopago.setid_empresa(-1L);	
				tipoautopago.setcodigo("");	
				tipoautopago.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAutoPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAutoPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAutoPagoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAutoPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAutoPago(String sTipo,Row row,Workbook workbook,TipoAutoPago tipoautopago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoautopago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoautopago.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoautopago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAutoPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAutoPago() {
		return this.sFinalQueryTipoAutoPago;
	}
	
	public void setsFinalQueryTipoAutoPago(String sFinalQueryTipoAutoPago) {
		this.sFinalQueryTipoAutoPago= sFinalQueryTipoAutoPago;
	}
	
	public Border resaltarSeleccionarTipoAutoPago=null;
	
	public Border setResaltarSeleccionarTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoautopagoBeanSwingJInternalFrame.jTtoolBarTipoAutoPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAutoPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAutoPago() {
		return this.resaltarSeleccionarTipoAutoPago;
	}
	
	public void setResaltarSeleccionarTipoAutoPago(Border borderResaltarSeleccionarTipoAutoPago) {
		this.resaltarSeleccionarTipoAutoPago= borderResaltarSeleccionarTipoAutoPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAutoPago=null;
	public Boolean mostraridTipoAutoPago=true;
	public Boolean activaridTipoAutoPago=true;

	public Border resaltarid_empresaTipoAutoPago=null;
	public Boolean mostrarid_empresaTipoAutoPago=true;
	public Boolean activarid_empresaTipoAutoPago=true;
	public Boolean cargarid_empresaTipoAutoPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoAutoPago=false;//ConEventDepend=true

	public Border resaltarcodigoTipoAutoPago=null;
	public Boolean mostrarcodigoTipoAutoPago=true;
	public Boolean activarcodigoTipoAutoPago=true;

	public Border resaltarnombreTipoAutoPago=null;
	public Boolean mostrarnombreTipoAutoPago=true;
	public Boolean activarnombreTipoAutoPago=true;

	
	

	public Border setResaltaridTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautopagoBeanSwingJInternalFrame.jTtoolBarTipoAutoPago.setBorder(borderResaltar);
		
		this.resaltaridTipoAutoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAutoPago() {
		return this.resaltaridTipoAutoPago;
	}

	public void setResaltaridTipoAutoPago(Border borderResaltar) {
		this.resaltaridTipoAutoPago= borderResaltar;
	}

	public Boolean getMostraridTipoAutoPago() {
		return this.mostraridTipoAutoPago;
	}

	public void setMostraridTipoAutoPago(Boolean mostraridTipoAutoPago) {
		this.mostraridTipoAutoPago= mostraridTipoAutoPago;
	}

	public Boolean getActivaridTipoAutoPago() {
		return this.activaridTipoAutoPago;
	}

	public void setActivaridTipoAutoPago(Boolean activaridTipoAutoPago) {
		this.activaridTipoAutoPago= activaridTipoAutoPago;
	}

	public Border setResaltarid_empresaTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautopagoBeanSwingJInternalFrame.jTtoolBarTipoAutoPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoAutoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoAutoPago() {
		return this.resaltarid_empresaTipoAutoPago;
	}

	public void setResaltarid_empresaTipoAutoPago(Border borderResaltar) {
		this.resaltarid_empresaTipoAutoPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoAutoPago() {
		return this.mostrarid_empresaTipoAutoPago;
	}

	public void setMostrarid_empresaTipoAutoPago(Boolean mostrarid_empresaTipoAutoPago) {
		this.mostrarid_empresaTipoAutoPago= mostrarid_empresaTipoAutoPago;
	}

	public Boolean getActivarid_empresaTipoAutoPago() {
		return this.activarid_empresaTipoAutoPago;
	}

	public void setActivarid_empresaTipoAutoPago(Boolean activarid_empresaTipoAutoPago) {
		this.activarid_empresaTipoAutoPago= activarid_empresaTipoAutoPago;
	}

	public Boolean getCargarid_empresaTipoAutoPago() {
		return this.cargarid_empresaTipoAutoPago;
	}

	public void setCargarid_empresaTipoAutoPago(Boolean cargarid_empresaTipoAutoPago) {
		this.cargarid_empresaTipoAutoPago= cargarid_empresaTipoAutoPago;
	}

	public Border setResaltarcodigoTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautopagoBeanSwingJInternalFrame.jTtoolBarTipoAutoPago.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoAutoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoAutoPago() {
		return this.resaltarcodigoTipoAutoPago;
	}

	public void setResaltarcodigoTipoAutoPago(Border borderResaltar) {
		this.resaltarcodigoTipoAutoPago= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoAutoPago() {
		return this.mostrarcodigoTipoAutoPago;
	}

	public void setMostrarcodigoTipoAutoPago(Boolean mostrarcodigoTipoAutoPago) {
		this.mostrarcodigoTipoAutoPago= mostrarcodigoTipoAutoPago;
	}

	public Boolean getActivarcodigoTipoAutoPago() {
		return this.activarcodigoTipoAutoPago;
	}

	public void setActivarcodigoTipoAutoPago(Boolean activarcodigoTipoAutoPago) {
		this.activarcodigoTipoAutoPago= activarcodigoTipoAutoPago;
	}

	public Border setResaltarnombreTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoautopagoBeanSwingJInternalFrame.jTtoolBarTipoAutoPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAutoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAutoPago() {
		return this.resaltarnombreTipoAutoPago;
	}

	public void setResaltarnombreTipoAutoPago(Border borderResaltar) {
		this.resaltarnombreTipoAutoPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAutoPago() {
		return this.mostrarnombreTipoAutoPago;
	}

	public void setMostrarnombreTipoAutoPago(Boolean mostrarnombreTipoAutoPago) {
		this.mostrarnombreTipoAutoPago= mostrarnombreTipoAutoPago;
	}

	public Boolean getActivarnombreTipoAutoPago() {
		return this.activarnombreTipoAutoPago;
	}

	public void setActivarnombreTipoAutoPago(Boolean activarnombreTipoAutoPago) {
		this.activarnombreTipoAutoPago= activarnombreTipoAutoPago;
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
		
		
		this.setMostraridTipoAutoPago(esInicial);
		this.setMostrarid_empresaTipoAutoPago(esInicial);
		this.setMostrarcodigoTipoAutoPago(esInicial);
		this.setMostrarnombreTipoAutoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.ID)) {
				this.setMostraridTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAutoPago(esAsigna);
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
		
		
		this.setActivaridTipoAutoPago(esInicial);
		this.setActivarid_empresaTipoAutoPago(esInicial);
		this.setActivarcodigoTipoAutoPago(esInicial);
		this.setActivarnombreTipoAutoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.ID)) {
				this.setActivaridTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAutoPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAutoPago(esInicial);
		this.setResaltarid_empresaTipoAutoPago(esInicial);
		this.setResaltarcodigoTipoAutoPago(esInicial);
		this.setResaltarnombreTipoAutoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoAutoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAutoPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAutoPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoAutoPago=true;

	public Boolean getMostrarFK_IdEmpresaTipoAutoPago() {
		return this.mostrarFK_IdEmpresaTipoAutoPago;
	}

	public void setMostrarFK_IdEmpresaTipoAutoPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoAutoPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoAutoPago=true;

	public Boolean getActivarFK_IdEmpresaTipoAutoPago() {
		return this.activarFK_IdEmpresaTipoAutoPago;
	}

	public void setActivarFK_IdEmpresaTipoAutoPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoAutoPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoAutoPago=null;

	public Border getResaltarFK_IdEmpresaTipoAutoPago() {
		return this.resaltarFK_IdEmpresaTipoAutoPago;
	}

	public void setResaltarFK_IdEmpresaTipoAutoPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoAutoPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoAutoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAutoPagoBeanSwingJInternalFrame tipoautopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoAutoPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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


import com.bydan.erp.facturacion.util.TipoPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoPagoParameterGeneral;

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
final public class TipoPagoConstantesFunciones extends TipoPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPago"+TipoPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPagoConstantesFunciones.SCHEMA+"_"+TipoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPagoConstantesFunciones.SCHEMA+"_"+TipoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPagoConstantesFunciones.SCHEMA+"_"+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPagoConstantesFunciones.SCHEMA+"_"+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPago";
	public static final String OBJECTNAME="tipopago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipopago from "+TipoPagoConstantesFunciones.SPERSISTENCENAME+" tipopago";
	public static String QUERYSELECTNATIVE="select "+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME+".id,"+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME+".version_row,"+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME+".codigo,"+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME+".nombre from "+TipoPagoConstantesFunciones.SCHEMA+"."+TipoPagoConstantesFunciones.TABLENAME;//+" as "+TipoPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPagoConstantesFuncionesAdditional tipopagoConstantesFuncionesAdditional=null;
	
	public TipoPagoConstantesFuncionesAdditional getTipoPagoConstantesFuncionesAdditional() {
		return this.tipopagoConstantesFuncionesAdditional;
	}
	
	public void setTipoPagoConstantesFuncionesAdditional(TipoPagoConstantesFuncionesAdditional tipopagoConstantesFuncionesAdditional) {
		try {
			this.tipopagoConstantesFuncionesAdditional=tipopagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPagoConstantesFunciones.CODIGO)) {sLabelColumna=TipoPagoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPagoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoPagoDescripcion(TipoPago tipopago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipopago !=null/* && tipopago.getId()!=0*/) {
			sDescripcion=tipopago.getcodigo();//tipopagotipopago.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPagoDescripcionDetallado(TipoPago tipopago) {
		String sDescripcion="";
			
		sDescripcion+=TipoPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipopago.getId().toString()+",";
		sDescripcion+=TipoPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipopago.getVersionRow().toString()+",";
		sDescripcion+=TipoPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipopago.getid_empresa().toString()+",";
		sDescripcion+=TipoPagoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipopago.getcodigo()+",";
		sDescripcion+=TipoPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipopago.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPagoDescripcion(TipoPago tipopago,String sValor) throws Exception {			
		if(tipopago !=null) {
			tipopago.setcodigo(sValor);;//tipopagotipopago.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPago(TipoPago tipopago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipopago.setcodigo(tipopago.getcodigo().trim());
		tipopago.setnombre(tipopago.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPagos(List<TipoPago> tipopagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPago tipopago: tipopagos) {
			tipopago.setcodigo(tipopago.getcodigo().trim());
			tipopago.setnombre(tipopago.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPago(TipoPago tipopago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipopago.getConCambioAuxiliar()) {
			tipopago.setIsDeleted(tipopago.getIsDeletedAuxiliar());	
			tipopago.setIsNew(tipopago.getIsNewAuxiliar());	
			tipopago.setIsChanged(tipopago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipopago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipopago.setIsDeletedAuxiliar(false);	
			tipopago.setIsNewAuxiliar(false);	
			tipopago.setIsChangedAuxiliar(false);
			
			tipopago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPagos(List<TipoPago> tipopagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPago tipopago : tipopagos) {
			if(conAsignarBase && tipopago.getConCambioAuxiliar()) {
				tipopago.setIsDeleted(tipopago.getIsDeletedAuxiliar());	
				tipopago.setIsNew(tipopago.getIsNewAuxiliar());	
				tipopago.setIsChanged(tipopago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipopago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipopago.setIsDeletedAuxiliar(false);	
				tipopago.setIsNewAuxiliar(false);	
				tipopago.setIsChangedAuxiliar(false);
				
				tipopago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPago(TipoPago tipopago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPagos(List<TipoPago> tipopagos,Boolean conEnteros) throws Exception  {
		
		for(TipoPago tipopago: tipopagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPago(List<TipoPago> tipopagos,TipoPago tipopagoAux) throws Exception  {
		TipoPagoConstantesFunciones.InicializarValoresTipoPago(tipopagoAux,true);
		
		for(TipoPago tipopago: tipopagos) {
			if(tipopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPagoConstantesFunciones.getArrayColumnasGlobalesTipoPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPago> tipopagos,TipoPago tipopago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPago tipopagoAux: tipopagos) {
			if(tipopagoAux!=null && tipopago!=null) {
				if((tipopagoAux.getId()==null && tipopago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipopagoAux.getId()!=null && tipopago.getId()!=null){
					if(tipopagoAux.getId().equals(tipopago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPago(List<TipoPago> tipopagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPago tipopago: tipopagos) {			
			if(tipopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPagoConstantesFunciones.LABEL_ID, TipoPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoConstantesFunciones.LABEL_VERSIONROW, TipoPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoConstantesFunciones.LABEL_IDEMPRESA, TipoPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoConstantesFunciones.LABEL_CODIGO, TipoPagoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPagoConstantesFunciones.LABEL_NOMBRE, TipoPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago() throws Exception  {
		return TipoPagoConstantesFunciones.getTiposSeleccionarTipoPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago(Boolean conFk) throws Exception  {
		return TipoPagoConstantesFunciones.getTiposSeleccionarTipoPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPagoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPagoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPago(TipoPago tipopagoAux) throws Exception {
		
			tipopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipopagoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPago(List<TipoPago> tipopagosTemp) throws Exception {
		for(TipoPago tipopagoAux:tipopagosTemp) {
			
			tipopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipopagoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPagoConstantesFunciones.getClassesRelationshipsOfTipoPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPago tipopago,List<TipoPago> tipopagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPago tipopagoEncontrado=null;
			
			for(TipoPago tipopagoLocal:tipopagos) {
				if(tipopagoLocal.getId().equals(tipopago.getId())) {
					tipopagoEncontrado=tipopagoLocal;
					
					tipopagoLocal.setIsChanged(tipopago.getIsChanged());
					tipopagoLocal.setIsNew(tipopago.getIsNew());
					tipopagoLocal.setIsDeleted(tipopago.getIsDeleted());
					
					tipopagoLocal.setGeneralEntityOriginal(tipopago.getGeneralEntityOriginal());
					
					tipopagoLocal.setId(tipopago.getId());	
					tipopagoLocal.setVersionRow(tipopago.getVersionRow());	
					tipopagoLocal.setid_empresa(tipopago.getid_empresa());	
					tipopagoLocal.setcodigo(tipopago.getcodigo());	
					tipopagoLocal.setnombre(tipopago.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipopago.getIsDeleted()) {
				if(!existe) {
					tipopagos.add(tipopago);
				}
			} else {
				if(tipopagoEncontrado!=null && permiteQuitar)  {
					tipopagos.remove(tipopagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPago tipopago,List<TipoPago> tipopagos) throws Exception {
		try	{			
			for(TipoPago tipopagoLocal:tipopagos) {
				if(tipopagoLocal.getId().equals(tipopago.getId())) {
					tipopagoLocal.setIsSelected(tipopago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPago(List<TipoPago> tipopagosAux) throws Exception {
		//this.tipopagosAux=tipopagosAux;
		
		for(TipoPago tipopagoAux:tipopagosAux) {
			if(tipopagoAux.getIsChanged()) {
				tipopagoAux.setIsChanged(false);
			}		
			
			if(tipopagoAux.getIsNew()) {
				tipopagoAux.setIsNew(false);
			}	
			
			if(tipopagoAux.getIsDeleted()) {
				tipopagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPago(TipoPago tipopagoAux) throws Exception {
		//this.tipopagoAux=tipopagoAux;
		
			if(tipopagoAux.getIsChanged()) {
				tipopagoAux.setIsChanged(false);
			}		
			
			if(tipopagoAux.getIsNew()) {
				tipopagoAux.setIsNew(false);
			}	
			
			if(tipopagoAux.getIsDeleted()) {
				tipopagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPago tipopagoAsignar,TipoPago tipopago) throws Exception {
		tipopagoAsignar.setId(tipopago.getId());	
		tipopagoAsignar.setVersionRow(tipopago.getVersionRow());	
		tipopagoAsignar.setid_empresa(tipopago.getid_empresa());
		tipopagoAsignar.setempresa_descripcion(tipopago.getempresa_descripcion());	
		tipopagoAsignar.setcodigo(tipopago.getcodigo());	
		tipopagoAsignar.setnombre(tipopago.getnombre());	
	}
	
	public static void inicializarTipoPago(TipoPago tipopago) throws Exception {
		try {
				tipopago.setId(0L);	
					
				tipopago.setid_empresa(-1L);	
				tipopago.setcodigo("");	
				tipopago.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPagoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPago(String sTipo,Row row,Workbook workbook,TipoPago tipopago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPago() {
		return this.sFinalQueryTipoPago;
	}
	
	public void setsFinalQueryTipoPago(String sFinalQueryTipoPago) {
		this.sFinalQueryTipoPago= sFinalQueryTipoPago;
	}
	
	public Border resaltarSeleccionarTipoPago=null;
	
	public Border setResaltarSeleccionarTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipopagoBeanSwingJInternalFrame.jTtoolBarTipoPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPago() {
		return this.resaltarSeleccionarTipoPago;
	}
	
	public void setResaltarSeleccionarTipoPago(Border borderResaltarSeleccionarTipoPago) {
		this.resaltarSeleccionarTipoPago= borderResaltarSeleccionarTipoPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPago=null;
	public Boolean mostraridTipoPago=true;
	public Boolean activaridTipoPago=true;

	public Border resaltarid_empresaTipoPago=null;
	public Boolean mostrarid_empresaTipoPago=true;
	public Boolean activarid_empresaTipoPago=true;
	public Boolean cargarid_empresaTipoPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPago=false;//ConEventDepend=true

	public Border resaltarcodigoTipoPago=null;
	public Boolean mostrarcodigoTipoPago=true;
	public Boolean activarcodigoTipoPago=true;

	public Border resaltarnombreTipoPago=null;
	public Boolean mostrarnombreTipoPago=true;
	public Boolean activarnombreTipoPago=true;

	
	

	public Border setResaltaridTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagoBeanSwingJInternalFrame.jTtoolBarTipoPago.setBorder(borderResaltar);
		
		this.resaltaridTipoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPago() {
		return this.resaltaridTipoPago;
	}

	public void setResaltaridTipoPago(Border borderResaltar) {
		this.resaltaridTipoPago= borderResaltar;
	}

	public Boolean getMostraridTipoPago() {
		return this.mostraridTipoPago;
	}

	public void setMostraridTipoPago(Boolean mostraridTipoPago) {
		this.mostraridTipoPago= mostraridTipoPago;
	}

	public Boolean getActivaridTipoPago() {
		return this.activaridTipoPago;
	}

	public void setActivaridTipoPago(Boolean activaridTipoPago) {
		this.activaridTipoPago= activaridTipoPago;
	}

	public Border setResaltarid_empresaTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagoBeanSwingJInternalFrame.jTtoolBarTipoPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPago() {
		return this.resaltarid_empresaTipoPago;
	}

	public void setResaltarid_empresaTipoPago(Border borderResaltar) {
		this.resaltarid_empresaTipoPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPago() {
		return this.mostrarid_empresaTipoPago;
	}

	public void setMostrarid_empresaTipoPago(Boolean mostrarid_empresaTipoPago) {
		this.mostrarid_empresaTipoPago= mostrarid_empresaTipoPago;
	}

	public Boolean getActivarid_empresaTipoPago() {
		return this.activarid_empresaTipoPago;
	}

	public void setActivarid_empresaTipoPago(Boolean activarid_empresaTipoPago) {
		this.activarid_empresaTipoPago= activarid_empresaTipoPago;
	}

	public Boolean getCargarid_empresaTipoPago() {
		return this.cargarid_empresaTipoPago;
	}

	public void setCargarid_empresaTipoPago(Boolean cargarid_empresaTipoPago) {
		this.cargarid_empresaTipoPago= cargarid_empresaTipoPago;
	}

	public Border setResaltarcodigoTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagoBeanSwingJInternalFrame.jTtoolBarTipoPago.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPago() {
		return this.resaltarcodigoTipoPago;
	}

	public void setResaltarcodigoTipoPago(Border borderResaltar) {
		this.resaltarcodigoTipoPago= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPago() {
		return this.mostrarcodigoTipoPago;
	}

	public void setMostrarcodigoTipoPago(Boolean mostrarcodigoTipoPago) {
		this.mostrarcodigoTipoPago= mostrarcodigoTipoPago;
	}

	public Boolean getActivarcodigoTipoPago() {
		return this.activarcodigoTipoPago;
	}

	public void setActivarcodigoTipoPago(Boolean activarcodigoTipoPago) {
		this.activarcodigoTipoPago= activarcodigoTipoPago;
	}

	public Border setResaltarnombreTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopagoBeanSwingJInternalFrame.jTtoolBarTipoPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPago() {
		return this.resaltarnombreTipoPago;
	}

	public void setResaltarnombreTipoPago(Border borderResaltar) {
		this.resaltarnombreTipoPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPago() {
		return this.mostrarnombreTipoPago;
	}

	public void setMostrarnombreTipoPago(Boolean mostrarnombreTipoPago) {
		this.mostrarnombreTipoPago= mostrarnombreTipoPago;
	}

	public Boolean getActivarnombreTipoPago() {
		return this.activarnombreTipoPago;
	}

	public void setActivarnombreTipoPago(Boolean activarnombreTipoPago) {
		this.activarnombreTipoPago= activarnombreTipoPago;
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
		
		
		this.setMostraridTipoPago(esInicial);
		this.setMostrarid_empresaTipoPago(esInicial);
		this.setMostrarcodigoTipoPago(esInicial);
		this.setMostrarnombreTipoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoConstantesFunciones.ID)) {
				this.setMostraridTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPago(esAsigna);
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
		
		
		this.setActivaridTipoPago(esInicial);
		this.setActivarid_empresaTipoPago(esInicial);
		this.setActivarcodigoTipoPago(esInicial);
		this.setActivarnombreTipoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoConstantesFunciones.ID)) {
				this.setActivaridTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPago(esInicial);
		this.setResaltarid_empresaTipoPago(esInicial);
		this.setResaltarcodigoTipoPago(esInicial);
		this.setResaltarnombreTipoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoPago=true;

	public Boolean getMostrarFK_IdEmpresaTipoPago() {
		return this.mostrarFK_IdEmpresaTipoPago;
	}

	public void setMostrarFK_IdEmpresaTipoPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoPago=true;

	public Boolean getActivarFK_IdEmpresaTipoPago() {
		return this.activarFK_IdEmpresaTipoPago;
	}

	public void setActivarFK_IdEmpresaTipoPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoPago=null;

	public Border getResaltarFK_IdEmpresaTipoPago() {
		return this.resaltarFK_IdEmpresaTipoPago;
	}

	public void setResaltarFK_IdEmpresaTipoPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPagoBeanSwingJInternalFrame tipopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
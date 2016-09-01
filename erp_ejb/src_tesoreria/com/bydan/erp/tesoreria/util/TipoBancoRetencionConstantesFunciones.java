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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TipoBancoRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoBancoRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoBancoRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoBancoRetencionConstantesFunciones extends TipoBancoRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoBancoRetencion";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoBancoRetencion"+TipoBancoRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoBancoRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoBancoRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoBancoRetencionConstantesFunciones.SCHEMA+"_"+TipoBancoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoBancoRetencionConstantesFunciones.SCHEMA+"_"+TipoBancoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoBancoRetencionConstantesFunciones.SCHEMA+"_"+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoBancoRetencionConstantesFunciones.SCHEMA+"_"+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoBancoRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoBancoRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoBancoRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoBancoRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Banco Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Banco Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Banco Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoBancoRetencion";
	public static final String OBJECTNAME="tipobancoretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_banco_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipobancoretencion from "+TipoBancoRetencionConstantesFunciones.SPERSISTENCENAME+" tipobancoretencion";
	public static String QUERYSELECTNATIVE="select "+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME+".id,"+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME+".version_row,"+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME+".id_empresa,"+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME+".codigo,"+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME+".nombre from "+TipoBancoRetencionConstantesFunciones.SCHEMA+"."+TipoBancoRetencionConstantesFunciones.TABLENAME;//+" as "+TipoBancoRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoBancoRetencionConstantesFuncionesAdditional tipobancoretencionConstantesFuncionesAdditional=null;
	
	public TipoBancoRetencionConstantesFuncionesAdditional getTipoBancoRetencionConstantesFuncionesAdditional() {
		return this.tipobancoretencionConstantesFuncionesAdditional;
	}
	
	public void setTipoBancoRetencionConstantesFuncionesAdditional(TipoBancoRetencionConstantesFuncionesAdditional tipobancoretencionConstantesFuncionesAdditional) {
		try {
			this.tipobancoretencionConstantesFuncionesAdditional=tipobancoretencionConstantesFuncionesAdditional;
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
	
	public static String getTipoBancoRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoBancoRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoBancoRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoBancoRetencionConstantesFunciones.CODIGO)) {sLabelColumna=TipoBancoRetencionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoBancoRetencionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoBancoRetencionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoBancoRetencionDescripcion(TipoBancoRetencion tipobancoretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipobancoretencion !=null/* && tipobancoretencion.getId()!=0*/) {
			sDescripcion=tipobancoretencion.getcodigo();//tipobancoretenciontipobancoretencion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoBancoRetencionDescripcionDetallado(TipoBancoRetencion tipobancoretencion) {
		String sDescripcion="";
			
		sDescripcion+=TipoBancoRetencionConstantesFunciones.ID+"=";
		sDescripcion+=tipobancoretencion.getId().toString()+",";
		sDescripcion+=TipoBancoRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipobancoretencion.getVersionRow().toString()+",";
		sDescripcion+=TipoBancoRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipobancoretencion.getid_empresa().toString()+",";
		sDescripcion+=TipoBancoRetencionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipobancoretencion.getcodigo()+",";
		sDescripcion+=TipoBancoRetencionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipobancoretencion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoBancoRetencionDescripcion(TipoBancoRetencion tipobancoretencion,String sValor) throws Exception {			
		if(tipobancoretencion !=null) {
			tipobancoretencion.setcodigo(sValor);;//tipobancoretenciontipobancoretencion.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoBancoRetencion(TipoBancoRetencion tipobancoretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipobancoretencion.setcodigo(tipobancoretencion.getcodigo().trim());
		tipobancoretencion.setnombre(tipobancoretencion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoBancoRetencions(List<TipoBancoRetencion> tipobancoretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoBancoRetencion tipobancoretencion: tipobancoretencions) {
			tipobancoretencion.setcodigo(tipobancoretencion.getcodigo().trim());
			tipobancoretencion.setnombre(tipobancoretencion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoRetencion(TipoBancoRetencion tipobancoretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipobancoretencion.getConCambioAuxiliar()) {
			tipobancoretencion.setIsDeleted(tipobancoretencion.getIsDeletedAuxiliar());	
			tipobancoretencion.setIsNew(tipobancoretencion.getIsNewAuxiliar());	
			tipobancoretencion.setIsChanged(tipobancoretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipobancoretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipobancoretencion.setIsDeletedAuxiliar(false);	
			tipobancoretencion.setIsNewAuxiliar(false);	
			tipobancoretencion.setIsChangedAuxiliar(false);
			
			tipobancoretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoRetencions(List<TipoBancoRetencion> tipobancoretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoBancoRetencion tipobancoretencion : tipobancoretencions) {
			if(conAsignarBase && tipobancoretencion.getConCambioAuxiliar()) {
				tipobancoretencion.setIsDeleted(tipobancoretencion.getIsDeletedAuxiliar());	
				tipobancoretencion.setIsNew(tipobancoretencion.getIsNewAuxiliar());	
				tipobancoretencion.setIsChanged(tipobancoretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipobancoretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipobancoretencion.setIsDeletedAuxiliar(false);	
				tipobancoretencion.setIsNewAuxiliar(false);	
				tipobancoretencion.setIsChangedAuxiliar(false);
				
				tipobancoretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoBancoRetencion(TipoBancoRetencion tipobancoretencion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoBancoRetencions(List<TipoBancoRetencion> tipobancoretencions,Boolean conEnteros) throws Exception  {
		
		for(TipoBancoRetencion tipobancoretencion: tipobancoretencions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoBancoRetencion(List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencion tipobancoretencionAux) throws Exception  {
		TipoBancoRetencionConstantesFunciones.InicializarValoresTipoBancoRetencion(tipobancoretencionAux,true);
		
		for(TipoBancoRetencion tipobancoretencion: tipobancoretencions) {
			if(tipobancoretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoBancoRetencionConstantesFunciones.getArrayColumnasGlobalesTipoBancoRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoBancoRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoBancoRetencionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoBancoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoBancoRetencion> tipobancoretencions,TipoBancoRetencion tipobancoretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoBancoRetencion tipobancoretencionAux: tipobancoretencions) {
			if(tipobancoretencionAux!=null && tipobancoretencion!=null) {
				if((tipobancoretencionAux.getId()==null && tipobancoretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipobancoretencionAux.getId()!=null && tipobancoretencion.getId()!=null){
					if(tipobancoretencionAux.getId().equals(tipobancoretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoBancoRetencion(List<TipoBancoRetencion> tipobancoretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoBancoRetencion tipobancoretencion: tipobancoretencions) {			
			if(tipobancoretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoBancoRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoBancoRetencionConstantesFunciones.LABEL_ID, TipoBancoRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoRetencionConstantesFunciones.LABEL_VERSIONROW, TipoBancoRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoRetencionConstantesFunciones.LABEL_IDEMPRESA, TipoBancoRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoRetencionConstantesFunciones.LABEL_CODIGO, TipoBancoRetencionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoRetencionConstantesFunciones.LABEL_NOMBRE, TipoBancoRetencionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoBancoRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoBancoRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoRetencionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoRetencionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoRetencion() throws Exception  {
		return TipoBancoRetencionConstantesFunciones.getTiposSeleccionarTipoBancoRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoRetencion(Boolean conFk) throws Exception  {
		return TipoBancoRetencionConstantesFunciones.getTiposSeleccionarTipoBancoRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoBancoRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoRetencionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoBancoRetencionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoRetencionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoBancoRetencionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoBancoRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoRetencion(TipoBancoRetencion tipobancoretencionAux) throws Exception {
		
			tipobancoretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoretencionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoRetencion(List<TipoBancoRetencion> tipobancoretencionsTemp) throws Exception {
		for(TipoBancoRetencion tipobancoretencionAux:tipobancoretencionsTemp) {
			
			tipobancoretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoretencionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoBancoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoRetencionConstantesFunciones.getClassesRelationshipsOfTipoBancoRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoBancoRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoBancoRetencion tipobancoretencion,List<TipoBancoRetencion> tipobancoretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoBancoRetencion tipobancoretencionEncontrado=null;
			
			for(TipoBancoRetencion tipobancoretencionLocal:tipobancoretencions) {
				if(tipobancoretencionLocal.getId().equals(tipobancoretencion.getId())) {
					tipobancoretencionEncontrado=tipobancoretencionLocal;
					
					tipobancoretencionLocal.setIsChanged(tipobancoretencion.getIsChanged());
					tipobancoretencionLocal.setIsNew(tipobancoretencion.getIsNew());
					tipobancoretencionLocal.setIsDeleted(tipobancoretencion.getIsDeleted());
					
					tipobancoretencionLocal.setGeneralEntityOriginal(tipobancoretencion.getGeneralEntityOriginal());
					
					tipobancoretencionLocal.setId(tipobancoretencion.getId());	
					tipobancoretencionLocal.setVersionRow(tipobancoretencion.getVersionRow());	
					tipobancoretencionLocal.setid_empresa(tipobancoretencion.getid_empresa());	
					tipobancoretencionLocal.setcodigo(tipobancoretencion.getcodigo());	
					tipobancoretencionLocal.setnombre(tipobancoretencion.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipobancoretencion.getIsDeleted()) {
				if(!existe) {
					tipobancoretencions.add(tipobancoretencion);
				}
			} else {
				if(tipobancoretencionEncontrado!=null && permiteQuitar)  {
					tipobancoretencions.remove(tipobancoretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoBancoRetencion tipobancoretencion,List<TipoBancoRetencion> tipobancoretencions) throws Exception {
		try	{			
			for(TipoBancoRetencion tipobancoretencionLocal:tipobancoretencions) {
				if(tipobancoretencionLocal.getId().equals(tipobancoretencion.getId())) {
					tipobancoretencionLocal.setIsSelected(tipobancoretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoBancoRetencion(List<TipoBancoRetencion> tipobancoretencionsAux) throws Exception {
		//this.tipobancoretencionsAux=tipobancoretencionsAux;
		
		for(TipoBancoRetencion tipobancoretencionAux:tipobancoretencionsAux) {
			if(tipobancoretencionAux.getIsChanged()) {
				tipobancoretencionAux.setIsChanged(false);
			}		
			
			if(tipobancoretencionAux.getIsNew()) {
				tipobancoretencionAux.setIsNew(false);
			}	
			
			if(tipobancoretencionAux.getIsDeleted()) {
				tipobancoretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoBancoRetencion(TipoBancoRetencion tipobancoretencionAux) throws Exception {
		//this.tipobancoretencionAux=tipobancoretencionAux;
		
			if(tipobancoretencionAux.getIsChanged()) {
				tipobancoretencionAux.setIsChanged(false);
			}		
			
			if(tipobancoretencionAux.getIsNew()) {
				tipobancoretencionAux.setIsNew(false);
			}	
			
			if(tipobancoretencionAux.getIsDeleted()) {
				tipobancoretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoBancoRetencion tipobancoretencionAsignar,TipoBancoRetencion tipobancoretencion) throws Exception {
		tipobancoretencionAsignar.setId(tipobancoretencion.getId());	
		tipobancoretencionAsignar.setVersionRow(tipobancoretencion.getVersionRow());	
		tipobancoretencionAsignar.setid_empresa(tipobancoretencion.getid_empresa());
		tipobancoretencionAsignar.setempresa_descripcion(tipobancoretencion.getempresa_descripcion());	
		tipobancoretencionAsignar.setcodigo(tipobancoretencion.getcodigo());	
		tipobancoretencionAsignar.setnombre(tipobancoretencion.getnombre());	
	}
	
	public static void inicializarTipoBancoRetencion(TipoBancoRetencion tipobancoretencion) throws Exception {
		try {
				tipobancoretencion.setId(0L);	
					
				tipobancoretencion.setid_empresa(-1L);	
				tipobancoretencion.setcodigo("");	
				tipobancoretencion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoBancoRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoRetencionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoRetencionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoBancoRetencion(String sTipo,Row row,Workbook workbook,TipoBancoRetencion tipobancoretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoretencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoretencion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoretencion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoBancoRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoBancoRetencion() {
		return this.sFinalQueryTipoBancoRetencion;
	}
	
	public void setsFinalQueryTipoBancoRetencion(String sFinalQueryTipoBancoRetencion) {
		this.sFinalQueryTipoBancoRetencion= sFinalQueryTipoBancoRetencion;
	}
	
	public Border resaltarSeleccionarTipoBancoRetencion=null;
	
	public Border setResaltarSeleccionarTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipobancoretencionBeanSwingJInternalFrame.jTtoolBarTipoBancoRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoBancoRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoBancoRetencion() {
		return this.resaltarSeleccionarTipoBancoRetencion;
	}
	
	public void setResaltarSeleccionarTipoBancoRetencion(Border borderResaltarSeleccionarTipoBancoRetencion) {
		this.resaltarSeleccionarTipoBancoRetencion= borderResaltarSeleccionarTipoBancoRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoBancoRetencion=null;
	public Boolean mostraridTipoBancoRetencion=true;
	public Boolean activaridTipoBancoRetencion=true;

	public Border resaltarid_empresaTipoBancoRetencion=null;
	public Boolean mostrarid_empresaTipoBancoRetencion=true;
	public Boolean activarid_empresaTipoBancoRetencion=true;
	public Boolean cargarid_empresaTipoBancoRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoBancoRetencion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoBancoRetencion=null;
	public Boolean mostrarcodigoTipoBancoRetencion=true;
	public Boolean activarcodigoTipoBancoRetencion=true;

	public Border resaltarnombreTipoBancoRetencion=null;
	public Boolean mostrarnombreTipoBancoRetencion=true;
	public Boolean activarnombreTipoBancoRetencion=true;

	
	

	public Border setResaltaridTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoretencionBeanSwingJInternalFrame.jTtoolBarTipoBancoRetencion.setBorder(borderResaltar);
		
		this.resaltaridTipoBancoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoBancoRetencion() {
		return this.resaltaridTipoBancoRetencion;
	}

	public void setResaltaridTipoBancoRetencion(Border borderResaltar) {
		this.resaltaridTipoBancoRetencion= borderResaltar;
	}

	public Boolean getMostraridTipoBancoRetencion() {
		return this.mostraridTipoBancoRetencion;
	}

	public void setMostraridTipoBancoRetencion(Boolean mostraridTipoBancoRetencion) {
		this.mostraridTipoBancoRetencion= mostraridTipoBancoRetencion;
	}

	public Boolean getActivaridTipoBancoRetencion() {
		return this.activaridTipoBancoRetencion;
	}

	public void setActivaridTipoBancoRetencion(Boolean activaridTipoBancoRetencion) {
		this.activaridTipoBancoRetencion= activaridTipoBancoRetencion;
	}

	public Border setResaltarid_empresaTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoretencionBeanSwingJInternalFrame.jTtoolBarTipoBancoRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoBancoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoBancoRetencion() {
		return this.resaltarid_empresaTipoBancoRetencion;
	}

	public void setResaltarid_empresaTipoBancoRetencion(Border borderResaltar) {
		this.resaltarid_empresaTipoBancoRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoBancoRetencion() {
		return this.mostrarid_empresaTipoBancoRetencion;
	}

	public void setMostrarid_empresaTipoBancoRetencion(Boolean mostrarid_empresaTipoBancoRetencion) {
		this.mostrarid_empresaTipoBancoRetencion= mostrarid_empresaTipoBancoRetencion;
	}

	public Boolean getActivarid_empresaTipoBancoRetencion() {
		return this.activarid_empresaTipoBancoRetencion;
	}

	public void setActivarid_empresaTipoBancoRetencion(Boolean activarid_empresaTipoBancoRetencion) {
		this.activarid_empresaTipoBancoRetencion= activarid_empresaTipoBancoRetencion;
	}

	public Boolean getCargarid_empresaTipoBancoRetencion() {
		return this.cargarid_empresaTipoBancoRetencion;
	}

	public void setCargarid_empresaTipoBancoRetencion(Boolean cargarid_empresaTipoBancoRetencion) {
		this.cargarid_empresaTipoBancoRetencion= cargarid_empresaTipoBancoRetencion;
	}

	public Border setResaltarcodigoTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoretencionBeanSwingJInternalFrame.jTtoolBarTipoBancoRetencion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoBancoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoBancoRetencion() {
		return this.resaltarcodigoTipoBancoRetencion;
	}

	public void setResaltarcodigoTipoBancoRetencion(Border borderResaltar) {
		this.resaltarcodigoTipoBancoRetencion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoBancoRetencion() {
		return this.mostrarcodigoTipoBancoRetencion;
	}

	public void setMostrarcodigoTipoBancoRetencion(Boolean mostrarcodigoTipoBancoRetencion) {
		this.mostrarcodigoTipoBancoRetencion= mostrarcodigoTipoBancoRetencion;
	}

	public Boolean getActivarcodigoTipoBancoRetencion() {
		return this.activarcodigoTipoBancoRetencion;
	}

	public void setActivarcodigoTipoBancoRetencion(Boolean activarcodigoTipoBancoRetencion) {
		this.activarcodigoTipoBancoRetencion= activarcodigoTipoBancoRetencion;
	}

	public Border setResaltarnombreTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoretencionBeanSwingJInternalFrame.jTtoolBarTipoBancoRetencion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoBancoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoBancoRetencion() {
		return this.resaltarnombreTipoBancoRetencion;
	}

	public void setResaltarnombreTipoBancoRetencion(Border borderResaltar) {
		this.resaltarnombreTipoBancoRetencion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoBancoRetencion() {
		return this.mostrarnombreTipoBancoRetencion;
	}

	public void setMostrarnombreTipoBancoRetencion(Boolean mostrarnombreTipoBancoRetencion) {
		this.mostrarnombreTipoBancoRetencion= mostrarnombreTipoBancoRetencion;
	}

	public Boolean getActivarnombreTipoBancoRetencion() {
		return this.activarnombreTipoBancoRetencion;
	}

	public void setActivarnombreTipoBancoRetencion(Boolean activarnombreTipoBancoRetencion) {
		this.activarnombreTipoBancoRetencion= activarnombreTipoBancoRetencion;
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
		
		
		this.setMostraridTipoBancoRetencion(esInicial);
		this.setMostrarid_empresaTipoBancoRetencion(esInicial);
		this.setMostrarcodigoTipoBancoRetencion(esInicial);
		this.setMostrarnombreTipoBancoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.ID)) {
				this.setMostraridTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoBancoRetencion(esAsigna);
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
		
		
		this.setActivaridTipoBancoRetencion(esInicial);
		this.setActivarid_empresaTipoBancoRetencion(esInicial);
		this.setActivarcodigoTipoBancoRetencion(esInicial);
		this.setActivarnombreTipoBancoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.ID)) {
				this.setActivaridTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoBancoRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoBancoRetencion(esInicial);
		this.setResaltarid_empresaTipoBancoRetencion(esInicial);
		this.setResaltarcodigoTipoBancoRetencion(esInicial);
		this.setResaltarnombreTipoBancoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.ID)) {
				this.setResaltaridTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoBancoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoRetencionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoBancoRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoBancoRetencion=true;

	public Boolean getMostrarBusquedaPorCodigoTipoBancoRetencion() {
		return this.mostrarBusquedaPorCodigoTipoBancoRetencion;
	}

	public void setMostrarBusquedaPorCodigoTipoBancoRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoBancoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoBancoRetencion=true;

	public Boolean getMostrarBusquedaPorNombreTipoBancoRetencion() {
		return this.mostrarBusquedaPorNombreTipoBancoRetencion;
	}

	public void setMostrarBusquedaPorNombreTipoBancoRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoBancoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoBancoRetencion=true;

	public Boolean getMostrarFK_IdEmpresaTipoBancoRetencion() {
		return this.mostrarFK_IdEmpresaTipoBancoRetencion;
	}

	public void setMostrarFK_IdEmpresaTipoBancoRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoBancoRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoBancoRetencion=true;

	public Boolean getActivarBusquedaPorCodigoTipoBancoRetencion() {
		return this.activarBusquedaPorCodigoTipoBancoRetencion;
	}

	public void setActivarBusquedaPorCodigoTipoBancoRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoBancoRetencion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoBancoRetencion=true;

	public Boolean getActivarBusquedaPorNombreTipoBancoRetencion() {
		return this.activarBusquedaPorNombreTipoBancoRetencion;
	}

	public void setActivarBusquedaPorNombreTipoBancoRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoBancoRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoBancoRetencion=true;

	public Boolean getActivarFK_IdEmpresaTipoBancoRetencion() {
		return this.activarFK_IdEmpresaTipoBancoRetencion;
	}

	public void setActivarFK_IdEmpresaTipoBancoRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoBancoRetencion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoBancoRetencion=null;

	public Border getResaltarBusquedaPorCodigoTipoBancoRetencion() {
		return this.resaltarBusquedaPorCodigoTipoBancoRetencion;
	}

	public void setResaltarBusquedaPorCodigoTipoBancoRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoBancoRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoBancoRetencion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoBancoRetencion=null;

	public Border getResaltarBusquedaPorNombreTipoBancoRetencion() {
		return this.resaltarBusquedaPorNombreTipoBancoRetencion;
	}

	public void setResaltarBusquedaPorNombreTipoBancoRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoBancoRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoBancoRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoBancoRetencion=null;

	public Border getResaltarFK_IdEmpresaTipoBancoRetencion() {
		return this.resaltarFK_IdEmpresaTipoBancoRetencion;
	}

	public void setResaltarFK_IdEmpresaTipoBancoRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoBancoRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoBancoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoRetencionBeanSwingJInternalFrame tipobancoretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoBancoRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
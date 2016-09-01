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


import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoParameterGeneral;

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
final public class TipoBancoFormaPagoConstantesFunciones extends TipoBancoFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoBancoFormaPago";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoBancoFormaPago"+TipoBancoFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoBancoFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoBancoFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoBancoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoBancoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoBancoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoBancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoBancoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoBancoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoBancoFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoBancoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoBancoFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Banco Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Banco Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Banco Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoBancoFormaPago";
	public static final String OBJECTNAME="tipobancoformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_banco_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipobancoformapago from "+TipoBancoFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipobancoformapago";
	public static String QUERYSELECTNATIVE="select "+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME+".codigo,"+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoBancoFormaPagoConstantesFunciones.SCHEMA+"."+TipoBancoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoBancoFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoBancoFormaPagoConstantesFuncionesAdditional tipobancoformapagoConstantesFuncionesAdditional=null;
	
	public TipoBancoFormaPagoConstantesFuncionesAdditional getTipoBancoFormaPagoConstantesFuncionesAdditional() {
		return this.tipobancoformapagoConstantesFuncionesAdditional;
	}
	
	public void setTipoBancoFormaPagoConstantesFuncionesAdditional(TipoBancoFormaPagoConstantesFuncionesAdditional tipobancoformapagoConstantesFuncionesAdditional) {
		try {
			this.tipobancoformapagoConstantesFuncionesAdditional=tipobancoformapagoConstantesFuncionesAdditional;
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
	
	public static String getTipoBancoFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoBancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoBancoFormaPagoConstantesFunciones.CODIGO)) {sLabelColumna=TipoBancoFormaPagoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoBancoFormaPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoBancoFormaPagoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoBancoFormaPagoDescripcion(TipoBancoFormaPago tipobancoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipobancoformapago !=null/* && tipobancoformapago.getId()!=0*/) {
			sDescripcion=tipobancoformapago.getcodigo();//tipobancoformapagotipobancoformapago.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoBancoFormaPagoDescripcionDetallado(TipoBancoFormaPago tipobancoformapago) {
		String sDescripcion="";
			
		sDescripcion+=TipoBancoFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipobancoformapago.getId().toString()+",";
		sDescripcion+=TipoBancoFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipobancoformapago.getVersionRow().toString()+",";
		sDescripcion+=TipoBancoFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipobancoformapago.getid_empresa().toString()+",";
		sDescripcion+=TipoBancoFormaPagoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipobancoformapago.getcodigo()+",";
		sDescripcion+=TipoBancoFormaPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipobancoformapago.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoBancoFormaPagoDescripcion(TipoBancoFormaPago tipobancoformapago,String sValor) throws Exception {			
		if(tipobancoformapago !=null) {
			tipobancoformapago.setcodigo(sValor);;//tipobancoformapagotipobancoformapago.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipobancoformapago.setcodigo(tipobancoformapago.getcodigo().trim());
		tipobancoformapago.setnombre(tipobancoformapago.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoBancoFormaPagos(List<TipoBancoFormaPago> tipobancoformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoBancoFormaPago tipobancoformapago: tipobancoformapagos) {
			tipobancoformapago.setcodigo(tipobancoformapago.getcodigo().trim());
			tipobancoformapago.setnombre(tipobancoformapago.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipobancoformapago.getConCambioAuxiliar()) {
			tipobancoformapago.setIsDeleted(tipobancoformapago.getIsDeletedAuxiliar());	
			tipobancoformapago.setIsNew(tipobancoformapago.getIsNewAuxiliar());	
			tipobancoformapago.setIsChanged(tipobancoformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipobancoformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipobancoformapago.setIsDeletedAuxiliar(false);	
			tipobancoformapago.setIsNewAuxiliar(false);	
			tipobancoformapago.setIsChangedAuxiliar(false);
			
			tipobancoformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBancoFormaPagos(List<TipoBancoFormaPago> tipobancoformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoBancoFormaPago tipobancoformapago : tipobancoformapagos) {
			if(conAsignarBase && tipobancoformapago.getConCambioAuxiliar()) {
				tipobancoformapago.setIsDeleted(tipobancoformapago.getIsDeletedAuxiliar());	
				tipobancoformapago.setIsNew(tipobancoformapago.getIsNewAuxiliar());	
				tipobancoformapago.setIsChanged(tipobancoformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipobancoformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipobancoformapago.setIsDeletedAuxiliar(false);	
				tipobancoformapago.setIsNewAuxiliar(false);	
				tipobancoformapago.setIsChangedAuxiliar(false);
				
				tipobancoformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoBancoFormaPagos(List<TipoBancoFormaPago> tipobancoformapagos,Boolean conEnteros) throws Exception  {
		
		for(TipoBancoFormaPago tipobancoformapago: tipobancoformapagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoBancoFormaPago(List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPago tipobancoformapagoAux) throws Exception  {
		TipoBancoFormaPagoConstantesFunciones.InicializarValoresTipoBancoFormaPago(tipobancoformapagoAux,true);
		
		for(TipoBancoFormaPago tipobancoformapago: tipobancoformapagos) {
			if(tipobancoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoBancoFormaPagoConstantesFunciones.getArrayColumnasGlobalesTipoBancoFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPago tipobancoformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoBancoFormaPago tipobancoformapagoAux: tipobancoformapagos) {
			if(tipobancoformapagoAux!=null && tipobancoformapago!=null) {
				if((tipobancoformapagoAux.getId()==null && tipobancoformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipobancoformapagoAux.getId()!=null && tipobancoformapago.getId()!=null){
					if(tipobancoformapagoAux.getId().equals(tipobancoformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoBancoFormaPago(List<TipoBancoFormaPago> tipobancoformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoBancoFormaPago tipobancoformapago: tipobancoformapagos) {			
			if(tipobancoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoBancoFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoBancoFormaPagoConstantesFunciones.LABEL_ID, TipoBancoFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoFormaPagoConstantesFunciones.LABEL_VERSIONROW, TipoBancoFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA, TipoBancoFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoFormaPagoConstantesFunciones.LABEL_CODIGO, TipoBancoFormaPagoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBancoFormaPagoConstantesFunciones.LABEL_NOMBRE, TipoBancoFormaPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoBancoFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoBancoFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoFormaPagoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBancoFormaPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoFormaPago() throws Exception  {
		return TipoBancoFormaPagoConstantesFunciones.getTiposSeleccionarTipoBancoFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoFormaPago(Boolean conFk) throws Exception  {
		return TipoBancoFormaPagoConstantesFunciones.getTiposSeleccionarTipoBancoFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBancoFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoBancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoFormaPagoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoBancoFormaPagoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBancoFormaPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoBancoFormaPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoBancoFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapagoAux) throws Exception {
		
			tipobancoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoformapagoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBancoFormaPago(List<TipoBancoFormaPago> tipobancoformapagosTemp) throws Exception {
		for(TipoBancoFormaPago tipobancoformapagoAux:tipobancoformapagosTemp) {
			
			tipobancoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobancoformapagoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoBancoFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(BancoFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(BancoFormaPago.class)) {
						classes.add(new Classe(BancoFormaPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBancoFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoBancoFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoFormaPago.class)); continue;
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
	public static void actualizarLista(TipoBancoFormaPago tipobancoformapago,List<TipoBancoFormaPago> tipobancoformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoBancoFormaPago tipobancoformapagoEncontrado=null;
			
			for(TipoBancoFormaPago tipobancoformapagoLocal:tipobancoformapagos) {
				if(tipobancoformapagoLocal.getId().equals(tipobancoformapago.getId())) {
					tipobancoformapagoEncontrado=tipobancoformapagoLocal;
					
					tipobancoformapagoLocal.setIsChanged(tipobancoformapago.getIsChanged());
					tipobancoformapagoLocal.setIsNew(tipobancoformapago.getIsNew());
					tipobancoformapagoLocal.setIsDeleted(tipobancoformapago.getIsDeleted());
					
					tipobancoformapagoLocal.setGeneralEntityOriginal(tipobancoformapago.getGeneralEntityOriginal());
					
					tipobancoformapagoLocal.setId(tipobancoformapago.getId());	
					tipobancoformapagoLocal.setVersionRow(tipobancoformapago.getVersionRow());	
					tipobancoformapagoLocal.setid_empresa(tipobancoformapago.getid_empresa());	
					tipobancoformapagoLocal.setcodigo(tipobancoformapago.getcodigo());	
					tipobancoformapagoLocal.setnombre(tipobancoformapago.getnombre());	
					
					
					tipobancoformapagoLocal.setBancoFormaPagos(tipobancoformapago.getBancoFormaPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipobancoformapago.getIsDeleted()) {
				if(!existe) {
					tipobancoformapagos.add(tipobancoformapago);
				}
			} else {
				if(tipobancoformapagoEncontrado!=null && permiteQuitar)  {
					tipobancoformapagos.remove(tipobancoformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoBancoFormaPago tipobancoformapago,List<TipoBancoFormaPago> tipobancoformapagos) throws Exception {
		try	{			
			for(TipoBancoFormaPago tipobancoformapagoLocal:tipobancoformapagos) {
				if(tipobancoformapagoLocal.getId().equals(tipobancoformapago.getId())) {
					tipobancoformapagoLocal.setIsSelected(tipobancoformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoBancoFormaPago(List<TipoBancoFormaPago> tipobancoformapagosAux) throws Exception {
		//this.tipobancoformapagosAux=tipobancoformapagosAux;
		
		for(TipoBancoFormaPago tipobancoformapagoAux:tipobancoformapagosAux) {
			if(tipobancoformapagoAux.getIsChanged()) {
				tipobancoformapagoAux.setIsChanged(false);
			}		
			
			if(tipobancoformapagoAux.getIsNew()) {
				tipobancoformapagoAux.setIsNew(false);
			}	
			
			if(tipobancoformapagoAux.getIsDeleted()) {
				tipobancoformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapagoAux) throws Exception {
		//this.tipobancoformapagoAux=tipobancoformapagoAux;
		
			if(tipobancoformapagoAux.getIsChanged()) {
				tipobancoformapagoAux.setIsChanged(false);
			}		
			
			if(tipobancoformapagoAux.getIsNew()) {
				tipobancoformapagoAux.setIsNew(false);
			}	
			
			if(tipobancoformapagoAux.getIsDeleted()) {
				tipobancoformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoBancoFormaPago tipobancoformapagoAsignar,TipoBancoFormaPago tipobancoformapago) throws Exception {
		tipobancoformapagoAsignar.setId(tipobancoformapago.getId());	
		tipobancoformapagoAsignar.setVersionRow(tipobancoformapago.getVersionRow());	
		tipobancoformapagoAsignar.setid_empresa(tipobancoformapago.getid_empresa());
		tipobancoformapagoAsignar.setempresa_descripcion(tipobancoformapago.getempresa_descripcion());	
		tipobancoformapagoAsignar.setcodigo(tipobancoformapago.getcodigo());	
		tipobancoformapagoAsignar.setnombre(tipobancoformapago.getnombre());	
	}
	
	public static void inicializarTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago) throws Exception {
		try {
				tipobancoformapago.setId(0L);	
					
				tipobancoformapago.setid_empresa(-1L);	
				tipobancoformapago.setcodigo("");	
				tipobancoformapago.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoBancoFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoFormaPagoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBancoFormaPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoBancoFormaPago(String sTipo,Row row,Workbook workbook,TipoBancoFormaPago tipobancoformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoformapago.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobancoformapago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoBancoFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoBancoFormaPago() {
		return this.sFinalQueryTipoBancoFormaPago;
	}
	
	public void setsFinalQueryTipoBancoFormaPago(String sFinalQueryTipoBancoFormaPago) {
		this.sFinalQueryTipoBancoFormaPago= sFinalQueryTipoBancoFormaPago;
	}
	
	public Border resaltarSeleccionarTipoBancoFormaPago=null;
	
	public Border setResaltarSeleccionarTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoBancoFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoBancoFormaPago() {
		return this.resaltarSeleccionarTipoBancoFormaPago;
	}
	
	public void setResaltarSeleccionarTipoBancoFormaPago(Border borderResaltarSeleccionarTipoBancoFormaPago) {
		this.resaltarSeleccionarTipoBancoFormaPago= borderResaltarSeleccionarTipoBancoFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoBancoFormaPago=null;
	public Boolean mostraridTipoBancoFormaPago=true;
	public Boolean activaridTipoBancoFormaPago=true;

	public Border resaltarid_empresaTipoBancoFormaPago=null;
	public Boolean mostrarid_empresaTipoBancoFormaPago=true;
	public Boolean activarid_empresaTipoBancoFormaPago=true;
	public Boolean cargarid_empresaTipoBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarcodigoTipoBancoFormaPago=null;
	public Boolean mostrarcodigoTipoBancoFormaPago=true;
	public Boolean activarcodigoTipoBancoFormaPago=true;

	public Border resaltarnombreTipoBancoFormaPago=null;
	public Boolean mostrarnombreTipoBancoFormaPago=true;
	public Boolean activarnombreTipoBancoFormaPago=true;

	
	

	public Border setResaltaridTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltaridTipoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoBancoFormaPago() {
		return this.resaltaridTipoBancoFormaPago;
	}

	public void setResaltaridTipoBancoFormaPago(Border borderResaltar) {
		this.resaltaridTipoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostraridTipoBancoFormaPago() {
		return this.mostraridTipoBancoFormaPago;
	}

	public void setMostraridTipoBancoFormaPago(Boolean mostraridTipoBancoFormaPago) {
		this.mostraridTipoBancoFormaPago= mostraridTipoBancoFormaPago;
	}

	public Boolean getActivaridTipoBancoFormaPago() {
		return this.activaridTipoBancoFormaPago;
	}

	public void setActivaridTipoBancoFormaPago(Boolean activaridTipoBancoFormaPago) {
		this.activaridTipoBancoFormaPago= activaridTipoBancoFormaPago;
	}

	public Border setResaltarid_empresaTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoBancoFormaPago() {
		return this.resaltarid_empresaTipoBancoFormaPago;
	}

	public void setResaltarid_empresaTipoBancoFormaPago(Border borderResaltar) {
		this.resaltarid_empresaTipoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoBancoFormaPago() {
		return this.mostrarid_empresaTipoBancoFormaPago;
	}

	public void setMostrarid_empresaTipoBancoFormaPago(Boolean mostrarid_empresaTipoBancoFormaPago) {
		this.mostrarid_empresaTipoBancoFormaPago= mostrarid_empresaTipoBancoFormaPago;
	}

	public Boolean getActivarid_empresaTipoBancoFormaPago() {
		return this.activarid_empresaTipoBancoFormaPago;
	}

	public void setActivarid_empresaTipoBancoFormaPago(Boolean activarid_empresaTipoBancoFormaPago) {
		this.activarid_empresaTipoBancoFormaPago= activarid_empresaTipoBancoFormaPago;
	}

	public Boolean getCargarid_empresaTipoBancoFormaPago() {
		return this.cargarid_empresaTipoBancoFormaPago;
	}

	public void setCargarid_empresaTipoBancoFormaPago(Boolean cargarid_empresaTipoBancoFormaPago) {
		this.cargarid_empresaTipoBancoFormaPago= cargarid_empresaTipoBancoFormaPago;
	}

	public Border setResaltarcodigoTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoBancoFormaPago() {
		return this.resaltarcodigoTipoBancoFormaPago;
	}

	public void setResaltarcodigoTipoBancoFormaPago(Border borderResaltar) {
		this.resaltarcodigoTipoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoBancoFormaPago() {
		return this.mostrarcodigoTipoBancoFormaPago;
	}

	public void setMostrarcodigoTipoBancoFormaPago(Boolean mostrarcodigoTipoBancoFormaPago) {
		this.mostrarcodigoTipoBancoFormaPago= mostrarcodigoTipoBancoFormaPago;
	}

	public Boolean getActivarcodigoTipoBancoFormaPago() {
		return this.activarcodigoTipoBancoFormaPago;
	}

	public void setActivarcodigoTipoBancoFormaPago(Boolean activarcodigoTipoBancoFormaPago) {
		this.activarcodigoTipoBancoFormaPago= activarcodigoTipoBancoFormaPago;
	}

	public Border setResaltarnombreTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoBancoFormaPago() {
		return this.resaltarnombreTipoBancoFormaPago;
	}

	public void setResaltarnombreTipoBancoFormaPago(Border borderResaltar) {
		this.resaltarnombreTipoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoBancoFormaPago() {
		return this.mostrarnombreTipoBancoFormaPago;
	}

	public void setMostrarnombreTipoBancoFormaPago(Boolean mostrarnombreTipoBancoFormaPago) {
		this.mostrarnombreTipoBancoFormaPago= mostrarnombreTipoBancoFormaPago;
	}

	public Boolean getActivarnombreTipoBancoFormaPago() {
		return this.activarnombreTipoBancoFormaPago;
	}

	public void setActivarnombreTipoBancoFormaPago(Boolean activarnombreTipoBancoFormaPago) {
		this.activarnombreTipoBancoFormaPago= activarnombreTipoBancoFormaPago;
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
		
		
		this.setMostraridTipoBancoFormaPago(esInicial);
		this.setMostrarid_empresaTipoBancoFormaPago(esInicial);
		this.setMostrarcodigoTipoBancoFormaPago(esInicial);
		this.setMostrarnombreTipoBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.ID)) {
				this.setMostraridTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoBancoFormaPago(esAsigna);
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
		
		
		this.setActivaridTipoBancoFormaPago(esInicial);
		this.setActivarid_empresaTipoBancoFormaPago(esInicial);
		this.setActivarcodigoTipoBancoFormaPago(esInicial);
		this.setActivarnombreTipoBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.ID)) {
				this.setActivaridTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoBancoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoBancoFormaPago(esInicial);
		this.setResaltarid_empresaTipoBancoFormaPago(esInicial);
		this.setResaltarcodigoTipoBancoFormaPago(esInicial);
		this.setResaltarnombreTipoBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBancoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoBancoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBancoFormaPagoTipoBancoFormaPago=null;

	public Border getResaltarBancoFormaPagoTipoBancoFormaPago() {
		return this.resaltarBancoFormaPagoTipoBancoFormaPago;
	}

	public void setResaltarBancoFormaPagoTipoBancoFormaPago(Border borderResaltarBancoFormaPago) {
		if(borderResaltarBancoFormaPago!=null) {
			this.resaltarBancoFormaPagoTipoBancoFormaPago= borderResaltarBancoFormaPago;
		}
	}

	public Border setResaltarBancoFormaPagoTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarBancoFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipobancoformapagoBeanSwingJInternalFrame.jTtoolBarTipoBancoFormaPago.setBorder(borderResaltarBancoFormaPago);
			
		this.resaltarBancoFormaPagoTipoBancoFormaPago= borderResaltarBancoFormaPago;

		 return borderResaltarBancoFormaPago;
	}



	public Boolean mostrarBancoFormaPagoTipoBancoFormaPago=true;

	public Boolean getMostrarBancoFormaPagoTipoBancoFormaPago() {
		return this.mostrarBancoFormaPagoTipoBancoFormaPago;
	}

	public void setMostrarBancoFormaPagoTipoBancoFormaPago(Boolean visibilidadResaltarBancoFormaPago) {
		this.mostrarBancoFormaPagoTipoBancoFormaPago= visibilidadResaltarBancoFormaPago;
	}



	public Boolean activarBancoFormaPagoTipoBancoFormaPago=true;

	public Boolean gethabilitarResaltarBancoFormaPagoTipoBancoFormaPago() {
		return this.activarBancoFormaPagoTipoBancoFormaPago;
	}

	public void setActivarBancoFormaPagoTipoBancoFormaPago(Boolean habilitarResaltarBancoFormaPago) {
		this.activarBancoFormaPagoTipoBancoFormaPago= habilitarResaltarBancoFormaPago;
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

		this.setMostrarBancoFormaPagoTipoBancoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setMostrarBancoFormaPagoTipoBancoFormaPago(esAsigna);
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

		this.setActivarBancoFormaPagoTipoBancoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setActivarBancoFormaPagoTipoBancoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBancoFormaPagoTipoBancoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setResaltarBancoFormaPagoTipoBancoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoBancoFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaTipoBancoFormaPago() {
		return this.mostrarFK_IdEmpresaTipoBancoFormaPago;
	}

	public void setMostrarFK_IdEmpresaTipoBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoBancoFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoBancoFormaPago=true;

	public Boolean getActivarFK_IdEmpresaTipoBancoFormaPago() {
		return this.activarFK_IdEmpresaTipoBancoFormaPago;
	}

	public void setActivarFK_IdEmpresaTipoBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoBancoFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoBancoFormaPago=null;

	public Border getResaltarFK_IdEmpresaTipoBancoFormaPago() {
		return this.resaltarFK_IdEmpresaTipoBancoFormaPago;
	}

	public void setResaltarFK_IdEmpresaTipoBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBancoFormaPagoBeanSwingJInternalFrame tipobancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoBancoFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
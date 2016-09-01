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


import com.bydan.erp.facturacion.util.TipoDetaFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDetaFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDetaFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDetaFormaPagoConstantesFunciones extends TipoDetaFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDetaFormaPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDetaFormaPago"+TipoDetaFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDetaFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDetaFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDetaFormaPagoConstantesFunciones.SCHEMA+"_"+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDetaFormaPagoConstantesFunciones.SCHEMA+"_"+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDetaFormaPagoConstantesFunciones.SCHEMA+"_"+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDetaFormaPagoConstantesFunciones.SCHEMA+"_"+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDetaFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDetaFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDetaFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDetaFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Detalle Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Detalle Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Deta Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDetaFormaPago";
	public static final String OBJECTNAME="tipodetaformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_deta_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodetaformapago from "+TipoDetaFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipodetaformapago";
	public static String QUERYSELECTNATIVE="select "+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME+".codigo,"+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoDetaFormaPagoConstantesFunciones.SCHEMA+"."+TipoDetaFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoDetaFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDetaFormaPagoConstantesFuncionesAdditional tipodetaformapagoConstantesFuncionesAdditional=null;
	
	public TipoDetaFormaPagoConstantesFuncionesAdditional getTipoDetaFormaPagoConstantesFuncionesAdditional() {
		return this.tipodetaformapagoConstantesFuncionesAdditional;
	}
	
	public void setTipoDetaFormaPagoConstantesFuncionesAdditional(TipoDetaFormaPagoConstantesFuncionesAdditional tipodetaformapagoConstantesFuncionesAdditional) {
		try {
			this.tipodetaformapagoConstantesFuncionesAdditional=tipodetaformapagoConstantesFuncionesAdditional;
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
	
	public static String getTipoDetaFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDetaFormaPagoConstantesFunciones.CODIGO)) {sLabelColumna=TipoDetaFormaPagoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDetaFormaPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDetaFormaPagoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoDetaFormaPagoDescripcion(TipoDetaFormaPago tipodetaformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodetaformapago !=null/* && tipodetaformapago.getId()!=0*/) {
			sDescripcion=tipodetaformapago.getcodigo();//tipodetaformapagotipodetaformapago.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDetaFormaPagoDescripcionDetallado(TipoDetaFormaPago tipodetaformapago) {
		String sDescripcion="";
			
		sDescripcion+=TipoDetaFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipodetaformapago.getId().toString()+",";
		sDescripcion+=TipoDetaFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodetaformapago.getVersionRow().toString()+",";
		sDescripcion+=TipoDetaFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodetaformapago.getid_empresa().toString()+",";
		sDescripcion+=TipoDetaFormaPagoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodetaformapago.getcodigo()+",";
		sDescripcion+=TipoDetaFormaPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodetaformapago.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDetaFormaPagoDescripcion(TipoDetaFormaPago tipodetaformapago,String sValor) throws Exception {			
		if(tipodetaformapago !=null) {
			tipodetaformapago.setcodigo(sValor);;//tipodetaformapagotipodetaformapago.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodetaformapago.setcodigo(tipodetaformapago.getcodigo().trim());
		tipodetaformapago.setnombre(tipodetaformapago.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDetaFormaPagos(List<TipoDetaFormaPago> tipodetaformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDetaFormaPago tipodetaformapago: tipodetaformapagos) {
			tipodetaformapago.setcodigo(tipodetaformapago.getcodigo().trim());
			tipodetaformapago.setnombre(tipodetaformapago.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodetaformapago.getConCambioAuxiliar()) {
			tipodetaformapago.setIsDeleted(tipodetaformapago.getIsDeletedAuxiliar());	
			tipodetaformapago.setIsNew(tipodetaformapago.getIsNewAuxiliar());	
			tipodetaformapago.setIsChanged(tipodetaformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodetaformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodetaformapago.setIsDeletedAuxiliar(false);	
			tipodetaformapago.setIsNewAuxiliar(false);	
			tipodetaformapago.setIsChangedAuxiliar(false);
			
			tipodetaformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetaFormaPagos(List<TipoDetaFormaPago> tipodetaformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDetaFormaPago tipodetaformapago : tipodetaformapagos) {
			if(conAsignarBase && tipodetaformapago.getConCambioAuxiliar()) {
				tipodetaformapago.setIsDeleted(tipodetaformapago.getIsDeletedAuxiliar());	
				tipodetaformapago.setIsNew(tipodetaformapago.getIsNewAuxiliar());	
				tipodetaformapago.setIsChanged(tipodetaformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodetaformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodetaformapago.setIsDeletedAuxiliar(false);	
				tipodetaformapago.setIsNewAuxiliar(false);	
				tipodetaformapago.setIsChangedAuxiliar(false);
				
				tipodetaformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDetaFormaPagos(List<TipoDetaFormaPago> tipodetaformapagos,Boolean conEnteros) throws Exception  {
		
		for(TipoDetaFormaPago tipodetaformapago: tipodetaformapagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDetaFormaPago(List<TipoDetaFormaPago> tipodetaformapagos,TipoDetaFormaPago tipodetaformapagoAux) throws Exception  {
		TipoDetaFormaPagoConstantesFunciones.InicializarValoresTipoDetaFormaPago(tipodetaformapagoAux,true);
		
		for(TipoDetaFormaPago tipodetaformapago: tipodetaformapagos) {
			if(tipodetaformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDetaFormaPagoConstantesFunciones.getArrayColumnasGlobalesTipoDetaFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDetaFormaPago> tipodetaformapagos,TipoDetaFormaPago tipodetaformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDetaFormaPago tipodetaformapagoAux: tipodetaformapagos) {
			if(tipodetaformapagoAux!=null && tipodetaformapago!=null) {
				if((tipodetaformapagoAux.getId()==null && tipodetaformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodetaformapagoAux.getId()!=null && tipodetaformapago.getId()!=null){
					if(tipodetaformapagoAux.getId().equals(tipodetaformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDetaFormaPago(List<TipoDetaFormaPago> tipodetaformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDetaFormaPago tipodetaformapago: tipodetaformapagos) {			
			if(tipodetaformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDetaFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDetaFormaPagoConstantesFunciones.LABEL_ID, TipoDetaFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaFormaPagoConstantesFunciones.LABEL_VERSIONROW, TipoDetaFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA, TipoDetaFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaFormaPagoConstantesFunciones.LABEL_CODIGO, TipoDetaFormaPagoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaFormaPagoConstantesFunciones.LABEL_NOMBRE, TipoDetaFormaPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDetaFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDetaFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaFormaPagoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaFormaPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaFormaPago() throws Exception  {
		return TipoDetaFormaPagoConstantesFunciones.getTiposSeleccionarTipoDetaFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaFormaPago(Boolean conFk) throws Exception  {
		return TipoDetaFormaPagoConstantesFunciones.getTiposSeleccionarTipoDetaFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaFormaPagoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDetaFormaPagoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaFormaPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDetaFormaPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDetaFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapagoAux) throws Exception {
		
			tipodetaformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetaformapagoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetaFormaPago(List<TipoDetaFormaPago> tipodetaformapagosTemp) throws Exception {
		for(TipoDetaFormaPago tipodetaformapagoAux:tipodetaformapagosTemp) {
			
			tipodetaformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetaformapagoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetaFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoDetaFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPago.class)) {
						classes.add(new Classe(DetaFormaPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetaFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDetaFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
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
	public static void actualizarLista(TipoDetaFormaPago tipodetaformapago,List<TipoDetaFormaPago> tipodetaformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDetaFormaPago tipodetaformapagoEncontrado=null;
			
			for(TipoDetaFormaPago tipodetaformapagoLocal:tipodetaformapagos) {
				if(tipodetaformapagoLocal.getId().equals(tipodetaformapago.getId())) {
					tipodetaformapagoEncontrado=tipodetaformapagoLocal;
					
					tipodetaformapagoLocal.setIsChanged(tipodetaformapago.getIsChanged());
					tipodetaformapagoLocal.setIsNew(tipodetaformapago.getIsNew());
					tipodetaformapagoLocal.setIsDeleted(tipodetaformapago.getIsDeleted());
					
					tipodetaformapagoLocal.setGeneralEntityOriginal(tipodetaformapago.getGeneralEntityOriginal());
					
					tipodetaformapagoLocal.setId(tipodetaformapago.getId());	
					tipodetaformapagoLocal.setVersionRow(tipodetaformapago.getVersionRow());	
					tipodetaformapagoLocal.setid_empresa(tipodetaformapago.getid_empresa());	
					tipodetaformapagoLocal.setcodigo(tipodetaformapago.getcodigo());	
					tipodetaformapagoLocal.setnombre(tipodetaformapago.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodetaformapago.getIsDeleted()) {
				if(!existe) {
					tipodetaformapagos.add(tipodetaformapago);
				}
			} else {
				if(tipodetaformapagoEncontrado!=null && permiteQuitar)  {
					tipodetaformapagos.remove(tipodetaformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDetaFormaPago tipodetaformapago,List<TipoDetaFormaPago> tipodetaformapagos) throws Exception {
		try	{			
			for(TipoDetaFormaPago tipodetaformapagoLocal:tipodetaformapagos) {
				if(tipodetaformapagoLocal.getId().equals(tipodetaformapago.getId())) {
					tipodetaformapagoLocal.setIsSelected(tipodetaformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDetaFormaPago(List<TipoDetaFormaPago> tipodetaformapagosAux) throws Exception {
		//this.tipodetaformapagosAux=tipodetaformapagosAux;
		
		for(TipoDetaFormaPago tipodetaformapagoAux:tipodetaformapagosAux) {
			if(tipodetaformapagoAux.getIsChanged()) {
				tipodetaformapagoAux.setIsChanged(false);
			}		
			
			if(tipodetaformapagoAux.getIsNew()) {
				tipodetaformapagoAux.setIsNew(false);
			}	
			
			if(tipodetaformapagoAux.getIsDeleted()) {
				tipodetaformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapagoAux) throws Exception {
		//this.tipodetaformapagoAux=tipodetaformapagoAux;
		
			if(tipodetaformapagoAux.getIsChanged()) {
				tipodetaformapagoAux.setIsChanged(false);
			}		
			
			if(tipodetaformapagoAux.getIsNew()) {
				tipodetaformapagoAux.setIsNew(false);
			}	
			
			if(tipodetaformapagoAux.getIsDeleted()) {
				tipodetaformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDetaFormaPago tipodetaformapagoAsignar,TipoDetaFormaPago tipodetaformapago) throws Exception {
		tipodetaformapagoAsignar.setId(tipodetaformapago.getId());	
		tipodetaformapagoAsignar.setVersionRow(tipodetaformapago.getVersionRow());	
		tipodetaformapagoAsignar.setid_empresa(tipodetaformapago.getid_empresa());
		tipodetaformapagoAsignar.setempresa_descripcion(tipodetaformapago.getempresa_descripcion());	
		tipodetaformapagoAsignar.setcodigo(tipodetaformapago.getcodigo());	
		tipodetaformapagoAsignar.setnombre(tipodetaformapago.getnombre());	
	}
	
	public static void inicializarTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapago) throws Exception {
		try {
				tipodetaformapago.setId(0L);	
					
				tipodetaformapago.setid_empresa(-1L);	
				tipodetaformapago.setcodigo("");	
				tipodetaformapago.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDetaFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaFormaPagoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaFormaPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDetaFormaPago(String sTipo,Row row,Workbook workbook,TipoDetaFormaPago tipodetaformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetaformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetaformapago.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetaformapago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDetaFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDetaFormaPago() {
		return this.sFinalQueryTipoDetaFormaPago;
	}
	
	public void setsFinalQueryTipoDetaFormaPago(String sFinalQueryTipoDetaFormaPago) {
		this.sFinalQueryTipoDetaFormaPago= sFinalQueryTipoDetaFormaPago;
	}
	
	public Border resaltarSeleccionarTipoDetaFormaPago=null;
	
	public Border setResaltarSeleccionarTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodetaformapagoBeanSwingJInternalFrame.jTtoolBarTipoDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDetaFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDetaFormaPago() {
		return this.resaltarSeleccionarTipoDetaFormaPago;
	}
	
	public void setResaltarSeleccionarTipoDetaFormaPago(Border borderResaltarSeleccionarTipoDetaFormaPago) {
		this.resaltarSeleccionarTipoDetaFormaPago= borderResaltarSeleccionarTipoDetaFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDetaFormaPago=null;
	public Boolean mostraridTipoDetaFormaPago=true;
	public Boolean activaridTipoDetaFormaPago=true;

	public Border resaltarid_empresaTipoDetaFormaPago=null;
	public Boolean mostrarid_empresaTipoDetaFormaPago=true;
	public Boolean activarid_empresaTipoDetaFormaPago=true;
	public Boolean cargarid_empresaTipoDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDetaFormaPago=null;
	public Boolean mostrarcodigoTipoDetaFormaPago=true;
	public Boolean activarcodigoTipoDetaFormaPago=true;

	public Border resaltarnombreTipoDetaFormaPago=null;
	public Boolean mostrarnombreTipoDetaFormaPago=true;
	public Boolean activarnombreTipoDetaFormaPago=true;

	
	

	public Border setResaltaridTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetaformapagoBeanSwingJInternalFrame.jTtoolBarTipoDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltaridTipoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDetaFormaPago() {
		return this.resaltaridTipoDetaFormaPago;
	}

	public void setResaltaridTipoDetaFormaPago(Border borderResaltar) {
		this.resaltaridTipoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostraridTipoDetaFormaPago() {
		return this.mostraridTipoDetaFormaPago;
	}

	public void setMostraridTipoDetaFormaPago(Boolean mostraridTipoDetaFormaPago) {
		this.mostraridTipoDetaFormaPago= mostraridTipoDetaFormaPago;
	}

	public Boolean getActivaridTipoDetaFormaPago() {
		return this.activaridTipoDetaFormaPago;
	}

	public void setActivaridTipoDetaFormaPago(Boolean activaridTipoDetaFormaPago) {
		this.activaridTipoDetaFormaPago= activaridTipoDetaFormaPago;
	}

	public Border setResaltarid_empresaTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetaformapagoBeanSwingJInternalFrame.jTtoolBarTipoDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDetaFormaPago() {
		return this.resaltarid_empresaTipoDetaFormaPago;
	}

	public void setResaltarid_empresaTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarid_empresaTipoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDetaFormaPago() {
		return this.mostrarid_empresaTipoDetaFormaPago;
	}

	public void setMostrarid_empresaTipoDetaFormaPago(Boolean mostrarid_empresaTipoDetaFormaPago) {
		this.mostrarid_empresaTipoDetaFormaPago= mostrarid_empresaTipoDetaFormaPago;
	}

	public Boolean getActivarid_empresaTipoDetaFormaPago() {
		return this.activarid_empresaTipoDetaFormaPago;
	}

	public void setActivarid_empresaTipoDetaFormaPago(Boolean activarid_empresaTipoDetaFormaPago) {
		this.activarid_empresaTipoDetaFormaPago= activarid_empresaTipoDetaFormaPago;
	}

	public Boolean getCargarid_empresaTipoDetaFormaPago() {
		return this.cargarid_empresaTipoDetaFormaPago;
	}

	public void setCargarid_empresaTipoDetaFormaPago(Boolean cargarid_empresaTipoDetaFormaPago) {
		this.cargarid_empresaTipoDetaFormaPago= cargarid_empresaTipoDetaFormaPago;
	}

	public Border setResaltarcodigoTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetaformapagoBeanSwingJInternalFrame.jTtoolBarTipoDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDetaFormaPago() {
		return this.resaltarcodigoTipoDetaFormaPago;
	}

	public void setResaltarcodigoTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarcodigoTipoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDetaFormaPago() {
		return this.mostrarcodigoTipoDetaFormaPago;
	}

	public void setMostrarcodigoTipoDetaFormaPago(Boolean mostrarcodigoTipoDetaFormaPago) {
		this.mostrarcodigoTipoDetaFormaPago= mostrarcodigoTipoDetaFormaPago;
	}

	public Boolean getActivarcodigoTipoDetaFormaPago() {
		return this.activarcodigoTipoDetaFormaPago;
	}

	public void setActivarcodigoTipoDetaFormaPago(Boolean activarcodigoTipoDetaFormaPago) {
		this.activarcodigoTipoDetaFormaPago= activarcodigoTipoDetaFormaPago;
	}

	public Border setResaltarnombreTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetaformapagoBeanSwingJInternalFrame.jTtoolBarTipoDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDetaFormaPago() {
		return this.resaltarnombreTipoDetaFormaPago;
	}

	public void setResaltarnombreTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarnombreTipoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDetaFormaPago() {
		return this.mostrarnombreTipoDetaFormaPago;
	}

	public void setMostrarnombreTipoDetaFormaPago(Boolean mostrarnombreTipoDetaFormaPago) {
		this.mostrarnombreTipoDetaFormaPago= mostrarnombreTipoDetaFormaPago;
	}

	public Boolean getActivarnombreTipoDetaFormaPago() {
		return this.activarnombreTipoDetaFormaPago;
	}

	public void setActivarnombreTipoDetaFormaPago(Boolean activarnombreTipoDetaFormaPago) {
		this.activarnombreTipoDetaFormaPago= activarnombreTipoDetaFormaPago;
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
		
		
		this.setMostraridTipoDetaFormaPago(esInicial);
		this.setMostrarid_empresaTipoDetaFormaPago(esInicial);
		this.setMostrarcodigoTipoDetaFormaPago(esInicial);
		this.setMostrarnombreTipoDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.ID)) {
				this.setMostraridTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDetaFormaPago(esAsigna);
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
		
		
		this.setActivaridTipoDetaFormaPago(esInicial);
		this.setActivarid_empresaTipoDetaFormaPago(esInicial);
		this.setActivarcodigoTipoDetaFormaPago(esInicial);
		this.setActivarnombreTipoDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.ID)) {
				this.setActivaridTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDetaFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDetaFormaPago(esInicial);
		this.setResaltarid_empresaTipoDetaFormaPago(esInicial);
		this.setResaltarcodigoTipoDetaFormaPago(esInicial);
		this.setResaltarnombreTipoDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaFormaPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDetaFormaPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDetaFormaPago=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDetaFormaPago() {
		return this.mostrarBusquedaPorCodigoTipoDetaFormaPago;
	}

	public void setMostrarBusquedaPorCodigoTipoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDetaFormaPago=true;

	public Boolean getMostrarBusquedaPorNombreTipoDetaFormaPago() {
		return this.mostrarBusquedaPorNombreTipoDetaFormaPago;
	}

	public void setMostrarBusquedaPorNombreTipoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoDetaFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaTipoDetaFormaPago() {
		return this.mostrarFK_IdEmpresaTipoDetaFormaPago;
	}

	public void setMostrarFK_IdEmpresaTipoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDetaFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDetaFormaPago=true;

	public Boolean getActivarBusquedaPorCodigoTipoDetaFormaPago() {
		return this.activarBusquedaPorCodigoTipoDetaFormaPago;
	}

	public void setActivarBusquedaPorCodigoTipoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDetaFormaPago=true;

	public Boolean getActivarBusquedaPorNombreTipoDetaFormaPago() {
		return this.activarBusquedaPorNombreTipoDetaFormaPago;
	}

	public void setActivarBusquedaPorNombreTipoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoDetaFormaPago=true;

	public Boolean getActivarFK_IdEmpresaTipoDetaFormaPago() {
		return this.activarFK_IdEmpresaTipoDetaFormaPago;
	}

	public void setActivarFK_IdEmpresaTipoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDetaFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDetaFormaPago=null;

	public Border getResaltarBusquedaPorCodigoTipoDetaFormaPago() {
		return this.resaltarBusquedaPorCodigoTipoDetaFormaPago;
	}

	public void setResaltarBusquedaPorCodigoTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDetaFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDetaFormaPago= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDetaFormaPago=null;

	public Border getResaltarBusquedaPorNombreTipoDetaFormaPago() {
		return this.resaltarBusquedaPorNombreTipoDetaFormaPago;
	}

	public void setResaltarBusquedaPorNombreTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDetaFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoDetaFormaPago=null;

	public Border getResaltarFK_IdEmpresaTipoDetaFormaPago() {
		return this.resaltarFK_IdEmpresaTipoDetaFormaPago;
	}

	public void setResaltarFK_IdEmpresaTipoDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaFormaPagoBeanSwingJInternalFrame tipodetaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDetaFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
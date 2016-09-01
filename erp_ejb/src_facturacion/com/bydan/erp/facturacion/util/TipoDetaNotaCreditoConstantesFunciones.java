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


import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDetaNotaCreditoParameterGeneral;

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
final public class TipoDetaNotaCreditoConstantesFunciones extends TipoDetaNotaCreditoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDetaNotaCredito";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDetaNotaCredito"+TipoDetaNotaCreditoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDetaNotaCreditoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDetaNotaCreditoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"_"+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"_"+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"_"+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"_"+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetaNotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetaNotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDetaNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDetaNotaCreditoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDetaNotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDetaNotaCreditoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Detalle Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Detalle Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Deta Nota Credito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDetaNotaCredito";
	public static final String OBJECTNAME="tipodetanotacredito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_deta_nota_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodetanotacredito from "+TipoDetaNotaCreditoConstantesFunciones.SPERSISTENCENAME+" tipodetanotacredito";
	public static String QUERYSELECTNATIVE="select "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".codigo,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".nombre from "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDetaNotaCreditoConstantesFuncionesAdditional tipodetanotacreditoConstantesFuncionesAdditional=null;
	
	public TipoDetaNotaCreditoConstantesFuncionesAdditional getTipoDetaNotaCreditoConstantesFuncionesAdditional() {
		return this.tipodetanotacreditoConstantesFuncionesAdditional;
	}
	
	public void setTipoDetaNotaCreditoConstantesFuncionesAdditional(TipoDetaNotaCreditoConstantesFuncionesAdditional tipodetanotacreditoConstantesFuncionesAdditional) {
		try {
			this.tipodetanotacreditoConstantesFuncionesAdditional=tipodetanotacreditoConstantesFuncionesAdditional;
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
	
	public static String getTipoDetaNotaCreditoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDetaNotaCreditoConstantesFunciones.CODIGO)) {sLabelColumna=TipoDetaNotaCreditoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDetaNotaCreditoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDetaNotaCreditoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoDetaNotaCreditoDescripcion(TipoDetaNotaCredito tipodetanotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodetanotacredito !=null/* && tipodetanotacredito.getId()!=0*/) {
			sDescripcion=tipodetanotacredito.getcodigo();//tipodetanotacreditotipodetanotacredito.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDetaNotaCreditoDescripcionDetallado(TipoDetaNotaCredito tipodetanotacredito) {
		String sDescripcion="";
			
		sDescripcion+=TipoDetaNotaCreditoConstantesFunciones.ID+"=";
		sDescripcion+=tipodetanotacredito.getId().toString()+",";
		sDescripcion+=TipoDetaNotaCreditoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodetanotacredito.getVersionRow().toString()+",";
		sDescripcion+=TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodetanotacredito.getid_empresa().toString()+",";
		sDescripcion+=TipoDetaNotaCreditoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodetanotacredito.getcodigo()+",";
		sDescripcion+=TipoDetaNotaCreditoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodetanotacredito.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDetaNotaCreditoDescripcion(TipoDetaNotaCredito tipodetanotacredito,String sValor) throws Exception {			
		if(tipodetanotacredito !=null) {
			tipodetanotacredito.setcodigo(sValor);;//tipodetanotacreditotipodetanotacredito.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodetanotacredito.setcodigo(tipodetanotacredito.getcodigo().trim());
		tipodetanotacredito.setnombre(tipodetanotacredito.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDetaNotaCreditos(List<TipoDetaNotaCredito> tipodetanotacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDetaNotaCredito tipodetanotacredito: tipodetanotacreditos) {
			tipodetanotacredito.setcodigo(tipodetanotacredito.getcodigo().trim());
			tipodetanotacredito.setnombre(tipodetanotacredito.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodetanotacredito.getConCambioAuxiliar()) {
			tipodetanotacredito.setIsDeleted(tipodetanotacredito.getIsDeletedAuxiliar());	
			tipodetanotacredito.setIsNew(tipodetanotacredito.getIsNewAuxiliar());	
			tipodetanotacredito.setIsChanged(tipodetanotacredito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodetanotacredito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodetanotacredito.setIsDeletedAuxiliar(false);	
			tipodetanotacredito.setIsNewAuxiliar(false);	
			tipodetanotacredito.setIsChangedAuxiliar(false);
			
			tipodetanotacredito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetaNotaCreditos(List<TipoDetaNotaCredito> tipodetanotacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDetaNotaCredito tipodetanotacredito : tipodetanotacreditos) {
			if(conAsignarBase && tipodetanotacredito.getConCambioAuxiliar()) {
				tipodetanotacredito.setIsDeleted(tipodetanotacredito.getIsDeletedAuxiliar());	
				tipodetanotacredito.setIsNew(tipodetanotacredito.getIsNewAuxiliar());	
				tipodetanotacredito.setIsChanged(tipodetanotacredito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodetanotacredito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodetanotacredito.setIsDeletedAuxiliar(false);	
				tipodetanotacredito.setIsNewAuxiliar(false);	
				tipodetanotacredito.setIsChangedAuxiliar(false);
				
				tipodetanotacredito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDetaNotaCreditos(List<TipoDetaNotaCredito> tipodetanotacreditos,Boolean conEnteros) throws Exception  {
		
		for(TipoDetaNotaCredito tipodetanotacredito: tipodetanotacreditos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDetaNotaCredito(List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCredito tipodetanotacreditoAux) throws Exception  {
		TipoDetaNotaCreditoConstantesFunciones.InicializarValoresTipoDetaNotaCredito(tipodetanotacreditoAux,true);
		
		for(TipoDetaNotaCredito tipodetanotacredito: tipodetanotacreditos) {
			if(tipodetanotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDetaNotaCreditoConstantesFunciones.getArrayColumnasGlobalesTipoDetaNotaCredito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDetaNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDetaNotaCredito> tipodetanotacreditos,TipoDetaNotaCredito tipodetanotacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDetaNotaCredito tipodetanotacreditoAux: tipodetanotacreditos) {
			if(tipodetanotacreditoAux!=null && tipodetanotacredito!=null) {
				if((tipodetanotacreditoAux.getId()==null && tipodetanotacredito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodetanotacreditoAux.getId()!=null && tipodetanotacredito.getId()!=null){
					if(tipodetanotacreditoAux.getId().equals(tipodetanotacredito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDetaNotaCredito(List<TipoDetaNotaCredito> tipodetanotacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDetaNotaCredito tipodetanotacredito: tipodetanotacreditos) {			
			if(tipodetanotacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDetaNotaCredito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDetaNotaCreditoConstantesFunciones.LABEL_ID, TipoDetaNotaCreditoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaNotaCreditoConstantesFunciones.LABEL_VERSIONROW, TipoDetaNotaCreditoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA, TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaNotaCreditoConstantesFunciones.LABEL_CODIGO, TipoDetaNotaCreditoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetaNotaCreditoConstantesFunciones.LABEL_NOMBRE, TipoDetaNotaCreditoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDetaNotaCredito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDetaNotaCreditoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaNotaCreditoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaNotaCreditoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetaNotaCreditoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaNotaCredito() throws Exception  {
		return TipoDetaNotaCreditoConstantesFunciones.getTiposSeleccionarTipoDetaNotaCredito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaNotaCredito(Boolean conFk) throws Exception  {
		return TipoDetaNotaCreditoConstantesFunciones.getTiposSeleccionarTipoDetaNotaCredito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetaNotaCredito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaNotaCreditoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDetaNotaCreditoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetaNotaCreditoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDetaNotaCreditoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDetaNotaCredito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacreditoAux) throws Exception {
		
			tipodetanotacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetanotacreditoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetaNotaCredito(List<TipoDetaNotaCredito> tipodetanotacreditosTemp) throws Exception {
		for(TipoDetaNotaCredito tipodetanotacreditoAux:tipodetanotacreditosTemp) {
			
			tipodetanotacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetanotacreditoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetaNotaCreditoConstantesFunciones.getClassesRelationshipsOfTipoDetaNotaCredito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaNotaCredito.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCredito.class)) {
						classes.add(new Classe(DetaNotaCredito.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetaNotaCreditoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDetaNotaCredito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetaNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
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
	public static void actualizarLista(TipoDetaNotaCredito tipodetanotacredito,List<TipoDetaNotaCredito> tipodetanotacreditos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDetaNotaCredito tipodetanotacreditoEncontrado=null;
			
			for(TipoDetaNotaCredito tipodetanotacreditoLocal:tipodetanotacreditos) {
				if(tipodetanotacreditoLocal.getId().equals(tipodetanotacredito.getId())) {
					tipodetanotacreditoEncontrado=tipodetanotacreditoLocal;
					
					tipodetanotacreditoLocal.setIsChanged(tipodetanotacredito.getIsChanged());
					tipodetanotacreditoLocal.setIsNew(tipodetanotacredito.getIsNew());
					tipodetanotacreditoLocal.setIsDeleted(tipodetanotacredito.getIsDeleted());
					
					tipodetanotacreditoLocal.setGeneralEntityOriginal(tipodetanotacredito.getGeneralEntityOriginal());
					
					tipodetanotacreditoLocal.setId(tipodetanotacredito.getId());	
					tipodetanotacreditoLocal.setVersionRow(tipodetanotacredito.getVersionRow());	
					tipodetanotacreditoLocal.setid_empresa(tipodetanotacredito.getid_empresa());	
					tipodetanotacreditoLocal.setcodigo(tipodetanotacredito.getcodigo());	
					tipodetanotacreditoLocal.setnombre(tipodetanotacredito.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodetanotacredito.getIsDeleted()) {
				if(!existe) {
					tipodetanotacreditos.add(tipodetanotacredito);
				}
			} else {
				if(tipodetanotacreditoEncontrado!=null && permiteQuitar)  {
					tipodetanotacreditos.remove(tipodetanotacreditoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDetaNotaCredito tipodetanotacredito,List<TipoDetaNotaCredito> tipodetanotacreditos) throws Exception {
		try	{			
			for(TipoDetaNotaCredito tipodetanotacreditoLocal:tipodetanotacreditos) {
				if(tipodetanotacreditoLocal.getId().equals(tipodetanotacredito.getId())) {
					tipodetanotacreditoLocal.setIsSelected(tipodetanotacredito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDetaNotaCredito(List<TipoDetaNotaCredito> tipodetanotacreditosAux) throws Exception {
		//this.tipodetanotacreditosAux=tipodetanotacreditosAux;
		
		for(TipoDetaNotaCredito tipodetanotacreditoAux:tipodetanotacreditosAux) {
			if(tipodetanotacreditoAux.getIsChanged()) {
				tipodetanotacreditoAux.setIsChanged(false);
			}		
			
			if(tipodetanotacreditoAux.getIsNew()) {
				tipodetanotacreditoAux.setIsNew(false);
			}	
			
			if(tipodetanotacreditoAux.getIsDeleted()) {
				tipodetanotacreditoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacreditoAux) throws Exception {
		//this.tipodetanotacreditoAux=tipodetanotacreditoAux;
		
			if(tipodetanotacreditoAux.getIsChanged()) {
				tipodetanotacreditoAux.setIsChanged(false);
			}		
			
			if(tipodetanotacreditoAux.getIsNew()) {
				tipodetanotacreditoAux.setIsNew(false);
			}	
			
			if(tipodetanotacreditoAux.getIsDeleted()) {
				tipodetanotacreditoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDetaNotaCredito tipodetanotacreditoAsignar,TipoDetaNotaCredito tipodetanotacredito) throws Exception {
		tipodetanotacreditoAsignar.setId(tipodetanotacredito.getId());	
		tipodetanotacreditoAsignar.setVersionRow(tipodetanotacredito.getVersionRow());	
		tipodetanotacreditoAsignar.setid_empresa(tipodetanotacredito.getid_empresa());
		tipodetanotacreditoAsignar.setempresa_descripcion(tipodetanotacredito.getempresa_descripcion());	
		tipodetanotacreditoAsignar.setcodigo(tipodetanotacredito.getcodigo());	
		tipodetanotacreditoAsignar.setnombre(tipodetanotacredito.getnombre());	
	}
	
	public static void inicializarTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito) throws Exception {
		try {
				tipodetanotacredito.setId(0L);	
					
				tipodetanotacredito.setid_empresa(-1L);	
				tipodetanotacredito.setcodigo("");	
				tipodetanotacredito.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDetaNotaCredito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaNotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaNotaCreditoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetaNotaCreditoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDetaNotaCredito(String sTipo,Row row,Workbook workbook,TipoDetaNotaCredito tipodetanotacredito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetanotacredito.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetanotacredito.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetanotacredito.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDetaNotaCredito=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDetaNotaCredito() {
		return this.sFinalQueryTipoDetaNotaCredito;
	}
	
	public void setsFinalQueryTipoDetaNotaCredito(String sFinalQueryTipoDetaNotaCredito) {
		this.sFinalQueryTipoDetaNotaCredito= sFinalQueryTipoDetaNotaCredito;
	}
	
	public Border resaltarSeleccionarTipoDetaNotaCredito=null;
	
	public Border setResaltarSeleccionarTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodetanotacreditoBeanSwingJInternalFrame.jTtoolBarTipoDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDetaNotaCredito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDetaNotaCredito() {
		return this.resaltarSeleccionarTipoDetaNotaCredito;
	}
	
	public void setResaltarSeleccionarTipoDetaNotaCredito(Border borderResaltarSeleccionarTipoDetaNotaCredito) {
		this.resaltarSeleccionarTipoDetaNotaCredito= borderResaltarSeleccionarTipoDetaNotaCredito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDetaNotaCredito=null;
	public Boolean mostraridTipoDetaNotaCredito=true;
	public Boolean activaridTipoDetaNotaCredito=true;

	public Border resaltarid_empresaTipoDetaNotaCredito=null;
	public Boolean mostrarid_empresaTipoDetaNotaCredito=true;
	public Boolean activarid_empresaTipoDetaNotaCredito=true;
	public Boolean cargarid_empresaTipoDetaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDetaNotaCredito=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDetaNotaCredito=null;
	public Boolean mostrarcodigoTipoDetaNotaCredito=true;
	public Boolean activarcodigoTipoDetaNotaCredito=true;

	public Border resaltarnombreTipoDetaNotaCredito=null;
	public Boolean mostrarnombreTipoDetaNotaCredito=true;
	public Boolean activarnombreTipoDetaNotaCredito=true;

	
	

	public Border setResaltaridTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetanotacreditoBeanSwingJInternalFrame.jTtoolBarTipoDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltaridTipoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDetaNotaCredito() {
		return this.resaltaridTipoDetaNotaCredito;
	}

	public void setResaltaridTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltaridTipoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostraridTipoDetaNotaCredito() {
		return this.mostraridTipoDetaNotaCredito;
	}

	public void setMostraridTipoDetaNotaCredito(Boolean mostraridTipoDetaNotaCredito) {
		this.mostraridTipoDetaNotaCredito= mostraridTipoDetaNotaCredito;
	}

	public Boolean getActivaridTipoDetaNotaCredito() {
		return this.activaridTipoDetaNotaCredito;
	}

	public void setActivaridTipoDetaNotaCredito(Boolean activaridTipoDetaNotaCredito) {
		this.activaridTipoDetaNotaCredito= activaridTipoDetaNotaCredito;
	}

	public Border setResaltarid_empresaTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetanotacreditoBeanSwingJInternalFrame.jTtoolBarTipoDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDetaNotaCredito() {
		return this.resaltarid_empresaTipoDetaNotaCredito;
	}

	public void setResaltarid_empresaTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarid_empresaTipoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDetaNotaCredito() {
		return this.mostrarid_empresaTipoDetaNotaCredito;
	}

	public void setMostrarid_empresaTipoDetaNotaCredito(Boolean mostrarid_empresaTipoDetaNotaCredito) {
		this.mostrarid_empresaTipoDetaNotaCredito= mostrarid_empresaTipoDetaNotaCredito;
	}

	public Boolean getActivarid_empresaTipoDetaNotaCredito() {
		return this.activarid_empresaTipoDetaNotaCredito;
	}

	public void setActivarid_empresaTipoDetaNotaCredito(Boolean activarid_empresaTipoDetaNotaCredito) {
		this.activarid_empresaTipoDetaNotaCredito= activarid_empresaTipoDetaNotaCredito;
	}

	public Boolean getCargarid_empresaTipoDetaNotaCredito() {
		return this.cargarid_empresaTipoDetaNotaCredito;
	}

	public void setCargarid_empresaTipoDetaNotaCredito(Boolean cargarid_empresaTipoDetaNotaCredito) {
		this.cargarid_empresaTipoDetaNotaCredito= cargarid_empresaTipoDetaNotaCredito;
	}

	public Border setResaltarcodigoTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetanotacreditoBeanSwingJInternalFrame.jTtoolBarTipoDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDetaNotaCredito() {
		return this.resaltarcodigoTipoDetaNotaCredito;
	}

	public void setResaltarcodigoTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarcodigoTipoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDetaNotaCredito() {
		return this.mostrarcodigoTipoDetaNotaCredito;
	}

	public void setMostrarcodigoTipoDetaNotaCredito(Boolean mostrarcodigoTipoDetaNotaCredito) {
		this.mostrarcodigoTipoDetaNotaCredito= mostrarcodigoTipoDetaNotaCredito;
	}

	public Boolean getActivarcodigoTipoDetaNotaCredito() {
		return this.activarcodigoTipoDetaNotaCredito;
	}

	public void setActivarcodigoTipoDetaNotaCredito(Boolean activarcodigoTipoDetaNotaCredito) {
		this.activarcodigoTipoDetaNotaCredito= activarcodigoTipoDetaNotaCredito;
	}

	public Border setResaltarnombreTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetanotacreditoBeanSwingJInternalFrame.jTtoolBarTipoDetaNotaCredito.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDetaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDetaNotaCredito() {
		return this.resaltarnombreTipoDetaNotaCredito;
	}

	public void setResaltarnombreTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarnombreTipoDetaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDetaNotaCredito() {
		return this.mostrarnombreTipoDetaNotaCredito;
	}

	public void setMostrarnombreTipoDetaNotaCredito(Boolean mostrarnombreTipoDetaNotaCredito) {
		this.mostrarnombreTipoDetaNotaCredito= mostrarnombreTipoDetaNotaCredito;
	}

	public Boolean getActivarnombreTipoDetaNotaCredito() {
		return this.activarnombreTipoDetaNotaCredito;
	}

	public void setActivarnombreTipoDetaNotaCredito(Boolean activarnombreTipoDetaNotaCredito) {
		this.activarnombreTipoDetaNotaCredito= activarnombreTipoDetaNotaCredito;
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
		
		
		this.setMostraridTipoDetaNotaCredito(esInicial);
		this.setMostrarid_empresaTipoDetaNotaCredito(esInicial);
		this.setMostrarcodigoTipoDetaNotaCredito(esInicial);
		this.setMostrarnombreTipoDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.ID)) {
				this.setMostraridTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDetaNotaCredito(esAsigna);
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
		
		
		this.setActivaridTipoDetaNotaCredito(esInicial);
		this.setActivarid_empresaTipoDetaNotaCredito(esInicial);
		this.setActivarcodigoTipoDetaNotaCredito(esInicial);
		this.setActivarnombreTipoDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.ID)) {
				this.setActivaridTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDetaNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDetaNotaCredito(esInicial);
		this.setResaltarid_empresaTipoDetaNotaCredito(esInicial);
		this.setResaltarcodigoTipoDetaNotaCredito(esInicial);
		this.setResaltarnombreTipoDetaNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.ID)) {
				this.setResaltaridTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDetaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetaNotaCreditoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDetaNotaCredito(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDetaNotaCredito=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDetaNotaCredito() {
		return this.mostrarBusquedaPorCodigoTipoDetaNotaCredito;
	}

	public void setMostrarBusquedaPorCodigoTipoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDetaNotaCredito=true;

	public Boolean getMostrarBusquedaPorNombreTipoDetaNotaCredito() {
		return this.mostrarBusquedaPorNombreTipoDetaNotaCredito;
	}

	public void setMostrarBusquedaPorNombreTipoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDetaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoDetaNotaCredito=true;

	public Boolean getMostrarFK_IdEmpresaTipoDetaNotaCredito() {
		return this.mostrarFK_IdEmpresaTipoDetaNotaCredito;
	}

	public void setMostrarFK_IdEmpresaTipoDetaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDetaNotaCredito= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDetaNotaCredito=true;

	public Boolean getActivarBusquedaPorCodigoTipoDetaNotaCredito() {
		return this.activarBusquedaPorCodigoTipoDetaNotaCredito;
	}

	public void setActivarBusquedaPorCodigoTipoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDetaNotaCredito=true;

	public Boolean getActivarBusquedaPorNombreTipoDetaNotaCredito() {
		return this.activarBusquedaPorNombreTipoDetaNotaCredito;
	}

	public void setActivarBusquedaPorNombreTipoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDetaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoDetaNotaCredito=true;

	public Boolean getActivarFK_IdEmpresaTipoDetaNotaCredito() {
		return this.activarFK_IdEmpresaTipoDetaNotaCredito;
	}

	public void setActivarFK_IdEmpresaTipoDetaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDetaNotaCredito= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDetaNotaCredito=null;

	public Border getResaltarBusquedaPorCodigoTipoDetaNotaCredito() {
		return this.resaltarBusquedaPorCodigoTipoDetaNotaCredito;
	}

	public void setResaltarBusquedaPorCodigoTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDetaNotaCredito=null;

	public Border getResaltarBusquedaPorNombreTipoDetaNotaCredito() {
		return this.resaltarBusquedaPorNombreTipoDetaNotaCredito;
	}

	public void setResaltarBusquedaPorNombreTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDetaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoDetaNotaCredito=null;

	public Border getResaltarFK_IdEmpresaTipoDetaNotaCredito() {
		return this.resaltarFK_IdEmpresaTipoDetaNotaCredito;
	}

	public void setResaltarFK_IdEmpresaTipoDetaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDetaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDetaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetaNotaCreditoBeanSwingJInternalFrame tipodetanotacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDetaNotaCredito= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
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


import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDetalleDocumentoConstantesFunciones extends TipoDetalleDocumentoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDetalleDocumento";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDetalleDocumento"+TipoDetalleDocumentoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDetalleDocumentoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDetalleDocumentoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDetalleDocumentoConstantesFunciones.SCHEMA+"_"+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDetalleDocumentoConstantesFunciones.SCHEMA+"_"+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDetalleDocumentoConstantesFunciones.SCHEMA+"_"+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDetalleDocumentoConstantesFunciones.SCHEMA+"_"+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDetalleDocumentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDetalleDocumentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDetalleDocumentoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDetalleDocumentoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDetalleDocumentoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDetalleDocumentoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Detalle Documentos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Detalle Documento";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Detalle Documento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDetalleDocumento";
	public static final String OBJECTNAME="tipodetalledocumento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_detalle_documento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodetalledocumento from "+TipoDetalleDocumentoConstantesFunciones.SPERSISTENCENAME+" tipodetalledocumento";
	public static String QUERYSELECTNATIVE="select "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".codigo,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".nombre from "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDetalleDocumentoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDetalleDocumentoConstantesFuncionesAdditional tipodetalledocumentoConstantesFuncionesAdditional=null;
	
	public TipoDetalleDocumentoConstantesFuncionesAdditional getTipoDetalleDocumentoConstantesFuncionesAdditional() {
		return this.tipodetalledocumentoConstantesFuncionesAdditional;
	}
	
	public void setTipoDetalleDocumentoConstantesFuncionesAdditional(TipoDetalleDocumentoConstantesFuncionesAdditional tipodetalledocumentoConstantesFuncionesAdditional) {
		try {
			this.tipodetalledocumentoConstantesFuncionesAdditional=tipodetalledocumentoConstantesFuncionesAdditional;
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
	
	public static String getTipoDetalleDocumentoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDetalleDocumentoConstantesFunciones.CODIGO)) {sLabelColumna=TipoDetalleDocumentoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDetalleDocumentoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDetalleDocumentoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoDetalleDocumentoDescripcion(TipoDetalleDocumento tipodetalledocumento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodetalledocumento !=null/* && tipodetalledocumento.getId()!=0*/) {
			sDescripcion=tipodetalledocumento.getcodigo();//tipodetalledocumentotipodetalledocumento.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDetalleDocumentoDescripcionDetallado(TipoDetalleDocumento tipodetalledocumento) {
		String sDescripcion="";
			
		sDescripcion+=TipoDetalleDocumentoConstantesFunciones.ID+"=";
		sDescripcion+=tipodetalledocumento.getId().toString()+",";
		sDescripcion+=TipoDetalleDocumentoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodetalledocumento.getVersionRow().toString()+",";
		sDescripcion+=TipoDetalleDocumentoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodetalledocumento.getid_empresa().toString()+",";
		sDescripcion+=TipoDetalleDocumentoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodetalledocumento.getcodigo()+",";
		sDescripcion+=TipoDetalleDocumentoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodetalledocumento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDetalleDocumentoDescripcion(TipoDetalleDocumento tipodetalledocumento,String sValor) throws Exception {			
		if(tipodetalledocumento !=null) {
			tipodetalledocumento.setcodigo(sValor);;//tipodetalledocumentotipodetalledocumento.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodetalledocumento.setcodigo(tipodetalledocumento.getcodigo().trim());
		tipodetalledocumento.setnombre(tipodetalledocumento.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDetalleDocumentos(List<TipoDetalleDocumento> tipodetalledocumentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDetalleDocumento tipodetalledocumento: tipodetalledocumentos) {
			tipodetalledocumento.setcodigo(tipodetalledocumento.getcodigo().trim());
			tipodetalledocumento.setnombre(tipodetalledocumento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodetalledocumento.getConCambioAuxiliar()) {
			tipodetalledocumento.setIsDeleted(tipodetalledocumento.getIsDeletedAuxiliar());	
			tipodetalledocumento.setIsNew(tipodetalledocumento.getIsNewAuxiliar());	
			tipodetalledocumento.setIsChanged(tipodetalledocumento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodetalledocumento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodetalledocumento.setIsDeletedAuxiliar(false);	
			tipodetalledocumento.setIsNewAuxiliar(false);	
			tipodetalledocumento.setIsChangedAuxiliar(false);
			
			tipodetalledocumento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDetalleDocumentos(List<TipoDetalleDocumento> tipodetalledocumentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDetalleDocumento tipodetalledocumento : tipodetalledocumentos) {
			if(conAsignarBase && tipodetalledocumento.getConCambioAuxiliar()) {
				tipodetalledocumento.setIsDeleted(tipodetalledocumento.getIsDeletedAuxiliar());	
				tipodetalledocumento.setIsNew(tipodetalledocumento.getIsNewAuxiliar());	
				tipodetalledocumento.setIsChanged(tipodetalledocumento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodetalledocumento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodetalledocumento.setIsDeletedAuxiliar(false);	
				tipodetalledocumento.setIsNewAuxiliar(false);	
				tipodetalledocumento.setIsChangedAuxiliar(false);
				
				tipodetalledocumento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDetalleDocumentos(List<TipoDetalleDocumento> tipodetalledocumentos,Boolean conEnteros) throws Exception  {
		
		for(TipoDetalleDocumento tipodetalledocumento: tipodetalledocumentos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDetalleDocumento(List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumento tipodetalledocumentoAux) throws Exception  {
		TipoDetalleDocumentoConstantesFunciones.InicializarValoresTipoDetalleDocumento(tipodetalledocumentoAux,true);
		
		for(TipoDetalleDocumento tipodetalledocumento: tipodetalledocumentos) {
			if(tipodetalledocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDetalleDocumentoConstantesFunciones.getArrayColumnasGlobalesTipoDetalleDocumento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDetalleDocumento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumento tipodetalledocumento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDetalleDocumento tipodetalledocumentoAux: tipodetalledocumentos) {
			if(tipodetalledocumentoAux!=null && tipodetalledocumento!=null) {
				if((tipodetalledocumentoAux.getId()==null && tipodetalledocumento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodetalledocumentoAux.getId()!=null && tipodetalledocumento.getId()!=null){
					if(tipodetalledocumentoAux.getId().equals(tipodetalledocumento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDetalleDocumento(List<TipoDetalleDocumento> tipodetalledocumentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDetalleDocumento tipodetalledocumento: tipodetalledocumentos) {			
			if(tipodetalledocumento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDetalleDocumento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDetalleDocumentoConstantesFunciones.LABEL_ID, TipoDetalleDocumentoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleDocumentoConstantesFunciones.LABEL_VERSIONROW, TipoDetalleDocumentoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA, TipoDetalleDocumentoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleDocumentoConstantesFunciones.LABEL_CODIGO, TipoDetalleDocumentoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDetalleDocumentoConstantesFunciones.LABEL_NOMBRE, TipoDetalleDocumentoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDetalleDocumento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleDocumentoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleDocumentoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleDocumentoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleDocumentoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDetalleDocumentoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleDocumento() throws Exception  {
		return TipoDetalleDocumentoConstantesFunciones.getTiposSeleccionarTipoDetalleDocumento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleDocumento(Boolean conFk) throws Exception  {
		return TipoDetalleDocumentoConstantesFunciones.getTiposSeleccionarTipoDetalleDocumento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDetalleDocumento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetalleDocumentoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDetalleDocumentoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDetalleDocumentoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDetalleDocumentoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDetalleDocumento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumentoAux) throws Exception {
		
			tipodetalledocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetalledocumentoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDetalleDocumento(List<TipoDetalleDocumento> tipodetalledocumentosTemp) throws Exception {
		for(TipoDetalleDocumento tipodetalledocumentoAux:tipodetalledocumentosTemp) {
			
			tipodetalledocumentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodetalledocumentoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetalleDocumentoConstantesFunciones.getClassesRelationshipsOfTipoDetalleDocumento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleDocumento.class)) {
						classes.add(new Classe(DetalleDocumento.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDetalleDocumentoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDetalleDocumento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDetalleDocumento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleDocumento.class)); continue;
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
	public static void actualizarLista(TipoDetalleDocumento tipodetalledocumento,List<TipoDetalleDocumento> tipodetalledocumentos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDetalleDocumento tipodetalledocumentoEncontrado=null;
			
			for(TipoDetalleDocumento tipodetalledocumentoLocal:tipodetalledocumentos) {
				if(tipodetalledocumentoLocal.getId().equals(tipodetalledocumento.getId())) {
					tipodetalledocumentoEncontrado=tipodetalledocumentoLocal;
					
					tipodetalledocumentoLocal.setIsChanged(tipodetalledocumento.getIsChanged());
					tipodetalledocumentoLocal.setIsNew(tipodetalledocumento.getIsNew());
					tipodetalledocumentoLocal.setIsDeleted(tipodetalledocumento.getIsDeleted());
					
					tipodetalledocumentoLocal.setGeneralEntityOriginal(tipodetalledocumento.getGeneralEntityOriginal());
					
					tipodetalledocumentoLocal.setId(tipodetalledocumento.getId());	
					tipodetalledocumentoLocal.setVersionRow(tipodetalledocumento.getVersionRow());	
					tipodetalledocumentoLocal.setid_empresa(tipodetalledocumento.getid_empresa());	
					tipodetalledocumentoLocal.setcodigo(tipodetalledocumento.getcodigo());	
					tipodetalledocumentoLocal.setnombre(tipodetalledocumento.getnombre());	
					
					
					tipodetalledocumentoLocal.setDetalleDocumentos(tipodetalledocumento.getDetalleDocumentos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodetalledocumento.getIsDeleted()) {
				if(!existe) {
					tipodetalledocumentos.add(tipodetalledocumento);
				}
			} else {
				if(tipodetalledocumentoEncontrado!=null && permiteQuitar)  {
					tipodetalledocumentos.remove(tipodetalledocumentoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDetalleDocumento tipodetalledocumento,List<TipoDetalleDocumento> tipodetalledocumentos) throws Exception {
		try	{			
			for(TipoDetalleDocumento tipodetalledocumentoLocal:tipodetalledocumentos) {
				if(tipodetalledocumentoLocal.getId().equals(tipodetalledocumento.getId())) {
					tipodetalledocumentoLocal.setIsSelected(tipodetalledocumento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDetalleDocumento(List<TipoDetalleDocumento> tipodetalledocumentosAux) throws Exception {
		//this.tipodetalledocumentosAux=tipodetalledocumentosAux;
		
		for(TipoDetalleDocumento tipodetalledocumentoAux:tipodetalledocumentosAux) {
			if(tipodetalledocumentoAux.getIsChanged()) {
				tipodetalledocumentoAux.setIsChanged(false);
			}		
			
			if(tipodetalledocumentoAux.getIsNew()) {
				tipodetalledocumentoAux.setIsNew(false);
			}	
			
			if(tipodetalledocumentoAux.getIsDeleted()) {
				tipodetalledocumentoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumentoAux) throws Exception {
		//this.tipodetalledocumentoAux=tipodetalledocumentoAux;
		
			if(tipodetalledocumentoAux.getIsChanged()) {
				tipodetalledocumentoAux.setIsChanged(false);
			}		
			
			if(tipodetalledocumentoAux.getIsNew()) {
				tipodetalledocumentoAux.setIsNew(false);
			}	
			
			if(tipodetalledocumentoAux.getIsDeleted()) {
				tipodetalledocumentoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDetalleDocumento tipodetalledocumentoAsignar,TipoDetalleDocumento tipodetalledocumento) throws Exception {
		tipodetalledocumentoAsignar.setId(tipodetalledocumento.getId());	
		tipodetalledocumentoAsignar.setVersionRow(tipodetalledocumento.getVersionRow());	
		tipodetalledocumentoAsignar.setid_empresa(tipodetalledocumento.getid_empresa());
		tipodetalledocumentoAsignar.setempresa_descripcion(tipodetalledocumento.getempresa_descripcion());	
		tipodetalledocumentoAsignar.setcodigo(tipodetalledocumento.getcodigo());	
		tipodetalledocumentoAsignar.setnombre(tipodetalledocumento.getnombre());	
	}
	
	public static void inicializarTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento) throws Exception {
		try {
				tipodetalledocumento.setId(0L);	
					
				tipodetalledocumento.setid_empresa(-1L);	
				tipodetalledocumento.setcodigo("");	
				tipodetalledocumento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDetalleDocumento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetalleDocumentoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetalleDocumentoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDetalleDocumentoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDetalleDocumento(String sTipo,Row row,Workbook workbook,TipoDetalleDocumento tipodetalledocumento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetalledocumento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetalledocumento.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodetalledocumento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDetalleDocumento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDetalleDocumento() {
		return this.sFinalQueryTipoDetalleDocumento;
	}
	
	public void setsFinalQueryTipoDetalleDocumento(String sFinalQueryTipoDetalleDocumento) {
		this.sFinalQueryTipoDetalleDocumento= sFinalQueryTipoDetalleDocumento;
	}
	
	public Border resaltarSeleccionarTipoDetalleDocumento=null;
	
	public Border setResaltarSeleccionarTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDetalleDocumento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDetalleDocumento() {
		return this.resaltarSeleccionarTipoDetalleDocumento;
	}
	
	public void setResaltarSeleccionarTipoDetalleDocumento(Border borderResaltarSeleccionarTipoDetalleDocumento) {
		this.resaltarSeleccionarTipoDetalleDocumento= borderResaltarSeleccionarTipoDetalleDocumento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDetalleDocumento=null;
	public Boolean mostraridTipoDetalleDocumento=true;
	public Boolean activaridTipoDetalleDocumento=true;

	public Border resaltarid_empresaTipoDetalleDocumento=null;
	public Boolean mostrarid_empresaTipoDetalleDocumento=true;
	public Boolean activarid_empresaTipoDetalleDocumento=true;
	public Boolean cargarid_empresaTipoDetalleDocumento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDetalleDocumento=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDetalleDocumento=null;
	public Boolean mostrarcodigoTipoDetalleDocumento=true;
	public Boolean activarcodigoTipoDetalleDocumento=true;

	public Border resaltarnombreTipoDetalleDocumento=null;
	public Boolean mostrarnombreTipoDetalleDocumento=true;
	public Boolean activarnombreTipoDetalleDocumento=true;

	
	

	public Border setResaltaridTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltaridTipoDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDetalleDocumento() {
		return this.resaltaridTipoDetalleDocumento;
	}

	public void setResaltaridTipoDetalleDocumento(Border borderResaltar) {
		this.resaltaridTipoDetalleDocumento= borderResaltar;
	}

	public Boolean getMostraridTipoDetalleDocumento() {
		return this.mostraridTipoDetalleDocumento;
	}

	public void setMostraridTipoDetalleDocumento(Boolean mostraridTipoDetalleDocumento) {
		this.mostraridTipoDetalleDocumento= mostraridTipoDetalleDocumento;
	}

	public Boolean getActivaridTipoDetalleDocumento() {
		return this.activaridTipoDetalleDocumento;
	}

	public void setActivaridTipoDetalleDocumento(Boolean activaridTipoDetalleDocumento) {
		this.activaridTipoDetalleDocumento= activaridTipoDetalleDocumento;
	}

	public Border setResaltarid_empresaTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDetalleDocumento() {
		return this.resaltarid_empresaTipoDetalleDocumento;
	}

	public void setResaltarid_empresaTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarid_empresaTipoDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDetalleDocumento() {
		return this.mostrarid_empresaTipoDetalleDocumento;
	}

	public void setMostrarid_empresaTipoDetalleDocumento(Boolean mostrarid_empresaTipoDetalleDocumento) {
		this.mostrarid_empresaTipoDetalleDocumento= mostrarid_empresaTipoDetalleDocumento;
	}

	public Boolean getActivarid_empresaTipoDetalleDocumento() {
		return this.activarid_empresaTipoDetalleDocumento;
	}

	public void setActivarid_empresaTipoDetalleDocumento(Boolean activarid_empresaTipoDetalleDocumento) {
		this.activarid_empresaTipoDetalleDocumento= activarid_empresaTipoDetalleDocumento;
	}

	public Boolean getCargarid_empresaTipoDetalleDocumento() {
		return this.cargarid_empresaTipoDetalleDocumento;
	}

	public void setCargarid_empresaTipoDetalleDocumento(Boolean cargarid_empresaTipoDetalleDocumento) {
		this.cargarid_empresaTipoDetalleDocumento= cargarid_empresaTipoDetalleDocumento;
	}

	public Border setResaltarcodigoTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDetalleDocumento() {
		return this.resaltarcodigoTipoDetalleDocumento;
	}

	public void setResaltarcodigoTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarcodigoTipoDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDetalleDocumento() {
		return this.mostrarcodigoTipoDetalleDocumento;
	}

	public void setMostrarcodigoTipoDetalleDocumento(Boolean mostrarcodigoTipoDetalleDocumento) {
		this.mostrarcodigoTipoDetalleDocumento= mostrarcodigoTipoDetalleDocumento;
	}

	public Boolean getActivarcodigoTipoDetalleDocumento() {
		return this.activarcodigoTipoDetalleDocumento;
	}

	public void setActivarcodigoTipoDetalleDocumento(Boolean activarcodigoTipoDetalleDocumento) {
		this.activarcodigoTipoDetalleDocumento= activarcodigoTipoDetalleDocumento;
	}

	public Border setResaltarnombreTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDetalleDocumento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDetalleDocumento() {
		return this.resaltarnombreTipoDetalleDocumento;
	}

	public void setResaltarnombreTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarnombreTipoDetalleDocumento= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDetalleDocumento() {
		return this.mostrarnombreTipoDetalleDocumento;
	}

	public void setMostrarnombreTipoDetalleDocumento(Boolean mostrarnombreTipoDetalleDocumento) {
		this.mostrarnombreTipoDetalleDocumento= mostrarnombreTipoDetalleDocumento;
	}

	public Boolean getActivarnombreTipoDetalleDocumento() {
		return this.activarnombreTipoDetalleDocumento;
	}

	public void setActivarnombreTipoDetalleDocumento(Boolean activarnombreTipoDetalleDocumento) {
		this.activarnombreTipoDetalleDocumento= activarnombreTipoDetalleDocumento;
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
		
		
		this.setMostraridTipoDetalleDocumento(esInicial);
		this.setMostrarid_empresaTipoDetalleDocumento(esInicial);
		this.setMostrarcodigoTipoDetalleDocumento(esInicial);
		this.setMostrarnombreTipoDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.ID)) {
				this.setMostraridTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDetalleDocumento(esAsigna);
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
		
		
		this.setActivaridTipoDetalleDocumento(esInicial);
		this.setActivarid_empresaTipoDetalleDocumento(esInicial);
		this.setActivarcodigoTipoDetalleDocumento(esInicial);
		this.setActivarnombreTipoDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.ID)) {
				this.setActivaridTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDetalleDocumento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDetalleDocumento(esInicial);
		this.setResaltarid_empresaTipoDetalleDocumento(esInicial);
		this.setResaltarcodigoTipoDetalleDocumento(esInicial);
		this.setResaltarnombreTipoDetalleDocumento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.ID)) {
				this.setResaltaridTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDetalleDocumento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDetalleDocumentoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDetalleDocumento(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleDocumentoTipoDetalleDocumento=null;

	public Border getResaltarDetalleDocumentoTipoDetalleDocumento() {
		return this.resaltarDetalleDocumentoTipoDetalleDocumento;
	}

	public void setResaltarDetalleDocumentoTipoDetalleDocumento(Border borderResaltarDetalleDocumento) {
		if(borderResaltarDetalleDocumento!=null) {
			this.resaltarDetalleDocumentoTipoDetalleDocumento= borderResaltarDetalleDocumento;
		}
	}

	public Border setResaltarDetalleDocumentoTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleDocumento=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodetalledocumentoBeanSwingJInternalFrame.jTtoolBarTipoDetalleDocumento.setBorder(borderResaltarDetalleDocumento);
			
		this.resaltarDetalleDocumentoTipoDetalleDocumento= borderResaltarDetalleDocumento;

		 return borderResaltarDetalleDocumento;
	}



	public Boolean mostrarDetalleDocumentoTipoDetalleDocumento=true;

	public Boolean getMostrarDetalleDocumentoTipoDetalleDocumento() {
		return this.mostrarDetalleDocumentoTipoDetalleDocumento;
	}

	public void setMostrarDetalleDocumentoTipoDetalleDocumento(Boolean visibilidadResaltarDetalleDocumento) {
		this.mostrarDetalleDocumentoTipoDetalleDocumento= visibilidadResaltarDetalleDocumento;
	}



	public Boolean activarDetalleDocumentoTipoDetalleDocumento=true;

	public Boolean gethabilitarResaltarDetalleDocumentoTipoDetalleDocumento() {
		return this.activarDetalleDocumentoTipoDetalleDocumento;
	}

	public void setActivarDetalleDocumentoTipoDetalleDocumento(Boolean habilitarResaltarDetalleDocumento) {
		this.activarDetalleDocumentoTipoDetalleDocumento= habilitarResaltarDetalleDocumento;
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

		this.setMostrarDetalleDocumentoTipoDetalleDocumento(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleDocumento.class)) {
				this.setMostrarDetalleDocumentoTipoDetalleDocumento(esAsigna);
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

		this.setActivarDetalleDocumentoTipoDetalleDocumento(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleDocumento.class)) {
				this.setActivarDetalleDocumentoTipoDetalleDocumento(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleDocumentoTipoDetalleDocumento(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleDocumento.class)) {
				this.setResaltarDetalleDocumentoTipoDetalleDocumento(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoDetalleDocumento=true;

	public Boolean getMostrarBusquedaPorCodigoTipoDetalleDocumento() {
		return this.mostrarBusquedaPorCodigoTipoDetalleDocumento;
	}

	public void setMostrarBusquedaPorCodigoTipoDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoDetalleDocumento= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoDetalleDocumento=true;

	public Boolean getMostrarBusquedaPorNombreTipoDetalleDocumento() {
		return this.mostrarBusquedaPorNombreTipoDetalleDocumento;
	}

	public void setMostrarBusquedaPorNombreTipoDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoDetalleDocumento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoDetalleDocumento=true;

	public Boolean getMostrarFK_IdEmpresaTipoDetalleDocumento() {
		return this.mostrarFK_IdEmpresaTipoDetalleDocumento;
	}

	public void setMostrarFK_IdEmpresaTipoDetalleDocumento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDetalleDocumento= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoDetalleDocumento=true;

	public Boolean getActivarBusquedaPorCodigoTipoDetalleDocumento() {
		return this.activarBusquedaPorCodigoTipoDetalleDocumento;
	}

	public void setActivarBusquedaPorCodigoTipoDetalleDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoDetalleDocumento= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoDetalleDocumento=true;

	public Boolean getActivarBusquedaPorNombreTipoDetalleDocumento() {
		return this.activarBusquedaPorNombreTipoDetalleDocumento;
	}

	public void setActivarBusquedaPorNombreTipoDetalleDocumento(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoDetalleDocumento= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoDetalleDocumento=true;

	public Boolean getActivarFK_IdEmpresaTipoDetalleDocumento() {
		return this.activarFK_IdEmpresaTipoDetalleDocumento;
	}

	public void setActivarFK_IdEmpresaTipoDetalleDocumento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDetalleDocumento= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoDetalleDocumento=null;

	public Border getResaltarBusquedaPorCodigoTipoDetalleDocumento() {
		return this.resaltarBusquedaPorCodigoTipoDetalleDocumento;
	}

	public void setResaltarBusquedaPorCodigoTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoDetalleDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoDetalleDocumento= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoDetalleDocumento=null;

	public Border getResaltarBusquedaPorNombreTipoDetalleDocumento() {
		return this.resaltarBusquedaPorNombreTipoDetalleDocumento;
	}

	public void setResaltarBusquedaPorNombreTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoDetalleDocumento= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoDetalleDocumento= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoDetalleDocumento=null;

	public Border getResaltarFK_IdEmpresaTipoDetalleDocumento() {
		return this.resaltarFK_IdEmpresaTipoDetalleDocumento;
	}

	public void setResaltarFK_IdEmpresaTipoDetalleDocumento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDetalleDocumento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDetalleDocumento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDetalleDocumentoBeanSwingJInternalFrame tipodetalledocumentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDetalleDocumento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
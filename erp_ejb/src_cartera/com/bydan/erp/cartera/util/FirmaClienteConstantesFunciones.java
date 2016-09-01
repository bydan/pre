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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.FirmaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.FirmaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.FirmaClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FirmaClienteConstantesFunciones extends FirmaClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FirmaCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FirmaCliente"+FirmaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FirmaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FirmaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FirmaClienteConstantesFunciones.SCHEMA+"_"+FirmaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FirmaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FirmaClienteConstantesFunciones.SCHEMA+"_"+FirmaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FirmaClienteConstantesFunciones.SCHEMA+"_"+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FirmaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FirmaClienteConstantesFunciones.SCHEMA+"_"+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FirmaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FirmaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FirmaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FirmaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FirmaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FirmaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FirmaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Firma Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Firma Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Firma Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FirmaCliente";
	public static final String OBJECTNAME="firmacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="firma_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select firmacliente from "+FirmaClienteConstantesFunciones.SPERSISTENCENAME+" firmacliente";
	public static String QUERYSELECTNATIVE="select "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".version_row,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_empresa,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_cliente,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_tipo_imagen,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".firma,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".path_firma from "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME;//+" as "+FirmaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FirmaClienteConstantesFuncionesAdditional firmaclienteConstantesFuncionesAdditional=null;
	
	public FirmaClienteConstantesFuncionesAdditional getFirmaClienteConstantesFuncionesAdditional() {
		return this.firmaclienteConstantesFuncionesAdditional;
	}
	
	public void setFirmaClienteConstantesFuncionesAdditional(FirmaClienteConstantesFuncionesAdditional firmaclienteConstantesFuncionesAdditional) {
		try {
			this.firmaclienteConstantesFuncionesAdditional=firmaclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOIMAGEN= "id_tipo_imagen";
    public static final String FIRMA= "firma";
    public static final String PATHFIRMA= "path_firma";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOIMAGEN= "Idtipo Imagen";
		public static final String LABEL_IDTIPOIMAGEN_LOWER= "Tipo Imagen";
    	public static final String LABEL_FIRMA= "Firma";
		public static final String LABEL_FIRMA_LOWER= "Firma";
    	public static final String LABEL_PATHFIRMA= "Path Firma";
		public static final String LABEL_PATHFIRMA_LOWER= "Path Firma";
	
		
		
		
		
		
		
	public static final String SREGEXPATH_FIRMA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_FIRMA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFirmaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FirmaClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=FirmaClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FirmaClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=FirmaClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FirmaClienteConstantesFunciones.IDTIPOIMAGEN)) {sLabelColumna=FirmaClienteConstantesFunciones.LABEL_IDTIPOIMAGEN;}
		if(sNombreColumna.equals(FirmaClienteConstantesFunciones.FIRMA)) {sLabelColumna=FirmaClienteConstantesFunciones.LABEL_FIRMA;}
		if(sNombreColumna.equals(FirmaClienteConstantesFunciones.PATHFIRMA)) {sLabelColumna=FirmaClienteConstantesFunciones.LABEL_PATHFIRMA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getFirmaClienteDescripcion(FirmaCliente firmacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(firmacliente !=null/* && firmacliente.getId()!=0*/) {
			if(firmacliente.getId()!=null) {
				sDescripcion=firmacliente.getId().toString();
			}//firmaclientefirmacliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFirmaClienteDescripcionDetallado(FirmaCliente firmacliente) {
		String sDescripcion="";
			
		sDescripcion+=FirmaClienteConstantesFunciones.ID+"=";
		sDescripcion+=firmacliente.getId().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=firmacliente.getVersionRow().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=firmacliente.getid_empresa().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=firmacliente.getid_cliente().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.IDTIPOIMAGEN+"=";
		sDescripcion+=firmacliente.getid_tipo_imagen().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.FIRMA+"=";
		sDescripcion+=firmacliente.getfirma().toString()+",";
		sDescripcion+=FirmaClienteConstantesFunciones.PATHFIRMA+"=";
		sDescripcion+=firmacliente.getpath_firma()+",";
			
		return sDescripcion;
	}
	
	public static void setFirmaClienteDescripcion(FirmaCliente firmacliente,String sValor) throws Exception {			
		if(firmacliente !=null) {
			//firmaclientefirmacliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoImagenDescripcion(TipoImagen tipoimagen) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoimagen!=null/*&&tipoimagen.getId()>0*/) {
			sDescripcion=TipoImagenConstantesFunciones.getTipoImagenDescripcion(tipoimagen);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoImagen")) {
			sNombreIndice="Tipo=  Por Idtipo Imagen";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoImagen(Long id_tipo_imagen) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_imagen!=null) {sDetalleIndice+=" Codigo Unico De Idtipo Imagen="+id_tipo_imagen.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFirmaCliente(FirmaCliente firmacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		firmacliente.setpath_firma(firmacliente.getpath_firma().trim());
	}
	
	public static void quitarEspaciosFirmaClientes(List<FirmaCliente> firmaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FirmaCliente firmacliente: firmaclientes) {
			firmacliente.setpath_firma(firmacliente.getpath_firma().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFirmaCliente(FirmaCliente firmacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && firmacliente.getConCambioAuxiliar()) {
			firmacliente.setIsDeleted(firmacliente.getIsDeletedAuxiliar());	
			firmacliente.setIsNew(firmacliente.getIsNewAuxiliar());	
			firmacliente.setIsChanged(firmacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			firmacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			firmacliente.setIsDeletedAuxiliar(false);	
			firmacliente.setIsNewAuxiliar(false);	
			firmacliente.setIsChangedAuxiliar(false);
			
			firmacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFirmaClientes(List<FirmaCliente> firmaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FirmaCliente firmacliente : firmaclientes) {
			if(conAsignarBase && firmacliente.getConCambioAuxiliar()) {
				firmacliente.setIsDeleted(firmacliente.getIsDeletedAuxiliar());	
				firmacliente.setIsNew(firmacliente.getIsNewAuxiliar());	
				firmacliente.setIsChanged(firmacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				firmacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				firmacliente.setIsDeletedAuxiliar(false);	
				firmacliente.setIsNewAuxiliar(false);	
				firmacliente.setIsChangedAuxiliar(false);
				
				firmacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFirmaCliente(FirmaCliente firmacliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFirmaClientes(List<FirmaCliente> firmaclientes,Boolean conEnteros) throws Exception  {
		
		for(FirmaCliente firmacliente: firmaclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFirmaCliente(List<FirmaCliente> firmaclientes,FirmaCliente firmaclienteAux) throws Exception  {
		FirmaClienteConstantesFunciones.InicializarValoresFirmaCliente(firmaclienteAux,true);
		
		for(FirmaCliente firmacliente: firmaclientes) {
			if(firmacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFirmaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FirmaClienteConstantesFunciones.getArrayColumnasGlobalesFirmaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFirmaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FirmaClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FirmaClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFirmaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FirmaCliente> firmaclientes,FirmaCliente firmacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FirmaCliente firmaclienteAux: firmaclientes) {
			if(firmaclienteAux!=null && firmacliente!=null) {
				if((firmaclienteAux.getId()==null && firmacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(firmaclienteAux.getId()!=null && firmacliente.getId()!=null){
					if(firmaclienteAux.getId().equals(firmacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFirmaCliente(List<FirmaCliente> firmaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FirmaCliente firmacliente: firmaclientes) {			
			if(firmacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFirmaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_ID, FirmaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_VERSIONROW, FirmaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_IDEMPRESA, FirmaClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_IDCLIENTE, FirmaClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_IDTIPOIMAGEN, FirmaClienteConstantesFunciones.IDTIPOIMAGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_FIRMA, FirmaClienteConstantesFunciones.FIRMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FirmaClienteConstantesFunciones.LABEL_PATHFIRMA, FirmaClienteConstantesFunciones.PATHFIRMA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFirmaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.IDTIPOIMAGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.FIRMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FirmaClienteConstantesFunciones.PATHFIRMA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFirmaCliente() throws Exception  {
		return FirmaClienteConstantesFunciones.getTiposSeleccionarFirmaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFirmaCliente(Boolean conFk) throws Exception  {
		return FirmaClienteConstantesFunciones.getTiposSeleccionarFirmaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFirmaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FirmaClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FirmaClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FirmaClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FirmaClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FirmaClienteConstantesFunciones.LABEL_IDTIPOIMAGEN);
			reporte.setsDescripcion(FirmaClienteConstantesFunciones.LABEL_IDTIPOIMAGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(FirmaClienteConstantesFunciones.LABEL_FIRMA);
		reporte.setsDescripcion(FirmaClienteConstantesFunciones.LABEL_FIRMA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FirmaClienteConstantesFunciones.LABEL_PATHFIRMA);
			reporte.setsDescripcion(FirmaClienteConstantesFunciones.LABEL_PATHFIRMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFirmaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFirmaCliente(FirmaCliente firmaclienteAux) throws Exception {
		
			firmaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(firmaclienteAux.getEmpresa()));
			firmaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(firmaclienteAux.getCliente()));
			firmaclienteAux.settipoimagen_descripcion(TipoImagenConstantesFunciones.getTipoImagenDescripcion(firmaclienteAux.getTipoImagen()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFirmaCliente(List<FirmaCliente> firmaclientesTemp) throws Exception {
		for(FirmaCliente firmaclienteAux:firmaclientesTemp) {
			
			firmaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(firmaclienteAux.getEmpresa()));
			firmaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(firmaclienteAux.getCliente()));
			firmaclienteAux.settipoimagen_descripcion(TipoImagenConstantesFunciones.getTipoImagenDescripcion(firmaclienteAux.getTipoImagen()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFirmaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoImagen.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoImagen.class)) {
						classes.add(new Classe(TipoImagen.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFirmaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagen.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagen.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFirmaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FirmaClienteConstantesFunciones.getClassesRelationshipsOfFirmaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFirmaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFirmaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FirmaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfFirmaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFirmaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FirmaCliente firmacliente,List<FirmaCliente> firmaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FirmaCliente firmaclienteEncontrado=null;
			
			for(FirmaCliente firmaclienteLocal:firmaclientes) {
				if(firmaclienteLocal.getId().equals(firmacliente.getId())) {
					firmaclienteEncontrado=firmaclienteLocal;
					
					firmaclienteLocal.setIsChanged(firmacliente.getIsChanged());
					firmaclienteLocal.setIsNew(firmacliente.getIsNew());
					firmaclienteLocal.setIsDeleted(firmacliente.getIsDeleted());
					
					firmaclienteLocal.setGeneralEntityOriginal(firmacliente.getGeneralEntityOriginal());
					
					firmaclienteLocal.setId(firmacliente.getId());	
					firmaclienteLocal.setVersionRow(firmacliente.getVersionRow());	
					firmaclienteLocal.setid_empresa(firmacliente.getid_empresa());	
					firmaclienteLocal.setid_cliente(firmacliente.getid_cliente());	
					firmaclienteLocal.setid_tipo_imagen(firmacliente.getid_tipo_imagen());	
					firmaclienteLocal.setfirma(firmacliente.getfirma());	
					firmaclienteLocal.setpath_firma(firmacliente.getpath_firma());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!firmacliente.getIsDeleted()) {
				if(!existe) {
					firmaclientes.add(firmacliente);
				}
			} else {
				if(firmaclienteEncontrado!=null && permiteQuitar)  {
					firmaclientes.remove(firmaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FirmaCliente firmacliente,List<FirmaCliente> firmaclientes) throws Exception {
		try	{			
			for(FirmaCliente firmaclienteLocal:firmaclientes) {
				if(firmaclienteLocal.getId().equals(firmacliente.getId())) {
					firmaclienteLocal.setIsSelected(firmacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFirmaCliente(List<FirmaCliente> firmaclientesAux) throws Exception {
		//this.firmaclientesAux=firmaclientesAux;
		
		for(FirmaCliente firmaclienteAux:firmaclientesAux) {
			if(firmaclienteAux.getIsChanged()) {
				firmaclienteAux.setIsChanged(false);
			}		
			
			if(firmaclienteAux.getIsNew()) {
				firmaclienteAux.setIsNew(false);
			}	
			
			if(firmaclienteAux.getIsDeleted()) {
				firmaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFirmaCliente(FirmaCliente firmaclienteAux) throws Exception {
		//this.firmaclienteAux=firmaclienteAux;
		
			if(firmaclienteAux.getIsChanged()) {
				firmaclienteAux.setIsChanged(false);
			}		
			
			if(firmaclienteAux.getIsNew()) {
				firmaclienteAux.setIsNew(false);
			}	
			
			if(firmaclienteAux.getIsDeleted()) {
				firmaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FirmaCliente firmaclienteAsignar,FirmaCliente firmacliente) throws Exception {
		firmaclienteAsignar.setId(firmacliente.getId());	
		firmaclienteAsignar.setVersionRow(firmacliente.getVersionRow());	
		firmaclienteAsignar.setid_empresa(firmacliente.getid_empresa());
		firmaclienteAsignar.setempresa_descripcion(firmacliente.getempresa_descripcion());	
		firmaclienteAsignar.setid_cliente(firmacliente.getid_cliente());
		firmaclienteAsignar.setcliente_descripcion(firmacliente.getcliente_descripcion());	
		firmaclienteAsignar.setid_tipo_imagen(firmacliente.getid_tipo_imagen());
		firmaclienteAsignar.settipoimagen_descripcion(firmacliente.gettipoimagen_descripcion());	
		firmaclienteAsignar.setfirma(firmacliente.getfirma());	
		firmaclienteAsignar.setpath_firma(firmacliente.getpath_firma());	
	}
	
	public static void inicializarFirmaCliente(FirmaCliente firmacliente) throws Exception {
		try {
				firmacliente.setId(0L);	
					
				firmacliente.setid_empresa(-1L);	
				firmacliente.setid_cliente(-1L);	
				firmacliente.setid_tipo_imagen(-1L);	
				firmacliente.setfirma(null);	
				firmacliente.setpath_firma("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFirmaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FirmaClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FirmaClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FirmaClienteConstantesFunciones.LABEL_IDTIPOIMAGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FirmaClienteConstantesFunciones.LABEL_PATHFIRMA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFirmaCliente(String sTipo,Row row,Workbook workbook,FirmaCliente firmacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(firmacliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(firmacliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(firmacliente.gettipoimagen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(firmacliente.getpath_firma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFirmaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFirmaCliente() {
		return this.sFinalQueryFirmaCliente;
	}
	
	public void setsFinalQueryFirmaCliente(String sFinalQueryFirmaCliente) {
		this.sFinalQueryFirmaCliente= sFinalQueryFirmaCliente;
	}
	
	public Border resaltarSeleccionarFirmaCliente=null;
	
	public Border setResaltarSeleccionarFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFirmaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFirmaCliente() {
		return this.resaltarSeleccionarFirmaCliente;
	}
	
	public void setResaltarSeleccionarFirmaCliente(Border borderResaltarSeleccionarFirmaCliente) {
		this.resaltarSeleccionarFirmaCliente= borderResaltarSeleccionarFirmaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFirmaCliente=null;
	public Boolean mostraridFirmaCliente=true;
	public Boolean activaridFirmaCliente=true;

	public Border resaltarid_empresaFirmaCliente=null;
	public Boolean mostrarid_empresaFirmaCliente=true;
	public Boolean activarid_empresaFirmaCliente=true;
	public Boolean cargarid_empresaFirmaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFirmaCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteFirmaCliente=null;
	public Boolean mostrarid_clienteFirmaCliente=true;
	public Boolean activarid_clienteFirmaCliente=true;
	public Boolean cargarid_clienteFirmaCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFirmaCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_imagenFirmaCliente=null;
	public Boolean mostrarid_tipo_imagenFirmaCliente=true;
	public Boolean activarid_tipo_imagenFirmaCliente=true;
	public Boolean cargarid_tipo_imagenFirmaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_imagenFirmaCliente=false;//ConEventDepend=true

	public Border resaltarfirmaFirmaCliente=null;
	public Boolean mostrarfirmaFirmaCliente=true;
	public Boolean activarfirmaFirmaCliente=true;

	public Border resaltarpath_firmaFirmaCliente=null;
	public Boolean mostrarpath_firmaFirmaCliente=true;
	public Boolean activarpath_firmaFirmaCliente=true;

	
	

	public Border setResaltaridFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltaridFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFirmaCliente() {
		return this.resaltaridFirmaCliente;
	}

	public void setResaltaridFirmaCliente(Border borderResaltar) {
		this.resaltaridFirmaCliente= borderResaltar;
	}

	public Boolean getMostraridFirmaCliente() {
		return this.mostraridFirmaCliente;
	}

	public void setMostraridFirmaCliente(Boolean mostraridFirmaCliente) {
		this.mostraridFirmaCliente= mostraridFirmaCliente;
	}

	public Boolean getActivaridFirmaCliente() {
		return this.activaridFirmaCliente;
	}

	public void setActivaridFirmaCliente(Boolean activaridFirmaCliente) {
		this.activaridFirmaCliente= activaridFirmaCliente;
	}

	public Border setResaltarid_empresaFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFirmaCliente() {
		return this.resaltarid_empresaFirmaCliente;
	}

	public void setResaltarid_empresaFirmaCliente(Border borderResaltar) {
		this.resaltarid_empresaFirmaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaFirmaCliente() {
		return this.mostrarid_empresaFirmaCliente;
	}

	public void setMostrarid_empresaFirmaCliente(Boolean mostrarid_empresaFirmaCliente) {
		this.mostrarid_empresaFirmaCliente= mostrarid_empresaFirmaCliente;
	}

	public Boolean getActivarid_empresaFirmaCliente() {
		return this.activarid_empresaFirmaCliente;
	}

	public void setActivarid_empresaFirmaCliente(Boolean activarid_empresaFirmaCliente) {
		this.activarid_empresaFirmaCliente= activarid_empresaFirmaCliente;
	}

	public Boolean getCargarid_empresaFirmaCliente() {
		return this.cargarid_empresaFirmaCliente;
	}

	public void setCargarid_empresaFirmaCliente(Boolean cargarid_empresaFirmaCliente) {
		this.cargarid_empresaFirmaCliente= cargarid_empresaFirmaCliente;
	}

	public Border setResaltarid_clienteFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFirmaCliente() {
		return this.resaltarid_clienteFirmaCliente;
	}

	public void setResaltarid_clienteFirmaCliente(Border borderResaltar) {
		this.resaltarid_clienteFirmaCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteFirmaCliente() {
		return this.mostrarid_clienteFirmaCliente;
	}

	public void setMostrarid_clienteFirmaCliente(Boolean mostrarid_clienteFirmaCliente) {
		this.mostrarid_clienteFirmaCliente= mostrarid_clienteFirmaCliente;
	}

	public Boolean getActivarid_clienteFirmaCliente() {
		return this.activarid_clienteFirmaCliente;
	}

	public void setActivarid_clienteFirmaCliente(Boolean activarid_clienteFirmaCliente) {
		this.activarid_clienteFirmaCliente= activarid_clienteFirmaCliente;
	}

	public Boolean getCargarid_clienteFirmaCliente() {
		return this.cargarid_clienteFirmaCliente;
	}

	public void setCargarid_clienteFirmaCliente(Boolean cargarid_clienteFirmaCliente) {
		this.cargarid_clienteFirmaCliente= cargarid_clienteFirmaCliente;
	}

	public Border setResaltarid_tipo_imagenFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_imagenFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_imagenFirmaCliente() {
		return this.resaltarid_tipo_imagenFirmaCliente;
	}

	public void setResaltarid_tipo_imagenFirmaCliente(Border borderResaltar) {
		this.resaltarid_tipo_imagenFirmaCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_imagenFirmaCliente() {
		return this.mostrarid_tipo_imagenFirmaCliente;
	}

	public void setMostrarid_tipo_imagenFirmaCliente(Boolean mostrarid_tipo_imagenFirmaCliente) {
		this.mostrarid_tipo_imagenFirmaCliente= mostrarid_tipo_imagenFirmaCliente;
	}

	public Boolean getActivarid_tipo_imagenFirmaCliente() {
		return this.activarid_tipo_imagenFirmaCliente;
	}

	public void setActivarid_tipo_imagenFirmaCliente(Boolean activarid_tipo_imagenFirmaCliente) {
		this.activarid_tipo_imagenFirmaCliente= activarid_tipo_imagenFirmaCliente;
	}

	public Boolean getCargarid_tipo_imagenFirmaCliente() {
		return this.cargarid_tipo_imagenFirmaCliente;
	}

	public void setCargarid_tipo_imagenFirmaCliente(Boolean cargarid_tipo_imagenFirmaCliente) {
		this.cargarid_tipo_imagenFirmaCliente= cargarid_tipo_imagenFirmaCliente;
	}

	public Border setResaltarfirmaFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarfirmaFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfirmaFirmaCliente() {
		return this.resaltarfirmaFirmaCliente;
	}

	public void setResaltarfirmaFirmaCliente(Border borderResaltar) {
		this.resaltarfirmaFirmaCliente= borderResaltar;
	}

	public Boolean getMostrarfirmaFirmaCliente() {
		return this.mostrarfirmaFirmaCliente;
	}

	public void setMostrarfirmaFirmaCliente(Boolean mostrarfirmaFirmaCliente) {
		this.mostrarfirmaFirmaCliente= mostrarfirmaFirmaCliente;
	}

	public Boolean getActivarfirmaFirmaCliente() {
		return this.activarfirmaFirmaCliente;
	}

	public void setActivarfirmaFirmaCliente(Boolean activarfirmaFirmaCliente) {
		this.activarfirmaFirmaCliente= activarfirmaFirmaCliente;
	}

	public Border setResaltarpath_firmaFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//firmaclienteBeanSwingJInternalFrame.jTtoolBarFirmaCliente.setBorder(borderResaltar);
		
		this.resaltarpath_firmaFirmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_firmaFirmaCliente() {
		return this.resaltarpath_firmaFirmaCliente;
	}

	public void setResaltarpath_firmaFirmaCliente(Border borderResaltar) {
		this.resaltarpath_firmaFirmaCliente= borderResaltar;
	}

	public Boolean getMostrarpath_firmaFirmaCliente() {
		return this.mostrarpath_firmaFirmaCliente;
	}

	public void setMostrarpath_firmaFirmaCliente(Boolean mostrarpath_firmaFirmaCliente) {
		this.mostrarpath_firmaFirmaCliente= mostrarpath_firmaFirmaCliente;
	}

	public Boolean getActivarpath_firmaFirmaCliente() {
		return this.activarpath_firmaFirmaCliente;
	}

	public void setActivarpath_firmaFirmaCliente(Boolean activarpath_firmaFirmaCliente) {
		this.activarpath_firmaFirmaCliente= activarpath_firmaFirmaCliente;
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
		
		
		this.setMostraridFirmaCliente(esInicial);
		this.setMostrarid_empresaFirmaCliente(esInicial);
		this.setMostrarid_clienteFirmaCliente(esInicial);
		this.setMostrarid_tipo_imagenFirmaCliente(esInicial);
		this.setMostrarfirmaFirmaCliente(esInicial);
		this.setMostrarpath_firmaFirmaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FirmaClienteConstantesFunciones.ID)) {
				this.setMostraridFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDTIPOIMAGEN)) {
				this.setMostrarid_tipo_imagenFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.FIRMA)) {
				this.setMostrarfirmaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.PATHFIRMA)) {
				this.setMostrarpath_firmaFirmaCliente(esAsigna);
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
		
		
		this.setActivaridFirmaCliente(esInicial);
		this.setActivarid_empresaFirmaCliente(esInicial);
		this.setActivarid_clienteFirmaCliente(esInicial);
		this.setActivarid_tipo_imagenFirmaCliente(esInicial);
		this.setActivarfirmaFirmaCliente(esInicial);
		this.setActivarpath_firmaFirmaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FirmaClienteConstantesFunciones.ID)) {
				this.setActivaridFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDTIPOIMAGEN)) {
				this.setActivarid_tipo_imagenFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.FIRMA)) {
				this.setActivarfirmaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.PATHFIRMA)) {
				this.setActivarpath_firmaFirmaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFirmaCliente(esInicial);
		this.setResaltarid_empresaFirmaCliente(esInicial);
		this.setResaltarid_clienteFirmaCliente(esInicial);
		this.setResaltarid_tipo_imagenFirmaCliente(esInicial);
		this.setResaltarfirmaFirmaCliente(esInicial);
		this.setResaltarpath_firmaFirmaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FirmaClienteConstantesFunciones.ID)) {
				this.setResaltaridFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.IDTIPOIMAGEN)) {
				this.setResaltarid_tipo_imagenFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.FIRMA)) {
				this.setResaltarfirmaFirmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(FirmaClienteConstantesFunciones.PATHFIRMA)) {
				this.setResaltarpath_firmaFirmaCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteFirmaCliente=true;

	public Boolean getMostrarFK_IdClienteFirmaCliente() {
		return this.mostrarFK_IdClienteFirmaCliente;
	}

	public void setMostrarFK_IdClienteFirmaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFirmaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFirmaCliente=true;

	public Boolean getMostrarFK_IdEmpresaFirmaCliente() {
		return this.mostrarFK_IdEmpresaFirmaCliente;
	}

	public void setMostrarFK_IdEmpresaFirmaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFirmaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoImagenFirmaCliente=true;

	public Boolean getMostrarFK_IdTipoImagenFirmaCliente() {
		return this.mostrarFK_IdTipoImagenFirmaCliente;
	}

	public void setMostrarFK_IdTipoImagenFirmaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoImagenFirmaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteFirmaCliente=true;

	public Boolean getActivarFK_IdClienteFirmaCliente() {
		return this.activarFK_IdClienteFirmaCliente;
	}

	public void setActivarFK_IdClienteFirmaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFirmaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFirmaCliente=true;

	public Boolean getActivarFK_IdEmpresaFirmaCliente() {
		return this.activarFK_IdEmpresaFirmaCliente;
	}

	public void setActivarFK_IdEmpresaFirmaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFirmaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoImagenFirmaCliente=true;

	public Boolean getActivarFK_IdTipoImagenFirmaCliente() {
		return this.activarFK_IdTipoImagenFirmaCliente;
	}

	public void setActivarFK_IdTipoImagenFirmaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoImagenFirmaCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteFirmaCliente=null;

	public Border getResaltarFK_IdClienteFirmaCliente() {
		return this.resaltarFK_IdClienteFirmaCliente;
	}

	public void setResaltarFK_IdClienteFirmaCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteFirmaCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFirmaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFirmaCliente=null;

	public Border getResaltarFK_IdEmpresaFirmaCliente() {
		return this.resaltarFK_IdEmpresaFirmaCliente;
	}

	public void setResaltarFK_IdEmpresaFirmaCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFirmaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFirmaCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoImagenFirmaCliente=null;

	public Border getResaltarFK_IdTipoImagenFirmaCliente() {
		return this.resaltarFK_IdTipoImagenFirmaCliente;
	}

	public void setResaltarFK_IdTipoImagenFirmaCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoImagenFirmaCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoImagenFirmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*FirmaClienteBeanSwingJInternalFrame firmaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoImagenFirmaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
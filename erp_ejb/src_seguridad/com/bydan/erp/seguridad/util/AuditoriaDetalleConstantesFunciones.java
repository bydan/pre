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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.AuditoriaDetalleConstantesFunciones;
import com.bydan.erp.seguridad.util.AuditoriaDetalleParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AuditoriaDetalleParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AuditoriaDetalleConstantesFunciones extends AuditoriaDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AuditoriaDetalle";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AuditoriaDetalle"+AuditoriaDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AuditoriaDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AuditoriaDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AuditoriaDetalleConstantesFunciones.SCHEMA+"_"+AuditoriaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AuditoriaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AuditoriaDetalleConstantesFunciones.SCHEMA+"_"+AuditoriaDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AuditoriaDetalleConstantesFunciones.SCHEMA+"_"+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AuditoriaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AuditoriaDetalleConstantesFunciones.SCHEMA+"_"+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AuditoriaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AuditoriaDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AuditoriaDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AuditoriaDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AuditoriaDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AuditoriaDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Auditoria Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Auditoria Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Auditoria Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AuditoriaDetalle";
	public static final String OBJECTNAME="auditoriadetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_AUDITORIA;	
	public static final String TABLENAME="auditoria_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select auditoriadetalle from "+AuditoriaDetalleConstantesFunciones.SPERSISTENCENAME+" auditoriadetalle";
	public static String QUERYSELECTNATIVE="select "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".id,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".version_row,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".id_auditoria,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".nombre_campo,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".valor_anterior,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".valor_actual from "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME;//+" as "+AuditoriaDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AuditoriaDetalleConstantesFuncionesAdditional auditoriadetalleConstantesFuncionesAdditional=null;
	
	public AuditoriaDetalleConstantesFuncionesAdditional getAuditoriaDetalleConstantesFuncionesAdditional() {
		return this.auditoriadetalleConstantesFuncionesAdditional;
	}
	
	public void setAuditoriaDetalleConstantesFuncionesAdditional(AuditoriaDetalleConstantesFuncionesAdditional auditoriadetalleConstantesFuncionesAdditional) {
		try {
			this.auditoriadetalleConstantesFuncionesAdditional=auditoriadetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDAUDITORIA= "id_auditoria";
    public static final String NOMBRECAMPO= "nombre_campo";
    public static final String VALORANTERIOR= "valor_anterior";
    public static final String VALORACTUAL= "valor_actual";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDAUDITORIA= "Auditoria";
		public static final String LABEL_IDAUDITORIA_LOWER= "Auditoria";
    	public static final String LABEL_NOMBRECAMPO= "Nombre Del Campo";
		public static final String LABEL_NOMBRECAMPO_LOWER= "Nombre Campo";
    	public static final String LABEL_VALORANTERIOR= "Valor Anterior";
		public static final String LABEL_VALORANTERIOR_LOWER= "Valor Anterior";
    	public static final String LABEL_VALORACTUAL= "Valor Actual";
		public static final String LABEL_VALORACTUAL_LOWER= "Valor Actual";
	
		
		
		
	public static final String SREGEXNOMBRE_CAMPO=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXNOMBRE_CAMPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXVALOR_ANTERIOR=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXVALOR_ANTERIOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXVALOR_ACTUAL=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXVALOR_ACTUAL=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAuditoriaDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AuditoriaDetalleConstantesFunciones.IDAUDITORIA)) {sLabelColumna=AuditoriaDetalleConstantesFunciones.LABEL_IDAUDITORIA;}
		if(sNombreColumna.equals(AuditoriaDetalleConstantesFunciones.NOMBRECAMPO)) {sLabelColumna=AuditoriaDetalleConstantesFunciones.LABEL_NOMBRECAMPO;}
		if(sNombreColumna.equals(AuditoriaDetalleConstantesFunciones.VALORANTERIOR)) {sLabelColumna=AuditoriaDetalleConstantesFunciones.LABEL_VALORANTERIOR;}
		if(sNombreColumna.equals(AuditoriaDetalleConstantesFunciones.VALORACTUAL)) {sLabelColumna=AuditoriaDetalleConstantesFunciones.LABEL_VALORACTUAL;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getAuditoriaDetalleDescripcion(AuditoriaDetalle auditoriadetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(auditoriadetalle !=null/* && auditoriadetalle.getId()!=0*/) {
			sDescripcion=auditoriadetalle.getvalor_anterior();//auditoriadetalleauditoriadetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAuditoriaDetalleDescripcionDetallado(AuditoriaDetalle auditoriadetalle) {
		String sDescripcion="";
			
		sDescripcion+=AuditoriaDetalleConstantesFunciones.ID+"=";
		sDescripcion+=auditoriadetalle.getId().toString()+",";
		sDescripcion+=AuditoriaDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=auditoriadetalle.getVersionRow().toString()+",";
		sDescripcion+=AuditoriaDetalleConstantesFunciones.IDAUDITORIA+"=";
		sDescripcion+=auditoriadetalle.getid_auditoria().toString()+",";
		sDescripcion+=AuditoriaDetalleConstantesFunciones.NOMBRECAMPO+"=";
		sDescripcion+=auditoriadetalle.getnombre_campo()+",";
		sDescripcion+=AuditoriaDetalleConstantesFunciones.VALORANTERIOR+"=";
		sDescripcion+=auditoriadetalle.getvalor_anterior()+",";
		sDescripcion+=AuditoriaDetalleConstantesFunciones.VALORACTUAL+"=";
		sDescripcion+=auditoriadetalle.getvalor_actual()+",";
			
		return sDescripcion;
	}
	
	public static void setAuditoriaDetalleDescripcion(AuditoriaDetalle auditoriadetalle,String sValor) throws Exception {			
		if(auditoriadetalle !=null) {
			auditoriadetalle.setvalor_anterior(sValor);//auditoriadetalleauditoriadetalle.getId().toString();
		}		
	}
	
		

	public static String getAuditoriaDescripcion(Auditoria auditoria) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(auditoria!=null/*&&auditoria.getId()>0*/) {
			sDescripcion=AuditoriaConstantesFunciones.getAuditoriaDescripcion(auditoria);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdAuditoriaPorNombreCampo")) {
			sNombreIndice="Tipo=  Por Auditoria Por Nombre Del Campo";
		} else if(sNombreIndice.equals("FK_IdAuditoria")) {
			sNombreIndice="Tipo=  Por Auditoria";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdAuditoriaPorNombreCampo(Long id_auditoria,String nombre_campo) {
		String sDetalleIndice=" Parametros->";
		if(id_auditoria!=null) {sDetalleIndice+=" Codigo Unico De Auditoria="+id_auditoria.toString();}
		if(nombre_campo!=null) {sDetalleIndice+=" Nombre Del Campo="+nombre_campo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAuditoria(Long id_auditoria) {
		String sDetalleIndice=" Parametros->";
		if(id_auditoria!=null) {sDetalleIndice+=" Codigo Unico De Auditoria="+id_auditoria.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAuditoriaDetalle(AuditoriaDetalle auditoriadetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		auditoriadetalle.setnombre_campo(auditoriadetalle.getnombre_campo().trim());
		auditoriadetalle.setvalor_anterior(auditoriadetalle.getvalor_anterior().trim());
		auditoriadetalle.setvalor_actual(auditoriadetalle.getvalor_actual().trim());
	}
	
	public static void quitarEspaciosAuditoriaDetalles(List<AuditoriaDetalle> auditoriadetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AuditoriaDetalle auditoriadetalle: auditoriadetalles) {
			auditoriadetalle.setnombre_campo(auditoriadetalle.getnombre_campo().trim());
			auditoriadetalle.setvalor_anterior(auditoriadetalle.getvalor_anterior().trim());
			auditoriadetalle.setvalor_actual(auditoriadetalle.getvalor_actual().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAuditoriaDetalle(AuditoriaDetalle auditoriadetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && auditoriadetalle.getConCambioAuxiliar()) {
			auditoriadetalle.setIsDeleted(auditoriadetalle.getIsDeletedAuxiliar());	
			auditoriadetalle.setIsNew(auditoriadetalle.getIsNewAuxiliar());	
			auditoriadetalle.setIsChanged(auditoriadetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			auditoriadetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			auditoriadetalle.setIsDeletedAuxiliar(false);	
			auditoriadetalle.setIsNewAuxiliar(false);	
			auditoriadetalle.setIsChangedAuxiliar(false);
			
			auditoriadetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAuditoriaDetalles(List<AuditoriaDetalle> auditoriadetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AuditoriaDetalle auditoriadetalle : auditoriadetalles) {
			if(conAsignarBase && auditoriadetalle.getConCambioAuxiliar()) {
				auditoriadetalle.setIsDeleted(auditoriadetalle.getIsDeletedAuxiliar());	
				auditoriadetalle.setIsNew(auditoriadetalle.getIsNewAuxiliar());	
				auditoriadetalle.setIsChanged(auditoriadetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				auditoriadetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				auditoriadetalle.setIsDeletedAuxiliar(false);	
				auditoriadetalle.setIsNewAuxiliar(false);	
				auditoriadetalle.setIsChangedAuxiliar(false);
				
				auditoriadetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAuditoriaDetalle(AuditoriaDetalle auditoriadetalle,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAuditoriaDetalles(List<AuditoriaDetalle> auditoriadetalles,Boolean conEnteros) throws Exception  {
		
		for(AuditoriaDetalle auditoriadetalle: auditoriadetalles) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAuditoriaDetalle(List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalle auditoriadetalleAux) throws Exception  {
		AuditoriaDetalleConstantesFunciones.InicializarValoresAuditoriaDetalle(auditoriadetalleAux,true);
		
		for(AuditoriaDetalle auditoriadetalle: auditoriadetalles) {
			if(auditoriadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAuditoriaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AuditoriaDetalleConstantesFunciones.getArrayColumnasGlobalesAuditoriaDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAuditoriaDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAuditoriaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalle auditoriadetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AuditoriaDetalle auditoriadetalleAux: auditoriadetalles) {
			if(auditoriadetalleAux!=null && auditoriadetalle!=null) {
				if((auditoriadetalleAux.getId()==null && auditoriadetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(auditoriadetalleAux.getId()!=null && auditoriadetalle.getId()!=null){
					if(auditoriadetalleAux.getId().equals(auditoriadetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAuditoriaDetalle(List<AuditoriaDetalle> auditoriadetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AuditoriaDetalle auditoriadetalle: auditoriadetalles) {			
			if(auditoriadetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAuditoriaDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_ID, AuditoriaDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_VERSIONROW, AuditoriaDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_IDAUDITORIA, AuditoriaDetalleConstantesFunciones.IDAUDITORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_NOMBRECAMPO, AuditoriaDetalleConstantesFunciones.NOMBRECAMPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_VALORANTERIOR, AuditoriaDetalleConstantesFunciones.VALORANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaDetalleConstantesFunciones.LABEL_VALORACTUAL, AuditoriaDetalleConstantesFunciones.VALORACTUAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAuditoriaDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.IDAUDITORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.NOMBRECAMPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.VALORANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaDetalleConstantesFunciones.VALORACTUAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoriaDetalle() throws Exception  {
		return AuditoriaDetalleConstantesFunciones.getTiposSeleccionarAuditoriaDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoriaDetalle(Boolean conFk) throws Exception  {
		return AuditoriaDetalleConstantesFunciones.getTiposSeleccionarAuditoriaDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoriaDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaDetalleConstantesFunciones.LABEL_IDAUDITORIA);
			reporte.setsDescripcion(AuditoriaDetalleConstantesFunciones.LABEL_IDAUDITORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaDetalleConstantesFunciones.LABEL_NOMBRECAMPO);
			reporte.setsDescripcion(AuditoriaDetalleConstantesFunciones.LABEL_NOMBRECAMPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaDetalleConstantesFunciones.LABEL_VALORANTERIOR);
			reporte.setsDescripcion(AuditoriaDetalleConstantesFunciones.LABEL_VALORANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaDetalleConstantesFunciones.LABEL_VALORACTUAL);
			reporte.setsDescripcion(AuditoriaDetalleConstantesFunciones.LABEL_VALORACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAuditoriaDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAuditoriaDetalle(AuditoriaDetalle auditoriadetalleAux) throws Exception {
		
			auditoriadetalleAux.setauditoria_descripcion(AuditoriaConstantesFunciones.getAuditoriaDescripcion(auditoriadetalleAux.getAuditoria()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAuditoriaDetalle(List<AuditoriaDetalle> auditoriadetallesTemp) throws Exception {
		for(AuditoriaDetalle auditoriadetalleAux:auditoriadetallesTemp) {
			
			auditoriadetalleAux.setauditoria_descripcion(AuditoriaConstantesFunciones.getAuditoriaDescripcion(auditoriadetalleAux.getAuditoria()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAuditoriaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Auditoria.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Auditoria.class)) {
						classes.add(new Classe(Auditoria.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAuditoriaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Auditoria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Auditoria.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Auditoria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Auditoria.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoriaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AuditoriaDetalleConstantesFunciones.getClassesRelationshipsOfAuditoriaDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoriaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAuditoriaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AuditoriaDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfAuditoriaDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAuditoriaDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AuditoriaDetalle auditoriadetalle,List<AuditoriaDetalle> auditoriadetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AuditoriaDetalle auditoriadetalleEncontrado=null;
			
			for(AuditoriaDetalle auditoriadetalleLocal:auditoriadetalles) {
				if(auditoriadetalleLocal.getId().equals(auditoriadetalle.getId())) {
					auditoriadetalleEncontrado=auditoriadetalleLocal;
					
					auditoriadetalleLocal.setIsChanged(auditoriadetalle.getIsChanged());
					auditoriadetalleLocal.setIsNew(auditoriadetalle.getIsNew());
					auditoriadetalleLocal.setIsDeleted(auditoriadetalle.getIsDeleted());
					
					auditoriadetalleLocal.setGeneralEntityOriginal(auditoriadetalle.getGeneralEntityOriginal());
					
					auditoriadetalleLocal.setId(auditoriadetalle.getId());	
					auditoriadetalleLocal.setVersionRow(auditoriadetalle.getVersionRow());	
					auditoriadetalleLocal.setid_auditoria(auditoriadetalle.getid_auditoria());	
					auditoriadetalleLocal.setnombre_campo(auditoriadetalle.getnombre_campo());	
					auditoriadetalleLocal.setvalor_anterior(auditoriadetalle.getvalor_anterior());	
					auditoriadetalleLocal.setvalor_actual(auditoriadetalle.getvalor_actual());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!auditoriadetalle.getIsDeleted()) {
				if(!existe) {
					auditoriadetalles.add(auditoriadetalle);
				}
			} else {
				if(auditoriadetalleEncontrado!=null && permiteQuitar)  {
					auditoriadetalles.remove(auditoriadetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AuditoriaDetalle auditoriadetalle,List<AuditoriaDetalle> auditoriadetalles) throws Exception {
		try	{			
			for(AuditoriaDetalle auditoriadetalleLocal:auditoriadetalles) {
				if(auditoriadetalleLocal.getId().equals(auditoriadetalle.getId())) {
					auditoriadetalleLocal.setIsSelected(auditoriadetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAuditoriaDetalle(List<AuditoriaDetalle> auditoriadetallesAux) throws Exception {
		//this.auditoriadetallesAux=auditoriadetallesAux;
		
		for(AuditoriaDetalle auditoriadetalleAux:auditoriadetallesAux) {
			if(auditoriadetalleAux.getIsChanged()) {
				auditoriadetalleAux.setIsChanged(false);
			}		
			
			if(auditoriadetalleAux.getIsNew()) {
				auditoriadetalleAux.setIsNew(false);
			}	
			
			if(auditoriadetalleAux.getIsDeleted()) {
				auditoriadetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAuditoriaDetalle(AuditoriaDetalle auditoriadetalleAux) throws Exception {
		//this.auditoriadetalleAux=auditoriadetalleAux;
		
			if(auditoriadetalleAux.getIsChanged()) {
				auditoriadetalleAux.setIsChanged(false);
			}		
			
			if(auditoriadetalleAux.getIsNew()) {
				auditoriadetalleAux.setIsNew(false);
			}	
			
			if(auditoriadetalleAux.getIsDeleted()) {
				auditoriadetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AuditoriaDetalle auditoriadetalleAsignar,AuditoriaDetalle auditoriadetalle) throws Exception {
		auditoriadetalleAsignar.setId(auditoriadetalle.getId());	
		auditoriadetalleAsignar.setVersionRow(auditoriadetalle.getVersionRow());	
		auditoriadetalleAsignar.setid_auditoria(auditoriadetalle.getid_auditoria());
		auditoriadetalleAsignar.setauditoria_descripcion(auditoriadetalle.getauditoria_descripcion());	
		auditoriadetalleAsignar.setnombre_campo(auditoriadetalle.getnombre_campo());	
		auditoriadetalleAsignar.setvalor_anterior(auditoriadetalle.getvalor_anterior());	
		auditoriadetalleAsignar.setvalor_actual(auditoriadetalle.getvalor_actual());	
	}
	
	public static void inicializarAuditoriaDetalle(AuditoriaDetalle auditoriadetalle) throws Exception {
		try {
				auditoriadetalle.setId(0L);	
					
				auditoriadetalle.setid_auditoria(-1L);	
				auditoriadetalle.setnombre_campo("");	
				auditoriadetalle.setvalor_anterior("");	
				auditoriadetalle.setvalor_actual("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAuditoriaDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaDetalleConstantesFunciones.LABEL_IDAUDITORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaDetalleConstantesFunciones.LABEL_NOMBRECAMPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaDetalleConstantesFunciones.LABEL_VALORANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaDetalleConstantesFunciones.LABEL_VALORACTUAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAuditoriaDetalle(String sTipo,Row row,Workbook workbook,AuditoriaDetalle auditoriadetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoriadetalle.getauditoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoriadetalle.getnombre_campo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoriadetalle.getvalor_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoriadetalle.getvalor_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAuditoriaDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAuditoriaDetalle() {
		return this.sFinalQueryAuditoriaDetalle;
	}
	
	public void setsFinalQueryAuditoriaDetalle(String sFinalQueryAuditoriaDetalle) {
		this.sFinalQueryAuditoriaDetalle= sFinalQueryAuditoriaDetalle;
	}
	
	public Border resaltarSeleccionarAuditoriaDetalle=null;
	
	public Border setResaltarSeleccionarAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAuditoriaDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAuditoriaDetalle() {
		return this.resaltarSeleccionarAuditoriaDetalle;
	}
	
	public void setResaltarSeleccionarAuditoriaDetalle(Border borderResaltarSeleccionarAuditoriaDetalle) {
		this.resaltarSeleccionarAuditoriaDetalle= borderResaltarSeleccionarAuditoriaDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAuditoriaDetalle=null;
	public Boolean mostraridAuditoriaDetalle=true;
	public Boolean activaridAuditoriaDetalle=true;

	public Border resaltarid_auditoriaAuditoriaDetalle=null;
	public Boolean mostrarid_auditoriaAuditoriaDetalle=true;
	public Boolean activarid_auditoriaAuditoriaDetalle=true;
	public Boolean cargarid_auditoriaAuditoriaDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_auditoriaAuditoriaDetalle=false;//ConEventDepend=true

	public Border resaltarnombre_campoAuditoriaDetalle=null;
	public Boolean mostrarnombre_campoAuditoriaDetalle=true;
	public Boolean activarnombre_campoAuditoriaDetalle=true;

	public Border resaltarvalor_anteriorAuditoriaDetalle=null;
	public Boolean mostrarvalor_anteriorAuditoriaDetalle=true;
	public Boolean activarvalor_anteriorAuditoriaDetalle=true;

	public Border resaltarvalor_actualAuditoriaDetalle=null;
	public Boolean mostrarvalor_actualAuditoriaDetalle=true;
	public Boolean activarvalor_actualAuditoriaDetalle=true;

	
	

	public Border setResaltaridAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltaridAuditoriaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAuditoriaDetalle() {
		return this.resaltaridAuditoriaDetalle;
	}

	public void setResaltaridAuditoriaDetalle(Border borderResaltar) {
		this.resaltaridAuditoriaDetalle= borderResaltar;
	}

	public Boolean getMostraridAuditoriaDetalle() {
		return this.mostraridAuditoriaDetalle;
	}

	public void setMostraridAuditoriaDetalle(Boolean mostraridAuditoriaDetalle) {
		this.mostraridAuditoriaDetalle= mostraridAuditoriaDetalle;
	}

	public Boolean getActivaridAuditoriaDetalle() {
		return this.activaridAuditoriaDetalle;
	}

	public void setActivaridAuditoriaDetalle(Boolean activaridAuditoriaDetalle) {
		this.activaridAuditoriaDetalle= activaridAuditoriaDetalle;
	}

	public Border setResaltarid_auditoriaAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltarid_auditoriaAuditoriaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_auditoriaAuditoriaDetalle() {
		return this.resaltarid_auditoriaAuditoriaDetalle;
	}

	public void setResaltarid_auditoriaAuditoriaDetalle(Border borderResaltar) {
		this.resaltarid_auditoriaAuditoriaDetalle= borderResaltar;
	}

	public Boolean getMostrarid_auditoriaAuditoriaDetalle() {
		return this.mostrarid_auditoriaAuditoriaDetalle;
	}

	public void setMostrarid_auditoriaAuditoriaDetalle(Boolean mostrarid_auditoriaAuditoriaDetalle) {
		this.mostrarid_auditoriaAuditoriaDetalle= mostrarid_auditoriaAuditoriaDetalle;
	}

	public Boolean getActivarid_auditoriaAuditoriaDetalle() {
		return this.activarid_auditoriaAuditoriaDetalle;
	}

	public void setActivarid_auditoriaAuditoriaDetalle(Boolean activarid_auditoriaAuditoriaDetalle) {
		this.activarid_auditoriaAuditoriaDetalle= activarid_auditoriaAuditoriaDetalle;
	}

	public Boolean getCargarid_auditoriaAuditoriaDetalle() {
		return this.cargarid_auditoriaAuditoriaDetalle;
	}

	public void setCargarid_auditoriaAuditoriaDetalle(Boolean cargarid_auditoriaAuditoriaDetalle) {
		this.cargarid_auditoriaAuditoriaDetalle= cargarid_auditoriaAuditoriaDetalle;
	}

	public Border setResaltarnombre_campoAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltarnombre_campoAuditoriaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_campoAuditoriaDetalle() {
		return this.resaltarnombre_campoAuditoriaDetalle;
	}

	public void setResaltarnombre_campoAuditoriaDetalle(Border borderResaltar) {
		this.resaltarnombre_campoAuditoriaDetalle= borderResaltar;
	}

	public Boolean getMostrarnombre_campoAuditoriaDetalle() {
		return this.mostrarnombre_campoAuditoriaDetalle;
	}

	public void setMostrarnombre_campoAuditoriaDetalle(Boolean mostrarnombre_campoAuditoriaDetalle) {
		this.mostrarnombre_campoAuditoriaDetalle= mostrarnombre_campoAuditoriaDetalle;
	}

	public Boolean getActivarnombre_campoAuditoriaDetalle() {
		return this.activarnombre_campoAuditoriaDetalle;
	}

	public void setActivarnombre_campoAuditoriaDetalle(Boolean activarnombre_campoAuditoriaDetalle) {
		this.activarnombre_campoAuditoriaDetalle= activarnombre_campoAuditoriaDetalle;
	}

	public Border setResaltarvalor_anteriorAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltarvalor_anteriorAuditoriaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_anteriorAuditoriaDetalle() {
		return this.resaltarvalor_anteriorAuditoriaDetalle;
	}

	public void setResaltarvalor_anteriorAuditoriaDetalle(Border borderResaltar) {
		this.resaltarvalor_anteriorAuditoriaDetalle= borderResaltar;
	}

	public Boolean getMostrarvalor_anteriorAuditoriaDetalle() {
		return this.mostrarvalor_anteriorAuditoriaDetalle;
	}

	public void setMostrarvalor_anteriorAuditoriaDetalle(Boolean mostrarvalor_anteriorAuditoriaDetalle) {
		this.mostrarvalor_anteriorAuditoriaDetalle= mostrarvalor_anteriorAuditoriaDetalle;
	}

	public Boolean getActivarvalor_anteriorAuditoriaDetalle() {
		return this.activarvalor_anteriorAuditoriaDetalle;
	}

	public void setActivarvalor_anteriorAuditoriaDetalle(Boolean activarvalor_anteriorAuditoriaDetalle) {
		this.activarvalor_anteriorAuditoriaDetalle= activarvalor_anteriorAuditoriaDetalle;
	}

	public Border setResaltarvalor_actualAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriadetalleBeanSwingJInternalFrame.jTtoolBarAuditoriaDetalle.setBorder(borderResaltar);
		
		this.resaltarvalor_actualAuditoriaDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_actualAuditoriaDetalle() {
		return this.resaltarvalor_actualAuditoriaDetalle;
	}

	public void setResaltarvalor_actualAuditoriaDetalle(Border borderResaltar) {
		this.resaltarvalor_actualAuditoriaDetalle= borderResaltar;
	}

	public Boolean getMostrarvalor_actualAuditoriaDetalle() {
		return this.mostrarvalor_actualAuditoriaDetalle;
	}

	public void setMostrarvalor_actualAuditoriaDetalle(Boolean mostrarvalor_actualAuditoriaDetalle) {
		this.mostrarvalor_actualAuditoriaDetalle= mostrarvalor_actualAuditoriaDetalle;
	}

	public Boolean getActivarvalor_actualAuditoriaDetalle() {
		return this.activarvalor_actualAuditoriaDetalle;
	}

	public void setActivarvalor_actualAuditoriaDetalle(Boolean activarvalor_actualAuditoriaDetalle) {
		this.activarvalor_actualAuditoriaDetalle= activarvalor_actualAuditoriaDetalle;
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
		
		
		this.setMostraridAuditoriaDetalle(esInicial);
		this.setMostrarid_auditoriaAuditoriaDetalle(esInicial);
		this.setMostrarnombre_campoAuditoriaDetalle(esInicial);
		this.setMostrarvalor_anteriorAuditoriaDetalle(esInicial);
		this.setMostrarvalor_actualAuditoriaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.ID)) {
				this.setMostraridAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.IDAUDITORIA)) {
				this.setMostrarid_auditoriaAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.NOMBRECAMPO)) {
				this.setMostrarnombre_campoAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORANTERIOR)) {
				this.setMostrarvalor_anteriorAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORACTUAL)) {
				this.setMostrarvalor_actualAuditoriaDetalle(esAsigna);
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
		
		
		this.setActivaridAuditoriaDetalle(esInicial);
		this.setActivarid_auditoriaAuditoriaDetalle(esInicial);
		this.setActivarnombre_campoAuditoriaDetalle(esInicial);
		this.setActivarvalor_anteriorAuditoriaDetalle(esInicial);
		this.setActivarvalor_actualAuditoriaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.ID)) {
				this.setActivaridAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.IDAUDITORIA)) {
				this.setActivarid_auditoriaAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.NOMBRECAMPO)) {
				this.setActivarnombre_campoAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORANTERIOR)) {
				this.setActivarvalor_anteriorAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORACTUAL)) {
				this.setActivarvalor_actualAuditoriaDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAuditoriaDetalle(esInicial);
		this.setResaltarid_auditoriaAuditoriaDetalle(esInicial);
		this.setResaltarnombre_campoAuditoriaDetalle(esInicial);
		this.setResaltarvalor_anteriorAuditoriaDetalle(esInicial);
		this.setResaltarvalor_actualAuditoriaDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.ID)) {
				this.setResaltaridAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.IDAUDITORIA)) {
				this.setResaltarid_auditoriaAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.NOMBRECAMPO)) {
				this.setResaltarnombre_campoAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORANTERIOR)) {
				this.setResaltarvalor_anteriorAuditoriaDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaDetalleConstantesFunciones.VALORACTUAL)) {
				this.setResaltarvalor_actualAuditoriaDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle=true;

	public Boolean getMostrarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle() {
		return this.mostrarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle;
	}

	public void setMostrarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAuditoriaAuditoriaDetalle=true;

	public Boolean getMostrarFK_IdAuditoriaAuditoriaDetalle() {
		return this.mostrarFK_IdAuditoriaAuditoriaDetalle;
	}

	public void setMostrarFK_IdAuditoriaAuditoriaDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAuditoriaAuditoriaDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle=true;

	public Boolean getActivarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle() {
		return this.activarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle;
	}

	public void setActivarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdAuditoriaAuditoriaDetalle=true;

	public Boolean getActivarFK_IdAuditoriaAuditoriaDetalle() {
		return this.activarFK_IdAuditoriaAuditoriaDetalle;
	}

	public void setActivarFK_IdAuditoriaAuditoriaDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdAuditoriaAuditoriaDetalle= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle=null;

	public Border getResaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle() {
		return this.resaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle;
	}

	public void setResaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle(Border borderResaltar) {
		this.resaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle= borderResaltar;
	}

	public void setResaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdAuditoriaPorNombreCampoAuditoriaDetalle= borderResaltar;
	}

	public Border resaltarFK_IdAuditoriaAuditoriaDetalle=null;

	public Border getResaltarFK_IdAuditoriaAuditoriaDetalle() {
		return this.resaltarFK_IdAuditoriaAuditoriaDetalle;
	}

	public void setResaltarFK_IdAuditoriaAuditoriaDetalle(Border borderResaltar) {
		this.resaltarFK_IdAuditoriaAuditoriaDetalle= borderResaltar;
	}

	public void setResaltarFK_IdAuditoriaAuditoriaDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaDetalleBeanSwingJInternalFrame auditoriadetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAuditoriaAuditoriaDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
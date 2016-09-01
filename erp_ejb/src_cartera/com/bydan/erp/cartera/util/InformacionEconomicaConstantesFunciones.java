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


import com.bydan.erp.cartera.util.InformacionEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionEconomicaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionEconomicaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class InformacionEconomicaConstantesFunciones extends InformacionEconomicaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="InformacionEconomica";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="InformacionEconomica"+InformacionEconomicaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="InformacionEconomicaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="InformacionEconomicaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=InformacionEconomicaConstantesFunciones.SCHEMA+"_"+InformacionEconomicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/InformacionEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=InformacionEconomicaConstantesFunciones.SCHEMA+"_"+InformacionEconomicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=InformacionEconomicaConstantesFunciones.SCHEMA+"_"+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/InformacionEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=InformacionEconomicaConstantesFunciones.SCHEMA+"_"+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionEconomicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionEconomicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=InformacionEconomicaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+InformacionEconomicaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=InformacionEconomicaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+InformacionEconomicaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Informacion Economicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Informacion Economica";
	public static final String SCLASSWEBTITULO_LOWER="Informacion Economica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="InformacionEconomica";
	public static final String OBJECTNAME="informacioneconomica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="informacioneconomica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select informacioneconomica from "+InformacionEconomicaConstantesFunciones.SPERSISTENCENAME+" informacioneconomica";
	public static String QUERYSELECTNATIVE="select "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".id,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".version_row,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".idcliente,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".idvalorclientevinculacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".codigoactualizacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".codigodestinofinanciero,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".origenrecursos,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".cuasavinculacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".sectorizacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".esactivo from "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME;//+" as "+InformacionEconomicaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected InformacionEconomicaConstantesFuncionesAdditional informacioneconomicaConstantesFuncionesAdditional=null;
	
	public InformacionEconomicaConstantesFuncionesAdditional getInformacionEconomicaConstantesFuncionesAdditional() {
		return this.informacioneconomicaConstantesFuncionesAdditional;
	}
	
	public void setInformacionEconomicaConstantesFuncionesAdditional(InformacionEconomicaConstantesFuncionesAdditional informacioneconomicaConstantesFuncionesAdditional) {
		try {
			this.informacioneconomicaConstantesFuncionesAdditional=informacioneconomicaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOVINCULACION= "idvalorclientevinculacion";
    public static final String CODIGOACTUALIZACION= "codigoactualizacion";
    public static final String CODIGODESTINOFINANCIERO= "codigodestinofinanciero";
    public static final String ORIGENRECURSOS= "origenrecursos";
    public static final String CUASAVINCULACION= "cuasavinculacion";
    public static final String SECTORIZACION= "sectorizacion";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOVINCULACION= "Tipo Vinculacion";
		public static final String LABEL_IDTIPOVINCULACION_LOWER= "Tipo Vinculacion";
    	public static final String LABEL_CODIGOACTUALIZACION= "Codigo Actualizacion";
		public static final String LABEL_CODIGOACTUALIZACION_LOWER= "Codigo Actualizacion";
    	public static final String LABEL_CODIGODESTINOFINANCIERO= "Codigo Destino Financiero";
		public static final String LABEL_CODIGODESTINOFINANCIERO_LOWER= "Codigo Destino Financiero";
    	public static final String LABEL_ORIGENRECURSOS= "Origen Recursos";
		public static final String LABEL_ORIGENRECURSOS_LOWER= "Origen Recursos";
    	public static final String LABEL_CUASAVINCULACION= "Cuasa Vinculacion";
		public static final String LABEL_CUASAVINCULACION_LOWER= "Cuasa Vinculacion";
    	public static final String LABEL_SECTORIZACION= "Sectorizacion";
		public static final String LABEL_SECTORIZACION_LOWER= "Sectorizacion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
	public static final String SREGEXCODIGOACTUALIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGOACTUALIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGODESTINOFINANCIERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGODESTINOFINANCIERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORIGENRECURSOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORIGENRECURSOS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCUASAVINCULACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCUASAVINCULACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getInformacionEconomicaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.IDCLIENTE)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_IDTIPOVINCULACION;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_CODIGOACTUALIZACION;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_CODIGODESTINOFINANCIERO;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.ORIGENRECURSOS)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_ORIGENRECURSOS;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.CUASAVINCULACION)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_CUASAVINCULACION;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.SECTORIZACION)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_SECTORIZACION;}
		if(sNombreColumna.equals(InformacionEconomicaConstantesFunciones.ESACTIVO)) {sLabelColumna=InformacionEconomicaConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(InformacionEconomica informacioneconomica) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!informacioneconomica.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(InformacionEconomica informacioneconomica) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(informacioneconomica.getId(),informacioneconomica.getesactivo());

		return sDescripcion;
	}	
	
	public static String getInformacionEconomicaDescripcion(InformacionEconomica informacioneconomica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(informacioneconomica !=null/* && informacioneconomica.getId()!=0*/) {
			sDescripcion=informacioneconomica.getcodigoactualizacion();//informacioneconomicainformacioneconomica.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getInformacionEconomicaDescripcionDetallado(InformacionEconomica informacioneconomica) {
		String sDescripcion="";
			
		sDescripcion+=InformacionEconomicaConstantesFunciones.ID+"=";
		sDescripcion+=informacioneconomica.getId().toString()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=informacioneconomica.getVersionRow().toString()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=informacioneconomica.getidcliente().toString()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION+"=";
		sDescripcion+=informacioneconomica.getidvalorclientevinculacion().toString()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION+"=";
		sDescripcion+=informacioneconomica.getcodigoactualizacion()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO+"=";
		sDescripcion+=informacioneconomica.getcodigodestinofinanciero()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.ORIGENRECURSOS+"=";
		sDescripcion+=informacioneconomica.getorigenrecursos()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.CUASAVINCULACION+"=";
		sDescripcion+=informacioneconomica.getcuasavinculacion()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.SECTORIZACION+"=";
		sDescripcion+=informacioneconomica.getsectorizacion()+",";
		sDescripcion+=InformacionEconomicaConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=informacioneconomica.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setInformacionEconomicaDescripcion(InformacionEconomica informacioneconomica,String sValor) throws Exception {			
		if(informacioneconomica !=null) {
			informacioneconomica.setcodigoactualizacion(sValor);//informacioneconomicainformacioneconomica.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoVinculacionDescripcion(TipoVinculacion tipovinculacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovinculacion!=null/*&&tipovinculacion.getId()>0*/) {
			sDescripcion=TipoVinculacionConstantesFunciones.getTipoVinculacionDescripcion(tipovinculacion);
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
		} else if(sNombreIndice.equals("FK_IdValorClienteVinculacion")) {
			sNombreIndice="Tipo=  Por Tipo Vinculacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteVinculacion(Long idvalorclientevinculacion) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientevinculacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Vinculacion="+idvalorclientevinculacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosInformacionEconomica(InformacionEconomica informacioneconomica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		informacioneconomica.setcodigoactualizacion(informacioneconomica.getcodigoactualizacion().trim());
		informacioneconomica.setcodigodestinofinanciero(informacioneconomica.getcodigodestinofinanciero().trim());
		informacioneconomica.setorigenrecursos(informacioneconomica.getorigenrecursos().trim());
		informacioneconomica.setcuasavinculacion(informacioneconomica.getcuasavinculacion().trim());
		informacioneconomica.setsectorizacion(informacioneconomica.getsectorizacion().trim());
	}
	
	public static void quitarEspaciosInformacionEconomicas(List<InformacionEconomica> informacioneconomicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(InformacionEconomica informacioneconomica: informacioneconomicas) {
			informacioneconomica.setcodigoactualizacion(informacioneconomica.getcodigoactualizacion().trim());
			informacioneconomica.setcodigodestinofinanciero(informacioneconomica.getcodigodestinofinanciero().trim());
			informacioneconomica.setorigenrecursos(informacioneconomica.getorigenrecursos().trim());
			informacioneconomica.setcuasavinculacion(informacioneconomica.getcuasavinculacion().trim());
			informacioneconomica.setsectorizacion(informacioneconomica.getsectorizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionEconomica(InformacionEconomica informacioneconomica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && informacioneconomica.getConCambioAuxiliar()) {
			informacioneconomica.setIsDeleted(informacioneconomica.getIsDeletedAuxiliar());	
			informacioneconomica.setIsNew(informacioneconomica.getIsNewAuxiliar());	
			informacioneconomica.setIsChanged(informacioneconomica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			informacioneconomica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			informacioneconomica.setIsDeletedAuxiliar(false);	
			informacioneconomica.setIsNewAuxiliar(false);	
			informacioneconomica.setIsChangedAuxiliar(false);
			
			informacioneconomica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionEconomicas(List<InformacionEconomica> informacioneconomicas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(InformacionEconomica informacioneconomica : informacioneconomicas) {
			if(conAsignarBase && informacioneconomica.getConCambioAuxiliar()) {
				informacioneconomica.setIsDeleted(informacioneconomica.getIsDeletedAuxiliar());	
				informacioneconomica.setIsNew(informacioneconomica.getIsNewAuxiliar());	
				informacioneconomica.setIsChanged(informacioneconomica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				informacioneconomica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				informacioneconomica.setIsDeletedAuxiliar(false);	
				informacioneconomica.setIsNewAuxiliar(false);	
				informacioneconomica.setIsChangedAuxiliar(false);
				
				informacioneconomica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresInformacionEconomica(InformacionEconomica informacioneconomica,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresInformacionEconomicas(List<InformacionEconomica> informacioneconomicas,Boolean conEnteros) throws Exception  {
		
		for(InformacionEconomica informacioneconomica: informacioneconomicas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaInformacionEconomica(List<InformacionEconomica> informacioneconomicas,InformacionEconomica informacioneconomicaAux) throws Exception  {
		InformacionEconomicaConstantesFunciones.InicializarValoresInformacionEconomica(informacioneconomicaAux,true);
		
		for(InformacionEconomica informacioneconomica: informacioneconomicas) {
			if(informacioneconomica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionEconomica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=InformacionEconomicaConstantesFunciones.getArrayColumnasGlobalesInformacionEconomica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionEconomica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoInformacionEconomica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<InformacionEconomica> informacioneconomicas,InformacionEconomica informacioneconomica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(InformacionEconomica informacioneconomicaAux: informacioneconomicas) {
			if(informacioneconomicaAux!=null && informacioneconomica!=null) {
				if((informacioneconomicaAux.getId()==null && informacioneconomica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(informacioneconomicaAux.getId()!=null && informacioneconomica.getId()!=null){
					if(informacioneconomicaAux.getId().equals(informacioneconomica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInformacionEconomica(List<InformacionEconomica> informacioneconomicas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(InformacionEconomica informacioneconomica: informacioneconomicas) {			
			if(informacioneconomica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaInformacionEconomica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_ID, InformacionEconomicaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_VERSIONROW, InformacionEconomicaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_IDCLIENTE, InformacionEconomicaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_IDTIPOVINCULACION, InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_CODIGOACTUALIZACION, InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_CODIGODESTINOFINANCIERO, InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_ORIGENRECURSOS, InformacionEconomicaConstantesFunciones.ORIGENRECURSOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_CUASAVINCULACION, InformacionEconomicaConstantesFunciones.CUASAVINCULACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_SECTORIZACION, InformacionEconomicaConstantesFunciones.SECTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionEconomicaConstantesFunciones.LABEL_ESACTIVO, InformacionEconomicaConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasInformacionEconomica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.ORIGENRECURSOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.CUASAVINCULACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.SECTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionEconomicaConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionEconomica() throws Exception  {
		return InformacionEconomicaConstantesFunciones.getTiposSeleccionarInformacionEconomica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionEconomica(Boolean conFk) throws Exception  {
		return InformacionEconomicaConstantesFunciones.getTiposSeleccionarInformacionEconomica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionEconomica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_IDTIPOVINCULACION);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_IDTIPOVINCULACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_CODIGOACTUALIZACION);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_CODIGOACTUALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_CODIGODESTINOFINANCIERO);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_CODIGODESTINOFINANCIERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_ORIGENRECURSOS);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_ORIGENRECURSOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_CUASAVINCULACION);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_CUASAVINCULACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_SECTORIZACION);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_SECTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionEconomicaConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(InformacionEconomicaConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesInformacionEconomica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionEconomica(InformacionEconomica informacioneconomicaAux) throws Exception {
		
			informacioneconomicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacioneconomicaAux.getCliente()));
			informacioneconomicaAux.settipovinculacion_descripcion(TipoVinculacionConstantesFunciones.getTipoVinculacionDescripcion(informacioneconomicaAux.getTipoVinculacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionEconomica(List<InformacionEconomica> informacioneconomicasTemp) throws Exception {
		for(InformacionEconomica informacioneconomicaAux:informacioneconomicasTemp) {
			
			informacioneconomicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacioneconomicaAux.getCliente()));
			informacioneconomicaAux.settipovinculacion_descripcion(TipoVinculacionConstantesFunciones.getTipoVinculacionDescripcion(informacioneconomicaAux.getTipoVinculacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoVinculacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoVinculacion.class)) {
						classes.add(new Classe(TipoVinculacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfInformacionEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoVinculacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVinculacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoVinculacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoVinculacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionEconomicaConstantesFunciones.getClassesRelationshipsOfInformacionEconomica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionEconomicaConstantesFunciones.getClassesRelationshipsFromStringsOfInformacionEconomica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionEconomica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(InformacionEconomica informacioneconomica,List<InformacionEconomica> informacioneconomicas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			InformacionEconomica informacioneconomicaEncontrado=null;
			
			for(InformacionEconomica informacioneconomicaLocal:informacioneconomicas) {
				if(informacioneconomicaLocal.getId().equals(informacioneconomica.getId())) {
					informacioneconomicaEncontrado=informacioneconomicaLocal;
					
					informacioneconomicaLocal.setIsChanged(informacioneconomica.getIsChanged());
					informacioneconomicaLocal.setIsNew(informacioneconomica.getIsNew());
					informacioneconomicaLocal.setIsDeleted(informacioneconomica.getIsDeleted());
					
					informacioneconomicaLocal.setGeneralEntityOriginal(informacioneconomica.getGeneralEntityOriginal());
					
					informacioneconomicaLocal.setId(informacioneconomica.getId());	
					informacioneconomicaLocal.setVersionRow(informacioneconomica.getVersionRow());	
					informacioneconomicaLocal.setidcliente(informacioneconomica.getidcliente());	
					informacioneconomicaLocal.setidvalorclientevinculacion(informacioneconomica.getidvalorclientevinculacion());	
					informacioneconomicaLocal.setcodigoactualizacion(informacioneconomica.getcodigoactualizacion());	
					informacioneconomicaLocal.setcodigodestinofinanciero(informacioneconomica.getcodigodestinofinanciero());	
					informacioneconomicaLocal.setorigenrecursos(informacioneconomica.getorigenrecursos());	
					informacioneconomicaLocal.setcuasavinculacion(informacioneconomica.getcuasavinculacion());	
					informacioneconomicaLocal.setsectorizacion(informacioneconomica.getsectorizacion());	
					informacioneconomicaLocal.setesactivo(informacioneconomica.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!informacioneconomica.getIsDeleted()) {
				if(!existe) {
					informacioneconomicas.add(informacioneconomica);
				}
			} else {
				if(informacioneconomicaEncontrado!=null && permiteQuitar)  {
					informacioneconomicas.remove(informacioneconomicaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(InformacionEconomica informacioneconomica,List<InformacionEconomica> informacioneconomicas) throws Exception {
		try	{			
			for(InformacionEconomica informacioneconomicaLocal:informacioneconomicas) {
				if(informacioneconomicaLocal.getId().equals(informacioneconomica.getId())) {
					informacioneconomicaLocal.setIsSelected(informacioneconomica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesInformacionEconomica(List<InformacionEconomica> informacioneconomicasAux) throws Exception {
		//this.informacioneconomicasAux=informacioneconomicasAux;
		
		for(InformacionEconomica informacioneconomicaAux:informacioneconomicasAux) {
			if(informacioneconomicaAux.getIsChanged()) {
				informacioneconomicaAux.setIsChanged(false);
			}		
			
			if(informacioneconomicaAux.getIsNew()) {
				informacioneconomicaAux.setIsNew(false);
			}	
			
			if(informacioneconomicaAux.getIsDeleted()) {
				informacioneconomicaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesInformacionEconomica(InformacionEconomica informacioneconomicaAux) throws Exception {
		//this.informacioneconomicaAux=informacioneconomicaAux;
		
			if(informacioneconomicaAux.getIsChanged()) {
				informacioneconomicaAux.setIsChanged(false);
			}		
			
			if(informacioneconomicaAux.getIsNew()) {
				informacioneconomicaAux.setIsNew(false);
			}	
			
			if(informacioneconomicaAux.getIsDeleted()) {
				informacioneconomicaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(InformacionEconomica informacioneconomicaAsignar,InformacionEconomica informacioneconomica) throws Exception {
		informacioneconomicaAsignar.setId(informacioneconomica.getId());	
		informacioneconomicaAsignar.setVersionRow(informacioneconomica.getVersionRow());	
		informacioneconomicaAsignar.setidcliente(informacioneconomica.getidcliente());
		informacioneconomicaAsignar.setcliente_descripcion(informacioneconomica.getcliente_descripcion());	
		informacioneconomicaAsignar.setidvalorclientevinculacion(informacioneconomica.getidvalorclientevinculacion());
		informacioneconomicaAsignar.settipovinculacion_descripcion(informacioneconomica.gettipovinculacion_descripcion());	
		informacioneconomicaAsignar.setcodigoactualizacion(informacioneconomica.getcodigoactualizacion());	
		informacioneconomicaAsignar.setcodigodestinofinanciero(informacioneconomica.getcodigodestinofinanciero());	
		informacioneconomicaAsignar.setorigenrecursos(informacioneconomica.getorigenrecursos());	
		informacioneconomicaAsignar.setcuasavinculacion(informacioneconomica.getcuasavinculacion());	
		informacioneconomicaAsignar.setsectorizacion(informacioneconomica.getsectorizacion());	
		informacioneconomicaAsignar.setesactivo(informacioneconomica.getesactivo());	
	}
	
	public static void inicializarInformacionEconomica(InformacionEconomica informacioneconomica) throws Exception {
		try {
				informacioneconomica.setId(0L);	
					
				informacioneconomica.setidcliente(-1L);	
				informacioneconomica.setidvalorclientevinculacion(-1L);	
				informacioneconomica.setcodigoactualizacion("");	
				informacioneconomica.setcodigodestinofinanciero("");	
				informacioneconomica.setorigenrecursos("");	
				informacioneconomica.setcuasavinculacion("");	
				informacioneconomica.setsectorizacion("");	
				informacioneconomica.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderInformacionEconomica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_IDTIPOVINCULACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_CODIGOACTUALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_CODIGODESTINOFINANCIERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_ORIGENRECURSOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_CUASAVINCULACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_SECTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionEconomicaConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataInformacionEconomica(String sTipo,Row row,Workbook workbook,InformacionEconomica informacioneconomica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.gettipovinculacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getcodigoactualizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getcodigodestinofinanciero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getorigenrecursos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getcuasavinculacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacioneconomica.getsectorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(informacioneconomica.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryInformacionEconomica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryInformacionEconomica() {
		return this.sFinalQueryInformacionEconomica;
	}
	
	public void setsFinalQueryInformacionEconomica(String sFinalQueryInformacionEconomica) {
		this.sFinalQueryInformacionEconomica= sFinalQueryInformacionEconomica;
	}
	
	public Border resaltarSeleccionarInformacionEconomica=null;
	
	public Border setResaltarSeleccionarInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarInformacionEconomica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarInformacionEconomica() {
		return this.resaltarSeleccionarInformacionEconomica;
	}
	
	public void setResaltarSeleccionarInformacionEconomica(Border borderResaltarSeleccionarInformacionEconomica) {
		this.resaltarSeleccionarInformacionEconomica= borderResaltarSeleccionarInformacionEconomica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridInformacionEconomica=null;
	public Boolean mostraridInformacionEconomica=true;
	public Boolean activaridInformacionEconomica=true;

	public Border resaltaridclienteInformacionEconomica=null;
	public Boolean mostraridclienteInformacionEconomica=true;
	public Boolean activaridclienteInformacionEconomica=true;
	public Boolean cargaridclienteInformacionEconomica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteInformacionEconomica=false;//ConEventDepend=true

	public Border resaltaridvalorclientevinculacionInformacionEconomica=null;
	public Boolean mostraridvalorclientevinculacionInformacionEconomica=true;
	public Boolean activaridvalorclientevinculacionInformacionEconomica=true;
	public Boolean cargaridvalorclientevinculacionInformacionEconomica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientevinculacionInformacionEconomica=false;//ConEventDepend=true

	public Border resaltarcodigoactualizacionInformacionEconomica=null;
	public Boolean mostrarcodigoactualizacionInformacionEconomica=true;
	public Boolean activarcodigoactualizacionInformacionEconomica=true;

	public Border resaltarcodigodestinofinancieroInformacionEconomica=null;
	public Boolean mostrarcodigodestinofinancieroInformacionEconomica=true;
	public Boolean activarcodigodestinofinancieroInformacionEconomica=true;

	public Border resaltarorigenrecursosInformacionEconomica=null;
	public Boolean mostrarorigenrecursosInformacionEconomica=true;
	public Boolean activarorigenrecursosInformacionEconomica=true;

	public Border resaltarcuasavinculacionInformacionEconomica=null;
	public Boolean mostrarcuasavinculacionInformacionEconomica=true;
	public Boolean activarcuasavinculacionInformacionEconomica=true;

	public Border resaltarsectorizacionInformacionEconomica=null;
	public Boolean mostrarsectorizacionInformacionEconomica=true;
	public Boolean activarsectorizacionInformacionEconomica=true;

	public Border resaltaresactivoInformacionEconomica=null;
	public Boolean mostraresactivoInformacionEconomica=true;
	public Boolean activaresactivoInformacionEconomica=true;

	
	

	public Border setResaltaridInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltaridInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridInformacionEconomica() {
		return this.resaltaridInformacionEconomica;
	}

	public void setResaltaridInformacionEconomica(Border borderResaltar) {
		this.resaltaridInformacionEconomica= borderResaltar;
	}

	public Boolean getMostraridInformacionEconomica() {
		return this.mostraridInformacionEconomica;
	}

	public void setMostraridInformacionEconomica(Boolean mostraridInformacionEconomica) {
		this.mostraridInformacionEconomica= mostraridInformacionEconomica;
	}

	public Boolean getActivaridInformacionEconomica() {
		return this.activaridInformacionEconomica;
	}

	public void setActivaridInformacionEconomica(Boolean activaridInformacionEconomica) {
		this.activaridInformacionEconomica= activaridInformacionEconomica;
	}

	public Border setResaltaridclienteInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltaridclienteInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteInformacionEconomica() {
		return this.resaltaridclienteInformacionEconomica;
	}

	public void setResaltaridclienteInformacionEconomica(Border borderResaltar) {
		this.resaltaridclienteInformacionEconomica= borderResaltar;
	}

	public Boolean getMostraridclienteInformacionEconomica() {
		return this.mostraridclienteInformacionEconomica;
	}

	public void setMostraridclienteInformacionEconomica(Boolean mostraridclienteInformacionEconomica) {
		this.mostraridclienteInformacionEconomica= mostraridclienteInformacionEconomica;
	}

	public Boolean getActivaridclienteInformacionEconomica() {
		return this.activaridclienteInformacionEconomica;
	}

	public void setActivaridclienteInformacionEconomica(Boolean activaridclienteInformacionEconomica) {
		this.activaridclienteInformacionEconomica= activaridclienteInformacionEconomica;
	}

	public Boolean getCargaridclienteInformacionEconomica() {
		return this.cargaridclienteInformacionEconomica;
	}

	public void setCargaridclienteInformacionEconomica(Boolean cargaridclienteInformacionEconomica) {
		this.cargaridclienteInformacionEconomica= cargaridclienteInformacionEconomica;
	}

	public Border setResaltaridvalorclientevinculacionInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltaridvalorclientevinculacionInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientevinculacionInformacionEconomica() {
		return this.resaltaridvalorclientevinculacionInformacionEconomica;
	}

	public void setResaltaridvalorclientevinculacionInformacionEconomica(Border borderResaltar) {
		this.resaltaridvalorclientevinculacionInformacionEconomica= borderResaltar;
	}

	public Boolean getMostraridvalorclientevinculacionInformacionEconomica() {
		return this.mostraridvalorclientevinculacionInformacionEconomica;
	}

	public void setMostraridvalorclientevinculacionInformacionEconomica(Boolean mostraridvalorclientevinculacionInformacionEconomica) {
		this.mostraridvalorclientevinculacionInformacionEconomica= mostraridvalorclientevinculacionInformacionEconomica;
	}

	public Boolean getActivaridvalorclientevinculacionInformacionEconomica() {
		return this.activaridvalorclientevinculacionInformacionEconomica;
	}

	public void setActivaridvalorclientevinculacionInformacionEconomica(Boolean activaridvalorclientevinculacionInformacionEconomica) {
		this.activaridvalorclientevinculacionInformacionEconomica= activaridvalorclientevinculacionInformacionEconomica;
	}

	public Boolean getCargaridvalorclientevinculacionInformacionEconomica() {
		return this.cargaridvalorclientevinculacionInformacionEconomica;
	}

	public void setCargaridvalorclientevinculacionInformacionEconomica(Boolean cargaridvalorclientevinculacionInformacionEconomica) {
		this.cargaridvalorclientevinculacionInformacionEconomica= cargaridvalorclientevinculacionInformacionEconomica;
	}

	public Border setResaltarcodigoactualizacionInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarcodigoactualizacionInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoactualizacionInformacionEconomica() {
		return this.resaltarcodigoactualizacionInformacionEconomica;
	}

	public void setResaltarcodigoactualizacionInformacionEconomica(Border borderResaltar) {
		this.resaltarcodigoactualizacionInformacionEconomica= borderResaltar;
	}

	public Boolean getMostrarcodigoactualizacionInformacionEconomica() {
		return this.mostrarcodigoactualizacionInformacionEconomica;
	}

	public void setMostrarcodigoactualizacionInformacionEconomica(Boolean mostrarcodigoactualizacionInformacionEconomica) {
		this.mostrarcodigoactualizacionInformacionEconomica= mostrarcodigoactualizacionInformacionEconomica;
	}

	public Boolean getActivarcodigoactualizacionInformacionEconomica() {
		return this.activarcodigoactualizacionInformacionEconomica;
	}

	public void setActivarcodigoactualizacionInformacionEconomica(Boolean activarcodigoactualizacionInformacionEconomica) {
		this.activarcodigoactualizacionInformacionEconomica= activarcodigoactualizacionInformacionEconomica;
	}

	public Border setResaltarcodigodestinofinancieroInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarcodigodestinofinancieroInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigodestinofinancieroInformacionEconomica() {
		return this.resaltarcodigodestinofinancieroInformacionEconomica;
	}

	public void setResaltarcodigodestinofinancieroInformacionEconomica(Border borderResaltar) {
		this.resaltarcodigodestinofinancieroInformacionEconomica= borderResaltar;
	}

	public Boolean getMostrarcodigodestinofinancieroInformacionEconomica() {
		return this.mostrarcodigodestinofinancieroInformacionEconomica;
	}

	public void setMostrarcodigodestinofinancieroInformacionEconomica(Boolean mostrarcodigodestinofinancieroInformacionEconomica) {
		this.mostrarcodigodestinofinancieroInformacionEconomica= mostrarcodigodestinofinancieroInformacionEconomica;
	}

	public Boolean getActivarcodigodestinofinancieroInformacionEconomica() {
		return this.activarcodigodestinofinancieroInformacionEconomica;
	}

	public void setActivarcodigodestinofinancieroInformacionEconomica(Boolean activarcodigodestinofinancieroInformacionEconomica) {
		this.activarcodigodestinofinancieroInformacionEconomica= activarcodigodestinofinancieroInformacionEconomica;
	}

	public Border setResaltarorigenrecursosInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarorigenrecursosInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorigenrecursosInformacionEconomica() {
		return this.resaltarorigenrecursosInformacionEconomica;
	}

	public void setResaltarorigenrecursosInformacionEconomica(Border borderResaltar) {
		this.resaltarorigenrecursosInformacionEconomica= borderResaltar;
	}

	public Boolean getMostrarorigenrecursosInformacionEconomica() {
		return this.mostrarorigenrecursosInformacionEconomica;
	}

	public void setMostrarorigenrecursosInformacionEconomica(Boolean mostrarorigenrecursosInformacionEconomica) {
		this.mostrarorigenrecursosInformacionEconomica= mostrarorigenrecursosInformacionEconomica;
	}

	public Boolean getActivarorigenrecursosInformacionEconomica() {
		return this.activarorigenrecursosInformacionEconomica;
	}

	public void setActivarorigenrecursosInformacionEconomica(Boolean activarorigenrecursosInformacionEconomica) {
		this.activarorigenrecursosInformacionEconomica= activarorigenrecursosInformacionEconomica;
	}

	public Border setResaltarcuasavinculacionInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarcuasavinculacionInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuasavinculacionInformacionEconomica() {
		return this.resaltarcuasavinculacionInformacionEconomica;
	}

	public void setResaltarcuasavinculacionInformacionEconomica(Border borderResaltar) {
		this.resaltarcuasavinculacionInformacionEconomica= borderResaltar;
	}

	public Boolean getMostrarcuasavinculacionInformacionEconomica() {
		return this.mostrarcuasavinculacionInformacionEconomica;
	}

	public void setMostrarcuasavinculacionInformacionEconomica(Boolean mostrarcuasavinculacionInformacionEconomica) {
		this.mostrarcuasavinculacionInformacionEconomica= mostrarcuasavinculacionInformacionEconomica;
	}

	public Boolean getActivarcuasavinculacionInformacionEconomica() {
		return this.activarcuasavinculacionInformacionEconomica;
	}

	public void setActivarcuasavinculacionInformacionEconomica(Boolean activarcuasavinculacionInformacionEconomica) {
		this.activarcuasavinculacionInformacionEconomica= activarcuasavinculacionInformacionEconomica;
	}

	public Border setResaltarsectorizacionInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltarsectorizacionInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsectorizacionInformacionEconomica() {
		return this.resaltarsectorizacionInformacionEconomica;
	}

	public void setResaltarsectorizacionInformacionEconomica(Border borderResaltar) {
		this.resaltarsectorizacionInformacionEconomica= borderResaltar;
	}

	public Boolean getMostrarsectorizacionInformacionEconomica() {
		return this.mostrarsectorizacionInformacionEconomica;
	}

	public void setMostrarsectorizacionInformacionEconomica(Boolean mostrarsectorizacionInformacionEconomica) {
		this.mostrarsectorizacionInformacionEconomica= mostrarsectorizacionInformacionEconomica;
	}

	public Boolean getActivarsectorizacionInformacionEconomica() {
		return this.activarsectorizacionInformacionEconomica;
	}

	public void setActivarsectorizacionInformacionEconomica(Boolean activarsectorizacionInformacionEconomica) {
		this.activarsectorizacionInformacionEconomica= activarsectorizacionInformacionEconomica;
	}

	public Border setResaltaresactivoInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacioneconomicaBeanSwingJInternalFrame.jTtoolBarInformacionEconomica.setBorder(borderResaltar);
		
		this.resaltaresactivoInformacionEconomica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoInformacionEconomica() {
		return this.resaltaresactivoInformacionEconomica;
	}

	public void setResaltaresactivoInformacionEconomica(Border borderResaltar) {
		this.resaltaresactivoInformacionEconomica= borderResaltar;
	}

	public Boolean getMostraresactivoInformacionEconomica() {
		return this.mostraresactivoInformacionEconomica;
	}

	public void setMostraresactivoInformacionEconomica(Boolean mostraresactivoInformacionEconomica) {
		this.mostraresactivoInformacionEconomica= mostraresactivoInformacionEconomica;
	}

	public Boolean getActivaresactivoInformacionEconomica() {
		return this.activaresactivoInformacionEconomica;
	}

	public void setActivaresactivoInformacionEconomica(Boolean activaresactivoInformacionEconomica) {
		this.activaresactivoInformacionEconomica= activaresactivoInformacionEconomica;
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
		
		
		this.setMostraridInformacionEconomica(esInicial);
		this.setMostraridclienteInformacionEconomica(esInicial);
		this.setMostraridvalorclientevinculacionInformacionEconomica(esInicial);
		this.setMostrarcodigoactualizacionInformacionEconomica(esInicial);
		this.setMostrarcodigodestinofinancieroInformacionEconomica(esInicial);
		this.setMostrarorigenrecursosInformacionEconomica(esInicial);
		this.setMostrarcuasavinculacionInformacionEconomica(esInicial);
		this.setMostrarsectorizacionInformacionEconomica(esInicial);
		this.setMostraresactivoInformacionEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ID)) {
				this.setMostraridInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION)) {
				this.setMostraridvalorclientevinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION)) {
				this.setMostrarcodigoactualizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO)) {
				this.setMostrarcodigodestinofinancieroInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ORIGENRECURSOS)) {
				this.setMostrarorigenrecursosInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CUASAVINCULACION)) {
				this.setMostrarcuasavinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.SECTORIZACION)) {
				this.setMostrarsectorizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoInformacionEconomica(esAsigna);
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
		
		
		this.setActivaridInformacionEconomica(esInicial);
		this.setActivaridclienteInformacionEconomica(esInicial);
		this.setActivaridvalorclientevinculacionInformacionEconomica(esInicial);
		this.setActivarcodigoactualizacionInformacionEconomica(esInicial);
		this.setActivarcodigodestinofinancieroInformacionEconomica(esInicial);
		this.setActivarorigenrecursosInformacionEconomica(esInicial);
		this.setActivarcuasavinculacionInformacionEconomica(esInicial);
		this.setActivarsectorizacionInformacionEconomica(esInicial);
		this.setActivaresactivoInformacionEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ID)) {
				this.setActivaridInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION)) {
				this.setActivaridvalorclientevinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION)) {
				this.setActivarcodigoactualizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO)) {
				this.setActivarcodigodestinofinancieroInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ORIGENRECURSOS)) {
				this.setActivarorigenrecursosInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CUASAVINCULACION)) {
				this.setActivarcuasavinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.SECTORIZACION)) {
				this.setActivarsectorizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoInformacionEconomica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridInformacionEconomica(esInicial);
		this.setResaltaridclienteInformacionEconomica(esInicial);
		this.setResaltaridvalorclientevinculacionInformacionEconomica(esInicial);
		this.setResaltarcodigoactualizacionInformacionEconomica(esInicial);
		this.setResaltarcodigodestinofinancieroInformacionEconomica(esInicial);
		this.setResaltarorigenrecursosInformacionEconomica(esInicial);
		this.setResaltarcuasavinculacionInformacionEconomica(esInicial);
		this.setResaltarsectorizacionInformacionEconomica(esInicial);
		this.setResaltaresactivoInformacionEconomica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ID)) {
				this.setResaltaridInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION)) {
				this.setResaltaridvalorclientevinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION)) {
				this.setResaltarcodigoactualizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO)) {
				this.setResaltarcodigodestinofinancieroInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ORIGENRECURSOS)) {
				this.setResaltarorigenrecursosInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.CUASAVINCULACION)) {
				this.setResaltarcuasavinculacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.SECTORIZACION)) {
				this.setResaltarsectorizacionInformacionEconomica(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionEconomicaConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoInformacionEconomica(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteInformacionEconomica=true;

	public Boolean getMostrarFK_IdClienteInformacionEconomica() {
		return this.mostrarFK_IdClienteInformacionEconomica;
	}

	public void setMostrarFK_IdClienteInformacionEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteInformacionEconomica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteVinculacionInformacionEconomica=true;

	public Boolean getMostrarFK_IdValorClienteVinculacionInformacionEconomica() {
		return this.mostrarFK_IdValorClienteVinculacionInformacionEconomica;
	}

	public void setMostrarFK_IdValorClienteVinculacionInformacionEconomica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteVinculacionInformacionEconomica= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteInformacionEconomica=true;

	public Boolean getActivarFK_IdClienteInformacionEconomica() {
		return this.activarFK_IdClienteInformacionEconomica;
	}

	public void setActivarFK_IdClienteInformacionEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdClienteInformacionEconomica= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteVinculacionInformacionEconomica=true;

	public Boolean getActivarFK_IdValorClienteVinculacionInformacionEconomica() {
		return this.activarFK_IdValorClienteVinculacionInformacionEconomica;
	}

	public void setActivarFK_IdValorClienteVinculacionInformacionEconomica(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteVinculacionInformacionEconomica= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteInformacionEconomica=null;

	public Border getResaltarFK_IdClienteInformacionEconomica() {
		return this.resaltarFK_IdClienteInformacionEconomica;
	}

	public void setResaltarFK_IdClienteInformacionEconomica(Border borderResaltar) {
		this.resaltarFK_IdClienteInformacionEconomica= borderResaltar;
	}

	public void setResaltarFK_IdClienteInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteInformacionEconomica= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteVinculacionInformacionEconomica=null;

	public Border getResaltarFK_IdValorClienteVinculacionInformacionEconomica() {
		return this.resaltarFK_IdValorClienteVinculacionInformacionEconomica;
	}

	public void setResaltarFK_IdValorClienteVinculacionInformacionEconomica(Border borderResaltar) {
		this.resaltarFK_IdValorClienteVinculacionInformacionEconomica= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteVinculacionInformacionEconomica(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionEconomicaBeanSwingJInternalFrame informacioneconomicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteVinculacionInformacionEconomica= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
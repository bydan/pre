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


import com.bydan.erp.cartera.util.InformacionFinancieraConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionFinancieraParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionFinancieraParameterGeneral;

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
final public class InformacionFinancieraConstantesFunciones extends InformacionFinancieraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="InformacionFinanciera";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="InformacionFinanciera"+InformacionFinancieraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="InformacionFinancieraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="InformacionFinancieraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=InformacionFinancieraConstantesFunciones.SCHEMA+"_"+InformacionFinancieraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/InformacionFinancieraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=InformacionFinancieraConstantesFunciones.SCHEMA+"_"+InformacionFinancieraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=InformacionFinancieraConstantesFunciones.SCHEMA+"_"+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/InformacionFinancieraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=InformacionFinancieraConstantesFunciones.SCHEMA+"_"+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionFinancieraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformacionFinancieraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformacionFinancieraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=InformacionFinancieraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+InformacionFinancieraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=InformacionFinancieraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+InformacionFinancieraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Informacion Financieras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Informacion Financiera";
	public static final String SCLASSWEBTITULO_LOWER="Informacion Financiera";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="InformacionFinanciera";
	public static final String OBJECTNAME="informacionfinanciera";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="informacionfinanciera";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select informacionfinanciera from "+InformacionFinancieraConstantesFunciones.SPERSISTENCENAME+" informacionfinanciera";
	public static String QUERYSELECTNATIVE="select "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".id,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".version_row,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".id_empresa,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".idcliente,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".idvalorclientemovimiento,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".valor,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".descripcion,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".esactivo from "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME;//+" as "+InformacionFinancieraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected InformacionFinancieraConstantesFuncionesAdditional informacionfinancieraConstantesFuncionesAdditional=null;
	
	public InformacionFinancieraConstantesFuncionesAdditional getInformacionFinancieraConstantesFuncionesAdditional() {
		return this.informacionfinancieraConstantesFuncionesAdditional;
	}
	
	public void setInformacionFinancieraConstantesFuncionesAdditional(InformacionFinancieraConstantesFuncionesAdditional informacionfinancieraConstantesFuncionesAdditional) {
		try {
			this.informacionfinancieraConstantesFuncionesAdditional=informacionfinancieraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOMOVIFINAN= "idvalorclientemovimiento";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOMOVIFINAN= "Tipo Movi Finan";
		public static final String LABEL_IDTIPOMOVIFINAN_LOWER= "Tipo Movi Finan";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getInformacionFinancieraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.IDEMPRESA)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.IDCLIENTE)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_IDTIPOMOVIFINAN;}
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.VALOR)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.DESCRIPCION)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(InformacionFinancieraConstantesFunciones.ESACTIVO)) {sLabelColumna=InformacionFinancieraConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(InformacionFinanciera informacionfinanciera) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!informacionfinanciera.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(InformacionFinanciera informacionfinanciera) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(informacionfinanciera.getId(),informacionfinanciera.getesactivo());

		return sDescripcion;
	}	
	
	public static String getInformacionFinancieraDescripcion(InformacionFinanciera informacionfinanciera) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(informacionfinanciera !=null/* && informacionfinanciera.getId()!=0*/) {
			if(informacionfinanciera.getId()!=null) {
				sDescripcion=informacionfinanciera.getId().toString();
			}//informacionfinancierainformacionfinanciera.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getInformacionFinancieraDescripcionDetallado(InformacionFinanciera informacionfinanciera) {
		String sDescripcion="";
			
		sDescripcion+=InformacionFinancieraConstantesFunciones.ID+"=";
		sDescripcion+=informacionfinanciera.getId().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=informacionfinanciera.getVersionRow().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=informacionfinanciera.getid_empresa().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=informacionfinanciera.getidcliente().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN+"=";
		sDescripcion+=informacionfinanciera.getidvalorclientemovimiento().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.VALOR+"=";
		sDescripcion+=informacionfinanciera.getvalor().toString()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=informacionfinanciera.getdescripcion()+",";
		sDescripcion+=InformacionFinancieraConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=informacionfinanciera.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setInformacionFinancieraDescripcion(InformacionFinanciera informacionfinanciera,String sValor) throws Exception {			
		if(informacionfinanciera !=null) {
			//informacionfinancierainformacionfinanciera.getId().toString();
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

	public static String getTipoMoviFinanDescripcion(TipoMoviFinan tipomovifinan) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovifinan!=null/*&&tipomovifinan.getId()>0*/) {
			sDescripcion=TipoMoviFinanConstantesFunciones.getTipoMoviFinanDescripcion(tipomovifinan);
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
		} else if(sNombreIndice.equals("FK_IdValorClienteMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movi Finan";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteMovimiento(Long idvalorclientemovimiento) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientemovimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movi Finan="+idvalorclientemovimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosInformacionFinanciera(InformacionFinanciera informacionfinanciera,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		informacionfinanciera.setdescripcion(informacionfinanciera.getdescripcion().trim());
	}
	
	public static void quitarEspaciosInformacionFinancieras(List<InformacionFinanciera> informacionfinancieras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(InformacionFinanciera informacionfinanciera: informacionfinancieras) {
			informacionfinanciera.setdescripcion(informacionfinanciera.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionFinanciera(InformacionFinanciera informacionfinanciera,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && informacionfinanciera.getConCambioAuxiliar()) {
			informacionfinanciera.setIsDeleted(informacionfinanciera.getIsDeletedAuxiliar());	
			informacionfinanciera.setIsNew(informacionfinanciera.getIsNewAuxiliar());	
			informacionfinanciera.setIsChanged(informacionfinanciera.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			informacionfinanciera.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			informacionfinanciera.setIsDeletedAuxiliar(false);	
			informacionfinanciera.setIsNewAuxiliar(false);	
			informacionfinanciera.setIsChangedAuxiliar(false);
			
			informacionfinanciera.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformacionFinancieras(List<InformacionFinanciera> informacionfinancieras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(InformacionFinanciera informacionfinanciera : informacionfinancieras) {
			if(conAsignarBase && informacionfinanciera.getConCambioAuxiliar()) {
				informacionfinanciera.setIsDeleted(informacionfinanciera.getIsDeletedAuxiliar());	
				informacionfinanciera.setIsNew(informacionfinanciera.getIsNewAuxiliar());	
				informacionfinanciera.setIsChanged(informacionfinanciera.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				informacionfinanciera.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				informacionfinanciera.setIsDeletedAuxiliar(false);	
				informacionfinanciera.setIsNewAuxiliar(false);	
				informacionfinanciera.setIsChangedAuxiliar(false);
				
				informacionfinanciera.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresInformacionFinanciera(InformacionFinanciera informacionfinanciera,Boolean conEnteros) throws Exception  {
		informacionfinanciera.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresInformacionFinancieras(List<InformacionFinanciera> informacionfinancieras,Boolean conEnteros) throws Exception  {
		
		for(InformacionFinanciera informacionfinanciera: informacionfinancieras) {
			informacionfinanciera.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaInformacionFinanciera(List<InformacionFinanciera> informacionfinancieras,InformacionFinanciera informacionfinancieraAux) throws Exception  {
		InformacionFinancieraConstantesFunciones.InicializarValoresInformacionFinanciera(informacionfinancieraAux,true);
		
		for(InformacionFinanciera informacionfinanciera: informacionfinancieras) {
			if(informacionfinanciera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			informacionfinancieraAux.setvalor(informacionfinancieraAux.getvalor()+informacionfinanciera.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionFinanciera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=InformacionFinancieraConstantesFunciones.getArrayColumnasGlobalesInformacionFinanciera(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesInformacionFinanciera(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(InformacionFinancieraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(InformacionFinancieraConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoInformacionFinanciera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<InformacionFinanciera> informacionfinancieras,InformacionFinanciera informacionfinanciera,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(InformacionFinanciera informacionfinancieraAux: informacionfinancieras) {
			if(informacionfinancieraAux!=null && informacionfinanciera!=null) {
				if((informacionfinancieraAux.getId()==null && informacionfinanciera.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(informacionfinancieraAux.getId()!=null && informacionfinanciera.getId()!=null){
					if(informacionfinancieraAux.getId().equals(informacionfinanciera.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInformacionFinanciera(List<InformacionFinanciera> informacionfinancieras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(InformacionFinanciera informacionfinanciera: informacionfinancieras) {			
			if(informacionfinanciera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=informacionfinanciera.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(InformacionFinancieraConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaInformacionFinanciera() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_ID, InformacionFinancieraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_VERSIONROW, InformacionFinancieraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_IDEMPRESA, InformacionFinancieraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_IDCLIENTE, InformacionFinancieraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_IDTIPOMOVIFINAN, InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_VALOR, InformacionFinancieraConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_DESCRIPCION, InformacionFinancieraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformacionFinancieraConstantesFunciones.LABEL_ESACTIVO, InformacionFinancieraConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasInformacionFinanciera() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformacionFinancieraConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionFinanciera() throws Exception  {
		return InformacionFinancieraConstantesFunciones.getTiposSeleccionarInformacionFinanciera(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionFinanciera(Boolean conFk) throws Exception  {
		return InformacionFinancieraConstantesFunciones.getTiposSeleccionarInformacionFinanciera(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformacionFinanciera(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_IDTIPOMOVIFINAN);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_IDTIPOMOVIFINAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformacionFinancieraConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(InformacionFinancieraConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesInformacionFinanciera(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionFinanciera(InformacionFinanciera informacionfinancieraAux) throws Exception {
		
			informacionfinancieraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(informacionfinancieraAux.getEmpresa()));
			informacionfinancieraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacionfinancieraAux.getCliente()));
			informacionfinancieraAux.settipomovifinan_descripcion(TipoMoviFinanConstantesFunciones.getTipoMoviFinanDescripcion(informacionfinancieraAux.getTipoMoviFinan()));		
	}
	
	public static void refrescarForeignKeysDescripcionesInformacionFinanciera(List<InformacionFinanciera> informacionfinancierasTemp) throws Exception {
		for(InformacionFinanciera informacionfinancieraAux:informacionfinancierasTemp) {
			
			informacionfinancieraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(informacionfinancieraAux.getEmpresa()));
			informacionfinancieraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(informacionfinancieraAux.getCliente()));
			informacionfinancieraAux.settipomovifinan_descripcion(TipoMoviFinanConstantesFunciones.getTipoMoviFinanDescripcion(informacionfinancieraAux.getTipoMoviFinan()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionFinanciera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoMoviFinan.class));
				
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
					if(clas.clas.equals(TipoMoviFinan.class)) {
						classes.add(new Classe(TipoMoviFinan.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfInformacionFinanciera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMoviFinan.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMoviFinan.class)); continue;
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

					if(TipoMoviFinan.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMoviFinan.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionFinanciera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionFinancieraConstantesFunciones.getClassesRelationshipsOfInformacionFinanciera(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionFinanciera(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionFinanciera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformacionFinancieraConstantesFunciones.getClassesRelationshipsFromStringsOfInformacionFinanciera(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformacionFinanciera(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(InformacionFinanciera informacionfinanciera,List<InformacionFinanciera> informacionfinancieras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			InformacionFinanciera informacionfinancieraEncontrado=null;
			
			for(InformacionFinanciera informacionfinancieraLocal:informacionfinancieras) {
				if(informacionfinancieraLocal.getId().equals(informacionfinanciera.getId())) {
					informacionfinancieraEncontrado=informacionfinancieraLocal;
					
					informacionfinancieraLocal.setIsChanged(informacionfinanciera.getIsChanged());
					informacionfinancieraLocal.setIsNew(informacionfinanciera.getIsNew());
					informacionfinancieraLocal.setIsDeleted(informacionfinanciera.getIsDeleted());
					
					informacionfinancieraLocal.setGeneralEntityOriginal(informacionfinanciera.getGeneralEntityOriginal());
					
					informacionfinancieraLocal.setId(informacionfinanciera.getId());	
					informacionfinancieraLocal.setVersionRow(informacionfinanciera.getVersionRow());	
					informacionfinancieraLocal.setid_empresa(informacionfinanciera.getid_empresa());	
					informacionfinancieraLocal.setidcliente(informacionfinanciera.getidcliente());	
					informacionfinancieraLocal.setidvalorclientemovimiento(informacionfinanciera.getidvalorclientemovimiento());	
					informacionfinancieraLocal.setvalor(informacionfinanciera.getvalor());	
					informacionfinancieraLocal.setdescripcion(informacionfinanciera.getdescripcion());	
					informacionfinancieraLocal.setesactivo(informacionfinanciera.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!informacionfinanciera.getIsDeleted()) {
				if(!existe) {
					informacionfinancieras.add(informacionfinanciera);
				}
			} else {
				if(informacionfinancieraEncontrado!=null && permiteQuitar)  {
					informacionfinancieras.remove(informacionfinancieraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(InformacionFinanciera informacionfinanciera,List<InformacionFinanciera> informacionfinancieras) throws Exception {
		try	{			
			for(InformacionFinanciera informacionfinancieraLocal:informacionfinancieras) {
				if(informacionfinancieraLocal.getId().equals(informacionfinanciera.getId())) {
					informacionfinancieraLocal.setIsSelected(informacionfinanciera.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesInformacionFinanciera(List<InformacionFinanciera> informacionfinancierasAux) throws Exception {
		//this.informacionfinancierasAux=informacionfinancierasAux;
		
		for(InformacionFinanciera informacionfinancieraAux:informacionfinancierasAux) {
			if(informacionfinancieraAux.getIsChanged()) {
				informacionfinancieraAux.setIsChanged(false);
			}		
			
			if(informacionfinancieraAux.getIsNew()) {
				informacionfinancieraAux.setIsNew(false);
			}	
			
			if(informacionfinancieraAux.getIsDeleted()) {
				informacionfinancieraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesInformacionFinanciera(InformacionFinanciera informacionfinancieraAux) throws Exception {
		//this.informacionfinancieraAux=informacionfinancieraAux;
		
			if(informacionfinancieraAux.getIsChanged()) {
				informacionfinancieraAux.setIsChanged(false);
			}		
			
			if(informacionfinancieraAux.getIsNew()) {
				informacionfinancieraAux.setIsNew(false);
			}	
			
			if(informacionfinancieraAux.getIsDeleted()) {
				informacionfinancieraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(InformacionFinanciera informacionfinancieraAsignar,InformacionFinanciera informacionfinanciera) throws Exception {
		informacionfinancieraAsignar.setId(informacionfinanciera.getId());	
		informacionfinancieraAsignar.setVersionRow(informacionfinanciera.getVersionRow());	
		informacionfinancieraAsignar.setid_empresa(informacionfinanciera.getid_empresa());
		informacionfinancieraAsignar.setempresa_descripcion(informacionfinanciera.getempresa_descripcion());	
		informacionfinancieraAsignar.setidcliente(informacionfinanciera.getidcliente());
		informacionfinancieraAsignar.setcliente_descripcion(informacionfinanciera.getcliente_descripcion());	
		informacionfinancieraAsignar.setidvalorclientemovimiento(informacionfinanciera.getidvalorclientemovimiento());
		informacionfinancieraAsignar.settipomovifinan_descripcion(informacionfinanciera.gettipomovifinan_descripcion());	
		informacionfinancieraAsignar.setvalor(informacionfinanciera.getvalor());	
		informacionfinancieraAsignar.setdescripcion(informacionfinanciera.getdescripcion());	
		informacionfinancieraAsignar.setesactivo(informacionfinanciera.getesactivo());	
	}
	
	public static void inicializarInformacionFinanciera(InformacionFinanciera informacionfinanciera) throws Exception {
		try {
				informacionfinanciera.setId(0L);	
					
				informacionfinanciera.setid_empresa(-1L);	
				informacionfinanciera.setidcliente(-1L);	
				informacionfinanciera.setidvalorclientemovimiento(-1L);	
				informacionfinanciera.setvalor(0.0);	
				informacionfinanciera.setdescripcion("");	
				informacionfinanciera.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderInformacionFinanciera(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_IDTIPOMOVIFINAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformacionFinancieraConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataInformacionFinanciera(String sTipo,Row row,Workbook workbook,InformacionFinanciera informacionfinanciera,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionfinanciera.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionfinanciera.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionfinanciera.gettipomovifinan_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionfinanciera.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informacionfinanciera.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(informacionfinanciera.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryInformacionFinanciera=Constantes.SFINALQUERY;
	
	public String getsFinalQueryInformacionFinanciera() {
		return this.sFinalQueryInformacionFinanciera;
	}
	
	public void setsFinalQueryInformacionFinanciera(String sFinalQueryInformacionFinanciera) {
		this.sFinalQueryInformacionFinanciera= sFinalQueryInformacionFinanciera;
	}
	
	public Border resaltarSeleccionarInformacionFinanciera=null;
	
	public Border setResaltarSeleccionarInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltarSeleccionarInformacionFinanciera= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarInformacionFinanciera() {
		return this.resaltarSeleccionarInformacionFinanciera;
	}
	
	public void setResaltarSeleccionarInformacionFinanciera(Border borderResaltarSeleccionarInformacionFinanciera) {
		this.resaltarSeleccionarInformacionFinanciera= borderResaltarSeleccionarInformacionFinanciera;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridInformacionFinanciera=null;
	public Boolean mostraridInformacionFinanciera=true;
	public Boolean activaridInformacionFinanciera=true;

	public Border resaltarid_empresaInformacionFinanciera=null;
	public Boolean mostrarid_empresaInformacionFinanciera=true;
	public Boolean activarid_empresaInformacionFinanciera=true;
	public Boolean cargarid_empresaInformacionFinanciera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaInformacionFinanciera=false;//ConEventDepend=true

	public Border resaltaridclienteInformacionFinanciera=null;
	public Boolean mostraridclienteInformacionFinanciera=true;
	public Boolean activaridclienteInformacionFinanciera=true;
	public Boolean cargaridclienteInformacionFinanciera=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteInformacionFinanciera=false;//ConEventDepend=true

	public Border resaltaridvalorclientemovimientoInformacionFinanciera=null;
	public Boolean mostraridvalorclientemovimientoInformacionFinanciera=true;
	public Boolean activaridvalorclientemovimientoInformacionFinanciera=true;
	public Boolean cargaridvalorclientemovimientoInformacionFinanciera=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientemovimientoInformacionFinanciera=false;//ConEventDepend=true

	public Border resaltarvalorInformacionFinanciera=null;
	public Boolean mostrarvalorInformacionFinanciera=true;
	public Boolean activarvalorInformacionFinanciera=true;

	public Border resaltardescripcionInformacionFinanciera=null;
	public Boolean mostrardescripcionInformacionFinanciera=true;
	public Boolean activardescripcionInformacionFinanciera=true;

	public Border resaltaresactivoInformacionFinanciera=null;
	public Boolean mostraresactivoInformacionFinanciera=true;
	public Boolean activaresactivoInformacionFinanciera=true;

	
	

	public Border setResaltaridInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltaridInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridInformacionFinanciera() {
		return this.resaltaridInformacionFinanciera;
	}

	public void setResaltaridInformacionFinanciera(Border borderResaltar) {
		this.resaltaridInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostraridInformacionFinanciera() {
		return this.mostraridInformacionFinanciera;
	}

	public void setMostraridInformacionFinanciera(Boolean mostraridInformacionFinanciera) {
		this.mostraridInformacionFinanciera= mostraridInformacionFinanciera;
	}

	public Boolean getActivaridInformacionFinanciera() {
		return this.activaridInformacionFinanciera;
	}

	public void setActivaridInformacionFinanciera(Boolean activaridInformacionFinanciera) {
		this.activaridInformacionFinanciera= activaridInformacionFinanciera;
	}

	public Border setResaltarid_empresaInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltarid_empresaInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaInformacionFinanciera() {
		return this.resaltarid_empresaInformacionFinanciera;
	}

	public void setResaltarid_empresaInformacionFinanciera(Border borderResaltar) {
		this.resaltarid_empresaInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostrarid_empresaInformacionFinanciera() {
		return this.mostrarid_empresaInformacionFinanciera;
	}

	public void setMostrarid_empresaInformacionFinanciera(Boolean mostrarid_empresaInformacionFinanciera) {
		this.mostrarid_empresaInformacionFinanciera= mostrarid_empresaInformacionFinanciera;
	}

	public Boolean getActivarid_empresaInformacionFinanciera() {
		return this.activarid_empresaInformacionFinanciera;
	}

	public void setActivarid_empresaInformacionFinanciera(Boolean activarid_empresaInformacionFinanciera) {
		this.activarid_empresaInformacionFinanciera= activarid_empresaInformacionFinanciera;
	}

	public Boolean getCargarid_empresaInformacionFinanciera() {
		return this.cargarid_empresaInformacionFinanciera;
	}

	public void setCargarid_empresaInformacionFinanciera(Boolean cargarid_empresaInformacionFinanciera) {
		this.cargarid_empresaInformacionFinanciera= cargarid_empresaInformacionFinanciera;
	}

	public Border setResaltaridclienteInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltaridclienteInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteInformacionFinanciera() {
		return this.resaltaridclienteInformacionFinanciera;
	}

	public void setResaltaridclienteInformacionFinanciera(Border borderResaltar) {
		this.resaltaridclienteInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostraridclienteInformacionFinanciera() {
		return this.mostraridclienteInformacionFinanciera;
	}

	public void setMostraridclienteInformacionFinanciera(Boolean mostraridclienteInformacionFinanciera) {
		this.mostraridclienteInformacionFinanciera= mostraridclienteInformacionFinanciera;
	}

	public Boolean getActivaridclienteInformacionFinanciera() {
		return this.activaridclienteInformacionFinanciera;
	}

	public void setActivaridclienteInformacionFinanciera(Boolean activaridclienteInformacionFinanciera) {
		this.activaridclienteInformacionFinanciera= activaridclienteInformacionFinanciera;
	}

	public Boolean getCargaridclienteInformacionFinanciera() {
		return this.cargaridclienteInformacionFinanciera;
	}

	public void setCargaridclienteInformacionFinanciera(Boolean cargaridclienteInformacionFinanciera) {
		this.cargaridclienteInformacionFinanciera= cargaridclienteInformacionFinanciera;
	}

	public Border setResaltaridvalorclientemovimientoInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltaridvalorclientemovimientoInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientemovimientoInformacionFinanciera() {
		return this.resaltaridvalorclientemovimientoInformacionFinanciera;
	}

	public void setResaltaridvalorclientemovimientoInformacionFinanciera(Border borderResaltar) {
		this.resaltaridvalorclientemovimientoInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostraridvalorclientemovimientoInformacionFinanciera() {
		return this.mostraridvalorclientemovimientoInformacionFinanciera;
	}

	public void setMostraridvalorclientemovimientoInformacionFinanciera(Boolean mostraridvalorclientemovimientoInformacionFinanciera) {
		this.mostraridvalorclientemovimientoInformacionFinanciera= mostraridvalorclientemovimientoInformacionFinanciera;
	}

	public Boolean getActivaridvalorclientemovimientoInformacionFinanciera() {
		return this.activaridvalorclientemovimientoInformacionFinanciera;
	}

	public void setActivaridvalorclientemovimientoInformacionFinanciera(Boolean activaridvalorclientemovimientoInformacionFinanciera) {
		this.activaridvalorclientemovimientoInformacionFinanciera= activaridvalorclientemovimientoInformacionFinanciera;
	}

	public Boolean getCargaridvalorclientemovimientoInformacionFinanciera() {
		return this.cargaridvalorclientemovimientoInformacionFinanciera;
	}

	public void setCargaridvalorclientemovimientoInformacionFinanciera(Boolean cargaridvalorclientemovimientoInformacionFinanciera) {
		this.cargaridvalorclientemovimientoInformacionFinanciera= cargaridvalorclientemovimientoInformacionFinanciera;
	}

	public Border setResaltarvalorInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltarvalorInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorInformacionFinanciera() {
		return this.resaltarvalorInformacionFinanciera;
	}

	public void setResaltarvalorInformacionFinanciera(Border borderResaltar) {
		this.resaltarvalorInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostrarvalorInformacionFinanciera() {
		return this.mostrarvalorInformacionFinanciera;
	}

	public void setMostrarvalorInformacionFinanciera(Boolean mostrarvalorInformacionFinanciera) {
		this.mostrarvalorInformacionFinanciera= mostrarvalorInformacionFinanciera;
	}

	public Boolean getActivarvalorInformacionFinanciera() {
		return this.activarvalorInformacionFinanciera;
	}

	public void setActivarvalorInformacionFinanciera(Boolean activarvalorInformacionFinanciera) {
		this.activarvalorInformacionFinanciera= activarvalorInformacionFinanciera;
	}

	public Border setResaltardescripcionInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltardescripcionInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionInformacionFinanciera() {
		return this.resaltardescripcionInformacionFinanciera;
	}

	public void setResaltardescripcionInformacionFinanciera(Border borderResaltar) {
		this.resaltardescripcionInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostrardescripcionInformacionFinanciera() {
		return this.mostrardescripcionInformacionFinanciera;
	}

	public void setMostrardescripcionInformacionFinanciera(Boolean mostrardescripcionInformacionFinanciera) {
		this.mostrardescripcionInformacionFinanciera= mostrardescripcionInformacionFinanciera;
	}

	public Boolean getActivardescripcionInformacionFinanciera() {
		return this.activardescripcionInformacionFinanciera;
	}

	public void setActivardescripcionInformacionFinanciera(Boolean activardescripcionInformacionFinanciera) {
		this.activardescripcionInformacionFinanciera= activardescripcionInformacionFinanciera;
	}

	public Border setResaltaresactivoInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informacionfinancieraBeanSwingJInternalFrame.jTtoolBarInformacionFinanciera.setBorder(borderResaltar);
		
		this.resaltaresactivoInformacionFinanciera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoInformacionFinanciera() {
		return this.resaltaresactivoInformacionFinanciera;
	}

	public void setResaltaresactivoInformacionFinanciera(Border borderResaltar) {
		this.resaltaresactivoInformacionFinanciera= borderResaltar;
	}

	public Boolean getMostraresactivoInformacionFinanciera() {
		return this.mostraresactivoInformacionFinanciera;
	}

	public void setMostraresactivoInformacionFinanciera(Boolean mostraresactivoInformacionFinanciera) {
		this.mostraresactivoInformacionFinanciera= mostraresactivoInformacionFinanciera;
	}

	public Boolean getActivaresactivoInformacionFinanciera() {
		return this.activaresactivoInformacionFinanciera;
	}

	public void setActivaresactivoInformacionFinanciera(Boolean activaresactivoInformacionFinanciera) {
		this.activaresactivoInformacionFinanciera= activaresactivoInformacionFinanciera;
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
		
		
		this.setMostraridInformacionFinanciera(esInicial);
		this.setMostrarid_empresaInformacionFinanciera(esInicial);
		this.setMostraridclienteInformacionFinanciera(esInicial);
		this.setMostraridvalorclientemovimientoInformacionFinanciera(esInicial);
		this.setMostrarvalorInformacionFinanciera(esInicial);
		this.setMostrardescripcionInformacionFinanciera(esInicial);
		this.setMostraresactivoInformacionFinanciera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ID)) {
				this.setMostraridInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN)) {
				this.setMostraridvalorclientemovimientoInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.VALOR)) {
				this.setMostrarvalorInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoInformacionFinanciera(esAsigna);
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
		
		
		this.setActivaridInformacionFinanciera(esInicial);
		this.setActivarid_empresaInformacionFinanciera(esInicial);
		this.setActivaridclienteInformacionFinanciera(esInicial);
		this.setActivaridvalorclientemovimientoInformacionFinanciera(esInicial);
		this.setActivarvalorInformacionFinanciera(esInicial);
		this.setActivardescripcionInformacionFinanciera(esInicial);
		this.setActivaresactivoInformacionFinanciera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ID)) {
				this.setActivaridInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN)) {
				this.setActivaridvalorclientemovimientoInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.VALOR)) {
				this.setActivarvalorInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoInformacionFinanciera(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridInformacionFinanciera(esInicial);
		this.setResaltarid_empresaInformacionFinanciera(esInicial);
		this.setResaltaridclienteInformacionFinanciera(esInicial);
		this.setResaltaridvalorclientemovimientoInformacionFinanciera(esInicial);
		this.setResaltarvalorInformacionFinanciera(esInicial);
		this.setResaltardescripcionInformacionFinanciera(esInicial);
		this.setResaltaresactivoInformacionFinanciera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ID)) {
				this.setResaltaridInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN)) {
				this.setResaltaridvalorclientemovimientoInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.VALOR)) {
				this.setResaltarvalorInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionInformacionFinanciera(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformacionFinancieraConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoInformacionFinanciera(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteInformacionFinanciera=true;

	public Boolean getMostrarFK_IdClienteInformacionFinanciera() {
		return this.mostrarFK_IdClienteInformacionFinanciera;
	}

	public void setMostrarFK_IdClienteInformacionFinanciera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteInformacionFinanciera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaInformacionFinanciera=true;

	public Boolean getMostrarFK_IdEmpresaInformacionFinanciera() {
		return this.mostrarFK_IdEmpresaInformacionFinanciera;
	}

	public void setMostrarFK_IdEmpresaInformacionFinanciera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaInformacionFinanciera= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteMovimientoInformacionFinanciera=true;

	public Boolean getMostrarFK_IdValorClienteMovimientoInformacionFinanciera() {
		return this.mostrarFK_IdValorClienteMovimientoInformacionFinanciera;
	}

	public void setMostrarFK_IdValorClienteMovimientoInformacionFinanciera(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteMovimientoInformacionFinanciera= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteInformacionFinanciera=true;

	public Boolean getActivarFK_IdClienteInformacionFinanciera() {
		return this.activarFK_IdClienteInformacionFinanciera;
	}

	public void setActivarFK_IdClienteInformacionFinanciera(Boolean habilitarResaltar) {
		this.activarFK_IdClienteInformacionFinanciera= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaInformacionFinanciera=true;

	public Boolean getActivarFK_IdEmpresaInformacionFinanciera() {
		return this.activarFK_IdEmpresaInformacionFinanciera;
	}

	public void setActivarFK_IdEmpresaInformacionFinanciera(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaInformacionFinanciera= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteMovimientoInformacionFinanciera=true;

	public Boolean getActivarFK_IdValorClienteMovimientoInformacionFinanciera() {
		return this.activarFK_IdValorClienteMovimientoInformacionFinanciera;
	}

	public void setActivarFK_IdValorClienteMovimientoInformacionFinanciera(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteMovimientoInformacionFinanciera= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteInformacionFinanciera=null;

	public Border getResaltarFK_IdClienteInformacionFinanciera() {
		return this.resaltarFK_IdClienteInformacionFinanciera;
	}

	public void setResaltarFK_IdClienteInformacionFinanciera(Border borderResaltar) {
		this.resaltarFK_IdClienteInformacionFinanciera= borderResaltar;
	}

	public void setResaltarFK_IdClienteInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteInformacionFinanciera= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaInformacionFinanciera=null;

	public Border getResaltarFK_IdEmpresaInformacionFinanciera() {
		return this.resaltarFK_IdEmpresaInformacionFinanciera;
	}

	public void setResaltarFK_IdEmpresaInformacionFinanciera(Border borderResaltar) {
		this.resaltarFK_IdEmpresaInformacionFinanciera= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaInformacionFinanciera= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteMovimientoInformacionFinanciera=null;

	public Border getResaltarFK_IdValorClienteMovimientoInformacionFinanciera() {
		return this.resaltarFK_IdValorClienteMovimientoInformacionFinanciera;
	}

	public void setResaltarFK_IdValorClienteMovimientoInformacionFinanciera(Border borderResaltar) {
		this.resaltarFK_IdValorClienteMovimientoInformacionFinanciera= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteMovimientoInformacionFinanciera(ParametroGeneralUsuario parametroGeneralUsuario/*InformacionFinancieraBeanSwingJInternalFrame informacionfinancieraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteMovimientoInformacionFinanciera= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}
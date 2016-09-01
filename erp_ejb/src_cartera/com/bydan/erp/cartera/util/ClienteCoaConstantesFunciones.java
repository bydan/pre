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


import com.bydan.erp.cartera.util.ClienteCoaConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteCoaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteCoaParameterGeneral;

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
final public class ClienteCoaConstantesFunciones extends ClienteCoaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ClienteCoa";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClienteCoa"+ClienteCoaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClienteCoaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClienteCoaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClienteCoaConstantesFunciones.SCHEMA+"_"+ClienteCoaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClienteCoaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClienteCoaConstantesFunciones.SCHEMA+"_"+ClienteCoaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClienteCoaConstantesFunciones.SCHEMA+"_"+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClienteCoaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClienteCoaConstantesFunciones.SCHEMA+"_"+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteCoaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteCoaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteCoaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClienteCoaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClienteCoaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClienteCoaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClienteCoaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Coas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Coa";
	public static final String SCLASSWEBTITULO_LOWER="Cliente Coa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClienteCoa";
	public static final String OBJECTNAME="clientecoa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cliente_coa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select clientecoa from "+ClienteCoaConstantesFunciones.SPERSISTENCENAME+" clientecoa";
	public static String QUERYSELECTNATIVE="select "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".version_row,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_empresa,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_cliente,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_usuario,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".autori_imprenta,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".autori_usuario,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".num_factura_ini,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".num_factura_fin,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".serie_docu,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".fecha_vali from "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME;//+" as "+ClienteCoaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClienteCoaConstantesFuncionesAdditional clientecoaConstantesFuncionesAdditional=null;
	
	public ClienteCoaConstantesFuncionesAdditional getClienteCoaConstantesFuncionesAdditional() {
		return this.clientecoaConstantesFuncionesAdditional;
	}
	
	public void setClienteCoaConstantesFuncionesAdditional(ClienteCoaConstantesFuncionesAdditional clientecoaConstantesFuncionesAdditional) {
		try {
			this.clientecoaConstantesFuncionesAdditional=clientecoaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDUSUARIO= "id_usuario";
    public static final String AUTORIIMPRENTA= "autori_imprenta";
    public static final String AUTORIUSUARIO= "autori_usuario";
    public static final String NUMFACTURAINI= "num_factura_ini";
    public static final String NUMFACTURAFIN= "num_factura_fin";
    public static final String SERIEDOCU= "serie_docu";
    public static final String FECHAVALI= "fecha_vali";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_AUTORIIMPRENTA= "Autorizacion Imprenta";
		public static final String LABEL_AUTORIIMPRENTA_LOWER= "Autori Imprenta";
    	public static final String LABEL_AUTORIUSUARIO= "Autorizacion Usuario";
		public static final String LABEL_AUTORIUSUARIO_LOWER= "Autori Usuario";
    	public static final String LABEL_NUMFACTURAINI= "Factura Inicial";
		public static final String LABEL_NUMFACTURAINI_LOWER= "Num Factura Ini";
    	public static final String LABEL_NUMFACTURAFIN= "Factura Final";
		public static final String LABEL_NUMFACTURAFIN_LOWER= "Num Factura Fin";
    	public static final String LABEL_SERIEDOCU= "Serie Documento";
		public static final String LABEL_SERIEDOCU_LOWER= "Serie Docu";
    	public static final String LABEL_FECHAVALI= "Fecha Validez";
		public static final String LABEL_FECHAVALI_LOWER= "Fecha Vali";
	
		
		
		
		
		
	public static final String SREGEXAUTORI_IMPRENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORI_IMPRENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORI_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORI_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUM_FACTURA_INI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUM_FACTURA_INI=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUM_FACTURA_FIN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUM_FACTURA_FIN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE_DOCU=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE_DOCU=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getClienteCoaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.IDUSUARIO)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.AUTORIIMPRENTA)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_AUTORIIMPRENTA;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.AUTORIUSUARIO)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_AUTORIUSUARIO;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.NUMFACTURAINI)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_NUMFACTURAINI;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.NUMFACTURAFIN)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_NUMFACTURAFIN;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.SERIEDOCU)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_SERIEDOCU;}
		if(sNombreColumna.equals(ClienteCoaConstantesFunciones.FECHAVALI)) {sLabelColumna=ClienteCoaConstantesFunciones.LABEL_FECHAVALI;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getClienteCoaDescripcion(ClienteCoa clientecoa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(clientecoa !=null/* && clientecoa.getId()!=0*/) {
			if(clientecoa.getId()!=null) {
				sDescripcion=clientecoa.getId().toString();
			}//clientecoaclientecoa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getClienteCoaDescripcionDetallado(ClienteCoa clientecoa) {
		String sDescripcion="";
			
		sDescripcion+=ClienteCoaConstantesFunciones.ID+"=";
		sDescripcion+=clientecoa.getId().toString()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=clientecoa.getVersionRow().toString()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=clientecoa.getid_empresa().toString()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=clientecoa.getid_cliente().toString()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=clientecoa.getid_usuario().toString()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.AUTORIIMPRENTA+"=";
		sDescripcion+=clientecoa.getautori_imprenta()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.AUTORIUSUARIO+"=";
		sDescripcion+=clientecoa.getautori_usuario()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.NUMFACTURAINI+"=";
		sDescripcion+=clientecoa.getnum_factura_ini()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.NUMFACTURAFIN+"=";
		sDescripcion+=clientecoa.getnum_factura_fin()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.SERIEDOCU+"=";
		sDescripcion+=clientecoa.getserie_docu()+",";
		sDescripcion+=ClienteCoaConstantesFunciones.FECHAVALI+"=";
		sDescripcion+=clientecoa.getfecha_vali().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setClienteCoaDescripcion(ClienteCoa clientecoa,String sValor) throws Exception {			
		if(clientecoa !=null) {
			//clientecoaclientecoa.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClienteCoa(ClienteCoa clientecoa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		clientecoa.setautori_imprenta(clientecoa.getautori_imprenta().trim());
		clientecoa.setautori_usuario(clientecoa.getautori_usuario().trim());
		clientecoa.setnum_factura_ini(clientecoa.getnum_factura_ini().trim());
		clientecoa.setnum_factura_fin(clientecoa.getnum_factura_fin().trim());
		clientecoa.setserie_docu(clientecoa.getserie_docu().trim());
	}
	
	public static void quitarEspaciosClienteCoas(List<ClienteCoa> clientecoas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClienteCoa clientecoa: clientecoas) {
			clientecoa.setautori_imprenta(clientecoa.getautori_imprenta().trim());
			clientecoa.setautori_usuario(clientecoa.getautori_usuario().trim());
			clientecoa.setnum_factura_ini(clientecoa.getnum_factura_ini().trim());
			clientecoa.setnum_factura_fin(clientecoa.getnum_factura_fin().trim());
			clientecoa.setserie_docu(clientecoa.getserie_docu().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteCoa(ClienteCoa clientecoa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && clientecoa.getConCambioAuxiliar()) {
			clientecoa.setIsDeleted(clientecoa.getIsDeletedAuxiliar());	
			clientecoa.setIsNew(clientecoa.getIsNewAuxiliar());	
			clientecoa.setIsChanged(clientecoa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			clientecoa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			clientecoa.setIsDeletedAuxiliar(false);	
			clientecoa.setIsNewAuxiliar(false);	
			clientecoa.setIsChangedAuxiliar(false);
			
			clientecoa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteCoas(List<ClienteCoa> clientecoas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClienteCoa clientecoa : clientecoas) {
			if(conAsignarBase && clientecoa.getConCambioAuxiliar()) {
				clientecoa.setIsDeleted(clientecoa.getIsDeletedAuxiliar());	
				clientecoa.setIsNew(clientecoa.getIsNewAuxiliar());	
				clientecoa.setIsChanged(clientecoa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				clientecoa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				clientecoa.setIsDeletedAuxiliar(false);	
				clientecoa.setIsNewAuxiliar(false);	
				clientecoa.setIsChangedAuxiliar(false);
				
				clientecoa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClienteCoa(ClienteCoa clientecoa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClienteCoas(List<ClienteCoa> clientecoas,Boolean conEnteros) throws Exception  {
		
		for(ClienteCoa clientecoa: clientecoas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClienteCoa(List<ClienteCoa> clientecoas,ClienteCoa clientecoaAux) throws Exception  {
		ClienteCoaConstantesFunciones.InicializarValoresClienteCoa(clientecoaAux,true);
		
		for(ClienteCoa clientecoa: clientecoas) {
			if(clientecoa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteCoa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClienteCoaConstantesFunciones.getArrayColumnasGlobalesClienteCoa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteCoa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteCoaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteCoaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteCoaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteCoaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClienteCoa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClienteCoa> clientecoas,ClienteCoa clientecoa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClienteCoa clientecoaAux: clientecoas) {
			if(clientecoaAux!=null && clientecoa!=null) {
				if((clientecoaAux.getId()==null && clientecoa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(clientecoaAux.getId()!=null && clientecoa.getId()!=null){
					if(clientecoaAux.getId().equals(clientecoa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClienteCoa(List<ClienteCoa> clientecoas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ClienteCoa clientecoa: clientecoas) {			
			if(clientecoa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClienteCoa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_ID, ClienteCoaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_VERSIONROW, ClienteCoaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_IDEMPRESA, ClienteCoaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_IDCLIENTE, ClienteCoaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_IDUSUARIO, ClienteCoaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_AUTORIIMPRENTA, ClienteCoaConstantesFunciones.AUTORIIMPRENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_AUTORIUSUARIO, ClienteCoaConstantesFunciones.AUTORIUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_NUMFACTURAINI, ClienteCoaConstantesFunciones.NUMFACTURAINI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_NUMFACTURAFIN, ClienteCoaConstantesFunciones.NUMFACTURAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_SERIEDOCU, ClienteCoaConstantesFunciones.SERIEDOCU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteCoaConstantesFunciones.LABEL_FECHAVALI, ClienteCoaConstantesFunciones.FECHAVALI,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClienteCoa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.AUTORIIMPRENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.AUTORIUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.NUMFACTURAINI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.NUMFACTURAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.SERIEDOCU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteCoaConstantesFunciones.FECHAVALI;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteCoa() throws Exception  {
		return ClienteCoaConstantesFunciones.getTiposSeleccionarClienteCoa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteCoa(Boolean conFk) throws Exception  {
		return ClienteCoaConstantesFunciones.getTiposSeleccionarClienteCoa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteCoa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_AUTORIIMPRENTA);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_AUTORIIMPRENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_AUTORIUSUARIO);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_AUTORIUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAINI);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAINI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAFIN);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_SERIEDOCU);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_SERIEDOCU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteCoaConstantesFunciones.LABEL_FECHAVALI);
			reporte.setsDescripcion(ClienteCoaConstantesFunciones.LABEL_FECHAVALI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClienteCoa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClienteCoa(ClienteCoa clientecoaAux) throws Exception {
		
			clientecoaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clientecoaAux.getEmpresa()));
			clientecoaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clientecoaAux.getCliente()));
			clientecoaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(clientecoaAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClienteCoa(List<ClienteCoa> clientecoasTemp) throws Exception {
		for(ClienteCoa clientecoaAux:clientecoasTemp) {
			
			clientecoaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clientecoaAux.getEmpresa()));
			clientecoaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clientecoaAux.getCliente()));
			clientecoaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(clientecoaAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClienteCoa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Usuario.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClienteCoa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteCoa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteCoaConstantesFunciones.getClassesRelationshipsOfClienteCoa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteCoa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteCoa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteCoaConstantesFunciones.getClassesRelationshipsFromStringsOfClienteCoa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteCoa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClienteCoa clientecoa,List<ClienteCoa> clientecoas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClienteCoa clientecoaEncontrado=null;
			
			for(ClienteCoa clientecoaLocal:clientecoas) {
				if(clientecoaLocal.getId().equals(clientecoa.getId())) {
					clientecoaEncontrado=clientecoaLocal;
					
					clientecoaLocal.setIsChanged(clientecoa.getIsChanged());
					clientecoaLocal.setIsNew(clientecoa.getIsNew());
					clientecoaLocal.setIsDeleted(clientecoa.getIsDeleted());
					
					clientecoaLocal.setGeneralEntityOriginal(clientecoa.getGeneralEntityOriginal());
					
					clientecoaLocal.setId(clientecoa.getId());	
					clientecoaLocal.setVersionRow(clientecoa.getVersionRow());	
					clientecoaLocal.setid_empresa(clientecoa.getid_empresa());	
					clientecoaLocal.setid_cliente(clientecoa.getid_cliente());	
					clientecoaLocal.setid_usuario(clientecoa.getid_usuario());	
					clientecoaLocal.setautori_imprenta(clientecoa.getautori_imprenta());	
					clientecoaLocal.setautori_usuario(clientecoa.getautori_usuario());	
					clientecoaLocal.setnum_factura_ini(clientecoa.getnum_factura_ini());	
					clientecoaLocal.setnum_factura_fin(clientecoa.getnum_factura_fin());	
					clientecoaLocal.setserie_docu(clientecoa.getserie_docu());	
					clientecoaLocal.setfecha_vali(clientecoa.getfecha_vali());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!clientecoa.getIsDeleted()) {
				if(!existe) {
					clientecoas.add(clientecoa);
				}
			} else {
				if(clientecoaEncontrado!=null && permiteQuitar)  {
					clientecoas.remove(clientecoaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClienteCoa clientecoa,List<ClienteCoa> clientecoas) throws Exception {
		try	{			
			for(ClienteCoa clientecoaLocal:clientecoas) {
				if(clientecoaLocal.getId().equals(clientecoa.getId())) {
					clientecoaLocal.setIsSelected(clientecoa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClienteCoa(List<ClienteCoa> clientecoasAux) throws Exception {
		//this.clientecoasAux=clientecoasAux;
		
		for(ClienteCoa clientecoaAux:clientecoasAux) {
			if(clientecoaAux.getIsChanged()) {
				clientecoaAux.setIsChanged(false);
			}		
			
			if(clientecoaAux.getIsNew()) {
				clientecoaAux.setIsNew(false);
			}	
			
			if(clientecoaAux.getIsDeleted()) {
				clientecoaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClienteCoa(ClienteCoa clientecoaAux) throws Exception {
		//this.clientecoaAux=clientecoaAux;
		
			if(clientecoaAux.getIsChanged()) {
				clientecoaAux.setIsChanged(false);
			}		
			
			if(clientecoaAux.getIsNew()) {
				clientecoaAux.setIsNew(false);
			}	
			
			if(clientecoaAux.getIsDeleted()) {
				clientecoaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClienteCoa clientecoaAsignar,ClienteCoa clientecoa) throws Exception {
		clientecoaAsignar.setId(clientecoa.getId());	
		clientecoaAsignar.setVersionRow(clientecoa.getVersionRow());	
		clientecoaAsignar.setid_empresa(clientecoa.getid_empresa());
		clientecoaAsignar.setempresa_descripcion(clientecoa.getempresa_descripcion());	
		clientecoaAsignar.setid_cliente(clientecoa.getid_cliente());
		clientecoaAsignar.setcliente_descripcion(clientecoa.getcliente_descripcion());	
		clientecoaAsignar.setid_usuario(clientecoa.getid_usuario());
		clientecoaAsignar.setusuario_descripcion(clientecoa.getusuario_descripcion());	
		clientecoaAsignar.setautori_imprenta(clientecoa.getautori_imprenta());	
		clientecoaAsignar.setautori_usuario(clientecoa.getautori_usuario());	
		clientecoaAsignar.setnum_factura_ini(clientecoa.getnum_factura_ini());	
		clientecoaAsignar.setnum_factura_fin(clientecoa.getnum_factura_fin());	
		clientecoaAsignar.setserie_docu(clientecoa.getserie_docu());	
		clientecoaAsignar.setfecha_vali(clientecoa.getfecha_vali());	
	}
	
	public static void inicializarClienteCoa(ClienteCoa clientecoa) throws Exception {
		try {
				clientecoa.setId(0L);	
					
				clientecoa.setid_empresa(-1L);	
				clientecoa.setid_cliente(-1L);	
				clientecoa.setid_usuario(-1L);	
				clientecoa.setautori_imprenta("");	
				clientecoa.setautori_usuario("");	
				clientecoa.setnum_factura_ini("");	
				clientecoa.setnum_factura_fin("");	
				clientecoa.setserie_docu("");	
				clientecoa.setfecha_vali(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClienteCoa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_AUTORIIMPRENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_AUTORIUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAINI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_NUMFACTURAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_SERIEDOCU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteCoaConstantesFunciones.LABEL_FECHAVALI);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClienteCoa(String sTipo,Row row,Workbook workbook,ClienteCoa clientecoa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getautori_imprenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getautori_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getnum_factura_ini());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getnum_factura_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getserie_docu());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientecoa.getfecha_vali());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClienteCoa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClienteCoa() {
		return this.sFinalQueryClienteCoa;
	}
	
	public void setsFinalQueryClienteCoa(String sFinalQueryClienteCoa) {
		this.sFinalQueryClienteCoa= sFinalQueryClienteCoa;
	}
	
	public Border resaltarSeleccionarClienteCoa=null;
	
	public Border setResaltarSeleccionarClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClienteCoa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClienteCoa() {
		return this.resaltarSeleccionarClienteCoa;
	}
	
	public void setResaltarSeleccionarClienteCoa(Border borderResaltarSeleccionarClienteCoa) {
		this.resaltarSeleccionarClienteCoa= borderResaltarSeleccionarClienteCoa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClienteCoa=null;
	public Boolean mostraridClienteCoa=true;
	public Boolean activaridClienteCoa=true;

	public Border resaltarid_empresaClienteCoa=null;
	public Boolean mostrarid_empresaClienteCoa=true;
	public Boolean activarid_empresaClienteCoa=true;
	public Boolean cargarid_empresaClienteCoa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaClienteCoa=false;//ConEventDepend=true

	public Border resaltarid_clienteClienteCoa=null;
	public Boolean mostrarid_clienteClienteCoa=true;
	public Boolean activarid_clienteClienteCoa=true;
	public Boolean cargarid_clienteClienteCoa=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteClienteCoa=false;//ConEventDepend=true

	public Border resaltarid_usuarioClienteCoa=null;
	public Boolean mostrarid_usuarioClienteCoa=true;
	public Boolean activarid_usuarioClienteCoa=true;
	public Boolean cargarid_usuarioClienteCoa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioClienteCoa=false;//ConEventDepend=true

	public Border resaltarautori_imprentaClienteCoa=null;
	public Boolean mostrarautori_imprentaClienteCoa=true;
	public Boolean activarautori_imprentaClienteCoa=true;

	public Border resaltarautori_usuarioClienteCoa=null;
	public Boolean mostrarautori_usuarioClienteCoa=true;
	public Boolean activarautori_usuarioClienteCoa=true;

	public Border resaltarnum_factura_iniClienteCoa=null;
	public Boolean mostrarnum_factura_iniClienteCoa=true;
	public Boolean activarnum_factura_iniClienteCoa=true;

	public Border resaltarnum_factura_finClienteCoa=null;
	public Boolean mostrarnum_factura_finClienteCoa=true;
	public Boolean activarnum_factura_finClienteCoa=true;

	public Border resaltarserie_docuClienteCoa=null;
	public Boolean mostrarserie_docuClienteCoa=true;
	public Boolean activarserie_docuClienteCoa=true;

	public Border resaltarfecha_valiClienteCoa=null;
	public Boolean mostrarfecha_valiClienteCoa=true;
	public Boolean activarfecha_valiClienteCoa=true;

	
	

	public Border setResaltaridClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltaridClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClienteCoa() {
		return this.resaltaridClienteCoa;
	}

	public void setResaltaridClienteCoa(Border borderResaltar) {
		this.resaltaridClienteCoa= borderResaltar;
	}

	public Boolean getMostraridClienteCoa() {
		return this.mostraridClienteCoa;
	}

	public void setMostraridClienteCoa(Boolean mostraridClienteCoa) {
		this.mostraridClienteCoa= mostraridClienteCoa;
	}

	public Boolean getActivaridClienteCoa() {
		return this.activaridClienteCoa;
	}

	public void setActivaridClienteCoa(Boolean activaridClienteCoa) {
		this.activaridClienteCoa= activaridClienteCoa;
	}

	public Border setResaltarid_empresaClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarid_empresaClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaClienteCoa() {
		return this.resaltarid_empresaClienteCoa;
	}

	public void setResaltarid_empresaClienteCoa(Border borderResaltar) {
		this.resaltarid_empresaClienteCoa= borderResaltar;
	}

	public Boolean getMostrarid_empresaClienteCoa() {
		return this.mostrarid_empresaClienteCoa;
	}

	public void setMostrarid_empresaClienteCoa(Boolean mostrarid_empresaClienteCoa) {
		this.mostrarid_empresaClienteCoa= mostrarid_empresaClienteCoa;
	}

	public Boolean getActivarid_empresaClienteCoa() {
		return this.activarid_empresaClienteCoa;
	}

	public void setActivarid_empresaClienteCoa(Boolean activarid_empresaClienteCoa) {
		this.activarid_empresaClienteCoa= activarid_empresaClienteCoa;
	}

	public Boolean getCargarid_empresaClienteCoa() {
		return this.cargarid_empresaClienteCoa;
	}

	public void setCargarid_empresaClienteCoa(Boolean cargarid_empresaClienteCoa) {
		this.cargarid_empresaClienteCoa= cargarid_empresaClienteCoa;
	}

	public Border setResaltarid_clienteClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarid_clienteClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteClienteCoa() {
		return this.resaltarid_clienteClienteCoa;
	}

	public void setResaltarid_clienteClienteCoa(Border borderResaltar) {
		this.resaltarid_clienteClienteCoa= borderResaltar;
	}

	public Boolean getMostrarid_clienteClienteCoa() {
		return this.mostrarid_clienteClienteCoa;
	}

	public void setMostrarid_clienteClienteCoa(Boolean mostrarid_clienteClienteCoa) {
		this.mostrarid_clienteClienteCoa= mostrarid_clienteClienteCoa;
	}

	public Boolean getActivarid_clienteClienteCoa() {
		return this.activarid_clienteClienteCoa;
	}

	public void setActivarid_clienteClienteCoa(Boolean activarid_clienteClienteCoa) {
		this.activarid_clienteClienteCoa= activarid_clienteClienteCoa;
	}

	public Boolean getCargarid_clienteClienteCoa() {
		return this.cargarid_clienteClienteCoa;
	}

	public void setCargarid_clienteClienteCoa(Boolean cargarid_clienteClienteCoa) {
		this.cargarid_clienteClienteCoa= cargarid_clienteClienteCoa;
	}

	public Border setResaltarid_usuarioClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarid_usuarioClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioClienteCoa() {
		return this.resaltarid_usuarioClienteCoa;
	}

	public void setResaltarid_usuarioClienteCoa(Border borderResaltar) {
		this.resaltarid_usuarioClienteCoa= borderResaltar;
	}

	public Boolean getMostrarid_usuarioClienteCoa() {
		return this.mostrarid_usuarioClienteCoa;
	}

	public void setMostrarid_usuarioClienteCoa(Boolean mostrarid_usuarioClienteCoa) {
		this.mostrarid_usuarioClienteCoa= mostrarid_usuarioClienteCoa;
	}

	public Boolean getActivarid_usuarioClienteCoa() {
		return this.activarid_usuarioClienteCoa;
	}

	public void setActivarid_usuarioClienteCoa(Boolean activarid_usuarioClienteCoa) {
		this.activarid_usuarioClienteCoa= activarid_usuarioClienteCoa;
	}

	public Boolean getCargarid_usuarioClienteCoa() {
		return this.cargarid_usuarioClienteCoa;
	}

	public void setCargarid_usuarioClienteCoa(Boolean cargarid_usuarioClienteCoa) {
		this.cargarid_usuarioClienteCoa= cargarid_usuarioClienteCoa;
	}

	public Border setResaltarautori_imprentaClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarautori_imprentaClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautori_imprentaClienteCoa() {
		return this.resaltarautori_imprentaClienteCoa;
	}

	public void setResaltarautori_imprentaClienteCoa(Border borderResaltar) {
		this.resaltarautori_imprentaClienteCoa= borderResaltar;
	}

	public Boolean getMostrarautori_imprentaClienteCoa() {
		return this.mostrarautori_imprentaClienteCoa;
	}

	public void setMostrarautori_imprentaClienteCoa(Boolean mostrarautori_imprentaClienteCoa) {
		this.mostrarautori_imprentaClienteCoa= mostrarautori_imprentaClienteCoa;
	}

	public Boolean getActivarautori_imprentaClienteCoa() {
		return this.activarautori_imprentaClienteCoa;
	}

	public void setActivarautori_imprentaClienteCoa(Boolean activarautori_imprentaClienteCoa) {
		this.activarautori_imprentaClienteCoa= activarautori_imprentaClienteCoa;
	}

	public Border setResaltarautori_usuarioClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarautori_usuarioClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautori_usuarioClienteCoa() {
		return this.resaltarautori_usuarioClienteCoa;
	}

	public void setResaltarautori_usuarioClienteCoa(Border borderResaltar) {
		this.resaltarautori_usuarioClienteCoa= borderResaltar;
	}

	public Boolean getMostrarautori_usuarioClienteCoa() {
		return this.mostrarautori_usuarioClienteCoa;
	}

	public void setMostrarautori_usuarioClienteCoa(Boolean mostrarautori_usuarioClienteCoa) {
		this.mostrarautori_usuarioClienteCoa= mostrarautori_usuarioClienteCoa;
	}

	public Boolean getActivarautori_usuarioClienteCoa() {
		return this.activarautori_usuarioClienteCoa;
	}

	public void setActivarautori_usuarioClienteCoa(Boolean activarautori_usuarioClienteCoa) {
		this.activarautori_usuarioClienteCoa= activarautori_usuarioClienteCoa;
	}

	public Border setResaltarnum_factura_iniClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarnum_factura_iniClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnum_factura_iniClienteCoa() {
		return this.resaltarnum_factura_iniClienteCoa;
	}

	public void setResaltarnum_factura_iniClienteCoa(Border borderResaltar) {
		this.resaltarnum_factura_iniClienteCoa= borderResaltar;
	}

	public Boolean getMostrarnum_factura_iniClienteCoa() {
		return this.mostrarnum_factura_iniClienteCoa;
	}

	public void setMostrarnum_factura_iniClienteCoa(Boolean mostrarnum_factura_iniClienteCoa) {
		this.mostrarnum_factura_iniClienteCoa= mostrarnum_factura_iniClienteCoa;
	}

	public Boolean getActivarnum_factura_iniClienteCoa() {
		return this.activarnum_factura_iniClienteCoa;
	}

	public void setActivarnum_factura_iniClienteCoa(Boolean activarnum_factura_iniClienteCoa) {
		this.activarnum_factura_iniClienteCoa= activarnum_factura_iniClienteCoa;
	}

	public Border setResaltarnum_factura_finClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarnum_factura_finClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnum_factura_finClienteCoa() {
		return this.resaltarnum_factura_finClienteCoa;
	}

	public void setResaltarnum_factura_finClienteCoa(Border borderResaltar) {
		this.resaltarnum_factura_finClienteCoa= borderResaltar;
	}

	public Boolean getMostrarnum_factura_finClienteCoa() {
		return this.mostrarnum_factura_finClienteCoa;
	}

	public void setMostrarnum_factura_finClienteCoa(Boolean mostrarnum_factura_finClienteCoa) {
		this.mostrarnum_factura_finClienteCoa= mostrarnum_factura_finClienteCoa;
	}

	public Boolean getActivarnum_factura_finClienteCoa() {
		return this.activarnum_factura_finClienteCoa;
	}

	public void setActivarnum_factura_finClienteCoa(Boolean activarnum_factura_finClienteCoa) {
		this.activarnum_factura_finClienteCoa= activarnum_factura_finClienteCoa;
	}

	public Border setResaltarserie_docuClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarserie_docuClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserie_docuClienteCoa() {
		return this.resaltarserie_docuClienteCoa;
	}

	public void setResaltarserie_docuClienteCoa(Border borderResaltar) {
		this.resaltarserie_docuClienteCoa= borderResaltar;
	}

	public Boolean getMostrarserie_docuClienteCoa() {
		return this.mostrarserie_docuClienteCoa;
	}

	public void setMostrarserie_docuClienteCoa(Boolean mostrarserie_docuClienteCoa) {
		this.mostrarserie_docuClienteCoa= mostrarserie_docuClienteCoa;
	}

	public Boolean getActivarserie_docuClienteCoa() {
		return this.activarserie_docuClienteCoa;
	}

	public void setActivarserie_docuClienteCoa(Boolean activarserie_docuClienteCoa) {
		this.activarserie_docuClienteCoa= activarserie_docuClienteCoa;
	}

	public Border setResaltarfecha_valiClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientecoaBeanSwingJInternalFrame.jTtoolBarClienteCoa.setBorder(borderResaltar);
		
		this.resaltarfecha_valiClienteCoa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_valiClienteCoa() {
		return this.resaltarfecha_valiClienteCoa;
	}

	public void setResaltarfecha_valiClienteCoa(Border borderResaltar) {
		this.resaltarfecha_valiClienteCoa= borderResaltar;
	}

	public Boolean getMostrarfecha_valiClienteCoa() {
		return this.mostrarfecha_valiClienteCoa;
	}

	public void setMostrarfecha_valiClienteCoa(Boolean mostrarfecha_valiClienteCoa) {
		this.mostrarfecha_valiClienteCoa= mostrarfecha_valiClienteCoa;
	}

	public Boolean getActivarfecha_valiClienteCoa() {
		return this.activarfecha_valiClienteCoa;
	}

	public void setActivarfecha_valiClienteCoa(Boolean activarfecha_valiClienteCoa) {
		this.activarfecha_valiClienteCoa= activarfecha_valiClienteCoa;
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
		
		
		this.setMostraridClienteCoa(esInicial);
		this.setMostrarid_empresaClienteCoa(esInicial);
		this.setMostrarid_clienteClienteCoa(esInicial);
		this.setMostrarid_usuarioClienteCoa(esInicial);
		this.setMostrarautori_imprentaClienteCoa(esInicial);
		this.setMostrarautori_usuarioClienteCoa(esInicial);
		this.setMostrarnum_factura_iniClienteCoa(esInicial);
		this.setMostrarnum_factura_finClienteCoa(esInicial);
		this.setMostrarserie_docuClienteCoa(esInicial);
		this.setMostrarfecha_valiClienteCoa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteCoaConstantesFunciones.ID)) {
				this.setMostraridClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIIMPRENTA)) {
				this.setMostrarautori_imprentaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIUSUARIO)) {
				this.setMostrarautori_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAINI)) {
				this.setMostrarnum_factura_iniClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAFIN)) {
				this.setMostrarnum_factura_finClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.SERIEDOCU)) {
				this.setMostrarserie_docuClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.FECHAVALI)) {
				this.setMostrarfecha_valiClienteCoa(esAsigna);
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
		
		
		this.setActivaridClienteCoa(esInicial);
		this.setActivarid_empresaClienteCoa(esInicial);
		this.setActivarid_clienteClienteCoa(esInicial);
		this.setActivarid_usuarioClienteCoa(esInicial);
		this.setActivarautori_imprentaClienteCoa(esInicial);
		this.setActivarautori_usuarioClienteCoa(esInicial);
		this.setActivarnum_factura_iniClienteCoa(esInicial);
		this.setActivarnum_factura_finClienteCoa(esInicial);
		this.setActivarserie_docuClienteCoa(esInicial);
		this.setActivarfecha_valiClienteCoa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteCoaConstantesFunciones.ID)) {
				this.setActivaridClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIIMPRENTA)) {
				this.setActivarautori_imprentaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIUSUARIO)) {
				this.setActivarautori_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAINI)) {
				this.setActivarnum_factura_iniClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAFIN)) {
				this.setActivarnum_factura_finClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.SERIEDOCU)) {
				this.setActivarserie_docuClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.FECHAVALI)) {
				this.setActivarfecha_valiClienteCoa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClienteCoa(esInicial);
		this.setResaltarid_empresaClienteCoa(esInicial);
		this.setResaltarid_clienteClienteCoa(esInicial);
		this.setResaltarid_usuarioClienteCoa(esInicial);
		this.setResaltarautori_imprentaClienteCoa(esInicial);
		this.setResaltarautori_usuarioClienteCoa(esInicial);
		this.setResaltarnum_factura_iniClienteCoa(esInicial);
		this.setResaltarnum_factura_finClienteCoa(esInicial);
		this.setResaltarserie_docuClienteCoa(esInicial);
		this.setResaltarfecha_valiClienteCoa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteCoaConstantesFunciones.ID)) {
				this.setResaltaridClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIIMPRENTA)) {
				this.setResaltarautori_imprentaClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.AUTORIUSUARIO)) {
				this.setResaltarautori_usuarioClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAINI)) {
				this.setResaltarnum_factura_iniClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.NUMFACTURAFIN)) {
				this.setResaltarnum_factura_finClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.SERIEDOCU)) {
				this.setResaltarserie_docuClienteCoa(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteCoaConstantesFunciones.FECHAVALI)) {
				this.setResaltarfecha_valiClienteCoa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteClienteCoa=true;

	public Boolean getMostrarFK_IdClienteClienteCoa() {
		return this.mostrarFK_IdClienteClienteCoa;
	}

	public void setMostrarFK_IdClienteClienteCoa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteClienteCoa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaClienteCoa=true;

	public Boolean getMostrarFK_IdEmpresaClienteCoa() {
		return this.mostrarFK_IdEmpresaClienteCoa;
	}

	public void setMostrarFK_IdEmpresaClienteCoa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaClienteCoa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioClienteCoa=true;

	public Boolean getMostrarFK_IdUsuarioClienteCoa() {
		return this.mostrarFK_IdUsuarioClienteCoa;
	}

	public void setMostrarFK_IdUsuarioClienteCoa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioClienteCoa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteClienteCoa=true;

	public Boolean getActivarFK_IdClienteClienteCoa() {
		return this.activarFK_IdClienteClienteCoa;
	}

	public void setActivarFK_IdClienteClienteCoa(Boolean habilitarResaltar) {
		this.activarFK_IdClienteClienteCoa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaClienteCoa=true;

	public Boolean getActivarFK_IdEmpresaClienteCoa() {
		return this.activarFK_IdEmpresaClienteCoa;
	}

	public void setActivarFK_IdEmpresaClienteCoa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaClienteCoa= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioClienteCoa=true;

	public Boolean getActivarFK_IdUsuarioClienteCoa() {
		return this.activarFK_IdUsuarioClienteCoa;
	}

	public void setActivarFK_IdUsuarioClienteCoa(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioClienteCoa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteClienteCoa=null;

	public Border getResaltarFK_IdClienteClienteCoa() {
		return this.resaltarFK_IdClienteClienteCoa;
	}

	public void setResaltarFK_IdClienteClienteCoa(Border borderResaltar) {
		this.resaltarFK_IdClienteClienteCoa= borderResaltar;
	}

	public void setResaltarFK_IdClienteClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteClienteCoa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaClienteCoa=null;

	public Border getResaltarFK_IdEmpresaClienteCoa() {
		return this.resaltarFK_IdEmpresaClienteCoa;
	}

	public void setResaltarFK_IdEmpresaClienteCoa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaClienteCoa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaClienteCoa= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioClienteCoa=null;

	public Border getResaltarFK_IdUsuarioClienteCoa() {
		return this.resaltarFK_IdUsuarioClienteCoa;
	}

	public void setResaltarFK_IdUsuarioClienteCoa(Border borderResaltar) {
		this.resaltarFK_IdUsuarioClienteCoa= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioClienteCoa(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteCoaBeanSwingJInternalFrame clientecoaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioClienteCoa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}